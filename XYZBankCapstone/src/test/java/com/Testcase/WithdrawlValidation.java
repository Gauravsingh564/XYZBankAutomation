package com.Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.pages.AccountPage;

public class WithdrawlValidation extends BaseClass {
	
	public AccountPage ap;
	@Test
	public void TC01() throws Exception {
		Test();
		String text=ap.getWithdrawlData("500");
		Assert.assertEquals(text,"Transaction successful");
		
	}
	
	
	
	@Test
	public void TC02() throws Exception {
		ap.homeBtn();
		lp.clickOnCustomerBtn();
		ap=lp.loginToApplication("Harry Potter");
		ap.withDrawlClick();
		ap.getWithdrawlData("-111");
		String text=ap.balanceText();
		Assert.assertEquals(text, text);
	}
	@Test
	public void TC03() throws Exception {
		ap.homeBtn();
		lp.clickOnCustomerBtn();
		ap=lp.loginToApplication("Harry Potter");
		ap.withDrawlClick();
		ap.getWithdrawlData("0");
		String text=ap.balanceText();
		Assert.assertEquals(text, text);
	}
	@Test
	public void TC04() throws Exception {
		ap.homeBtn();
		lp.clickOnCustomerBtn();
		ap=lp.loginToApplication("Harry Potter");
		ap.withDrawlClick();
		ap.getWithdrawlData(" ");
		String text=ap.validationMsg();
		Assert.assertEquals(text, "Please fill this field");
	}
	
	
	
	 public void Test() {
			lp.clickOnCustomerBtn();
			ap=lp.loginToApplication("Harry Potter");
			 ap.getDepositData("1000");
				
		 }

}
