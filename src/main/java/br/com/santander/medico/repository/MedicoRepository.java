package br.com.santander.medico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.santander.medico.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

	@Query("SELECT m FROM Medico m Join m.agendas a WHERE a.disponivel = false and a.medico.id = :id")
	List<Medico> buscarAgendaPorMedicoId(Integer id);

}
