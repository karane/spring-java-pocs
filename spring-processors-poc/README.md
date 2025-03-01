# Spring Processors POC

This project demonstrates various processors and event listeners in Spring Core.

## Included Listeners
- `ContextRefreshedEvent Listener`: Triggered when the application context is refreshed.
- `ContextStartedEvent Listener`: Triggered when the application context starts.

## Common Application Events
- **ContextRefreshedEvent**: Fired when the application context is refreshed.
- **ContextStartedEvent**: Fired when the application context is started using `context.start()`.
- **ContextStoppedEvent**: Fired when the application context is stopped using `context.stop()`.
- **ContextClosedEvent**: Fired when the application context is closed using `context.close()`.
- **ApplicationReadyEvent**: Fired when the application is fully ready.

## Run the Application
```sh
mvn clean compile exec:java -Dexec.mainClass=org.karane.App
```

## Expected Output
```
BeanFactoryPostProcessor executed!
Before Initialization: app
After Initialization: app
Before Initialization: myBean
After Initialization: myBean
Before Initialization: contextStartedListener
After Initialization: contextStartedListener
Before Initialization: customApplicationListener
After Initialization: customApplicationListener
ApplicationListener executed on context refresh!
ContextStartedEvent triggered!
Hello from MyBean!

```