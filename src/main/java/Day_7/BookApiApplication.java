package Day_7;
// This tells Java that BookApiApplication belongs
// to the Day_7 package.


import org.springframework.boot.SpringApplication;
// SpringApplication is used to start the Spring Boot application.


import org.springframework.boot.autoconfigure.SpringBootApplication;
// @SpringBootApplication enables Spring Boot configuration,
// auto-configuration and component scanning.


@SpringBootApplication
// This tells Spring Boot:
//
// 1. This is the main Spring Boot application.
// 2. Automatically configure required components.
// 3. Scan this package and its sub-packages.
//
// Since this class is inside Day_7,
// Spring will scan:
//
// Day_7
// Day_7.controller
// Day_7.service
// Day_7.repository
// Day_7.entity
public class BookApiApplication {


    public static void main(String[] args) {

        // Java starts execution from this main() method.

        SpringApplication.run(
                BookApiApplication.class,
                args
        );

        // Starts the Spring Boot application.
        //
        // This starts:
        // - Embedded Tomcat
        // - Spring Container
        // - JPA
        // - Hibernate
        // - Database configuration
        // - REST controllers
        // - Repositories
        // - Services
    }
}