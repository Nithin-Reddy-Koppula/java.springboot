package Day_6;


// List is used for returning
// multiple books.
import java.util.List;


// Optional represents
// a value that may be present or absent.
import java.util.Optional;


// Used for HTTP status codes.
import org.springframework.http.ResponseEntity;


// REST annotations.
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// =====================================================
// REST CONTROLLER
// =====================================================

@RestController


// Base URL.
//
// Every endpoint starts with:
// /api/books
@RequestMapping("/api/books")
public class BookController {


    // =====================================================
    // Service Dependency
    // =====================================================

    private final BookService bookService;


    // =====================================================
    // Constructor Dependency Injection
    // =====================================================

    // Spring automatically injects BookService.
    public BookController(BookService bookService) {

        this.bookService = bookService;
    }


    // =====================================================
    // GET ALL BOOKS
    // =====================================================

    // GET /api/books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {


        // Ask service for all books.
        List<Book> books =
                bookService.getAllBooks();


        // Return 200 OK.
        return ResponseEntity.ok(books);
    }


    // =====================================================
    // GET BOOK BY ID
    // =====================================================

    // GET /api/books/{id}
    //
    // Example:
    // GET /api/books/1
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(

            // Get ID from URL.
            @PathVariable int id) {


        // Ask service to find the book.
        Optional<Book> book =
                bookService.getBookById(id);


        // If book exists...
        if (book.isPresent()) {


            // Return 200 OK.
            return ResponseEntity.ok(
                    book.get()
            );
        }


        // Book doesn't exist.
        //
        // Return 404 NOT FOUND.
        return ResponseEntity.notFound().build();
    }


    // =====================================================
    // CREATE BOOK
    // =====================================================

    // POST /api/books
    @PostMapping
    public ResponseEntity<Book> createBook(

            // Convert incoming JSON
            // into Book object.
            @RequestBody Book book) {


        // Basic validation.
        if (book.getTitle() == null ||
                book.getTitle().trim().isEmpty()) {


            // Invalid request.
            return ResponseEntity.badRequest().build();
        }


        // Save book using service.
        Book savedBook =
                bookService.createBook(book);


        // Return 201 CREATED.
        return ResponseEntity
                .status(201)
                .body(savedBook);
    }


    // =====================================================
    // UPDATE BOOK
    // =====================================================

    // PUT /api/books/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(

            // ID from URL.
            @PathVariable int id,

            // JSON body converted to Book.
            @RequestBody Book updatedBook) {


        // Basic validation.
        if (updatedBook.getTitle() == null ||
                updatedBook.getTitle().trim().isEmpty()) {


            // Return 400 BAD REQUEST.
            return ResponseEntity.badRequest().build();
        }


        // Ask service to update.
        Optional<Book> result =
                bookService.updateBook(
                        id,
                        updatedBook
                );


        // If update was successful...
        if (result.isPresent()) {


            // Return 200 OK.
            return ResponseEntity.ok(
                    result.get()
            );
        }


        // Book doesn't exist.
        return ResponseEntity.notFound().build();
    }


    // =====================================================
    // DELETE BOOK
    // =====================================================

    // DELETE /api/books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(

            // ID from URL.
            @PathVariable int id) {


        // Ask service to delete.
        boolean deleted =
                bookService.deleteBook(id);


        // If no book was found...
        if (!deleted) {


            // Return 404.
            return ResponseEntity.notFound().build();
        }


        // Delete successful.
        //
        // Return 204 NO CONTENT.
        return ResponseEntity.noContent().build();
    }
}