package com.pom.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.pom.wrappers.ProjectWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class ResultPage extends ProjectWrappers {

	public ResultPage(RemoteWebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;
		Thread.sleep(5000);

		
		  if (!verifyTitle("Search results | Make a booking | Emirates")) {
		  reportStep("This is not the Emirates Flight search result Page", "FAIL"); }
		 
	}



	public ResultPage verifyOutBoundDetails() throws InterruptedException {
		getTextByXpath(prop.getProperty("Result.OutBound.Xpath"));
		return this;
	}

	public ResultPage verifyInBoundDetails() throws InterruptedException {
		getTextByXpath(prop.getProperty("Result.InBound.Xpath"));
		return this;
	}
	
	public ResultPage verifyOutBoundDate() throws InterruptedException {
		getTextByXpath(prop.getProperty("Result.ObDate.Xpath"));
		return this;
	}
	
	public ResultPage verifyInBoundDate() throws InterruptedException {
		//Thread.sleep(60000);
		getTextByXpath(prop.getProperty("Result.IbDate.Xapth"));
		return this;
	}
	
	public ResultPage verifyOutBoundList() throws InterruptedException {
		List<WebElement>  ObList= driver.findElementsByXPath(prop.getProperty("Result.ObList.Xapth")) ;
		System.out.println("Total Out bound flights available : " + ObList.size() ) ;
		return this;
	}

	public ResultPage verifyInBoundList() throws InterruptedException {
		List<WebElement> IbList = driver.findElementsByXPath(prop.getProperty("Reuslt.IbList.Xpath"));
		System.out.println("Total In bound flights available : " + IbList.size()) ;
		return this;
	}

}
