# Spring Core Dependency Injection POC

This project demonstrates **Setter Injection** and **Constructor Injection** using Spring Core.

## How to Run
1. **Compile the project**
   ```sh
   mvn compile
   ```
2. **Run the application**
   ```sh
   mvn exec:java -Dexec.mainClass="org.karane.App"
   ```

## Explanation
- `GreetingService`: Uses **Setter Injection** to set a message.
- `GreetingServiceConstructor`: Uses **Constructor Injection** to set a message.
- `applicationContext.xml`: Defines beans and their dependencies.
- `App.java`: Loads Spring Context and retrieves beans.

## Output
```
Hello from Setter Injection!
Hello from Constructor Injection!
```

## Dependencies
- **Spring Core** (spring-context v5.3.30)
- **Maven** for build automation