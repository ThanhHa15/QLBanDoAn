package com.asm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PD10637 {

	public static void main(String[] args) {
		SpringApplication.run(PD10637.class, args);
	}

}
