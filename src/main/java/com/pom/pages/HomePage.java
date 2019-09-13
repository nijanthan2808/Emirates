package com.pom.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.pom.wrappers.ProjectWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage extends ProjectWrappers {
	
	public HomePage(RemoteWebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;

		if (!verifyTitle(
				"Emirates flights – Book a flight, browse our flight offers and explore the Emirates Experience")) {
			reportStep("This is not the Emirates Home Page", "FAIL");
		}
		

	}

	public HomePage enterDeparture(String departureLocation)
			throws InterruptedException {
		enter("xpath", prop.getProperty("Home.Departure.Xpath"), departureLocation);
		return this;
	}


	public HomePage selectDeparture()
			throws InterruptedException {
		//click("xpath", prop.getProperty("Home.DepartureSelect.Xpath"));
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		return this;
	}
	
	public HomePage enterArrival( String arrivalLocation)
			throws InterruptedException {
		enter("xpath", prop.getProperty("Home.Arrival.Xpath"), arrivalLocation);
		return this;
	}

	public HomePage selectArrival()
			throws InterruptedException {
		//click("xpath", prop.getProperty("Home.ArrivalSelect.Xpath"));
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		return this;
	}
	
	public HomePage selectOneway()
			throws InterruptedException {
		click("xpath", prop.getProperty("Home.Oneway.Xpath"));
		return this;
	}
	
	public HomePage selectDepartureDate()
			throws InterruptedException {
		 
		click("xpath",prop.getProperty("Home.DepartureDate.Xpath")); 
		return this;
	}
	
	public HomePage selectReturnDate(  )
			throws InterruptedException {
		click("xpath", prop.getProperty("Home.ReturnDate.Xpath"));
		return this ;
	}
	
	public ResultPage clickSearch()
			throws InterruptedException {
		click("xpath", prop.getProperty("Home.SearchButton.Xpath"));
		return new ResultPage(driver, test);
	}
	
}
