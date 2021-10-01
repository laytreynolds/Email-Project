package com.qa.emailapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
		
		Email user1 = new Email("Layton", "Reynolds");
		
		System.out.println(user1.showInfo());
		
	}

}
