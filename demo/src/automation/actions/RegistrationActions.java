package automation.actions;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automation.helper.GetPropertyValues;
import automation.helper.Helper;
import automation.logging.Logging;
import automation.page.HomePage;
import automation.page.RegistrationPage;

public class RegistrationActions {
	
	/**
	 * Registration
	 * @param driver
	 */
	public void fieldsValidation(WebDriver driver) {
		Helper.environmentInfoReport();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Logging.getInstance().getLogger().log(Level.INFO, "Navigate to url");
		homePage.navigateTo(GetPropertyValues.getPropertyValue("url"), driver);
		homePage.clickRegistrationButton(driver);
		RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
		registrationPage.clickSubmit(driver);
		Assert.assertEquals(registrationPage.getNameSetErrorMessage(), "* This field is required");
	}

}
