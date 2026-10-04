package Day_6;


// JpaRepository provides ready-made
// database CRUD operations.
import org.springframework.data.jpa.repository.JpaRepository;


// This interface communicates with the database.
//
// We don't have to write SQL for basic CRUD.
public interface BookRepository
        extends JpaRepository<Book, Integer> {


    // JpaRepository already provides:

    // save()
    // findAll()
    // findById()
    // deleteById()
    // existsById()
    // count()

}