package pe.edu.grupo1.siscol.role.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionResponse {

    private Long id;

    private String name;

    private String description;

    private String code;

}