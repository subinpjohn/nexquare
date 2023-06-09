package io.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qa.base.BaseTest;
import io.qa.utils.PageUtils;
import io.qa.utils.WaitUtility;

public class HomePage extends BaseTest {

	public HomePage(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="hr") 
	WebElement staffProfileManagement;
	
	@FindBy(id="link_addStaff") 
	WebElement addStaff;
	
	@FindBy(id="wallet_config active") 
	WebElement feeConfiguration ;

	//--------------------------------------------------
	
    public void clickOnAddStaff()
    {  
    	PageUtils.clickele(driver,staffProfileManagement);
    	PageUtils.clickele(driver,addStaff);
    	
    }
    
    public void clickOnFeeConfiguration() throws InterruptedException
    {  
    	Thread.sleep(5000);
    	PageUtils.clickele(driver,feeConfiguration);
    	
    }
    
}
