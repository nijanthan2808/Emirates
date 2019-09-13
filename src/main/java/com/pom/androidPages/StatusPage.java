package com.pom.androidPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.pom.androidPages.ResultPage;
import com.pom.wrappers.ProjectWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class StatusPage extends ProjectWrappers {
	
	public StatusPage(RemoteWebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;

		/*
		 * if (!verifyTitle(
		 * "Emirates flights – Book a flight, browse our flight offers and explore the Emirates Experience"
		 * )) { reportStep("This is not the Emirates Home Page", "FAIL"); }
		 */

	}

	public StatusPage enterFlightNumber(String flightNumber)
			throws InterruptedException {
		enter("xpath", prop.getProperty("FlightNumber"), flightNumber);
		return this;
	}

	
	public ResultPage clickFind()
			throws InterruptedException {
		click("xpath", prop.getProperty("FindButton"));
		return new ResultPage(driver, test);
	}

	
}
