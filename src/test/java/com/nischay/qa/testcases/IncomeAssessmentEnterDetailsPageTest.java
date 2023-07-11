package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.IncomeAssessmentEnterDetailsPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class IncomeAssessmentEnterDetailsPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	IncomeAssessmentEnterDetailsPage incomeAssessmentPage;
	LoginPage loginPage;
		
	String sheetName = "IncomeAssessment";
	 
	String Path = System.getProperty("user.dir") +"/src/main/java/com/nischay/qa/testdata/IncomeAssessment.xlsx";
	 
	public IncomeAssessmentEnterDetailsPageTest() 
	{
		super();
	}

	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException   
	{
		initialization();
		dashboardPage = new DashboardPage();
		loginPage = new LoginPage();
		incomeAssessmentPage = new IncomeAssessmentEnterDetailsPage();
		
		loginPage.login(username, password);
	}

	
	 @DataProvider public Object[][] getTestData() 
	 { 
		 Object data[][] = TestUtil.getTestData(sheetName, Path); 
		 return data; 
	 }
	 

	@Test(dataProvider = "getTestData")
	public void enterIncomeAssessmentDetails(
			String UploadType, String UploadTypeForCoApp1, String UploadTypeForCoApp2, String UploadTypeForCoApp3) throws InterruptedException
	{
		System.out.println("Inside enterIncomeAssessmentDetails method");
	    //loginPage.login(username, password);
	    dashboardPage.searchApplication();
		dashboardPage.editApplication();
		
		incomeAssessmentPage.enterDetailsInIncomeAssessment(UploadType, UploadTypeForCoApp1, UploadTypeForCoApp2, UploadTypeForCoApp3);
		
		/*if(UploadType.contains("Generate Link"))
		{
			System.out.println("Generate link selected");
			incomeAssessmentPage.generateLink();
		}
		else if(UploadType.contains("Upload Scanned Statement "))
		{
			System.out.println("Upload Scanned selected");
			incomeAssessmentPage.uploadScannedStatement();
		}
		else if(UploadType.contains("Upload E-Statement"))
		{
			System.out.println("Upload E-statement selected");
			incomeAssessmentPage.uploadEStatement();
		}
		else
		{
			System.out.println("No option available");
		}*/
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}


}
