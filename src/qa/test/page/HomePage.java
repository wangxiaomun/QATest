package qa.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage {
	private WebDriver webDriver;

	public HomePage(WebDriver driver, String url) {
		webDriver = driver;
		webDriver.get(url);
	}

	@FindBy(how = How.ID, using = "test-1-div")
	private WebElement test1Div;

	@FindBy(how = How.ID, using = "test-2-div")
	private WebElement test2Div;
	
	@FindBy(how = How.ID, using = "test-3-div")
	private WebElement test3Div;

	@FindBy(how = How.ID, using = "test-4-div")
	private WebElement test4Div;
	
	@FindBy(how = How.ID, using = "test-5-div")
	private WebElement test5Div;

	@FindBy(how = How.ID, using = "test-6-div")
	private WebElement test6Div;
}
