package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.IPSOfferLetter;
import com.nischay.qa.util.TestUtil;

public class IPSOfferLetterTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	IPSOfferLetter ipsOfferLetter;
	
	public IPSOfferLetterTest() 
	{
		super();
	}

	@BeforeMethod
	public void setUp() 
	{
		initialization();
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		ipsOfferLetter = new IPSOfferLetter();
	}

	@Test(priority = 2)
	public void verifyIPSOfferLetterdetails() throws InterruptedException 
	{
		dashboardPage.searchApplication();
		dashboardPage.editApplication();
		ipsOfferLetter.enterIPSOfferLetter();
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
