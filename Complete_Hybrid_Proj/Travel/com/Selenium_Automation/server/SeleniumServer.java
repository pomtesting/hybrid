package com.Selenium_Automation.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumServer {

	public static final int FIREFOX_DRIVER = 1;
	public static final int IE_DRIVER = 2;
	public static final int CHROME_DRIVER = 3;
	public static final int SAFARI_DRIVER = 4;

	private static final Logger logger = Logger.getLogger(SeleniumServer.class.getPackage().getName());
	public static WebDriver driver = null;

	public static WebDriver createAndStartWebDriver(int driverCode) throws InterruptedException{
		System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");

		logger.log(Level.INFO, "In createAndStartWebDriver :: start");
		switch (driverCode){
		case FIREFOX_DRIVER:
			driver = new FirefoxDriver();
			//Wait for browser to start
			//sleepTightInSeconds(5);
			Thread.sleep(5000);
			break;
		case IE_DRIVER:

			System.out.println("IE_DRIVER:"+IE_DRIVER);
			driver = new InternetExplorerDriver();
			//sleepTightInSeconds(5);
			Thread.sleep(5000);
			break;

		case CHROME_DRIVER:
			driver=new ChromeDriver();
			//sleepTightInSeconds(5);
			Thread.sleep(5000);
			break;

		}
		logger.log(Level.INFO, "In createAndStartWebDriver :: end");
		return driver;
	}
	
	public static void stopWebDriver(WebDriver driverToStop){
		if (driverToStop != null){
			driverToStop.close();
		}
	}
	
	public static WebDriver getDriver(){
		return driver;
	}

}
