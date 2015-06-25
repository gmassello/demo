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
	private WebElement nameErrorMessage;
	
	@FindBy(xpath = ".//*[@id='pie_register']/li[3]/div/div[2]/span")
	private WebElement hobbyErrorMessage;
	
	@FindBy(id = "name_3_firstname")
	private WebElement firstNameTextBox;
	
	@FindBy(id = "name_3_lastname")
	private WebElement lastNameTextBox;
	
	/**
	 * Click Submit
	 */
	public void clickSubmit(WebDriver driver) {
		Reporter.log("- Click Submit");
		submitButton.click();
		Helper.waitForJQueryProcessing(30,driver);
	}

	/**
	 * Get First Name Error Message
	 */
	public String getNameErrorMessage() {
		return nameErrorMessage.getText();
	}
	
	/**
	 * Get Hobby Error Message
	 */
	public String getHobbyErrorMessage() {
		return hobbyErrorMessage.getText();
	}
	
	/**
	 * Complete first name
	 * @param firstName
	 */
	public void completeFirstName(String firstName) {
		Reporter.log("- Complete first name");
		firstNameTextBox.clear();
		firstNameTextBox.sendKeys(firstName);
	}

	/**
	 * Complete last name
	 * @param lastName
	 */
	public void completeLastName(String lastName) {
		Reporter.log("- Complete last name");
		lastNameTextBox.clear();
		lastNameTextBox.sendKeys(lastName);
	}
}
