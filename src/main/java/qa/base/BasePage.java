package qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.util.WebConst;

public class BasePage {

	protected WebDriver driver;
	protected String Path;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, WebConst.EXPLICIT_WAIT, WebConst.EXPLICIT_POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WebConst.EXPLICIT_WAIT), this);
	}
	
	protected String getPageTitle() {
		return driver.getTitle();
	}

	protected void clickOn(WebElement locator) {
		int count=0;
		do {
			
			try {
//				wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
				waitForElementToBeClickable(locator);
				locator.click();
				count = 6;
			} catch (Exception e) {
				count++;
			}
		} while (count<=5);
	}

	protected void clickOnByJavaScript(WebElement locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", locator);

	}

	protected void clickAfterMouseOverOn(WebElement locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		actions.moveToElement(locator).click().build().perform();
		js.executeScript("arguments[0].click();", locator);
	}

	protected void waitForElementToAppear(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	protected void waitForElementToAppear(WebElement locator) {
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	protected void waitForElementToDisappear(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	protected void waitForElementToDisappear(WebElement locator) {
		wait.until(ExpectedConditions.invisibilityOf(locator));
	}

	protected void waitForTextToDisappear(WebElement locator, String text) {
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(locator, text)));
	}
	
	protected void waitForTextToAppear(WebElement locator, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(locator, text));
	}
	
	protected void waitForElementToBeClickable(WebElement locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
