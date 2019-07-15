package info.aripov.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePage extends Base {

	WebDriver driver;
	
	@Test
	void TestTitle() {
		driver = initializeDriver();
	}
	
}
