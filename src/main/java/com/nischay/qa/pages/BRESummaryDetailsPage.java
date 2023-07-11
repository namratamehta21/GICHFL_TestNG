package com.nischay.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class BRESummaryDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;	
		
	@FindBy(xpath = "(//div[@class='menu-item-name'])[9]")
	WebElement BRESummaryTab;
	
	@FindBy(xpath = "(//app-bresummary[@class='ng-star-inserted'])/div/div/div/span[2]")
	WebElement status;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[1]/input")
	WebElement loanRequested;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[2]/input")
	WebElement inPrincipleSanctionedAmount;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[3]/input")
	WebElement tenure;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[4]/input")
	WebElement roi;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[5]/input")
	WebElement emi;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[6]/input")
	WebElement foir;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[6]")
	WebElement next;
	
	//@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[7]")
	//WebElement next;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[6]")
	WebElement previous;
	
	public BRESummaryDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
	}

	
	public void verifyBRESummaryDetails(String LoanRequested, String InPrincipleSanctionedAmount, String Tenure, 
			String ROI, String EMI, String FOIR ) throws InterruptedException 
	{
		Thread.sleep(3000);
		BRESummaryTab.click();
		Thread.sleep(3000);
		
		String Status1 = status.getText();
		Thread.sleep(3000);
		System.out.println("Status is : "+Status1);
		
		if(loanRequested.getAttribute("value").contentEquals(LoanRequested))
		  {
			System.out.println("Loan requested is matching");
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("Loan requested is not matching");
			  Thread.sleep(3000);
		  }
			
		 if(inPrincipleSanctionedAmount.getAttribute("value").contentEquals(InPrincipleSanctionedAmount))
		  {
			System.out.println("inPrincipleSanctionedAmount is matching");
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("inPrincipleSanctionedAmount is not matching");
			  Thread.sleep(3000);
		  }
		
		 if(tenure.getAttribute("value").contentEquals(Tenure))
		  {
			System.out.println("Tenure is matching");
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("Tenure is not matching");
			  Thread.sleep(3000);
		  }
		
		 if(roi.getAttribute("value").contentEquals(ROI))
		  {
			System.out.println("ROI is matching");
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("ROI is not matching");
			  Thread.sleep(3000);
		  }
		 
		 if(emi.getAttribute("value").contentEquals(EMI))
		  {
			System.out.println("EMI is matching");
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("EMI is not matching");
			  Thread.sleep(3000);
		  }
		 
		 if(foir.getAttribute("value").contentEquals(FOIR))
		  {
			System.out.println("FOIR is matching");
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("FOIR is not matching");
			  Thread.sleep(3000);
		  }
				
		next.click();
		Thread.sleep(3000);
		
	}	
	
}

