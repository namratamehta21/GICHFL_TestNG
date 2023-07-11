package com.nischay.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class ApplicantEmployerDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	
		
	@FindBy(xpath = "(//*[@class=\"ng-star-inserted\"]/app-side-nav-sub-menu-items/div/span)[4]")
	WebElement employerDetailsTab;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[1]/input")
	WebElement salariedSince;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix']/input)[2]")
	WebElement employerName;
	
	@FindBy(xpath = "(//*[@class=\"mat-select-value\"]/span)[1]")
	WebElement selectEmploymentType;
	
	@FindBy(xpath = "(//*[@class=\"mat-option mat-active\"]/span)[1]")
	WebElement employmentType;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[3]")
	WebElement dateOfJoining;
	
	@FindBy(xpath = "(//div[@class='mat-select-trigger'])[2]") WebElement
	addressType;
	
	@FindBy(xpath = "(//mat-option[@class='mat-option ng-star-inserted mat-active'])[1]") WebElement
	selectAddressType;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[6]/textarea") WebElement
	 address;
	
	@FindBy(xpath = "(//div[@class='branch-input-field-fullwidth link-button'])[1]/a/span") 
	WebElement verifyAddress;
	
	/*
	 * @FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[4]") WebElement
	 * houseNo;
	 * 
	 * @FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[5]") WebElement
	 * address;
	 * 
	 * @FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[6]") WebElement
	 * landmark;
	 * 
	 * @FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[7]") WebElement
	 * locality;
	 * 
	 * @FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[8]") WebElement
	 * pincode;
	 * 
	 * @FindBy(xpath = "//*[@class=\"branch-input-field link-button\"]/a/span")
	 * WebElement verifyAddress;
	 * 
	 * @FindBy(xpath =
	 * "//*[@class=\"mat-raised-button primary-button full-width\"]/span")
	 * WebElement authenticate;
	 * 
	 * @FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[8]") WebElement update;
	 */
	
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[9]")
	WebElement authenticate;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[8]")
	WebElement update;
			
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[11]")
	WebElement save;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[10]")
	WebElement next;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[9]")
	WebElement previous;
	
	
	public ApplicantEmployerDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		//applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}

	public void enterEmployerDetails(String SalariedSince, String EmployerName, String DateOfJoining, String AddressType, String Address) throws InterruptedException 
	{
		employerDetailsTab.click();
		Thread.sleep(3000);
		
			
		if(salariedSince.getAttribute("value").isEmpty())
		  {
			salariedSince.click();
			Thread.sleep(2000);
			salariedSince.sendKeys(SalariedSince);
		  }
		  else
		  {
			  System.out.println("Salaried Since value exists");
		  }
		
		if(employerName.getAttribute("value").isEmpty())
		  {
			employerName.click();
			Thread.sleep(2000);
			employerName.sendKeys(EmployerName);
		  }
		  else
		  {
			  System.out.println("Employer Name value exists");
		  }
				
		/* Now this is auto populated field
		 * selectEmploymentType.click(); Thread.sleep(3000); employmentType.click();
		 */
		
		if(dateOfJoining.getAttribute("value").isEmpty())
		  {
			dateOfJoining.click();
			Thread.sleep(2000);
			dateOfJoining.sendKeys(DateOfJoining);
		  }
		  else
		  {
			  System.out.println("date of joining value exists");
		  }
		
			
		if(addressType.getText().length() == 1)
		  {
			  System.out.println("Inside addressType if loop");
			  Thread.sleep(2000);
			  
			   Actions action = new Actions(driver);
			  action.moveToElement(addressType).click().perform();
						  
			  List<WebElement> addr = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
			  Thread.sleep(2000);
					  
		  for (WebElement ele : addr)
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
			  System.out.println("Address Type is selected");
		  }	
		
		
		/*
		 * houseNo.click(); Thread.sleep(3000); houseNo.sendKeys(HouseNo);
		 * 
		 * address.click(); Thread.sleep(3000); address.sendKeys(Address);
		 * 
		 * landmark.click(); Thread.sleep(3000); landmark.sendKeys(Landmark);
		 * 
		 * locality.click(); Thread.sleep(3000); locality.sendKeys(Locality);
		 * 
		 * pincode.click(); Thread.sleep(3000); pincode.sendKeys(Pincode);
		 * 
		 * verifyAddress.click();
		 * 
		 * authenticate.click();
		 */
		
		if(address.getAttribute("value").isEmpty())
		  {
			Actions action = new Actions(driver);
			action.moveToElement(address).click().perform();
			  
			//address.click();
			Thread.sleep(2000);
			address.sendKeys(Address);
			
		  }
		  else
		  {
			  System.out.println("Address value exists");
		  }
		verifyAddress.click();
		Thread.sleep(3000);
		
		authenticate.click();
		Thread.sleep(3000);
		
		update.click();
		Thread.sleep(3000);
				
		save.click();
		Thread.sleep(3000);
	}	
	
}

