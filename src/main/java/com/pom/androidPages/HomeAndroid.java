package com.pom.androidPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.pom.pages.ResultPage;
import com.pom.wrappers.ProjectWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class HomeAndroid extends ProjectWrappers {
	
	public HomeAndroid(RemoteWebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;

		/*
		 * if (!verifyTitle(
		 * "Emirates flights – Book a flight, browse our flight offers and explore the Emirates Experience"
		 * )) { reportStep("This is not the Emirates Home Page", "FAIL"); }
		 */

	}

	public MenuPage clickMenu()
			throws InterruptedException {
		click("xpath", prop.getProperty("MainMenu"));
		return new MenuPage(driver, test);
	}

	
}
