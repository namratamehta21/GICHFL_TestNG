package com.nischay.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;


public class LoginPageTest extends TestBase 
{
		TestUtil testUtil = new TestUtil();
	//LoginPage loginPage = new 	LoginPage();
	
	//String sheetName= "login";
	
	//String Path= System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/TestData.xlsx";
	//String Path= "E:/GICHFL/GICAutomation/src/main/java/com/nischay/qa/testdata/TestData.xlsx";

	public LoginPageTest() 
	{
		super();
		
	}
/*
	@BeforeMethod
	public void setUp() 
	{
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		
	}*/

	/*
	 * public void loginPageTitleTest() { String title =
	 * loginPage.validateLoginPageTitle(); Assert.assertEquals(title,
	 * "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"
	 * ); }
	 */

	/*@DataProvider
	public Object[][] getTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}*/
	
	@Parameters({ "username", "password" })
	@Test
	public void validatelogin(String username, String password) throws InterruptedException
	{
		LoginPage loginpage1 = PageFactory.initElements(driver, LoginPage.class);
		System.out.println("Inside login page test");
		String tit = loginpage1.validateLoginPageTitle();
		System.out.println("Title is :"+tit);
	
		System.out.println("Username is : "+username);
		loginpage1.login(username, password);
	}
		
/*
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
*/
}
