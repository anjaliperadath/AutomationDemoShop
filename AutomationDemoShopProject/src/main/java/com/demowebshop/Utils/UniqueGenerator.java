package com.demowebshop.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class UniqueGenerator {
	
	public static String getUniqueEmail() {
		
		return "testuser"+getCurrentDateTime()+"@yopmail.com";// the format of mail id we want to get 
	}
    
	
	public static String getCurrentDateTime() {
		String dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()); //format to get date and time
		return dateTime.replaceAll("[^0-9]",""); //[^0-9] means anything apart from 0 to 9 replace it with nothing ""
	}

}
