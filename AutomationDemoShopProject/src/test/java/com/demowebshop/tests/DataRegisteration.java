package com.demowebshop.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.Utils.ExcelReader;
import com.demowebshop.Utils.UniqueGenerator;

public class DataRegisteration extends BaseTest{
	
	@Test
	public void verifyUserIsAbleToRegister() throws IOException {
		String firstName=ExcelReader.getCellValue(1, 0);
		String lastName= ExcelReader.getCellValue(1, 1);
		String email=ExcelReader.getCellValue(1, 2)+UniqueGenerator.getCurrentDateTime()+"@yopmail.com";//to get unique mailid each time
		String password= ExcelReader.getCellValue(1, 3);
		
		loginPage.navigateToRegisteration();
        registerPage.createUser(firstName,lastName, email, password, password); //as password and confirm password are same gave it on both place .
		
		Map<String, String> dataMap = registerPage.validateRegisterationPageItems(); // method to check if we get alert message
		Assert.assertEquals(dataMap.get("alertText"), prop.getProperty("registerationMsg"), "Alert did not match" );
		// to check if alertText is same as the expected result given
		Assert.assertEquals(dataMap.get("loggedEmail"), email, "Logged Email is different" );
		// to check if loggedEmail is same as the expected result given
				
	}
	
}
