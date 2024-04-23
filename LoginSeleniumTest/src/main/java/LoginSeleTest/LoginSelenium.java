import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginSelenium {
    private WebDriver driver;
    private String baseUrl = "file:///C:/Users/91983/OneDrive/Desktop/SEM6/Test Automation Experiments/login.html";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                { "user1", "password1", "Login successful" },
                { "user1", "wrongpassword", "Incorrect password" },
                { "nonexistentuser", "password", "User does not exist" }
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String expectedMessage) throws InterruptedException {
        // Find the username, password, and submit button elements
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        // Enter username
        usernameInput.sendKeys(username);
        Thread.sleep(1000); // Wait for 1 second

        // Enter password
        passwordInput.sendKeys(password);
        Thread.sleep(1000); // Wait for 1 second

        // Click on the submit button
        submitButton.click();

        // Wait for the message element to be displayed
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        // Find the message element and assert the text
        WebElement messageElement = driver.findElement(By.id("message"));
        Assert.assertEquals(messageElement.getText(), expectedMessage);

        // Clear username and password fields for the next iteration
        usernameInput.clear();
        passwordInput.clear();
    }


    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
