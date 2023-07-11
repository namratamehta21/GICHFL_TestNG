package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.pages.CoApplicantPhotoSignaturePage;
import com.nischay.qa.util.TestUtil;

public class CoApplicantPhotoSignaturePageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	CoApplicantPhotoSignaturePage CophotoSignaturePage;
	LoginPage loginPage;
	
	//String sheetName = "login";

	//String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/BranchUser.xlsx";
	
	public CoApplicantPhotoSignaturePageTest() 
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
		CophotoSignaturePage = new CoApplicantPhotoSignaturePage();
		loginPage = new LoginPage();
		
		loginPage.login(username, password);
	}

	/*@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}*/
	
	@Test
	public void PhotoSignature() throws InterruptedException 
	{
		System.out.println("Inside PhotoSignature method");
	    
	    dashboardPage.searchApplication();
		dashboardPage.editApplication();
		CophotoSignaturePage.enterPhotoSignatureDetails();
	}

	@AfterMethod 
	public void tearDown() 
	{ 
		  driver.quit(); 
	}
	
}
