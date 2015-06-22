package automation.page.assets;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import automation.page.BasePage;

public class ImportAssetsPage extends BasePage{
	
	@FindBy(id = "userfile")
	private WebElement userfile;
	
	@FindBy(id = "chkIsHeaderInFile")
	private WebElement chkIsHeaderInFile;
	
	@FindBy(id = "save")
	private WebElement nextBtn;
	
	@FindBy(id = "s2id_cmbAssets")
	private WebElement assestType;
	
	@FindBy(xpath = "//*[@id='select2-results-1']//*[text()='Project']")
	private WebElement assestTypeProject;
	
	@FindBy(xpath = "//*[@id='select2-results-1']//*[text()='Name']")
	private WebElement assestTypeName;
	
	@FindBy(id = "chkPrimaryKeyName")
	private WebElement chkPrimaryKeyName;
	
	@FindBy(id = "s2id_cmbCSVAssetNameID")
	private WebElement select2dropmask;
	
	@FindBy(id = "s2id_cmbCSVField0")
	private WebElement select2results2;
	
	@FindBy(xpath = "//div[@id='select2-drop']//*[text()='Project Managers']")
	private WebElement assetFieldsProjectManager;
	
	@FindBy(xpath = "//ul[@id='select2-results-3']//*[text()='State']")
	private WebElement assetFieldsState;
	
	@FindBy(id = "s2id_cmbCSVField1")
	private WebElement select2results3;
	
	@FindBy(id = "btnPreview")
	private WebElement btnPreview;
	
	@FindBy(id = "btnImportData")
	private WebElement btnImportData;
	
	@FindBy(xpath = "//h4[text()='Result for Asset Import']/following-sibling::table/tbody/tr")
	private List<WebElement> resultsTable;
	
	@FindBy(id = "btnDone")
	private WebElement btnDone;
	
	@FindBy(id = "btnNext")
	private WebElement btnNext;
	
	@FindBy(xpath = "//div[@class='k-main']/h1")
	private WebElement resultsTitle;
	
	@FindBy(xpath = "//div[@class='k-confirm-layout']/section/header")
	private WebElement resultsHeader;
	
	@FindBy(xpath = "//div[@class='k-confirm-layout']/section/h4")
	private WebElement resultsSubHeader;
	
	
	/**
	 * Select Next
	 */
	public void selectNext() {
		Reporter.log("- Select Next");
		nextBtn.click();
	}
	
	/**
	 * Select File Header Row
	 */
	public void selectFileHeaderRow() {
		Reporter.log("- Select File Header Row");
		chkIsHeaderInFile.click();
	}
	
	/**
	 * Upload file
	 * @param filePath
	 */
	public void uploadFile(String filePath) {
		Reporter.log("- Upload csv: "+filePath);
		userfile.sendKeys(filePath);
	}
	
	/**
	 * Select Assert Type
	 */
	public void selectAssestType() {
		Reporter.log("- Select Assets type");
		assestType.click();
	}
	
	/**
	 * Select assets type = project
	 */
	public void selectAssetsTypeProject() {
		Reporter.log("- Select assets type = project");
		assestTypeProject.click();
	}
	
	/**
	 * Select next
	 */
	public void selectBtnNext() {
		Reporter.log("- Select next");
		btnNext.click();
	}
	
	/**
	 * Select Standard Fields
	 */
	public void selectStandardFields() {
		Reporter.log("- Select Standard fields");
		select2dropmask.click();
		
	}
	
	/**
	 * Select Asset Name (Text): Name
	 */
	public void selectAssestTypeName() {
		Reporter.log("- Select Asset Name (Text): Name");
		assestTypeName.click();
	}
	
	/**
	 * Select chkPrimaryKeyName
	 */
	public void selectChkPrimaryKeyName() {
		Reporter.log("- Active checkbox PK");
		chkPrimaryKeyName.click();
	}
	
	/**
	 * Select Asset Field First Combo
	 */
	public void selectAssetFieldsFirstCombo() {
		Reporter.log("- Select Asset Field First Combo");
		select2results2.click();
	}
	
	/**
	 * Select Asset Field First Combo - Project Manager
	 */
	public void selectAssetFieldProjectManager() {
		Reporter.log("- Select Asset Field First Combo - Project Manager");
		assetFieldsProjectManager.click();
	}
	
	/**
	 * Select Asset Field Second Combo
	 */
	public void selectAssetFieldsSecondCombo() {
		Reporter.log("- Select Asset Field Second Combo");
		select2results3.click();
	}
	
	/**
	 * Select Asset Field Second Combo - State
	 */
	public void selectAssetFieldState() {
		Reporter.log("- Select Asset Field Second Combo - State");
		assetFieldsState.click();
	}
	
	/**
	 * Select Preview
	 */
	public void selectPreview() {
		Reporter.log("- Select Preview");
		btnPreview.click();
	}
	
	/**
	 * Select Import data
	 */
	public void selectImportData() {
		Reporter.log("- Select Import Data");
		btnImportData.click();
	}
	
	/**
	 * Get Results
	 * @return {@link List} {@link String}
	 */
	public List<String> getResults() {
		List<String> ll = new LinkedList<String>();
		for (WebElement e : resultsTable) {
			ll.add(e.findElement(By.xpath(".//td")).getText());
		}
		return ll;
	}
	
	/**
	 * Select done
	 */
	public void selectDone() {
		Reporter.log("- Select Done");
		btnDone.click();
	}
	
	/**
	 * Get results title
	 * @return {@link String}
	 */
	public String getResultsTitle() {
		return resultsTitle.getText();
	}
	
	/**
	 * Get results header
	 * @return {@link String}
	 */
	public String getResultsHeader() {
		return resultsHeader.getText();
	}
	
	/**
	 * Get results sub-header
	 * @return {@link String}
	 */
	public String getResultsSubHeader() {
		return resultsSubHeader.getText();
	}

}
