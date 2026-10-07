package Day_10.controller;

// Import the Book entity.
import Day_10.entity.Book;

// Import the BookService.
import Day_10.service.BookService;

// Used to return HTTP responses.
import org.springframework.http.ResponseEntity;

// Used to document REST endpoints in Swagger.
import io.swagger.v3.oas.annotations.Operation;

// Used to document possible HTTP responses.
import io.swagger.v3.oas.annotations.responses.ApiResponse;

// Used to document multiple API responses.
import io.swagger.v3.oas.annotations.responses.ApiResponses;

// Used for DELETE requests.
import org.springframework.web.bind.annotation.DeleteMapping;

// Used for GET requests.
import org.springframework.web.bind.annotation.GetMapping;

// Used to read values from the URL.
import org.springframework.web.bind.annotation.PathVariable;

// Used for POST requests.
import org.springframework.web.bind.annotation.PostMapping;

// Used to read JSON request data.
import org.springframework.web.bind.annotation.RequestBody;

// Used to define the base URL.
import org.springframework.web.bind.annotation.RequestMapping;

// Marks this class as a REST controller.
import org.springframework.web.bind.annotation.RestController;

// Used for List.
import java.util.List;


/*
 * @RestController tells Spring that this class
 * contains REST API endpoints.
 *
 * Spring automatically converts Java objects
 * into JSON responses.
 */
@RestController


/*
 * All endpoints in this controller start with:
 *
 * /api/books
 */
@RequestMapping("/api/books")
public class BookController {

    /*
     * Reference to the service layer.
     */
    private final BookService bookService;


    /*
     * Constructor injection.
     *
     * Spring automatically provides BookService.
     */
    public BookController(BookService bookService) {

        // Store the service object.
        this.bookService = bookService;
    }


    // ============================================================
    // GET ALL BOOKS
    // ============================================================

    /*
     * @Operation provides a description for Swagger.
     *
     * Swagger will display this description
     * next to the GET endpoint.
     */
    @Operation(
            summary = "Get all books",
            description = "Returns a list of all books stored in the database."
    )

    /*
     * @ApiResponses documents the possible HTTP responses.
     */
    @ApiResponses({

            /*
             * HTTP 200 means the request was successful.
             */
            @ApiResponse(
                    responseCode = "200",
                    description = "Books retrieved successfully"
            )
    })

    /*
     * @GetMapping handles:
     *
     * GET /api/books
     */
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        // Ask the service to retrieve all books.
        List<Book> books = bookService.getAllBooks();

        // Return HTTP 200 OK with the books.
        return ResponseEntity.ok(books);
    }


    // ============================================================
    // GET BOOK BY ID
    // ============================================================

    @Operation(
            summary = "Get book by ID",
            description = "Returns a single book using its ID."
    )

    @ApiResponses({

            /*
             * Book was found.
             */
            @ApiResponse(
                    responseCode = "200",
                    description = "Book found successfully"
            ),

            /*
             * Book was not found.
             */
            @ApiResponse(
                    responseCode = "404",
                    description = "Book not found"
            )
    })

    /*
     * Handles:
     *
     * GET /api/books/{id}
     *
     * Example:
     *
     * GET /api/books/1
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(

            /*
             * @PathVariable gets the ID
             * from the URL.
             */
            @PathVariable Long id) {

        // Ask the service to find the book.
        Book book = bookService.getBookById(id);

        // Return HTTP 200 OK with the book.
        return ResponseEntity.ok(book);
    }


    // ============================================================
    // CREATE BOOK
    // ============================================================

    @Operation(
            summary = "Create a new book",
            description = "Creates and saves a new book in the database."
    )

    @ApiResponses({

            /*
             * Book created successfully.
             */
            @ApiResponse(
                    responseCode = "200",
                    description = "Book created successfully"
            )
    })

    /*
     * Handles:
     *
     * POST /api/books
     */
    @PostMapping
    public ResponseEntity<Book> createBook(

            /*
             * @RequestBody converts incoming JSON
             * into a Book Java object.
             */
            @RequestBody Book book) {

        // Send the book to the service layer.
        Book savedBook = bookService.createBook(book);

        // Return the saved book.
        return ResponseEntity.ok(savedBook);
    }


    // ============================================================
    // DELETE BOOK
    // ============================================================

    @Operation(
            summary = "Delete a book",
            description = "Deletes a book using its ID."
    )

    @ApiResponses({

            /*
             * Book deleted successfully.
             */
            @ApiResponse(
                    responseCode = "204",
                    description = "Book deleted successfully"
            ),

            /*
             * Book was not found.
             */
            @ApiResponse(
                    responseCode = "404",
                    description = "Book not found"
            )
    })

    /*
     * Handles:
     *
     * DELETE /api/books/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(

            /*
             * Get the ID from the URL.
             */
            @PathVariable Long id) {

        // Ask the service to delete the book.
        bookService.deleteBook(id);

        // Return HTTP 204 No Content.
        return ResponseEntity.noContent().build();
    }
}