package io.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qa.base.BaseTest;
import io.qa.utils.PageUtils;
import io.qa.utils.WaitUtility;

public class LoginPage extends BaseTest{

	public LoginPage(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtuser") 
	WebElement userName;

	@FindBy(id="txtpassword") 
	WebElement passwordField;
	
	@FindBy(id="log-btn") 
	WebElement loginBtn;
	



	public void login(String username,String password) throws InterruptedException
	{
		PageUtils.sendInput(driver, userName, username);
		PageUtils.sendInput(driver, passwordField, password);
	    PageUtils.clickele(driver,loginBtn);
	    Thread.sleep(5000);
	}



}
