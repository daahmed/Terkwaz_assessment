package page;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class webdriverdemo {
	
		
		public static void main(String...args) {
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");

			
			WebDriver driver = new ChromeDriver();

			   driver.get("http://demo.guru99.com/test/ajax.html");
			    List<WebElement> elements = driver.findElements(By.name("name"));
			    System.out.println("Number of elements:" +elements.size());

			    for (int i=0; i<elements.size();i++){
			      System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
			    }
			    
			 // WebElement myDynamicElement = (new WebDriverWait(driver,
				// 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

				
		}


}
