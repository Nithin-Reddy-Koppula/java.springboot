package Day_10;

// Imports the SpringApplication class.
// This class is used to start the Spring Boot application.
import org.springframework.boot.SpringApplication;

// Imports the @SpringBootApplication annotation.
// This annotation tells Spring Boot that this is the main application class.
import org.springframework.boot.autoconfigure.SpringBootApplication;


// @SpringBootApplication is a combination of three important annotations:
// 1. @Configuration       -> tells Spring this class contains configuration.
// 2. @EnableAutoConfiguration -> Spring Boot automatically configures required components.
// 3. @ComponentScan       -> Spring searches this package and its sub-packages
//                            for controllers, services, repositories, etc.
@SpringBootApplication
public class Day10Application {

    // The main() method is the starting point of a Java application.
    public static void main(String[] args) {

        // SpringApplication.run() starts the Spring Boot application.
        //
        // Day10Application.class tells Spring which application class to start.
        //
        // args contains command-line arguments passed when starting the application.
        //
        // This line starts:
        // - Spring container
        // - Embedded Tomcat server
        // - Component scanning
        // - Auto configuration
        SpringApplication.run(Day10Application.class, args);
    }
}