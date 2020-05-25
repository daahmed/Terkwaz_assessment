package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HerokuappHomePage {
	private final String URL = "https://the-internet.herokuapp.com/";


	private WebDriver driver;

	public HerokuappHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// navigate to the-internet.herokuapp page
	public void open() {
		driver.get(URL);

		driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param linkName
	 * this method receive the link name
	 * then click on the link
	 */
	public void clickIn(String linkName) {
		
		driver.findElement(By.linkText(linkName)).click();

	}

}
