package com.nischay.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class IncomeAssessmentEditIncomePage extends TestBase 
{
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
			
	@FindBy(xpath = "(//div[@class='ng-star-inserted'])[13]")
	WebElement incomeAssessmentTab;
	
	@FindBy(xpath = "(//div[@class='ng-star-inserted'])[9]/app-side-nav-sub-menu-items/div/span")
	WebElement editIncomeDetails;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[9]")
	WebElement edit;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[9]")
	WebElement accept;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[6]")
	WebElement salaryTransaction;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[7]")
	WebElement pensionTransaction;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[9]")
	WebElement addPension;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[8]")
	WebElement rentalTransaction;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[9]")
	WebElement addRental;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[11]")
	WebElement next;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[10]")
	WebElement previous;
	
	public IncomeAssessmentEditIncomePage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		//applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}
	
	public void editIncomeDetails() throws InterruptedException 
	{
		incomeAssessmentTab.click();
		Thread.sleep(50000);
		
		editIncomeDetails.click();
		Thread.sleep(3000);
		
		List<WebElement> list = driver.findElements(By.xpath("(//*[@class='mat-tab-labels'])[1]/div/div"));
		  Thread.sleep(2000);
		  
		  int size = list.size();
		
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  WebElement editIncomeTab = null;
		  int i=0;
		  
		  if(size>=0)
		  { 
			  for(i=1; i<=size; i++)
				{
				  
				  	System.out.println("Checking Edit Income for : "+i);
		
				  	
				  	editIncomeTab = driver.findElement(By.xpath("((//*[@class='mat-tab-label-container'])[1]/div/div/div/div)["+i+"]"));
				  	Thread.sleep(3000);
				  	js.executeScript("arguments[0].click();", editIncomeTab);
					Thread.sleep(3000);
					
					salaryTransaction.click();
					Thread.sleep(3000);
					
					edit.click();
					Thread.sleep(3000);
					
					accept.click();
					Thread.sleep(3000);
					
					pensionTransaction.click();
					Thread.sleep(3000);
					
					addPension.click();
					Thread.sleep(3000);
					
					accept.click();
					Thread.sleep(3000);
					
					rentalTransaction.click();
					Thread.sleep(3000);
					
					addRental.click();
					Thread.sleep(3000);
					
					accept.click();
					Thread.sleep(3000);
					
					
				}
			 }
			 else
			 {
				  System.out.println("CIBIL report not available");
			 }
		next.click();
		Thread.sleep(3000);
	}	
}

