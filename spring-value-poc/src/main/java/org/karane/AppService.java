package org.karane;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppService {
    
    @Value("${app.name:Default App Name}")
    private String appName;
    
    @Value("${app.version:0.0.1}")
    private String appVersion;
    
    @Value("${external.property:Default External Value}")
    private String externalProperty;
    
    @Value("${missing.property:Fallback Value}")
    private String fallbackValue;
    
    @Value("${cli.property:Default CLI Value}")
    private String cliProperty;
    
    public void printAppDetails() {
        System.out.println("Application Name: " + appName);
        System.out.println("Application Version: " + appVersion);
        System.out.println("External Property: " + externalProperty);
        System.out.println("Fallback Property: " + fallbackValue);
        System.out.println("CLI Property: " + cliProperty);
    }
}