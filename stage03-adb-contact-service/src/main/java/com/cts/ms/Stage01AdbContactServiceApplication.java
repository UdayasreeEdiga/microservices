package com.cts.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Stage01AdbContactServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Stage01AdbContactServiceApplication.class, args);
	}

}
