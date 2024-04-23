package Experiment10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShwetaUnitConverter {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91983\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        
        //String filePath = "file:///C:/Users/91983/OneDrive/Desktop/Web%20Dev/todo-list/index.html";

        // Open the local HTML file containing the todo application
        driver.get("http://127.0.0.1:5500/index.html");
        
        WebElement amountInput = driver.findElement(By.id("amount"));
        amountInput.sendKeys("5"); // Enter the amount to convert

        // Select 'Meters' as the 'From Unit'
        WebElement fromUnitDropdown = driver.findElement(By.id("fromUnit"));
        fromUnitDropdown.sendKeys("Meters");

        // Select 'Centimeters' as the 'To Unit'
        WebElement toUnitDropdown = driver.findElement(By.id("toUnit"));
        toUnitDropdown.sendKeys("Centimeters");

        // Click the 'Convert' button
        WebElement convertButton = driver.findElement(By.tagName("button"));
        convertButton.click();

        Thread.sleep(2000); // Wait for the conversion to complete

        // Retrieve the result
        WebElement resultDiv = driver.findElement(By.id("result"));
        String resultText = resultDiv.getText();

        // Validate the converted result
        double expectedValue = 500.0; // 5 meters = 500 centimeters
        double actualValue = Double.parseDouble(resultText.split(":")[1].trim().split(" ")[0]);

        if (actualValue == expectedValue) {
            System.out.println("Conversion test passed. Expected: " + expectedValue + " Actual: " + actualValue);
        } else {
            System.out.println("Conversion test failed. Expected: " + expectedValue + " Actual: " + actualValue);
        }

        // Close the browser
        driver.quit();
    }

	
}
