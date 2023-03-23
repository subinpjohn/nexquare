package io.qa.pages;

import java.security.PublicKey;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qa.base.BaseTest;
import io.qa.utils.Calendar;
import io.qa.utils.PageUtils;
import io.qa.utils.WaitUtility;

public class FeeConfigurationPage extends BaseTest {
	
	public FeeConfigurationPage(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(id="searchInput") 
	WebElement globalStudentsSearch ;
	
	

	
	//--------------------------------------------------
	
    public void enterStudentId(String studentId) throws InterruptedException
    {  
    	PageUtils.sendInput(driver, globalStudentsSearch, studentId);
    	globalStudentsSearch.sendKeys(Keys.ENTER);
    }
    


}
