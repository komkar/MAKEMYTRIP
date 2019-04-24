package com.mmt.Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mmt.Base.TestBase;

public class BrowserSelection extends TestBase {

public static WebDriver selectBrowser(String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/mkar/Desktop/chromedriver");
			driver = (WebDriver) new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/mkar/Desktop/geckodriver");
			driver =  (WebDriver) new FirefoxDriver();

		} else {
			System.out.println("Unable to launch the browser=" + browserName);

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		return driver;
	
	}
}
