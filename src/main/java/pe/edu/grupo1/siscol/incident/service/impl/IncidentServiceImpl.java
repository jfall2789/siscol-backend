package pe.edu.grupo1.siscol.incident.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.edu.grupo1.siscol.incident.dto.request.IncidentRequest;
import pe.edu.grupo1.siscol.incident.dto.response.IncidentResponse;
import pe.edu.grupo1.siscol.incident.entity.Incident;
import pe.edu.grupo1.siscol.incident.enums.IncidentPriority;
import pe.edu.grupo1.siscol.incident.enums.IncidentStatus;
import pe.edu.grupo1.siscol.incident.repository.IncidentRepository;
import pe.edu.grupo1.siscol.incident.service.IncidentService;
import pe.edu.grupo1.siscol.shared.generator.IncidentCodeGenerator;
import pe.edu.grupo1.siscol.user.entity.User;
import pe.edu.grupo1.siscol.user.repository.UserRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class IncidentServiceImpl implements IncidentService {

    private final IncidentCodeGenerator incidentCodeGenerator;

    private final IncidentRepository incidentRepository;

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    @Override
    public IncidentResponse register(IncidentRequest request) {

        // Convertimos el DTO de entrada a la entidad
        Incident incident = modelMapper.map(request, Incident.class);

        // Valores administrados por el sistema
        incident.setStatus(IncidentStatus.PENDING);

        // La prioridad inicial se deriva de la urgencia reportada
        incident.setPriority(
                IncidentPriority.valueOf(
                        incident.getUrgency().name()));
        incident.setCode(incidentCodeGenerator.generate());


        // TODO: Obtener el usuario autenticado cuando implementemos JWT
        // incident.setReporter(currentUserProvider.getCurrentUser());
        User reporter = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        incident.setReporter(reporter);

        Incident savedIncident = incidentRepository.save(incident);

        return modelMapper.map(savedIncident, IncidentResponse.class);
    }

    @Override
    public List<IncidentResponse> findAll() {

        return incidentRepository.findAll()
                .stream()
                .map(incident -> modelMapper.map(incident, IncidentResponse.class))
                .toList();
    }

    @Override
    public IncidentResponse findById(Long id) {

        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada"));

        return modelMapper.map(incident, IncidentResponse.class);
    }

    @Override
    public IncidentResponse findByCode(String code) {

        Incident incident = incidentRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada"));

        return modelMapper.map(incident, IncidentResponse.class);
    }

    @Override
    public IncidentResponse update(Long id, IncidentRequest request) {

        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada"));

        incident.setTitle(request.getTitle());
        incident.setDescription(request.getDescription());
        incident.setLocation(request.getLocation());
        incident.setType(request.getType());
        incident.setUrgency(request.getUrgency());

        IncidentPriority priority =
                IncidentPriority.valueOf(request.getUrgency().name());

        incident.setPriority(priority);

        Incident updatedIncident = incidentRepository.save(incident);

        return modelMapper.map(updatedIncident, IncidentResponse.class);
    }

    @Override
    public void delete(Long id) {

        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada"));

        incidentRepository.delete(incident);
    }
}
