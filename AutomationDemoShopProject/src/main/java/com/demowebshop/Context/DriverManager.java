package com.demowebshop.Context;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<WebDriver>(); 
	//we name it "driverInstance" and make it private so it belongs to this class
	
	public static  WebDriver getDriver() { //way of having singleton object
		if(driverInstance.get()==null) {
			throw new  IllegalArgumentException("please initilaize driver"); 
		}
		else {
			return driverInstance.get();
		}
		//if driver is null, it will throw exception , else it will return what it gets.
	}
	
	public static void setDriver(WebDriver driver) {
		driverInstance.set(driver);//set driver to this instance
		
	}
	
}
