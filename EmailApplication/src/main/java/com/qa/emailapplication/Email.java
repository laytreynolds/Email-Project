package com.qa.emailapplication;

import java.util.Objects;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String password;
	private String department;	
	private String email;	
	@Column(columnDefinition = "integer default 500")
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	@Column(columnDefinition = "varchar(255) default 'QA.com")
	private String companySuffix = "QA.com";
	
	
	
//	constructor to first and last name
	
	public Email() {
		super();
	}
	
	
	public Email(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		System.out.println("New email being created for: " + this.firstName + " " + this.lastName);
		System.out.println("=".repeat(40));

		
		this.department = setDepartment();
//		System.out.println("Department: " + this.department);
		
	//	return password
		this.password = randomPassword(defaultPasswordLength);
		
		System.out.println("=".repeat(40));
		System.out.println("Your password is: " + this.password);
		System.out.println("=".repeat(40));

		
//		combine to generate email
		
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		
//		System.out.println(email);
		
	}
	
	
//	Generate random password
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ012345679.!#&$*@";
		
		char[] password = new char[length]; 
		for (int i=0; i<length; i++) {
		int rand = (int) (Math.random() * passwordSet.length());			
		password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
		
	}
	

//	ask for department
	
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
			   "Email: " + email + "\n" +
			   "Mailbox Capacity: " + mailboxCapacity);
	}
	
	public long getId() {
		return id;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	
	
//	set mailbox capacity
	public void setMailbox(int capacity) {
		this.mailboxCapacity = capacity;
	}
		
	
//	set alternate email
	public void alternateEmail(String altEmail){
		this.alternateEmail = altEmail;	
	}
	
//	 change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}
	public int getDefaultPasswordLength() {
		return defaultPasswordLength;
	}
	public void setDefaultPasswordLength(int defaultPasswordLength) {
		this.defaultPasswordLength = defaultPasswordLength;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	public String getCompanySuffix() {
		return companySuffix;
	}
	public void setCompanySuffix(String companySuffix) {
		this.companySuffix = companySuffix;
	}


	@Override
	public String toString() {
		return "Email [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", department=" + department + ", email=" + email + ", mailboxCapacity=" + mailboxCapacity
				+ ", defaultPasswordLength=" + defaultPasswordLength + ", alternateEmail=" + alternateEmail
				+ ", companySuffix=" + companySuffix + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(alternateEmail, companySuffix, defaultPasswordLength, department, email, firstName, id,
				lastName, mailboxCapacity, password);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(alternateEmail, other.alternateEmail)
				&& Objects.equals(companySuffix, other.companySuffix)
				&& defaultPasswordLength == other.defaultPasswordLength && Objects.equals(department, other.department)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && mailboxCapacity == other.mailboxCapacity
				&& Objects.equals(password, other.password);
	}
	
	
	
	
	
	

}
