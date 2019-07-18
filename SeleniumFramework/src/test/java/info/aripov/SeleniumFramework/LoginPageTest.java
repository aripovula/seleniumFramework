package info.aripov.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectsRepo.HomePageObjects;
import PageObjectsRepo.LoginPageObjects;

public class LoginPageTest extends Base {

	WebDriver driver;
	WebDriverWait expwait;
	LoginPageObjects lpo;
	HomePageObjects hpo;
	
	@DataProvider
	Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "weblaruchun";
		data[0][1] = "passord";

//		data[1][0] = "weblaruchun2";
//		data[1][1] = "passord";
		return data;
	}
	
	
	@BeforeTest
	public void setupTest() {
		driver = initializeDriver();
		driver.get(prop.getProperty("loginURL"));
		logBase.info("driver is setup, opening " + prop.getProperty("loginURL"));

		expwait = new WebDriverWait(driver, 10);
		
		lpo = new LoginPageObjects(driver);
		hpo = new HomePageObjects(driver);		
	}

	@Test(dataProvider = "getData")
	void testLogin(String username, String password) {
		lpo.usernameInput().clear();
		lpo.usernameInput().sendKeys(username);
				
		lpo.passwordInput().clear();
		lpo.passwordInput().sendKeys(password);
		
		expwait.until(ExpectedConditions.elementToBeClickable(lpo.nextButton()));
		lpo.nextButton().click();
		 
		AssertJUnit.assertTrue(hpo.navBar().isDisplayed());
		AssertJUnit.assertEquals(hpo.logoutLinkText().getText(), "Logout");
	}
	
	@Test(groups= {"smoke"}, dependsOnMethods= {"testLogin", "testLogin"})
	void testLink() {
		Assert.assertTrue(true);
	}
	
//	@AfterMethod(alwaysRun = true)
//	public void captureScreenshot(ITestResult result){
//	    if(ITestResult.FAILURE==result.getStatus()){
//	    	getScreenShot(result.getName(), driver);
//	    }
//	}
	
	@AfterTest
	public void teardown() {
		logBase.info("Before closing !");
		waitAndClose(driver, 3000L);
	}
	
}
