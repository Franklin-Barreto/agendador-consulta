package br.com.santander.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.santander.medico.model.Medico;
import br.com.santander.medico.model.dto.LiberarHorariosDto;
import br.com.santander.medico.service.MedicoService;
import br.com.santander.model.Agenda;
import br.com.santander.paciente.model.Paciente;
import br.com.santander.paciente.service.PacienteService;
import br.com.santander.repository.AgendaRepository;

@Service
public class AgendaService {

	private final AgendaRepository agendaRepository;
	private final MedicoService medicoService;
	private final PacienteService pacienteService;

	public AgendaService(AgendaRepository agendaRepository, MedicoService medicoService, PacienteService pacienteService) {
		this.agendaRepository = agendaRepository;
		this.medicoService = medicoService;
		this.pacienteService = pacienteService;
	}

	public List<Agenda> diasDoMes(Integer medico, Integer mes) {
		return agendaRepository.buscarDiasDisponiveis(medico, LocalDate.now().getYear(), mes);
	}

	public List<Agenda> liberarHorarios(LiberarHorariosDto agenda) {
		Medico medico = medicoService.buscarPorId(agenda.getMedicoId());
		List<Agenda> horarios = agenda.getHorarios().stream().map(h -> new Agenda(h, medico, null))
				.collect(Collectors.toList());
		return agendaRepository.saveAll(horarios);
	}

	public List<Agenda> buscaConsultasPaciente(Integer id) {
		
		return agendaRepository.findAllByPacienteId(id);
	}

	public List<Agenda> buscaHorarioDisponiveis(Integer id) {
		return agendaRepository.findAllByMedicoIdAndDisponivelIsTrue(id);
	}

	@Transactional
	public Agenda marcaConsulta(Integer id, Integer pacienteId) {
		Agenda agenda = buscaPorId(id);
		Paciente paciente = pacienteService.buscaPorId(pacienteId);
		agenda.setPaciente(paciente);
		return agenda;
	}
	
	public Agenda buscaPorId(Integer id) {
		return agendaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Data não encontrada"));
	}

	public List<Agenda> buscaConsultasMedico(Integer id) {
		return agendaRepository.findAllByMedicoIdAndDisponivelIsFalse(id);
	}

}
