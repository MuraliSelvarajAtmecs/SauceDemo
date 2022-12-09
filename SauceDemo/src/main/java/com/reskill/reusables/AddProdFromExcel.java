package com.reskill.reusables;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.reskill.testingutility.ExcelDataReads;

public class AddProdFromExcel {
	static Logger logger = Logger.getLogger(AddProdFromExcel.class);
	public WebDriver driver;
	ExcelDataReads excelRead = new ExcelDataReads();
	String excelDataYourCartPage = "yourCart";
	String excelDataProductPage = "products";

	public List<String> verifyProductInCartExcel(WebDriver driver) {
		List<String> excelData = excelRead.readExcelData(excelDataYourCartPage);
//		System.out.println("======================");
//		System.out.println(excelData.get(2));
//		for (int row = 0; row < excelData.size(); row++) {
//			String rowData = excelData.get(row);

//		logger.info("data is: " + rowData);

//		}
		return excelData;

	}

}
