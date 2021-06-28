package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.TestBase;

public class HomePage extends TestBase {
	
	WebElement searchResultNameElement; //a search result name selector
	WebElement addedMessageElement; //added message locator
	
	// LinkedIn Search
	@FindBy(xpath = "//input[@aria-label='Search']")
	static WebElement searchBox;

//	@FindBy(xpath = "//*[contains(text(), 'Tien Dao Thi Ha')]")
//	WebElement searchResultName;

	@FindBy(xpath = "//a[text()='Message']")
	WebElement messageBtn;

	// Send message box
	@FindBy(xpath = "//div[@aria-label='Write a message…']")
	WebElement message;

	@FindBy(xpath = "//button[text()='Send']")
	WebElement sendMesssageBtn;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void search(String searchText) {
		searchBox.sendKeys(searchText);
	}

	public void clickSearchResult(String searchResultName) {
//		searchResultName.click();
		updateSearchResultNameXpath(searchResultName);
		searchResultNameElement.click();
	}
	public void sendMessage(String msg) {
		messageBtn.click();
		message.sendKeys(msg);
		clickOn(sendMesssageBtn, 20);
	}

	public boolean isAddedMessageDisplayed(String inputMessage) {
		updateAddedMessageXpath(inputMessage);
		return addedMessageElement.isDisplayed();
	}
	public boolean isSearchBoxDisplayed() {
		return searchBox.isDisplayed();
	}
	
	public void updateSearchResultNameXpath(String searchResultName) {
		String xpathSearchResultName = "//*[contains(text(), '{searchResult}')]";
		xpathSearchResultName = xpathSearchResultName.replace("{searchResult}", searchResultName);
		searchResultNameElement = driver.findElement(By.xpath(xpathSearchResultName));
	}
	public void updateAddedMessageXpath(String inputMessage) {
		String xpathAddedMessgae = "//p[text()='{addedMessage}']";
		xpathAddedMessgae = xpathAddedMessgae.replace("{addedMessage}", inputMessage);
		addedMessageElement = driver.findElement(By.xpath(xpathAddedMessgae));
	}
}
