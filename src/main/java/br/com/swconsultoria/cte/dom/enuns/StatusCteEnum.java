/**
 * 
 */
package br.com.swconsultoria.cte.dom.enuns;

/**
 * @author Samuel Oliveira
 *
 */
/**
 * enuns que contém os status da Cte
 * @author Samuel Oliveira
 *
 */
public enum StatusCteEnum {

	AUTORIZADO("100"),
	CANCELADO("101"),
	INUTILIZADO("102"),
	LOTE_RECEBIDO("103"),
	LOTE_PROCESSADO("104"),
	LOTE_EM_PROCESSAMENTO("105"),
    SERVICO_EM_OPERACAO("107"),
    USO_DENEGADO("110"),
	CADASTRO_ENCONTRADO("111"),
	LOTE_EVENTO_PROCESSADO("128"),
	EVENTO_VINCULADO("135"),
    EVENTO_REGISTRADO_NAO_VINCULADO("136"),
	NENHUM_DOC_LOCALIZADO_PARA_DESTINATARIO("137"),
	DOC_LOCALIZADO_PARA_DESTINATARIO("138"),
    CONSUMO_INDEVIDO("656"),
	AUTORIZADO_FORA_PRAZO("150"),
	CANCELADO_FORA_PRAZO("151"),
	CANCELAMENTO_FORA_PRAZO("155"),
	FALHA_MODAL("580"),
	DUPLICIDADE("204");

	private final String codigo;

	StatusCteEnum(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo(){
		return codigo;
	}
}
