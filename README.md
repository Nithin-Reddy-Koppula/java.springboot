# Day 10 - Book API

A Spring Boot REST API for managing books.

## Project Overview

This project is the Day 10 version of the Book API.

The main goals of Day 10 are:

- API documentation using Swagger
- Exception handling
- Unit testing with JUnit 5 and Mockito
- Controller testing with MockMvc
- Database testing with Spring Boot
- Environment variables for database credentials
- Maven packaging
- Running the application as a JAR
- Final API regression testing

---

# Tech Stack

- Java 17
- Spring Boot 3.5.6
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- JUnit 5
- Mockito
- Swagger / OpenAPI

---

# Project Structure

```text
src
├── main
│   ├── java
│   │   └── Day_10
│   │       ├── config
│   │       │   └── OpenApiConfig.java
│   │       │
│   │       ├── controller
│   │       │   └── BookController.java
│   │       │
│   │       ├── entity
│   │       │   └── Book.java
│   │       │
│   │       ├── exception
│   │       │   ├── GlobalExceptionHandler.java
│   │       │   └── ResourceNotFoundException.java
│   │       │
│   │       ├── repository
│   │       │   └── BookRepository.java
│   │       │
│   │       ├── service
│   │       │   └── BookService.java
│   │       │
│   │       └── Day10Application.java
│   │
│   └── resources
│       └── application.properties
│
└── test
    └── java
        └── Day_10
            ├── controller
            │   └── BookControllerTest.java
            │
            └── service
                └── BookServiceTest.java