package com.demowebshop.Utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demowebshop.Context.Constants;

public class ReportNG {

	static ExtentSparkReporter reporter; // make it static as we have to use in both methods
public static ExtentReports generateReport() {
		
		
		reporter = new ExtentSparkReporter(Constants.reportPath);// gave the path here 
		loadXMLFIle();// to load the screenshot in xml file 
		
		ExtentReports extent = new ExtentReports();// to create a HTML document another class ExtentReports is created
		extent.attachReporter(reporter);//attachReporter() object is responsible in attaching the report with whichever it extents
		extent.setSystemInfo("QA Name", "Anjali");//set the additional info
		extent.setSystemInfo("Brand", "Demo WebShop");
		return extent;
	}	

public static void loadXMLFIle() {
	try {
		reporter.loadXMLConfig(Constants.extentConfigFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
