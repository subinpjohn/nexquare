package io.qa.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

	public static void selectDate(WebDriver driver,String desiredDate) throws InterruptedException {
		
	
		String[] dateComponents = desiredDate.split("-");
		int day = Integer.parseInt(dateComponents[0]);
		String month =dateComponents[1];
		String year = dateComponents[2];
		Thread.sleep(500);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		//wait.until(ExpectedConditions.elementToBeClickable ((target)));
    
     Select selectMonth=new Select(driver.findElement(By.xpath("//select[@data-handler='selectMonth']")));
     selectMonth.selectByVisibleText(month);
     Select selectYear=new Select(driver.findElement(By.xpath("//select[@data-handler='selectYear']")));
     selectYear.selectByVisibleText(year);
     Thread.sleep(500);
     driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='"+day+"']")).click();
	}
}
