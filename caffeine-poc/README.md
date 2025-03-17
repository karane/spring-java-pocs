# Spring Boot Caffeine Cache POC

This project demonstrates how to use **Caffeine Cache** in a Spring Boot application with REST endpoints.

## Features
- Uses **Caffeine Cache** for efficient in-memory caching.
- Implements `@Cacheable`, `@CachePut`, and `@CacheEvict` annotations.
- Provides a REST API to interact with the cached data.

## Technologies Used
- **Spring Boot**
- **Caffeine Cache**
- **Spring Web**
- **Maven**

## Setup & Run

### Prerequisites
- Java 17+
- Maven

### Steps to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/karane/spring-java-pocs 
   ```
2. Navigate to the project directory:
   ```sh
   cd caffeine-poc
   ```
3. Build and run the application:
   ```sh
   mvn spring-boot:run
   ```
## API Endpoints

| Method | Endpoint       | Description                         |
|--------|---------------|-------------------------------------|
| GET    | `/users/{id}` | Retrieves a user (caches result).  |
| PUT    | `/users/{id}` | Updates a user (updates cache).    |
| DELETE | `/users/{id}` | Deletes a user (removes from cache). |removes from cache).
 
## How Caching Works
   `@Cacheable("users")`: Caches the response of getUserById(id).
   `@CachePut("users")`: Updates cache when updateUser(id) is called.
   `@CacheEvict("users")`: Removes user from cache when deleteUser(id) is called. 
   
## Testing the API
   1. **Fetch a user (first call will be slow, subsequent calls will be cached):**<br>
    ```sh
    curl -X GET http://localhost:8080/users/1
    ```
   2. **Update a user (updates the cache):**<br>
    ```sh
    curl -X PUT http://localhost:8080/users/1
    ```
   3. **Delete a user (removes from cache):**<br>
    ```sh
    curl -X DELETE http://localhost:8080/users/1
    ```
   