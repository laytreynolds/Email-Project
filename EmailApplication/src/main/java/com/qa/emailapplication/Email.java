package com.qa.emailapplication;

import java.util.Objects;

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
	private int defaultPasswordLength = 10;
	private String companySuffix = "QA.com";

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getDefaultPasswordLength() {
		return defaultPasswordLength;
	}

	public void setDefaultPasswordLength(int defaultPasswordLength) {
		this.defaultPasswordLength = defaultPasswordLength;
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
				+ ", department=" + department + ", email=" + email + ", defaultPasswordLength=" + defaultPasswordLength
				+ ", companySuffix=" + companySuffix + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(companySuffix, defaultPasswordLength, department, email, firstName, id, lastName, password);
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
		return Objects.equals(companySuffix, other.companySuffix)
				&& defaultPasswordLength == other.defaultPasswordLength && Objects.equals(department, other.department)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password);
	}

}
