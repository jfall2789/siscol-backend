package pe.edu.grupo1.siscol.incident.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.grupo1.siscol.incident.dto.request.IncidentRequest;
import pe.edu.grupo1.siscol.incident.dto.response.IncidentResponse;
import pe.edu.grupo1.siscol.incident.service.IncidentService;

import java.util.List;

@Tag(
        name = "Incidencias",
        description = "Operaciones para el registro y seguimiento de incidencias."
)
@RestController
@RequestMapping("/api/incidents")
@RequiredArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;

    /**
     * Registrar incidencia
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncidentResponse register(@Valid @RequestBody IncidentRequest request) {
        return incidentService.register(request);
    }

    /**
     * Listar incidencias
     */
    @GetMapping
    public List<IncidentResponse> findAll() {
        return incidentService.findAll();
    }

    /**
     * Buscar incidencia por ID
     */
    @GetMapping("/{id}")
    public IncidentResponse findById(@PathVariable Long id) {
        return incidentService.findById(id);
    }

    /**
     * Buscar incidencia por código
     */
    @GetMapping("/code/{code}")
    public IncidentResponse findByCode(@PathVariable String code) {
        return incidentService.findByCode(code);
    }

    /**
     * Actualizar incidencia
     */
    @PutMapping("/{id}")
    public IncidentResponse update(
            @PathVariable Long id,
            @Valid @RequestBody IncidentRequest request) {

        return incidentService.update(id, request);
    }

    /**
     * Eliminar incidencia
     * (En el siguiente sprint será reemplazado por Soft Delete)
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        incidentService.delete(id);
    }

}