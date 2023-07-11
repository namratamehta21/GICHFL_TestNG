package com.nischay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class DashboardPageTest extends TestBase {

	DashboardPage dashboardPage;
	TestUtil testUtil;
	LoginPage loginPage;
	
	String sheetName = "login";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/TestData.xlsx";

	public DashboardPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		dashboardPage = new DashboardPage();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
	}
	
	@DataProvider
	public Object[][] getTestData() 
	{
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}

	@Test(dataProvider = "getTestData", priority=1)
	public void LandingPageTitle(String username, String password) throws InterruptedException 
	{
		loginPage.login(username, password);	
		String title = dashboardPage.validateDashboardPageTitle();
		Assert.assertEquals(title, "GICHF Loan Application");

		
	}
	
	@Test(dataProvider = "getTestData", priority=2)
	public void verifyPageSize(String username, String password) throws InterruptedException 
	{
		loginPage.login(username, password);
		driver.navigate().refresh();
		Thread.sleep(3000);
		dashboardPage.selectPageSize();
	}

	@Test(dataProvider = "getTestData", priority=3)
	public void editSelectedApplication(String username, String password) throws InterruptedException 
	{
		loginPage.login(username, password);
		driver.navigate().refresh();
		Thread.sleep(3000);
		dashboardPage.searchApplication();
		dashboardPage.editApplication();

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
