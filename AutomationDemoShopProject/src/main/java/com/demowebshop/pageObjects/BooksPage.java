package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.PageActions;

public class BooksPage extends PageActions {
	
WebDriver driver;
	
	public BooksPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
}
	

	@FindBy(xpath= "//ul[@class='top-menu'][1]/li/a" ) // to grab the "Books" category
	private WebElement Books;
	
	@FindBy(id="products-orderby")// to locate the "SortBy" dropdown
	private WebElement sortbyDropdown;
	
	@FindBy(id="products-pagesize")// to locate the "Display" dropdown
	private WebElement displayDropdown;
	
	@FindBy(id="products-viewmode")// to locate the "ViewAs" dropdown
	private WebElement viewAsDropdown;
	
	@FindBy(xpath= "//div[@class='filter-content']/ul/li/a" ) // to grab the "Books" category
	private WebElement filterUnder25;
	
	@FindBy(xpath="//*[@value='Add to cart']")//to locate "Add to cart" button of "HealthBook" product
	private WebElement addToCartBtnBook;
	
	@FindBy(xpath= "//*[@class='prices']/span[2]" ) // to grab the rate of book
	private WebElement bookRate;
	
	@FindBy(xpath= "//*[@id='topcartlink']/a/span" ) // to grab the ShoppingCart button
	private WebElement shoppingCartBtn;
	
	@FindBy(xpath= "//*[@class='subtotal nobr end']/span[2]" ) // to grab the final rate
	private WebElement finalBookRate;
	
		
	public void clickOnBooks() {
		clickElement(Books);// to click on "Books" category
	}
	
	public void checkoutDropdown(String sortby,String display,String viewAs) { 
		selectDropdownByVisibleText(sortbyDropdown,sortby );// in the sortbyDropdown pass sortby
		selectDropdownByVisibleText(displayDropdown,display );// in the displayDropdown pass sortby
		selectDropdownByVisibleText(viewAsDropdown,viewAs );// in the viewAsDropdown pass sortby
	}
	
	
	public void clickOnFilter() {
		clickElement( filterUnder25);//to click on under25
	}
	
	public void addTocartBook() {
		clickElement(addToCartBtnBook);//to click on "add to cart" button of "HealthBook" product
	}

	public String originalRateOfBook() {
		String rate=getElementText(bookRate);// to get original price of product(here 10 rs)
		clickElement(shoppingCartBtn); //to click on ShoppingCart button
		return rate;
	}
	
	public String finalRateofBook() {
		String finalRate= getElementText(finalBookRate);// to get final rate of product added in cart
		return finalRate;
	}			
}
