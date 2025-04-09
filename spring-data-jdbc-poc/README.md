# Spring Data JDBC

This project demonstrates the use of Spring Data JDBC with a PostgreSQL database.
It provides a simple REST API to manage User entities using:

- Spring Data JDBC
- PostgreSQL (via Docker Compose)

---

## How to Run
### Prerequisites
- Java 17+ 
- Maven 
- Docker

### Run Docker compose
```bash
docker-compose up --build -d
```
**Observation**: In case you want to rebuild it from scratch
```bash
docker-compose down -v
docker-compose up --build -d
```

### Build and Run Spring Boot Application

```bash
mvn spring-boot:run
```

---

## Test REST API with curl

### List all users

```bash
curl -X GET http://localhost:8080/users
```

### Get user by ID

```bash
curl -X GET http://localhost:8080/users/1
```

### Create a new user (without role)

```bash
curl -X POST http://localhost:8080/users \
     -H "Content-Type: application/json" \
     -d '{"name":"Alice Smith", "email":"alice@example.com"}'
```

### Create User with existing role_id
```bash
curl -X POST http://localhost:5000/users \
-H "Content-Type: application/json" \
-d '{
"name": "Alice",
"email": "alice@example.com",
"roleId": 1
}'
```

### Create User with Role Name (role created if it doesn't exist)
```bash
curl -X POST http://localhost:5000/users/create-with-role \
-H "Content-Type: application/json" \
-d '{
"name": "Bob",
"email": "bob@example.com",
"roleName": "Admin"
}'
```

### Update an existing user

```bash
curl -X PUT http://localhost:8080/users/1 \
     -H "Content-Type: application/json" \
     -d '{"name":"Updated Name", "email":"updated@example.com"}'
```

### Delete a user

```bash
curl -X DELETE http://localhost:8080/users/1
```

---

