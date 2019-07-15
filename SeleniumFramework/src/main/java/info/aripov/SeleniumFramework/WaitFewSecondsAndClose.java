package info.aripov.SeleniumFramework;

import org.openqa.selenium.WebDriver;

public class WaitFewSecondsAndClose {

	public void WaitAndClose(WebDriver driver, Long seconds) {
		// wait before quitting browser
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
