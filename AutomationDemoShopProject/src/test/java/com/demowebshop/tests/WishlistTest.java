package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class WishlistTest extends BaseTest  {

	@Test
	public void verifyUserIsAbleToAddItemToWishlist() {
		
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String password= faker.internet().password();
		
		loginPage.navigateToRegisteration(); // to navigate to register button and to click on the register button
		registerPage.createUser(firstName,lastName, email, password, password);//to create user filling these fields with values from faker
		loginPage.searchItem(prop.getProperty("itemToSearch")); //to search item diamond & click the search button
		String actualProdName= wishlistPage.originalProductName();
		String expectedProdName= wishlistPage.finalProductName();
		Assert.assertEquals(actualProdName,expectedProdName, "Product name did not match" );
		
	}
	
}
