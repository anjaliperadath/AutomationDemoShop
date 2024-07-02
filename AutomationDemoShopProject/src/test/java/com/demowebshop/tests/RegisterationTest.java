package com.demowebshop.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.model.Person;
import com.github.javafaker.Faker;

public class RegisterationTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToRegisterWithValidCreds() {
				 		
		Faker faker = new Faker(); // create faker so that we don't need to pass values manually each time
		
		String password= faker.internet().password();
		
		Person person = new Person(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(), password, password);
		// created object and called constructor of Person()
		
		loginPage.navigateToRegisteration();// loginPage is an object like obj.method() . with loginPage object we can call this method
		registerPage.createUser(person.firstName,person.lastName, person.email, person.password, person.confirmPassword);
		// inside method createUser() called obj.parameter i.e. person.firstName etc
		
		Map<String, String> dataMap = registerPage.validateRegisterationPageItems(); // method to check if we get alert message
		Assert.assertEquals(dataMap.get("alertText"), prop.getProperty("registerationMsg"), "Alert did not match" );
		// to check if alertText is same as the expected result given
		Assert.assertEquals(dataMap.get("loggedEmail"), person.email, "Logged Email is different" );
		// to check if loggedEmail is same as the expected result given
		
	}
}
