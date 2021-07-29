package br.com.santander.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.santander.medico.model.Medico;
import br.com.santander.medico.model.dto.LiberarHorariosDto;
import br.com.santander.medico.service.MedicoService;
import br.com.santander.model.Agenda;
import br.com.santander.repository.AgendaRepository;

@Service
public class AgendaService {

	private final AgendaRepository agendaRepository;
	private final MedicoService medicoService;

	public AgendaService(AgendaRepository agendaRepository, MedicoService medicoService) {
		this.agendaRepository = agendaRepository;
		this.medicoService = medicoService;
	}

	public List<LocalDateTime> obterHorarioLivre(Integer id, Integer mes, Integer dia) {
		LocalDate data = LocalDate.of(2021, Month.of(mes), dia);
		List<LocalDateTime> horariosVagos = new ArrayList<>();
		List<LocalDateTime> horariosOcupados = agendaRepository
				.findAllByMedicoIdAndDataConsultaAfter(id, LocalDateTime.of(data, LocalTime.of(7, 59))).stream()
				.map(h -> h.getDataConsulta()).collect(Collectors.toList());
		LocalTime horaInicio = LocalTime.of(8, 0);
		LocalTime horaFim = LocalTime.of(18, 0);

		for (LocalTime i = horaInicio; i.isBefore(horaFim); i = i.plusMinutes(30)) {
			horariosVagos.add(LocalDateTime.of(data, i));
		}
		horariosVagos.removeAll(horariosOcupados);
		return horariosVagos;
	}

	public List<LocalDateTime> horariosPorDia(Integer medico, Integer mes, Integer dia) {
		int ano = LocalDate.now().getYear();
		LocalDate data = LocalDate.of(ano, Month.of(mes), dia);
		agendaRepository.buscarDiasDisponiveis(1, data.getYear(), data.getMonthValue());
		return null;
	}

	public List<Agenda> diasDoMes(Integer medico, Integer mes) {
		return agendaRepository.buscarDiasDisponiveis(medico, LocalDate.now().getYear(), mes);
	}

	public List<Agenda> liberarHorarios(LiberarHorariosDto agenda) {
		Medico medico = medicoService.buscarPorId(agenda.getMedicoId());
		Set<Agenda> horarios = agenda.getHorarios().stream().map(h -> new Agenda(h, medico, null))
				.collect(Collectors.toSet());
		return agendaRepository.saveAll(horarios);
	}

}
