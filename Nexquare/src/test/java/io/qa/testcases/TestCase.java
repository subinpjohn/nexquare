package io.qa.testcases;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qa.base.BaseTest;
import io.qa.pages.HomePage;
import io.qa.pages.LoginPage;
import io.qa.pages.PersonalDetails;
import io.qa.utils.ExcelCode;


public class TestCase extends BaseTest{

	LoginPage loginPage;
	HomePage homePage;
	PersonalDetails personalDetails;

	@BeforeClass
	public void beforeMethod() throws InterruptedException
	{
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		personalDetails=new PersonalDetails(driver);
		loginPage.login("S0075", "Abc!@1");
	}

	@Test
	public void addStaff() throws InterruptedException, IOException
	{	
		homePage.clickOnAddStaff();
		String fullNameString=ExcelCode.readStringData(1, 0, "PersonalDetails");
		String dob=ExcelCode.readStringData(1, 1, "PersonalDetails");
		String jDate=ExcelCode.readStringData(1, 2, "PersonalDetails");
		String email=ExcelCode.readStringData(1, 3, "PersonalDetails");
		String salStartDate=ExcelCode.readStringData(1, 4, "PersonalDetails");
		
		personalDetails.addStaffWithMandatoryFields(fullNameString, dob, jDate, email, salStartDate);
		Assert.assertTrue(personalDetails.satffHealthDetails());
	}
}
