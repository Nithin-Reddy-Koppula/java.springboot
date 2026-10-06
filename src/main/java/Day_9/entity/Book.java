package Day_9.entity;

// JPA annotation used to mark this class as a database entity.
import jakarta.persistence.Entity;

// Specifies the primary key of the table.
import jakarta.persistence.Id;

// Automatically generates the ID value.
import jakarta.persistence.GeneratedValue;

// Specifies how the ID should be generated.
import jakarta.persistence.GenerationType;


// @Entity tells JPA that this Java class represents
// a table in the database.
@Entity
public class Book {

    // @Id tells JPA that this field is the primary key.
    @Id

    // IDENTITY means the database will automatically
    // generate the ID when a new book is inserted.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Stores the title of the book.
    private String title;

    // Stores the author name.
    private String author;

    // Stores the price of the book.
    private Double price;


    // Default constructor.
    // JPA requires a no-argument constructor.
    public Book() {
    }


    // Constructor used to create a Book object
    // without manually setting every field.
    public Book(String title, String author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }


    // Getter for id.
    // Returns the book ID.
    public Long getId() {
        return id;
    }


    // Setter for id.
    // Allows the ID to be changed when required.
    public void setId(Long id) {
        this.id = id;
    }


    // Getter for title.
    // Returns the book title.
    public String getTitle() {
        return title;
    }


    // Setter for title.
    // Changes the book title.
    public void setTitle(String title) {
        this.title = title;
    }


    // Getter for author.
    // Returns the author name.
    public String getAuthor() {
        return author;
    }


    // Setter for author.
    // Changes the author name.
    public void setAuthor(String author) {
        this.author = author;
    }


    // Getter for price.
    // Returns the book price.
    public Double getPrice() {
        return price;
    }


    // Setter for price.
    // Changes the book price.
    public void setPrice(Double price) {
        this.price = price;
    }
}