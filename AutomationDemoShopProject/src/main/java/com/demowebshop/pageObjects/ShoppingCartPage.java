package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.PageActions;

public class ShoppingCartPage  extends PageActions { 

WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css=".product-subtotal") // to grab the Total 130rs
	private WebElement subTotal;
	
	@FindBy(id="CountryId")// to locate the "Select Country" dropdown
	private WebElement countryDropdown;
	
	@FindBy(id="termsofservice")// to locate the I agree checkbox
	private WebElement agreeCheckBox;
	
	@FindBy(id="checkout")// to locate the "checkoutButton" 
	private WebElement checkoutButton;
	
	
	public String validateShoppingCartPrice() { 
		return getElementText(subTotal);//to get the amount and return it to perform assertions
	}
	
	public void checkoutProduct(String country) { 
		selectDropdownByVisibleText(countryDropdown, country);// in the location countryDropdown pass country
	}
	
	public void clickOnCheckBox() { 
		clickElement(agreeCheckBox);//to click on i agree checkbox
		clickElement(checkoutButton);// to click on checkoutButton
	}
}
