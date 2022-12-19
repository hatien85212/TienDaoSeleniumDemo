package qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import qa.base.BaseTest;
import qa.pages.LoginPage;
import qa.pages.HomePage;

public class SendMessageTest extends BaseTest {
	LoginPage loginPage;
	WebDriver driver;

	@Test(priority = 1, dataProvider = "SendMessageProvider")

	public void verify_sending_message_succcessfully(String searchString, String searchResultName, String msg) {
		msg = msg + System.currentTimeMillis();

		driver = getDriver();
		loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.isSearchBoxDisplayed(), "Don't see the search box");

		homePage.search(searchString).clickSearchResult(searchResultName).sendMessage(msg);
		Assert.assertTrue(homePage.isAddedMessageDisplayed(msg), "Don't see added message: " + msg);

		homePage.signOut();
		Assert.assertTrue(homePage.isSignInDisplayed(), "Don't see Sign In link");
	}

	@DataProvider(name = "SendMessageProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Tien Dao Thi Ha", "Tien Dao Thi Ha", "This is auto msg from chrome with data provider " } };

	}

}
