package Experiment10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

@Test
public class UnitCalculator {
    private WebDriver driver;
    private String baseUrl = "file:///C:/Users/91983/OneDrive/Desktop/Web%20Dev/units/your_file_name.html";

    @BeforeClass
    public void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91983\\Downloads\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait for element presence
        driver.manage().window().maximize(); // Maximize the browser window
        // Open the web page
        driver.get(baseUrl);
    }

    public void testLengthConversionFromMetersToCentimeters() {
        // Find the input field for length amount
        WebElement lengthAmountInput = driver.findElement(By.id("lgthamt"));
        // Clear any existing value in the input field (optional)
        lengthAmountInput.clear();
        // Enter the length value (e.g., 5 meters)
        lengthAmountInput.sendKeys("5");

        // Find the dropdown for selecting 'from' unit (meters)
        Select fromUnitDropdown = new Select(driver.findElement(By.id("lgthfr")));
        // Select 'm' (meters) as the 'from' unit
        fromUnitDropdown.selectByValue("uM");

        // Find the dropdown for selecting 'to' unit (centimeters)
        Select toUnitDropdown = new Select(driver.findElement(By.id("lgthto")));
        // Select 'cm' (centimeters) as the 'to' unit
        toUnitDropdown.selectByValue("uCm");

        // Find the 'convert' button and click it
        WebElement convertButton = driver.findElement(By.id("lgthBtn"));
        convertButton.click();

        // Explicit wait for the result to be visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        // Retrieve the converted value from the result section
        WebElement resultDiv = driver.findElement(By.id("result"));
        String convertedResult = resultDiv.getText();

        // Validate the converted result
        double expectedValue = 500.0; // 5 meters = 500 centimeters
        double actualValue = Double.parseDouble(convertedResult.trim());

        // Assert the expected and actual values with a delta for precision
        Assert.assertEquals(actualValue, expectedValue, 0.01, "Length conversion result is not as expected");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
