package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.IncomeAssessmentEditIncomePage;
import com.nischay.qa.pages.IncomeAssessmentIncomeSummaryPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class IncomeAssessmentIncomeSummaryPageTest extends TestBase 
{
	TestUtil testUtil;
	DashboardPage dashboardPage;
	IncomeAssessmentIncomeSummaryPage incomeAssessmentIncomeSummaryPage;
	LoginPage loginPage;
		
	String sheetName = "IncomeSummary";
	 
	String Path = System.getProperty("user.dir") +"/src/main/java/com/nischay/qa/testdata/IncomeSummary.xlsx";
	 
	public IncomeAssessmentIncomeSummaryPageTest() 
	{
		super();
	}

	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException  
	{
		initialization();
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		loginPage = new LoginPage();
		incomeAssessmentIncomeSummaryPage = new IncomeAssessmentIncomeSummaryPage();
		
		loginPage.login(username, password);	
	}
	
	 @DataProvider public Object[][] getTestData() 
	 { 
		 Object data[][] = TestUtil.getTestData(sheetName, Path); 
		 return data; 
	 }

	@Test(dataProvider = "getTestData")
	public void incomeSummaryDetails(String AverageSalaryOfTotalIncome, String AverageSalaryOfPrimaryApplicant,
			String GrossMonthlyIncomeofTotalIncome, String GrossMonthlyIncomeofPrimaryApplicant) throws InterruptedException
	{
		System.out.println("Inside IncomeSummary method");
	    //loginPage.login(username, password);
	    
	    dashboardPage.searchApplication();
		dashboardPage.editApplication();
		
		incomeAssessmentIncomeSummaryPage.IncomeSummaryDetails(AverageSalaryOfTotalIncome, AverageSalaryOfPrimaryApplicant,
				GrossMonthlyIncomeofTotalIncome,  GrossMonthlyIncomeofPrimaryApplicant);
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
}
