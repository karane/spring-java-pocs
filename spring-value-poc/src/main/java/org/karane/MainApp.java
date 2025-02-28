package org.karane;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppService appService = context.getBean(AppService.class);
        appService.printAppDetails();
        context.close();
    }
}