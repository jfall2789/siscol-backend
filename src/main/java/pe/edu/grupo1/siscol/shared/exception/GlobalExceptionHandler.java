package pe.edu.grupo1.siscol.shared.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//Cada vez que ocurra una excepción en cualquier @RestController, pásamela a mí para decidir cómo responder.
public class GlobalExceptionHandler {


    //aqui veremos todos los exception hanlder , cada uno controlará excepciones especificas del sistema

    @ExceptionHandler(IllegalArgumentException.class)
    //Si en cualquier parte de la aplicación alguien lanza (throw) una IllegalArgumentException, llama automáticamente a este método.
    public ResponseEntity<String> handleIllegalArgumentException(
            IllegalArgumentException exception) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) //bad request al momento de mandar
                .body(exception.getMessage());
    }

/*    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException exception) {

        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(exception.getMessage());
    }
    */
}


