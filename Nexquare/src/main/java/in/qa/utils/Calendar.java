package in.qa.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

	public static void selectDate(WebDriver driver,String desiredDate) {
		
		// Assuming you have already navigated to the webpage with the calendar
		// and located the calendar element using Selenium

		// Replace "desiredDate" with the date you want to select in the format "dd/mm/yyyy"
		

		// Split the desired date into day, month, and year components
		String[] dateComponents = desiredDate.split("/");
		int day = Integer.parseInt(dateComponents[0]);
		int month = Integer.parseInt(dateComponents[1]);
		int year = Integer.parseInt(dateComponents[2]);
	

		// Wait for the calendar to load and become clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='day' and text()='" + day + "']")));

		// Select the desired day
		driver.findElement(By.xpath("//td[@class='day' and text()='" + day + "']"))
		        .click();

		// Select the desired month
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='datepicker-months']")));
		driver.findElement(By.xpath("//span[@class='month' and text()='" + month + "']"))
		        .click();

		// Select the desired year
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='datepicker-years']")));
		driver.findElement(By.xpath("//span[@class='year' and text()='" + year + "']"))
		        .click();

	}
}
