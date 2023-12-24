package com.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public String getScreenshot(String testName , WebDriver d) throws Exception{
		TakesScreenshot ts=(TakesScreenshot)d;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\"+testName+".png");
		FileUtils.copyFile(source,destination);
		return System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\"+testName+".png";
	}

}
