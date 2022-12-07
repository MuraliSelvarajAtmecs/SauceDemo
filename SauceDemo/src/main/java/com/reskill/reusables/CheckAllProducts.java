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
		List<WebElement> itemAddCart = driver.findElements(By.xpath(productPage.getAddAllItemlocator()));
		List<WebElement> itemLabel = driver.findElements(By.xpath(productPage.getAllItemLabel()));
		List<WebElement> itemDisc = driver.findElements(By.xpath(productPage.getAllItemDisc()));
		List<WebElement> itemPrice = driver.findElements(By.xpath(productPage.getAllItemPrice()));

		for (int buttonAction = 0; buttonAction < itemAddCart.size(); buttonAction++) {
			itemAddCart.get(buttonAction).click();
			String itemLabels = itemLabel.get(buttonAction).getText();
			System.out.println("The output of Item Labels is:- " + itemLabels);
			String itemDiscriptions = itemDisc.get(buttonAction).getText();
			System.out.println("The output of Discription is:- " + itemDiscriptions);
			String itemPrices = itemPrice.get(buttonAction).getText();
			System.out.println("The output of Discription is:- " + itemPrices);
	
		}
//		cart.cartImageButtonAction(driver);
//		cart.cartContinueShopingAction(driver);
//		cart.cartCheckoutButtonAction(driver);
	}

}
