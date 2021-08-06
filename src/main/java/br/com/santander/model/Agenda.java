package br.com.santander.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.santander.medico.model.Medico;
import br.com.santander.paciente.model.Paciente;

@Entity
public class Agenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime dataConsulta;
	@ManyToOne
	private Medico medico;
	private boolean disponivel = true;

	@ManyToOne
	private Paciente paciente;

	public Agenda(LocalDateTime dataConsulta, Medico medico, Paciente paciente) {
		this.dataConsulta = dataConsulta;
		this.medico = medico;
		this.paciente = paciente;
	}

	public Agenda() {
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getDataConsulta() {
		return dataConsulta;
	}

	public Medico getMedico() {
		return medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
		disponivel = false;
	}

}
