package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BasePage {
	
	@FindBy(className = "logoutLink")
	private WebElement logoutLink;	
	
	/**
	 * Select logout
	 */
	protected void selectLogout() {
		logoutLink.click();
	}
	
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
