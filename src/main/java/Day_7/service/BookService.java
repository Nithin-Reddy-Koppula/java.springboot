package Day_7.service;
// This class belongs to the service package inside Day_7.

import Day_7.entity.Book;
// Imports the Book entity.

import Day_7.repository.BookRepository;
// Imports BookRepository.
// The service uses this repository to communicate with the database.

import org.springframework.stereotype.Service;
// @Service tells Spring that this class is a service component.

import java.util.List;
// List is used when returning multiple Book objects.

import java.util.Optional;
// Optional is used when a book may or may not exist.


@Service
// Tells Spring:
//
// "Create and manage an object of this BookService class."
//
// This class contains the business logic between
// Controller and Repository.

public class BookService {

    private final BookRepository bookRepository;
    // Creates a reference to BookRepository.
    //
    // final means the reference cannot be changed
    // after it is assigned.
    //
    // The service uses this object to perform database operations.


    public BookService(BookRepository bookRepository) {
        // Constructor of BookService.
        //
        // Spring automatically provides the BookRepository object
        // through constructor injection.

        this.bookRepository = bookRepository;
        // Stores the repository object inside this class.
    }


    public Book createBook(Book book) {
        // Creates and saves a new book.
        //
        // The Book object comes from the controller.

        return bookRepository.save(book);
        // save() is provided by JpaRepository.
        //
        // Hibernate converts the Java object into an SQL INSERT.
        //
        // Example:
        //
        // INSERT INTO books (...)
        // VALUES (...);
    }


    public List<Book> getAllBooks() {
        // Returns all books from the database.

        return bookRepository.findAll();
        // findAll() is provided automatically by JpaRepository.
        //
        // It retrieves all records from the books table.
    }


    public Optional<Book> getBookById(Long id) {
        // Searches for one book using its primary key.

        return bookRepository.findById(id);
        // findById() is provided by JpaRepository.
        //
        // Optional is returned because the book may not exist.
    }


    public Book updateBook(Long id, Book updatedBook) {
        // Updates an existing book.

        Optional<Book> existingBook = bookRepository.findById(id);
        // First, search for the existing book using its ID.


        if (existingBook.isPresent()) {
            // Checks whether a book with this ID exists.

            Book book = existingBook.get();
            // Gets the actual Book object from Optional.


            book.setTitle(updatedBook.getTitle());
            // Updates the title.


            book.setIsbn(updatedBook.getIsbn());
            // Updates the ISBN.


            book.setPrice(updatedBook.getPrice());
            // Updates the price.


            book.setPublishedYear(updatedBook.getPublishedYear());
            // Updates the published year.


            return bookRepository.save(book);
            // Saves the updated book to the database.
            //
            // Hibernate generates an SQL UPDATE.
        }


        return null;
        // If the book does not exist,
        // return null to the controller.
    }


    public void deleteBook(Long id) {
        // Deletes a book using its ID.

        bookRepository.deleteById(id);
        // deleteById() is provided by JpaRepository.
    }


    public List<Book> searchBooksByTitle(String title) {
        // Searches for books whose title contains
        // the text supplied by the user.
        //
        // Example:
        //
        // title = "Harry"


        return bookRepository.findByTitleContaining(title);
        // Calls our derived query from BookRepository.
        //
        // Spring Data JPA reads:
        //
        // findByTitleContaining
        //
        // and automatically creates the appropriate query.
    }
    public List<Book> getBooksWithPriceGreaterThan(Double price) {
        // Receives the minimum price from the controller.

        return bookRepository.findBooksWithPriceGreaterThan(price);
        // Calls the custom @Query method in BookRepository.
    }


}