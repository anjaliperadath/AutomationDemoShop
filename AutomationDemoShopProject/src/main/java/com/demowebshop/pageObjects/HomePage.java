package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.PageActions;
import com.demowebshop.Utils.UniqueGenerator;

public class HomePage extends PageActions {
	
WebDriver driver;
	//	Create the parameterized constructor just like in the LoginPage
	public HomePage(WebDriver driver) {
	    super(driver);//super() can be used to invoke immediate parent class constructor 
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//*[@class='header-links']//a)[1]") // obsqura24@gmail.com xpath
	private WebElement loggedEmail;
	
	@FindBy(id="newsletter-email")  // to locate the place to write email id to subscribe newsletter
	private WebElement newsLetterEmail;
	
	@FindBy(id="newsletter-subscribe-button") // to locate Subscribe button
	private WebElement newsLetterSubscribeBtn;
	
	@FindBy(id="newsletter-result-block") //To locate alert message after subscription.
	private WebElement newsLetterAlertMsg;
		
	      public String getLoggedEmail() {
	    	  return getElementText(loggedEmail); // to get the text of email
	}
	
	
	      public String subcribeNewsLetter() throws InterruptedException  {
	    
	        setTextBox(newsLetterEmail,UniqueGenerator .getUniqueEmail()); // classname.methodname to get unique mail id each time 
	  		clickElement(newsLetterSubscribeBtn); // to click subscribe button
	  		Thread.sleep(2000);//to wait for 2 seconds for alert message of subscription to appear 
	  		return getElementText(newsLetterAlertMsg);// to get the text of alert message after subscription
		      // used return to return the value in other class	    	  
	     
	      }
	
}
