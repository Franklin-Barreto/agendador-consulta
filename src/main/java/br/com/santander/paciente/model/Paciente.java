package br.com.santander.paciente.model;

import javax.persistence.Entity;

import br.com.santander.model.Endereco;
import br.com.santander.model.Telefone;
import br.com.santander.model.Usuario;

@Entity
public class Paciente extends Usuario {

	public Paciente(String nome, String cpf, String email, Telefone telefone,Endereco endereco) {
		super(nome, email, telefone,endereco);
		this.cpf = cpf;
	}

	protected Paciente() {
	}

	private String cpf;

	public String getCpf() {
		return cpf;
	}

}
