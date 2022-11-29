package com.reskill.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.reskill.reusables.FilePath;

public class CheckoutOverviewPageLocation {

	
static Logger logger = LogManager.getLogger(CheckoutOverviewPageLocation.class);
	
	public Properties readCheckoutOverviewPropertiesFile() {
		
		String homePage = FilePath.HOMEPAGE;
		String checkoutOverviewPage = FilePath.CHECKOUTOVERVIEWLOCATORSPATH;
		FileInputStream prodlocator = null;
		Properties pordProperties = null;
		try {
			prodlocator = new FileInputStream(homePage + File.separator + checkoutOverviewPage + File.separator + "checkoutOverview.properties");
			pordProperties = new Properties();
			pordProperties.load(prodlocator);
		} catch (FileNotFoundException e) {
			logger.error("File Not Found");
		} catch (IOException e) {
			logger.error("IOException");
		}
		return pordProperties;
	}
	
	public String getCheckoutOverviewTitle() {
		return readCheckoutOverviewPropertiesFile().getProperty("checkoutOverviewTitle");
	}
	public String getCheckoutPaymentInfo() {
		return readCheckoutOverviewPropertiesFile().getProperty("checkoutPaymentInfo");
	}
	public String getCheckoutSauceCard() {
		return readCheckoutOverviewPropertiesFile().getProperty("checkoutSauceCard");
	}
	public String getCheckoutShippingInfo() {
		return readCheckoutOverviewPropertiesFile().getProperty("checkoutShippingInfo");
	}
	public String getCheckoutShippingDeliver() {
		return readCheckoutOverviewPropertiesFile().getProperty("checkoutShippingDeliver");	
	}
	public String getChcekoutItemTotal() {
		return readCheckoutOverviewPropertiesFile().getProperty("chcekoutItemTotal");
	}
	public String getCheckoutTax() {
		return readCheckoutOverviewPropertiesFile().getProperty("checkoutTax");
	}
	public String getCheckoutTotal() {
		return readCheckoutOverviewPropertiesFile().getProperty("checkoutTotal");
	}
	public String getCheckoutCancel() {
		return readCheckoutOverviewPropertiesFile().getProperty("checkoutCancel");
	}
	public String getCheckoutFinish() {
		return readCheckoutOverviewPropertiesFile().getProperty("checkoutFinish");
	}
	public String getCheckoutCancelLabel() {
		return readCheckoutOverviewPropertiesFile().getProperty("checkoutCancelLabel");
	}
	public String getCheckoutFinishLabel() {
		return readCheckoutOverviewPropertiesFile().getProperty("checkoutFinishLabel");
	}
}
