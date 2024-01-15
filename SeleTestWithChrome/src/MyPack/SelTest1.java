package MyPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelTest1 {

    public static void main(String[] args) {
        // Set the system property for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver obj = new ChromeDriver();
        obj.manage().window().maximize();
        obj.get("http://www.google.co.in");
    }
}
