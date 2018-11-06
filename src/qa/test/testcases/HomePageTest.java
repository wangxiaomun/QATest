package qa.test.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
	
	@Test
	public void test1Func() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test2Func() {
		try {
			Thread.sleep(3000);
			scrollToElement(getHomePage().getTest2Div());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test3Func() {
		try {
			Thread.sleep(3000);
			scrollToElement(getHomePage().getTest3Div());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test4Func() {
		try {
			Thread.sleep(3000);
			scrollToElement(getHomePage().getTest4Div());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test5Func() {
		try {
			Thread.sleep(3000);
			scrollToElement(getHomePage().getTest5Div());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test6Func() {
		try {
			Thread.sleep(3000);
			scrollToElement(getHomePage().getTest6Div());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getHomePage().getDriver(); 
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
