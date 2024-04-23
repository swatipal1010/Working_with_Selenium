package AutomationSe;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Workflow {

	public static void main(String[] args) {
		//Set the path to ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91983\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		// Create a new instance of the ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://formy-project.herokuapp.com/form");
		
		FormPage formpage = new FormPage();
		formpage.submitForm(driver);
		
		ConfirmationPage confirmpage = new ConfirmationPage();
		confirmpage.waitForAlertBanner(driver);
		
		
		assertEquals("The form was successfully submitted!", confirmpage.getAlertBannerText(driver));
		
		driver.quit();

	}

	
}
