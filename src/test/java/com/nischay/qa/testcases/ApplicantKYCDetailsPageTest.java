package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.ApplicantKYCDetailsPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class ApplicantKYCDetailsPageTest extends TestBase 
{

	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	LoginPage loginPage;
	
	String sheetName = "AppKYCDetails";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/ApplicantKYCDetails.xlsx";
	
	public ApplicantKYCDetailsPageTest() 
	{
		super();
	}

	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException  
	{
		initialization();
		dashboardPage = new DashboardPage();
		applicantKYCDetailsPage= new ApplicantKYCDetailsPage();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		
		loginPage.login(username, password);
	}
	
	@DataProvider
	public Object[][] getTestData() 
	{
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}
	
	@Test(dataProvider = "getTestData")
	public void verifyApplicantKYCdetails(String TestCase, String IncomeConsidered, String FirstName, String MiddleName, String LastName, String DateOfBirth, String Gender, String AadharNo,
			String Occupation, String Citizenship, String Education, String Religion, String MaritalStatus, String Category) throws InterruptedException 
	{
		
	    System.out.println("Inside method");
	    System.out.println("Inside verifyCoApplicantKYCdetails method");
		String tc = TestCase;
		System.out.println("Test Case execution no is : "+tc);
	    
	    dashboardPage.searchApplication();
	    
	    dashboardPage.editApplication();
	    
	    applicantKYCDetailsPage.enterKYCDetails(IncomeConsidered, FirstName, MiddleName, LastName, DateOfBirth, Gender, AadharNo,
				Occupation, Citizenship, Education, Religion, MaritalStatus, Category);
	}


	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}
