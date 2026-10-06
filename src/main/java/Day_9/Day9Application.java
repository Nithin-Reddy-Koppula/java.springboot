package Day_9;

// Imports Spring Boot's main application annotation.
import org.springframework.boot.SpringApplication;

// Imports the annotation that enables Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication;


// @SpringBootApplication is a combination of:
//
// @Configuration
// @EnableAutoConfiguration
// @ComponentScan
//
// It tells Spring Boot:
// "This is the main application class."
@SpringBootApplication
public class Day9Application {

    // Main method.
    // Java starts execution from here.
    public static void main(String[] args) {

        // Starts the Spring Boot application.
        //
        // Day9Application.class tells Spring
        // which application configuration to use.
        //
        // args contains command-line arguments.
        SpringApplication.run(Day9Application.class, args);
    }
}