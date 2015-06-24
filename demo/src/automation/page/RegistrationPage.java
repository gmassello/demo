package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import automation.helper.Helper;

public class RegistrationPage extends BasePage {
	
	@FindBy(xpath = ".//*[@name='pie_submit']")
	private WebElement submitButton;
	
	/**
	 * Click Submit
	 */
	public void clickSubmit(WebDriver driver) {
		Reporter.log("- Click Submit");
		submitButton.click();
		Helper.waitForJQueryProcessing(30,driver);
	}
}
