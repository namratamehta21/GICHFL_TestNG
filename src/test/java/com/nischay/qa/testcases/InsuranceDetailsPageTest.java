package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.InsuranceDetailsPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class InsuranceDetailsPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	InsuranceDetailsPage insuranceDetailsPage;
	LoginPage loginPage;
		
	String sheetName = "InsuranceDetails";
	 
	String Path = System.getProperty("user.dir") +"/src/main/java/com/nischay/qa/testdata/InsuranceDetails.xlsx";
	 
	public InsuranceDetailsPageTest() 
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
		insuranceDetailsPage = new InsuranceDetailsPage();
		
		loginPage.login(username, password);
	}

	
	 @DataProvider public Object[][] getTestData() 
	 { 
		 Object data[][] = TestUtil.getTestData(sheetName, Path); 
		 return data; 
	 }
	 

	@Test(dataProvider = "getTestData")
	public void selectLifeInsurance(String OptForInsurance, String SelectBirlaInsurance, 
			String SelectKotakInsurance, String NomineeName,
			String NomineeDOB, String NomineeGender, String NomineeRelationship,
			String SelectTataAIG, String TataAIGNomineeName, String TataAIGNomineeDOB, String TataAIGNomineeGender, 
			String TataAIGNomineeRelationship, String PreExistingDisease, String InGoodHealth) throws InterruptedException
	{
		System.out.println("Inside enterIncomeAssessmentDetails method");
	    
	    
	    dashboardPage.searchApplication();
		dashboardPage.editApplication();
		
		insuranceDetailsPage.selectLifeInsurance(OptForInsurance, SelectBirlaInsurance,SelectKotakInsurance,  NomineeName,
				NomineeDOB, NomineeGender, NomineeRelationship,
				SelectTataAIG, TataAIGNomineeName, TataAIGNomineeDOB, TataAIGNomineeGender, TataAIGNomineeRelationship,
				PreExistingDisease, InGoodHealth);
		
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
