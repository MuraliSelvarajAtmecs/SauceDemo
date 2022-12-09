package com.reskill.reusables;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.reskill.pages.UserLoginPageLocation;

public class PageEnteryConfirmation {
	static Logger logger = Logger.getLogger(PageEnteryConfirmation.class);
	UserLoginPageLocation login = new UserLoginPageLocation();
	String expUserName;

	public boolean isElementPresent(WebDriver driver, By locator, String elementLabel) {
		try {
			driver.findElement(locator);
		} catch (NoSuchElementException e) {
			logger.info(elementLabel + " is NOT logined Successfully");
			return false;
		}
		logger.info("User logged in " +elementLabel + " Page Successfully");
		return true;
	}
}

