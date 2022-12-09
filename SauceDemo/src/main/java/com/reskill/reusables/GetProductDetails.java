package com.reskill.reusables;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.reskill.pages.CartPageLocation;

public class GetProductDetails {
	static Logger logger = Logger.getLogger(GetProductDetails.class);
	public WebDriver driver;
	AddAllItemsInCart addAllItems = new AddAllItemsInCart();
	CartImageAction cartImage = new CartImageAction();
	CartPageLocation cartPage = new CartPageLocation();
	
	public List<String> prodDetails(WebDriver driver) {
		List<String> uiData = new ArrayList<String>();

		addAllItems.addAllItems(driver);
		cartImage.cartImageButtonAction(driver);
		List<WebElement> cartQTY = driver.findElements(By.xpath(cartPage.getCartItemQTY()));
		List<WebElement> cartItemLabel = driver.findElements(By.xpath(cartPage.getCartItemLabel()));
		List<WebElement> cartItemDisc = driver.findElements(By.xpath(cartPage.getCartItemDisc()));
		List<WebElement> cartItemPrice = driver.findElements(By.xpath(cartPage.getCartItemPrice()));
	
//	for (int addProd = 0; addProd < cartItemLabel.size(); addProd++) {
//		String cartQTYs = cartQTY.get(addProd).getText();
//		String cartItemLabels = cartItemLabel.get(addProd).getText();
//		String cartItemDecs = cartItemDisc.get(addProd).getText();
//		String cartItemPrices = cartItemPrice.get(addProd).getText();
//		
//		logger.info("Label: " + cartQTYs);
//		logger.info("Label: " + cartItemLabels);
//		logger.info("Label: " + cartItemDecs);
//		logger.info("Label: " + cartItemPrices);
//		
//	}
		for (int addProd = 0; addProd < cartItemLabel.size(); addProd++) {
			
		uiData.add( cartQTY.get(addProd).getText());
		uiData.add(cartItemLabel.get(addProd).getText());
		uiData.add(cartItemDisc.get(addProd).getText());
		uiData.add(cartItemPrice.get(addProd).getText());
		
	}
		
	
return uiData;
}
//	public static void main(String[] args) {
//		GetProductDetails run = new GetProductDetails();
//		run.prodDetails(driver);
//	}

}
