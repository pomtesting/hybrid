package com.Selenium_Automation.travel.listener;

import java.io.File;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class Screenshot extends com.Selenium_Automation.server.SeleniumServer  implements ITestListener
{
	/*ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	public WebDriver driver= SeleniumServer.createAndStartWebDriver(1);


	public void onFinish(ITestContext result) {

		extent.flush();
	}

	public void onStart(ITestContext result) {
		htmlReporter=new ExtentHtmlReporter("./test-output/Extent_Report/extent.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "Qa");
		extent.setSystemInfo("user", "Manoj Kumar Rana");
		htmlReporter.config().setDocumentTitle("Hybrid Automation Report");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		logger=extent.createTest(result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		//Taking Screenshot for Failed Test Case
		if(result.getStatus()==ITestResult.FAILURE)
		{
			TakesScreenshot take=(TakesScreenshot)driver;
			File srcFile = take.getScreenshotAs(OutputType.FILE);
			try
			{
				File destFile=new File("./test-output/Sceenshots/"+result.getName()+".png");
				FileUtils.copyFile(srcFile, destFile);
				System.out.println("Screenshot is been taken for failed test case: "+result.getName());
				logger.fail("Screenshot below"+logger.addScreenCaptureFromPath("./test-output/Sceenshots/"+result.getName()+".png"));
			}
			catch(Exception e)
			{
				System.out.println("Screenshot is not available");
			}
		}

	}

	public void onTestSkipped(ITestResult result) {

		logger=extent.createTest(result.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {

		logger=extent.createTest(result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));

	}
*/

}
