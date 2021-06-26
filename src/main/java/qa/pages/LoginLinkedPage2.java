package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.TestBase;

public class LoginLinkedPage2 extends TestBase {
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@aria-label='Sign in']")
	WebElement loginBtn;

	public LoginLinkedPage2() {
		PageFactory.initElements(driver, this);
//		driver.get(prop.getProperty("url") + "/login");
	}

	public void login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}

}
