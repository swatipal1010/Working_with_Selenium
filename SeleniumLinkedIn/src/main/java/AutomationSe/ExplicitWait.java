package AutomationSe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91983\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://developers.google.com/maps/documentation/javascript/examples/places-autocomplete-addressform");
  
        
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement autocomplete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pac-target-input")));

        // Clear any existing text (optional)
        autocomplete.clear();

        // Send keys to the autocomplete input field
        autocomplete.sendKeys("Newbury St");

        //Thread.sleep(5000); // Sleep to observe the filled value


        // Close the browser
        driver.quit();
	}

}
