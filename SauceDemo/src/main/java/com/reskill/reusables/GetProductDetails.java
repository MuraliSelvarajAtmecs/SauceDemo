package com.reskill.reusables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetProductDetails {

	public WebDriver driver;
	
	List<WebElement> itemCart = driver.findElements(By.xpath("//div[@class='inventory_item_description']//button"));
	List<WebElement> itemLabel = driver.findElements(By.xpath("//div[@class='inventory_item_description']//div[@class='inventory_item_name']"));
	List<WebElement> itemDisc = driver.findElements(By.xpath("//div[@class='inventory_item_description']//div[@class='inventory_item_desc']"));
	List<WebElement> itemPrice = driver.findElements(By.xpath("//div[@class='inventory_item_description']//div[@class='inventory_item_price']"));
	
	List<WebElement> cartItemLabel = driver.findElements(By.xpath("//div[@class='cart_item_label']//div[@class='inventory_item_name']"));
	List<WebElement> cartItemDisc = driver.findElements(By.xpath("//div[@class='cart_item_label']//div[@class='inventory_item_desc']"));
	List<WebElement> cartItemPrice = driver.findElements(By.xpath("//div[@class='cart_item_label']//div[@class='inventory_item_price']"));

	int num=0;
	

	for (int buttonAction = 0; buttonAction < itemCart.size(); buttonAction++) {
		itemCart.get(buttonAction).click();
		
		
		
		System.err.println("Line Number:- "+num);
		String itemLabels = itemLabel.get(buttonAction).getText();
		System.out.println("The output of Item Labels is:- " + itemLabels);
		String itemDiscriptions = itemDisc.get(buttonAction).getText();
		System.out.println("The output of Discription is:- " + itemDiscriptions);
		String itemPrices = itemPrice.get(buttonAction).getText();
		System.out.println("The output of Price is:- " + itemPrices);
		num++;
	}
	driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	String cartText = driver.findElement(By.xpath("//div[@class='header_secondary_container']")).getText();
	System.out.println("Page confirmation:- " + cartText);

//	Thread.sleep(2000);
//	WebDriverWait wait = new WebDriverWait(driver, 5000);
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn_secondary back btn_medium']")));
	driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();

}

}
