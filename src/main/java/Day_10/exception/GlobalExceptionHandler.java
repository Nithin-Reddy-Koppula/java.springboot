package Day_10.exception;

// Used to build HTTP responses.
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// Used to define a global exception handler.
import org.springframework.web.bind.annotation.ExceptionHandler;

// Used to mark this class as a global controller advice.
import org.springframework.web.bind.annotation.RestControllerAdvice;


/*
 * @RestControllerAdvice means:
 *
 * "Handle exceptions thrown by REST controllers
 * from one central location."
 *
 * This prevents us from writing try/catch
 * blocks inside every controller method.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    /*
     * @ExceptionHandler tells Spring:
     *
     * Whenever ResourceNotFoundException occurs,
     * call this method.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(
            ResourceNotFoundException exception) {

        /*
         * Return:
         *
         * HTTP 404 NOT FOUND
         *
         * along with the exception message.
         */
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}