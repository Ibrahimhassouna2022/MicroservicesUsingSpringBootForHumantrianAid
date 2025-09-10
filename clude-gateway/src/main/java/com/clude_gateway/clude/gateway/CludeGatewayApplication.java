package com.clude_gateway.clude.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CludeGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CludeGatewayApplication.class, args);
	}

}
