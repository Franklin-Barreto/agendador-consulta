package br.com.santander.medico.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.medico.model.Medico;
import br.com.santander.medico.model.dto.MedicoInputDto;
import br.com.santander.medico.service.MedicoService;

@RestController
@RequestMapping("medicos")
public class MedicoController {

	private MedicoService medicoService;

	public MedicoController(MedicoService medicoService) {
		this.medicoService = medicoService;
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody MedicoInputDto medicoDto) {
		System.out.println(medicoDto);
		Medico medico = medicoService.salvar(medicoDto);
		return ResponseEntity.ok(medico);

	}

}
