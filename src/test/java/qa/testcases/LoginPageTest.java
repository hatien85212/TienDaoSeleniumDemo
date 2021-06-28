package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.HomePage;
import qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();

	}

	@Test(priority = 1)
	public void loginSucess() {
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		loginPage = new LoginPage();
		loginPage.login(username, password);

		HomePage homePage = new HomePage();
		Assert.assertTrue(homePage.isSearchBoxDisplayed(), "Don't see the search box");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
