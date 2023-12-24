package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage {
	
	WebDriver driver;
	
	public OpenAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="select[name=userSelect]")
	WebElement userSelect;
	
	@FindBy(css="select[name=currency]")
	WebElement currencySelect;
	
	@FindBy(css="button[type=submit]")
	WebElement processBtn;
	
	@FindBy(css="button[ng-class='btnClass3']")
	WebElement customerBtn;
	
	
	public String openAccountData(String user ,String currency) {
		Select sc= new Select(userSelect);
		sc.selectByVisibleText(user);
		Select sc1= new Select(currencySelect);
		sc1.selectByVisibleText(currency);
		processBtn.click();
		String text=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return text;
	}
	
	public CustomerPage click() {
		customerBtn.click();
		CustomerPage cp= new CustomerPage(driver);
		return cp;
	}

}
