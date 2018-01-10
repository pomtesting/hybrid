package Complete_Hybrid_Package.Complete_Hybrid_Proj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test {

	@Test
	public void open()
	{
		String src="D:\\SE_Utility\\Testing_Utilities\\BrowsersDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", src);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
	}
}
