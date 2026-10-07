package Day_10.exception;

/*
 * This is our custom exception.
 *
 * We use it when a requested resource does not exist.
 *
 * Example:
 *
 * GET /api/books/100
 *
 * If book 100 does not exist,
 * we throw ResourceNotFoundException.
 */
public class ResourceNotFoundException extends RuntimeException {

    /*
     * Constructor of our custom exception.
     *
     * "message" contains the error message
     * that we want to send to the caller.
     */
    public ResourceNotFoundException(String message) {

        /*
         * super(message) sends the message
         * to the RuntimeException parent class.
         */
        super(message);
    }
}