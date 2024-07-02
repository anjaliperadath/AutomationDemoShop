package com.demowebshop.model;

public class Person {

	public String firstName, lastName, email, password, confirmPassword;// making parameters public so all classes can access it

	public Person(String firstName, String lastName, String email, String password, String confirmPassword) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
}
