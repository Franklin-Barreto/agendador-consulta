package br.com.santander.medico.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LiberarHorariosDto {

	private Integer medicoId;
	private List<LocalDateTime> horarios = new ArrayList<>();

	public LiberarHorariosDto(Integer medicoId, List<LocalDateTime> horarios) {
		this.medicoId = medicoId;
		this.horarios = horarios;
	}

	public Integer getMedicoId() {
		return medicoId;
	}

	public List<LocalDateTime> getHorarios() {
		return horarios;
	}

	@Override
	public String toString() {
		return "LiberarHorariosDto [id=" + medicoId + ", horarios=" + horarios + "]";
	}

}
