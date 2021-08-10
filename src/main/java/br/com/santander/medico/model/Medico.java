package br.com.santander.medico.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.santander.model.Agenda;
import br.com.santander.model.Endereco;
import br.com.santander.model.Telefone;
import br.com.santander.model.Usuario;

@Entity
public class Medico extends Usuario {

	private String crm;
	@ManyToOne
	private Especialidade especialidade;

	@OneToMany(mappedBy = "medico")
	private List<Agenda> agendas = new ArrayList<>();

	public Medico(String nome, String crm, String email, Telefone telefone, Endereco endereco) {
		super(nome, email, telefone, endereco);
		this.crm = crm;
	}

	protected Medico() {
	};

	public String getCrm() {
		return crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
}
