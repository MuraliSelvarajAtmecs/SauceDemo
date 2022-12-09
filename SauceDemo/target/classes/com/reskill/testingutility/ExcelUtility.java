package com.reskill.testingutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.reskill.reusables.FilePath;

public class ExcelUtility {
	static Logger logger = Logger.getLogger(ExcelUtility.class);
	DataFormatter dataformater = new DataFormatter();
	List<Map<String, String>> testData = null;
	Map<String, String> cellValues = null;

	public List<Map<String, String>> readExcelData()  {

		String homePage = FilePath.HOMEPAGE;
		String readExcel = FilePath.EXCELDATAREADPATH;

		File src = new File(homePage + File.separator + readExcel + File.separator + "sauceDemoTestData.xlsx");
		FileInputStream files = null;
		try {
			files = new FileInputStream(src);
		} catch (FileNotFoundException e) {
//			logger.info("Test Data file is incorrect");
			e.printStackTrace();
		}
	
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(files);
		} catch (IOException e) {
			logger.info("Test Data IO Exception: ");
		}
		
		XSSFSheet sheet = workbook.getSheet("yourCart");
		int rowCount = sheet.getLastRowNum();
		int columCount = sheet.getRow(0).getLastCellNum();

		// Getting Heaader Row Values and store it in ArrayList
		List<String> headder = new ArrayList<String>();
		
		for (int cell = 0; cell < columCount; cell++) {
			String headderrow = dataformater.formatCellValue(sheet.getRow(0).getCell(cell));
			headder.add(headderrow);
		}
		
//		for (String head : headder) {
//			logger.info(head);
//		}
		

		//Getting Each Cell Values and storing it in ArrayList and Map
		testData = new ArrayList<Map<String, String>>();
		for (int row = 1; row <= rowCount; row++) {
			cellValues = new HashMap<String, String>();
			
			for (int col = 0; col < columCount; col++) {
				String rowvalue = dataformater.formatCellValue(sheet.getRow(row).getCell(col));
				cellValues.put(headder.get(col), rowvalue);
			}
			testData.add(cellValues);
		}
		try {
			workbook.close();
		} catch (IOException e) {
			logger.info("Test Data IO Exception: ");
		}
		return testData;
	}
	
//	public static void main(String[] args) {
//		ExcelUtility excel = new ExcelUtility();
//		List<Map<String, String>> studentdata = excel.readExcelData();
//		logger.info("Given Row count is :" + studentdata.size());
//		
//			for (int row = 0; row < 6; row++) {
//				logger.info( studentdata.get(row).get("Product Discription"));
//				
//			}
//	}
	
}
