package com.reskill.testingutility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUsingArray {
	public String[][] RadData() throws Exception {
		// file seperator
		File file = new File("C:/Users/murali.selvaraj/Desktop/excel/sauceDemoTestData.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet("yourCart");
//				String cellvalue = sheet.getRow(1).getCell(0).getStringCellValue();
		int numberOfRows = sheet.getLastRowNum();
		int numberOfColums = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[numberOfRows][numberOfColums];
		for (int rownumber = 0; rownumber < numberOfRows; rownumber++) {
			for (int columnumber = 0; columnumber < numberOfColums; columnumber++) {

				DataFormatter dataformater = new DataFormatter();
				data[rownumber][columnumber] = dataformater
						.formatCellValue(sheet.getRow(rownumber + 1).getCell(columnumber));
//						System.out.print(data);
//						System.out.print(" | ");
			}

//					System.out.println();
		}

		
//		for (int num = 0; num < data.length; num++) {
//			for (int ele = 0; ele < 4; ele++) {
//				System.out.println(data[num][ele]);
//			}
//			System.out.println("===========================");
//		}

//				for (String[] arraydata : data) {
//					System.out.println(Arrays.toString(arraydata));
//				}
		workbook.close();
		return data;
	}

	public static void main(String[] args) throws Exception {
		ExcelUsingArray run = new ExcelUsingArray();
		String[][] a = run.RadData();
		System.out.println(a[1][1]);
		System.out.println(a[1][2]);
	}


}
