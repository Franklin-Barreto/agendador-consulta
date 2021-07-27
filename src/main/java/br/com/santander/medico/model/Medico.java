package br.com.santander.medico.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.santander.model.Agenda;
import br.com.santander.model.Telefone;
import br.com.santander.model.Usuario;

@Entity
public class Medico extends Usuario {

	private String crm;
	@OneToOne(cascade = CascadeType.ALL)
	private Especialidade especialidade;
	
	@OneToMany
	private List<Agenda> agendas = new ArrayList<>();

	public Medico(String nome, String crm, String email, Telefone telefone) {
		super(nome, email, telefone);
		this.crm = crm;
	}
	
	protected Medico() {};

	public String getCrm() {
		return crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}
}
