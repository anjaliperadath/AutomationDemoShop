package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.PageActions;

public class EmailPage extends PageActions{

WebDriver driver;
	
	public EmailPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
}
	
	@FindBy(css=".product-title a") 
	private WebElement searchedProduct2;//to locate Black & White diamond Heart

	@FindBy(css="[value='Email a friend']") 
	private WebElement emailAFriendBtn;//to locate Email A Friend Button
	
	@FindBy(id="FriendEmail")// to locate enter Friend's email Textbox
	private WebElement enterEmailTextBox;
	
	@FindBy(css="[value='Send email']") 
	private WebElement sendEmailBtn;//to locate send Email button
	
	@FindBy(xpath="//*[@class='page-body']/div[2]") 
	private WebElement emailAlertMsg;// to locate "Your Message has been sent"
		
	public void clickOnProduct() {
		clickElement(searchedProduct2);//to click on Black & White diamond Heart
		clickElement(emailAFriendBtn);//to click on Email A Friend Button		
	}
	 
	public void sendEmailToFriend(String friendEmail) {
		setTextBox(enterEmailTextBox,friendEmail); //to enter friends mail id 
		clickElement(sendEmailBtn);//to click on send Email button			
	}
	
	public String getEmailAlertMsg() {
		String text= getElementText(emailAlertMsg);// to get text of "Your Message has been sent"
		return text;
	}
}
