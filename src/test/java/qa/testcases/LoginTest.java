package qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
	@Test
//	public static void main(String[] args) throws InterruptedException {
	public void loginTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Volumes/DATA/chromedriver");

		WebDriver driver = new ChromeDriver(); // launch chrome
		By username = By.id("username");
		By password = By.id("password");
		By loginBtn = By.xpath("//button[@aria-label='Sign in']");

		By search = By.xpath("//input[@aria-label='Search']");
		By searchResultName = By.xpath("//*[contains(text(), 'Tien Dao Thi Ha')]");
//		By search = By.cssSelector("css=.search-global-typeahead__input");
		By messageBtn = By.xpath("//a[contains(.,'Message')]");
		By message = By.xpath("//div[@aria-label='Write a message…']");
		By sendMesssageBtn = By.xpath("//button[contains(.,'Send')]");

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.linkedin.com/login");
		System.out.println(driver.getCurrentUrl());

		driver.findElement(username).sendKeys("tien.dao85212@gmail.com");
		driver.findElement(password).sendKeys("L!nkauto85212");
		driver.findElement(loginBtn).click();

		System.out.println(driver.getCurrentUrl());

		// search and click on search result whose text is "abc" to send a message
		driver.findElement(search).sendKeys("Tien Dao");
		driver.findElement(searchResultName).click();
		driver.findElement(messageBtn).click();
		
		driver.findElement(message).sendKeys("This is automation message 2");
		driver.findElement(sendMesssageBtn).click();
		driver.close();
	}
}
