package Day_8.controller;

import Day_8.dto.BookRequest;
import Day_8.dto.BookResponse;
import Day_8.service.BookService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // Constructor Injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CREATE BOOK
    @PostMapping
    public ResponseEntity<BookResponse> createBook(
            @Valid @RequestBody BookRequest request) {

        BookResponse response = bookService.createBook(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // GET ALL BOOKS
    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {

        List<BookResponse> books = bookService.getAllBooks();

        return ResponseEntity.ok(books);
    }

    // GET BOOK BY ID
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(
            @PathVariable Long id) {

        BookResponse response = bookService.getBookById(id);

        return ResponseEntity.ok(response);
    }

    // UPDATE BOOK
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BookRequest request) {

        BookResponse response = bookService.updateBook(id, request);

        return ResponseEntity.ok(response);
    }

    // DELETE BOOK
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(
            @PathVariable Long id) {

        bookService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }
}