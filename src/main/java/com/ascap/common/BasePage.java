package com.ascap.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascap.maps.DataMaps;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.*;
import org.json.simple.JSONObject;

public class BasePage extends SupportUtils {

	public static final int WAIT_IN_SECONDS = 20;
	public static Logger log = Logger.getLogger("ApplicationLogger");
	
	
	public boolean isDisplayed(By by) {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(by);
			flag = element.isDisplayed();
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return flag;
	}

	public boolean isEnable(By by) {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(by);
			flag = element.isEnabled();
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return flag;
	}

	public WebElement waitForElement(By by) {
		return waitForElement(by, 10, 1);
	}

	public WebElement waitForElement(WebElement element) {
		return waitForElement(element, 10, 1);
	}

	private WebElement waitForElement(WebElement webElement, int timeoutInSecs, int pollingTimeInSecs) {
		waitExplicitly(timeoutInSecs, pollingTimeInSecs, ExpectedConditions.visibilityOf(webElement));
		return webElement;
	}

	private WebElement waitForElement(By by, int timeoutInSecs, int pollingTimeInSecs) {
		WebElement webElement = driver.findElement(by);
		waitExplicitly(timeoutInSecs, pollingTimeInSecs, ExpectedConditions.visibilityOf(webElement));
		return webElement;
	}

	public WebElement waitForElementClickable(By by, int timeoutInSecs, int pollingTimeInSecs) {
		WebElement webElement = driver.findElement(by);
		waitExplicitly(timeoutInSecs, pollingTimeInSecs, ExpectedConditions.elementToBeClickable(by));
		return webElement;
	}

	public WebElement waitForElementClickable(By by) {
		return PageWaitUtil.waitForElementClickable(by);
	}

	public void waitForPageToLoad(By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(5000)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	private void waitExplicitly(int timeoutInSecs, int pollingTimeInSecs,
			ExpectedCondition<WebElement> expectedCondition) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSecs);
		wait.pollingEvery(Duration.ofMillis(pollingTimeInSecs * 1000));
		wait.until(expectedCondition);
	}

	public boolean isElementPresent(By by) {
		try {
			boolean flag = false;
			if (driver.findElements(by).size() > 0) {
				flag = true;
			}
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	public JavascriptExecutor getJavaScriptExecutor() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	public void clickWithJavaScript(By by) {
		getJavaScriptExecutor().executeScript("argument[0].click();", waitForElement(by));
	}

	public void clickWithJavaScript(WebElement by) {
		getJavaScriptExecutor().executeScript("arguments[0].click();", waitForElement(by));
	}

	public void scrollToElement(WebElement element) {
		int scrollBy = element.getLocation().y + 25;
		getJavaScriptExecutor().executeScript("window.scrollBy(0," + scrollBy + ");");
	}

	public static String getRandomNumericString(int i) {
		return RandomStringUtils.randomNumeric(i);
	}

	public List<WebElement> waitForElementsBy(final By by) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return driver.findElements(by);

	}

	public void selectItemByText(WebElement element, String text) {
		Select select = new Select(waitForElement(element));
		select.deselectByValue(text);
	}

	public void selectItemByValue(WebElement element, String itemToSelect) {
		Select select = new Select(waitForElement(element));
		select.deselectByValue(itemToSelect);
	}

	public void selectItemByText(By element, String itemToSelect) {
		Select select = new Select(waitForElement(element));
		select.deselectByValue(itemToSelect);
	}

	public void selectItemByText(WebElement element, int index) {
		Select select = new Select(waitForElement(element));
		select.deselectByIndex(index);
	}

	public void selectItemByText(By element, int index) {
		Select select = new Select(waitForElement(element));
		select.deselectByIndex(index);
	}

	public WebElement waitForElementLoad(By by) {
		WebElement element;
		// try {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		// }catch(Exception e) {

		// }
		return element;
	}

	public void sleep(int sleepInSeconds) {
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.SECOND, sleepInSeconds);
		while (cal1.after(cal)) {
			cal = Calendar.getInstance();
		}
	}

	public void clickButton(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebDriverWait getWaitDriverInstance(int time) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait;
	}

	public static void waitTillMultipleWIndowHandles() {
		Set<String> allWindows = driver.getWindowHandles();
		while (allWindows.size() == 1) {
			allWindows = driver.getWindowHandles();
		}
	}

	public static void switchToLastTab() {
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(browserTabs.size() - 1));
	}

	public static void switchToFirstTab() {
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(browserTabs.size() - browserTabs.size()));
	}

	public static void closeTab() {
		driver.close();
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(browserTabs.size() - 1));
	}

	public void scrollDownTillEndOfPage() {
		Integer pageLoadCount = 0;
		if (pageLoadCount == 0) {
			for (int i = 0; i <= 10; i++) {
				scrollDown();
				sleep(1);
			}
			pageLoadCount++;
		}
	}

	private void scrollDown() {
		getJavaScriptExecutor().executeScript("window.scrollBy(0,2000)", "");
	}

	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void clickElementWithJavaScript(WebElement element) {
		if (driver instanceof JavascriptExecutor) {
			getJavaScriptExecutor().executeScript("arguments[0].click()", element);
		}
	}

	public boolean hasNoElementAsExpected(By by) {
		WebElement element;
		try {
			element = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (TimeoutException e) {
			return true;
		}
		return Boolean.valueOf(element == null || !element.isDisplayed());
	}

	public static String getRandomString(int i) {
		return RandomStringUtils.randomNumeric(i);
	}

	public static String userNameGenerator(int i) {
		return RandomStringUtils.randomAlphabetic(i);
	}

	public static String SSNorTaxIDGenerator() {
		return RandomStringUtils.randomNumeric(9);
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	public WebElement findElementWithinIFrame(By by) {
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		for (WebElement iframe : iframes) {
			driver.switchTo().frame(iframe);
			if (hasElement(by)) {
				return driver.findElement(by);
			}
		}
		return null;
	}

	public boolean hasElement(By by) {
		return countElements(by) != 0;
	}

	public int countElements(By by) {
		int result = 0;
		long currentWaitMillis = 5000;
		try {
			if (currentWaitMillis > 0) {
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			}
			result = driver.findElements(by).size();
		} finally {
			driver.manage().timeouts().implicitlyWait(currentWaitMillis, TimeUnit.MILLISECONDS);
		}
		return result;
	}

	public List<WebElement> waitForElements(final By by) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return driver.findElements(by);
	}

	public List<WebElement> waitForElementsOnWebElement(final By by1, final By by2) {
		return driver.findElement(by1).findElements(by2);
	}

	public void selectValuesFromDropDown(String optionName, By by) {
		waitForPageToLoad(by);
		List<WebElement> operations = waitForElementsBy(by);
		for (WebElement function : operations) {
			if (function.getText().equalsIgnoreCase(optionName)) {
				clickWithJavaScript(function);
				sleep(3);
				break;
			}
		}
	}

	public void selectRadioButton(String optionName, By by) {
		waitForPageToLoad(by);
		List<WebElement> buttons = waitForElementsBy(by);
		for (WebElement button : buttons) {
			if (button.getText().equalsIgnoreCase(optionName)) {
				clickWithJavaScript(button);
				sleep(3);
				break;
			}
		}
	}

	public static String getFileContent(String fileName, String filePath) {
		StringBuffer stringBuffer = new StringBuffer();
		try {
			File file = new File(filePath);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}
}
