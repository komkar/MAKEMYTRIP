package com.mmt.Tests;


import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mmt.Base.TestBase;
import com.mmt.Page.ForFlightPage;
import com.mmt.Page.Homepage;
import com.mmt.TetstdataUtility.TestUtility;


public class ForFlightPageTest extends TestBase {

	Homepage homepage;
	ForFlightPage ForFlightPage;

	@BeforeMethod
	public void setupForFlightPage() throws InterruptedException {

		initialization();
		homepage = new Homepage();
		ForFlightPage = homepage.searchflightocation();
		homepage.Fromloca();
		homepage.location(prop.getProperty("locationfrom"));
		homepage.Toloca();
		homepage.location(prop.getProperty("locationto"));
		homepage.Dateselection();
		homepage.Btnsearchclc();
		Thread.sleep(1000);

	}

	
	  
	  @Test(priority = 1,description = "Count of Departure and Return Fights")
	  public void CountDepartureandReturnFights() throws InterruptedException
	   {
		  ForFlightPage.Scrolldown();
		  ForFlightPage.DepartureFlightCount();
	      ForFlightPage.ReturnFlightCount();
	  }
	 
	  @Test (priority = 2, description = "Non Stop Departure and Return Flights count")
	  public void NonStopFlightsCount() throws InterruptedException 
	   {
	      ForFlightPage.NonstopCount();
	      ForFlightPage.Scrolldown();
	      ForFlightPage.DepartureFlightCount();
	      ForFlightPage.ReturnFlightCount();
	      }
	
	  @Test (priority = 3, description = "Count of One Stop Departue and Return Flights")
	  public void OneStopFlightsCount() throws InterruptedException 
	  {
	      ForFlightPage.onestopCount();
	      ForFlightPage.Scrolldown();
	      ForFlightPage.DepartureFlightCount(); 
	      ForFlightPage.ReturnFlightCount();
	  
	  }
	 
	  @DataProvider public Iterator<Object[]> getdatatest() { 
		  ArrayList<Object[]> testdata = TestUtility.getDatafromExcel();
		  return testdata.iterator();
		  }
	  
	  @Test(dataProvider ="getdatatest", description=" data driven Test") 
	  public void DataProviderTest(String DepartureRadio, String Returnradio) throws InterruptedException {
	   //	  new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
         if(driver.findElement(By.xpath("(//div[@id='ow_domrt-jrny']/div[2]//div[@class='fli-list splitVw-listing']["+DepartureRadio+"]//label)[1]")).isDisplayed()) 
          { 
        	WebElement DepartureradioButton =  driver.findElement(By.xpath("//div[@id='ow_domrt-jrny']/div[2]//div[@class='fli-list splitVw-listing']["+DepartureRadio+"]//label//div//span[@class='splitVw-outer append_right9']"));
        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DepartureradioButton);
        	new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(DepartureradioButton)).click();
	        String Departureprice = driver.findElement(By.xpath("(//div[@id='ow_domrt-jrny']//div//label[1]//div[3]/p[1]/span[1])["+DepartureRadio+"]")).getText();
            System.out.println("total number of records of  Departureprice is :" + Departureprice);
      
	        WebElement Returnradiobutton = driver.findElement(By.xpath("//div[@id='rt-domrt-jrny']/div[2]//div[@class='fli-list splitVw-listing']["+Returnradio+"]//label//div//span[@class='splitVw-outer append_right9']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Returnradiobutton);
	        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Returnradiobutton)).click();
	        String Returnprice = driver.findElement(By.xpath("(//div[@id='rt-domrt-jrny']//div//label[1]//div[3]/p[1]/span[1])["+Returnradio+"]")).getText();
            System.out.println("total number of records of  Returnprice is :" + Returnprice);
	      
             int DepartBottomPrice = ForFlightPage.DepartBottomPricecount();
             int ReturnBottomPrice = ForFlightPage.ReturnBottomPricecount();
			/*
			 * String DepartBottomPrice=ForFlightPage.DepartBottomPriceM();
			 * System.out.println("DepartBottomPrice is :"+ DepartBottomPrice); String
			 * ReturnBottomPrice=ForFlightPage.ReturnBottomPriceM();
			 * System.out.println("ReturnBottomPrice is :" +ReturnBottomPrice);
			 * 
			 * String[] DB = DepartBottomPrice.split(" "); String DBP = DB[1]; // int DBP1
			 * =Integer.parseInt(DBP);
			 * System.out.println("DepartBottomPrice after split  is :" +DBP);
			 * 
			 * String[] RB = ReturnBottomPrice.split(" "); String RBP = RB[1]; // int RBP1
			 * =Integer.parseInt(RBP);
			 * System.out.println("ReturnBottomPrice after split  is :" +RBP); String DRP =
			 * DBP + RBP; System.out.println("Total adding Departure and Return  is :"
			 * +DRP);
			 */
             
			 String TotalPrice=ForFlightPage.TotalPrice();
			 System.out.println("Total Price  fare is :"+TotalPrice);
			 String[] TP = TotalPrice.split(" ");
             String TF = TP[1];
             System.out.println("Total Price  fare  after split  is :" +TF);
             Assert.assertEquals(DepartBottomPrice, Departureprice);
			/*
			 * Assert.assertEquals(ReturnBottomPrice, Returnprice); Assert.assertEquals(DRP,
			 * TF);
			 */
	     //   int DRP = Integer.parseInt(DBP) + Integer.parseInt(RBP); driver.findElement(By.xpath("//div[@id='rt-domrt-jrny']/div[2]//div[@class='fli-list splitVw-listing']["+Returnradio+"]//label//div//span[@class='splitVw-outer append_right9']")).click();;
	         Thread.sleep(7000);
	         
	       
	       
        }
	  }
	
	  @AfterMethod 
	  public void teardown() { 
		  driver.quit();
	  }
	 

}
