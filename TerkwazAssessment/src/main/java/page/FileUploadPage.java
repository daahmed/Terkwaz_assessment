package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

	private By fileUploadButton = By.id("file-upload");
	private By uploadButton = By.id("file-submit");
	private By uploadedImageName = By.id("uploaded-files");
	private By pageName = By.xpath("/html/body/div[2]/div/div/h3");

	private WebDriver driver;

	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
	}

	// enter the file path onto the file-selection input field
	public void fileSelect() {

		// WebElement uploadElement = driver.findElement(fileUploadButton);
		// uploadElement.sendKeys("‪D:\\a.jpg");

		driver.findElement(fileUploadButton).sendKeys("c:\\a.png");

	}

	// click the "UploadFile" button
	public void uploadFile() {
		driver.findElement(uploadButton).click();

	}

	public boolean checkUploadedFile() {

		try {
			if (driver.findElement(pageName).getText().toString().equals("File Uploaded!")) {
				if (driver.findElement(uploadedImageName).getText().toString().equals("a.png")) 
				return true;
			}

		} catch (NoSuchElementException e) {
			System.out.println("the element not found");
		}

		return false;
	}

}
