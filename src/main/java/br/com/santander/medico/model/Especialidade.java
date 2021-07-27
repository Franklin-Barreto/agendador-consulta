package br.com.santander.medico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Especialidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	public Especialidade(String nome) {
		this.nome = nome;
	}
	
	protected Especialidade() {}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
