package com.pages;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    
     WebDriver driver;
     WebDriverWait wait;
     
     public AccountPage(WebDriver driver) {
    	 this.driver=driver;
    	 PageFactory.initElements(driver, this);
    	 wait= new WebDriverWait(driver,Duration.ofSeconds(5));
     }
     

     
     
     @FindBy(xpath="(//div[@class='borderM box padT20 ng-scope'] //div //strong)[1]")
     WebElement welcomeTxt;
     
     @FindBy(xpath="(//div[@ng-hide='noAccount'])[1] //strong[1]")
     WebElement accountNo;
     
     @FindBy(xpath="(//div[@ng-hide='noAccount'])[1] //strong[2]")
     WebElement balance;
     
     @FindBy(css="button[ng-class='btnClass2']")
     WebElement depositBtn;
     
     @FindBy(css="input[placeholder='amount']")
     WebElement depositeField;
     
     @FindBy(css="button[type='submit']")
     WebElement addAmount;
     
     @FindBy(css="span[ng-show='message']")
     WebElement text;
     
     @FindBy(css="button[ng-class='btnClass3']")
     WebElement withdrawlBtn;
     
     @FindBy(css="input[placeholder='amount']")
     WebElement withdrawlAmount;
     
     @FindBy(css="button[type='submit']")
     WebElement withdrawl;
     
     @FindBy(css="span[ng-show='message']")
     WebElement withdrawlMsg;
     
     @FindBy(css="button[ng-class='btnClass1']")
      WebElement transactionBtn;
     
     @FindBy(css="button[ng-click='home()']")
     WebElement homeBtn;
     public HashMap<String,String> getText() {
    	String welcome= welcomeTxt.getText();
    	String account= accountNo.getText();
    	String Ac_balance=balance.getText();
        HashMap<String,String> map= new HashMap<String,String>();
        map.put("wlecomeTxt", welcome);
        map.put("accountNo", account);
        map.put("balance", Ac_balance);
        
        return map;
     }
     
     public String getDepositData(String amount) {
    	 depositBtn.click();
    	 depositeField.sendKeys(amount);
    	 addAmount.click();
    	 String depositText=text.getText();
    	 return depositText;
     }
     
     public String getWithdrawlData(String withDrawlAmount) throws Exception{
    	 synchronized(driver) {
    		 driver.wait(2000);
    	 }
    	 withdrawlBtn.click();
    	 synchronized(driver) {
    		 driver.wait(2000);
    	 }
    	 withdrawlAmount.sendKeys(withDrawlAmount);
    	 withdrawl.click();
    	 String msg=withdrawlMsg.getText();
    	 return msg;
    	 
     }
     public TransactionPage clickOnTransactionBtn() {
    	 transactionBtn.click();
    	 TransactionPage tp= new TransactionPage(driver);
    	 return tp;
     }
     
     public void withDrawlClick() {
    	 withdrawlBtn.click();
     }
     
     public String balanceText() {
    	 String text= balance.getText();
    	 return text;
     }
     
     public void homeBtn() {
    	 homeBtn.click();
     }
     
     public String validationMsg() {
    	String text= withdrawlAmount.getAttribute("validationMessage");
    	return text;
     }
     public String validationMsg2() {
     	String text= depositeField.getAttribute("validationMessage");
     	return text;
      }
}
