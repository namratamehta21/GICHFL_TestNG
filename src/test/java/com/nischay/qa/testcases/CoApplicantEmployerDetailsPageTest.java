package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.CoApplicantEmployerDetailsPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class CoApplicantEmployerDetailsPageTest extends TestBase 
{

	TestUtil testUtil;
	DashboardPage dashboardPage;
	CoApplicantEmployerDetailsPage applicantEmployerDetailsPage;
	LoginPage loginPage;
	
	String sheetName = "AppEmpDetails";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/CoApplicantEmployerDetails.xlsx";

	public CoApplicantEmployerDetailsPageTest() 
	{
		super();
	}

	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException  
	{
		initialization();
		dashboardPage = new DashboardPage();
		applicantEmployerDetailsPage = new CoApplicantEmployerDetailsPage();
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
	public void validateCoApplicantEmployerDetails(String employeeSince, String employerName, String dateOfJoining, String AddressType, 
			String houseNo, 
			String address,
			String landmark, String locality, String pincode) throws InterruptedException
	{
		System.out.println("Inside validateCoApplicantEmployerDetails method");
	   
	    dashboardPage.searchApplication();
		dashboardPage.editApplication();
		applicantEmployerDetailsPage.enterCoApplicantEmployerDetails(employeeSince, employerName, dateOfJoining, AddressType, 
				houseNo, address, landmark, locality, pincode);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
