package qa.test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class HomePageTest extends BaseTest {

	@Test
	public void test1Func() {
		try {
			Thread.sleep(1000);
			WebElement test1Div = getHomePage().getTest1Div();
			WebElement inputEmail = test1Div.findElement(By.id("inputEmail"));
			WebElement inputPassword = test1Div.findElement(By.id("inputPassword"));
			WebElement signInBtn = test1Div.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
			Assert.assertTrue(inputEmail.isDisplayed());
			Assert.assertTrue(inputPassword.isDisplayed());
			Assert.assertTrue(signInBtn.isDisplayed());
			inputEmail.sendKeys("wangxiaomun@gmail.com");
			inputPassword.sendKeys("password");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test2Func() {
		try {
			scrollToElement(getHomePage().getTest2Div());
			WebElement test2Div = getHomePage().getTest2Div();
			List<WebElement> listgroup = test2Div.findElements(By.tagName("li"));
			Assert.assertTrue(listgroup.size() == 3);
			Assert.assertTrue(getTextNode(listgroup.get(1)).equalsIgnoreCase("List Item 2"));
			WebElement span = listgroup.get(1).findElement(By.tagName("span"));
			Assert.assertTrue(span.getText().equals("6"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test3Func() {
		try {
			scrollToElement(getHomePage().getTest3Div());
			WebElement test3Div = getHomePage().getTest3Div();
			WebElement select = test3Div.findElement(By.id("dropdownMenuButton"));
			String selectedValueInDropDown = select.getText();
			Assert.assertTrue(selectedValueInDropDown.equalsIgnoreCase("Option 1"));
			WebDriver driver = getHomePage().getDriver();
			Actions action = new Actions(driver);
			action.moveToElement(select).click().perform();
			List<WebElement> dropdownItems = driver.findElements(By.cssSelector("a.dropdown-item"));
			action.moveToElement(dropdownItems.get(1)).click().perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test4Func() {
		try {
			scrollToElement(getHomePage().getTest4Div());
			WebElement test4Div = getHomePage().getTest4Div();
			WebElement primaryBtn = test4Div.findElement(By.cssSelector("button.btn-primary"));
			WebElement secondaryBtn = test4Div.findElement(By.cssSelector("button.btn-secondary"));
			Assert.assertTrue(primaryBtn.isEnabled());
			Assert.assertFalse(secondaryBtn.isEnabled());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test5Func() {
		try {
			scrollToElement(getHomePage().getTest5Div());
			WebElement test5Div = getHomePage().getTest5Div();
			WebDriver driver = getHomePage().getDriver();
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test5-button")));
			WebElement alert = test5Div.findElement(By.id("test5-alert"));
			WebElement btn = test5Div.findElement(By.id("test5-button"));
			Actions action = new Actions(driver);
			action.moveToElement(btn).click().perform();
			Assert.assertTrue(alert.isDisplayed());
			Assert.assertFalse(btn.isEnabled());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test6Func() {
		try {
			scrollToElement(getHomePage().getTest6Div());
			WebElement test6Div = getHomePage().getTest6Div();
			WebElement table = test6Div.findElement(By.tagName("table"));
			String text = searchTable(table, 2, 2);
			Assert.assertTrue(text.equalsIgnoreCase("Ventosanzap"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getHomePage().getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTextNode(WebElement e) {
		String text = e.getText().trim();
		List<WebElement> children = e.findElements(By.xpath("./*"));
		for (WebElement child : children) {
			text = text.replaceFirst(child.getText(), "").trim();
		}
		return text;
	}

	public String searchTable(WebElement table_element, int row, int column) {
		List<WebElement> tr_collection = table_element.findElements(By.tagName("tr"));
		tr_collection.remove(0); // remove table head
		assert (row <= (tr_collection.size() - 1));
		assert (column <= (tr_collection.get(0).findElements(By.xpath("td")).size() - 1));

		WebElement trElement = tr_collection.get(row);
		List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
		WebElement tdElement = td_collection.get(column);
		return tdElement.getText();
	}
}
