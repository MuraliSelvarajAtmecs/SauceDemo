package com.reskill.reusables;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.reskill.actions.CheckButtonAction;
import com.reskill.actions.CheckTextField;
import com.reskill.pages.CheckoutPageLocation;
import com.reskill.testingutility.ExcelDataReads;

public class CheckoutInfo {
	ExcelDataReads excelRead = new ExcelDataReads();
	CheckoutPageLocation checkout = new CheckoutPageLocation();
	CheckTextField textField = new CheckTextField();
	CheckButtonAction buttonAction = new CheckButtonAction();
	String excelDataCheckoutInfoPage = "checkoutInfo";
	public WebDriver driver;
	static Logger logger = Logger.getLogger(CheckoutInfo.class);
	
	public void verifyCheckoutUserInfo(WebDriver driver) {
		List<String> excelData = excelRead.readExcelData(excelDataCheckoutInfoPage);

		String getCheckoutHeader = driver.findElement(By.xpath(checkout.getCheckoutHeader())).getText();
		Assert.assertEquals(excelData.get(0), getCheckoutHeader, "Text is NOT Matched");
		logger.info(getCheckoutHeader + " is Present");

		textField.enterText(driver, By.xpath(checkout.getCheckoutFirstName()), checkout.getCheckoutFnameLabel(),
				excelData.get(1));
		textField.enterText(driver, By.xpath(checkout.checkoutLastName()), checkout.getcheckoutLnameLabel(),
				excelData.get(2));
		textField.enterText(driver, By.xpath(checkout.getcheckoutzip()), checkout.getcheckoutZipLabel(),
				excelData.get(3));
		buttonAction.buttonClick(driver, By.xpath(checkout.getcheckoutContinue()), excelData.get(4));
//		buttonAction.buttonClick(driver, By.xpath(checkout.getcheckoutCancel()), excelData.get(5));
	}

	public void verifyCheckoutUserInformation(WebDriver driver, String firstName, String lastName, int zip) throws InterruptedException {

		List<String> excelData = excelRead.readExcelData(excelDataCheckoutInfoPage);

		String getCheckoutHeader = driver.findElement(By.xpath(checkout.getCheckoutHeader())).getText();
		Assert.assertEquals(excelData.get(0), getCheckoutHeader, "Text is NOT Matched");
		logger.info(getCheckoutHeader + " is Present");

		driver.findElement(By.xpath(checkout.getCheckoutFirstName())).sendKeys(firstName);
		driver.findElement(By.xpath(checkout.checkoutLastName())).sendKeys(lastName);
		driver.findElement(By.xpath(checkout.getcheckoutzip())).sendKeys(String.valueOf(zip));
		Thread.sleep(5000);

//		driver.findElement(By.id("postal-code")).sendKeys("521106");
		buttonAction.buttonClick(driver, By.xpath(checkout.getcheckoutContinue()), excelData.get(4));
	}
}