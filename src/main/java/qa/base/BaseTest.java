package qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import qa.util.WebEventListener;
import qa.util.TestUtil;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eDriver;
	public static WebEventListener eventListener;

	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream config = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/qa/config/config.properties");
			prop.load(config);
			System.out.println("Run BaseTest");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public static void setup() {
		System.out.println("@BeforeMethod -- Initializing the browser");
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
		} else if (browserName.equals("FF") || browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriverPath"));
			driver = new FirefoxDriver();
		}

		eDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eDriver.register(eventListener);
		driver = eDriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("linkedInURL"));

	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("@AfterMethod -- close browser");
		driver.close();
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
