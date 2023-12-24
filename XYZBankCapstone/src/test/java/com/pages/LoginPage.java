package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="button[ng-click='customer()']")
	WebElement customerLogin;
	
	@FindBy(css="select[id='userSelect']")
	WebElement selectUser;
	
	@FindBy(css="button[type='submit']")
	WebElement loginBtn;
	
	@FindBy(css="button[ng-click='manager()']")
    WebElement managerLoginBtn;
	
	
	public void clickOnCustomerBtn() {
		customerLogin.click();
		
	}
	
	public AccountPage loginToApplication(String user) {
		Select st= new Select(selectUser);
		st.selectByVisibleText(user);
		loginBtn.click();
		AccountPage ap= new AccountPage(driver);
		return ap;
	}
	
	public ManagerPage managerLogin() {
		managerLoginBtn.click();
		ManagerPage mp= new ManagerPage(driver);
		return mp;
	}
}
