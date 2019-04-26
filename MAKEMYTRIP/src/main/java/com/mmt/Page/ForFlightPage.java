package com.mmt.Page;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mmt.Base.TestBase;

public class ForFlightPage extends TestBase {
  
	 @FindBy(xpath = "//div[@id='ow_domrt-jrny']/div[2]//div[@class='fli-list splitVw-listing']")
	 List<WebElement> DepartureFlightCount;
	 
	 @FindBy(xpath ="//div[@id='rt-domrt-jrny']/div[2]//div[@class='fli-list splitVw-listing']")
	 List<WebElement> ReturnFlightCount;
	 
	 @FindBy(xpath = "//label[@for='filter_stop0']")
	 WebElement Nonstop;
	 
	 @FindBy(xpath = "//label[@for='filter_stop1']")
	 WebElement onestop;
	 
	 @FindBy(xpath = "//button[@class='btn fli_primary_btn text-uppercase']")
	 WebElement BookNow;
	
	
	  @FindBy(xpath ="//div[@id='ow_domrt-jrny']/div[2]//div[@class='fli-list splitVw-listing'][10]//label//div//span[@class='splitVw-outer append_right9']")
	  WebElement DepartureRadioButton;
	  
	  @FindBy(xpath ="//div[@id='rt-domrt-jrny']/div[2]//div[@class='fli-list splitVw-listing'][10]//label//div//span[@class='splitVw-outer append_right9']")
	  WebElement ReturnRadioButton;
	 
	  @FindBy(xpath = "(//*[@class='splitVw-total-fare']//span)[1]")
	  WebElement TotalFare;
	  
	  @FindBy(xpath = "(//div//div//div[contains(@class,'splitVw-footer-right')]//div[contains(@class,'pull-right marL5 text-right')]//span)[1]")
	  WebElement ReturnBottomPrice;
	  
	  @FindBy(xpath = "(//div//div//div[contains(@class,'splitVw-footer-left')]//div[@class='pull-right marL5 text-right']//span[1])[1]")
	  WebElement DepartBottomPrice;


	public ForFlightPage() {
			PageFactory.initElements(driver, this);
	}
	 	 
	public void DepartureFlightCount() throws InterruptedException {
		  System.out.println("total number of records of DepartureFlight is: " + DepartureFlightCount.size());
	}	
	
	public void ReturnFlightCount() {
		System.out.println("total number of records of ReturnFlight is: " + ReturnFlightCount.size());
	}	
	
	public void NonstopCount() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(Nonstop)).click();
	}	
	
	public void onestopCount() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(onestop)).click();
	}
	
	public String DepartBottomPriceM() {
		return	new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(DepartBottomPrice)).getText();
        		
	}	
	
	public String ReturnBottomPriceM() {
		return	new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(ReturnBottomPrice)).getText();
	}	
	
	public String TotalPrice() {
		return	new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(TotalFare)).getText();
        		
	}	
	
	 public int ReturnBottomPricecount() throws InterruptedException
	 {
		   String RB =   ReturnBottomPrice.getText(); 
	  	   System.out.println("ReturnBottomPrice is :" +RB);
		   String[] RBS = RB.split(" ");
		   String RBS1 = RBS[1].replace(",", "");
		   int RBP = Integer.parseInt(RBS1);
		   System.out.println("ReturnBottomPricecount after split  is " + RBP);
		   return RBP;
	 }
	 public int TOtalPriceMatch() throws InterruptedException
	 {
		   String TF =   TotalFare.getText(); 
		   System.out.println("DepartBottomPrice is :"+ TF);
		   String[] TFS = TF.split(" ");
		   String TFS1 = TFS[1].replace(",", "");
		   int TFP = Integer.valueOf(TFS1);
		   System.out.println("Total Price  fare  after split  is " + TFP);
		   return TFP;
	 }
	 
	 public int DepartBottomPricecount() throws InterruptedException
	 {
		   String DB =   DepartBottomPrice.getText(); 
		   System.out.println("DepartBottomPrice is :"+ DB);
		   String[] DBS = DB.split(" ");
		   String DBS1 = DBS[1].replace(",", "");
		   int DBP = Integer.valueOf(DBS1);
		   System.out.println("DepartBottomPricecount after split  is " + DBP);
		   return DBP;
	 }
	
	public void Scrolldown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int second = 0;; second++) {
			if (second >=20) {
				break;
			}
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(300);
		}
		
	}
	
}
