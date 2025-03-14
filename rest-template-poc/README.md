# Spring Boot RestTemplate POC

This project demonstrates how to use `RestTemplate` in a Spring Boot application to make HTTP requests to external APIs.

## Features
- **GET Request** 
- **POST Request**
- **PUT Request**
- **DELETE Request**
- **Using `exchange()` for custom headers**
- **Setting timeouts in `RestTemplate`**
- **Using interceptors for logging requests**

## Running the App
Run the application
```sh
mvn clean package
mvn spring-boot:run
```

## 🚀 API Usage
1. **GET Request (Basic)**
    ```sh
    curl http://localhost:8080/api/post/1
    ```

2. **POST Request**
    ```sh
    curl -X POST http://localhost:8080/api/post \
    -H "Content-Type: application/json" \
    -d '{"title":"New Post","body":"Post content","userId":1}'
    ```
3. **PUT Request**
    ```sh
    curl -X PUT http://localhost:8080/api/post/1 \
    -H "Content-Type: application/json" \
    -d '{"title":"Updated Title","body":"Updated content","userId":1}'
    ```
4. **DELETE Request**
    ```sh
    curl -X DELETE http://localhost:8080/api/post/1
    ```
5. **GET Request Using exchange()**
    ```sh
    curl -X GET http://localhost:8080/api/post-with-headers/1 \
    -H "Custom-Header: Value"
    ```
