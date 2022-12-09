package com.reskill.reusables;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.reskill.actions.CheckButtonAction;
import com.reskill.actions.CheckButtonElement;
import com.reskill.pages.CartPageLocation;
import com.reskill.pages.ProductLabelLocation;
import com.reskill.pages.ProductPageLocation;
import com.reskill.testingutility.ExcelDataReads;
import com.reskill.testingutility.ExcelUtility;

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
	AddAllItemsInCart addAllItems = new AddAllItemsInCart();
	ExcelUtility testData = new ExcelUtility();
	CartImageAction cartImage = new CartImageAction();
	CartCheckoutButton cartButton = new CartCheckoutButton();
	
	Assertion assertion = new Assertion();

	public void verifyProductInCart(WebDriver driver) {
//		List<String> excelData = excelRead.readExcelData(excelDataYourCartPage);
		addAllItems.addAllItems(driver);
		cartImage.cartImageButtonAction(driver);

		List<WebElement> cartItemQTY = driver.findElements(By.xpath(cartPage.getCartItemQTY()));
		List<WebElement> cartItemLabel = driver.findElements(By.xpath(cartPage.getCartItemLabel()));
		List<WebElement> cartItemDisc = driver.findElements(By.xpath(cartPage.getCartItemDisc()));
		List<WebElement> cartItemPrice = driver.findElements(By.xpath(cartPage.getCartItemPrice()));
		
		List<Map<String, String>> verifyExceldata = testData.readExcelData();
		for(int row=0; row<verifyExceldata.size(); row++) {

//			String textData = cartItemLabel.get(row).getText();
//			String productTxt = verifyExceldata.get(row).get("Product Title"); 
//			assertion.assertEquals(textData, productTxt, "validate product text");

			assertion.assertEquals(cartItemQTY.get(row).getText(), verifyExceldata.get(row).get("QTY"), "validate Product Quantity");
			logger.info("Product Quantity is: " + cartItemQTY.get(row).getText());
			assertion.assertEquals(cartItemLabel.get(row).getText(), verifyExceldata.get(row).get("ProductTitle"), "validate Product Lable");
			logger.info("Product Label is: " + cartItemLabel.get(row).getText());
			assertion.assertEquals(cartItemDisc.get(row).getText(), verifyExceldata.get(row).get("ProductDiscription"), "validate Product Description");
			logger.info("Product Description is: " + cartItemDisc.get(row).getText());
			assertion.assertEquals(cartItemPrice.get(row).getText(), verifyExceldata.get(row).get("ProductPrice"), "validate Product Price");
			logger.info("Product Price is: " + cartItemPrice.get(row).getText());
			cartImage.cartImageButtonAction(driver);
		}
		cartButton.cartCheckoutButtonAction(driver);
		}
}


