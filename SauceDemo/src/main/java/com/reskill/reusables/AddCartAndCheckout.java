package com.reskill.reusables;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.reskill.actions.CheckButtonAction;
import com.reskill.pages.CartPageLocation;
import com.reskill.pages.ProductLabelLocation;
import com.reskill.pages.ProductPageLocation;
import com.reskill.testingutility.ExcelDataReads;

public class AddCartAndCheckout {
	static Logger logger = Logger.getLogger(AddCartAndCheckout.class);
	CheckButtonAction buttonAction = new CheckButtonAction();
	ProductPageLocation productPage = new ProductPageLocation();
	ProductLabelLocation productLabel = new ProductLabelLocation();
	public WebDriver driver;
	ExcelDataReads excelRead = new ExcelDataReads();
	String excelDataYourCartPage = "yourCart";
	CartPageLocation cartPage = new CartPageLocation();
	
	public void verifyDefaultProductInCart(WebDriver driver) {

		List<String> excelData = excelRead.readExcelData(excelDataYourCartPage);
		
		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBackpackProductAddToCart1()),	productLabel.getAddToCartLabel());
//		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBackpackProductRemoveFromCart1()), productLabel.getRemoveFromCartLabel());
		buttonAction.buttonClick(driver, By.xpath(cartPage.getLogoButton()), cartPage.getCartImageClick());
		
		String getHeaderText = driver.findElement(By.xpath(cartPage.getHeaderTextCart())).getText();
		Assert.assertEquals(excelData.get(0), getHeaderText, "Text NOT Matched");
		logger.info(getHeaderText + " is Present");

		String getQtyHeaderTextCart = driver.findElement(By.xpath(cartPage.getQtyHeaderText())).getText();
		Assert.assertEquals(excelData.get(1), getQtyHeaderTextCart, "Text NOT Matched");
		logger.info(getQtyHeaderTextCart + " is Present");

		String getDiscriptioHeaderTextCart = driver.findElement(By.xpath(cartPage.getDiscriptioHeaderText())).getText();
		Assert.assertEquals(excelData.get(2), getDiscriptioHeaderTextCart, "Text NOT Matched");
		logger.info(getDiscriptioHeaderTextCart + " is Present");

		String getSauceLabsBackpackCartLabelText = driver
				.findElement(By.xpath(cartPage.getSauceLabsBackpackCartLabel())).getText();
		Assert.assertEquals(excelData.get(3), getSauceLabsBackpackCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartLabelText + " is Present");

		String getSauceLabsBackpackCartDiscriptionText = driver
				.findElement(By.xpath(cartPage.getSauceLabsBackpackCartDiscription())).getText();
		Assert.assertEquals(excelData.get(4), getSauceLabsBackpackCartDiscriptionText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartDiscriptionText + " is Present");

		String getSauceLabsBackpackCartPriceText = driver
				.findElement(By.xpath(cartPage.getSauceLabsBackpackCartPrice())).getText();
		Assert.assertEquals(excelData.get(5), getSauceLabsBackpackCartPriceText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartPriceText + " is Present");

		buttonAction.buttonClick(driver, By.xpath(cartPage.getSauceLabsBackpackCartCheckout()),
				cartPage.getcheckoutCartLabel());
		
	}
	
}
