package com.mmt.Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.mmt.Base.TestBase;

public class BrowserSelection extends TestBase {

@SuppressWarnings("deprecation")
public static WebDriver selectBrowser(String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/mkar/Desktop/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			driver =  new ChromeDriver(capabilities);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/mkar/Desktop/geckodriver");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			driver =   new FirefoxDriver(capabilities);

		} else {
			System.out.println("Unable to launch the browser=" + browserName);

		}
    
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		return driver;
	
	}
}
