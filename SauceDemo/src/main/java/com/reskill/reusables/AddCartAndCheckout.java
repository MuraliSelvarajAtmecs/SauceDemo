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

public class AddCartAndCheckout {
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
	
//	public void verifyDefaultProductInCart(WebDriver driver) {
//
//		List<String> excelData = excelRead.readExcelData(excelDataYourCartPage);
//		
//		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBackpackProductAddToCart1()),	productLabel.getAddToCartLabel());
////		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBackpackProductRemoveFromCart1()), productLabel.getRemoveFromCartLabel());
//		buttonAction.buttonClick(driver, By.xpath(cartPage.getLogoButton()), cartPage.getCartImageClick());
//		
//		String getHeaderText = driver.findElement(By.xpath(cartPage.getHeaderTextCart())).getText();
//		Assert.assertEquals(excelData.get(0), getHeaderText, "Text NOT Matched");
//		logger.info(getHeaderText + " is Present");
//
//		String getQtyHeaderTextCart = driver.findElement(By.xpath(cartPage.getQtyHeaderText())).getText();
//		Assert.assertEquals(excelData.get(1), getQtyHeaderTextCart, "Text NOT Matched");
//		logger.info(getQtyHeaderTextCart + " is Present");
//
//		String getDiscriptioHeaderTextCart = driver.findElement(By.xpath(cartPage.getDiscriptioHeaderText())).getText();
//		Assert.assertEquals(excelData.get(2), getDiscriptioHeaderTextCart, "Text NOT Matched");
//		logger.info(getDiscriptioHeaderTextCart + " is Present");
//
//		String getSauceLabsBackpackCartLabelText = driver
//				.findElement(By.xpath(cartPage.getSauceLabsBackpackCartLabel())).getText();
//		Assert.assertEquals(excelData.get(3), getSauceLabsBackpackCartLabelText, "Text NOT Matched");
//		logger.info(getSauceLabsBackpackCartLabelText + " is Present");
//
//		String getSauceLabsBackpackCartDiscriptionText = driver
//				.findElement(By.xpath(cartPage.getSauceLabsBackpackCartDiscription())).getText();
//		Assert.assertEquals(excelData.get(4), getSauceLabsBackpackCartDiscriptionText, "Text NOT Matched");
//		logger.info(getSauceLabsBackpackCartDiscriptionText + " is Present");
//
//		String getSauceLabsBackpackCartPriceText = driver
//				.findElement(By.xpath(cartPage.getSauceLabsBackpackCartPrice())).getText();
//		Assert.assertEquals(excelData.get(5), getSauceLabsBackpackCartPriceText, "Text NOT Matched");
//		logger.info(getSauceLabsBackpackCartPriceText + " is Present");
//
//		buttonAction.buttonClick(driver, By.xpath(cartPage.getSauceLabsBackpackCartCheckout()),
//				cartPage.getcheckoutCartLabel());
//		
//	}
	
	public void cartImageButtonAction(WebDriver driver) {
		buttonAction.buttonClick(driver, By.xpath(cartPage.getLogoButton()), cartPage.getCartImageClick());
	}
	
	public void cartCheckoutBittonAction(WebDriver driver) {
		buttonAction.buttonClick(driver, By.xpath(cartPage.getSauceLabsBackpackCartCheckout()), cartPage.getcheckoutCartLabel());
	}
	public void verifyProductInCart(WebDriver driver) throws InterruptedException {

		List<String> excelData = excelRead.readExcelData(excelDataYourCartPage);
		List<String> productLabels = excelRead.readExcelData(excelDataProductPage);
		
		
//		System.out.println("Product Labels" + productLabels);
//		System.out.println("++++++++++++++");
		
		String productSauceLabsBackpack = "Sauce Labs Backpack";
		String productSauceLabsBikeLight = "Sauce Labs Bike Light";
		String productSauceLabsBoltTShirt = "Sauce Labs Bolt T-Shirt";
		String productSauceLabsFleeceJacket = "Sauce Labs Fleece Jacket";
		String productSauceLabsOnesie = "Sauce Labs Onesie";
		String productTestAllTheThingsTShirtRed= "Test.allTheThings() T-Shirt (Red)";
		
		for(int productLabels1 = 0; productLabels1<6; productLabels1++) {
		String productlablesIt = productLabels.get(productLabels1);
	
		if(productSauceLabsBackpack.contains(productlablesIt)) {
		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBackpackProductAddToCart1()),	productLabel.getAddToCartLabel());
		buttonElement.isButtonEnable(driver, By.xpath(productPage.getSauceLabsBackpackProductRemoveFromCart1()), productLabel.getRemoveFromCartLabel());
//		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBackpackProductRemoveFromCart1()), productLabel.getRemoveFromCartLabel());
		cartImageButtonAction(driver);
		Thread.sleep(3000);
		String getSauceLabsBackpackCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartLabel())).getText();
		Assert.assertEquals(excelData.get(3), getSauceLabsBackpackCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartLabelText + " is Present");
		Thread.sleep(3000);
		String getSauceLabsBackpackCartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartDiscription())).getText();
		Assert.assertEquals(excelData.get(4), getSauceLabsBackpackCartDiscriptionText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartDiscriptionText + " is Present");
		Thread.sleep(3000);
		String getSauceLabsBackpackCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartPrice())).getText();
		Assert.assertEquals(excelData.get(5), getSauceLabsBackpackCartPriceText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartPriceText + " is Present");
		Thread.sleep(3000);
		cartCheckoutBittonAction(driver);
		}
