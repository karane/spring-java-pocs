package org.karane.bean;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
    public void sayHello() {
        System.out.println("Hello from MyBean!");
    }
}