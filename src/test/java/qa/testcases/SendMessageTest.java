package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.HomePage;

public class SendMessageTest extends TestBase {
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
		String searchResultName = "Tien Dao Thi Ha";
		
		LoginPageTest loginTest = new LoginPageTest();
		loginTest.loginSucess();
		
		HomePage homePage = new HomePage();
		homePage.search(searchString);
		homePage.clickSearchResult(searchResultName);
		
		//send message
		String msg = "This is auto msg from chrome " + System.currentTimeMillis();
		homePage.sendMessage(msg);
		//verify the message is added
		Assert.assertTrue(homePage.isAddedMessageDisplayed(msg), "Don't see added message; " + msg);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
