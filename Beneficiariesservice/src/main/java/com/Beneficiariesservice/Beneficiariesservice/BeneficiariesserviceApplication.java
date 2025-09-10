package com.Beneficiariesservice.Beneficiariesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//@EnableEurekaClient

@SpringBootApplication
public class BeneficiariesserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeneficiariesserviceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
