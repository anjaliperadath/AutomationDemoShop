package com.demowebshop.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.demowebshop.Context.Constants;

public class TestProperties {
	
	public static Properties getProperties() throws IOException {
		FileInputStream fis = new FileInputStream(Constants.PROPERTIESFILE); // the path of file
		// by giving FileInputStream , it will covert input bytes from file and use it
		Properties prop = new Properties(); // to get the class Properties : Properties class represent a  persistent set of properties
		prop.load(fis); // to load the file
		return prop; // returning the properties to obtain in other class
	}	

}
