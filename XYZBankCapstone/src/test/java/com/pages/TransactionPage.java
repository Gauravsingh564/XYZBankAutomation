package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage {
	
	WebDriver driver;
	
	public TransactionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table //tbody//tr//td")
	List<WebElement> TransactionList;
	
	@FindBy(css="button[ng-show='logout']")
	WebElement logOutBtn;
	@FindBy(css="button[ng-click='home()']")
	WebElement homeBtn;
	
	public void getTransactionData() {
		for(int i=0;i<TransactionList.size();i++) {
			System.out.println(TransactionList.get(i).getText());
		}
	}
	
	public void logout() {
		logOutBtn.click();
		homeBtn.click();
	}

}
