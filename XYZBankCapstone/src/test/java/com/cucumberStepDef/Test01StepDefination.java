package com.cucumberStepDef;

import org.testng.Assert;

import com.Base.BaseClass;
import com.pages.AccountPage;
import com.pages.LoginPage;
import com.pages.TransactionPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test01StepDefination extends BaseClass {
	  public LoginPage lp; 
	  public AccountPage ap;
	  public TransactionPage tp;
	  String url="";
	@Given("user landed on the home page")
	public void user_landed_on_the_home_page() throws Exception {
       lp=launchApplication();

	}

	@Given("User click on the CustomerLogin button")
	public void user_click_on_the_customer_login_button() {
	   lp.clickOnCustomerBtn();
	}
	
	@When("^User select the name (.+) from dropdown and click on login button")
	public void user_select_the_name_harry_potter_from_dropdown_and_click_on_login_button(String name) {
	   ap= lp.loginToApplication(name);
	    
	}
     
	@When("User click on the Deposite button and fill deposite amount {int} and click deposite button")
	public void user_click_on_the_deposite_button_and_fill_deposite_amount1000_and_click_deposite_button(int amount) {
		String a=Integer.toString(amount);
		String text=ap.getDepositData(a);
		Assert.assertEquals(text,"Deposit Successful");
	}


	@When("^user click on the Withdrawl button and fill withdrawl amount (.+) and click withdrawl button$")
	public void user_click_on_the_withdrawl_button_and_fill_withdrawl_amount_and_click_withdrawl_button(String amount) throws Exception {
	    String text=ap.getWithdrawlData(amount);
	    Assert.assertEquals(text,"Transaction successful");
	}

	@When("User click on the transaction button and get all details")
	public void user_click_on_the_transaction_button_and_get_all_details() {
		tp=ap.clickOnTransactionBtn();
		tp.getTransactionData();
	}

	@When("User click on the logout button")
	public void user_click_on_the_logout_button() throws Exception {
	   tp.logout();
	   synchronized(driver) {
		   driver.wait(2000);
	   }
	   url=driver.getCurrentUrl();
	}

	@Then("User redirected to the Home page")
	public void user_redirected_to_the_home_page() {
	    Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
	    driver.close();
	}




}
