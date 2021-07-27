package br.com.santander.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.santander.repository.AgendaRepository;

@Service
public class AgendaService {

	private AgendaRepository agendaRepository;

	public AgendaService(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
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

	public List<Integer> diasDoMes(Integer medico, Integer mes) {
		List<Integer> diasCheios = agendaRepository.buscarDiasDisponiveis(medico, LocalDate.now().getYear(), mes);
		LocalDate mesMedico = LocalDate.of(LocalDate.now().getMonthValue(), Month.of(mes), 1);
		List<Integer> dias = new ArrayList<>();
		for (int i = 1; i <= mesMedico.lengthOfMonth(); i++) {
			dias.add(i);
		}
		dias.removeAll(diasCheios);
		return dias;
	}

}
