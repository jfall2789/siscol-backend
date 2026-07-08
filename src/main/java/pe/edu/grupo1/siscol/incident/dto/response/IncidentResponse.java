package pe.edu.grupo1.siscol.incident.dto.response;

import lombok.Data;
import pe.edu.grupo1.siscol.incident.enums.IncidentPriority;
import pe.edu.grupo1.siscol.incident.enums.IncidentStatus;
import pe.edu.grupo1.siscol.incident.enums.IncidentType;
import pe.edu.grupo1.siscol.incident.enums.IncidentUrgency;

@Data
public class IncidentResponse {

    private Long id;

    private String code;

    private String title;

    private String description;

    private String location;

    private IncidentStatus status;

    private IncidentType type;

    private IncidentUrgency urgency;

    private IncidentPriority priority;

}