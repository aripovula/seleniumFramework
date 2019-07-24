package stepDefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjectsRepo.HomePageObjects;
import PageObjectsRepo.LoginPageObjects;
import info.aripov.SeleniumFramework.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;;

@RunWith(Cucumber.class)
public class StepDefinitions extends Base {
	WebDriverWait expwait;
	LoginPageObjects lpo;
	HomePageObjects hpo;

    @Given("^User opens the app$")
    public void user_opens_the_app() throws Throwable {
        driver = initializeDriver();
		driver.get(prop.getProperty("loginURL"));
		logBase.info("driver is setup, opening " + prop.getProperty("loginURL"));
    }
 
    @When("^user enters (.+) and password (.+)$")
    public void user_enters_and_password(String username, String password) throws Throwable {
    	logBase.info("strArg1-" + username + "  strArg2-" + password);
//        throw new PendingException();
		expwait = new WebDriverWait(driver, 10);	
		lpo = new LoginPageObjects(driver);
		hpo = new HomePageObjects(driver);
		
		lpo.usernameInput().clear();
		lpo.usernameInput().sendKeys(username);
				
		lpo.passwordInput().clear();
		lpo.passwordInput().sendKeys(password);
		
		expwait.until(ExpectedConditions.elementToBeClickable(lpo.nextButton()));
		lpo.nextButton().click();
    }

    @Then("^Dashboard page opened is (.+)$")
    public void dashboard_page_opened_is(String condition) throws Throwable {
//        throw new PendingException();
    	logBase.info("Nav bar - " + hpo.navBar().isDisplayed());
		Assert.assertTrue(hpo.navBar().isDisplayed());
		Assert.assertEquals(hpo.logoutLinkText().getText(), "Logout");
    }

    @And("^all charts and KPI status shown is (.+)$")
    public void all_charts_and_kpi_status_shown_is(String condition) throws Throwable {
//        throw new PendingException();
		logBase.info("Before closing !");
		waitAndClose(driver, 3000L);

    }

}