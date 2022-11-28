package com.reskill.testingutility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.reskill.reusables.FilePath;

public class ExcelUtilities {

	static Logger logger = Logger.getLogger(ExcelUtilities.class);
	
	String homePage = FilePath.HOMEPAGE;
	String testDataPath = FilePath.TESTDATAPATH;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	
	public ExcelUtilities() {
		try {
			workBook = new XSSFWorkbook(homePage + File.separator + testDataPath + File.separator + "sauceDemoTestData.xlsx");
			sheet = workBook.getSheet("userCredentials");
		} catch (Exception e) {
			logger.info("IO Exception");
		}
	}
		
	public String readCellString(int rowNum, int colNum) {
		
		String cellData = null;
		DataFormatter dataFormatter = new DataFormatter();
		try {
			cellData = dataFormatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));		
		} catch (Exception e) {
			logger.info("IO Exception");
		}
		return cellData;
	}
	
	public List<String> readData(int colNum) {
		int rowCount = sheet.getLastRowNum();
		List<String> excelData = new ArrayList<String>();
		for (int rowNum = 1; rowNum<=rowCount; rowNum++) {
			excelData.add(readCellString(rowNum, colNum));
		}
		return excelData;
	}
	


}
