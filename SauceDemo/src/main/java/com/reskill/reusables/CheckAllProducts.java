package com.reskill.reusables;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.reskill.actions.CheckButtonAction;
import com.reskill.actions.CheckButtonElement;
import com.reskill.pages.CartPageLocation;
import com.reskill.pages.ProductLabelLocation;
import com.reskill.pages.ProductPageLocation;
import com.reskill.testingutility.ExcelDataReads;

public class CheckAllProducts {
	
	static Logger logger = Logger.getLogger(CheckAllProducts.class);
	ProductPageLocation productPage = new ProductPageLocation();
	CheckButtonAction buttonAction = new CheckButtonAction();
	CheckButtonElement buttonElement = new CheckButtonElement();
	ProductLabelLocation productLabel = new ProductLabelLocation();
	AddCartAndCheckout cart = new AddCartAndCheckout();
	public WebDriver driver;
	
	ExcelDataReads excelRead = new ExcelDataReads();
	String excelDataYourCartPage = "yourCart";
	String excelDataProductPage = "products";
	CartPageLocation cartPage = new CartPageLocation();
	
	List<String> excelData = excelRead.readExcelData(excelDataYourCartPage);
	
	public void verifyAllProducts(WebDriver driver) {
		
		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBackpackProductAddToCart1()),	productLabel.getAddToCartLabel());
		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBikeLightProductAddToCart()),	productLabel.getAddToCartLabel());
		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBoltTShirtProductAddToCart()), productLabel.getAddToCartLabel());
		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsFleeceJacketProductAddToCart()), productLabel.getAddToCartLabel());
		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsOnesieProductAddToCart()), productLabel.getAddToCartLabel());
		buttonAction.buttonClick(driver, By.xpath(productPage.getTestAllTheThingsTShirtRedProductAddToCart()),	productLabel.getAddToCartLabel());
		cart.cartImageButtonAction(driver);
		
		String getSauceLabsBackpackCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartLabel())).getText();
		Assert.assertEquals(excelData.get(3), getSauceLabsBackpackCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartLabelText + " is Present");

		String getSauceLabsBackpackCartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartDiscription())).getText();
		Assert.assertEquals(excelData.get(4), getSauceLabsBackpackCartDiscriptionText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartDiscriptionText + " is Present");

		String getSauceLabsBackpackCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartPrice())).getText();
		Assert.assertEquals(excelData.get(5), getSauceLabsBackpackCartPriceText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartPriceText + " is Present");

		String getSauceLabsBikeLightCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBikeLightLabel())).getText();
		Assert.assertEquals(excelData.get(6), getSauceLabsBikeLightCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsBikeLightCartLabelText + " is Present");



		cart.cartCheckoutBittonAction(driver);
		

	}
}


