package com.reskill.reusables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.reskill.actions.CheckButtonAction;
import com.reskill.pages.CartPageLocation;

public class CartImageAction {
	CheckButtonAction buttonAction = new CheckButtonAction();
	CartPageLocation cartPage = new CartPageLocation();
	
	public void cartImageButtonAction(WebDriver driver) {
		buttonAction.buttonClick(driver, By.xpath(cartPage.getLogoButton()), cartPage.getCartImageClick());
	}

}