//		else if(productSauceLabsBikeLight.contains(productlablesIt)) {
//			System.out.println("----------------" + productlablesIt);
//			buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBikeLightProductAddToCart()),	productLabel.getAddToCartLabel());
////			buttonElement.isButtonEnable(driver, By.xpath(productPage.getSauceLabsBackpackProductRemoveFromCart1()), productLabel.getRemoveFromCartLabel());
////			buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBackpackProductRemoveFromCart1()), productLabel.getRemoveFromCartLabel());
//			cartImageButtonAction(driver);
//			
//			String getSauceLabsBikeLightCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBikeLightLabel())).getText();
//			Assert.assertEquals(excelData.get(6), getSauceLabsBikeLightCartLabelText, "Text NOT Matched");
//			logger.info(getSauceLabsBikeLightCartLabelText + " is Present");
//
//			String getSauceLabsBikeLightCartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartDiscription())).getText();
//			Assert.assertEquals(excelData.get(7), getSauceLabsBikeLightCartDiscriptionText, "Text NOT Matched");
//			logger.info(getSauceLabsBikeLightCartDiscriptionText + " is Present");
//
//			String getSauceLabsBikeLightCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsBikeLightCartPrice())).getText();
//			Assert.assertEquals(excelData.get(8), getSauceLabsBikeLightCartPriceText, "Text NOT Matched");
//			logger.info(getSauceLabsBikeLightCartPriceText + " is Present");
//			
//			cartCheckoutBittonAction(driver);
//			
//			}
//		else if(productSauceLabsBoltTShirt.contains(productlablesIt)) {
//			System.out.println("----------------" + productlablesIt);
//			buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBoltTShirtProductAddToCart()), productLabel.getAddToCartLabel());
////			buttonElement.isButtonEnable(driver, By.xpath(productPage.getSauceLabsBoltTShirtProductRemoveFromCart()), productLabel.getRemoveFromCartLabel());
////			buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBoltTShirtProductRemoveFromCart()), productLabel.getRemoveFromCartLabel());
//			cartImageButtonAction(driver);
//			
//			String getSauceLabsBoltTShirtCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBoltTShirtLabel())).getText();
//			Assert.assertEquals(excelData.get(9), getSauceLabsBoltTShirtCartLabelText, "Text NOT Matched");
//			logger.info(getSauceLabsBoltTShirtCartLabelText + " is Present");
//			
//			String getSauceLabsBoltTShirtartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsBoltTShirtDiscription())).getText();
//			Assert.assertEquals(excelData.get(10), getSauceLabsBoltTShirtartDiscriptionText, "Text NOT Matched");
//			logger.info(getSauceLabsBoltTShirtartDiscriptionText + " is Present");
//
//			String getSauceLabsBoltTShirtCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsBoltTShirtCartPrice())).getText();
//			Assert.assertEquals(excelData.get(11), getSauceLabsBoltTShirtCartPriceText, "Text NOT Matched");
//			logger.info(getSauceLabsBoltTShirtCartPriceText + " is Present");
//
//			cartCheckoutBittonAction(driver);
//		}
//		else if(productSauceLabsFleeceJacket.contains(productlablesIt)) {
//			System.out.println("----------------" + productlablesIt);
//			buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsFleeceJacketProductAddToCart()), productLabel.getAddToCartLabel());
//			buttonElement.isButtonEnable(driver, By.xpath(productPage.getSauceLabsFleeceJacketProductRemoveFromCart()), productLabel.getRemoveFromCartLabel());
////			buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsFleeceJacketProductRemoveFromCart()), productLabel.getRemoveFromCartLabel());
//			cartImageButtonAction(driver);
//			
//			String getSauceLabsFleeceJacketCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBoltTShirtLabel())).getText();
//			Assert.assertEquals(excelData.get(12), getSauceLabsFleeceJacketCartLabelText, "Text NOT Matched");
//			logger.info(getSauceLabsFleeceJacketCartLabelText + " is Present");
//			
//			String getSauceLabsFleeceJacketCartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsBoltTShirtDiscription())).getText();
//			Assert.assertEquals(excelData.get(13), getSauceLabsFleeceJacketCartDiscriptionText, "Text NOT Matched");
//			logger.info(getSauceLabsFleeceJacketCartDiscriptionText + " is Present");
//
//			String getSauceLabsBackpackCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsBoltTShirtCartPrice())).getText();
//			Assert.assertEquals(excelData.get(14), getSauceLabsBackpackCartPriceText, "Text NOT Matched");
//			logger.info(getSauceLabsBackpackCartPriceText + " is Present");
//
//			cartCheckoutBittonAction(driver);
//		}
//		else if(productSauceLabsOnesie.contains(productlablesIt)) {
//			System.out.println("----------------" + productlablesIt);
//			buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsOnesieProductAddToCart()), productLabel.getAddToCartLabel());
//			buttonElement.isButtonEnable(driver, By.xpath(productPage.getSauceLabsOnesieProductRemoveFromCart()), productLabel.getRemoveFromCartLabel());
////			buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsOnesieProductRemoveFromCart()), productLabel.getRemoveFromCartLabel());
//			cartImageButtonAction(driver);
//			
//			String getSauceLabsOnesieCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsOnesieLabel())).getText();
//			Assert.assertEquals(excelData.get(15), getSauceLabsOnesieCartLabelText, "Text NOT Matched");
//			logger.info(getSauceLabsOnesieCartLabelText + " is Present");
//			
//			String getSauceLabsOnesieCartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsOnesieDiscription())).getText();
//			Assert.assertEquals(excelData.get(16), getSauceLabsOnesieCartDiscriptionText, "Text NOT Matched");
//			logger.info(getSauceLabsOnesieCartDiscriptionText + " is Present");
//
//			String getSauceLabsOnesieCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsOnesieCartPrice())).getText();
//			Assert.assertEquals(excelData.get(17), getSauceLabsOnesieCartPriceText, "Text NOT Matched");
//			logger.info(getSauceLabsOnesieCartPriceText + " is Present");
//
//			cartCheckoutBittonAction(driver);
//		}
//		else if(productTestAllTheThingsTShirtRed.contains(productlablesIt)) {
//			System.out.println("----------------" + productlablesIt);
//			buttonAction.buttonClick(driver, By.xpath(productPage.getTestAllTheThingsTShirtRedProductAddToCart()), productLabel.getAddToCartLabel());
//			buttonElement.isButtonEnable(driver, By.xpath(productPage.getTestAllTheThingsTShirtRedProductRemoveFromCart()), productLabel.getRemoveFromCartLabel());
////			buttonAction.buttonClick(driver, By.xpath(productPage.getTestAllTheThingsTShirtRedProductRemoveFromCart()), productLabel.getRemoveFromCartLabel());
//
//			cartImageButtonAction(driver);
//			
//			String getTestAllTheThingsTShirtRedCartLabelText = driver.findElement(By.xpath(cartPage.getTestAllTheThingsTShirtRedLabel())).getText();
//			Assert.assertEquals(excelData.get(18), getTestAllTheThingsTShirtRedCartLabelText, "Text NOT Matched");
//			logger.info(getTestAllTheThingsTShirtRedCartLabelText + " is Present");
//			
//			String getTestAllTheThingsTShirtRedCartDiscriptionText = driver.findElement(By.xpath(cartPage.getTestAllTheThingsTShirtRedDiscription())).getText();
//			Assert.assertEquals(excelData.get(19), getTestAllTheThingsTShirtRedCartDiscriptionText, "Text NOT Matched");
//			logger.info(getTestAllTheThingsTShirtRedCartDiscriptionText + " is Present");
//
//			String getTestAllTheThingsTShirtRedCartPriceText = driver.findElement(By.xpath(cartPage.getTestAllTheThingsTShirtRedCartPrice())).getText();
//			Assert.assertEquals(excelData.get(20), getTestAllTheThingsTShirtRedCartPriceText, "Text NOT Matched");
//			logger.info(getTestAllTheThingsTShirtRedCartPriceText + " is Present");
//
//			cartCheckoutBittonAction(driver);
//		}
	}
	}
	
}
