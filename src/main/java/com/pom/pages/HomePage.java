package com.pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.pom.wrappers.ProjectWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage extends ProjectWrappers {

	public HomePage(RemoteWebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;
		Thread.sleep(5000);

		
		
		  if (!verifyTitle("Emirates flights – Book a flight, browse our flight offers and explore the Emirates Experience")) {
		  reportStep("This is not the Emirates Home Page", "FAIL"); }
		 
	}



	public HomePage getUserName() throws InterruptedException {
		getTextByXpath(prop.getProperty("Home.UserName.Xpath"));
		return new HomePage(driver, test);
	}

}
