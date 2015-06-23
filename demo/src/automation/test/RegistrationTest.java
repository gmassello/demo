package automation.test;

import org.testng.annotations.Test;

import automation.actions.RegistrationActions;
import automation.helper.StaticProvider;
import automation.test.BaseTest;

public class RegistrationTest extends BaseTest {
	
	@Test(dataProvider = "demoInformation", dataProviderClass = StaticProvider.class)
	public void fieldsValidation(String user, String password) {
		RegistrationActions registration = new RegistrationActions();
		registration.fieldsValidation(driver);
	}

}
