package PageObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	WebDriver driver;
	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
//	@FindBy(name="email")
//	WebElement username;
//	
//	@FindBy(name="password")
//	WebElement password;
	
	By username = By.cssSelector("input[placeholder='username']");
	By password = By.cssSelector("input[placeholder='password']");
	By next = By.cssSelector("button[class*='button'");
	
	public WebElement usernameInput() {
		return driver.findElement(username);
	}

	public WebElement passwordInput() {
		return driver.findElement(password);
	}

	public WebElement nextButton() {
		return driver.findElement(next);
	}

}
