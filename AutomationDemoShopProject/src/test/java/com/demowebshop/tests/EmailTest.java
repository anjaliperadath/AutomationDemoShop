package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailTest extends BaseTest{
	
	@Test
	public void verifyUserIsAbleToEmailAFriend() {
		
		loginPage.login(prop.getProperty("email"), prop.getProperty("password")); // to login
		loginPage.searchItem(prop.getProperty("itemToSearch")); //to search item diamond & click the search button
		emailPage.clickOnProduct();//to click on Black & White diamond Heart & Email A Friend Button	
		emailPage.sendEmailToFriend(prop.getProperty("friendEmail")); // to enter friends mail id & send Email button	
		String actualMsg= emailPage.getEmailAlertMsg();//// to get text of "Your Message has been sent"
		Assert.assertEquals(actualMsg,"Your message has been sent.", "Alert Message did not match" );
	}
}
