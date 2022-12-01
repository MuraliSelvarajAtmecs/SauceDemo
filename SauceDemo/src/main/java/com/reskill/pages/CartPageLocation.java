package com.reskill.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.reskill.reusables.FilePath;

public class CartPageLocation {
	
static Logger logger = LogManager.getLogger(UserLoginPageLocation.class);
	
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
	
	
	public String getSauceLabsBikeLightLabel() {
		return readCartPropertiesFile().getProperty("sauceLabsBikeLightLabel");
	}
	
	public String getSauceLabsBikeLightDiscription() {
		return readCartPropertiesFile().getProperty("sauceLabsBikeLightCartDiscription");
	}
	
	public String getSauceLabsBikeLightCartPrice() {
		return readCartPropertiesFile().getProperty("sauceLabsBikeLightCartPrice");
	}
	
	public String getSauceLabsBoltTShirtLabel() {
		return readCartPropertiesFile().getProperty("sauceLabsBoltTShirtLabel");
	}
	
	public String getSauceLabsBoltTShirtDiscription() {
		return readCartPropertiesFile().getProperty("sauceLabsBoltTShirtCartDiscription");
	}
	
	public String getSauceLabsBoltTShirtCartPrice() {
		return readCartPropertiesFile().getProperty("sauceLabsBoltTShirtCartPrice");
	}
	
	public String getSauceLabsOnesieLabel() {
		return readCartPropertiesFile().getProperty("sauceLabsOnesieLabel");
	}
	
	public String getSauceLabsOnesieDiscription() {
		return readCartPropertiesFile().getProperty("sauceLabsOnesieCartDiscription");
	}
	
	public String getSauceLabsOnesieCartPrice() {
		return readCartPropertiesFile().getProperty("sauceLabsOnesieCartPrice");
	}
	
	public String getTestAllTheThingsTShirtRedLabel() {
		return readCartPropertiesFile().getProperty("testAllTheThingsTShirtRedLabel");
	}
	
	public String getTestAllTheThingsTShirtRedDiscription() {
		return readCartPropertiesFile().getProperty("testAllTheThingsTShirtRedCartDiscription");
	}
	
	public String getTestAllTheThingsTShirtRedCartPrice() {
		return readCartPropertiesFile().getProperty("testAllTheThingsTShirtRedCartPrice");
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
	
	public String getLogoButton() {
		return readCartPropertiesFile().getProperty("cartButton");
	}
	
	public String getCartImageClick() {
		return readCartPropertiesFile().getProperty("cartImage");
	}
	
}
