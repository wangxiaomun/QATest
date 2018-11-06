package qa.test.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import qa.test.page.*;

public class BaseTest {
	private WebDriver driver;
	private final String currentDir = System.getProperty("user.dir");

	@Test
	public void function() throws InterruptedException {
		HomePage homepage = new HomePage(driver,"file://"+currentDir+"/Resource/index.html");		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", currentDir + "/chromedriver");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		// Quitting the browser.
		driver.quit();
	}
}
