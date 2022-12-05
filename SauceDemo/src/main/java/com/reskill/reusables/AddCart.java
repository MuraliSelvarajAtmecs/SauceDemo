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

public class AddCart {
	static Logger logger = Logger.getLogger(AddCartAndCheckout.class);
	CheckButtonAction buttonAction = new CheckButtonAction();
	CheckButtonElement buttonElement = new CheckButtonElement();
	ProductPageLocation productPage = new ProductPageLocation();
	ProductLabelLocation productLabel = new ProductLabelLocation();
	public WebDriver driver;
	ExcelDataReads excelRead = new ExcelDataReads();
	String excelDataYourCartPage = "yourCart";
	String excelDataProductPage = "products";
	CartPageLocation cartPage = new CartPageLocation();
	
	public void cartImageButtonAction(WebDriver driver) {
		buttonAction.buttonClick(driver, By.xpath(cartPage.getLogoButton()), cartPage.getCartImageClick());
	}
	
	public void cartCheckoutBittonAction(WebDriver driver) {
		buttonAction.buttonClick(driver, By.xpath(cartPage.getSauceLabsBackpackCartCheckout()), cartPage.getcheckoutCartLabel());
	}
	
	
	public void verifyProductInCart(WebDriver driver) {
		List<WebElement> productButton = driver.findElements(By.xpath(productPage.getAllproductlocator()));
		for(int buttonAction=0; buttonAction<productButton.size(); buttonAction++) {
			productButton.get(buttonAction).click();
		}
		cartImageButtonAction(driver);
		cartCheckoutBittonAction(driver);
		}
}
