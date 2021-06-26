package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.base.TestBase;

public class LoginLinkedPage extends TestBase{
	WebDriver driver;
	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.xpath("//button[@aria-label='Sign in']");
	
	public LoginLinkedPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String un, String pwd) {
		enterUsername(un);
		enterPassword(pwd);
		clickSignIn();
	}
	public void enterUsername(String un) {
		driver.findElement(username).sendKeys(un);
	}
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickSignIn() {
		driver.findElement(loginBtn).click();
	}

}
