package com.demowebshop.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class RegisterationDP extends BaseTest {
	
	@Test (dataProvider="getData", groups="Smoke")
	public void verifyUserIsAbleToRegisterThroughDP(String firstName, String lastName, String email, String password) {
		
		loginPage.navigateToRegisteration();// loginPage is an object like obj.method() . with loginPage object we can call this method
		registerPage.createUser(firstName,lastName, email, password, password); //as password and confirm password are same gave it on both place .
		
		Map<String, String> dataMap = registerPage.validateRegisterationPageItems(); // method to check if we get alert message
		Assert.assertEquals(dataMap.get("alertText"), prop.getProperty("registerationMsg"), "Alert did not match" );
		// to check if alertText is same as the expected result given
		Assert.assertEquals(dataMap.get("loggedEmail"), email, "Logged Email is different" );
		// to check if loggedEmail is same as the expected result given
		
		
	}

	@DataProvider
	public String[][] getData() {
		
		Faker faker = new Faker();
		String data[][]= new String[1][4];
		data[0][0]=faker.name().firstName();
		data[0][1]= faker.name().lastName();
		data[0][2]=faker.internet().emailAddress();
		data[0][3]=faker.internet().password();
		
		return data;
		
	}	
}
