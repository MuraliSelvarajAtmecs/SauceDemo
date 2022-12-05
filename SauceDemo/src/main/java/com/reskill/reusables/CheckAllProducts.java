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
		List<WebElement> itemCart = driver.findElements(By.xpath(productPage.getAllItemlocator()));
		List<WebElement> itemLabel = driver.findElements(By.xpath(productPage.getAllItemLabel()));
		List<WebElement> itemDisc = driver.findElements(By.xpath(productPage.getAllItemDisc()));
		List<WebElement> itemPrice = driver.findElements(By.xpath(productPage.getAllItemPrice()));

		for (int buttonAction = 0; buttonAction < itemCart.size(); buttonAction++) {
			itemCart.get(buttonAction).click();
			
			cart.cartImageButtonAction(driver);
				for (int itemLab = 0; itemLab < itemLabel.size(); itemLab++) {
					String itemLabels = itemLabel.get(itemLab).getText();
					System.out.println("The output of Item Labels is:- " + itemLabels);
					
					for (int itemDis = 0; itemDis < itemDisc.size(); itemDis++) {
						String itemDiscriptions = itemDisc.get(itemDis).getText();
						System.out.println("The output of Discription is:- " + itemDiscriptions);
						
						for (int itemPri = 0; itemPri < itemPrice.size(); itemPri++) {
							String itemPrices = itemPrice.get(itemPri).getText();
							System.out.println("The output of Discription is:- " + itemPrices);
						}

					}
				}
			
	
			cart.cartCheckoutBittonAction(driver);

		}

	}

}
