package Experiment10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TodoApp {

	public static void main(String[] args) throws InterruptedException {
		//Set the path to ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91983\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        
        //String filePath = "file:///C:/Users/91983/OneDrive/Desktop/Web%20Dev/todo-list/index.html";

        // Open the local HTML file containing the todo application
        driver.get("file:///C:/Users/91983/OneDrive/Desktop/Web%20Dev/todo-list/index.html");

        // Find the input field to add a new task
        WebElement taskInput = driver.findElement(By.cssSelector("input[type='text']"));
        taskInput.sendKeys("Complete assignment");

        // Find the input field for the due date
        WebElement dateInput = driver.findElement(By.cssSelector("input.schedule-date"));
        dateInput.sendKeys("30-04-2022"); // Set the due date

        // Find the add task button and click it
        WebElement addButton = driver.findElement(By.cssSelector("button.add-task-button"));
        addButton.click();

        Thread.sleep(5000); // Wait for the task to be added

        // Find the task in the todo list (assuming it's the first row in the table)
        WebElement taskRow = driver.findElement(By.cssSelector("table.table tbody tr:first-child"));

        // Find the status column (third column) of the task
        WebElement statusColumn = taskRow.findElement(By.xpath("./td[3]"));

        // Check the status of the task (pending or completed)
        String status = statusColumn.getText();
        if (status.equals("Pending")) {
            // Click on the task status to change it to completed
            statusColumn.click();
        }

        Thread.sleep(2000); // Wait for the state change to complete

        // Close the browser
        driver.quit();

	}

}
