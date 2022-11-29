package com.reskill.reusables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.reskill.actions.CheckButtonAction;
import com.reskill.actions.CheckTextField;
import com.reskill.pages.UserLoginPageLocation;

public class UserLoginPage {
	CheckTextField textField = new CheckTextField();
	UserLoginPageLocation userLoginPage = new UserLoginPageLocation();
	CheckButtonAction buttonAction = new CheckButtonAction();
	public WebDriver driver;
	
	public void validLoginTest(WebDriver driver) {
		textField.enterText(driver, By.xpath(userLoginPage.getUserName()), userLoginPage.getUserLabel(), userLoginPage.getStandardUserName());
		textField.enterText(driver, By.xpath(userLoginPage.getPassword()), userLoginPage.getuserPasswordLabel(), userLoginPage.getStandardPassword());
		buttonAction.buttonClick(driver, By.xpath(userLoginPage.getLoginButton()), userLoginPage.getLoginLable());
	}

}
