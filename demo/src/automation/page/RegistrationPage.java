package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import automation.helper.Helper;

public class RegistrationPage extends BasePage {
	
	@FindBy(xpath = ".//*[@name='pie_submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = ".//*[@id='pie_register']/li[1]/div[1]/div[2]/span")
	private WebElement nameSetErrorMessage;
	
	/**
	 * Click Submit
	 */
	public void clickSubmit(WebDriver driver) {
		Reporter.log("- Click Submit");
		submitButton.click();
		Helper.waitForJQueryProcessing(30,driver);
	}

	/**
	 * Get NameSet Error Message
	 */
	public String getNameSetErrorMessage() {
		return nameSetErrorMessage.getText();
	}
}
