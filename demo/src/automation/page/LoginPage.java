package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends BasePage {
	
	@FindBy(name = "LOGIN_NAME")
	private WebElement loginTextBox;
	
	@FindBy(name = "LOGIN_PASSWORD")
	private WebElement passwordTextBox;
	
	@FindBy(name = "save")
	private WebElement loginButton;
	
	@FindBy(name = "kbox")
	private WebElement kbox;
	
	/**
	 * Complete Login user
	 * @param value
	 */
	public void completeLoginTextBox(String value) {
		Reporter.log("- Complete login user: "+value);
		loginTextBox.clear();
		loginTextBox.sendKeys(value);
	}
	
	/**
	 * Complete Password
	 * @param value
	 */
	public void completePasswordTextBox(String value) {
		Reporter.log("- Complete password: "+value);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(value);
	}
	
	/**
	 * Select Login
	 */
	public void selectLogin() {
		Reporter.log("- Select login");
		loginButton.click();
	}
	
	/**
	 * Switch to frame
	 * @param driver
	 */
	public void switchToFrame(WebDriver driver) {
		driver.switchTo().frame(kbox);
	}

}
