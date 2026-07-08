package pe.edu.grupo1.siscol.incident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.grupo1.siscol.incident.entity.Incident;

import java.util.Optional;

public interface IncidentRepository extends JpaRepository<Incident, Long> {

    Optional<Incident> findByCode(String code);

    Optional<Incident> findTopByOrderByCodeDesc();
}
