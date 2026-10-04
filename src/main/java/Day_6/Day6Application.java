package Day_6;

// SpringApplication is used to start Spring Boot.
import org.springframework.boot.SpringApplication;

// This annotation enables Spring Boot auto-configuration
// and component scanning.
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Main Spring Boot application class.
@SpringBootApplication
public class Day6Application {


    // Java starts execution from main().
    public static void main(String[] args) {


        // Start the Spring Boot application.
        SpringApplication.run(
                Day6Application.class,
                args
        );
    }
}