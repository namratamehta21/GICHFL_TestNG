package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.CoApplicantCorrespondenceDetailsPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class CoApplicantCorrespondenceDetailsPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	CoApplicantCorrespondenceDetailsPage applicantCorrespondenceDetailsPage;
	LoginPage loginPage;
	
	String sheetName = "AppCorrDetails";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/CoApplicantCorrespondenceDetails.xlsx";

	public CoApplicantCorrespondenceDetailsPageTest() {
		super();
	}


	
	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException  
	{
		initialization();
		dashboardPage = new DashboardPage();
		applicantCorrespondenceDetailsPage = new CoApplicantCorrespondenceDetailsPage();
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
	public void CoapplicantCorrespondenceDetailsPage(String MobileNo, String alternateMobileNo, String landline, String AddressType, String houseNo, 
			String address, String landmark, String locality, String pincode) throws InterruptedException
	{
		System.out.println("Inside CoapplicantCorrespondenceDetailsPage method");
		
		dashboardPage.searchApplication();
		dashboardPage.editApplication();
		applicantCorrespondenceDetailsPage.enterCorrespondenceDetails(MobileNo, alternateMobileNo, landline, AddressType, houseNo, 
				address, landmark, locality, pincode);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
