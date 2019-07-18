package info.aripov.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import PageObjectsRepo.LoginPageObjects;

public class HomePageTest extends Base {

	WebDriver driver;
	
//	@DataProvider
//	Object[][] getData() {
//		Object[][] data = new Object[2][2];
//		data[0][0] = "weblaruchun";
//		data[0][1] = "passord";
//
//		data[1][0] = "weblaruchun2";
//		data[1][1] = "passord";
//		return data;
//	}
	
//	@Test(dataProvider = "getData")
	@Test
	void testTitle() {
//	void testTitle(String username, String password) {
		driver = initializeDriver();
		driver.get(prop.getProperty("homeURL"));

		WebDriverWait expwait = new WebDriverWait(driver, 10);
		
		LoginPageObjects lpo = new LoginPageObjects(driver);
				
//		lpo.usernameInput().clear();
//		lpo.usernameInput().sendKeys(username);
		
		
//		expwait.until(ExpectedConditions.elementToBeClickable(lpo.nextButton()));
//		lpo.nextButton().click();
		
//		lpo.passwordInput().clear();
//		lpo.passwordInput().sendKeys(password);
		

//		expwait.until(ExpectedConditions.elementToBeClickable(lpo.nextButton()));
//		lpo.nextButton().click();
		

		
		

		
	}
	
	@AfterSuite
	public void wrapTestSuite() {
		waitAndClose(driver, 3000L);
	}
	
}
