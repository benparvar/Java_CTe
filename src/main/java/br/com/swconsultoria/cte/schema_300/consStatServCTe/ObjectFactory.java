
package br.com.swconsultoria.cte.schema_300.consStatServCTe;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.swconsultoria.cte.schema_300.consStatServCTe package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsStatServCte_QNAME = new QName("http://www.portalfiscal.inf.br/cte", "consStatServCte");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.swconsultoria.cte.schema_300.consStatServCTe
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TConsStatServ }
     * 
     */
    public TConsStatServ createTConsStatServ() {
        return new TConsStatServ();
    }

    /**
     * Create an instance of {@link TRetConsStatServ }
     * 
     */
    public TRetConsStatServ createTRetConsStatServ() {
        return new TRetConsStatServ();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TConsStatServ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/cte", name = "consStatServCte")
    public JAXBElement<TConsStatServ> createConsStatServCte(TConsStatServ value) {
        return new JAXBElement<TConsStatServ>(_ConsStatServCte_QNAME, TConsStatServ.class, null, value);
    }

}
