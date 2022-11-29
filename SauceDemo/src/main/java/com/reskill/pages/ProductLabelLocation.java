package com.reskill.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.reskill.reusables.FilePath;

public class ProductLabelLocation {

static Logger logger = LogManager.getLogger(UserLoginPageLocation.class);
	
	public Properties readProductPropertiesFile() {
		String homePage = FilePath.HOMEPAGE;
		String productLabel = FilePath.PRODUCTLABELLOCATORSPATH;
		
		FileInputStream prodlocator = null;
		Properties pordProperties = null;
		try {
			prodlocator = new FileInputStream(homePage + File.separator + productLabel + File.separator + "productLabels.properties");
			pordProperties = new Properties();
			pordProperties.load(prodlocator);
		} catch (FileNotFoundException e) {
			logger.error("File Not Found");
		} catch (IOException e) {
			logger.error("IOException");
		}
		return pordProperties;
	}
	
	public String getAddToCartLabel() {
		return  readProductPropertiesFile().getProperty("addToCartLabel");
	}
	
	public String getRemoveFromCartLabel() {
		return  readProductPropertiesFile().getProperty("removeFromCartLabel");
	}
	
	public String getBackToProcductLabel() {
		return  readProductPropertiesFile().getProperty("backToProcduct");
	}
	
	public String getAddCartImage() {
		return  readProductPropertiesFile().getProperty("addCartImage");
	}
	
	public String getcartImageLabel() {
		return  readProductPropertiesFile().getProperty("cartImageClick");
	}
	
}
