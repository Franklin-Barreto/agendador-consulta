package br.com.santander.paciente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.paciente.model.Paciente;
import br.com.santander.paciente.model.dto.PacienteInputDto;
import br.com.santander.paciente.service.PacienteService;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

	private final PacienteService pacienteService;

	@Autowired
	public PacienteController(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}
	
	@PostMapping
	public ResponseEntity<?> salva(@RequestBody PacienteInputDto pacienteDto){
		pacienteService.salva(pacienteDto.getPaciente());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Paciente> buscaTodos(){
		return pacienteService.buscaTodos();
	}
}
