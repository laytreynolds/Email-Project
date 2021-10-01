package com.example.EmailApplicationInterface;

import java.util.Scanner;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String password;
	private String department;	
	private String email;	
	private int defaultPasswordLength = 10;
	private String companySuffix = "QA.com";


	
	public Email(String firstName, String lastName) {
	
	this.firstName = firstName;
	this.lastName = lastName;
	
	System.out.println("New email being created for: " + this.firstName + " " + this.lastName);
	System.out.println("=".repeat(40));

	
	this.department = setDepartment();
	System.out.println("Department: " + this.department);
	
//	return password
	this.password = randomPassword(defaultPasswordLength);
	
	System.out.println("=".repeat(40));
	System.out.println("Your password is: " + this.password);
	System.out.println("=".repeat(40));

	
//	combine to generate email
	
	email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	
	System.out.println(email);
	
}


//Generate random password

private String randomPassword(int length) {
	String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ012345679.!#&$*@";
	
	char[] password = new char[length]; 
	for (int i=0; i<length; i++) {
	int rand = (int) (Math.random() * passwordSet.length());			
	password[i] = passwordSet.charAt(rand);
	}
	
	return new String(password);
	
}


////ask for department

private String setDepartment() {
	
	System.out.print("DEPARTMENT CODES: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department Code: "); // menu option
	
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in); // user input
	
	int depChoice = in.nextInt(); // department choice = user input
	
// department choice logic
	if (depChoice == 1) { return "sales"; } 
		else if ( depChoice == 2) { return "Dev"; }
		else if (depChoice == 3) { return "Acct"; }
		else { return "";}
	
}


public String showInfo() {
	return ("Name: " + firstName + " " + lastName + "\n" +
		   "Email: " + email);
}

}

