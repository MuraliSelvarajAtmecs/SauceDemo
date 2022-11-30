package com.reskill.testingutility;

import java.text.DecimalFormat;

import org.apache.log4j.Logger;

public class ItemTotal {
	static Logger logger = Logger.getLogger(ItemTotal.class);

	public double totalCovertion(double addition) {
		DecimalFormat decimalFormat=new DecimalFormat("#.##");
		String stringFormatTotal = decimalFormat.format(addition);
		double totalInDouble = Double.parseDouble(stringFormatTotal);
//		logger.info("Total: " + totalInDouble);
		return totalInDouble;
	}
}

