# Spring Boot Integration Testing POC

This project demonstrates how to perform **integration testing** with **Spring Boot** and **MockMvc**.

## Features

- Full Spring Boot application using H2 in-memory database
- Integration tests with `@SpringBootTest` and `@AutoConfigureMockMvc`
- RESTful endpoints tested with MockMvc
- Validation with `@NotBlank`
- Error handling and assertions

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (for testing)
- JUnit 5
- MockMvc
- Maven

## Running the Application

```bash
mvn spring-boot:run
```

## Running the Tests (This is the most important)

```bash
mvn test
```
