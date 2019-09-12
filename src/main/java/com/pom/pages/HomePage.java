package com.pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.pom.wrappers.ProjectWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage extends ProjectWrappers {

	public HomePage(RemoteWebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;

		if (!verifyTitle(
				"Emirates flights � Book a flight, browse our flight offers and explore the Emirates Experience")) {
			reportStep("This is not the Emirates Home Page", "FAIL");
		}

	}

	public HomePage enterDeparture(String departureLocation)
			throws InterruptedException {
		enter("xpath", prop.getProperty("Home.Departure.Xpath"), prop.getProperty("Departure"));
		return this;
	}

	public HomePage selectDeparture()
			throws InterruptedException {
		click("xpath", prop.getProperty("Home.DepartureSelect.Xpath"));
		return this;
	}
	
	public HomePage enterArrival( String arrivalLocation)
			throws InterruptedException {
		enter("xpath", prop.getProperty("Home.Arrival.Xpath"), prop.getProperty("Arrival"));
		return this;
	}

	public HomePage selectArrival()
			throws InterruptedException {
		click("xpath", prop.getProperty("Home.ArrivalSelect.Xpath"));
		return this;
	}
	
	public HomePage selectOneway()
			throws InterruptedException {
		click("xpath", prop.getProperty("Home.Oneway.Xpath"));
		return this;
	}
	
	public HomePage selectDepartureDate( String departureDate)
			throws InterruptedException {
		departureDate = prop.getProperty("DepartureDate");
		click("xpath", prop.getProperty("Home.DepartureDate.Xpath"));
		return this;
	}
	
	public HomePage selectArrivalDate( String arrivalDate)
			throws InterruptedException {
		arrivalDate = prop.getProperty("ArrivalDate");
		click("xpath", prop.getProperty("Home.ArrivalSelect.Xpath"));
		return this ;
	}
	
	public ResultPage clickSearch()
			throws InterruptedException {
		click("xpath", prop.getProperty("Home.SearchButton.Xpath"));
		return new ResultPage(driver, test);
	}
	
}