package automation.helper;

import org.testng.annotations.DataProvider;

public class StaticProvider {
	
	@DataProvider(name = "demoInformation")
	public static Object[][] demoInformation() throws Exception {
		String user = GetPropertyValues.getPropertyValue("user");
		String password = GetPropertyValues.getPropertyValue("password");
		return new Object[][] {{user, password}};
	}

}
