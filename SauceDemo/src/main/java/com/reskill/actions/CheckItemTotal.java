package com.reskill.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckItemTotal {

	
	public double getPrice(WebDriver driver, By locator) {
	String value = driver.findElement(locator).getText();
		String[] splitValue = value.split("\\$");
		String itemTotal = splitValue[1];
		double parseDouble = Double.parseDouble(itemTotal);
		return parseDouble;
	}
	
	public double checkoutOverviewTotal(WebDriver driver, By locator) {
		double itemTotal = getPrice(driver, locator);
		return itemTotal;
	}
}
