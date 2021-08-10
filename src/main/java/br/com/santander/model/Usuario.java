package br.com.santander.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@Embedded
	private Contato contato;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	public Usuario(String nome, String email, Telefone telefone,Endereco endereco) {
		this.nome = nome;
		this.contato = new Contato(email, telefone);
		this.endereco = endereco;
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
	
	public Endereco getEndereco() {
		return endereco;
	}


}
