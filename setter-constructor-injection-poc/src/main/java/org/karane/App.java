package org.karane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Greeting setterService = (Greeting) context.getBean("greetingService");
        System.out.println(setterService.getMessage());
        
        GreetingConstructor constructorService = (GreetingConstructor) context.getBean("greetingServiceConstructor");
        System.out.println(constructorService.getMessage());
    }
}
