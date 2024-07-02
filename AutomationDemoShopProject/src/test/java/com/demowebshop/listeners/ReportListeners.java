package com.demowebshop.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.demowebshop.Utils.PageActions;
import com.demowebshop.Utils.ReportNG;

public class ReportListeners implements ITestListener {
	
	ExtentReports extent= ReportNG.generateReport(); // to call the method generateReport() here, to get report
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();// to make our tests threadsafe 
	ExtentTest test ;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());	// to start test
		extentTest.set(test);//putting the test with a unique stamp name to differentiate it 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed"); // to pass
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, result.getThrowable());// to fail and throw exception	
	//	extentTest.get().addScreenCaptureFromBase64String(PageActions.getScreenshot());// to get screenshot from BASE64
		extentTest.get().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(PageActions.getScreenshot()).build());
        //build the action so that at log level the screenshot will be generated as thumbnail				
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test Skipped");// to skip a test if it fails .
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();//to flush and generate report
	}	

}
