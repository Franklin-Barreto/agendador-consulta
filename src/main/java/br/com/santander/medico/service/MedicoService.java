package br.com.santander.medico.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.santander.medico.model.Especialidade;
import br.com.santander.medico.model.Medico;
import br.com.santander.medico.model.dto.MedicoFiltroDto;
import br.com.santander.medico.model.dto.MedicoInputDto;
import br.com.santander.medico.repository.MedicoRepository;
import br.com.santander.medico.repository.specification.MedicoSpecification;

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


	public List<Medico> buscarConsultas(Integer id) {
		return medicoRepository.buscarAgendaPorMedicoId(id);
	}

	@Cacheable(value = "Medicos")
	public List<Medico> buscaTodosComParamentro(MedicoFiltroDto filtro) {
		return medicoRepository.findAll(Specification
				.where(
						MedicoSpecification.porNome(filtro.getNome())
						.or(MedicoSpecification.porCrm(filtro.getCrm())
						.or(MedicoSpecification.porNumero(filtro.getNumero()))
					)));
	}

}
