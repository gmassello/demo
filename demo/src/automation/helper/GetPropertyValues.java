package automation.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetPropertyValues {
	
	/**
	 * Get Property value
	 * @param propertyName
	 * @return {@link String}
	 */
	public static String getPropertyValue(String propertyName) {
		Properties prop = new Properties();
		String returnValue = null;		
		try{ 
			prop.load(new FileInputStream("configuration\\configuration.properties"));
			returnValue = prop.getProperty(propertyName).toString();		
		} catch (IOException ex) {
			ex.printStackTrace();
	    }
		return returnValue;
	}

}
