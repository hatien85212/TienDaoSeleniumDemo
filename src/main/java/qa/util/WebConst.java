package qa.util;

public class WebConst {
	public static int PAGE_LOAD_TIMEOUT =20;
	public static int IMPLICIT_WAIT = 20;
	public static int EXPLICIT_WAIT = 5;
	public static int EXPLICIT_POLLING = 100;
	
	private static String DRIVER_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\driversWindows\\";
//	public static String CHROME_DRIVER_PATH = "C:/Users/tien.dao/DATA/Github/SeleniumDemo/src/test/resources/drivers/chromedriver.exe";
//	public static String CHROME_DRIVER_PATH =  DRIVER_PATH + "chromedriver.exe";
	public static String CHROME_DRIVER_PATH = "C:\\Users\\tien.dao\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe";
	public static String FF_DRIVER_PATH = DRIVER_PATH + "geckodriver";
}
