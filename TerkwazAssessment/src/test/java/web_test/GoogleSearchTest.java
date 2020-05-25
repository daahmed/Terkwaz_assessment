package web_test;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.GoogleHomePage;
import page.GoogleResultPage;

public class GoogleSearchTest {

	String driverPath = "D:\\chromedriver.exe";
	private static WebDriver driver;
	GoogleResultPage googleResultPage;
	GoogleHomePage googleHomePage;

	/**
	 * initialization web driver
	 */
	@BeforeClass
	public static void BrowserOpen() {

		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	/**
	 * This test open browser then go to https://google.com Search for "selenium
	 * webdriver" click in google search button finally Check that the third result
	 * text contains "What is Selenium WebDriver?"
	 */
	@Test
	public void searchByKeyword() {
		googleHomePage = new GoogleHomePage(driver);
		googleResultPage = new GoogleResultPage(driver);

		googleHomePage.open();

		googleHomePage.setSearchKeyword("selenium webdriver");
		googleHomePage.clickOnSearchButton();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Check that the third result text contains "What is Selenium WebDriver?"
		Assert.assertTrue(googleResultPage.checkSearchResult());

	}

	@AfterClass
	public static void BrowserClose() {
		 driver.close();
	}

}
