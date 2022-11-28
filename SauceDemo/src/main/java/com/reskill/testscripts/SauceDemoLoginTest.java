package com.reskill.testscripts;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.reskill.actions.CheckButtonAction;
import com.reskill.actions.CheckElement;
import com.reskill.actions.CheckItemText;
import com.reskill.actions.CheckItemTotal;
import com.reskill.actions.CheckTextField;
import com.reskill.actionutility.SelectWebDriver;
import com.reskill.pages.CartPageLocators;
import com.reskill.pages.CheckoutCompleteLocators;
import com.reskill.pages.CheckoutOverviewLocators;
import com.reskill.pages.CheckoutPageLocators;
import com.reskill.pages.ProductPageLocators;
import com.reskill.pages.UserLoginPageLocators;
import com.reskill.reusables.LoginDetails;
import com.reskill.reusables.PageEnteryConfirmation;
import com.reskill.testingutility.ExcelDataReads;
import com.reskill.testingutility.ExcelUtilities;

public class SauceDemoLoginTest extends LoginDetails {
	
	static Logger logger = Logger.getLogger(SauceDemoLoginTest.class);
	
	LoginDetails login = new LoginDetails();	
	SelectWebDriver requestDriver = new SelectWebDriver();
	CheckElement elementCheck = new CheckElement();
	UserLoginPageLocators userLoginPage = new UserLoginPageLocators();
	ProductPageLocators productPage = new ProductPageLocators();
	CartPageLocators cartPage = new CartPageLocators();
	CheckTextField textField = new CheckTextField();
	CheckoutPageLocators checkout = new CheckoutPageLocators();
	CheckButtonAction buttonAction = new CheckButtonAction();
	CheckoutOverviewLocators checkOverview = new CheckoutOverviewLocators();
	CheckItemTotal checkItemTotal = new CheckItemTotal();
	CheckItemText checkItemText = new CheckItemText();
	CheckoutCompleteLocators checkoutComplete = new CheckoutCompleteLocators();
	ExcelDataReads excelRead = new ExcelDataReads();
	ExcelUtilities readExcelData = new ExcelUtilities();
	PageEnteryConfirmation userLoginConfirm = new PageEnteryConfirmation();
	
	
	ExcelDataReads getData = new ExcelDataReads();
	

	public WebDriver driver;
	
	@BeforeTest
	public void selectBrowser() {
		driver = requestDriver.getDriver();
		requestDriver.getUrl(driver);
	}


@Test(priority = 1)
public void CheckUserCredentials() {
	
	List<String> excelData = excelRead.readExcelData(productPage.getnameofSheet0());
	
		
		
		String[] acceptedUsernamess = login.getLoginCredentials(driver, By.xpath(userLoginPage.getLoginName()));
		String[] passwordforallusers = login.getLoginCredentials(driver, By.xpath(userLoginPage.getstandardPasswordlist()));

		Assert.assertEquals(excelData.get(0), acceptedUsernamess[0], "Accepted User Names Text Missmatched");
		logger.info(acceptedUsernamess[0] + " is Present");
		
		Assert.assertEquals(excelData.get(1), acceptedUsernamess[1], "User Name Mismatch");
		logger.info(acceptedUsernamess[1] + " is Present");
		
		Assert.assertEquals(excelData.get(2), acceptedUsernamess[2], "Locked Out User Text Missmatched");
		logger.info(acceptedUsernamess[2] + " is Present");
		
		Assert.assertEquals(excelData.get(3), acceptedUsernamess[3], "Problem User Text Missmatched");
		logger.info(acceptedUsernamess[3] + " is Present");
		
		Assert.assertEquals(excelData.get(4), acceptedUsernamess[4], "Performance Glitch User Text Missmatched");
		logger.info(acceptedUsernamess[4] + " is Present");
			
		Assert.assertEquals(excelData.get(5), passwordforallusers[0], "Password for All Users Text Missmatched");
		logger.info(passwordforallusers[0] + " is Present");
		
		Assert.assertEquals(excelData.get(6), passwordforallusers[1], "Password Text Missmatched");
		logger.info(passwordforallusers[1] + " is Present");
	}
	


	@Test(priority = 2)
	public void validLoginTest() {
		textField.enterText(driver, By.xpath(userLoginPage.getUserName()), userLoginPage.getUserLabel(), userLoginPage.getStandardUserName());
		textField.enterText(driver, By.xpath(userLoginPage.getPassword()), userLoginPage.getuserPasswordLabel(), userLoginPage.getStandardPassword());
		buttonAction.buttonClick(driver, By.xpath(userLoginPage.getLoginButton()), userLoginPage.getLoginLable());
	}
	
	@Test(priority = 3)
	public void getIntoProductMessage() {
		String sauceLabsBackpackTitleText = "PRODUCTS";
		userLoginConfirm.isElementPresent(driver, By.xpath(productPage.getSauceLabsBackpackheaderTextClass()), sauceLabsBackpackTitleText);
	}
	
	
	
