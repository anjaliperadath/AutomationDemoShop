package com.demowebshop.pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.PageActions;

public class RegisterPage extends PageActions {
	
WebDriver driver;
	//	Create the parameterized constructor just like in the LoginPage
	public RegisterPage(WebDriver driver) {
	    super(driver);//super() can be used to invoke immediate parent class constructor 
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "gender-male") // to locate male checkbox
	private WebElement maleCheckbox;

	@FindBy(id = "FirstName") //to locate firstname field
	private WebElement firstName;

	@FindBy(id = "LastName")  //to locate lastname field
	private WebElement lastName;

	@FindBy(id = "Email")   //to locate email field
	private WebElement email;

	@FindBy(id = "Password")    //to locate password field
	private WebElement password;

	@FindBy(id = "ConfirmPassword")  //to locate confirm password field
	private WebElement confirmPassword;
    
	@FindBy(id = "register-button") // to click on register button
	private WebElement registerBtn;
	
	@FindBy(css = ".result") // to locate “Your registration is complete” alert message
	private WebElement alertMsg;
	
	@FindBy(xpath = "(//*[@class='header-links']//a)[1]") // to locate the logged in mail id
	private WebElement loggedEmail;
	
	public void createUser(String firstNameVal, String lastNameVal, String emailVal, String passwordVal,String ConfirmPassVal) {
		// Pass parameters in the method , we are not hardcoding
		
		clickElement(maleCheckbox); // to click on the check box
		setTextBox(firstName, firstNameVal); /// to give their value, we are not hardcoding 
		setTextBox(lastName, lastNameVal);
		setTextBox(email, emailVal);
		setTextBox(password, passwordVal);
		setTextBox(confirmPassword, ConfirmPassVal);
		clickElement(registerBtn);
		
	}
	
	public Map<String, String> validateRegisterationPageItems() {
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("alertText", getElementText(alertMsg)); // to get the text “Your registration is complete”
		dataMap.put("loggedEmail", getElementText(loggedEmail)); //to get the logged in mail id
		return dataMap; // return it so that we can print it in RegistrationTest class
	}
	
	
}
