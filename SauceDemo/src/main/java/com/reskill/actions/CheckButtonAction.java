package com.reskill.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckButtonAction {
	static Logger logger = Logger.getLogger(CheckButtonAction.class);

	CheckButtonElement buttonElement = new CheckButtonElement();

	public void buttonClick(WebDriver driver, By locator, String elementLabel) {
		if (buttonElement.isButtonEnable(driver, locator, elementLabel) == true) {
			driver.findElement(locator).click();
			logger.info(elementLabel + " is Clicked");
		} else {
			logger.info("Button is NOT Clickable");
		}
	}
	
}

