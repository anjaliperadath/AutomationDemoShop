package com.demowebshop.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demowebshop.Context.Constants;

public class ExcelReader {
	
	public static String getCellValue(int rowNumber, int cellNumber) throws IOException {
		
		FileInputStream fis = new FileInputStream(Constants.EXCELFILE);//to read a file  
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		//XSSFWorkbook is a class that helps to read, it accepts a file "fis".The fis object enter into sheet and read data
		Sheet sh = xs.getSheet("Sheet1");//to get the sheet and store it in "sh"   
		Row row = sh.getRow(rowNumber);//to get row
        Cell cell=row.getCell(cellNumber);//store row.getCell(cellNumber) in a cell
        return cell.toString(); //return the value from excelsheet
		
	}
}
