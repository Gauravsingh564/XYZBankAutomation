package com.Testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.pages.AccountPage;

public class DepositValidation extends BaseClass{
	public AccountPage ap;
	
	
	@Test
	public void TC_01() {
		lp.clickOnCustomerBtn();
		ap=lp.loginToApplication("Harry Potter");
		String depositText=ap.getDepositData("1000");
		Assert.assertEquals(depositText, "Deposit Successful");
		driver.navigate().refresh();
	}
	
	
	@Test(dependsOnMethods="TC_01") 
	public void TC_02() throws Exception {
		synchronized(driver) {
			driver.wait(2000);
		}
		ap.getDepositData("-11");
		String balance=ap.balanceText();
		Assert.assertEquals(balance, "0");
		driver.navigate().refresh();
		
	}

	@Test(dependsOnMethods="TC_02") 
	public void TC_03() throws Exception {
		synchronized(driver) {
			driver.wait(2000);
		}
		ap.getDepositData("0");
		String balance=ap.balanceText();
		Assert.assertEquals(balance, "0");
		driver.navigate().refresh();
		
	}

	@Test(dependsOnMethods="TC_03") 
	public void TC_04() throws Exception {
		synchronized(driver) {
			driver.wait(2000);
		}
		ap.getDepositData(" ");
		String msg=ap.validationMsg2();
		Assert.assertEquals(msg, "Please fill this field");
		
	}
	
	
}
