package com.ascap.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ascap.maps.DataMaps;
import com.relevantcodes.extentreports.*;
import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;
import ru.yandex.qatools.ashot.cropper.indent.IndentFilerFactory;

public class SupportUtils {

	// WebConnector
	public static WebDriver driver;
	static Properties OR = null;
	static Properties CONFIG = null;
	static WebDriver mozilla = null;
	static WebDriver chrome = null;
	public List<String> finalResult = new ArrayList<String>();
	public String currentReportFolder;
	public String testData;
	ExtentTest scenarioTest;

	static {
		if (OR == null) {
			try {
				// initialize OR
				OR = new Properties();
				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir") + "/src/main/resources/OR.properties");
				OR.load(fs);

				// initialize CONFIG
				CONFIG = new Properties();
				fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
				CONFIG.load(fs);
			} catch (Exception e) {
				System.out.println("Error on intializing properties files");
			}
		}
	}

	// opening the browser
	public static void openBrowser(String browserType) {

		if (browserType.equals("Mozilla") && mozilla == null) {
			System.setProperty("webdriver.gecko.driver", "C:/Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			mozilla = driver;
		} else if (browserType.equals("Mozilla") && mozilla != null) {
			driver = mozilla;
		} else if (browserType.equals("Chrome") && chrome == null) {
			System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
			driver = new ChromeDriver();
			chrome = driver;
		} else if (browserType.equals("Chrome") && chrome == null) {
			driver = chrome;
		}

		else if (browserType.equals("IE")) {
			// set the IE server exe path and initialize
		}
		// max
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// opening the browser
	public void openBrowser() {

		if (getBrowser().equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", getDriverPath("FirefoxDriverPath"));
			driver = new FirefoxDriver();
		} else if (getBrowser().equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", getDriverPath("ChromeDriverPath"));
			driver = new ChromeDriver();
		} else if (getBrowser().equalsIgnoreCase("IE")) {
			// set the IE server exe path and initialize
		}
		// max
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// navigates to a URL
	public void navigateToUrl() {
		driver.navigate().to(getUrl());
	}

	public static String getBrowser() {
		String browser = CONFIG.getProperty("browser");
		return browser;
	}

	public static String getUrl() {
		return DataMaps.url.get("QA");
	}

	public static String getDriverPath(String path) {
		String driverPath = CONFIG.getProperty(path);
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the config.properties file.");
	}

	public static WebDriver getDriver() {
		return driver;
	}

	// Close browser
	public void closeBrowser() {
		driver.close();
	}

	public String getDataFromJson(String sheetName, String dataType) {
		TestDataLoader dataLoader = new TestDataLoader();
		testData = dataLoader.getTestData(sheetName, dataType);
		return testData;
	}

	public void takeFailedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotBytes, "image/png");
		}
		driver.close();
	}

	public void writeExtentPass(String Infomsg) {
		scenarioTest.log(LogStatus.PASS, Infomsg, "PASSED");
	}

	public void writeExtentFail(String Infomsg, WebElement elementtotakescreenshot) throws IOException {
		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider())
				.imageCropper(new IndentCropper().addIndentFilter(IndentFilerFactory.blur()))
				.takeScreenshot(driver, elementtotakescreenshot);

		File createfile = new File(System.getProperty("user.dir") + "\\output\\" + currentReportFolder + "\\aShot"
				+ System.currentTimeMillis() + ".png");
		ImageIO.write(screenshot.getImage(), "PNG", createfile);

		String image = scenarioTest.addScreenCapture(createfile.getAbsolutePath());
		scenarioTest.log(LogStatus.FAIL, Infomsg, image);

	}

}

/*
 * private static Properties prop; static { prop = new Properties(); try {
 * FileInputStream fis = new FileInputStream( System.getProperty("user.dir") +
 * "\\src\\main\\resources\\config\\config.properties"); prop.load(fis); } catch
 * (IOException e) { e.printStackTrace(); } }
 * 
 * public static Properties getproperty() { return prop; }
 * 
 * public static boolean isRemoteEnvironment() { if
 * (prop.getProperty("RemoteEnvironment").equalsIgnoreCase("YES")) { return
 * true; } return false; }
 * 
 * public static String Browser() { String browser =
 * prop.getProperty("Browser"); return browser; }
 * 
 * public static String path() { String path = prop.getProperty("Browser");
 * return path; }
 * 
 * public static String remotEnv() { String remoteEnv =
 * prop.getProperty("RemoteEnvironment"); return remoteEnv; }
 * 
 * public static String remotURL() { String remoteURL =
 * prop.getProperty("RemoteURL"); return remoteURL; }
 * 
 * }
 */