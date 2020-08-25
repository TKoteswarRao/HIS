package com.his;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HISApplication {

	public static void main(String[] args) {
		SpringApplication.run(HISApplication.class, args);
	}
}
