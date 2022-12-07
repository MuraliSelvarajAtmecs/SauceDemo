package com.reskill.reusables;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.reskill.pages.ProductPageLocation;

public class RemoveAllItemsInCart {

	static Logger logger = Logger.getLogger(AddAllItemsInCart.class);
	ProductPageLocation productPage = new ProductPageLocation();
	public WebDriver driver;
	public void addAllItems(WebDriver driver) {
	List<WebElement> productButton = driver.findElements(By.xpath(productPage.getRemoveAllItemlocator()));
	String text1 = productButton.get(0).getText();
	logger.info("Button text is: " + text1);
	for(int buttonAction=0; buttonAction<productButton.size(); buttonAction++) {
		if(text1.contains("REMOVE")) {
		productButton.get(buttonAction).click();
		}
		else {
			logger.info("Button text is not clicked");
		}
	}
	}
}

