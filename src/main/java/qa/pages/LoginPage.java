package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import qa.base.BasePage;

public class LoginPage extends BasePage {
	@FindBy(id = "username")
	WebElement txtUsername;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@aria-label='Sign in']")
	WebElement btnSignIn;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public HomePage login(String username, String password) {
		log.info("========== Start login... ==========");
		waitForElementToBeClickable(btnSignIn);
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
//		btnSignIn.click();
		clickOn(btnSignIn);
		log.info("========== End login... ==========");
		return new HomePage(driver);
	}
}
