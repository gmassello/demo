package automation.helper;

import org.testng.annotations.DataProvider;

public class StaticProvider {
	
	@DataProvider(name = "kaceInformation")
	public static Object[][] kaceInformation() throws Exception {
		String user = GetPropertyValues.getPropertyValue("user");
		String password = GetPropertyValues.getPropertyValue("password");
		return new Object[][] {{user, password}};
	}

}
