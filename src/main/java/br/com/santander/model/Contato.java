package br.com.santander.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class Contato {

	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private Telefone telefone;

	public Contato(String email, Telefone telefone) {
		this.email = email;
		this.telefone = telefone;
	}
	
	protected Contato() {}

	public String getEmail() {
		return email;
	}

	public Telefone getTelefone() {
		return telefone;
	}

}
