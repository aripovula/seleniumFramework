package info.aripov.SeleniumFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	private WebDriver driver;
	
	public WebDriver initializeDriver() {
		
		Properties prop = new Properties();
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
		return driver;
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
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public String getLoginPage() {
		return "https://dv2yp2jkfi48m.cloudfront.net/login";
	}

}
