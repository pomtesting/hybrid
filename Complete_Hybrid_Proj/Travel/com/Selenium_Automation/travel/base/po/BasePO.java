package com.Selenium_Automation.travel.base.po;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

public class BasePO {

	protected WebDriver driver;
	public Properties pro=new Properties();
	public File loginfile=null;

	private static final Logger logger = Logger.getLogger(BasePO.class.getPackage().getName());


	protected BasePO(WebDriver driver) throws IOException{
		this.driver = driver;
		loadPropertiFiles();
	}

	private void loadPropertiFiles() throws IOException {
		//load login properties file
		loginfile=new File(System.getProperty("user.dir")+"\\src\\com\\Gmaillogin\\Propertiesfiles\\login.properties");
		FileInputStream fis_login=new FileInputStream(loginfile);
		pro.load(fis_login);


	}

	public WebDriver getDriver() {
		return driver;
	}

	public void sleep(long milliSecs){
		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(milliSecs, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE," ",e);
		}
	}

	/*-----------------------------------------------------------------------------------------------*/
	public boolean verifyIfTextPresent(String textToVerify) {
		boolean isTextPresent = false;

		String pageSource = getDriver().getPageSource();

		if (pageSource.contains(textToVerify)) {
			isTextPresent = true;
		}

		return isTextPresent;
	}

	public boolean isLinkTextPresent(String linkTextToVerify) {
		boolean isLinkTextPresent = false;

		try {
			getDriver().findElement(By.linkText(linkTextToVerify));
			isLinkTextPresent = true;
		} catch (NoSuchElementException e) {
			logger.log(Level.SEVERE,"Unable to locate Link: " + linkTextToVerify,e);
		}

		return isLinkTextPresent;
	}

	protected WebElement getElementByID(String elementID) {
		WebElement elementToReturn = null;

		try {
			elementToReturn = getDriver().findElement(By.id(elementID));
		} catch (NoSuchElementException e) {
			logger.log(Level.SEVERE,"Unable to identify the element by id: " + elementID,e);
		}

		return elementToReturn;
	}

	protected WebElement getElementByName(String elementName) {
		WebElement elementToReturn = null;

		try {
			elementToReturn = getDriver().findElement(By.name(elementName));
		} catch (NoSuchElementException e) {
			logger.log(Level.SEVERE,"Unable to identify the element by name: " + elementName,e);
		}

		return elementToReturn;
	}

	protected WebElement getElementByTagName(String tagName) {
		WebElement elementToReturn = null;

		try {
			elementToReturn = getDriver().findElement(By.tagName(tagName));
		} catch (NoSuchElementException e) {
			logger.log(Level.SEVERE,"Unable to identify the tag by name: " + tagName,e);
		}

		return elementToReturn;
	}

	protected WebElement getElementByLinkText(String linkText) {
		WebElement elementToReturn = null;

		try {
			elementToReturn = getDriver().findElement(By.linkText(linkText));
		} catch (NoSuchElementException e) {
			logger.log(Level.SEVERE,"Unable to identify the element by link text: " + linkText,e);
		}

		return elementToReturn;
	}

	protected WebElement getElementByPartialLinkText(String partialLinkText) {
		WebElement elementToReturn = null;

		try {
			elementToReturn = getDriver().findElement(By.partialLinkText(partialLinkText));
		} catch (NoSuchElementException e) {
			logger.log(Level.SEVERE,"Unable to identify the element by partial link text: " + partialLinkText,e);
		}

		return elementToReturn;
	}

	protected WebElement getElementByXPath(String xpath){
		WebElement elementToReturn = null;

		try {
			if (xpath != null)
				elementToReturn = getDriver().findElement(By.xpath(xpath));

		} catch (NoSuchElementException e) {
			logger.log(Level.SEVERE,"Unable to identify the element by xpath: " + xpath,e);
		}

		return elementToReturn;
	}

	protected WebElement getWebElementByCSS(String cssSelector) {
		WebElement elementToReturn = null;

		try {
			if (cssSelector != null)
				elementToReturn = getDriver().findElement(
						By.cssSelector(cssSelector));

		} catch (NoSuchElementException e) {
			logger.log(Level.SEVERE,"Unable to identify the element by CSS: " + cssSelector,e);
		}

		return elementToReturn;
	}

	protected boolean enableCheckBox(WebElement chkBoxToEnable) {
		boolean isEnabledSuccessfully = false;

		try {
			if (chkBoxToEnable != null) {
				if (!chkBoxToEnable.isSelected())
					chkBoxToEnable.click();

				if (!chkBoxToEnable.isSelected())
					chkBoxToEnable.click();

				isEnabledSuccessfully = chkBoxToEnable.isEnabled();
			}
		} catch (Exception e) {
			isEnabledSuccessfully = false;
		}

		return isEnabledSuccessfully;
	}

	protected boolean disableCheckBox(WebElement chkBoxToDiable){
		boolean isDisabledSuccessfully = false;

		try {
			if (chkBoxToDiable != null) {
				if (chkBoxToDiable.isSelected())
					chkBoxToDiable.click();

				if (chkBoxToDiable.isSelected())
					chkBoxToDiable.click();

				isDisabledSuccessfully = !chkBoxToDiable.isEnabled();
			}
		} catch (Exception e) {
			isDisabledSuccessfully = false;
		}


		return isDisabledSuccessfully;
	}

	public WebElement getWebElement(String locatorValue) throws Exception{
		WebElement element = null;
		//here we are divide the value part into type and value
		String locator_type=locatorValue.split("_")[0];
		String locator_value=locatorValue.split("_")[1];

		if(locator_type!=null){
			if(locator_type.trim().equalsIgnoreCase("xpath")){
				element = getElementByXPath(locator_value);
			}else if(locator_type.trim().equalsIgnoreCase("id")){
				element = getElementByID(locator_value);
			}else if(locator_type.trim().equalsIgnoreCase("name")){
				element = getElementByName(locator_value);
			}else if(locator_type.trim().equalsIgnoreCase("css")){
				element = getWebElementByCSS(locator_value);
			}else if(locator_type.trim().equalsIgnoreCase("tag")){
				element = getElementByTagName(locator_value);
			}else if(locator_type.trim().equalsIgnoreCase("linkText")){
				element = getElementByLinkText(locator_value);
			}else if(locator_type.trim().equalsIgnoreCase("partialLinkText")){
				element = getElementByPartialLinkText(locator_value);
			}
			else
				throw new Exception("Unknow Locator type"+locator_type+"");
		}
		return element;
	}

}
