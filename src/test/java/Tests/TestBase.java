package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests {

	public static WebDriver driver ;


	@SuppressWarnings("deprecation")
	@BeforeSuite
	@Parameters ({"browser"})
	public void startDriver (@Optional ("chrome")  String browsername) 
	{

		if (browsername.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver() ;
			
		}
		else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver() ;
		} 
		
		if (browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe");
			driver = new FirefoxDriver() ;
		} 
			
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");

	}


	@AfterSuite
	public void stopDriver () {

		driver.quit();
	}

	// take screenshot when test case fail and add it in screenshots folder
	@AfterMethod
	public void screenshotOnFailure (ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking screenshot ...");
			Helper.CaptureScreenshot(driver, result.getName());
			
		}
		
	}
	
	
}
