package com.scaler.productservicedecmwfeve.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationsConfiguration {


    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplateBuilder().build();
    }
}
