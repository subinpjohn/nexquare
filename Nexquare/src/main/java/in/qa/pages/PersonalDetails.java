package in.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.qa.base.BaseTest;
import in.qa.utils.Calendar;
import in.qa.utils.PageUtils;
import in.qa.utils.WaitUtility;

public class PersonalDetails extends BaseTest {
	
	public PersonalDetails(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(id="staffFullName") 
	WebElement staffFullName;
	
	@FindBy(xpath="//label[text()='User Type']//following-sibling::div[@class='select-wrapper']") 
	WebElement userTypeDrp;
	
	@FindBy(xpath="//span[text()='Employee Staff ']//parent::li") 
	WebElement employeeStaff;
	
	@FindBy(id="dob") 
	WebElement dobField;
	
	@FindBy(id="joinDate") 
	WebElement joinDate;
	
	@FindBy(id="email") 
	WebElement pEmail;
	
	@FindBy(id="salaryStartDate") 
	WebElement salaryStartDate;
	
	@FindBy(id="submitButton") 
	WebElement submitButton;
	
	//-----------------------------
	
    public void addStaffWithMandatoryFields(String fullName,String dob,String jDate,String email,String salStartDate)
    {  
    	PageUtils.sendInput(driver, staffFullName, fullName);
    	PageUtils.clickele(driver,userTypeDrp);
    	PageUtils.clickele(driver,employeeStaff);
    	PageUtils.clickele(driver, dobField);
    	Calendar.selectDate(driver, dob);
    	PageUtils.clickele(driver, joinDate);
    	Calendar.selectDate(driver, jDate);
    	PageUtils.sendInput(driver, joinDate, jDate);
    	PageUtils.sendInput(driver, pEmail, email);
    	PageUtils.clickele(driver, salaryStartDate);
    	Calendar.selectDate(driver, salStartDate);
    	PageUtils.clickele(driver,submitButton);
    }
    
  

}
