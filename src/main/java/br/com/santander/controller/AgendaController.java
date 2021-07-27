package br.com.santander.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.service.AgendaService;

@RestController
@RequestMapping("agenda/")
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
}
