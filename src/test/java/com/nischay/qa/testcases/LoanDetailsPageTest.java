package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.ApplicantCorrespondenceDetailsPage;
import com.nischay.qa.pages.ApplicantKYCDetailsPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoanDetailsPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class LoanDetailsPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	ApplicantCorrespondenceDetailsPage applicantCorrespondenceDetailsPage;
	LoanDetailsPage loanDetailsPage;
	LoginPage loginPage;

	String sheetName = "loanDetails";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/LoanDetails.xlsx";

	public LoanDetailsPageTest() 
	{
		super();
	}

	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException 
	{
		initialization();
		dashboardPage = new DashboardPage();
		applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
		applicantCorrespondenceDetailsPage = new ApplicantCorrespondenceDetailsPage();
		loanDetailsPage = new LoanDetailsPage();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		
		loginPage.login(username, password);	
	}

	/*
	 * @Test(priority = 1) public void verifyCorrespondencedetails() throws
	 * InterruptedException { dashboardPage.editApplication();
	 * loanDetailsPage.enterLoanDetails(); }
	 */

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}

	@Test(dataProvider = "getTestData")
	public void validateLoanDetails( String LoanAmount, String lTenure, String Product, String SubProduct, String Scheme) throws InterruptedException
	{
		System.out.println("Inside method");
	    //loginPage.login(username, password);
	    
	    dashboardPage.searchApplication();
		dashboardPage.editApplication();
		
		loanDetailsPage.enterLoanDetails(LoanAmount, lTenure, Product, SubProduct, Scheme);
	}

	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}

}
