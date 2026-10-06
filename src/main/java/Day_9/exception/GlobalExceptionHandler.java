package Day_9.exception;

// Imports the annotation used to create a global exception handler.
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Imports the annotation used to handle a specific exception.
import org.springframework.web.bind.annotation.ExceptionHandler;

// Imports ResponseEntity, which allows us to control
// the HTTP response body and HTTP status code.
import org.springframework.http.ResponseEntity;

// Imports HttpStatus so we can return HTTP 404 NOT FOUND.
import org.springframework.http.HttpStatus;

// Imports Map so that we can create a JSON-style response body.
import java.util.Map;


// @RestControllerAdvice tells Spring Boot that this class
// will handle exceptions thrown by REST controllers.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler tells Spring that this method
    // should execute whenever ResourceNotFoundException occurs.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFound(
            ResourceNotFoundException exception) {

        // Create the JSON response body.
        // "error" is the JSON field name.
        // exception.getMessage() gets the message from our exception.
        Map<String, String> errorResponse = Map.of(
                "error", exception.getMessage()
        );

        // Return the response.
        // errorResponse becomes the JSON body.
        // HttpStatus.NOT_FOUND gives us HTTP status 404.
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
}