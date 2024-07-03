package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class BooksTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToSearchBooksCategory() {
		
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String password= faker.internet().password();
		
		loginPage.navigateToRegisteration(); // to navigate to register button and to click on the register button
		registerPage.createUser(firstName,lastName, email, password, password);//to create user filling these fields with values from faker

		booksPage.navigateToBooks();// to click on "Books" category
		booksPage.checkoutDropdown(prop.getProperty("sortby"),prop.getProperty("display"),prop.getProperty("viewAs"));//to select from Dropdown list
		booksPage.navigateOnFilter();//to click on under25
		booksPage.addTocartBook();
		String actualRate=booksPage.originalRateOfBook();
		String expectedRate=booksPage.finalRateofBook();
		Assert.assertEquals(actualRate, expectedRate, "Rate difference in cart");
	}
	
}
