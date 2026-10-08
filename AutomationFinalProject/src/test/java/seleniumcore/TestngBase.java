package seleniumcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;


//import utilities.ScreenshotUtility;

public class TestngBase {
	
	Properties prop;
	FileInputStream f;
	
	public WebDriver driver;
	
	//Initialize Browser
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws IOException
	{
		
		prop = new Properties();
		f = new FileInputStream(Constant.CONFIGFILE);
		prop.load(f);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void browserCloseAndQuit(ITestResult iTestResult) throws IOException
	{
		 if (iTestResult.getStatus() == ITestResult.FAILURE) { 
			  
	 			ScreenshotUtility screenShot = new ScreenshotUtility(); 
	 			screenShot.getScreenshot(driver, iTestResult.getName()); 
	 		}
		driver.quit();
		
	}

}
