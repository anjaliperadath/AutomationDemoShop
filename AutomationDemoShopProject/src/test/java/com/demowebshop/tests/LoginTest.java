package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest { //extended parent class BaseTest

	@Test
	public void verifyUserIsAbleToLoginWithValidCreds() {
		
		 
       String actualEmail=loginPage.login(prop.getProperty("email"), prop.getProperty("password")); // actual email and password
		 
		 String expectedEmail = homePage.getLoggedEmail(); // to get logged email ie the email that is logged in
		 
		 Assert.assertEquals(actualEmail,expectedEmail , "Email did not match"); // to check if actualEmail=expectedEmail
		    
	}
}
