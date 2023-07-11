package com.nischay.qa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.pages.CoApplicantKYCDetailsPage;
import com.nischay.qa.pages.DashboardPage;
import com.nischay.qa.pages.LoginPage;
import com.nischay.qa.util.TestUtil;

public class CoApplicantKYCDetailsPageTest extends TestBase 
{
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	CoApplicantKYCDetailsPage coApplicantKYCDetailsPage;
	LoginPage loginPage;
	
	String sheetName1 = "AppKYCDetails";

	String Path1 = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/ApplicantKYCDetails.xlsx";
	
	String sheetName = "CoAppKYCDetails";

	String Path = System.getProperty("user.dir") + "/src/main/java/com/nischay/qa/testdata/CoApplicantKYCDetails.xlsx";
	

	public CoApplicantKYCDetailsPageTest() 
	{
		super();
	}

	
	/*@Parameters({ "username", "password" })
	@BeforeMethod
	public void setUp(String username, String password) throws InterruptedException  
	{
		initialization();
		dashboardPage = new DashboardPage();
		coApplicantKYCDetailsPage= new CoApplicantKYCDetailsPage();
		testUtil = new TestUtil();
		loginPage = new LoginPage(driver);
		
		loginPage.login(username, password);
	}*/
	
	/*@DataProvider
	public Object[][] getTestData() 
	{
		Object data[][] = TestUtil.getTestData(sheetName, Path);
		return data;
	}*/
	

	@DataProvider
	public Object[][] getTestData() throws IOException 
	{
		Map<String, ArrayList<ArrayList<String>>> data = TestUtil.compareSheetAndGetData(Path1, sheetName1, Path, sheetName);
		
		/*for (int i = 1; i < data.length; i++) 
        {
        	for(int j = 0; j < data[i].length; j++) 
        	{
        		//if(data[i][j]!=null)
        		//{
        			System.out.println("Return data :");
        			System.out.println(data[i][j]);
        		//}
        	}
        }*/
		for (String name : data.keySet()) 
		{
			String key = name.toString();
			String value = data.get(name).toString();
			System.out.println("Co-applicant page "+key + " " + value);
		}
		System.out.println("");
		return new Object[][] {{ data}};
	}
	
	@Test(dataProvider = "getTestData")
	public void verifyCoApplicantKYCdetails( Map<String, ArrayList<ArrayList<String>>> e
			/*String TestCase, String PanNo, String IncomeConsidered, String FirstName, String MiddleName, 
			String LastName, String DateOfBirth, String Gender, String AadharNo,
			String Occupation, String Citizenship, String Education, String Religion, String MaritalStatus, 
			String Category, String Relationship*/
			) //throws InterruptedException 
	{
		
		
		for (String name : e.keySet()) 
		{
		
			String key = name.toString();
			
			//String value = e.get(name).toString();
			
			ArrayList<ArrayList<String>> value = e.get(name);
				
			for(int i=0;i<value.size();i++)
			{
				System.out.println(key +"          "+value.get(i));
				
				AtomicInteger index = new AtomicInteger(); 
				
				String panNo = null, incomeConsidered = null, firstName = null, middleName = null, 
						lastName = null, dateOfBirth = null, gender = null, aadharNo = null,
						occupation = null, citizenship = null, education = null, religion = null, maritalStatus = null, 
						category = null, relationship = null;
				
				value.get(i).stream().map(s -> index.getAndIncrement() + "-> "+ s).
					
				
				forEach(s -> {
					System.out.println("Pan ====="+s);
					
					/*String panNo = null, incomeConsidered = null, firstName = null, middleName = null, 
							lastName = null, dateOfBirth = null, gender = null, aadharNo = null,
							occupation = null, citizenship = null, education = null, religion = null, maritalStatus = null, 
							category = null, relationship = null;	*/
					
					/*
					if(index.get()==1)
					{						
						panNo=s;
						System.out.println("Pan22 ====="+panNo);
					}
					if(index.get()==2)
					{						
						incomeConsidered=s;
						System.out.println("Pan22 ====="+incomeConsidered);
					}
					if(index.get()==3)
					{						
						firstName=s;
						System.out.println("Pan22 ====="+firstName);
					}
					if(index.get()==4)
					{						
						middleName=s;
						System.out.println("Pan22 ====="+middleName);
					}
					if(index.get()==5)
					{						
						lastName=s;
						System.out.println("Pan22 ====="+lastName);
					}
					if(index.get()==6)
					{						
						dateOfBirth=s;
						System.out.println("Pan22 ====="+dateOfBirth);
					}
					if(index.get()==7)
					{						
						gender=s;
						System.out.println("Pan22 ====="+gender);
					}
					if(index.get()==8)
					{						
						aadharNo=s;
						System.out.println("Pan22 ====="+aadharNo);
					}
					if(index.get()==9)
					{						
						occupation=s;
						System.out.println("Pan22 ====="+occupation);
					}
					if(index.get()==10)
					{						
						citizenship=s;
						System.out.println("Pan22 ====="+citizenship);
					}
					if(index.get()==11)
					{						
						education=s;
						System.out.println("Pan22 ====="+education);
					}
					if(index.get()==12)
					{						
						religion=s;
						System.out.println("Pan22 ====="+religion);
					}
					if(index.get()==13)
					{						
						maritalStatus=s;
						System.out.println("Pan22 ====="+maritalStatus);
					}
					if(index.get()==14)
					{						
						category=s;
						System.out.println("Pan22 ====="+category);
					}
					if(index.get()==15)
					{						
						relationship=s;
						System.out.println("Pan22 ====="+relationship);
					}
*/					
				});
				
				/*
				try {
					dashboardPage.searchApplication();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    try {
					dashboardPage.editApplication();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    try {
					coApplicantKYCDetailsPage.addCoApplicantKYCDetails(panNo, incomeConsidered, firstName, middleName, 
							lastName, dateOfBirth, gender, aadharNo,
							occupation, citizenship, education, religion, maritalStatus, 
							category, relationship);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				value.get(i).forEach(s -> {
					
					System.out.println("Value is : "+s);
					
				} );*/
			}
		}
		
		
		/*try
		{
			System.out.println("Inside verifyCoApplicantKYCdetails method");
			String tc = TestCase;
			System.out.println("Test Case execution no is : "+tc);
			
		    dashboardPage.searchApplication();
		    dashboardPage.editApplication();
		    coApplicantKYCDetailsPage.addCoApplicantKYCDetails(PanNo, IncomeConsidered, FirstName, MiddleName, 
					LastName, DateOfBirth, Gender, AadharNo,
					Occupation, Citizenship, Education, Religion, MaritalStatus, 
					Category, Relationship);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
	}


	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}
