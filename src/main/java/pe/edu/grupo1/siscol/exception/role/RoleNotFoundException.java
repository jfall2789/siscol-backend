package pe.edu.grupo1.siscol.exception.role;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(Long id) {
        super("No existe un rol con ID: " + id);
    }
}