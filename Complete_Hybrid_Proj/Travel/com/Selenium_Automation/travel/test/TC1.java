package com.Selenium_Automation.travel.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Selenium_Automation_Admin._BASuite_Administration;

public class TC1 extends _BASuite_Administration{

	

	@Test
	public void tx1()
	{
		try {
			String openurl="https://www.phptravels.net/admin";
			adminloginpo.open(openurl);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adminloginpo.sleep(5000);
		adminloginpo.enterEmail("manoj@gmail.com");
		adminloginpo.enterPwd("kjshk");
		adminloginpo.sleep(5000);
		adminloginpo.clickLogin();
		adminloginpo.sleep(5000);
	}
	


}
