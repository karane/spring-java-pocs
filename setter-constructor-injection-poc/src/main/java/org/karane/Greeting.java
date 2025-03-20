package org.karane;

public class Greeting {
    private String message;

    // Setter Injection
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}