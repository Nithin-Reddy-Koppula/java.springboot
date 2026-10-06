package Day_9.repository;

// Imports Spring Data JPA's JpaRepository.
import org.springframework.data.jpa.repository.JpaRepository;

// Imports our Book entity.
import Day_9.entity.Book;


// JpaRepository gives us ready-made database operations
// such as save(), findAll(), findById(), deleteById(), etc.
//
// Book = entity we are working with.
// Long = data type of Book's primary key.
public interface BookRepository extends JpaRepository<Book, Long> {

    // We don't need to write any methods here.
    //
    // JpaRepository already provides:
    //
    // save(book)
    // findAll()
    // findById(id)
    // deleteById(id)
    // existsById(id)
    //
    // It also supports pagination and sorting through
    // findAll(Pageable pageable).
}