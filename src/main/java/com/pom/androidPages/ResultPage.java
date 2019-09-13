package com.pom.androidPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.pom.wrappers.ProjectWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class ResultPage extends ProjectWrappers {
	
	public ResultPage(RemoteWebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;

		/*
		 * if (!verifyTitle(
		 * "Emirates flights – Book a flight, browse our flight offers and explore the Emirates Experience"
		 * )) { reportStep("This is not the Emirates Home Page", "FAIL"); }
		 */

	}

	public ResultPage getStatus()
			throws InterruptedException {
		getTextByXpath( prop.getProperty("CurrentStatus"));
		return this;
	}

	
}
