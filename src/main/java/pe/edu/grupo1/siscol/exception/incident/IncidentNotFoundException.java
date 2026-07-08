package pe.edu.grupo1.siscol.exception.incident;

public class IncidentNotFoundException extends RuntimeException {

    public IncidentNotFoundException(Long id) {
        super("No existe una incidencia con ID: " + id);
    }

    public IncidentNotFoundException(String code) {
        super("No existe una incidencia con código: " + code);
    }
}