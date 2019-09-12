package com.pom.testcases;

import org.jfree.xml.ParseException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pom.pages.HomePage;
import com.pom.wrappers.ProjectWrappers;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

public class SearchFlight  extends ProjectWrappers {
	{
		System.setProperty("atu.reporter.config", "./resources/atu.properties");
		ATUReports.currentRunDescription = "Test cases for Emirates flight search";
	}

	@BeforeSuite
	public void setSheetName() {
		dataSheetName = "Emirates";
	}

	@Test(dataProvider = "fetchData")

	public void searchOneWay(String departureLocation, String arrivalLocation, String departureDate, String returnDate)
			throws InterruptedException{

		ATUReports.setAuthorInfo(prop.getProperty("Authors"), Utils.getCurrentTime(), "1.0");
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Test case for search flights oneway");

		new HomePage(driver, test).enterDeparture(departureLocation).selectDeparture().enterArrival(arrivalLocation)
				.selectArrival().selectOneway().selectDepartureDate(departureDate).clickSearch().verifyOutBoundDetails()
				.verifyOutBoundDate().verifyOutBoundList();

	}

	@Test(dataProvider = "fetchData")

	public void searchWithReturn(String departureLocation, String arrivalLocation, String departureDate, String returnDate)
			throws InterruptedException {

		ATUReports.setAuthorInfo(prop.getProperty("Authors"), Utils.getCurrentTime(), "1.0");
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Test case for search flights with return");

		new HomePage(driver, test).enterDeparture(departureLocation).selectDeparture().enterArrival(arrivalLocation)
				.selectArrival().selectDepartureDate(departureDate).selectReturnDate(returnDate).clickSearch().verifyOutBoundDetails()
				.verifyOutBoundDate().verifyOutBoundList().verifyInBoundDetails().verifyInBoundDate().verifyInBoundList();

	}


}
