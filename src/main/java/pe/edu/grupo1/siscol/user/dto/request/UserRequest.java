package pe.edu.grupo1.siscol.user.dto.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor // CONTRUSCTOR CON TODOS LOS ATRITBUTOS
@NoArgsConstructor  // CONTRUCTOR VACIO
@Builder
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String position;
    private Long roleId;
}
