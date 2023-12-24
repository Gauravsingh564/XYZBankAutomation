package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="D:\\SeleniumProjects\\XYZBankCapstone\\src\\test\\java\\com\\cucumberFeature",
glue="com.cucumberStepDef",monochrome=true,plugin= {"html:target//index.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
