package com.reskill.testingutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.reskill.pages.ProductPageLocators;
import com.reskill.reusables.FilePath;

public class ExcelDataReads {
	DataFormatter dataFormatter = new DataFormatter();
	String path = FilePath.HOMEPAGE;
	

	ProductPageLocators productPage = new ProductPageLocators();

	XSSFWorkbook workBook;
	
	@SuppressWarnings("resource")
	public List<String> readExcelData(String getSheetData) {
//		/src/main/resources/moduleOneTestData/sauceDemoTestData.xlsx
		File src = new File(path + File.separator + "src" + File.separator + "main" + File.separator + "resources"
				+ File.separator + "moduleOneTestData" + File.separator + "sauceDemoTestData.xlsx");
		FileInputStream files;
		try {
			files = new FileInputStream(src);
			try {
				workBook = new XSSFWorkbook(files);
				int numberOfSheets = workBook.getNumberOfSheets();
				System.out.println("Number of Sheets: " + numberOfSheets);

				for (int sheetcount = 0; sheetcount < numberOfSheets; sheetcount++) {
					String sheetNames = workBook.getSheetAt(sheetcount).getSheetName();
					if (sheetNames.contains(getSheetData)) {
						getdata(sheetNames);
					}
				}
			} catch (IOException e) {
				System.out.println("IO Execption");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exeception");
		}
		return null;
	}

	@SuppressWarnings("null")
	public List<String> getdata(String sheetNames) {
		List<String> excelData = new ArrayList<String>();
		XSSFSheet sheet = null;
		int lastRowNum = 0;
		System.out.println("Name of Sheet is: " + productPage.getnameofSheet0());
		sheet = workBook.getSheet(sheetNames);
		lastRowNum = sheet.getPhysicalNumberOfRows();
		System.out.println("Last Row Number is: " + lastRowNum);
		for (int rowNum = 1; rowNum < lastRowNum; rowNum++) {
			XSSFRow row = sheet.getRow(rowNum);
			int lastCellNum = row.getLastCellNum();
			for (int cellNum = 0; cellNum < lastCellNum; cellNum++) {
				String cellData = dataFormatter.formatCellValue(row.getCell(cellNum));
				System.out.println("The Cell Value is: " + cellData);
				excelData.add(cellData);
			}
		}
		return excelData;
	}

	public static void main(String[] args) {
		ProductPageLocators productPage = new ProductPageLocators();
		ExcelDataReads run = new ExcelDataReads();
		run.readExcelData(productPage.getnameofSheet0());
	}

}
