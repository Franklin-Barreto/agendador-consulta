package br.com.santander.medico.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Especialidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@OneToMany(mappedBy = "especialidade")
	private Set<Medico> medicos = new HashSet<>();

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
