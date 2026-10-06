package Day_9.service;

// Imports Spring's @Service annotation.
// @Service tells Spring that this class contains business logic.
import org.springframework.stereotype.Service;

// Imports Pageable.
// Pageable contains pagination information such as:
// page number, page size, and sorting.
import org.springframework.data.domain.Pageable;

// Imports Page.
// Page contains the requested records along with
// information about total pages, total elements, etc.
import org.springframework.data.domain.Page;

// Imports our Book entity.
import Day_9.entity.Book;

// Imports our BookRepository.
// Repository communicates with the database.
import Day_9.repository.BookRepository;

// Imports our custom exception.
// We will throw this when a book does not exist.
import Day_9.exception.ResourceNotFoundException;

// Imports SLF4J Logger.
// Logger is used to print useful application messages.
import org.slf4j.Logger;

// Imports LoggerFactory.
// LoggerFactory creates our Logger object.

import org.slf4j.LoggerFactory;

// Imports Optional.
// findById() returns Optional<Book>.
import java.util.Optional;


// @Service tells Spring Boot that this class
// should be managed by the Spring container.
@Service
public class BookService {

    // Creates a logger for this class.
    //
    // BookService.class tells the logger
    // which class is generating the log messages.
    private static final Logger logger =
            LoggerFactory.getLogger(BookService.class);


    // Creates a BookRepository object.
    //
    // final means this reference cannot be changed
    // after it has been initialized.
    private final BookRepository bookRepository;


    // Constructor injection.
    //
    // Spring automatically provides BookRepository
    // when it creates BookService.
    public BookService(BookRepository bookRepository) {

        // Stores the repository object in our class variable.
        this.bookRepository = bookRepository;
    }


    // This method returns books with pagination and sorting.
    //
    // Pageable contains:
    // page number
    // page size
    // sorting information
    public Page<Book> getAllBooks(Pageable pageable) {

        // Writes an INFO-level log message.
        //
        // {} is a placeholder.
        // pageable will be inserted into that placeholder.
        logger.info("Fetching books with pagination: {}", pageable);


        // Calls Spring Data JPA's findAll(Pageable).
        //
        // This automatically handles:
        // pagination
        // sorting
        // database query
        return bookRepository.findAll(pageable);
    }


    // This method gets one book using its ID.
    public Book getBookById(Long id) {

        // Logs which book ID the user is requesting.
        logger.info("Fetching book with id: {}", id);


        // findById() searches for the book in the database.
        //
        // It returns Optional<Book> because
        // the book may or may not exist.
        Optional<Book> book = bookRepository.findById(id);


        // Check whether the book exists.
        if (book.isPresent()) {

            // Logs that the book was found.
            logger.info("Book found with id: {}", id);

            // Returns the actual Book object.
            return book.get();
        }


        // This executes when the book doesn't exist.
        logger.warn("Book not found with id: {}", id);


        // Throws our custom exception.
        //
        // GlobalExceptionHandler will catch this exception
        // and return HTTP 404 with a JSON response.
        throw new ResourceNotFoundException(
                "Book not found with id: " + id
        );
    }
}