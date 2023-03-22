package in.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.qa.base.BaseTest;
import in.qa.utils.PageUtils;
import in.qa.utils.WaitUtility;

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
	
    public void clickOnAddStaff()
    {  
    	PageUtils.clickele(driver,staffProfileManagement);
    	PageUtils.clickele(driver,addStaff);
    	
    }
    
}
