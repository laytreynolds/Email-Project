package com.qa.emailapplication;

public class EmailDTO {

	private long id;
	public String firstName;
	public String lastName;
	public String email;
	
	public EmailDTO(Email e) {
		this.id = e.getId();
		this.firstName = e.getFirstName();
		this.lastName = e.getLastName();
		this.email = e.getEmail();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getJumpheight() {
		return email;
	}
	public void setJumpheight(String email) {
		this.email = email;
	}
	
	
	
	
	
	
}