package com.cucumberStepDef;

import com.Base.BaseClass;
import com.pages.CustomerPage;
import com.pages.LoginPage;
import com.pages.ManagerPage;
import com.pages.OpenAccountPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagerStepDef extends BaseClass {
	 public LoginPage lp; 
	 public ManagerPage mp;
	 public OpenAccountPage op;
	 public CustomerPage cp;
	 
	@Given("Landed on the home page")
	public void landed_on_the_home_page() throws Exception {
		 lp=launchApplication();
	}

	@Given("Click on the manager login button")
	public void click_on_the_manager_login_button() {
	       mp= lp.managerLogin();
	}

	@When("^Click on the add customer button and fill the deatils (.+) , (.+) and (.+) and click on the add button$")
	public void click_on_the_add_customer_button_and_fill_the_deatils_gaurav_singh_and_and_click_on_the_add_button(String fname,String lname, String pin) {
	
		mp.addCustomer(fname, lname, pin);
	        
	}

	@When("^Click on the open account button and select user (.+) and currency (.+) and click on the process button")
	public void click_on_the_open_account_button_and_select_user_harry_potter_and_currency_rupee_and_click_on_the_process_button(String user, String currency) {
	   op= mp.accountBtn();
	   op.openAccountData(user,currency);
	}

	@When("^Click on the customers button and search the customer (.+)$")
	public void click_on_the_customers_button_and_search_the_customer_harry(String user) {
		cp=op.click();
		cp.searchCustomer(user);
	    
	}

	@Then("Delete the recently added customer")
	public void delete_the_recently_added_customer() throws Exception {
	   cp.deleteCutomer();
	   driver.close();
	}






}
