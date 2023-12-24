package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
   
	WebDriver driver;
	
	public CustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[type='text']")
	WebElement searchBox;
	
	@FindBy(xpath="(//button[@ng-click='deleteCust(cust)'])[6]")
	WebElement deleteBtn;
	
	public void searchCustomer(String searchUser) {
		searchBox.sendKeys(searchUser);
	}
	
	public void deleteCutomer() throws Exception {
		synchronized(driver) {
			driver.wait(2000);
		}
		searchBox.clear();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.querySelector(\".marTop \").scrollTop=500");
		deleteBtn.click();
	}
}
