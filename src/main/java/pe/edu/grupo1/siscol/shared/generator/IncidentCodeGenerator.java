package pe.edu.grupo1.siscol.shared.generator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.grupo1.siscol.incident.entity.Incident;
import pe.edu.grupo1.siscol.incident.repository.IncidentRepository;

@Component
@RequiredArgsConstructor
public class IncidentCodeGenerator {

    private static final String PREFIX = "INC-";

    private final IncidentRepository incidentRepository;

    public String generate() {

        return incidentRepository.findTopByOrderByCodeDesc()
                .map(Incident::getCode)
                .map(this::nextCode)
                .orElse("INC-000001");
    }

    private String nextCode(String currentCode) {

        int number = Integer.parseInt(currentCode.substring(4));

        return String.format("%s%06d", PREFIX, number + 1);
    }
}