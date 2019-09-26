package br.com.swconsultoria.cte;

import br.com.swconsultoria.cte.dom.ConfiguracoesCte;
import br.com.swconsultoria.cte.dom.enuns.AssinaturaEnum;
import br.com.swconsultoria.cte.dom.enuns.ServicosEnum;
import br.com.swconsultoria.cte.exception.CteException;
import br.com.swconsultoria.cte.schema_300.inutCTe.TInutCTe;
import br.com.swconsultoria.cte.schema_300.inutCTe.TRetInutCTe;
import br.com.swconsultoria.cte.util.*;
import br.com.swconsultoria.cte.wsdl.cteinutilizacao.CteInutilizacaoStub;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.transport.http.HTTPConstants;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.rmi.RemoteException;

/**
 * Classe Responsavel por inutilizar uma Faixa de numeracao da Cte.
 *
 * @author Samuel Oliveira - samuel@swconsultoria.com.br - www.swconsultoria.com.br
 */
class Inutilizar {

    static TRetInutCTe inutiliza(ConfiguracoesCte config, TInutCTe inutCTe, boolean validar)
            throws CteException {

        try {

            String xml = XmlCteUtil.objectToXml(inutCTe);
            xml = xml.replaceAll(" xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", "");
            xml = Assinar.assinaCte(config, xml, AssinaturaEnum.INUTILIZACAO);

            LoggerUtil.log(Inutilizar.class, "[XML-ENVIO]: " + xml);

            if (validar) {
                new Validar().validaXml(config, xml, ServicosEnum.INUTILIZACAO);
            }

            OMElement ome = AXIOMUtil.stringToOM(xml);

            CteInutilizacaoStub.CteDadosMsg dadosMsg = new CteInutilizacaoStub.CteDadosMsg();
            dadosMsg.setExtraElement(ome);

            CteInutilizacaoStub stub = new CteInutilizacaoStub(
                    WebServiceCteUtil.getUrl(config, ServicosEnum.INUTILIZACAO));

            CteInutilizacaoStub.CteCabecMsg cteCabecMsg = new CteInutilizacaoStub.CteCabecMsg();
            cteCabecMsg.setCUF(String.valueOf(config.getEstado().getCodigoUF()));
            cteCabecMsg.setVersaoDados(ConstantesCte.VERSAO.CTE);

            CteInutilizacaoStub.CteCabecMsgE cteCabecMsgE = new CteInutilizacaoStub.CteCabecMsgE();
            cteCabecMsgE.setCteCabecMsg(cteCabecMsg);

            // Timeout
            if (ObjetoCTeUtil.verifica(config.getTimeout()).isPresent()) {
                stub._getServiceClient().getOptions().setProperty(HTTPConstants.SO_TIMEOUT, config.getTimeout());
                stub._getServiceClient().getOptions().setProperty(HTTPConstants.CONNECTION_TIMEOUT, config.getTimeout());
            }
            CteInutilizacaoStub.CteInutilizacaoCTResult result = stub.cteInutilizacaoCT(dadosMsg, cteCabecMsgE);

            LoggerUtil.log(Inutilizar.class, "[XML-RETORNO]: " + result.getExtraElement().toString());
            return XmlCteUtil.xmlToObject(result.getExtraElement().toString(), TRetInutCTe.class);
        } catch (RemoteException | XMLStreamException | JAXBException e) {
            throw new CteException(e.getMessage());
        }

    }

}