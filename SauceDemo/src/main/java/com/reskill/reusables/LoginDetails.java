package com.reskill.reusables;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginDetails {

	static Logger logger = Logger.getLogger(LoginDetails.class);
	
	public String[] getLoginCredentials(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		String[] lines = element.getText().split("\\n");
		return lines;
	}
	
}