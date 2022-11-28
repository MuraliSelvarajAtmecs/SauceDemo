package com.reskill.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.reskill.reusables.FilePath;

public class ProductPageLocators {
	
	static Logger logger = LogManager.getLogger(UserLoginPageLocators.class);
	
	public Properties readProductPropertiesFile() {
		String homePage = FilePath.HOMEPAGE;
		String productPage = FilePath.PRODUCTPAGELOCATORSPATH;
		
		String fileSeprator = File.separator;
		
		FileInputStream prodlocator = null;
		Properties pordProperties = null;
		try {
			prodlocator = new FileInputStream(homePage + fileSeprator + productPage + fileSeprator + "products.properties");
			pordProperties = new Properties();
			pordProperties.load(prodlocator);
		} catch (FileNotFoundException e) {
			logger.error("File Not Found");
		} catch (IOException e) {
			logger.error("IOException");
		}
		return pordProperties;
	}
	
	public String getKey(String key) {
		return (String) readProductPropertiesFile().get(key);
	}
	
	public String getMenu() {
		return readProductPropertiesFile().getProperty("menuButton");
	}
	public String getMenuClose() {
		return readProductPropertiesFile().getProperty("closeButton");
	}
	
	public String getProductImage1() {
		return readProductPropertiesFile().getProperty("productImage1");
	}
	public String getProductImage2() {
		return readProductPropertiesFile().getProperty("productImage2");
	}
	
	public String getSauceLabsBackpackProductTitle() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductTitle");
	}
	
	public String getSauceLabsBackpackheaderTextClass() {
		return  readProductPropertiesFile().getProperty("headerTextClass");
	}
	
	public String getSauceLabsBackpackProductDiscription() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductDiscription");
	}
	
	public String getSauceLabsBackpackProductPrice() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductPrice");
	}
	
	public String getSauceLabsBackpackProductAddToCart1() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductAddToCart");
	}
	
	public String getSauceLabsBackpackProductRemoveFromCart1() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductRemoveFromCart");
	}
	
	public String getSauceLabsBackpackProductAddToCart2() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductAddToCart");
	}
	
	public String getSauceLabsBackpackProductRemoveFromCart2() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductRemoveFromCart");
	}
	
	public String getproductBackButton() {
		return  readProductPropertiesFile().getProperty("productBackButton");
	}
	
	public String getSauceLabsBackpackLabel() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackLabel");
	} 
	
	public String getSauceLabsBikeLightLabel() {
		return  readProductPropertiesFile().getProperty("SauceLabsBikeLightLabel");
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

	public String getnameofSheet0() {
		return  readProductPropertiesFile().getProperty("nameofSheet0");
	}
	public String getnameofSheet1() {
		return  readProductPropertiesFile().getProperty("nameofSheet1");
	}
	public String getnameofSheet2() {
		return  readProductPropertiesFile().getProperty("nameofSheet2");
	}
	public String getnameofSheet3() {
		return  readProductPropertiesFile().getProperty("nameofSheet3");
	}
	public String getnameofSheet4() {
		return  readProductPropertiesFile().getProperty("nameofSheet4");
	}
	public String getnameofSheet5() {
		return  readProductPropertiesFile().getProperty("nameofSheet5");
	}
}