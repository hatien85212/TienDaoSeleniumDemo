package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.HomePage;
import qa.pages.LoginLinkedPage2;

public class LinkedInLoginPageTest extends TestBase {
	LoginLinkedPage2 loginPage;
	
	public LinkedInLoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		
	}
	
	@Test(priority=1)
	public void loginSucess(){
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		loginPage = new LoginLinkedPage2();	
		loginPage.login(username, password);
		
		HomePage homePage = new HomePage();
		String title = homePage.getPageTitle();
		System.out.println("title: " + title);
		Assert.assertEquals(title, "Feed | LinkedIn", "Login is failed with title: " + title);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
