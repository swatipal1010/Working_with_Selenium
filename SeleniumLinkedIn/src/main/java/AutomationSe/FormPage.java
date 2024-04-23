package AutomationSe;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class FormPage {

	public static void main(String[] args) {
		driver.findElement(By.id("first-name")).sendKeys("John");
		driver.findElement(By.id("last-name")).sendKeys("Doe");
		
		driver.findElement(By.id("job-title")).sendKeys("QA Engineer");
		
		driver.findElement(By.id("radio-button-2")).click();
		
		driver.findElement(By.id("checkbox-2")).click();
		
		driver.findElement(By.cssSelector("option[value='1']")).click();
		
		driver.findElement(By.id("datepicker")).sendKeys("05/20/2023");
		driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);			//To close the datepicker
		
		driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();

	}

}
