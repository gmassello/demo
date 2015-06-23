package automation.test;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import automation.logging.Logging;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() {
		Logging.getInstance().getLogger().log(Level.INFO, "Open browser");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void afterSuite() {
		Logging.getInstance().getLogger().log(Level.INFO, "Close browser");
		driver.quit();
		Logging.closeHandler();
	}
}
