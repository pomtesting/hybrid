package com.Selenium_Automation.travel.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

import com.Selenium_Automation.server.SeleniumServer;
import com.Selenium_Automation.travel.util.ITestConstants;

public class BaseTest {

	private static final Logger logger = Logger.getLogger(BaseTest.class.getPackage().getName());
	public WebDriver driver = null;
	
	
	//Default Constructor
	public BaseTest() {
	
	}
	
	@BeforeTest
	public void beforeTest(ITestContext testContext){
		
		try
		{
		XmlTest xmlTest = testContext.getCurrentXmlTest();	
        String browser = xmlTest.getParameter(ITestConstants.PARAM_BROWSER_IDENTIFIER);
		
		int browserCode=0;// = 3;//= browser.equalsIgnoreCase(ITestConstants.FIREFOX_IDENTIFIER) ? SeleniumServer.FIREFOX_DRIVER : SeleniumServer.IE_DRIVER;
		System.out.println("browser:"+browser);
		if(browser.equalsIgnoreCase(ITestConstants.FIREFOX_IDENTIFIER))
			browserCode = SeleniumServer.FIREFOX_DRIVER;
		else if (browser.equalsIgnoreCase(ITestConstants.IE_IDENTIFIER))
			browserCode = SeleniumServer.IE_DRIVER;
		else if  (browser.equalsIgnoreCase(ITestConstants.CHROME_IDENTIFIER))
			browserCode = SeleniumServer.CHROME_DRIVER;			
			
		if(driver==null){
			driver = SeleniumServer.createAndStartWebDriver(browserCode);
		}
		
		logger.log(Level.INFO,"browser:- "+ browser );

		testContext.setAttribute(ITestConstants.ATTR_WEB_DRIVER_REF, driver);

		}catch(Exception e){
			logger.log(Level.SEVERE,"Exception caught while processing beforeTest ::",e);
		}
	}
	
	@AfterTest
	public void afterTest(){
		if(driver!=null){
			SeleniumServer.stopWebDriver(driver);
		}
	}
}
