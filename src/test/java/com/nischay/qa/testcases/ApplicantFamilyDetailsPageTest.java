package com.nischay.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.ApplicantCorrespondenceDetailsPage;
import com.nischay.qa.pages.ApplicantFamilyDetailsPage;
import com.nischay.qa.pages.ApplicantKYCDetailsPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class ApplicantFamilyDetailsPageTest
{

	TestUtil testUtil;
	DashboardPage dashboardPage = new DashboardPage();
	ApplicantKYCDetailsPage applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	ApplicantCorrespondenceDetailsPage applicantCorrespondenceDetailsPage;
	ApplicantFamilyDetailsPage familyDetailsPage = new ApplicantFamilyDetailsPage();
	LoginPage loginPage;
	InitializeObjectTestPage initializeObjectTestPage;
	WebDriver driver;
	
	String sheetName = "AppFamilyDetails";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/ApplicantFamilyDetails.xlsx";

	/*public ApplicantFamilyDetailsPageTest() {
		super();
		//initializeObjectTestPage = new InitializeObjectTestPage();
		//driver = initializeObjectTestPage.init();
	}*/
	

	/*@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException   
	{
		initialization();
		dashboardPage = new DashboardPage();
		applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
		applicantCorrespondenceDetailsPage = new ApplicantCorrespondenceDetailsPage();
		familyDetailsPage = new ApplicantFamilyDetailsPage();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		
		loginPage.login(username, password);
	}*/

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}

	@Test(dataProvider = "getTestData")
	public void validateApplicantFamilyDetails(String fatherName, String motherName, String spouseName, String emergancyContactNo, String noOfDependent) throws InterruptedException
	{
		System.out.println("Inside validateApplicantFamilyDetails method");
	    
	    dashboardPage.searchApplication();
		dashboardPage.editApplication();
		familyDetailsPage.enterFamilyDetails(fatherName, motherName, spouseName, emergancyContactNo, noOfDependent);
	}
	
	/*@Test(priority = 2)
	public void verifyFamilydetails() throws InterruptedException 
	{
		dashboardPage.editApplication();
		familyDetailsPage.enterFamilyDetails();
	}*/


	/*@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}*/


}
