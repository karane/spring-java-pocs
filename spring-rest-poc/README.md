# Spring Boot REST API Example

## Overview
This project demonstrates a simple REST API built using Spring Boot with all HTTP verbs.

## Requirements
- Java 17+
- Maven

## How to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/example/springboot-rest-api.git
   cd springboot-rest-api
   ```
2. Build the project:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```
4. Test the API:
   Open a browser or use curl/Postman:
   ```sh
   curl http://localhost:8080/api/items
   curl -X POST -H "Content-Type: application/json" -d '{"id":1, "value":"Sample"}' http://localhost:8080/api/items
   curl -X GET "http://localhost:8080/api/items/1"
   curl -X PUT "http://localhost:8080/api/items/1?value=Updated"
   curl -X DELETE "http://localhost:8080/api/items/1"
   ```

## Technologies Used
- Spring Boot
- Maven
- Java 17+