package com.reskill.reusables;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.reskill.pages.CartPageLocation;


public class VerifyCartDetails {
	AddAllItemsInCart addAllItems = new AddAllItemsInCart();
	CartImageAction cartImage = new CartImageAction();
	public WebDriver driver;
	AddProdFromExcel addProd = new AddProdFromExcel();
	GetProductDetails getProd = new GetProductDetails();
	CartCheckoutButton cartButton = new CartCheckoutButton();

	public void verifyCartProduct(WebDriver driver) {
//		addAllItems.addAllItems(driver);
//		cartImage.cartImageButtonAction(driver);

		List<String> data = getProd.prodDetails(driver);
		List<String> excelData = addProd.verifyProductInCartExcel(driver);

		
		for(int num=0; num<excelData.size(); num++) {
//			for(int ele=1; ele<excelData.size(); ele++) {
			if(data.get(num).contains(excelData.get(num)))
//			if(excelData.get(num).contains(data.get(ele))){
				System.out.println(data.get(num));
			}

		cartButton.cartCheckoutButtonAction(driver);
		
			}

		}

//	}
//}
