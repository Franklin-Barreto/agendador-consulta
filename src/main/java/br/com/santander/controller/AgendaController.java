package br.com.santander.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.medico.model.dto.LiberarHorariosDto;
import br.com.santander.model.Agenda;
import br.com.santander.service.AgendaService;

@RestController
@RequestMapping("agenda")
public class AgendaController {

	private AgendaService agendaService;

	public AgendaController(AgendaService agendaService) {
		this.agendaService = agendaService;
	}

	@GetMapping("medico/{id}/mes/{mes}")
	public ResponseEntity<?> obterAgendaMedico(@PathVariable(name = "id") Integer medico, @PathVariable Integer mes) {

		return ResponseEntity.ok().body(agendaService.diasDoMes(medico, mes));
	}

	@GetMapping("medico/{id}/mes/{mes}/dia/{dia}")
	public ResponseEntity<?> obterHorarioLivreDia(@PathVariable(name = "id") Integer medico, @PathVariable Integer mes,
			@PathVariable Integer dia) {

		return ResponseEntity.ok().body(agendaService.obterHorarioLivre(medico, mes, dia));
	}
	
	@PostMapping("/medico")
	public ResponseEntity<?> liberarHorarios(@RequestBody LiberarHorariosDto agenda){
		agendaService.liberarHorarios(agenda);
		return null;
	}
	
	@GetMapping("/paciente/{id}/consultas")
	public ResponseEntity<?> consultasPaciente(@PathVariable Integer id){
		List<Agenda> consultas =agendaService.buscaConsultasPaciente(id);
		return ResponseEntity.ok(consultas);
	}
}
