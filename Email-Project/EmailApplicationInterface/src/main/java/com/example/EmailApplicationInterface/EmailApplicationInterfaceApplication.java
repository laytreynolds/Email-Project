package com.example.EmailApplicationInterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailApplicationInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailApplicationInterfaceApplication.class, args);
		
		Email user1 = new Email("Layton", "Reynolds");
		
		System.out.println(user1.showInfo());
		
	}

}
