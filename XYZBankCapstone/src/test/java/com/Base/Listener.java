package com.Base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utility.ExtentReportFile;
import com.utility.Screenshot;

public class Listener extends BaseClass implements ITestListener {
	 ExtentTest test;
     ExtentReports extent= ExtentReportFile.getReport();
     Screenshot ss= new Screenshot();
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String filepath=null;
		try {
			driver=  (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			 filepath=ss.getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	

}
