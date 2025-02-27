package org.karane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  // Marks this as a Spring-managed component
public class Person {

    private final GreetingService greetingService;

    @Autowired  // Constructor-based Dependency Injection
    public Person(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void sayHello() {
        System.out.println(greetingService.getGreeting());
    }
}
