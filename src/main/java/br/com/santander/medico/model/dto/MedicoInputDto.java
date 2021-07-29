package br.com.santander.medico.model.dto;

import br.com.santander.medico.model.Medico;
import br.com.santander.model.Endereco;
import br.com.santander.model.Telefone;
import br.com.santander.model.dto.EnderecoDtoInput;
import br.com.santander.model.dto.TelefoneDtoInput;

public class MedicoInputDto {

	private String nome;
	private String email;
	private String crm;
	private TelefoneDtoInput telefone;
	private EnderecoDtoInput endereco;
	private Integer especialidadeId;

	public MedicoInputDto(String nome, String email, TelefoneDtoInput telefone, EnderecoDtoInput endereco, String crm,Integer especialidadeId) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.crm = crm;
		this.especialidadeId = especialidadeId;
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

	public String getCrm() {
		return crm;
	}
	
	public Integer getEspecialidadeId() {
		return especialidadeId;
	}

	public Medico getMedico() {
		Telefone telefone = new Telefone(this.telefone.getDdd(), this.telefone.getNumero());
		Endereco endereco = new Endereco(this.endereco.getRua(), this.endereco.getNumero(), this.endereco.getCidade());
		return new Medico(nome, crm, email, telefone, endereco);
	}
	
	


}
