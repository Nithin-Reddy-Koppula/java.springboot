package Day_9.exception;

// This class creates our own custom exception.
// We use it when a requested resource, such as a Book,
// cannot be found in the database.
public class ResourceNotFoundException extends RuntimeException {

    // Constructor receives the error message.
    public ResourceNotFoundException(String message) {

        // Passes the message to the parent RuntimeException class.
        super(message);
    }
}