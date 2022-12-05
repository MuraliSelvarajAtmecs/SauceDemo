package com.reskill.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.reskill.actionutility.SelectWebDriver;
import com.reskill.reusables.AddCartAndCheckout;
import com.reskill.reusables.CheckAllProducts;
import com.reskill.reusables.CheckoutComplete;
import com.reskill.reusables.CheckoutInfo;
import com.reskill.reusables.CheckoutOverview;
import com.reskill.reusables.UserLoginPage;

public class SauceDemoProductVerification {
	public WebDriver driver;
	
	SelectWebDriver requestDriver = new SelectWebDriver();
	UserLoginPage loginPage = new UserLoginPage();
	AddCartAndCheckout addCartAndCheckout = new AddCartAndCheckout();
	CheckoutInfo checkoutInfo = new CheckoutInfo();
	CheckoutOverview checkoutOverviewInfo = new CheckoutOverview();
	CheckoutComplete checkoutComplete = new CheckoutComplete();
	CheckAllProducts check = new CheckAllProducts();
	
	@BeforeTest
	public void selectBrowser() {
		driver = requestDriver.getDriver();
		requestDriver.getUrl(driver);
	}
	
	@Test 
	public void sauceDemo() {
		loginPage.validLoginTest(driver);
		addCartAndCheckout.verifyProductInCart(driver);
//		check.verifyAllProducts(driver);
		checkoutInfo.verifyCheckoutUserInfo(driver, "Murali", "Mulla", 632510);
		checkoutOverviewInfo.VerifyCheckoutOverview(driver);
		checkoutComplete.VerifyCheckoutCompleted(driver);
	}
	
	@AfterTest
	public void closeDriver() {
		requestDriver.closeBrowser(driver);
	}

}
