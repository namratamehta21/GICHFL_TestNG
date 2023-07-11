package com.nischay.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class ApplicantFamilyDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	
		
	@FindBy(xpath = "(//div[@class='ng-star-inserted']/app-side-nav-sub-menu-items/div/span)[3]")
	WebElement familyDetailsTab;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[1]")
	WebElement fatherName;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[2]")
	WebElement motherName;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[3]")
	WebElement spouseName;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[4]")
	WebElement emergancyContactNo;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[5]")
	WebElement noOfDependent;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[8]")
	WebElement save;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[7]")
	WebElement next;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[6]")
	WebElement previous;
	
	
	public ApplicantFamilyDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		//applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}

	
	public void enterFamilyDetails(String FatherName, String MotherName, String SpouseName, String EmergancyContactNo, String NoOfDependent ) throws InterruptedException 
	{
		Thread.sleep(3000);
		familyDetailsTab.click();
		Thread.sleep(3000);
		
		if(fatherName.getAttribute("value").isEmpty())
		  {
			fatherName.click();
			fatherName.sendKeys(FatherName);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("fatherName value exists");
		  }
			
		if(motherName.getAttribute("value").isEmpty())
		  {
			motherName.click();
			motherName.sendKeys(MotherName);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("motherName value exists");
		  }
		
		if(spouseName.getAttribute("value").isEmpty())
		  {
			spouseName.click();
			spouseName.sendKeys(SpouseName);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("spouseName value exists");
		  }
		
		if(emergancyContactNo.getAttribute("value").isEmpty())
		  {
			emergancyContactNo.click();
			emergancyContactNo.sendKeys(EmergancyContactNo);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("emergancyContactNo value exists");
		  }
		
		if(noOfDependent.getAttribute("value").isEmpty())
		  {
			noOfDependent.click();
			noOfDependent.sendKeys(NoOfDependent);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("noOfDependent value exists");
		  }
				
		save.click();
		Thread.sleep(3000);
		
	}	
	
}

