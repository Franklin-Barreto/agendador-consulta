package br.com.santander.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.santander.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

	@Query("SELECT a FROM Agenda a WHERE a.disponivel = true and a.medico.id = :medico and YEAR(dataConsulta) = :ano and MONTH(dataConsulta) = :mes")
	List<Agenda> buscarDiasDisponiveis(Integer medico, Integer ano,Integer mes);
	
	List<Agenda> findAllByMedicoIdAndDataConsultaAfter(Integer id,LocalDateTime dataConsulta);

	List<Agenda> findAllByPacienteId(Integer id);

	List<Agenda> findAllByMedicoIdAndDisponivelIsTrue(Integer id);

	List<Agenda> findAllByMedicoIdAndDisponivelIsFalse(Integer id);

}
