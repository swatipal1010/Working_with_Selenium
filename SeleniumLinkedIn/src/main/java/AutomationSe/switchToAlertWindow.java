package AutomationSe;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchToAlertWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\91983\\Downloads\\chromedriver-win64\\chromedriver.exe");

	        WebDriver driver = new ChromeDriver();

	        driver.get("https://formy-project.herokuapp.com/switch-window");
	        
	        WebElement alertButton = driver.findElement(By.id("alert-button"));
	        alertButton.click();
	        
	        Alert alert = driver.switchTo().alert();	//to switch the driver focus on open alert
	        alert.accept();    							//In order to press ok and close that alert
	        
	        driver.quit();

	}

}
