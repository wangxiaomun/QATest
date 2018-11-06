package qa.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver webdriver, String url) {
		driver = webdriver;
		driver.get(url);
		PageFactory.initElements(driver, this);
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

	public WebElement getTest1Div() {
		return test1Div;
	}

	public WebElement getTest2Div() {
		return test2Div;
	}

	public WebElement getTest3Div() {
		return test3Div;
	}

	public WebElement getTest4Div() {
		return test4Div;
	}

	public WebElement getTest5Div() {
		return test5Div;
	}

	public WebElement getTest6Div() {
		return test6Div;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
