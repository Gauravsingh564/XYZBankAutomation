package com.utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportFile {
     
	public static ExtentReports getReport() {
        File file= new File("D:\\SeleniumProjects\\XYZBankCapstone\\report\\index.html");
		ExtentSparkReporter reporter= new ExtentSparkReporter(file);
		reporter.config().setReportName("XYZBank Automation");
		reporter.config().setDocumentTitle("Test Result");
		
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shivendra Pratap");
		return extent;
	}
}
