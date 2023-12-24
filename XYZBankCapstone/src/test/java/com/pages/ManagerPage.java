package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage {
	
	WebDriver driver;
	
	public ManagerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="button[ng-class='btnClass1']")
	WebElement addCustomer;
	
	@FindBy(css="input[placeholder='First Name']")
	WebElement firstName;
	
	@FindBy(css="input[placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(css="input[placeholder='Post Code']")
	WebElement postCode;
	
	@FindBy(css="button[type='submit']")
	WebElement addBtn;
	
	@FindBy(css="button[ng-class='btnClass2']")
	WebElement openAccountBtn;
	
	public String addCustomer(String Fname, String Lname, String pinCode) {
		addCustomer.click();
		firstName.sendKeys(Fname);
		lastName.sendKeys(Lname);
		postCode.sendKeys(pinCode.substring(0, 4));
		addBtn.click();
		String text=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return text;
		
		
	}
	
	public OpenAccountPage accountBtn() {
		openAccountBtn.click();
		OpenAccountPage openAcc=new OpenAccountPage(driver);
		return openAcc;
	}
	

}
