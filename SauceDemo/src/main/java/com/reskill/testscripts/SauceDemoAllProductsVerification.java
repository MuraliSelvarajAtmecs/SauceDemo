package com.reskill.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.reskill.actionutility.SelectWebDriver;
import com.reskill.reusables.AddCart;
import com.reskill.reusables.CheckAllProducts;
import com.reskill.reusables.CheckoutComplete;
import com.reskill.reusables.CheckoutInfo;
import com.reskill.reusables.CheckoutOverview;
import com.reskill.reusables.GetProductDetails;
import com.reskill.reusables.UserLoginPage;
import com.reskill.reusables.VerifyCartDetails;

public class SauceDemoAllProductsVerification {
	
	public WebDriver driver;
	
	SelectWebDriver requestDriver = new SelectWebDriver();
	UserLoginPage loginPage = new UserLoginPage();
	CheckoutInfo checkoutInfo = new CheckoutInfo();
	CheckoutOverview checkoutOverviewInfo = new CheckoutOverview();
	CheckoutComplete checkoutComplete = new CheckoutComplete();
	CheckAllProducts checkAllProcucts = new CheckAllProducts();
	AddCart addCartAndCheckout = new AddCart();
	GetProductDetails getProd = new GetProductDetails();
	VerifyCartDetails cartDetails = new VerifyCartDetails();
	GetProductDetails prod = new GetProductDetails();
	
	  
	@BeforeTest
	public void selectBrowser() {
		driver = requestDriver.getDriver();
		requestDriver.getUrl(driver);
	}
	
	@Test
	public void sauceDemo(){
		loginPage.validLoginTest(driver);
		cartDetails.verifyCartProduct(driver);
//		addCartAndCheckout.verifyProductInCart(driver);
		checkoutInfo.verifyCheckoutUserInfo(driver, "Murali", "Mulla", 632510);
		checkoutOverviewInfo.VerifyCheckoutOverview(driver);
		checkoutComplete.VerifyCheckoutCompleted(driver);
	}
	
	@AfterTest
	public void closeDriver() {
		requestDriver.closeBrowser(driver);
	}


}
