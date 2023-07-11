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
import com.nischay.qa.pages.LoginFeeDetailsPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class LoginFeeDetailsPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	ApplicantCorrespondenceDetailsPage applicantCorrespondenceDetailsPage;
	LoginFeeDetailsPage loginFeeDetailsPage;
	LoginPage loginPage;
	
	String sheetName = "LoginFeeDetails";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/LoginFeeDetails.xlsx";

	public LoginFeeDetailsPageTest() {
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
		loginFeeDetailsPage = new LoginFeeDetailsPage();
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
	public void validateLoginFeeDetails(String TransactionType, String BankName, 
			String IFSCCode, String ChequeNumber, String ChequeDate) throws InterruptedException
	{
		System.out.println("Inside method");
	    //loginPage.login(username, password);
	    
	    dashboardPage.searchApplication();
		dashboardPage.editApplication();
		Thread.sleep(3000);
		
		if(TransactionType.contains("Cheque"))
		{
			loginFeeDetailsPage.selectChequeDetails(BankName, IFSCCode, ChequeNumber, ChequeDate);
		}
		else if(TransactionType.contains("Cash"))
		{
			System.out.println("Cash is selected");
			loginFeeDetailsPage.selectCashDetails();
		}
		else if(TransactionType.contains("PaymentGateway"))
		{
			System.out.println("Payment Gateway is selected");
			loginFeeDetailsPage.selectCashDetails();
		}
		else
		{
			System.out.println("No option available");
		}
	}
	
	/*@Test(priority = 2)
	public void verifyLoginFeedetails(String chequeNo, String date, String bankName, String amount) throws InterruptedException 
	{
		dashboardPage.editApplication();
		loginFeeDetailsPage.enterLoginFeeDetails(chequeNo, date, bankName, amount);
	}*/


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
