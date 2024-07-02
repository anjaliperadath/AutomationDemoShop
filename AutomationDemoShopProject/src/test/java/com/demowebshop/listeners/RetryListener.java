package com.demowebshop.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
//RetryListener implements IRetryAnalyzer which is an abstract method
	
	int retryLimit = 1;// how many times to re executes if it fails i.e. 1 time
	int counter=0; // initially counter is 0
	@Override
	public boolean retry(ITestResult result) {
		if(counter<retryLimit) {
			counter++;
			return true ;        //execute again	
		}
		
		return false;            // stop Executing
	}
	
}
