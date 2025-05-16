# Spring JPA Transaction Management POC

This project demonstrates advanced transaction management in a Spring Boot application using JPA. It covers:

* Declarative and programmatic transaction management
* Rollback rules (e.g., checked vs unchecked exceptions)
* Transaction propagation types 
* Isolation levels 
* Read-only transactions 
* Nested transactions 
* Programmatic transactions via TransactionTemplate 
* Transactional event listeners

## Tech Stack
* Java 17+ 
* Spring Boot 3.x 
* Spring Data JPA 
* H2 in-memory database 
* Maven

## Run the Project
```bash
./mvn spring-boot:run
```

### 1. Trigger Rollback for User Creation
Endpoint: POST /demo/users/rollback
Description: Triggers a rollback in the UserService.createUsersWithRollback() method.

```bash
curl -X POST http://localhost:8080/demo/users/rollback
```
 
### 2. Create Order with REQUIRES_NEW Propagation
Endpoint: POST /demo/orders/requires-new
Description: Attempts to create an order with Propagation.REQUIRES_NEW. Rollback expected.

```bash
curl -X POST http://localhost:8080/demo/orders/requires-new
```

### 3. Create Order with NESTED Propagation
Endpoint: POST /demo/orders/nested
Description: Attempts to create an order in a nested transaction. Rollback expected.

```bash
curl -X POST http://localhost:8080/demo/orders/nested
```

### 4. Create Order with Programmatic Transaction (TransactionTemplate)
Endpoint: POST /demo/orders/programmatic
Description: Attempts to create an order using programmatic transaction management.

```bash
curl -X POST http://localhost:8080/demo/orders/programmatic
```

### 5. Get Stats (User and Order Counts)
Endpoint: GET /demo/stats
Description: Returns the count of users and orders.

```bash
curl http://localhost:8080/demo/stats
```
