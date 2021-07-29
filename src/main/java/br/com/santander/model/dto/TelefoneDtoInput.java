package br.com.santander.model.dto;

public class TelefoneDtoInput {

	private int ddd;
	private String numero;
	
	public TelefoneDtoInput(int ddd, String numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public int getDdd() {
		return ddd;
	}
	
	public String getNumero() {
		return numero;
	}
}
