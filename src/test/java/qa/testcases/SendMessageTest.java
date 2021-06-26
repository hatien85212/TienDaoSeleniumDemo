package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.HomePage;
import qa.pages.LoginLinkedPage2;

public class SendMessageTest extends TestBase {
	LoginLinkedPage2 loginPage;
	HomePage homePage;
	
	public SendMessageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		
	}
	
	@Test(priority=1)
	public void sendMessageSuccess(){
		String searchString = "Tien Dao";
		
		LinkedInLoginPageTest loginTest = new LinkedInLoginPageTest();
		loginTest.loginSucess();
		
		homePage = new HomePage();
		homePage.search(searchString);
		homePage.clickSearchResult();
		
		String msg = "This is auto msg from chrome " + System.currentTimeMillis();
		homePage.sendMessage(msg);
		Assert.assertTrue(homePage.isAddedMessageDisplayed(msg), "Don't see added message; " + msg);
	}
	
	@AfterMethod
	public void tearDown(){
//		driver.quit();
	}
}
