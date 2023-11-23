package qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;ß
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import config.WebConst.Browser_Type;
import io.github.bonigarcia.wdm.WebDriverManager;
import qa.util.WebEventListener;
import qa.util.WebConst;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringDecorator eDriver;
	public static WebEventListener eventListener;
	public static Logger log;

	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream config = new FileInputStream("src/test/resources/config.properties");
			prop.load(config);
			log = Logger.getLogger(BaseTest.class);
			log.info("Run BaseTest");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public static void setup() {
		log.info("@BeforeMethod -- Initializing the browser");
		String browserName = prop.getProperty("browser");

//		
//		if (browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver",WebConst.CHROME_DRIVER_PATH);
//			ChromeOptions options = new ChromeOptions(); // solve err on Chrome 111+:  WARNING: Invalid Status code=403 text=Forbidden
//			options.addArguments("--remote-allow-origins=*");
//			driver = new ChromeDriver(options);
//		} else if (browserName.equals("FF") || browserName.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver",WebConst.FF_DRIVER_PATH);
//			driver = new FirefoxDriver();
//		}

		if (browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("IEEdge")) {		
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();			
		}	
//		eDriver = new EventFiringWebDriver(driver);
//		eventListener = new WebEventListener();
//		eDriver.register(eventListener);
//		driver = eDriver;
		
//		WebEventListener listener = new WebEventListener();// Create instance of Listener Class
//		WebDriver decorated = new EventFiringDecorator(listener).decorate(driver);
//		decorated.get("http://example.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(WebConst.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(WebConst.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WebConst.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebConst.IMPLICIT_WAIT));
		log.info("***** get linkkedInURL *******");
		driver.get(prop.getProperty("linkedInURL"));
		log.info("***** end get linkkedInURL *******");
	}
	
	@AfterMethod
	public void tearDown()
	{
		log.info("@AfterMethod -- close browser");
		driver.close();
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
