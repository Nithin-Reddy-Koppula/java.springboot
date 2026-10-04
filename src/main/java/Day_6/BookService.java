package Day_6;


// List is used for multiple books.
import java.util.List;


// Optional is used when a book
// may or may not exist.
import java.util.Optional;


// @Service tells Spring to create
// and manage this class as a Bean.
import org.springframework.stereotype.Service;


// Service layer.
@Service
public class BookService {


    // =====================================================
    // Repository Dependency
    // =====================================================

    private final BookRepository bookRepository;


    // =====================================================
    // Constructor Dependency Injection
    // =====================================================

    // Spring automatically provides
    // the BookRepository Bean here.
    public BookService(BookRepository bookRepository) {

        // Store the injected repository.
        this.bookRepository = bookRepository;
    }


    // =====================================================
    // GET ALL BOOKS
    // =====================================================

    public List<Book> getAllBooks() {

        // Get all records from books table.
        return bookRepository.findAll();
    }


    // =====================================================
    // GET BOOK BY ID
    // =====================================================

    public Optional<Book> getBookById(int id) {

        // Search database using primary key.
        return bookRepository.findById(id);
    }


    // =====================================================
    // CREATE BOOK
    // =====================================================

    public Book createBook(Book book) {

        // Save book into MySQL.
        return bookRepository.save(book);
    }


    // =====================================================
    // UPDATE BOOK
    // =====================================================

    public Optional<Book> updateBook(
            int id,
            Book updatedBook) {


        // First check whether book exists.
        Optional<Book> existingBook =
                bookRepository.findById(id);


        // If book exists...
        if (existingBook.isPresent()) {


            // Get existing database object.
            Book book = existingBook.get();


            // Update title.
            book.setTitle(updatedBook.getTitle());


            // Update ISBN.
            book.setIsbn(updatedBook.getIsbn());


            // Update price.
            book.setPrice(updatedBook.getPrice());


            // Update published year.
            book.setPublishedYear(
                    updatedBook.getPublishedYear()
            );


            // Update author ID.
            book.setAuthorId(
                    updatedBook.getAuthorId()
            );


            // Save updated object.
            Book savedBook =
                    bookRepository.save(book);


            // Return updated book.
            return Optional.of(savedBook);
        }


        // Book does not exist.
        return Optional.empty();
    }


    // =====================================================
    // DELETE BOOK
    // =====================================================

    public boolean deleteBook(int id) {


        // Check whether book exists.
        if (bookRepository.existsById(id)) {


            // Delete record from MySQL.
            bookRepository.deleteById(id);


            // Delete successful.
            return true;
        }


        // Book doesn't exist.
        return false;
    }
}