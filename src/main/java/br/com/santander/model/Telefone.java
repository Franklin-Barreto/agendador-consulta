package br.com.santander.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int ddd;
	private String numero;

	public Telefone(int ddd, String numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
	
	protected Telefone() {}

	public Integer getId() {
		return id;
	}

	public int getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

}
