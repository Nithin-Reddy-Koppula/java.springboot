package Day_10.repository;

// Imports the Book entity.
import Day_10.entity.Book;

// JpaRepository provides ready-made database operations.
import org.springframework.data.jpa.repository.JpaRepository;


// BookRepository is responsible for communicating with the database.
//
// JpaRepository<Book, Long> means:
//
// Book -> entity that this repository manages.
//
// Long -> data type of the Book primary key.
public interface BookRepository extends JpaRepository<Book, Long> {

    // We don't need to write methods for basic operations.
    //
    // JpaRepository already provides:
    //
    // save()
    // findAll()
    // findById()
    // deleteById()
    // existsById()
    // count()
    //
    // and many more.
}