package automation.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Helper {
	
	/**
	 * Waits for the completion of Ajax jQuery processing by checking "return jQuery.active == 0" condition.
	 * @param timeOutInSeconds - The time in seconds to wait until returning a failure
	 * @return {@link Boolean} true or false(condition fail, or if the timeout is reached)
	 */
	public static boolean waitForJQueryProcessing (int timeOutInSeconds, WebDriver driver) {
		boolean jQcondition = false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			new WebDriverWait(driver, timeOutInSeconds) {
	           }.until(new ExpectedCondition<Boolean>() {
	               @Override
	               public Boolean apply(WebDriver driverObject) {
	                   return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active == 0");
	               }
	           });
	       jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
	       driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS); //reset implicitlyWait
	       return jQcondition;
		} catch (Exception e) {
		}
		return jQcondition;
	}
	
	/**
	 * Waits for the Condition of JavaScript.
	 * @param timeOutInSeconds
	 * @param condition
	 * @return {@link Boolean} true or false(condition fail, or if the timeout is reached)
	 */
	public static boolean waitForJavaScriptCondition(int timeOutInSeconds, final String condition, WebDriver driver) {
		boolean jscondition = false;
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // nullify implicitlyWait()
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject).executeScript(condition);
				}
			});
			jscondition = (Boolean) ((JavascriptExecutor) driver).executeScript(condition);
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS); // reset implicitlyWait
			return jscondition;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
     * Wait for the Text to not be present in the given element, regardless of being displayed or not.
     * @param element element, which should contain the text
     * @param String The text we don't want to see
     * @param int The time in seconds to wait until returning a failure
     * @return {@link Boolean}
     */
	public static boolean waitForTextNotPresent(final WebElement element, final String text, int timeOutInSeconds, WebDriver driver) {
		boolean isPresent = false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject) {
					return !isTextPresent(driverObject, element, text); // is the Text in the DOM
				}
			});
			isPresent = isTextPresent(driver, element, text);
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS); // reset implicitlyWait
			return isPresent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
     * Checks if the text is present in the element.
     * @param driver - The driver object to use to perform this element search
     * @param element - WebElement contain text
     * @param text - The Text element you are looking for
     * @return {@link Boolean}
     */
	private static boolean isTextPresent(WebDriver driver, WebElement element, String text) {
		try {
			return element.getText().contains(text);
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	/**
	 * Get today
	 * @param format
	 * @return {@link String}
	 */
	public static String getTodayDate(String format) {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(currentDate.getTime());
	}
	
	/**
	 * Environment info report
	 */
	public static void environmentInfoReport() {
		Reporter.log("Test was executed in the following environment:");
		Reporter.log("- URL: " + GetPropertyValues.getPropertyValue("url"));
		Reporter.log("- Execution date: " + Helper.getTodayDate("EEEE' 'dd' de 'MMMM' del 'yyyy' a las 'kk':'mm'hs'"));
	}

}
