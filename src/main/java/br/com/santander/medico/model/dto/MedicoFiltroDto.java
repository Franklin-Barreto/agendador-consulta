package br.com.santander.medico.model.dto;

public class MedicoFiltroDto {

	private String nome;
	private String crm;
	private String numero;

	public MedicoFiltroDto(String nome, String crm, String numero) {
		this.nome = nome;
		this.crm = crm;
		this.numero = numero;
	}

	public String getCrm() {
		return crm;
	}

	public String getNome() {
		return nome;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "MedicoFiltroDto [nome=" + nome + ", crm=" + crm + ", numero=" + numero + "]";
	}
	
	

}
