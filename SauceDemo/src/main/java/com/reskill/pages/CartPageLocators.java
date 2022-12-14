package com.reskill.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.reskill.reusables.FilePath;

public class CartPageLocators {
	
static Logger logger = LogManager.getLogger(UserLoginPageLocators.class);
	
	public Properties readCartPropertiesFile() {
		String homePage = FilePath.HOMEPAGE;
		String cartPage = FilePath.CARTPAGELOCATORSPATH;
		FileInputStream prodlocator = null;
		Properties pordProperties = null;
		try {
			prodlocator = new FileInputStream(homePage + File.separator + cartPage + File.separator + "cartPage.properties");
			pordProperties = new Properties();
			pordProperties.load(prodlocator);
		} catch (FileNotFoundException e) {
			logger.error("File Not Found");
		} catch (IOException e) {
			logger.error("IOException");
		}
		return pordProperties;
	}
	
	public String getHeaderTextCart1() {
		return readCartPropertiesFile().getProperty("headerTextCart");
	}
	
	public String getHeaderTextCart() {
		return readCartPropertiesFile().getProperty("headerTextCart");
	}
	
	public String getQtyHeaderText() {
		return readCartPropertiesFile().getProperty("qtyHeaderText");
	}
	
	public String getDiscriptioHeaderText() {
		return readCartPropertiesFile().getProperty("discriptioHeaderText");
	}
	
	public String getSauceLabsBackpackCartLabel() {
		return readCartPropertiesFile().getProperty("sauceLabsBackpackCartLabel");
	}
	
	public String getSauceLabsBackpackCartDiscription() {
		return readCartPropertiesFile().getProperty("sauceLabsBackpackCartDiscription");
	}
	
	public String getSauceLabsBackpackCartPrice() {
		return readCartPropertiesFile().getProperty("sauceLabsBackpackCartPrice");
	}
	
	public String getSauceLabsBackpackCartContinueShoping() {
		return readCartPropertiesFile().getProperty("sauceLabsBackpackCartContinueShoping");
	}
	
	public String getSauceLabsBackpackCartCheckout() {
		return readCartPropertiesFile().getProperty("sauceLabsBackpackCartCheckout");
	}

	public String getcheckoutCartLabel() {
		return readCartPropertiesFile().getProperty("checkoutCart");
	}
}
