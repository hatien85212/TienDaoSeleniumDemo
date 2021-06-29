package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import qa.base.BaseTest;
import qa.pages.HomePage;
import qa.pages.LoginPage;

public class SendMessageTest extends BaseTest{
	LoginPage loginPage;

	@Test(priority = 1)
	public void verify_sending_message_succcessfully() {
		String searchString = "Tien Dao";
		String searchResultName = "Tien Dao Thi Ha";
		String msg = "This is auto msg from chrome " + System.currentTimeMillis();

		loginPage = new LoginPage(getDriver());
		HomePage homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(homePage.isSearchBoxDisplayed(), "Don't see the search box");

		homePage.search(searchString);
		homePage.clickSearchResult(searchResultName);
		homePage.sendMessage(msg);
		Assert.assertTrue(homePage.isAddedMessageDisplayed(msg), "Don't see added message: " + msg);
		
		homePage.signOut();
		Assert.assertTrue(homePage.isSignInDisplayed(), "Don't see Sign In link");
	}

}
