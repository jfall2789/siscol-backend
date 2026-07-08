package pe.edu.grupo1.siscol.incident.dto.request;

import lombok.Data;
import pe.edu.grupo1.siscol.incident.enums.IncidentType;
import pe.edu.grupo1.siscol.incident.enums.IncidentUrgency;

@Data
public class IncidentRequest {

    private String title;

    private String description;

    private String location;

    private IncidentType type;

    private IncidentUrgency urgency;

}