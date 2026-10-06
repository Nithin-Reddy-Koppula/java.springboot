package Day_7.repository;
// This interface belongs to the repository package inside Day_7.

import Day_7.entity.Book;
// Imports the Book entity.
// Our queries will operate on this entity.

import org.springframework.data.jpa.repository.JpaRepository;
// JpaRepository provides built-in CRUD operations.

import org.springframework.data.jpa.repository.Query;
// @Query allows us to write our own JPQL query.

import org.springframework.data.repository.query.Param;
// @Param connects a Java method parameter
// with a named parameter inside the @Query.

import java.util.List;
// List is used because the query can return multiple books.


public interface BookRepository extends JpaRepository<Book, Long> {
    // BookRepository manages the Book entity.
    //
    // Book → entity
    // Long → type of Book's primary key.


    List<Book> findByTitleContaining(String title);
    // DERIVED QUERY.
    //
    // Spring reads the method name and creates the query automatically.
    //
    // Example:
    //
    // findByTitleContaining("Harry")
    //
    // Conceptually:
    //
    // SELECT *
    // FROM books
    // WHERE title LIKE '%Harry%';


    @Query("SELECT b FROM Book b WHERE b.price > :price")
        // @Query allows us to define a custom JPQL query.
        //
        // SELECT b
        //     ↓
        // Select the Book object.
        //
        // FROM Book b
        //     ↓
        // Read data from the Book entity.
        //
        // "b" is an alias for the Book entity.
        //
        // WHERE b.price > :price
        //     ↓
        // Only return books whose price is greater
        // than the value supplied to the method.
        //
        // :price is a named parameter.


    List<Book> findBooksWithPriceGreaterThan(
            @Param("price") Double price
    );
    // This method executes the @Query above.
    //
    // @Param("price")
    //     ↓
    // Connects this Java parameter to:
    //
    // :price
    //
    // Example:
    //
    // findBooksWithPriceGreaterThan(500.0)
    //
    // means:
    //
    // Find books where price > 500.
}