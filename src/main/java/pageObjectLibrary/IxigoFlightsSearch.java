package pageObjectLibrary;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IxigoFlightsSearch {
	
	@FindBy (xpath ="//div[@class = \"input-label\" and text ()= \"From\"]/following-sibling::input[@placeholder = \"Enter city or airport\" and @type = \"text\"]")
	private  WebElement fromCityTxtBox;
	
	@FindBy (xpath ="//div[text() = 'BLR - Bengaluru, India']")
	private  WebElement fromSearchResultCity;
	
	@FindBy (xpath = "//div[@class = \"input-label\" and text ()= \"To\"]/following-sibling::input[@placeholder = \"Enter city or airport\" and @type = \"text\"]")
	private  WebElement toCityTxtBox;
	
	@FindBy (xpath = "//div[text() = 'DEL - New Delhi, India']")
	private  WebElement toSearchResultCity;
	
	@FindBy (xpath = "//td[@data-date=\"27042021\"]")
	private  WebElement depDate;
	
	@FindBy (xpath = "//input[@placeholder='Return']")
	private  WebElement returnDateTxtBox;
	
	@FindBy (xpath = "//body/div[7]/div[2]/div[2]/button[1]")
	private  WebElement returnDateNextArrow;
	
	@FindBy (xpath = "//td[@data-date = '24062021']")
	private  WebElement returnDate;
	
	@FindBy (xpath = "//div[text() = \"Travellers | Class\"]/following-sibling::input")
	private  WebElement noOfPassengerTextBox;
	
	@FindBy (xpath = "//div[text() = \"Adult\"]/../following-sibling::div/span[2]")
	private  WebElement countOfPassengers;
	
	@FindBy (xpath = "//body/div[@id='content']/div[1]/div[1]/div[6]/div[1]/div[1]/div[6]/button[1]/div[1]")
	private  WebElement searchBtn;
	
	@FindBy (xpath = "//div[text() = 'Stops']")
	private  WebElement stopFilter;
	
	@FindBy (xpath = "//div[text() = 'Departure from BLR']")
	private  WebElement departureFilter;
	
	@FindBy (xpath = "//div[text() = 'Airlines']")
	private  WebElement airlinesFilter;
	
	@FindBy (xpath = "//div[text() = 'Non stop']")
	private  WebElement nonStopChkBox;
			
	@FindBy (xpath = "//div[contains(@class, 'c-flight-listing-split-row')]")
	private  List<WebElement> allFlights;
		
	
	public WebElement getfromCityTxtBox()
	{
		return fromCityTxtBox;
	}
	public WebElement getFromSearchResultCity()
	{
		return fromSearchResultCity;
	}
	public WebElement getToCityTxtBox()
	{
		return toCityTxtBox;
	}
	
	public WebElement getToSearchResultCity()
	{
		return toSearchResultCity;
	}
	public WebElement getDepDate()
	{
		return depDate;
	}
	public WebElement getReturnDateTxtBox()
	{
		return returnDateTxtBox;
	}
	
	public WebElement getReturnDateNextArrow()
	{
		return returnDateNextArrow;
	}
	public WebElement getReturnDate()
	{
		return returnDate;
	}
	public WebElement getNoOfPassengerTextBox()
	{
		return noOfPassengerTextBox;
	}
	public WebElement getCountOfPassengers()
	{
		return countOfPassengers;
	}
	public WebElement getSearchBtn()
	{
		return searchBtn;
	}
	public WebElement getStopFilter()
	{
		return stopFilter;
	}
	public WebElement getDepartureFilter()
	{
		return departureFilter;
	}
	public WebElement getAirlinesFilter()
	{
		return airlinesFilter;
	}
	public WebElement getNonStopChkBox() 
	{
		return nonStopChkBox;
	}
	public List<WebElement> getAllFlights() 
	{
		return allFlights;
	}

}
