package com.nischay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.PropertyDetailsPage;
import com.nischay.qa.util.TestUtil;

public class PropertyDetailsPageTest extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	PropertyDetailsPage propertyDetailsPage;
	
	String sheetName = "PropertyDetails";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/PropertyDetails.xlsx";
	
	public PropertyDetailsPageTest() 
	{
		super();
	}

	@BeforeMethod
	public void setUp() 
	{
		initialization();
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		propertyDetailsPage = new PropertyDetailsPage();
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}

	@Test(dataProvider = "getTestData")
	public void verifyPropertyDdetails(String PlotArea, String BuiltUpArea, String SuperBuiltUpArea, String ReraId,
			String CarpetArea, String SecondSale, String ValueOfProperty, String MorgageType, String UnderConstructionOrNot,
			String HouseNo, String Address, String Landmark, String Locality,
			String Pincode, String Taluka, String SellerName, String Address1) throws InterruptedException 
	{
		dashboardPage.searchApplication();
		dashboardPage.editApplication();
		propertyDetailsPage.enterPropertyDetails(PlotArea, BuiltUpArea, SuperBuiltUpArea, ReraId,
				CarpetArea, SecondSale, ValueOfProperty, MorgageType, UnderConstructionOrNot,
				HouseNo, Address, Landmark, Locality,
				Pincode, Taluka, SellerName, Address1);
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
