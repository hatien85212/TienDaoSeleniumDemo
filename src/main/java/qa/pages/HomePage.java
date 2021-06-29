package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import qa.base.BasePage;

public class HomePage extends BasePage {
	
	WebElement searchResultNameElement;
	WebElement addedMessageElement; 
	
	@FindBy(xpath = "//input[@aria-label='Search']")
	WebElement txtSearch;

	@FindBy(xpath = "//a[text()='Message']")
	WebElement btnMessage;

	@FindBy(xpath = "//div[@aria-label='Write a message…']")
	WebElement txtMessage;

	@FindBy(xpath = "//button[text()='Send']")
	WebElement btnSend;
	
	@FindBy(id = "ember33")
	WebElement btnMe;
	
	@FindBy(linkText = "Sign Out")
	WebElement lnkSignOut;
	
	@FindBy(linkText = "Sign in")
	WebElement lnkSignIn;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage search(String searchText) {
		txtSearch.sendKeys(searchText);
		return this;
	}

	public HomePage clickSearchResult(String searchResultName) {
		updateSearchResultNameXpath(searchResultName);
		searchResultNameElement.click();
		return this;
	}
	public HomePage sendMessage(String msg) {
		btnMessage.click();
		txtMessage.sendKeys(msg);
		clickOn(btnSend);
		return this; 
	}
	public void signOut()
	{
		btnMe.click();
		clickAfterMouseOverOn(lnkSignOut);
	}

	public boolean isAddedMessageDisplayed(String inputMessage) {
		updateAddedMessageXpath(inputMessage);
		return addedMessageElement.isDisplayed();
	}
	public boolean isSearchBoxDisplayed() {
		return txtSearch.isDisplayed();
	}
	public boolean isSignInDisplayed() {
		return lnkSignIn.isDisplayed();
	}
	
	private void updateSearchResultNameXpath(String searchResultName) {
		String xpathSearchResultName = "//*[contains(text(), '{searchResult}')]";
		xpathSearchResultName = xpathSearchResultName.replace("{searchResult}", searchResultName);
		searchResultNameElement = driver.findElement(By.xpath(xpathSearchResultName));
	}
	private void updateAddedMessageXpath(String inputMessage) {
		String xpathAddedMessgae = "//p[text()='{addedMessage}']";
		xpathAddedMessgae = xpathAddedMessgae.replace("{addedMessage}", inputMessage);
		addedMessageElement = driver.findElement(By.xpath(xpathAddedMessgae));
	}
}
