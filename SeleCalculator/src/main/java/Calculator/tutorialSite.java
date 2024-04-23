package Calculator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class tutorialSite {
	 private static WebDriver driver;
	 private static final int MAX_DEPTH = 5; // Maximum depth level to navigate
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        // Set the path of the ChromeDriver executable
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\91983\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


		        // Create a new instance of the ChromeDriver
		        driver = new ChromeDriver();

		        // Open the FreeCodeCamp website
		        driver.get("https://www.freecodecamp.org/");

		        // Start navigation from the root URL with depth 0
		        navigateToDepth(0);

		        // Close the browser
		        driver.quit();
		    }

		    private static void navigateToDepth(int currentDepth) {
		        if (currentDepth >= MAX_DEPTH) {
		            System.out.println("Maximum depth reached: " + currentDepth);
		            return;
		        }

		        // Find all anchor (link) elements on the current page
		        List<WebElement> links = driver.findElements(By.tagName("a"));

		        for (WebElement link : links) {
		            try {
		                // Click the link to navigate to the next page
		                link.click();

		                // Wait for a short time to allow the new page to load
		                Thread.sleep(1000);

		                // Recursively navigate to the next depth level
		                navigateToDepth(currentDepth + 1);

		                // Navigate back to the previous page (simulate back button press)
		                driver.navigate().back();

		                // Wait for a short time after navigating back
		                Thread.sleep(1000);
		            } catch (Exception e) {
		                // Handle any exceptions that occur during navigation
		                System.out.println("Error occurred: " + e.getMessage());
		            }
		        }	
	}

}
