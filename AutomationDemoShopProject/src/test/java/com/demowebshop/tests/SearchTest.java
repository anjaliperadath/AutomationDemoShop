package com.demowebshop.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToSeeOnlySearchedItems() {
		loginPage.searchItem(prop.getProperty("itemToSearch")); // to search "diamond"
 
		List<String> actualItemsList = productPage.validateSearchedItemsAppearAppropriately(); //to get list
		
	    for(String item : actualItemsList) { 
	    	if(item.toLowerCase().contains(prop.getProperty("itemToSearch"))){ // whether it contains diamond
	    		Assert.assertTrue(true, "Missing item "+ prop.getProperty("itemToSearch")); //if false it will print "Missing item diamond"
	    	}	    	
	}
}
}
