package com.ewolff.user_registration.domain;

public class User {

	
	private String name;
	
	private String firstname;
	
	private String email;

	public User(String firstname, String name, String email) {
		super();
		this.firstname = firstname;
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getEmail() {
		return email;
	}
	
	
}
