package in.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.qa.base.BaseTest;
import in.qa.pages.HomePage;
import in.qa.pages.LoginPage;
import in.qa.pages.PersonalDetails;


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
	public void searchProdcut() throws InterruptedException
	{	
		homePage.clickOnAddStaff();
		personalDetails.addStaffWithMandatoryFields("Test", "02-07-1995", "21-03-2023", "test@test.com", "21-03-2023");
	}
}
