# Spring Core - Bean Scopes (Singleton, Prototype)

This project demonstrates Spring's bean scopes: `singleton` and `prototype`.

## Requirements
- Java 8 or later
- Maven

## How to Run

```sh
mvn clean compile exec:java -Dexec.mainClass="org.karane.SpringBeanScopeExample"
```

## Explanation
### Bean Scopes
In Spring, a **bean scope** defines the lifecycle and visibility of a bean.

- `@Scope("singleton")`: A **single instance** of the bean is created and shared across the application context.
- `@Scope("prototype")`: A **new instance** of the bean is created each time it is requested from the container.
- `@Scope("request")`: A new instance of the bean is created for each HTTP request (used in web applications).
- `@Scope("session")`: A single instance of the bean is created per HTTP session (used in web applications).
- `@Scope("application")`: A single instance is created per ServletContext lifecycle (shared across the whole web application).

### Singleton Scope
- The default scope in Spring.
- A single instance of the bean is created per Spring IoC container.
- All requests for the bean return the same shared instance.

### Prototype Scope
- A new instance is created each time the bean is requested.
- The container does not manage the complete lifecycle of a prototype-scoped bean (e.g., no automatic destruction).

### Request Scope
- A new bean instance is created for each HTTP request.
- Used in web applications where a separate instance is needed per request.

### Session Scope
- A single bean instance is created per HTTP session.
- Used when maintaining user-specific data throughout a session.

### Application Scope
- A single instance is created per ServletContext lifecycle.
- Shared across multiple requests and sessions within a web application.