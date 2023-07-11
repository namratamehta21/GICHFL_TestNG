package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.CIBILAssessmentPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class CIBILAssessmentPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	LoginPage loginPage;
	CIBILAssessmentPage cibilAssessmentPage;
	
	//String sheetName = "login";

	//String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/TestData.xlsx";

	public CIBILAssessmentPageTest() {
		super();
	}

	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException   
	{
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		cibilAssessmentPage = new CIBILAssessmentPage();
		
		loginPage.login(username, password);
	}

	/*@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}*/

	@Test
	public void verifyCIBILDetails() throws InterruptedException
	{
		System.out.println("Inside validateApplicantFamilyDetails method");
	    //loginPage.login(username, password);
	    dashboardPage.searchApplication();
		dashboardPage.editApplication();
		cibilAssessmentPage.VerifyCIBILAssessment();
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}
