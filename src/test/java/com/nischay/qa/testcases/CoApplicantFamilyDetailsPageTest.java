package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.CoApplicantFamilyDetailsPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class CoApplicantFamilyDetailsPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	CoApplicantFamilyDetailsPage familyDetailsPage;
	LoginPage loginPage;
	
	String sheetName = "AppFamilyDetails";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/CoApplicantFamilyDetails.xlsx";

	public CoApplicantFamilyDetailsPageTest() {
		super();
	}

	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException  
	{
		initialization();
		dashboardPage = new DashboardPage();
		familyDetailsPage = new CoApplicantFamilyDetailsPage();
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
	public void validateCoApplicantFamilyDetails(String fatherName, String motherName, String spouseName, String emergancyNo, String noOfDependent) throws InterruptedException
	{
		System.out.println("Inside method");
		
		dashboardPage.searchApplication();
		dashboardPage.editApplication();
		familyDetailsPage.enterCoApplicantFamilyDetails(fatherName, motherName, spouseName, emergancyNo, noOfDependent);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
