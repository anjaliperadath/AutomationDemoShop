package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.PageActions;

public class WishlistPage extends PageActions {
	
WebDriver driver;
	
	public WishlistPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
}

	@FindBy(css=".product-title a") 
	private WebElement searchedProduct2;//to locate Black & White diamond Heart
	
	@FindBy(id="add-to-wishlist-button-14")
	private WebElement addToWishlistBtn;//to locate Add To Wishlist Button
	
	@FindBy(xpath="//a[@class='ico-wishlist']/span[1]")
	private WebElement wishlistBtn;// to locate Wishlist button on Header
	
	@FindBy(xpath="//td[@class='product']/a")
	private WebElement finalProductName; //to locate final name of product added in wishlist
	
	
	public String originalProductName() {
		String nameText=getElementText(searchedProduct2);// to get original name of product(here Black & White diamond Heart)
		clickElement(searchedProduct2); //to click on Black & White diamond Heart
		clickElement(addToWishlistBtn);//to click on Add To Wishlist button
		clickElement(wishlistBtn);//to click on Wishlist button on Header
		return nameText;		
	}
	
	public String finalProductName() {
		String nameText2= getElementText(finalProductName);// to get final name of product added in wishlist
		return nameText2;
	}	
}
