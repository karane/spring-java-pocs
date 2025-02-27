package org.karane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeanScopeExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Singleton Scope
        System.out.println("\n1. Fetching Singleton Beans:");
        SingletonBean s1 = context.getBean(SingletonBean.class);
        SingletonBean s2 = context.getBean(SingletonBean.class);
        System.out.println("\ts1 == s2: " + (s1 == s2));

        // Prototype Scope
        System.out.println("\n2. Fetching Prototype Beans:");
        PrototypeBean p1 = context.getBean(PrototypeBean.class);
        PrototypeBean p2 = context.getBean(PrototypeBean.class);
        System.out.println("\tp1 == p2: " + (p1 == p2));
    }
}
