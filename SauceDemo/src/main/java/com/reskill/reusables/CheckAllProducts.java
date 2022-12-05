package com.reskill.reusables;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		List<WebElement> productButton = driver.findElements(By.xpath(productPage.getAllproductlocator()));
		
		
		for(int buttonAction=0; buttonAction<productButton.size(); buttonAction++) {
			productButton.get(buttonAction).click();
		}
		
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
		System.err.println("-------" + excelData.get(3));
		System.err.println("-------" + excelData.get(4));
		System.err.println("-------" + excelData.get(5));
		System.err.println("-------" + excelData.get(6));
		System.err.println("-------" + excelData.get(7));
		System.err.println("-------" + excelData.get(8));
		System.err.println("-------" + excelData.get(9));
	
		
		String getSauceLabsBikeLightCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBikeLightLabel())).getText();
		System.err.println("------" + getSauceLabsBikeLightCartLabelText);
		Assert.assertEquals(excelData.get(6), getSauceLabsBikeLightCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsBikeLightCartLabelText + " is Present");
		


		cart.cartCheckoutBittonAction(driver);
		

	}
}


