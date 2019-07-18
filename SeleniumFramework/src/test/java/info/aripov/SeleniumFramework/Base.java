package info.aripov.SeleniumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {
	private WebDriver driver;
	public Properties prop;
	public final Logger logBase = LogManager.getLogger(Base.class);
	
	public WebDriver initializeDriver() {
		
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("/Users/myfamily/git/SeleniumFramework/SeleniumFramework/data.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(prop.getProperty("browser")) {
		  case "chrome":
		    this.driver = getChrome();
		    break;
		  case "firefox":
			this.driver = getFirefox();
		    break;
		  default:
			this.driver = getChrome();
		}
		return this.driver;
	}
	
	private WebDriver getChrome(){
		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver = new ChromeDriver();
		this.otherSettings(driver);
		return driver;
	}
	
	private WebDriver getFirefox(){
		System.setProperty("webdriver.gecko.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/geckodriver");
		WebDriver driver =  new FirefoxDriver();
		this.otherSettings(driver);
		return driver;
	}
	
	private WebDriver otherSettings(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public void getScreenShot(String testName, WebDriver driver) {		
		logBase.info("driver 333 = " + driver);
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("/Users/myfamily/Documents/00CurWorks/AllCode/selenium/screensh_" + testName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void waitAndClose(WebDriver driver, Long seconds) {
		// wait before quitting browser
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

	@AfterMethod(alwaysRun = true)
	public void captureScreenshot(ITestResult result){
	    if(ITestResult.FAILURE==result.getStatus()){
	    	getScreenShot(result.getName() + "-new", driver);
	    }
	}

}
