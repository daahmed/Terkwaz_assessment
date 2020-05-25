package page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object for google search result
 */
public class GoogleResultPage {

	private By searchResults = By.xpath("//*[@id=\"rso\"]/div");

	WebDriver driver;

	public GoogleResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public String pageTitle() {
		return driver.getTitle();

	}

	// Check that the third result text contains "What is Selenium WebDriver?"
	public boolean checkSearchResult() {

		List<WebElement> searchResultElements = driver.findElements(searchResults);

		for (int item = 1; item <= searchResultElements.size(); item++) {
			// check the item number three
			if (item == 7) {

				try {

					if (driver.findElement(By.xpath("//*[@id=\"rso\"]/div[" + (item) + "]/div/div[1]/a/h3")).getText()
							.toString().contains("What is Selenium WebDriver?")) {

						return true;
					}

				} catch (NoSuchElementException e) {
					System.out.println("the element not found");
				}
			}
		} // end of for loop

		return false;
	}

}
