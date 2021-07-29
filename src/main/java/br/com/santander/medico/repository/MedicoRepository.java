package br.com.santander.medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.medico.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
