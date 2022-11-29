package com.reskill.testingutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.reskill.pages.ProductPageLocation;
import com.reskill.reusables.FilePath;

public class ExcelDataReads {
	static Logger logger = Logger.getLogger(ExcelDataReads.class);
	DataFormatter dataFormatter = new DataFormatter();
	String homePage = FilePath.HOMEPAGE;
	String readExcel = FilePath.EXCELDATAREADPATH;
	
	ProductPageLocation productPage = new ProductPageLocation();
	XSSFWorkbook workBook;
	
	public List<String> readExcelData(String getSheetName) {
		List<String> testExcelData = null;
//		/src/main/resources/moduleOneTestData/sauceDemoTestData.xlsx
		File src = new File(homePage + File.separator + readExcel + File.separator + "sauceDemoTestData.xlsx");
		FileInputStream files;
		try {
			files = new FileInputStream(src);
			try {
				workBook = new XSSFWorkbook(files);
				int numberOfSheets = workBook.getNumberOfSheets();
//				logger.info(("Number of Sheets: " + numberOfSheets);
				for (int sheetcount = 0; sheetcount < numberOfSheets; sheetcount++) {
					String sheetNames = workBook.getSheetAt(sheetcount).getSheetName();
					if (sheetNames.contains(getSheetName)) {
						testExcelData = getData(sheetNames);
					}
				}
			} catch (IOException e) {
				logger.info("IO Execption");
			}
		} catch (FileNotFoundException e) {
			logger.info("File Not Found Exeception");
		}
		return testExcelData;
	}

	public List<String> getData(String sheetNames) {
		List<String> excelData = new ArrayList<String>();
		XSSFSheet sheet = null;
		int lastRowNum = 0;
//		logger.info("Name of Sheet is: " + productPage.getnameofSheet0());
		sheet = workBook.getSheet(sheetNames);
		lastRowNum = sheet.getPhysicalNumberOfRows();
//		logger.info("Last Row Number is: " + lastRowNum);
		for (int rowNum = 1; rowNum < lastRowNum; rowNum++) {
			XSSFRow row = sheet.getRow(rowNum);
			int lastCellNum = row.getLastCellNum();
			for (int cellNum = 0; cellNum < lastCellNum; cellNum++) {
				String cellData = dataFormatter.formatCellValue(row.getCell(cellNum));
//				logger.info("The Cell Value is: " + cellData);
				excelData.add(cellData);
			}
		}
		return excelData;
	}

//	public static void main(String[] args) {
//		ProductPageLocators productPage = new ProductPageLocators();
//		ExcelDataReads run = new ExcelDataReads();
//		List<String> data = run.readExcelData(productPage.getnameofSheet0());
//		for(int i=0; i<data.size(); i++) {
//			System.out.println(data.get(i));
//		}
//	}

}
