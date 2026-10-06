package Day_7.controller;
// This class belongs to the controller package inside Day_7.

import Day_7.entity.Book;
// Imports the Book entity.

import Day_7.service.BookService;
// Imports BookService.
// The controller uses the service layer to perform operations.

import org.springframework.http.ResponseEntity;
// ResponseEntity allows us to control the HTTP response
// and HTTP status code.

import org.springframework.web.bind.annotation.DeleteMapping;
// Used for DELETE HTTP requests.

import org.springframework.web.bind.annotation.GetMapping;
// Used for GET HTTP requests.

import org.springframework.web.bind.annotation.PathVariable;
// Used to read values from the URL.

import org.springframework.web.bind.annotation.PostMapping;
// Used for POST HTTP requests.

import org.springframework.web.bind.annotation.PutMapping;
// Used for PUT HTTP requests.

import org.springframework.web.bind.annotation.RequestBody;
// Used to read JSON data from the request body.

import org.springframework.web.bind.annotation.RequestParam;
// Used to read parameters from the URL.

import org.springframework.web.bind.annotation.RestController;
// Marks this class as a REST controller.

import java.util.List;
// Used when returning multiple Book objects.


@RestController
// Tells Spring that this class handles REST API requests.
//
// Methods inside this class return data directly as JSON.

public class BookController {

    private final BookService bookService;
    // Reference to BookService.


    public BookController(BookService bookService) {
        // Constructor injection.
        //
        // Spring automatically provides BookService.

        this.bookService = bookService;
        // Stores the BookService object.
    }


    @PostMapping("/books")
    // Handles:
    //
    // POST http://localhost:8080/books
    //
    // Used to create a new book.

    public Book createBook(@RequestBody Book book) {
        // @RequestBody converts incoming JSON into a Book object.
        //
        // Example JSON:
        //
        // {
        //     "title": "Harry Potter",
        //     "isbn": "ISBN001",
        //     "price": 499.0,
        //     "publishedYear": 1997
        // }

        return bookService.createBook(book);
        // Sends the Book object to the service layer.
    }


    @GetMapping("/books")
    // Handles:
    //
    // GET http://localhost:8080/books
    //
    // Returns all books.

    public List<Book> getAllBooks() {
        // Returns a list of books.

        return bookService.getAllBooks();
        // Calls the service layer.
    }


    @GetMapping("/books/{id}")
    // Handles:
    //
    // GET http://localhost:8080/books/1
    //
    // {id} is a dynamic value.

    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        // @PathVariable gets the ID from the URL.
        //
        // Example:
        //
        // /books/1
        //
        // id = 1

        return bookService.getBookById(id)
                // Calls the service to find the book.

                .map(ResponseEntity::ok)
                // If the book exists,
                // return HTTP 200 OK with the book.

                .orElseGet(() -> ResponseEntity.notFound().build());
        // If the book doesn't exist,
        // return HTTP 404 NOT FOUND.
    }


    @PutMapping("/books/{id}")
    // Handles:
    //
    // PUT http://localhost:8080/books/1
    //
    // Used to update a book.

    public ResponseEntity<Book> updateBook(
            @PathVariable Long id,
            // Gets the ID from the URL.

            @RequestBody Book updatedBook
            // Gets the new book information from JSON.
    ) {

        Book book = bookService.updateBook(id, updatedBook);
        // Sends the ID and updated book to the service.


        if (book == null) {
            // Checks whether the book was found.

            return ResponseEntity.notFound().build();
            // If not found, return HTTP 404.
        }


        return ResponseEntity.ok(book);
        // If successfully updated,
        // return HTTP 200 with the updated book.
    }


    @DeleteMapping("/books/{id}")
    // Handles:
    //
    // DELETE http://localhost:8080/books/1
    //
    // Used to delete a book.

    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        // Gets the book ID from the URL.

        bookService.deleteBook(id);
        // Calls the service to delete the book.

        return ResponseEntity.noContent().build();
        // Returns HTTP 204 NO CONTENT.
    }


    @GetMapping("/books/search")
    // Handles:
    //
    // GET http://localhost:8080/books/search?title=Harry
    //
    // Used to search books by title.

    public List<Book> searchBooksByTitle(
            @RequestParam String title
            // @RequestParam gets "title" from the URL.
            //
            // Example:
            //
            // /books/search?title=Harry
            //
            // title = "Harry"
    ) {

        return bookService.searchBooksByTitle(title);
        // Sends the search text to the service layer.
    }
    @GetMapping("/books/price")
    public List<Book> getBooksWithPriceGreaterThan(
            @RequestParam Double price
    ) {
        // @RequestParam reads the price from the URL.
        //
        // Example:
        //
        // /books/price?price=500
        //
        // price = 500.0

        return bookService.getBooksWithPriceGreaterThan(price);
        // Sends the price to the service layer.
    }

}