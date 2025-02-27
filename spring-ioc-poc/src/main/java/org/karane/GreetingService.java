package org.karane;

import org.springframework.stereotype.Service;

@Service  // Marks this as a Spring-managed component
public class GreetingService {
    public String getGreeting() {
        return "Hello from GreetingService!";
    }
}
