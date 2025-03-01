package org.karane;

import org.karane.bean.MyBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.karane")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        context.start();
        MyBean myBean = context.getBean(MyBean.class);
        myBean.sayHello();
    }
}