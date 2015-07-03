package automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.firefox.profile", "automation");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}
