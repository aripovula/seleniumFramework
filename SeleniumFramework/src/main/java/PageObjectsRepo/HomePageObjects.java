package PageObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	
	WebDriver driver;
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}
		
	By logoutLink = By.cssSelector("a[href='#']");
	By navBar = By.cssSelector("div[class*='header__content'");
//	By next = By.cssSelector("button[class*='button'");
	
	public WebElement logoutLinkText() {
		return driver.findElement(logoutLink);
	}

	public WebElement navBar() {
		return driver.findElement(navBar);
	}

//	public WebElement nextButton() {
//		return driver.findElement(next);
//	}

}
