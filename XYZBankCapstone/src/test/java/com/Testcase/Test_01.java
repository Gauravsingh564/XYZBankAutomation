package com.Testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.pages.AccountPage;
import com.pages.CustomerPage;
import com.pages.ManagerPage;
import com.pages.OpenAccountPage;
import com.pages.TransactionPage;
import com.utility.ExcelFileReader;

public class Test_01 extends BaseClass {
	
	
	@Test(dataProvider="getExcelData")
	public void CustomerLogin(String user ,String amount, String withDrawlAmount) throws Exception {
		lp.clickOnCustomerBtn();
		synchronized(driver) {
			driver.wait(2000);
		}
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
		AccountPage ap=lp.loginToApplication(user);
		HashMap<String,String> map =ap.getText();
		Assert.assertEquals(map.get("wlecomeTxt"),"Welcome Harry Potter !!" );
		Assert.assertEquals(map.get("accountNo"), "1004");
		Assert.assertEquals(map.get("balance"), "0");
		String depositText=ap.getDepositData(amount);
		Assert.assertEquals(depositText, "Deposit Successful");
		String withdrawlText=ap.getWithdrawlData(withDrawlAmount);
		Assert.assertEquals(withdrawlText, "Transaction successful");
		 TransactionPage tp=ap.clickOnTransactionBtn();
		synchronized(driver) {
			driver.wait(2000);
		}
		String tpUrl=driver.getCurrentUrl();
		Assert.assertEquals(tpUrl,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx");
		tp.getTransactionData();
		tp.logout();
		Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
		
	}
	
	
	@Test(dependsOnMethods="CustomerLogin" , dataProvider="getManagerData")
	public void ManagerLogin(String Fname, String Lname, String pinCode, String user, String currency, String searchUser) throws Exception {
		ManagerPage mp=lp.managerLogin();
		synchronized(driver) {
			driver.wait(2000);
		}
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
		String txt=mp.addCustomer(Fname , Lname , pinCode);
		Assert.assertEquals(txt, txt);
		OpenAccountPage op=mp.accountBtn();
		String text=op.openAccountData(user ,currency);
		Assert.assertEquals(text, text);
		CustomerPage cp=op.click();
		cp.searchCustomer(searchUser);
		cp.deleteCutomer();
	}
     
	
	
	@DataProvider
	String[][] getExcelData() throws Exception{
		ExcelFileReader r= new ExcelFileReader();
		String p=System.getProperty("user.dir")+"\\src\\test\\resources\\ProjectResource\\XYZBank.xlsx";
		String[][] data=r.getExcelFileData(p, "Customer");
		return data;
	}
	
	
	@DataProvider
	String[][] getManagerData() throws Exception{
		ExcelFileReader r= new ExcelFileReader();
		String p=System.getProperty("user.dir")+"\\src\\test\\resources\\ProjectResource\\XYZBank.xlsx";
		String[][] data=r.getExcelFileData(p, "Manager");
		return data;
	}
}
