package pe.edu.grupo1.siscol.role.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleRequest {

    @NotBlank(message = "El nombre del rol es obligatorio.")
    @Size(max = 100, message = "El nombre del rol no puede superar los 100 caracteres.")
    private String name;

    @NotBlank(message = "La descripción del rol es obligatoria.")
    @Size(max = 255, message = "La descripción no puede superar los 255 caracteres.")
    private String description;

}