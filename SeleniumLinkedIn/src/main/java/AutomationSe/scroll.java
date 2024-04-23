package AutomationSe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class scroll {

	public static void main(String[] args) {
        // Set the path to ChromeDriver executable using the correct format for Windows
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91983\\Downloads\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/scroll");

        WebElement name = driver.findElement(By.id("name"));

        Actions actions = new Actions(driver);
        actions.moveToElement(name).perform(); // Move to the 'name' element

        name.sendKeys("Robin"); // Enter text into the 'name' field

        WebElement date = driver.findElement(By.id("date"));
        date.sendKeys("01/01/2020"); // Enter text into the 'date' field

        // Close the browser
        driver.quit();

	}

}
