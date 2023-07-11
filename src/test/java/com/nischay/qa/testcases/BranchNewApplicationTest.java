package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.BranchNewApplication;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class BranchNewApplicationTest extends TestBase {

	DashboardPage dashboardPage;
	TestUtil testUtil;
	BranchNewApplication branchNewApplication;
	LoginPage loginPage;
	
	String sheetName = "newApplicant";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/NewApplicantKYCDetails.xlsx";

	public BranchNewApplicationTest() {
		super();
	}

	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException  
	{
		initialization();
		dashboardPage = new DashboardPage();
		testUtil = new TestUtil();
		branchNewApplication = new BranchNewApplication();
		loginPage = new LoginPage();
		
		loginPage.login(username, password);	
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}

	@Test(dataProvider = "getTestData")
	public void CreateNewApplication(String PanNo
			/*String FirstName, String LastName, String DateOfBirth, String AadharNo*/
			
			) throws InterruptedException
	{
		//loginPage.login(username, password);
		branchNewApplication.enterNewPanNo(PanNo);
		//branchNewApplication.createNewApplication(FirstName, LastName, DateOfBirth, AadharNo);
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
