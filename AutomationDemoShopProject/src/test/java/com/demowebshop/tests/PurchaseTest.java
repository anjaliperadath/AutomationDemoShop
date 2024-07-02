package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class PurchaseTest extends BaseTest {
		
	@Test
	public void verifyUserIsAbleToBuyAProduct() {
		
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String password= faker.internet().password();
		
		loginPage.navigateToRegisteration(); // to navigate to register button and to click on the register button
		registerPage.createUser(firstName,lastName, email, password, password);//to create user filling these fields with values from faker
		
		loginPage.searchItem(prop.getProperty("itemToSearch"));//to search for item in LoginPage "diamond"
		String actualPrice=productPage.addTocart().navigateToCart();//to click on "add to cart" button & navigate to cart(both methods with the object returned)
		String expectedPrice=shoppingPage.validateShoppingCartPrice();//the price at the checkout "Total"
		Assert.assertEquals(actualPrice, expectedPrice, "Price difference in cart");// to check if actualPrice=expectedPrice	
		shoppingPage.checkoutProduct(prop.getProperty("country")); //to select country canada from dropdown list
		shoppingPage.clickOnCheckBox();
	}
}
