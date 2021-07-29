package br.com.santander.model.dto;

public class EnderecoDtoInput {

	private String rua;
	private String numero;
	private String cidade;

	public EnderecoDtoInput(String rua, String numero, String cidade) {
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

}
