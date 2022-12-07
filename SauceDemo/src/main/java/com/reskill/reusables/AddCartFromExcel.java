package com.reskill.reusables;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.reskill.testingutility.ExcelDataReads;

public class AddCartFromExcel {
	public static WebDriver driver;
	ExcelDataReads excelRead = new ExcelDataReads();
	String excelDataYourCartPage = "yourCart";
	String excelDataProductPage = "products";
	
	public void verifyProductInCartExcel(WebDriver driver) {
	List<String> excelData = excelRead.readExcelData(excelDataYourCartPage);
	for(int row=0; row<excelData.size(); row++) {
		String string = excelData.get(row);
		System.out.println("data is: " + string);
		
	}
	
	}
	
	public static void main(String[] args) {
		AddCartFromExcel run = new AddCartFromExcel();
		run.verifyProductInCartExcel(driver);
	}
	
}
