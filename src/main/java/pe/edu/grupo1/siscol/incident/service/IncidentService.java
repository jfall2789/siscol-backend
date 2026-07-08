package pe.edu.grupo1.siscol.incident.service;

import pe.edu.grupo1.siscol.incident.dto.request.IncidentRequest;
import pe.edu.grupo1.siscol.incident.dto.response.IncidentResponse;

import java.util.List;

public interface IncidentService {
    //registramos la macrofucion del sistema, el corazon del ssitema como tal
    IncidentResponse register(IncidentRequest request);

    List<IncidentResponse> findAll();

    IncidentResponse findById(Long id);

    IncidentResponse findByCode(String code);

    IncidentResponse update(Long id, IncidentRequest request);

    void delete(Long id);

}
