package br.com.santander.paciente.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.santander.paciente.model.Paciente;
import br.com.santander.paciente.repository.PacienteRepository;

@Service
public class PacienteService {

	private final PacienteRepository pacienteRepository;

	@Autowired
	public PacienteService(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

	public Paciente salva(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	public List<Paciente> buscaTodos() {
		return pacienteRepository.findAll();
	}

	public Paciente buscaPorId(Integer pacienteId) {
		return pacienteRepository.findById(pacienteId).orElseThrow(()->new EntityNotFoundException("Paciente não encontrado"));
	}

}
