package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.BRESummaryDetailsPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.util.TestUtil;

public class BRESummaryDetailsPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	BRESummaryDetailsPage bRESummaryDetailsPage;
	
	String sheetName = "BRESummary";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/BRESummary.xlsx";

	public BRESummaryDetailsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		dashboardPage = new DashboardPage();
		bRESummaryDetailsPage = new BRESummaryDetailsPage();
		testUtil = new TestUtil();
	}

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}

	@Test(dataProvider = "getTestData")
	public void verifyBRESummaryDetails(String LoanRequested, String InPrincipleSanctionedAmount, String Tenure, 
			String ROI, String EMI, String FOIR) throws InterruptedException
	{
		dashboardPage.searchApplication();
		dashboardPage.editApplication();
		bRESummaryDetailsPage.verifyBRESummaryDetails(LoanRequested, InPrincipleSanctionedAmount, Tenure, ROI, EMI, FOIR);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
