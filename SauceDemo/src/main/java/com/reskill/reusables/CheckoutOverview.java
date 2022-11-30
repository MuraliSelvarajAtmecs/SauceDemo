package com.reskill.reusables;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.reskill.actions.CheckButtonAction;
import com.reskill.actions.CheckItemText;
import com.reskill.actions.CheckItemTotal;
import com.reskill.pages.CheckoutOverviewPageLocation;
import com.reskill.testingutility.ExcelDataReads;
import com.reskill.testingutility.ItemTotal;

public class CheckoutOverview {
	static Logger logger = Logger.getLogger(CheckoutOverview.class);
	String excelDataCheckoutOverviewPage = "checkoutOverview";
	ExcelDataReads excelRead = new ExcelDataReads();
	public WebDriver driver;
	CheckoutOverviewPageLocation checkOverview = new CheckoutOverviewPageLocation();
	CheckItemTotal checkItemTotal = new CheckItemTotal();
	CheckItemText checkItemText = new CheckItemText();
	CheckButtonAction buttonAction = new CheckButtonAction();
	ItemTotal itemTotalCalc = new ItemTotal();
	
	public void VerifyCheckoutOverview(WebDriver driver) {
		List<String> excelData = excelRead.readExcelData(excelDataCheckoutOverviewPage);

		String getCheckoutOverviewTitle = driver.findElement(By.xpath(checkOverview.getCheckoutOverviewTitle()))
				.getText();
		Assert.assertEquals(excelData.get(0), getCheckoutOverviewTitle, "Text is NOT Matched");
		logger.info(getCheckoutOverviewTitle + " is Present");

		String getCheckoutPaymentInfo = driver.findElement(By.xpath(checkOverview.getCheckoutPaymentInfo())).getText();
		Assert.assertEquals(excelData.get(1), getCheckoutPaymentInfo, "Text is NOT Matched");
		logger.info(getCheckoutPaymentInfo + " is Present");

		String getCheckoutSauceCard = driver.findElement(By.xpath(checkOverview.getCheckoutSauceCard())).getText();
		Assert.assertEquals(excelData.get(2), getCheckoutSauceCard, "Text is NOT Matched");
		logger.info(getCheckoutSauceCard + " is Present");

		String getCheckoutShippingInfo = driver.findElement(By.xpath(checkOverview.getCheckoutShippingInfo()))
				.getText();
		Assert.assertEquals(excelData.get(3), getCheckoutShippingInfo, "Text is NOT Matched");
		logger.info(getCheckoutShippingInfo + " is Present");

		String getCheckoutShippingDeliver = driver.findElement(By.xpath(checkOverview.getCheckoutShippingDeliver()))
				.getText();
		Assert.assertEquals(excelData.get(4), getCheckoutShippingDeliver, "Text is NOT Matched");
		logger.info(getCheckoutShippingDeliver + " is Present");

		String iteamTotalText = checkItemText.checkoutText(driver, By.xpath(checkOverview.getChcekoutItemTotal()));
		Assert.assertEquals(excelData.get(5), iteamTotalText, " Text is NOT Matched");
		logger.info(iteamTotalText + " is Present");

		String itemTaxText = checkItemText.checkoutText(driver, By.xpath(checkOverview.getCheckoutTax()));
		Assert.assertEquals(excelData.get(6), itemTaxText, " Text is NOT Matched");
		logger.info(itemTaxText + " is Present");

		double itemTotal = checkItemTotal.checkoutOverviewTotal(driver, By.xpath(checkOverview.getChcekoutItemTotal()));
		double tax = checkItemTotal.checkoutOverviewTotal(driver, By.xpath(checkOverview.getCheckoutTax()));
		double addition = itemTotal + tax;
		double decimalTotal = itemTotalCalc.totalCovertion(addition);
		logger.info("Total: " + decimalTotal);

		double total = checkItemTotal.checkoutOverviewTotal(driver, By.xpath(checkOverview.getCheckoutTotal()));
		Assert.assertEquals(decimalTotal, total, " Total is NOT Matched");
		logger.info(total + " Total is Matched");

		buttonAction.buttonClick(driver, By.xpath(checkOverview.getCheckoutFinish()), excelData.get(7));
//		buttonAction.buttonClick(driver, By.xpath(checkOverview.getCheckoutCancel()), excelData.get(8));
	}

}

