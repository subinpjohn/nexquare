package io.qa.testcases;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qa.base.BaseTest;
import io.qa.pages.FeeConfigurationPage;
import io.qa.pages.HomePage;
import io.qa.pages.LoginPage;
import io.qa.pages.PersonalDetails;
import io.qa.utils.ExcelCode;


public class TestCase extends BaseTest{

	LoginPage loginPage;
	HomePage homePage;
	PersonalDetails personalDetails;
	FeeConfigurationPage feeConfigurationPage;

	@BeforeClass
	public void beforeClass() throws InterruptedException
	{
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		personalDetails=new PersonalDetails(driver);
		feeConfigurationPage=new FeeConfigurationPage(driver);
		loginPage.login("S0075", "Abc!@1");
	}

	@Test(priority = 1)
	public void addStaffTestWithMandaoryDetails() throws InterruptedException, IOException
	{	
		homePage.clickOnAddStaff();
		UUID uuid = UUID.randomUUID();
		String fullNameString=ExcelCode.readStringData(1, 0, "PersonalDetails");
		String dob=ExcelCode.readStringData(1, 1, "PersonalDetails");
		String jDate=ExcelCode.readStringData(1, 2, "PersonalDetails");
		String email=ExcelCode.readStringData(1, 3, "PersonalDetails")+uuid+"@test.com";
		String salStartDate=ExcelCode.readStringData(1, 4, "PersonalDetails");
		
		personalDetails.addStaffWithMandatoryFields(fullNameString, dob, jDate, email, salStartDate);
		Assert.assertTrue(personalDetails.satffHealthDetails());
	}
	
	@Test(priority = 2)
	public void addStaffTestWithoutMandatoryDetails() throws InterruptedException, IOException
	{	
		homePage.clickOnAddStaff();
		UUID uuid = UUID.randomUUID();
		String fullNameString=ExcelCode.readStringData(1, 0, "PersonalDetails");
		String dob=ExcelCode.readStringData(1, 1, "PersonalDetails");
		String jDate=ExcelCode.readStringData(1, 2, "PersonalDetails");
		String email=ExcelCode.readStringData(1, 3, "PersonalDetails")+uuid+"@test.com";
			
		personalDetails.addStaffWithMandatoryFields(fullNameString, dob, jDate, email, "");
		Assert.assertEquals(personalDetails.salErrorMessage(),"The salary start date is required and can't be empty");
	}
	
	@Test(priority = 3)
	public void feeCollection() throws InterruptedException, IOException
	{	
	   // driver.navigate().refresh();
		homePage.clickOnFeeConfiguration();
		feeConfigurationPage.enterStudentId("200011312");	
		
	}
	
}
