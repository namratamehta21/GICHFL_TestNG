package com.nischay.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class ApplicationSummaryDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
			
	@FindBy(xpath = "(//div[@class='ng-star-inserted'])[15]/app-side-nav-menu-items/div")
	WebElement applicationSummaryTab;
	
	
	@FindBy(xpath = "(//*[@class='menu-item-name active'])")
	WebElement applicationSummary;
	
	@FindBy(xpath = "//*[@class='mat-icon-button ng-star-inserted']/span/mat-icon")
	WebElement minMaxButton;
	
	@FindBy(xpath = "(//*[@class='mat-accordion']/app-custom-accordian-panel/mat-expansion-panel/mat-expansion-panel-header/span)[1]")
	WebElement kycDetailsTab;
	
	@FindBy(xpath = "(//*[@class='mat-accordion']/app-custom-accordian-panel/mat-expansion-panel/mat-expansion-panel-header/span)[3]")
	WebElement correspondenceDetailsTab;
	
	@FindBy(xpath = "(//*[@class='mat-accordion']/app-custom-accordian-panel/mat-expansion-panel/mat-expansion-panel-header/span)[5]")
	WebElement familyDetailsTab;
	
	@FindBy(xpath = "(//*[@class='mat-accordion']/app-custom-accordian-panel/mat-expansion-panel/mat-expansion-panel-header/span)[7]")
	WebElement employerDetailsTab;
	
	@FindBy(xpath = "(//*[@class='mat-content']/img)[1]")
	WebElement editKYCDetails;
	
	@FindBy(xpath = "(//*[@class='mat-content']/img)[2]")
	WebElement editCorrespondenceDetails;
	
	@FindBy(xpath = "(//*[@class='mat-content']/img)[3]")
	WebElement editFamilyDetails;
	
	@FindBy(xpath = "(//*[@class='mat-content']/img)[4]")
	WebElement editEmployerDetails;
	
	@FindBy(xpath = "//*[@class='mat-select-value']/span")
	WebElement viewDocument;
	
	/*
	 * @FindBy(xpath = "(//*[@class='mat-tab-labels'])/div[2]") WebElement
	 * coapplicantTab1;
	 */
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[8]")
	WebElement save;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[7]")
	WebElement next;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[6]")
	WebElement sendToHOPO;
	
	
	public ApplicationSummaryDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		//applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}

	
	public void verifyApplicationSummaryDetails() throws InterruptedException 
	{
			
		applicationSummaryTab.click();
		Thread.sleep(3000);
		
				
		  /*List<WebElement> list = driver.findElements(By.xpath("(//*[@class='mat-tab-labels'])/div"));
		  Thread.sleep(2000);
		  System.out.println("List is : "+list.size());
		  int size = list.size();
		 
		  WebElement coapplicantTab1 = null;
		if(size>=1)
		{
			for(int i=1; i<=size; i++)
			{
			System.out.println("Inside co-applicant loop");
			
			coapplicantTab1 = driver.findElement(By.xpath("(//*[@class='mat-tab-list'])/div/div["+i+"]"));
			
			
			Actions actions = new Actions(driver);
			actions.moveToElement(coapplicantTab1).click().build().perform();
			Thread.sleep(3000);			
			
			
			kycDetailsTab.click();
			Thread.sleep(3000);
			
			editKYCDetails.click();
			Thread.sleep(3000);
			
			Thread.sleep(3000);
			applicationSummary.click();
			Thread.sleep(3000);
			
			actions.moveToElement(coapplicantTab1).click().build().perform();
			Thread.sleep(3000);
			
			correspondenceDetailsTab.click();
			Thread.sleep(3000);
			
			editCorrespondenceDetails.click();
			Thread.sleep(3000);
			
			applicationSummary.click();
			Thread.sleep(3000);
			
			actions.moveToElement(coapplicantTab1).click().build().perform();
			Thread.sleep(3000);
			
			familyDetailsTab.click();
			Thread.sleep(3000);
			
			editFamilyDetails.click();
			Thread.sleep(3000);
			
			applicationSummary.click();
			Thread.sleep(3000);
			
			actions.moveToElement(coapplicantTab1).click().build().perform();
			Thread.sleep(3000);
			
			employerDetailsTab.click();
			Thread.sleep(3000);
			
			editEmployerDetails.click();
			Thread.sleep(3000);
			
			applicationSummary.click();
			Thread.sleep(3000);
			
			actions.moveToElement(coapplicantTab1).click().build().perform();
			Thread.sleep(3000);
		}
		}
		else
		{
			System.out.println("Coapplicant not available");
		}*/
		
		Thread.sleep(3000);
		sendToHOPO.click();
		Thread.sleep(3000);
	}	
	
}