	@Test(priority = 4)
	public void productVerification(){
		
		List<String> excelData = excelRead.readExcelData(productPage.getnameofSheet1());

		
		buttonAction.buttonClick(driver, By.xpath(productPage.getProductImage1()), productPage.getSauceLabsBackpackLabel());
				
		String sauceLabsBackpackTitleGetText = driver.findElement(By.xpath(productPage.getSauceLabsBackpackProductTitle())).getText();
		Assert.assertEquals(excelData.get(0), sauceLabsBackpackTitleGetText, "Text NOT matched");
		logger.info(sauceLabsBackpackTitleGetText + " is Present");
		
		String sauceLabsBackpackDiscriptionGetText = driver.findElement(By.xpath(productPage.getSauceLabsBackpackProductDiscription())).getText();
		Assert.assertEquals(excelData.get(1), sauceLabsBackpackDiscriptionGetText, "Text NOT matched");
		logger.info(sauceLabsBackpackDiscriptionGetText + " is Present");
		
		String sauceLabsBackpackDiscriptionPriceText = driver.findElement(By.xpath(productPage.getSauceLabsBackpackProductPrice())).getText();
		Assert.assertEquals(excelData.get(2), sauceLabsBackpackDiscriptionPriceText, "Text NOT matched");
		logger.info(sauceLabsBackpackDiscriptionPriceText + " is Present");
		
		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBackpackProductAddToCart1()), productPage.getSauceLabsBackpackLabel());
