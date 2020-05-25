package web_test;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.FileUploadPage;
import page.HerokuappHomePage;

public class FileUploadTest {

	String driverPath = "D:\\chromedriver.exe";
	private static WebDriver driver;

	private HerokuappHomePage herokuappHomePage;
	private FileUploadPage fileUploadPage;

	/*
	 * initialization web driver
	 */
	@BeforeClass
	public static void setUp() {

		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	/*
	 * navigate to home page then click on file upload link
	 */
	@Test
	public void clickOnFileUpoladLinke() {
		herokuappHomePage = new HerokuappHomePage(driver);

		herokuappHomePage.open();
		herokuappHomePage.clickIn("File Upload");
	}

	/*
	 * select file from local device then upload file
	 * then Check that the file has been uploaded successfully
	 */
	@Test
	public void uploadFile() {
		fileUploadPage = new FileUploadPage(driver);

		fileUploadPage.fileSelect();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileUploadPage.uploadFile();
		
		//Check that the file has been uploaded successfully
		Assert.assertTrue(fileUploadPage.checkUploadedFile());

	}


	@AfterClass
	public static void BrowserClose() {
		driver.close();
	}

}
