package com.mmt.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mmt.Base.TestBase;

public class Homepage extends TestBase {
	private static final String AfterDays = "7";


	@FindBy(how = How.XPATH, using = "//a[@class='active makeFlex hrtlCenter column']")
	WebElement Flightsclc;

	@FindBy(how = How.XPATH, using = "//ul[@class='fswTabs latoBlack greyText']//li[2]")
	WebElement RoundTrip;

	@FindBy(how = How.XPATH, using = "//input[@id='fromCity']")
	WebElement Fromcity;

	@FindBy(how = How.XPATH, using = "//input[@id='toCity']")
	WebElement Tocity;

	@FindBy(how = How.XPATH, using = "//li[contains(@class , 'react-autosuggest__suggestion')]")
	WebElement suggestion;

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'Search')]")
	WebElement BtnSearch;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'DEPARTURE')]")
	WebElement DEPARTURE;

	@FindBy(how = How.XPATH, using = "//div[@class='DayPicker-Day DayPicker-Day--today']//p")
	WebElement DEPARTUREDate;

	@FindBy(how = How.XPATH, using = "(//div[@class='DayPicker-Day']//p)[" + AfterDays + "]")
	WebElement RETURNDate;
	
	@FindBy(xpath = "//li[contains(@class , 'react-autosuggest__suggestion')]")
	List<WebElement> listOfFrom;

	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
    public void location(String location) throws InterruptedException {
		 for(int i=0;i<listOfFrom.size();i++){
	            WebElement element=listOfFrom.get(i);
	            if(element.getText().contentEquals(location )){
	            	driver.findElement(By.xpath("//li[contains(@class , 'react-autosuggest__suggestion')][" + i + "]")).click();
	                break;
	            }
	        }	
	}
    public void Fromloca() {
    	Fromcity.click();
		
	}
    public void Toloca() {
    	Tocity.click();
	}
  
	public void Dateselection() throws InterruptedException {
		DEPARTURE.click();
    	DEPARTUREDate.click();
		RETURNDate.click();
		 
	}

	public void Btnsearchclc() throws InterruptedException {
		BtnSearch.click();
		driver.manage().deleteAllCookies();
	}

	public ForFlightPage searchflightocation() throws InterruptedException {
		Flightsclc.click();
		RoundTrip.click();
		return new ForFlightPage();
	}
}
