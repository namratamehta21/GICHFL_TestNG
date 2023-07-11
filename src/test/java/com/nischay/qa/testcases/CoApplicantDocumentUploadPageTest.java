package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.CoApplicantDocumentUploadPage;
import com.nischay.qa.util.TestUtil;

public class CoApplicantDocumentUploadPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	CoApplicantDocumentUploadPage DocumentUPloadPage;
	
	public CoApplicantDocumentUploadPageTest() 
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
		DocumentUPloadPage = new CoApplicantDocumentUploadPage();
	}

	@Test(priority = 1)
	public void CoApplicantDocumentUpload() throws InterruptedException 
	{
		dashboardPage.searchApplication();
		dashboardPage.editApplication();
		DocumentUPloadPage.enterCoApplicantDocumentUploadDetails();
	}

	@AfterMethod public void tearDown() 
	{ 
		  driver.quit(); 
	}
	
}
