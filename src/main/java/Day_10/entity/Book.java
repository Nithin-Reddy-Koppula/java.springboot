package Day_10.entity;

// JPA annotation used to mark this class as a database entity.
import jakarta.persistence.Entity;

// JPA annotation used to specify the primary key.
import jakarta.persistence.Id;

// JPA annotation used to automatically generate ID values.
import jakarta.persistence.GeneratedValue;

// Defines how the ID should be generated.
import jakarta.persistence.GenerationType;


// @Entity tells JPA:
//
// "This Java class represents a table in the database."
//
// By default, the table name will be based on the class name:
// Book -> book
@Entity
public class Book {

    // @Id tells JPA that this field is the PRIMARY KEY.
    @Id

    // IDENTITY tells the database to automatically generate
    // the ID when a new book is inserted.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Stores the title of the book.
    private String title;

    // Stores the author name.
    private String author;

    // Stores the price of the book.
    private Double price;


    // Default constructor.
    //
    // JPA requires a no-argument constructor to create
    // Book objects when reading data from the database.
    public Book() {
    }


    // Constructor used when we want to create a Book object
    // by providing its values.
    public Book(String title, String author, Double price) {

        // "this.title" refers to the class field.
        // "title" refers to the constructor parameter.
        this.title = title;

        // Store the author parameter in the author field.
        this.author = author;

        // Store the price parameter in the price field.
        this.price = price;
    }


    // Getter for id.
    //
    // Used to retrieve the book ID.
    public Long getId() {
        return id;
    }


    // Setter for id.
    //
    // Used to assign an ID to the book.
    public void setId(Long id) {
        this.id = id;
    }


    // Getter for title.
    //
    // Returns the book title.
    public String getTitle() {
        return title;
    }


    // Setter for title.
    //
    // Updates the book title.
    public void setTitle(String title) {
        this.title = title;
    }


    // Getter for author.
    //
    // Returns the author name.
    public String getAuthor() {
        return author;
    }


    // Setter for author.
    //
    // Updates the author name.
    public void setAuthor(String author) {
        this.author = author;
    }


    // Getter for price.
    //
    // Returns the book price.
    public Double getPrice() {
        return price;
    }


    // Setter for price.
    //
    // Updates the book price.
    public void setPrice(Double price) {
        this.price = price;
    }
}