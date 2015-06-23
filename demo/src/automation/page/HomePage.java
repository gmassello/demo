package automation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends BasePage {
	
	@FindBy(xpath = ".//*[@id='nav_menu-6']//*[@href='http://demoqa.com/registration/']")
	private WebElement registrationButton;
	
	/**
	 * Registration Button Click
	 * @param value
	 */
	public void clickRegistrationButton() {
		Reporter.log("- Click Registration Button ");
		registrationButton.click();
	}
}
