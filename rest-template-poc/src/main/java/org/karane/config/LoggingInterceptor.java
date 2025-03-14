package org.karane.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;

import java.io.IOException;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logger.info("Request: {} {}", request.getMethod(), request.getURI());

        // Proceed with the request
        ClientHttpResponse response = execution.execute(request, body);

        logger.info("Response Status: {}", response.getStatusCode());

        return response;
    }
}
