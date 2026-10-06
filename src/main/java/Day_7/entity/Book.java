package Day_7.entity;
// Book belongs to the entity package inside Day_7.

import jakarta.persistence.Entity;
// @Entity tells JPA that Book is a database entity.

import jakarta.persistence.GeneratedValue;
// Used to automatically generate the primary key.

import jakarta.persistence.GenerationType;
// Provides different ID generation strategies.

import jakarta.persistence.Id;
// Marks a field as the primary key.

import jakarta.persistence.Table;
// @Table allows us to specify the exact database table name.


@Entity
// Tells Hibernate:
//
// Java class Book
//        ↓
// Database table books
//
// Hibernate will manage this entity.

@Table(name = "books")
// Tells Hibernate to use the database table named "books".
// Without this annotation, Hibernate may choose a table name
// based on its naming strategy.

public class Book {

    @Id
    // Marks id as the PRIMARY KEY.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Uses MySQL AUTO_INCREMENT to automatically generate IDs.

    private Long id;
    // Stores the unique ID of the book.


    private String title;
    // Stores the book title.


    private String isbn;
    // Stores the ISBN number of the book.


    private Double price;
    // Stores the price of the book.


    private Integer publishedYear;
    // Stores the year in which the book was published.


    public Book() {
        // JPA requires a no-argument constructor.
        // Hibernate uses this constructor when creating
        // Book objects from database records.
    }


    public Long getId() {
        // Getter method.
        // Returns the book ID.

        return id;
    }


    public void setId(Long id) {
        // Setter method.
        // Sets the book ID.

        this.id = id;
    }


    public String getTitle() {
        // Getter method.
        // Returns the book title.

        return title;
    }


    public void setTitle(String title) {
        // Setter method.
        // Sets the book title.

        this.title = title;
    }


    public String getIsbn() {
        // Getter method.
        // Returns the ISBN.

        return isbn;
    }


    public void setIsbn(String isbn) {
        // Setter method.
        // Sets the ISBN.

        this.isbn = isbn;
    }


    public Double getPrice() {
        // Getter method.
        // Returns the book price.

        return price;
    }


    public void setPrice(Double price) {
        // Setter method.
        // Sets the book price.

        this.price = price;
    }


    public Integer getPublishedYear() {
        // Getter method.
        // Returns the published year.

        return publishedYear;
    }


    public void setPublishedYear(Integer publishedYear) {
        // Setter method.
        // Sets the published year.

        this.publishedYear = publishedYear;
    }
}