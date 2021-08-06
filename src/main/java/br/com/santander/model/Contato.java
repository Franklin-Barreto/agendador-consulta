package br.com.santander.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class Contato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
