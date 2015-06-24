package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import automation.helper.Helper;

public class HomePage extends BasePage {
	
	@FindBy(xpath = ".//*[@id='nav_menu-6']//*[@href='http://demoqa.com/registration/']")
	private WebElement registrationButton;
	
	/**
	 * Registration Button Click
	 * @param value
	 */
	public void clickRegistrationButton(WebDriver driver) {
		Reporter.log("- Click Registration Button ");
		registrationButton.click();
		Helper.waitForJQueryProcessing(30,driver);
	}
}
