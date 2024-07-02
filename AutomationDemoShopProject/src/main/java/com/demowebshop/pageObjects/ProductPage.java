package com.demowebshop.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.PageActions;

public class ProductPage extends PageActions {

WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".product-title a") //to locate all 4 items of diamond with this common parent class path
	private List <WebElement> searchedProduct; //  and get their list 
	
	@FindBy(xpath="//*[@value='Add to cart']")//to locate "Add to cart" button of "Black and white diamond heart" product
	private WebElement addToCartBtn;
	
	@FindBy(css=".ico-cart .cart-label")// to locate the Shopping Cart(1) header
	private WebElement shoppingCartHeader;
	
	@FindBy(css="[value='Go to cart']")// to locate Go to cart button inside the Shopping cart(1)
	private WebElement goToCartBtn;
	
	@FindBy(css=".ico-cart .cart-qty")// to locate the number in Shopping Cart(0) header
	private WebElement qty;
	
	@FindBy(xpath="//*[@value='Add to cart']/../preceding-sibling::*/span")// to locate the price of product added in cart (here 130 rs)
	private WebElement priceOfProduct;
	
	
	public List<String> validateSearchedItemsAppearAppropriately() {
	return getTextContentList(searchedProduct); // to obtain the list of the diamonds products
	
}
	
	public ProductPage addTocart() {
		clickElement(addToCartBtn);//to click on "add to cart" button
		return this;//the current object will be returned
	}

	public String navigateToCart() {
		String price=getElementText(priceOfProduct);// to get price of product added in cart (here 130 rs)
		waitForTextPresentInElement(qty, "(1)");//wait for the qty to become 1
		hoverOverItem(shoppingCartHeader); // to hoverover on Shopping Cart(1) header
		clickElement(goToCartBtn); // to click Go to cart button inside the Shopping cart(1)
		return price;// as we want to perform assertion and check
	}
	
}
