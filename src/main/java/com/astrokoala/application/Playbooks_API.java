package com.astrokoala.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Playbooks_API {

	public static void main(String[] args) {
		Config.connectToDatabase();
		SpringApplication.run(Playbooks_API.class, args);
	}

}
