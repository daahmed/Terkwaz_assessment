package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for google home page https://www.google.com/ncr.
 */
public class GoogleHomePage {

	private final String URL = "https://www.google.com/ncr";
	private By searchKeywordField = By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input");
	private By searchButton = By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]");

	WebDriver driver;

	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// navigate to google.com
	public void open() {

		driver.get(URL);

		driver.manage().window().maximize();

	}

	// insert search keyword into search text field
	public void setSearchKeyword(String strKeyword) {

		driver.findElement(searchKeywordField).sendKeys(strKeyword);

	}

	// click on search button to get search result in search result page
	public void clickOnSearchButton() {

		driver.findElement(searchButton).click();

	}

}
