package br.com.santander.medico.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.santander.medico.model.Especialidade;

@Service
public class EspecialidadeService {

	private final EspecialidadeRepository especialidadeRepository;

	public EspecialidadeService(EspecialidadeRepository especialidadeRepository) {
		this.especialidadeRepository = especialidadeRepository;
	}

	public Especialidade buscarPorId(Integer especialidadeId) {

		return especialidadeRepository.findById(especialidadeId).orElseThrow(
				() -> new EntityNotFoundException("Especialidade com id" + especialidadeId + " não encontrada"));
	}

}
