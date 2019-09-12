package com.pom.testcases;

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

public class SearchFlight extends ProjectWrappers {
	{
		System.setProperty("atu.reporter.config", "./resources/atu.properties");
		ATUReports.currentRunDescription = "Test cases for BCT login Pass, Fail and Skip";
	}

	@BeforeSuite
	public void setSheetName() {
		dataSheetName = "BCT";
	}

	@Test(dataProvider = "fetchData")

	public void searchOneWay(String userId, String password) throws InterruptedException {

		ATUReports.setAuthorInfo(prop.getProperty("Authors"), Utils.getCurrentTime(), "1.0");
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Test case for BCT Login pass");

		new HomePage(driver, test);

	}

	@Test(dataProvider = "fetchData")
	
	public void searchReturn(String userId, String password) throws InterruptedException {

		ATUReports.setAuthorInfo(prop.getProperty("Authors"), Utils.getCurrentTime(), "1.0");
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Test case for BCT Login fail");

		new HomePage(driver, test);

	}



}
