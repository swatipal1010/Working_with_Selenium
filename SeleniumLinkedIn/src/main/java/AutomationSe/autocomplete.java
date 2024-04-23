package AutomationSe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class autocomplete {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91983\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://developers.google.com/maps/documentation/javascript/examples/places-autocomplete-addressform");
  
        WebElement autocomplete = driver.findElement(By.xpath("//*[@id='ship-address']"));

        // Clear any existing text (optional)
        autocomplete.clear();

        // Send keys to the autocomplete input field
        autocomplete.sendKeys("Newbury St");

        Thread.sleep(5000); // Sleep to observe the filled value


        // Close the browser
        driver.quit();

	}

}
