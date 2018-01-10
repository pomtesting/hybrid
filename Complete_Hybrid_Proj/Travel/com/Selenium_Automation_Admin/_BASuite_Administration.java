package com.Selenium_Automation_Admin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import com.Selenium_Automation.travel.login.po.AdminloginPO;
import com.Selenium_Automation.travel.test.BaseTest;
import com.Selenium_Automation.travel.util.ITestConstants;

public class _BASuite_Administration extends BaseTest {

	public WebDriver driver=null;
	
	
	/*public _BASuite_Administration(WebDriver driver) {
		this.driver=driver;
	}*/
	
	public AdminloginPO adminloginpo=null;
	@BeforeClass
	public void beforetest(ITestContext context) throws IOException
	{
		if(driver==null)
		{
			driver = (WebDriver)context.getAttribute(ITestConstants.ATTR_WEB_DRIVER_REF);
		}
		
		adminloginpo=new AdminloginPO(driver);
		
	}
}
