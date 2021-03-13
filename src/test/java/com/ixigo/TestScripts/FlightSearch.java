package com.ixigo.TestScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.Constants;
import junit.framework.Assert;
import pageObjectLibrary.IxigoFlightsSearch;

public class FlightSearch {
	
	@Test
	public void flightSearch()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe" ); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		// Navigating to the url
		driver.get(Constants.url);
				
		String homePageTitle = driver.getTitle();
		
		// Verifying the page title
		Assert.assertEquals("ixigo - Flights, IRCTC Train Booking, Bus Booking, Air Tickets & Hotels", homePageTitle);
		Reporter.log("Home page title verified");
					
		// Initializing the webelemens of IxigoFlightsSearch page and creating an object for it
		IxigoFlightsSearch flightSearchPage = PageFactory.initElements(driver, IxigoFlightsSearch.class);
		
		// Selecting From City
		flightSearchPage.getfromCityTxtBox().sendKeys(Constants.fromCity);
		
		// Using an explicit for a particular WebElement to load 
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(flightSearchPage.getFromSearchResultCity()));				
		flightSearchPage.getFromSearchResultCity().click();		
		
		// Selecting To City
		flightSearchPage.getToCityTxtBox().sendKeys(Constants.toCity);
		// Selecting Delhi City from the suggestions	
		flightSearchPage.getToSearchResultCity().click();
		
		// Selecting the Departure date
		wait.until(ExpectedConditions.visibilityOf(flightSearchPage.getDepDate()));		
		flightSearchPage.getDepDate().click();
		
		// Selecting the Return date				
		flightSearchPage.getReturnDateTxtBox().click();		
		wait.until(ExpectedConditions.visibilityOf(flightSearchPage.getReturnDateNextArrow()));			
		flightSearchPage.getReturnDateNextArrow().click();		
		flightSearchPage.getReturnDate().click();
		
	
		// Selecting the number of passengers
		flightSearchPage.getNoOfPassengerTextBox().click();		
		flightSearchPage.getCountOfPassengers().click();
		
		// Clicking on the search button		
		flightSearchPage.getSearchBtn().click();		
		
		// Waiting for the search results to load fully
		wait.until(ExpectedConditions.visibilityOf(flightSearchPage.getStopFilter()));
		
		// Verifying the all filter options one by one
		String searchResultTitleActual = driver.getTitle();
		String searchResultTitleExpected = "Bengaluru - New Delhi, Economy Flights, roundtrip, 27 Apr - 24 Jun";
		Assert.assertEquals(searchResultTitleExpected, searchResultTitleActual);
		Reporter.log("Search results page verified");	
		
		
		Assert.assertTrue(flightSearchPage.getStopFilter().isDisplayed());
		Reporter.log("Stop filter verified");	
		
		
		Assert.assertTrue(flightSearchPage.getDepartureFilter().isDisplayed());
		Reporter.log("Departure filter verfied");
		
		
		Assert.assertTrue(flightSearchPage.getAirlinesFilter().isDisplayed());
		Reporter.log("Airlines filter verified");
		
		//Selecting non stop check box		
		flightSearchPage.getNonStopChkBox().click();
		
		// Finding all the Flights
		List <WebElement> listOfFligts = flightSearchPage.getAllFlights();		
		for (int flightCount = 0; flightCount < listOfFligts.size(); flightCount++)
		{	
			String flightDetails = listOfFligts.get(flightCount).getText();
			
			int flightFare = Integer.parseInt(flightDetails.substring(flightDetails.length()-4));
			if (flightFare<7000)
			{	
				// Splitting the flight details using a new line
				String [] flightAry = flightDetails.split("\\r?\\n");
				String [] flightNoAry = flightAry[1].split(" ");
				if (flightNoAry[flightNoAry.length-1].equals("+1"))
				{
					flightNoAry = flightAry[2].split(" ");
					
					// Printing the Flight Number
					System.out.print("Flight No :: " + flightNoAry[flightNoAry.length-1] + "  ");
					Reporter.log("Flight No :: " + flightNoAry[flightNoAry.length-1] + "  ");
				}
				else
				{
					// Printing the Flight Number
					System.out.print("Flight No :: " + flightNoAry[flightNoAry.length-1] + "  ");
					Reporter.log("Flight No :: " + flightNoAry[flightNoAry.length-1] + "  ");
				}
				
				// Printing the Flight Departure time
				System.out.print("Departure Time:: " + flightDetails.substring(0,5)+ "  ");
				Reporter.log("Departure Time:: " + flightDetails.substring(0,5)+ "  ");
				
				// Printing the Flight Fare
				System.out.print("Fare:: " + flightFare + "  ");
				Reporter.log("Fare:: " + flightFare + "  ");				
			}
			
			System.out.println();			
		}		
	}
}
