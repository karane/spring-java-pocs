# Spring Core IoC Example

This is a simple Spring Core Inversion of Control (IoC) example using Java-based configuration.

## Prerequisites
- Java 17+
- Maven 3.6+

## Project Structure
```
├── src/main/java/org/karane
│   ├── AppConfig.java
│   ├── GreetingService.java
│   ├── Person.java
│   └── Main.java
├── pom.xml
```

## How to Run
1. Compile the project:
   ```sh
   mvn clean package
   ```
2. Run the application:
   ```sh
   mvn exec:java -Dexec.mainClass="org.karane.Main"
   ```
