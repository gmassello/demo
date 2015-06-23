package automation.page;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class BasePage {
	
	/**
	 * Goto url
	 * @param url
	 * @param driver
	 */
	public void navigateTo(String url, WebDriver driver) {
		Reporter.log("- Go To url: "+url);
		driver.navigate().to(url);
	}

}
