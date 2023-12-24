package com.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.pages.LoginPage;



public class BaseClass {
	
  public static	WebDriver driver;
  public LoginPage lp;  
	
    public WebDriver setup() throws Exception {
 		 
 		 driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
 	 
  	return driver;
    }
    
    @BeforeTest
    public LoginPage launchApplication() throws Exception {
    	driver=setup();
    	driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/");
    	lp= new LoginPage(driver);
    	return lp;
    }
    
    @AfterTest
    public void closeBrowser() {
    	driver.close();
    }
}

