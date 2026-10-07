package Day_10.service;

// Import the Book entity.
import Day_10.entity.Book;

// Import our custom exception.
import Day_10.exception.ResourceNotFoundException;

// Import the BookRepository.
import Day_10.repository.BookRepository;

// Import List so we can return multiple books.
import java.util.List;

// Import Optional because findById() returns Optional<Book>.
import java.util.Optional;

// @Service tells Spring that this class contains business logic.
import org.springframework.stereotype.Service;


// This class contains the business logic for books.
@Service
public class BookService {

    // Repository used to communicate with the database.
    private final BookRepository bookRepository;


    // Constructor injection.
    //
    // Spring automatically provides the BookRepository object.
    public BookService(BookRepository bookRepository) {

        // Store the repository in our class variable.
        this.bookRepository = bookRepository;
    }


    // ============================================================
    // CREATE BOOK
    // ============================================================

    // This method creates and saves a new book.
    public Book createBook(Book book) {

        // save() is provided by JpaRepository.
        //
        // It saves the book into the database.
        return bookRepository.save(book);
    }


    // ============================================================
    // GET ALL BOOKS
    // ============================================================

    // This method returns all books from the database.
    public List<Book> getAllBooks() {

        // findAll() is provided by JpaRepository.
        //
        // It retrieves all Book records.
        return bookRepository.findAll();
    }


    // ============================================================
    // GET BOOK BY ID
    // ============================================================

    // This method searches for one book using its ID.
    public Book getBookById(Long id) {

        // Search the database using the book ID.
        //
        // findById() returns Optional<Book>
        // because the book might not exist.
        Optional<Book> book = bookRepository.findById(id);


        // If the book exists:
        //     return the Book object.
        //
        // If the book doesn't exist:
        //     throw ResourceNotFoundException.
        return book.orElseThrow(
                () -> new ResourceNotFoundException(
                        "Book not found with id: " + id
                )
        );
    }


    // ============================================================
    // DELETE BOOK
    // ============================================================

    // This method deletes a book using its ID.
    public void deleteBook(Long id) {

        // Check whether the book exists.
        if (!bookRepository.existsById(id)) {

            // If the book doesn't exist,
            // throw our custom exception.
            throw new ResourceNotFoundException(
                    "Book not found with id: " + id
            );
        }

        // Delete the book using its ID.
        bookRepository.deleteById(id);
    }
}