package com.reskill.reusables;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.reskill.actions.CheckButtonAction;
import com.reskill.actions.CheckElement;
import com.reskill.pages.CheckoutCompletePageLocation;
import com.reskill.testingutility.ExcelDataReads;

public class CheckoutComplete {
	static Logger logger = Logger.getLogger(CheckoutComplete.class);
	ExcelDataReads excelRead = new ExcelDataReads();
	CheckoutCompletePageLocation checkoutComplete = new CheckoutCompletePageLocation();
	CheckElement elementCheck = new CheckElement();
	CheckButtonAction buttonAction = new CheckButtonAction();
	String excelDataCheckoutCompletePage = "checkoutComplete";
	
	public WebDriver driver;

	public void VerifyCheckoutCompleted(WebDriver driver) {
		List<String> excelData = excelRead.readExcelData(excelDataCheckoutCompletePage);

		String getCheckoutCompleteText = driver.findElement(By.xpath(checkoutComplete.getCheckoutComplete())).getText();
		Assert.assertEquals(excelData.get(0), getCheckoutCompleteText, " Text is NOT Matched");
		logger.info(getCheckoutCompleteText + " is Preasent");

		String getCompleteHeaderText = driver.findElement(By.xpath(checkoutComplete.getCompleteHeaderText())).getText();
		Assert.assertEquals(excelData.get(1), getCompleteHeaderText, " Text is NOT Matched");
		logger.info(getCompleteHeaderText + " is Present");

		String getOrderDiscription = driver.findElement(By.xpath(checkoutComplete.getOrderDiscription())).getText();
		Assert.assertEquals(excelData.get(2), getOrderDiscription, " Text is NOT Matched");
		logger.info(getOrderDiscription + " is Present");

		elementCheck.isElementPresent(driver, By.xpath(checkoutComplete.getponnyExpressLogo()),
				checkoutComplete.getPonyExpressLogoLabel());

		buttonAction.buttonClick(driver, By.xpath(checkoutComplete.getBackHomeButton()), excelData.get(3));
	}
}
