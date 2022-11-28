package com.reskill.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.reskill.reusables.FilePath;

public class CheckoutPageLocators {

static Logger logger = LogManager.getLogger(CheckoutPageLocators.class);
	
	public Properties readCheckoutPropertiesFile() {
		String homePage = FilePath.HOMEPAGE;
		String checkoutPage = FilePath.CHECKOUTPAGELOCATORSPATH;
		FileInputStream prodlocator = null;
		Properties pordProperties = null;
		try {
			prodlocator = new FileInputStream(homePage + File.separator + checkoutPage + File.separator + "checkout.properties");
			pordProperties = new Properties();
			pordProperties.load(prodlocator);
		} catch (FileNotFoundException e) {
			logger.error("File Not Found");
		} catch (IOException e) {
			logger.error("IOException");
		}
		return pordProperties;
	}
	
	public String getCheckoutHeader() {
		return readCheckoutPropertiesFile().getProperty("checkoutHeader");
	}
	public String getCheckoutFirstName() {
		return readCheckoutPropertiesFile().getProperty("checkoutFirstName");
	}
	public String checkoutLastName() {
		return readCheckoutPropertiesFile().getProperty("checkoutLastName");
	}
	public String getcheckoutzip() {
		return readCheckoutPropertiesFile().getProperty("checkoutzip");
	}
	public String getcheckoutContinue() {
		return readCheckoutPropertiesFile().getProperty("checkoutContinue");
	}
	public String getcheckoutCancel() {
		return readCheckoutPropertiesFile().getProperty("checkoutCancel");
	}
	public String getCheckoutFnameLabel() {
		return readCheckoutPropertiesFile().getProperty("checkoutFnameLabel");
	}
	public String getcheckoutLnameLabel() {
		return readCheckoutPropertiesFile().getProperty("checkoutLnameLabel");
	}
	public String getcheckoutZipLabel() {
		return readCheckoutPropertiesFile().getProperty("checkoutZipLabel");
	}
}
