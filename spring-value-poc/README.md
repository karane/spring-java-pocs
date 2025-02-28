# Spring Core - @Value Annotation Example with Multiple Property Sources

## Introduction
This project demonstrates how to use the `@Value` annotation in Spring Core to inject values from multiple property sources, with support for default values when a property is missing.

## Requirements
- Java 17
- Maven

## Setup & Run
1. Clone the repository.
2. Navigate to the project root.
3. Compile and run the application using:
   ```sh
   mvn clean compile exec:java -Dexec.mainClass=org.karane.MainApp -Dcli.property="Command Line Value"
   ```
4. You should see the output:
   ```
   Application Name: Spring Core Example
   Application Version: 1.0.0
   External Property: External Config Value
   Fallback Property: Fallback Value
   CLI Property: Command Line Value
   ```
   If `/etc/config/app.properties` is not present, Spring will ignore it by default.

## Explanation
- `@PropertySources` is used to load multiple property files.
- `@Value("${property.key:default_value}")` provides a default if the property is missing.
- `application.properties`, `extra.properties`, and an external file `/etc/config/app.properties` are used.
- `-Dcli.property` allows setting values via the command line.
