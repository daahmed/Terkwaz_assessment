package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object for dynamic loading page
 * https://the-internet.herokuapp.com/dynamic_loading
 */
public class DynamicLoadingPage {

	private By example2Link = By.xpath("//a[@href='/dynamic_loading/2']");
	private By startButton = By.xpath("//*[@id=\"start\"]/button");
	private By finishText = By.id("finish");

	private WebDriver driver;

	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnExample2() {
		driver.findElement(example2Link).click();
	}

	public void clickOnStart() {
		driver.findElement(startButton).click();
	}

	public void waitForLoading() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(finishText));

	}

	public boolean checkTheDispalyedText() {

		if (driver.findElement(finishText).getText().toString().equals("Hello World!"))
			return true;
		else
			return false;

	}

}
