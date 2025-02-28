package org.karane;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan("org.karane")
@PropertySources({
    @PropertySource("classpath:application.properties"),
    @PropertySource("classpath:config/extra.properties"),
    @PropertySource(value = "file:/etc/config/app.properties", ignoreResourceNotFound = true) //in case it doesn't exist, it won't break
})
public class AppConfig {
}