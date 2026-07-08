package pe.edu.grupo1.siscol.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres.")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio.")
    @Size(max = 100, message = "El apellido no puede superar los 100 caracteres.")
    private String lastName;

    @NotBlank(message = "El correo electrónico es obligatorio.")
    @Email(message = "El correo electrónico no tiene un formato válido.")
    @Size(max = 150, message = "El correo electrónico no puede superar los 150 caracteres.")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 8, max = 100, message = "La contraseña debe tener entre 8 y 100 caracteres.")
    private String password;

    @NotBlank(message = "El teléfono es obligatorio.")
    @Size(max = 20, message = "El teléfono no puede superar los 20 caracteres.")
    private String phoneNumber;

    @NotBlank(message = "El cargo es obligatorio.")
    @Size(max = 100, message = "El cargo no puede superar los 100 caracteres.")
    private String position;

    @NotNull(message = "Debe seleccionar un rol.")
    private Long roleId;

}