package pe.edu.grupo1.siscol.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.edu.grupo1.siscol.exception.incident.IncidentNotFoundException;
import pe.edu.grupo1.siscol.exception.permission.PermissionNotFoundException;
import pe.edu.grupo1.siscol.exception.role.RoleNotFoundException;
import pe.edu.grupo1.siscol.exception.user.UserNotFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            IncidentNotFoundException.class,
            UserNotFoundException.class,
            RoleNotFoundException.class,
            PermissionNotFoundException.class
    })
    public ApiError handleNotFound(RuntimeException ex,
                                   HttpServletRequest request) {

        return ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ApiError handleGeneric(Exception ex,
                                  HttpServletRequest request) {

        return ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
    }

}