package org.karane;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.karane")  // Automatically scans for @Component, @Service, etc.
public class AppConfig {
}
