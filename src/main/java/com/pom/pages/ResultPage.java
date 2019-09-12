package com.pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.pom.wrappers.ProjectWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class ResultPage extends ProjectWrappers {

	public ResultPage(RemoteWebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;
		Thread.sleep(5000);

		
		  if (!verifyTitle("Emirates flights – Book a flight, browse our flight offers and explore the Emirates Experience")) {
		  reportStep("This is not the Emirates Home Page", "FAIL"); }
		 
	}



	public ResultPage getUserName() throws InterruptedException {
		getTextByXpath(prop.getProperty("Home.UserName.Xpath"));
		return new ResultPage(driver, test);
	}

}
