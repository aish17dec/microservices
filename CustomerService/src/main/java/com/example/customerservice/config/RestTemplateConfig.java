package com.example.customerservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced //If this is not added, it will give ResourceNotFoundException, UnknownHostException
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
