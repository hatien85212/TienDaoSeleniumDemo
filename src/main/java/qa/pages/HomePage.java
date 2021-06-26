package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// LinkedIn Search, send message
	@FindBy(xpath = "//input[@aria-label='Search']")
	WebElement searchBox;

	@FindBy(xpath = "//*[contains(text(), 'Tien Dao Thi Ha')]")
	WebElement searchResultName;

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

	public static String getPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public void sendMessage(String msg) {
		messageBtn.click();
		message.sendKeys(msg);
		clickOn(sendMesssageBtn, 20);
	}

	public void search(String searchText) {
		searchBox.sendKeys(searchText);
	}

	public void clickSearchResult() {
		searchResultName.click();
	}

	public boolean isAddedMessageDisplayed(String inputMessage) {
		String xpathAddedMessgae = "//p[text()='{addedMessage}']";
		xpathAddedMessgae = xpathAddedMessgae.replace("{addedMessage}", inputMessage);
		WebElement addedMessage = driver.findElement(By.xpath(xpathAddedMessgae));

		return addedMessage.isDisplayed();
	}

//	public ContactsPage clickOnContactsLink(){
//		contactsLink.click();
//		return new ContactsPage();
//	}
//	
//	public DealsPage clickOnDealsLink(){
//		dealsLink.click();
//		return new DealsPage();
//	}
//	
//	public TasksPage clickOnTasksLink(){
//		tasksLink.click();
//		return new TasksPage();
//	}

	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();

	}

}
