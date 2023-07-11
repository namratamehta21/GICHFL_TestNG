package com.nischay.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class CoApplicantEmployerDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	
	@FindBy(xpath = "(//*[@class='ng-star-inserted']/app-side-nav-menu-items/div)[3]")
	WebElement CoApplicantTab;
	
	@FindBy(xpath = "(//*[@class='mat-card-content'])/img[2]")
	WebElement editCoApplicant;
		
	@FindBy(xpath = "(//*[@class=\"ng-star-inserted\"]/app-side-nav-sub-menu-items/div/span)[4]")
	WebElement employerDetailsTab;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[2]")
	WebElement employerName;
	
	@FindBy(xpath = "(//*[@class=\"mat-select-value\"]/span)[1]")
	WebElement selectEmploymentType;
	
	@FindBy(xpath = "(//*[@class=\"mat-option mat-active\"]/span)[1]")
	WebElement employmentSince;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix']/input)[1]")
	WebElement employeeSince;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[3]")
	WebElement dateOfJoining;
	
	@FindBy(xpath = "(//div[@class='mat-select-trigger'])[2]") WebElement
	addressType;
	
	@FindBy(xpath = "(//mat-option[@class='mat-option ng-star-inserted mat-active'])[1]") 
	WebElement selectAddressType;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[6]/textarea") WebElement
	 address;
	
	@FindBy(xpath = "//*[@class='branch-input-field-fullwidth link-button']/a/span")
	WebElement verifyAddress;
	
	@FindBy(xpath = "//*[@class=\"mat-raised-button primary-button full-width\"]/span")
	WebElement authenticate;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[8]")
	WebElement update;
	
	@FindBy(xpath = "//*[@class=\"mat-raised-button primary-button\"]/span")
	WebElement save;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[10]")
	WebElement next;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[9]")
	WebElement previous;
	
	public CoApplicantEmployerDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		//applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}

	public void enterCoApplicantEmployerDetails(String EmployeeSince, String EmployerName, String DateOfJoining, String AddressType, String HouseNo, String Address, String Landmark, String Locality, String Pincode) throws InterruptedException 
	{
		CoApplicantTab.click();
		Thread.sleep(2000);
		
		editCoApplicant.click();
		Thread.sleep(2000);
		
		employerDetailsTab.click();
		Thread.sleep(2000);
		
		if(employeeSince.getAttribute("value").isEmpty())
		  {
			employeeSince.click();
			employeeSince.sendKeys(EmployeeSince);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("employeeSince value exists");
		  }
		
		if(employerName.getAttribute("value").isEmpty())
		  {
			employerName.click();
			employerName.sendKeys(EmployerName);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("EmployerName value exists");
		  }
		
		/* Now this is auto populated field
		 * selectEmploymentType.click(); Thread.sleep(3000); employmentType.click();
		 */	
		
		if(dateOfJoining.getAttribute("value").isEmpty())
		  {
			dateOfJoining.click();
			dateOfJoining.sendKeys(DateOfJoining);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("dateOfJoining value exists");
		  }
		
		
		if(addressType.getText().length() == 1)
		  {
			  System.out.println("Inside addressType Code if loop");
			  addressType.click();
			  Thread.sleep(2000);
			  
			  List<WebElement> at = driver.findElements(By.xpath("(//*[@class='mat-option-text'])"));
			  Thread.sleep(2000);
					  
		  for (WebElement ele : at)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(AddressType)) 
	          {
	              ele.click();
	              break;
	          }
		  }
		  }
		  else
		  {
			  System.out.println("Inside else loop");
			  System.out.println("addressType is selected");
		  }	
		
		
		/*
		 * addressType.click(); Thread.sleep(3000); selectAddressType.click();
		 * Thread.sleep(3000);
		 */
		
		
		
		if(address.getAttribute("value").isEmpty())
		  {
			address.click();
			address.sendKeys(Address);
			Thread.sleep(3000);
			
			verifyAddress.click();
			Thread.sleep(3000);
			
			authenticate.click();
			Thread.sleep(3000);
			
			update.click();
			Thread.sleep(3000);
			
		  }
		  else
		  {
			  System.out.println("address value exists");
		  }
			
		save.click();
		Thread.sleep(3000);
	}	
	
}

