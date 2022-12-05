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
		List<String> excelData = excelRead.readExcelData(excelDataYourCartPage);
		List<WebElement> productButton = driver.findElements(By.xpath(productPage.getAllItemlocator()));
		
		for(int buttonAction=0; buttonAction<productButton.size(); buttonAction++) {
			productButton.get(buttonAction).click();
		}
		cartImageButtonAction(driver);
		
		
		String getSauceLabsBackpackCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartLabel())).getText();
		logger.info("------------ " + getSauceLabsBackpackCartLabelText + " ------------");
		String getSauceLabsBackpackCartQtyText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackQty())).getText();
		Assert.assertEquals(excelData.get(3), getSauceLabsBackpackCartQtyText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartQtyText + " Number of QTY is Present");
		Assert.assertEquals(excelData.get(4), getSauceLabsBackpackCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartLabelText + " is Present");
		String getSauceLabsBackpackCartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartDiscription())).getText();
		Assert.assertEquals(excelData.get(5), getSauceLabsBackpackCartDiscriptionText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartDiscriptionText + " is Present");
		String getSauceLabsBackpackCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartPrice())).getText();
		Assert.assertEquals(excelData.get(6), getSauceLabsBackpackCartPriceText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartPriceText + " is Present");
	
		String getSauceLabsBikeLightCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBikeLightLabel())).getText();
		logger.info("------------ " + getSauceLabsBikeLightCartLabelText + " ------------");
		String getSauceLabsBikeLightQtyText = driver.findElement(By.xpath(cartPage.getSauceLabsBikeLightQty())).getText();
		Assert.assertEquals(excelData.get(7), getSauceLabsBikeLightQtyText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartQtyText + " Number of QTY is Present");
		Assert.assertEquals(excelData.get(8), getSauceLabsBikeLightCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsBikeLightCartLabelText + " is Present");
		String getSauceLabsBikeLightCartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsBikeLightDiscription())).getText();
		Assert.assertEquals(excelData.get(9), getSauceLabsBikeLightCartDiscriptionText, "Text NOT Matched");
		logger.info(getSauceLabsBikeLightCartDiscriptionText + " is Present");
		String getSauceLabsBikeLightCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsBikeLightCartPrice())).getText();
		Assert.assertEquals(excelData.get(10), getSauceLabsBikeLightCartPriceText, "Text NOT Matched");
		logger.info(getSauceLabsBikeLightCartPriceText + " is Present");

		String getSauceLabsBoltTShirtCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBoltTShirtLabel())).getText();
		logger.info("------------ " + getSauceLabsBoltTShirtCartLabelText + " ------------");
		String getSauceLabsBoltTShirtQtyText = driver.findElement(By.xpath(cartPage.getSauceLabsBoltTShirtQty())).getText();
		Assert.assertEquals(excelData.get(11), getSauceLabsBoltTShirtQtyText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartQtyText + " Number of QTY is Present");
		Assert.assertEquals(excelData.get(12), getSauceLabsBoltTShirtCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsBoltTShirtCartLabelText + " is Present");
		String getSauceLabsBoltTShirtartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsBoltTShirtDiscription())).getText();
		Assert.assertEquals(excelData.get(13), getSauceLabsBoltTShirtartDiscriptionText, "Text NOT Matched");
		logger.info(getSauceLabsBoltTShirtartDiscriptionText + " is Present");
		String getSauceLabsBoltTShirtCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsBoltTShirtCartPrice())).getText();
		Assert.assertEquals(excelData.get(14), getSauceLabsBoltTShirtCartPriceText, "Text NOT Matched");
		logger.info(getSauceLabsBoltTShirtCartPriceText + " is Present");
		
		String getSauceLabsFleeceJacketCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsFleeceJacketLabelLabel())).getText();
		logger.info("------------ " + getSauceLabsFleeceJacketCartLabelText + " ------------");
		String getSauceLabsFleeceJacketQtyText = driver.findElement(By.xpath(cartPage.getSauceLabsFleeceJacketQty())).getText();
		Assert.assertEquals(excelData.get(15), getSauceLabsFleeceJacketQtyText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartQtyText + " Number of QTY is Present");
		Assert.assertEquals(excelData.get(16), getSauceLabsFleeceJacketCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsFleeceJacketCartLabelText + " is Present");
		String getSauceLabsFleeceJacketCartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsFleeceJacketCartDiscription())).getText();
		Assert.assertEquals(excelData.get(17), getSauceLabsFleeceJacketCartDiscriptionText, "Text NOT Matched");
		logger.info(getSauceLabsFleeceJacketCartDiscriptionText + " is Present");
		String getSauceLabsFleeceJacketCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsFleeceJacketCartPrice())).getText();
		Assert.assertEquals(excelData.get(18), getSauceLabsFleeceJacketCartPriceText, "Text NOT Matched");
		logger.info(getSauceLabsFleeceJacketCartPriceText + " is Present");
		
		String getSauceLabsOnesieCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsOnesieLabel())).getText();
		logger.info("------------ " + getSauceLabsOnesieCartLabelText + " ------------");
		String getSauceLabsOnesieQtyText = driver.findElement(By.xpath(cartPage.getSauceLabsOnesieQty())).getText();
		Assert.assertEquals(excelData.get(19), getSauceLabsOnesieQtyText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartQtyText + " Number of QTY is Present");
		Assert.assertEquals(excelData.get(20), getSauceLabsOnesieCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsOnesieCartLabelText + " is Present");
		String getSauceLabsOnesieCartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsOnesieDiscription())).getText();
		Assert.assertEquals(excelData.get(21), getSauceLabsOnesieCartDiscriptionText, "Text NOT Matched");
		logger.info(getSauceLabsOnesieCartDiscriptionText + " is Present");
		String getSauceLabsOnesieCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsOnesieCartPrice())).getText();
		Assert.assertEquals(excelData.get(22), getSauceLabsOnesieCartPriceText, "Text NOT Matched");
		logger.info(getSauceLabsOnesieCartPriceText + " is Present");
		
		String getTestAllTheThingsTShirtRedCartLabelText = driver.findElement(By.xpath(cartPage.getTestAllTheThingsTShirtRedLabel())).getText();
		logger.info("------------ " + getTestAllTheThingsTShirtRedCartLabelText + " ------------");
		String getTestAllTheThingsTShirtRedQtyText = driver.findElement(By.xpath(cartPage.getTestAllTheThingsTShirtRedQty())).getText();
		Assert.assertEquals(excelData.get(23), getTestAllTheThingsTShirtRedQtyText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartQtyText + " Number of QTY is Present");
		Assert.assertEquals(excelData.get(24), getTestAllTheThingsTShirtRedCartLabelText, "Text NOT Matched");
		logger.info(getTestAllTheThingsTShirtRedCartLabelText + " is Present");
		String getTestAllTheThingsTShirtRedCartDiscriptionText = driver.findElement(By.xpath(cartPage.getTestAllTheThingsTShirtRedDiscription())).getText();
		Assert.assertEquals(excelData.get(25), getTestAllTheThingsTShirtRedCartDiscriptionText, "Text NOT Matched");
		logger.info(getTestAllTheThingsTShirtRedCartDiscriptionText + " is Present");
		String getTestAllTheThingsTShirtRedCartPriceText = driver.findElement(By.xpath(cartPage.getTestAllTheThingsTShirtRedCartPrice())).getText();
		Assert.assertEquals(excelData.get(26), getTestAllTheThingsTShirtRedCartPriceText, "Text NOT Matched");
		logger.info(getTestAllTheThingsTShirtRedCartPriceText + " is Present");
		logger.info("--------------------------");
		
		cartCheckoutBittonAction(driver);
		}
}
