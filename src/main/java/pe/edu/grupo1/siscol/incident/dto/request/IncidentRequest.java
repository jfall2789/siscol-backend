package pe.edu.grupo1.siscol.incident.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import pe.edu.grupo1.siscol.incident.enums.IncidentType;
import pe.edu.grupo1.siscol.incident.enums.IncidentUrgency;

@Data
public class IncidentRequest {

    @NotBlank(message = "El título es obligatorio.")
    @Size(max = 100, message = "El título no puede superar los 100 caracteres.")
    private String title;

    @NotBlank(message = "La descripción es obligatoria.")
    @Size(max = 1000, message = "La descripción no puede superar los 1000 caracteres.")
    private String description;

    @NotBlank(message = "La ubicación es obligatoria.")
    @Size(max = 100, message = "La ubicación no puede superar los 100 caracteres.")
    private String location;

    @NotNull(message = "Debe seleccionar un tipo de incidencia.")
    private IncidentType type;

    @NotNull(message = "Debe seleccionar un nivel de urgencia.")
    private IncidentUrgency urgency;

}