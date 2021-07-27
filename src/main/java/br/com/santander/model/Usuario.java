package br.com.santander.model;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@Embedded
	private Contato contato;

	public Usuario(String nome, String email, Telefone telefone) {
		this.nome = nome;
		this.contato = new Contato(email, telefone);
	}

	protected Usuario() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return contato.getEmail();
	}

	public String getTelefone() {
		return contato.getTelefone().getDdd() + " " + contato.getTelefone().getNumero();
	}


}
