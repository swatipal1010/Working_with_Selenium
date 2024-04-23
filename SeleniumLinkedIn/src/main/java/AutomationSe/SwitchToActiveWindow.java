package AutomationSe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToActiveWindow {

	public static void main(String[] args) {
		// Set the path to ChromeDriver executable using the correct format for Windows
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91983\\Downloads\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/switch-window");
        
        WebElement newTabElement = driver.findElement(By.id("new-tab-button"));
        newTabElement.click();
        
        String originalHandle = driver.getWindowHandle();
        
        for(String handle1: driver.getWindowHandles()) {
        	driver.switchTo().window(handle1);
        }
        
        driver.switchTo().window(originalHandle);
        driver.quit();
	}

}
