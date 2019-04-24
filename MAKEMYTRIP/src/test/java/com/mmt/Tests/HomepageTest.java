package com.mmt.Tests;

import com.mmt.Page.Homepage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmt.Base.TestBase;
import com.mmt.Page.*;


public class HomepageTest extends TestBase {
	
	Homepage homepage;
	ForFlightPage ForFlightPage;
	
	@BeforeMethod
	public void setupHomePage() throws InterruptedException {
		
		initialization();
	}
	
	@Test
	public void verifyForFlightpageLocationTest() throws InterruptedException {
		homepage = new Homepage();
		ForFlightPage = homepage.searchflightocation();
		homepage.Fromloca();
	    homepage.location(prop.getProperty("locationfrom"));
	    homepage.Toloca();
	    homepage.location(prop.getProperty("locationto"));
	    homepage.Dateselection();
	    homepage.Btnsearchclc();
	}
	
	/*
	 * @AfterMethod public void teardown() { driver.quit(); }
	 */
}
