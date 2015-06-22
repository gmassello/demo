package automation.actions;

import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import automation.helper.GetPropertyValues;
import automation.helper.Helper;
import automation.logging.Logging;
import automation.page.LoginPage;
import automation.page.SideNavigationPage;
import automation.page.assets.AssetsPage;
import automation.page.assets.ImportAssetsPage;

public class RegistrationActions {
	
	/**
	 * Importación de Proyectos en Kace
	 * @param user
	 * @param password
	 * @param driver
	 */
	public void fieldsValidation(String user, String password, WebDriver driver) {
		Helper.environmentInfoReport();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Logging.getInstance().getLogger().log(Level.INFO, "Navigate to url");
		loginPage.navigateTo(GetPropertyValues.getPropertyValue("url"), driver);
		Logging.getInstance().getLogger().log(Level.INFO, "Complete Login");
		loginPage.switchToFrame(driver);
		loginPage.completeLoginTextBox(user);
		loginPage.completePasswordTextBox(password);
		loginPage.selectLogin();
		Helper.waitForJQueryProcessing(60, driver);
		SideNavigationPage sideNavigationPage = PageFactory.initElements(driver, SideNavigationPage.class);
		Logging.getInstance().getLogger().log(Level.INFO, "Side Navigation to Import Assests");
		sideNavigationPage.selectAssetsLink();
		sideNavigationPage.selectImportAssetsLink();
		ImportAssetsPage importAssetsPage = PageFactory.initElements(driver, ImportAssetsPage.class);
		Logging.getInstance().getLogger().log(Level.INFO, "Upload csv");
		importAssetsPage.uploadFile(System.getProperty("user.dir")+GetPropertyValues.getPropertyValue("csvPath"));
		Helper.waitForJQueryProcessing(60, driver);
		importAssetsPage.selectFileHeaderRow();
		importAssetsPage.selectNext();
		Logging.getInstance().getLogger().log(Level.INFO, "Asset Type Selection");
		importAssetsPage.selectAssestType();
		importAssetsPage.selectAssetsTypeProject();
		importAssetsPage.selectBtnNext();
		Logging.getInstance().getLogger().log(Level.INFO, "Mapping");
		importAssetsPage.selectStandardFields();
		importAssetsPage.selectAssestTypeName();
		importAssetsPage.selectChkPrimaryKeyName();
		importAssetsPage.selectAssetFieldsFirstCombo();
		importAssetsPage.selectAssetFieldProjectManager();
		importAssetsPage.selectAssetFieldsSecondCombo();
		importAssetsPage.selectAssetFieldState();
		Logging.getInstance().getLogger().log(Level.INFO, "Confirmation");
		importAssetsPage.selectPreview();
		Helper.waitForJQueryProcessing(60, driver);
		importAssetsPage.selectImportData();
		Logging.getInstance().getLogger().log(Level.INFO, "Import Results");
		Helper.waitForJQueryProcessing(240, driver);
		List<String> results = importAssetsPage.getResults();
		validateResultsTable(results, importAssetsPage);
		for (String result : results) {
			Reporter.log(result);
		}
		Logging.getInstance().getLogger().log(Level.INFO, "Done Import");
		importAssetsPage.selectDone();
		AssetsPage assetsPage = PageFactory.initElements(driver, AssetsPage.class);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(assetsPage.getSearchList()));
		Assert.assertTrue(driver.getCurrentUrl().contains("/assets.php"));
	}
	
	/**
	 * Validate Results table composition
	 * @param table
	 * @param importAssetsPage
	 */
	private void validateResultsTable(List<String> table, ImportAssetsPage importAssetsPage) {
		Assert.assertEquals(importAssetsPage.getResultsTitle(), "Asset Import Wizard - Result");
		Assert.assertEquals(importAssetsPage.getResultsHeader(), "Asset Import Completed");
		Assert.assertEquals(importAssetsPage.getResultsSubHeader(), "Result for Asset Import");
		String[] template = {"Successfully Inserted", "Successfully Updated", "Successfully Created", "Rejected", "Error Records"};
		int index = 0;
		for (String result : table) {
			Assert.assertTrue(result.contains(template[index]));
			index++;
		}
	}

}
