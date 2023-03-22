package io.qa.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.qa.base.BaseTest;

public class PageUtils extends BaseTest{


	public static void sendInput(WebDriver driver,WebElement ele,String input)
	{
		WaitUtility.waitForEle(driver, ele);
		ele.clear();
		ele.sendKeys(input);
	}

	public static void clickele(WebDriver driver,WebElement ele)
	{
		WaitUtility.waitForElementToBeClickable(driver,ele);
		ele.click();
	}

	public static void selectCheckBox(WebElement ele)
	{
		if(!ele.isSelected())
		{
			ele.click();
		}
	}

	public static void drp(WebElement ele,String text)
	{
		Select select=new Select(ele);
		select.selectByVisibleText(text);
	}

	public static String getText(WebElement ele)
	{
		String text=ele.getText();	
		return text;
	}

	public static void scrollTillEle(WebDriver driver, WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}


	public static boolean isDisplayed(WebDriver driver,WebElement ele)
	{
		WaitUtility.waitForElementToBeClickable(driver,ele);	
		return PageUtils.isDisplayed(driver, ele);
	}


}
