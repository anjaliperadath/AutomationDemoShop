package com.demowebshop.Context;

import com.demowebshop.Utils.UniqueGenerator;

public class Constants {
	
	public static final String WORKINGDIRECTORY= System.getProperty("user.dir"); //the specific address of a system (computer)
	public static final String PROPERTIESFILE =WORKINGDIRECTORY+"/src/main/resources/Configurations/Config.properties"; // the full file path
	public static final String EXCELFILE = WORKINGDIRECTORY+"/src/test/resources/testData/regsiteration.xlsx";//full path of excelfile
	public static final String reportPath =WORKINGDIRECTORY +"/Reports/index.html";// path of report , ReportNG class
	public static String Screenshot=WORKINGDIRECTORY+"/Reports/screenshot"+UniqueGenerator.getCurrentDateTime()+".png";//screenshot location
	public static String extentConfigFile= WORKINGDIRECTORY+"/src/test/resources/extentConfig/extent-config.xml";//screenshot as thumbnails
}
