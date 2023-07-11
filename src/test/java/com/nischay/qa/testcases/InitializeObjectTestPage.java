package com.nischay.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.ApplicantCorrespondenceDetailsPage;
import com.nischay.qa.pages.ApplicantKYCDetailsPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class InitializeObjectTestPage extends TestBase 
{
	TestUtil testUtil;
	DashboardPage dashboardPage;
	LoginPage loginPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	ApplicantCorrespondenceDetailsPage applicantCorrespondenceDetailsPage;
	
	WebDriver driver;
	
	public InitializeObjectTestPage() 
	{
		super();
	}
	
	@BeforeSuite
	public WebDriver init()
	{
		return driver = initialization();
	}
	
	@Parameters({ "username", "password" })
	@BeforeTest
	public void setUp(String username, String password) throws InterruptedException  
	{
		//initialization();
		
		loginPage = new LoginPage();
		loginPage.login(username, password);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}


}
