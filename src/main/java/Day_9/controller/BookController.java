package Day_9.controller;

// Imports @RestController.
// It tells Spring that this class handles REST API requests.
import org.springframework.web.bind.annotation.RestController;

// Imports @RequestMapping.
// It defines the common URL for all methods in this controller.
import org.springframework.web.bind.annotation.RequestMapping;

// Imports @GetMapping.
// It maps HTTP GET requests to Java methods.
import org.springframework.web.bind.annotation.GetMapping;

// Imports @PathVariable.
// It reads a value from the URL, such as /books/10.
import org.springframework.web.bind.annotation.PathVariable;

// Imports @RequestParam.
// It reads query parameters such as ?page=0&size=5&sort=title.
import org.springframework.web.bind.annotation.RequestParam;

// Imports Pageable.
// Pageable stores page, size, and sorting information.
import org.springframework.data.domain.Pageable;

// Imports Page.
// Page contains the books and pagination information.
import org.springframework.data.domain.Page;

// Imports PageRequest.
// PageRequest creates a Pageable object.
import org.springframework.data.domain.PageRequest;

// Imports Sort.
// Sort is used to specify ascending or descending sorting.
import org.springframework.data.domain.Sort;

// Imports our Book entity.
import Day_9.entity.Book;

// Imports our BookService.
import Day_9.service.BookService;


// @RestController tells Spring that this class
// is a REST API controller.
@RestController

// Every endpoint inside this controller starts with /api/books.
@RequestMapping("/api/books")
public class BookController {

    // Reference to our service layer.
    private final BookService bookService;


    // Constructor injection.
    //
    // Spring automatically provides BookService here.
    public BookController(BookService bookService) {

        // Store the service object in our class variable.
        this.bookService = bookService;
    }


    // Handles GET requests to:
    //
    // GET /api/books
    //
    // It also accepts:
    //
    // ?page=0
    // ?size=5
    // ?sort=title
    //
    // Example:
    // GET /api/books?page=0&size=5&sort=title
    @GetMapping
    public Page<Book> getAllBooks(

            // Reads the "page" query parameter.
            //
            // defaultValue = "0" means:
            // If the user doesn't provide page,
            // use page 0.
            @RequestParam(defaultValue = "0") int page,

            // Reads the "size" query parameter.
            //
            // If size isn't provided,
            // return 5 records per page.
            @RequestParam(defaultValue = "5") int size,

            // Reads the "sort" query parameter.
            //
            // If sort isn't provided,
            // sort by title.
            @RequestParam(defaultValue = "title") String sort
    ) {

        // Creates a Pageable object.
        //
        // PageRequest.of() receives:
        // 1. page number
        // 2. page size
        // 3. sorting
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sort).ascending()
        );


        // Send the pagination information
        // to the service layer.
        return bookService.getAllBooks(pageable);
    }


    // Handles:
    //
    // GET /api/books/{id}
    //
    // Example:
    //
    // GET /api/books/5
    @GetMapping("/{id}")
    public Book getBookById(

            // Reads the {id} value from the URL.
            //
            // Example:
            // /api/books/5
            //
            // id = 5
            @PathVariable Long id
    ) {

        // Pass the ID to the service layer.
        //
        // The service searches for the book.
        //
        // If the book doesn't exist,
        // ResourceNotFoundException is thrown.
        return bookService.getBookById(id);
    }
}