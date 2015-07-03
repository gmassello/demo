package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import automation.helper.Helper;

public class RegistrationPage extends BasePage {
	
	@FindBy(xpath = ".//*[@name='pie_submit']")
	private WebElement submitButton;
	
	//@FindBy(xpath = ".//*[@id='pie_register']/li[1]/div[1]/div[2]/span")
	@FindBy(xpath = ".//*[@id='pie_register']/li[1]//*[@class='fieldset error']//*[@class='legend_txt']//*[@class='legend error']")
	private WebElement nameErrorMessage;
	
	@FindBy(xpath = ".//*[@id='pie_register']/li[3]/div/div[2]/span")
	private WebElement hobbyErrorMessage;
	
	@FindBy(id = "name_3_firstname")
	private WebElement firstNameTextBox;
	
	@FindBy(id = "name_3_lastname")
	private WebElement lastNameTextBox;
	
	@FindBy(xpath = ".//*[@id='pie_register']/li[3]/div/div//*[@value='dance']")
	private WebElement danceCheckBox;
	
	@FindBy(xpath = ".//*[@id='pie_register']/li[3]/div/div//*[@value='reading']")
	private WebElement readingCheckBox;
	
	@FindBy(xpath = ".//*[@id='pie_register']/li[3]/div/div//*[@value='cricket ']")
	private WebElement cricketCheckBox;

	@FindBy(xpath = ".//*[@name='radio_4[]' and @value='single']")
	private WebElement singleOptionButton;

	@FindBy(xpath = ".//*[@name='radio_4[]' and @value='married']")
	private WebElement marriedOptionButton;
	
	@FindBy(xpath = ".//*[@name='radio_4[]' and @value='divorced']")
	private WebElement divorcedOptionButton;
	
	@FindBy(id = "dropdown_7")
	private WebElement countryComboBox;

	@FindBy(id = "yy_date_8")
	private WebElement yearComboBox;

	@FindBy(id = "dd_date_8")
	private WebElement dayComboBox;

	@FindBy(id = "mm_date_8")
	private WebElement monthComboBox;
	
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
	
	/**
	 * Select Dance
	 */
	public void selectDance() {
		Reporter.log("- Select Dance");
		if (!danceCheckBox.isSelected()) danceCheckBox.click();  
	}
	
	/**
	 * Select Reading
	 */
	public void selectReading() {
		Reporter.log("- Select Reading");
		if (!readingCheckBox.isSelected()) readingCheckBox.click();  
	}

	/**
	 * Select Reading
	 */
	public void selectCricket() {
		Reporter.log("- Select Cricket");
		if (!cricketCheckBox.isSelected()) cricketCheckBox.click();  
	}
	
	/**
	 * Select single
	 */
	public void selectSingle() {
		Reporter.log("- Select single");
		if (!singleOptionButton.isSelected()) singleOptionButton.click();  
	}
	
	/**
	 * Select married
	 */
	public void selectMarried() {
		Reporter.log("- Select married");
		if (!marriedOptionButton.isSelected()) marriedOptionButton.click();  
	}
	
	/**
	 * Select divorced
	 */
	public void selectDivorced() {
		Reporter.log("- Select divorced");
		if (!divorcedOptionButton.isSelected()) divorcedOptionButton.click();  
	}

	/**
	 * Select a Country
	 * @param countryName
	 */
	public void selectCountry(String countryName) {
		Reporter.log("- Select the country: "+countryName);
		new Select(this.countryComboBox).selectByVisibleText(countryName);	
	}
	
	/**
	 * Select current year
	 */
	public void selectYear() {
		Reporter.log("- Select current year");
		new Select(this.yearComboBox).selectByVisibleText("2014");
	}
	
	/**
	 * Select current day
	 */
	public void selectDay() {
		Reporter.log("- Select current day");
		new Select(this.dayComboBox).selectByVisibleText(Integer.toString(Integer.parseInt(Helper.getTodayDate("dd"))));
	}
	
	/**
	 * Select current month
	 */
	public void selectMonth() {
		Reporter.log("- Select current month");
		new Select(this.monthComboBox).selectByVisibleText("1");
	}
	
}
