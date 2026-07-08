package pe.edu.grupo1.siscol.exception.user;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("No existe un usuario con ID: " + id);
    }
}