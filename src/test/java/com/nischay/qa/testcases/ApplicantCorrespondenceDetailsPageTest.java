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
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class ApplicantCorrespondenceDetailsPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	LoginPage loginPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	ApplicantCorrespondenceDetailsPage applicantCorrespondenceDetailsPage;
	
	String sheetName = "AppCorrDetails";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/ApplicantCorrespondenceDetails.xlsx";

	public ApplicantCorrespondenceDetailsPageTest() {
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
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		loginPage.login(username, password);
	}

	
	/*@Test(priority = 2)
	public void verifyCorrespondencedetails() throws InterruptedException 
	{
		dashboardPage.editApplication();
		applicantCorrespondenceDetailsPage.enterCorrespondenceDetails();
	}*/

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}

	@Test(dataProvider = "getTestData")
	public void applicantCorrespondenceDetailsPage(String CountryCode, String MobileNo, String AlternateMobileNo, String Landline, String EmailId,
			String AddressType, String HouseNo, String Address, String Landmark, String Locality, String Pincode, String CorrAddr) throws InterruptedException
	{
		
		dashboardPage.searchApplication();
		
		dashboardPage.editApplication();
		applicantCorrespondenceDetailsPage.enterCorrespondenceDetails(CountryCode, MobileNo, AlternateMobileNo, Landline, EmailId,
				AddressType, HouseNo, Address, Landmark, Locality, Pincode, CorrAddr);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
