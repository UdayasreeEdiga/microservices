package com.cts.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Stage03AdbDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Stage03AdbDiscoveryServiceApplication.class, args);
	}

}
