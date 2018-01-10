package com.Selenium_Automation.travel.login.po;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hamcrest.core.IsNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Selenium_Automation.travel.base.po.BasePO;

public class AdminloginPO extends BasePO {

	private static final Logger logger = Logger.getLogger(AdminloginPO.class.getPackage().getName());
	
	public AdminloginPO(WebDriver driver) throws IOException {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}

	public void enterEmail(String uname)
	{
		logger.entering(AdminloginPO.class.getName(), "enterEmail though method");
		//logger.info("Email Data Entered");
		if(driver==null)
			System.out.println("Null Value");
		else
		{
		try {
			driver.findElement(By.xpath("html/body/div[2]/div[2]/form[1]/div[1]/input[1]")).sendKeys(uname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//logger.info("Email Entered Sucessfully");
		logger.exiting(AdminloginPO.class.getName(), "enterEmail");
		}
	}
	public void enterPwd(String pwd)
	{
		//logger.info("PWD Data Entered");
		try {
			driver.findElement(By.xpath("html/body/div[2]/div[2]/form[1]/div[1]/input[2]")).sendKeys(pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//logger.info("PWD Data Entered Sucessfully");
	}
	public void open(String Url) throws InterruptedException
	{
		if(driver!=null)
		{
			//logger.info(Url);
			try {
				driver.get(Url);
				Thread.sleep(5000);
				logger.info("Website Opened Sucessfully");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Driver is Null");
		}

	}
	public void clickLogin()
	{
		try {
			driver.findElement(By.xpath("html/body/div[2]/div[2]/form[1]/button")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.exiting(AdminloginPO.class.getName(), "clickLogin Error");
		logger.log(Level.INFO, AdminloginPO.class.getName()+"clickLogin---------------");
	}

}
