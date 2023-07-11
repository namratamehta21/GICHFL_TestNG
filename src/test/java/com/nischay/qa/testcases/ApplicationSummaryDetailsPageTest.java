package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.ApplicationSummaryDetailsPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class ApplicationSummaryDetailsPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicationSummaryDetailsPage applicationSummaryDetailsPage;
	LoginPage loginPage;
	
	//String sheetName = "login";

	//String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/TestData.xlsx";
	
	public ApplicationSummaryDetailsPageTest() 
	{
		super();
	}

	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException 
	{
		initialization();
		dashboardPage = new DashboardPage();
		applicationSummaryDetailsPage = new ApplicationSummaryDetailsPage();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		
		loginPage.login(username, password);
	}

	/*@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}*/
	
	@Test
	public void validateApplicantSummaryDetails() throws InterruptedException
	{
		System.out.println("Inside Application Summary method");
		//loginPage.login(username, password);
		dashboardPage.searchApplication();
		dashboardPage.editApplication();
		applicationSummaryDetailsPage.verifyApplicationSummaryDetails();
	}
	
	/*@Test(priority = 2)
	public void verifyFamilydetails() throws InterruptedException 
	{
		dashboardPage.editApplication();
		familyDetailsPage.enterFamilyDetails();
	}*/


	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}


}
