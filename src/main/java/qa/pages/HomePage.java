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
		log.info("========== Start search... ==========");
		txtSearch.sendKeys(searchText);
		log.info("========== End search... ==========");
		return this;
	}

	public HomePage clickSearchResult(String searchResultName) {
		log.info("========== Start clickSearchResult... ==========");
		updateSearchResultNameXpath(searchResultName);
		searchResultNameElement.click();
		log.info("========== End clickSearchResult... ==========");
		return this;
	}
	public HomePage sendMessage(String msg) {
		log.info("========== Start sendMessage... ==========");
		btnMessage.click();
		txtMessage.sendKeys(msg);
		clickOn(btnSend);
		log.info("========== End sendMessage... ==========");
		return this; 
	}
	public void signOut()
	{
		log.info("========== Start signOut... ==========");
		btnMe.click();
		clickAfterMouseOverOn(lnkSignOut);
		log.info("========== End signOut... ==========");
	}

	public boolean isAddedMessageDisplayed(String inputMessage) {
		log.info("========== Start isAddedMessageDisplayed... ==========");
		By byAddedMessage = updateAddedMessageXpath(inputMessage);
		waitForElementToAppear(byAddedMessage);
		log.info("========== End isAddedMessageDisplayed... ==========");
		return true;
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
	private By updateAddedMessageXpath(String inputMessage) {
		String xpathAddedMessage = "//p[text()='{addedMessage}']";
		By byAddedMessage = By.xpath(xpathAddedMessage.replace("{addedMessage}", inputMessage));
		addedMessageElement = driver.findElement(byAddedMessage);
		return byAddedMessage;
	}
}
