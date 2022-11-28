package com.reskill.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckItemText {
	
	public String getString(WebDriver driver, By locator) {
		String text = driver.findElement(locator).getText();
		String[] splitText = text.split("\\$");
		String itemTotalText = splitText[0];
		return itemTotalText;
}
	
	public String checkoutText(WebDriver driver, By locator) {
		String itemTotalText = getString(driver, locator);
		return itemTotalText;
	}

}
