package Calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorSele {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to your ChromeDriver executable
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\91983\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the calculator HTML page
            driver.get("file:///C:/Users/91983/OneDrive/Desktop/Web%20Dev/Registration-form/Calculator/calc.html");

            // Find the input fields and result element using WebDriver
            WebElement num1Input = driver.findElement(By.id("num1"));
            WebElement num2Input = driver.findElement(By.id("num2"));
            WebElement resultElement = driver.findElement(By.id("result"));

            // Test Addition
            num1Input.sendKeys("5");
            num2Input.sendKeys("10");
            driver.findElement(By.xpath("//button[text()='+']")).click();

            // Wait for the result to be updated
            Thread.sleep(1000); // You can adjust the wait time as needed

            // Get the displayed result from the output paragraph
            String displayedResult = resultElement.getText();

            // Check if the displayed result matches the expected result
            if (displayedResult.contains("Result: 15")) {
                System.out.println("Test Addition Passed! Output is correct: " + displayedResult);
            } else {
                System.out.println("Test Addition Failed! Expected output: Result: 15, Actual output: " + displayedResult);
            }

        } finally {
            // Close the WebDriver session
            //driver.quit();
        }
    }
}
