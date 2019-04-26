package com.mmt.Base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.mmt.Util.BrowserSelection;
import com.mmt.Util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverEventListener eventListener;
	public static EventFiringWebDriver eventfiringdriver;
	public static Logger log;
	
	public TestBase()  {
		log = Logger.getLogger(this.getClass());
		prop = new Properties();	
		
		try {
		 FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/mmt"
					+ "/config/config.properties");
		 prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() throws InterruptedException{
		// TODO Auto-generated method stub
		driver = BrowserSelection.selectBrowser(prop.getProperty("browser"));
		eventfiringdriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventfiringdriver.register(eventListener);
		driver = eventfiringdriver;
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();

		

	}
	
	
}
