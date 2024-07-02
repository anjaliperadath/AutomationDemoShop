package com.demowebshop.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demowebshop.Context.DriverManager;

public class PageActions {
	
WebDriver driver; // now driver will reach here
	
	public PageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public void clickElement(WebElement element) {  // to click 
		waitUntilVisible(element);
		waitUntilClickable(element);
		element.click();
	}
	
	public void setTextBox(WebElement element, String value) {  // to send values
		waitUntilVisible(element);
		waitUntilClickable(element);
		element.sendKeys(value);
	}
	
	public void waitUntilVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8)); // to wait until displayed
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void waitUntilClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8)); // to wait until clickable
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public String getElementText(WebElement element) { // to get the text of an element
		return element.getText(); // as we want to return the text in another class when calling this method
	}
	
	//creating extra wrapper with javascript
	    public void clickElementJavaScript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver; // to get driver 
		waitUntilVisible(element);
		waitUntilClickable(element);
		js.executeScript("arguments[0].click();", element); //to click on element
		
	}
	    
	    public List<String> getTextContentList(List<WebElement> list) { // to get the list of elements
			List<String> textContent= new ArrayList<String>();
			for(WebElement listItem : list) {
				textContent.add(getElementText(listItem)); // to get text 
			}
			return textContent;
		}
	
	    public void hoverOverItem(WebElement element) { //to hoverover on an Item 
	    	Actions act = new Actions(driver); // in built class to perform actions
			act.moveToElement(element).perform(); // to move to element
			
		}
	    
	    public void shortWait() {  // to wait 
			try {
				Thread.sleep(2000); // to wait for 2 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	    
	    public void waitForTextPresentInElement(WebElement element, String value) { //to wait for the element
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
			wait.until(ExpectedConditions.textToBePresentInElement(element, value)); // to wait till the desired value
		}
	    
	    public void selectDropdownByVisibleText(WebElement element, String value) { //static dropdown
			Select select = new Select(element); // created object for the select class and add argument(element).
			select.selectByVisibleText(value);// to select by value
		}
		
	  /*  public static String getScreenshot() throws IOException {
	    	TakesScreenshot screenshot = (TakesScreenshot)DriverManager.getDriver();// cast driver to TakesScreenshot interface
	    	File srcFile = screenshot.getScreenshotAs(OutputType.FILE); // took screenshot and stored it in src (arbitary position)
	    	String path =Constants.Screenshot;
	    	File destFile = new File(path);
	    	//to paste the screenshot from arbitary position to the destination "path" , which is in Constants file. 
	    	FileUtils.moveFile(srcFile, destFile); //used to move file
	    	return path;
	    }*/
	    
	    public static String getScreenshot() {
			TakesScreenshot screenshot = (TakesScreenshot)DriverManager.getDriver();
			return screenshot.getScreenshotAs(OutputType.BASE64);//to get screenshot using BASE64
		}
}
