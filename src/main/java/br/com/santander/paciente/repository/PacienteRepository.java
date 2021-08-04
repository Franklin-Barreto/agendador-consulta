package br.com.santander.paciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.paciente.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
