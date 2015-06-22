package automation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SideNavigationPage {
	
	@FindBy(className = "k-ctrl-collapsed")
	private WebElement ctrlCollapsed;
	
	@FindBy(xpath = "//li[@id='k_main_nav_assets']/a/span")
	private WebElement assetsLink;
	
	@FindBy(xpath = "//li[@id='uploadfile-page']/a")
	private WebElement importAssetsLink;
	
	/**
	 * Select Collapsed SideBar
	 */
	public void selectCollapsed() {
		ctrlCollapsed.click();
	}
	
	/**
	 * Select Assets Link
	 */
	public void selectAssetsLink() {
		Reporter.log("- Select Assets Link");
		assetsLink.click();
	}
	
	/**
	 * Select Import Assets
	 */
	public void selectImportAssetsLink() {
		Reporter.log("- Select Import Assets");
		importAssetsLink.click();
	}

}
