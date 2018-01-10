package com.Selenium_Automation.travel.test;

import org.testng.annotations.Test;

public class Checking extends BaseTest {

	public Checking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testing()
	{
		System.out.println("Hi Manoj");
		driver.get("http://www.softwaretestingblog.in");
		System.out.println("Thanks");
	}

}
