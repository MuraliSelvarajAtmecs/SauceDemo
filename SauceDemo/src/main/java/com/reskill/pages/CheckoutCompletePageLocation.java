package com.reskill.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.reskill.reusables.FilePath;

public class CheckoutCompletePageLocation {
	
	static Logger logger = LogManager.getLogger(CheckoutCompletePageLocation.class);


public Properties readCheckoutCompletePropertiesFile() {
		
	String homePage = FilePath.HOMEPAGE;
	String checkoutCompletePage = FilePath.CHECKOUTCOMPLETELOCATORSPATH;
	String fileSeprator = File.separator;
	
		FileInputStream prodlocator = null;
		Properties pordProperties = null;
		try {
			prodlocator = new FileInputStream(homePage + fileSeprator + checkoutCompletePage +File.separator+ "checkoutComplete.properties");
			pordProperties = new Properties();
			pordProperties.load(prodlocator);
		} catch (FileNotFoundException e) {
			logger.error("File Not Found");
		} catch (IOException e) {
			logger.error("IOException");
		}
		return pordProperties;
	}

	public String getCheckoutComplete() {
		return readCheckoutCompletePropertiesFile().getProperty("checkoutComplete");
	}
	
	public String getCompleteHeaderText() {
		return readCheckoutCompletePropertiesFile().getProperty("completeHeaderText");
	}
	
	public String getOrderDiscription() {
		return readCheckoutCompletePropertiesFile().getProperty("orderDiscription");
	}
	
	public String getponnyExpressLogo() {
		return readCheckoutCompletePropertiesFile().getProperty("ponnyExpressLogo");
	}
	
	public String getBackHomeButton() {
		return readCheckoutCompletePropertiesFile().getProperty("backHomeButton");
	}
	
	public String getPonyExpressLogoLabel() {
		return readCheckoutCompletePropertiesFile().getProperty("ponyExpressLogoLabel");
	}
	
	
	
}
