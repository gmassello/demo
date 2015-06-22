package automation.page.assets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automation.page.BasePage;

public class AssetsPage extends BasePage {
	
	@FindBy(id = "kgrid_page_search")
	private WebElement searchList;
	
	/**
	 * Get search list webElement
	 * @return {@link WebElement}
	 */
	public WebElement getSearchList() {
		return searchList;
	}

}
