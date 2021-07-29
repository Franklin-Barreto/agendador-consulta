package br.com.santander.medico.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.santander.medico.model.Especialidade;
import br.com.santander.medico.model.Medico;
import br.com.santander.medico.model.dto.MedicoInputDto;
import br.com.santander.medico.repository.MedicoRepository;

@Service
public class MedicoService {

	private final MedicoRepository medicoRepository;
	private final EspecialidadeService especialidadeService;

	public MedicoService(MedicoRepository medicoRepository, EspecialidadeService especialidadeService) {
		this.medicoRepository = medicoRepository;
		this.especialidadeService = especialidadeService;
	}

	public Medico salvar(MedicoInputDto medicoDto) {
		Medico medico = medicoDto.getMedico();
		Especialidade especialidade = especialidadeService.buscarPorId(medicoDto.getEspecialidadeId());
		medico.setEspecialidade(especialidade);
		return medicoRepository.save(medicoDto.getMedico());
	}

	public Medico buscarPorId(Integer medicoId) {
		return medicoRepository.findById(medicoId)
				.orElseThrow(() -> new EntityNotFoundException("Médico com id " + medicoId + " não encontrado"));
	}

}