//		buttonAction.buttonClick(driver, By.xpath(productPage.getSauceLabsBackpackProductRemoveFromCart1()), productPage.getRemoveFromCartLabel());
		buttonAction.buttonClick(driver, By.xpath(productPage.getproductBackButton()), productPage.getBackToProcductLabel());
		buttonAction.buttonClick(driver, By.xpath(productPage.getAddCartImage()), productPage.getcartImageLabel());
		
	}
	
	@Test(priority = 4)
	public void getIntoYourCartMassage() {
		String sauceLabsBackpackTitleText = "YOUR CART";
		userLoginConfirm.isElementPresent(driver, By.xpath(cartPage.getHeaderTextCart()), sauceLabsBackpackTitleText);
	}
	@Test(priority = 5)
	public void verifyProductInCart(){
		
		List<String> excelData = excelRead.readExcelData(productPage.getnameofSheet2());
		
		String getHeaderText = driver.findElement(By.xpath(cartPage.getHeaderTextCart())).getText();
		Assert.assertEquals(excelData.get(0), getHeaderText, "Text NOT Matched");
		logger.info(getHeaderText + " Text is Present");
		
		String getQtyHeaderTextCart = driver.findElement(By.xpath(cartPage.getQtyHeaderText())).getText();
		Assert.assertEquals(excelData.get(1), getQtyHeaderTextCart, "Text NOT Matched");
		logger.info(getQtyHeaderTextCart + " is Present");
		
		String getDiscriptioHeaderTextCart = driver.findElement(By.xpath(cartPage.getDiscriptioHeaderText())).getText();
		Assert.assertEquals(excelData.get(2), getDiscriptioHeaderTextCart, "Text NOT Matched");
		logger.info(getDiscriptioHeaderTextCart + " is Present");
		
		String getSauceLabsBackpackCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartLabel())).getText();
		Assert.assertEquals(excelData.get(3), getSauceLabsBackpackCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartLabelText + " is Present");
		
		String getSauceLabsBackpackCartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartDiscription())).getText();
		Assert.assertEquals(excelData.get(4), getSauceLabsBackpackCartDiscriptionText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartDiscriptionText + " is Present");
		
		String getSauceLabsBackpackCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartPrice())).getText();
		Assert.assertEquals(excelData.get(5), getSauceLabsBackpackCartPriceText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartPriceText + " is Present");
	
		buttonAction.buttonClick(driver, By.xpath(cartPage.getSauceLabsBackpackCartCheckout()), cartPage.getcheckoutCartLabel());
	}
	
	@Test(priority = 6)
	public void checkOut() {
	List<String> excelData = excelRead.readExcelData(productPage.getnameofSheet3());
		
		
		String getCheckoutHeader = driver.findElement(By.xpath(checkout.getCheckoutHeader())).getText();
		Assert.assertEquals(excelData.get(0), getCheckoutHeader, "Text is NOT Matched");
		logger.info(getCheckoutHeader + " is Present");
		
		textField.enterText(driver, By.xpath(checkout.getCheckoutFirstName()), checkout.getCheckoutFnameLabel(), excelData.get(1));
		textField.enterText(driver, By.xpath(checkout.checkoutLastName()), checkout.getcheckoutLnameLabel(), excelData.get(2));
		textField.enterText(driver, By.xpath(checkout.getcheckoutzip()), checkout.getcheckoutZipLabel(), excelData.get(3));
		buttonAction.buttonClick(driver, By.xpath(checkout.getcheckoutContinue()), excelData.get(4));
//		buttonAction.buttonClick(driver, By.xpath(checkout.getcheckoutCancel()), excelData.get(5));
	}

	@Test(priority = 7)
	public void checkoutOverview() {
	List<String> excelData = excelRead.readExcelData(productPage.getnameofSheet4());
		

		String getCheckoutOverviewTitle = driver.findElement(By.xpath(checkOverview.getCheckoutOverviewTitle()))
				.getText();
		Assert.assertEquals(excelData.get(0), getCheckoutOverviewTitle, "Text is NOT Matched");
		logger.info(getCheckoutOverviewTitle + " is Present");

		String getCheckoutPaymentInfo = driver.findElement(By.xpath(checkOverview.getCheckoutPaymentInfo())).getText();
		Assert.assertEquals(excelData.get(1), getCheckoutPaymentInfo, "Text is NOT Matched");
		logger.info(getCheckoutPaymentInfo + " is Present");

		String getCheckoutSauceCard = driver.findElement(By.xpath(checkOverview.getCheckoutSauceCard())).getText();
		Assert.assertEquals(excelData.get(2), getCheckoutSauceCard, "Text is NOT Matched");
		logger.info(getCheckoutSauceCard + " is Present");

		String getCheckoutShippingInfo = driver.findElement(By.xpath(checkOverview.getCheckoutShippingInfo()))
				.getText();
		Assert.assertEquals(excelData.get(3), getCheckoutShippingInfo, "Text is NOT Matched");
		logger.info(getCheckoutShippingInfo + " is Present");

		String getCheckoutShippingDeliver = driver.findElement(By.xpath(checkOverview.getCheckoutShippingDeliver()))
				.getText();
		Assert.assertEquals(excelData.get(4), getCheckoutShippingDeliver, "Text is NOT Matched");
		logger.info(getCheckoutShippingDeliver + " is Present");

		String iteamTotalText = checkItemText.checkoutText(driver, By.xpath(checkOverview.getChcekoutItemTotal()));
		Assert.assertEquals(excelData.get(5), iteamTotalText, " Text is NOT Matched");
		logger.info(iteamTotalText + " is Present");

		String itemTaxText = checkItemText.checkoutText(driver, By.xpath(checkOverview.getCheckoutTax()));
		Assert.assertEquals(excelData.get(6), itemTaxText, " Text is NOT Matched");
		logger.info(itemTaxText + " is Present");

		double itemTotal = checkItemTotal.checkoutOverviewTotal(driver, By.xpath(checkOverview.getChcekoutItemTotal()));
		double tax = checkItemTotal.checkoutOverviewTotal(driver, By.xpath(checkOverview.getCheckoutTax()));
		double add = itemTotal + tax;
		logger.info("Total: " + add);
		
		double total = checkItemTotal.checkoutOverviewTotal(driver, By.xpath(checkOverview.getCheckoutTotal()));
		Assert.assertEquals(add, total, " Total is NOT Matched");
		logger.info(total + " Total is Matched");	

		buttonAction.buttonClick(driver, By.xpath(checkOverview.getCheckoutFinish()), excelData.get(7));
//		buttonAction.buttonClick(driver, By.xpath(checkOverview.getCheckoutCancel()), excelData.get(8));
	}
	
	@Test(priority = 8)
	public void checkoutComplete() {
		List<String> excelData = excelRead.readExcelData(productPage.getnameofSheet5());

		String getCheckoutCompleteText = driver.findElement(By.xpath(checkoutComplete.getCheckoutComplete())).getText();
		Assert.assertEquals(excelData.get(0), getCheckoutCompleteText, " Text is NOT Matched");
		logger.info(getCheckoutCompleteText + " is Preasent");

		String getCompleteHeaderText = driver.findElement(By.xpath(checkoutComplete.getCompleteHeaderText())).getText();
		Assert.assertEquals(excelData.get(1), getCompleteHeaderText, " Text is NOT Matched");
		logger.info(getCompleteHeaderText + " is Present");

		String getOrderDiscription = driver.findElement(By.xpath(checkoutComplete.getOrderDiscription())).getText();
		Assert.assertEquals(excelData.get(2), getOrderDiscription, " Text is NOT Matched");
		logger.info(getOrderDiscription + " is Present");

		elementCheck.isElementPresent(driver, By.xpath(checkoutComplete.getponnyExpressLogo()), checkoutComplete.getPonyExpressLogoLabel());

		buttonAction.buttonClick(driver, By.xpath(checkoutComplete.getBackHomeButton()), excelData.get(3));
		
	
	}
	
	
	@AfterTest
	public void closeDriver() {
		requestDriver.closeBrowser(driver);
	}

}
