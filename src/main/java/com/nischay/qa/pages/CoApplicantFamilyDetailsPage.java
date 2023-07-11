package com.nischay.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class CoApplicantFamilyDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	
	@FindBy(xpath = "(//*[@class='ng-star-inserted']/app-side-nav-menu-items/div)[3]")
	WebElement CoApplicantTab;
	
	@FindBy(xpath = "(//*[@class='mat-card-content'])/img[2]")
	WebElement selectCoApplicantTab;
		
	@FindBy(xpath = "(//div[@class='ng-star-inserted']/app-side-nav-sub-menu-items/div/span)[3]")
	WebElement familyDetailsTab;
	
	@FindBy(xpath = "(//div[@class=\"mat-form-field-infix\"]/input)[1]")
	WebElement fatherName;
	
	@FindBy(xpath = "(//div[@class=\"mat-form-field-infix\"]/input)[2]")
	WebElement motherName;
	
	@FindBy(xpath = "(//div[@class=\"mat-form-field-infix\"]/input)[3]")
	WebElement spouseName;
	
	@FindBy(xpath = "(//div[@class=\"mat-form-field-infix\"]/input)[4]")
	WebElement emergancyNo;
	
	@FindBy(xpath = "(//div[@class=\"mat-form-field-infix\"]/input)[5]")
	WebElement noOfDependent;
	
	@FindBy(xpath = "(//span[@class=\"mat-button-wrapper\"])[8]")
	WebElement save;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[7]")
	WebElement next;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[6]")
	WebElement previous;
	
	
	public CoApplicantFamilyDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		//applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}

	
	public void enterCoApplicantFamilyDetails(String FatherName, String MotherName, String SpouseName, String EmergancyNo, String NoOfDependent ) throws InterruptedException 
	{
		CoApplicantTab.click();
		Thread.sleep(2000);
		
		selectCoApplicantTab.click();
		Thread.sleep(2000);
		
		
		familyDetailsTab.click();
		Thread.sleep(2000);
		
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
		
		if(emergancyNo.getAttribute("value").isEmpty())
		  {
			emergancyNo.click();
			emergancyNo.sendKeys(EmergancyNo);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("emergancyNo value exists");
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
		Thread.sleep(5000);
		
	}	
	
}

