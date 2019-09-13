package com.pom.testcases;


import java.text.ParseException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pom.androidPages.HomeAndroid;
import com.pom.pages.HomePage;
import com.pom.wrappers.ProjectWrappers;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

public class FlightStatus  extends ProjectWrappers {
	{
		System.setProperty("atu.reporter.config", "./resources/atu.properties");
		ATUReports.currentRunDescription = "Test cases for Emirates flight status in android app";
	}

	@BeforeSuite
	public void setSheetName() {
		dataSheetName = "EmiratesApp";
	}

	
	  @Test(dataProvider = "fetchData")
	  
	  public void flightStatus (String flightNumber)
	  throws InterruptedException, ParseException{
	  
	  ATUReports.setAuthorInfo(prop.getProperty("Authors"), Utils.getCurrentTime(),
	  "1.0"); ATUReports.setWebDriver(driver);
	  ATUReports.setTestCaseReqCoverage("Test case for search flights status");
	  
	  new HomeAndroid(driver, test).clickMenu().clickStatus().enterFlightNumber(flightNumber).clickFind().getStatus();
	  }
	 
}
