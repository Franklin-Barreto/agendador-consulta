package br.com.santander.medico.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.medico.model.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {

}
