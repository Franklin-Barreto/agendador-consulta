package br.com.santander.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.santander.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

	@Query("SELECT DAY(a.dataConsulta) as DIA,COUNT(a) as TOTAL FROM Agenda a WHERE a.medico.id = :medico and YEAR(dataConsulta) = :ano and MONTH(dataConsulta) = :mes GROUP BY DIA HAVING COUNT(a) > 8")
	List<Integer> buscarDiasDisponiveis(Integer medico, Integer ano,Integer mes);
	
	List<Agenda> findAllByMedicoIdAndDataConsultaAfter(Integer id,LocalDateTime dataConsulta);

}
