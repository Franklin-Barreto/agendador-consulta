package br.com.santander.paciente.model.dto;

import br.com.santander.model.Endereco;
import br.com.santander.model.Telefone;
import br.com.santander.model.dto.EnderecoDtoInput;
import br.com.santander.model.dto.TelefoneDtoInput;
import br.com.santander.paciente.model.Paciente;

public class PacienteInputDto {

	private String nome;
	private String email;
	private String cpf;
	private TelefoneDtoInput telefone;
	private EnderecoDtoInput endereco;

	public PacienteInputDto(String nome, String cpf, String email, TelefoneDtoInput telefone,
			EnderecoDtoInput endereco) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public TelefoneDtoInput getTelefone() {
		return telefone;
	}

	public EnderecoDtoInput getEndereco() {
		return endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public Paciente getPaciente() {
		Telefone telefone = new Telefone(this.telefone.getDdd(), this.telefone.getNumero());
		Endereco endereco = new Endereco(this.endereco.getRua(), this.endereco.getNumero(), this.endereco.getCidade());
		return new Paciente(nome, cpf, email, telefone, endereco);
	}

}