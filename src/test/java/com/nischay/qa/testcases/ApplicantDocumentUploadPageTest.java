package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.pages.ApplicantDocumentUploadPage;
import com.nischay.qa.util.TestUtil;

public class ApplicantDocumentUploadPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantDocumentUploadPage DocumentUPloadPage;
	LoginPage loginPage;
	
	String sheetName = "login";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/BranchUser.xlsx";
	
	public ApplicantDocumentUploadPageTest() 
	{
		super();
	}

	@BeforeMethod
	public void setUp() 
	{
		initialization();
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		DocumentUPloadPage = new ApplicantDocumentUploadPage();
		loginPage = new LoginPage();
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void DocumentUpload(String username, String password) throws InterruptedException 
	{
		System.out.println("Inside method");
	    loginPage.login(username, password);
		dashboardPage.editApplication();
		DocumentUPloadPage.enterDocumentUploadDetails();
	}

	@AfterMethod public void tearDown() 
	{ 
		  driver.quit(); 
	}
	
}
