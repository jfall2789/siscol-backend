package pe.edu.grupo1.siscol.exception.permission;

public class PermissionNotFoundException extends RuntimeException {

    public PermissionNotFoundException(Long id) {
        super("No existe un permiso con ID: " + id);
    }
}