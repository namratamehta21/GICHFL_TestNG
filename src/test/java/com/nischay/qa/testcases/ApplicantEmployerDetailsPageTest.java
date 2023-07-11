package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.ApplicantEmployerDetailsPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class ApplicantEmployerDetailsPageTest extends TestBase 
{

	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantEmployerDetailsPage applicantEmployerDetailsPage;
	LoginPage loginPage;
	
	String sheetName = "AppEmpDetails";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/ApplicantEmployerDetails.xlsx";

	public ApplicantEmployerDetailsPageTest() 
	{
		super();
	}

	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException 
	{
		initialization();
		dashboardPage = new DashboardPage();
		applicantEmployerDetailsPage = new ApplicantEmployerDetailsPage();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		
		loginPage.login(username, password);
	}

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}

	@Test(dataProvider = "getTestData")
	public void validateApplicantEmployerDetails(String SalariedSince, String employerName, String dateOfJoining, String AddressType, String address) throws InterruptedException
	{
		System.out.println("Inside validateApplicantEmployerDetails method");
		
		dashboardPage.searchApplication();
		dashboardPage.editApplication();
		applicantEmployerDetailsPage.enterEmployerDetails(SalariedSince, employerName, dateOfJoining, AddressType, address);
	}
	
	/*@Test(priority = 2)
	public void verifyCorrespondencedetails() throws InterruptedException 
	{
		dashboardPage.editApplication();
		applicantEmployerDetailsPage.enterEmployerDetails();
	}*/


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
