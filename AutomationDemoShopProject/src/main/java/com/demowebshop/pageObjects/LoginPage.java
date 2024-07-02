package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.PageActions;

public class LoginPage extends PageActions {

     WebDriver driver; //make as instance variable 
     // send this driver to below driver so that it will get life and it can find elements by @FindBy
	 //This is parameterized constructor :to call driver into this constructor and this class so that the elements can be found , by @FindBy
	 public LoginPage(WebDriver driver) {  // instead of this driver we can give any name // parameterized constructor in Loginpage
	     
		 super(driver);//super() can be used to invoke immediate parent class constructor 
		 this.driver= driver; //instance variable is assigned to local variable.
		PageFactory.initElements(driver, this); //PageFactory is a class in selenium library which will each time freshly take the elements.
		// always initialize "driver" to "this" 
	}
	
		
	@FindBy(css="[class='ico-login']") // To click log in
	private WebElement loginHeader; // name of WebElement is loginHeader , private means it cannot be changed by anyone simply
	// loginHeader is any name we can give anything
	
	@FindBy(id="Email") // To enter email
	private WebElement emailInput;
	
	@FindBy(xpath="//input[@id='Password']") // To enter password
	private WebElement passwordInput;
	
	@FindBy(xpath="//*[@class='buttons']/input[@value='Log in']") // To click log in button
	private WebElement loginBtn;
	// can findby xpath, id, css etc
	
	@FindBy(css = "[class='ico-register']") // to locate register button
	private WebElement registerHeader;
	
	@FindBy(id = "small-searchterms")// to locate search button in loginpage
	private WebElement searchInputBox;
	
	@FindBy(css = "[value='Search']") // to locate on "search" button
	private WebElement searchBtn;
	
	public String login(String email, String password) { // pass parameters
		clickElement(loginHeader); 
		setTextBox(emailInput, email); //whatever email we give 
		setTextBox(passwordInput, password); // whatever password we give
		clickElement(loginBtn);	
		return email; // returning it to get it in other class
	}
	
	public void navigateToRegisteration() { // to navigate to register button
		clickElement(registerHeader); // to click on the register button
		
	}
	
	public void searchItem(String item) {
		setTextBox(searchInputBox, item); // to search the item whichever
		clickElementJavaScript(searchBtn);// to click search button
		
	}
}
