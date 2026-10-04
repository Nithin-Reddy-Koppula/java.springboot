package Day_6;


// JPA Entity annotation.
import jakarta.persistence.Entity;

// Specifies the database table name.
import jakarta.persistence.Table;

// Specifies the primary key.
import jakarta.persistence.Id;

// Automatically generates ID values.
import jakarta.persistence.GeneratedValue;

// Strategy used for ID generation.
import jakarta.persistence.GenerationType;


// Tell JPA that this Java class
// represents a database table.
@Entity


// Tell JPA that this entity represents
// the "books" table.
@Table(name = "books")
public class Book {


    // =====================================================
    // ID
    // =====================================================

    // Primary key of the books table.
    @Id


    // MySQL AUTO_INCREMENT.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    // =====================================================
    // TITLE
    // =====================================================

    // Maps to the "title" column.
    private String title;


    // =====================================================
    // ISBN
    // =====================================================

    // Maps to the "isbn" column.
    private String isbn;


    // =====================================================
    // PRICE
    // =====================================================

    // Maps to the "price" column.
    private double price;


    // =====================================================
    // PUBLISHED YEAR
    // =====================================================

    // Maps to "published_year".
    //
    // Java variable uses camelCase.
    // Database column uses snake_case.
    @jakarta.persistence.Column(name = "published_year")
    private int publishedYear;


    // =====================================================
    // AUTHOR ID
    // =====================================================

    // Maps to the author_id column.
    @jakarta.persistence.Column(name = "author_id")
    private int authorId;


    // =====================================================
    // Empty Constructor
    // =====================================================

    // Required by JPA.
    public Book() {

    }


    // =====================================================
    // Getters and Setters
    // =====================================================

    // Get ID.
    public int getId() {
        return id;
    }


    // Set ID.
    public void setId(int id) {
        this.id = id;
    }


    // Get title.
    public String getTitle() {
        return title;
    }


    // Set title.
    public void setTitle(String title) {
        this.title = title;
    }


    // Get ISBN.
    public String getIsbn() {
        return isbn;
    }


    // Set ISBN.
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    // Get price.
    public double getPrice() {
        return price;
    }


    // Set price.
    public void setPrice(double price) {
        this.price = price;
    }


    // Get published year.
    public int getPublishedYear() {
        return publishedYear;
    }


    // Set published year.
    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }


    // Get author ID.
    public int getAuthorId() {
        return authorId;
    }


    // Set author ID.
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}