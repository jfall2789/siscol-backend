package pe.edu.grupo1.siscol.incident.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.grupo1.siscol.incident.dto.request.IncidentRequest;
import pe.edu.grupo1.siscol.incident.dto.response.IncidentResponse;
import pe.edu.grupo1.siscol.incident.service.IncidentService;

import java.util.List;

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
    public IncidentResponse register(@RequestBody IncidentRequest request) {
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
     * Buscar por ID
     */
    @GetMapping("/{id}")
    public IncidentResponse findById(@PathVariable Long id) {
        return incidentService.findById(id);
    }

    /**
     * Buscar por código
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
            @RequestBody IncidentRequest request) {

        return incidentService.update(id, request);
    }

    /**
     * Eliminar incidencia
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        incidentService.delete(id);
    }

}