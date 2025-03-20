package org.karane;

public class GreetingConstructor {
    private final String message;

    // Constructor Injection
    public GreetingConstructor(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}