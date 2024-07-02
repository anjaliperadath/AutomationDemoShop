package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscribeTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToSubscribeNewsLetter() throws InterruptedException {
	
		 
		loginPage.login(prop.getProperty("email"), prop.getProperty("password")); // actual email and password
			
		 String actualAlertMsg = homePage.subcribeNewsLetter(); // gave it in a String
		 Assert.assertEquals(actualAlertMsg, prop.getProperty("subscriptionMsg"), "Alert message not matching");
		 // check if actualAlertMsg = the message we enter
		 
	}
}
