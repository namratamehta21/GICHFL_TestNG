package com.nischay.qa.pages;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class CIBILAssessmentPage extends TestBase 
{
	TestUtil testUtil;
	DashboardPage dashboardPage;
			
	@FindBy(xpath = "(//*[@class='menu-item-name'])[3]")
	WebElement cibilAssessmentTab;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[1]")
	WebElement applicantTab;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[2]")
	WebElement coApplicantTab;
	
	@FindBy(xpath = "(//*[@class='mat-card-content'])[2]/h3/b/span[2]")
	WebElement transUnionScore;
	
	@FindBy(xpath = "(//*[@class='mat-card-content'])[3]/h3/b/span[2]")
	WebElement personalLoanScore;
	
	@FindBy(xpath = "//div[contains(text(),'Consumer Information')]")
	WebElement consumerInformation;
	
	@FindBy(xpath = "(//div[contains(text(),'Summary')])[4]")
	WebElement summary;
	
	@FindBy(xpath = "//div[contains(text(),'Enquiries')]")
	WebElement enquiries;
	
	@FindBy(xpath = "//div[contains(text(),'Additional Matches')]")
	WebElement aditionalMatches;
	
	@FindBy(xpath = "(//*[@class='mat-content'])[1]")
	WebElement openAccounts;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[6]")
	WebElement addAccount;
	
	@FindBy(xpath = "(//*[@class='mat-checkbox-layout'])[1]/div")
	WebElement closureStatusCheckbox;
	
	@FindBy(xpath = "(//*[@class='mat-select-value']/span)[1]")
	WebElement closureStatusDropDown;
	
	@FindBy(xpath = "(//*[@class='mat-option-text'])[2]")
	WebElement selectClosureStatus;
	
	@FindBy(xpath = "(//*[@class='mat-option-text'])[2]")
	WebElement loanType;
	
	@FindBy(xpath = "(//*[@class='mat-content'])[2]")
	WebElement closeAccounts;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[7]")
	WebElement viewReport;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[10]")
	WebElement save;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[9]")
	WebElement next;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[8]")
	WebElement previous;
	
	
	public CIBILAssessmentPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		//applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}

	
	public void VerifyCIBILAssessment() throws InterruptedException 
	{
		
		Thread.sleep(3000);
		
		cibilAssessmentTab.click();
		Thread.sleep(3000);
		
		  List<WebElement> list = driver.findElements(By.xpath("(//*[@class='mat-tab-labels'])[1]/div/div"));
		  Thread.sleep(2000);
		  
		  int size = list.size();
		
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  WebElement cibil = null;
		  int i=0;
		  if(size>=0)
		  { 
			  for(i=1; i<=size; i++)
				{
				  	System.out.println("Checking CIBIL report of : "+i);
				  				  
				  	cibil = driver.findElement(By.xpath("((//*[@class='mat-tab-label-container'])[1]/div/div/div/div)["+i+"]"));
				  	Thread.sleep(3000);
				  	js.executeScript("arguments[0].click();", cibil);
					Thread.sleep(3000);
					
					System.out.println("WebElement is :" +cibil);
					
					String transUnionScr = transUnionScore.getText();
					System.out.println("Trans Union Score is :"+transUnionScr);
					
					String personalLoanScr = personalLoanScore.getText();
					System.out.println("Trans Union Score is :"+personalLoanScr);
					
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click();", summary);
					Thread.sleep(3000);
					
					JavascriptExecutor jse1 = (JavascriptExecutor)driver;
					jse1.executeScript("arguments[0].click();", enquiries);
					Thread.sleep(3000);
					
					JavascriptExecutor jse2 = (JavascriptExecutor)driver;
					jse2.executeScript("arguments[0].click();", aditionalMatches);
					Thread.sleep(3000);
					
					JavascriptExecutor jse3 = (JavascriptExecutor)driver;
					jse3.executeScript("arguments[0].click();", consumerInformation);
					Thread.sleep(3000);
					
					openAccounts.click();
					Thread.sleep(3000);

					addAccount.click();
					Thread.sleep(3000);
					
					closeAccounts.click();
					Thread.sleep(3000);
					
					String currentHandle= driver.getWindowHandle();
					System.out.println("Current window is"+currentHandle);
					
					viewReport.click();
					Thread.sleep(3000);
					      
			        
					Set<String> handles = driver.getWindowHandles();
					System.out.println("window is"+handles);
					
					for(String actual: handles)
			        {
			            
			         if(!actual.equalsIgnoreCase(currentHandle))
			         {
			             //switching to the opened tab
			             driver.switchTo().window(actual);
			             Thread.sleep(3000);
			             
			             //opening the URL saved.
			             driver.close();
			             Thread.sleep(3000);
			             
			             driver.switchTo().window(currentHandle);
			             Thread.sleep(3000);
			         }
			         
			        }
					
					save.click();
					Thread.sleep(3000);
				}
		  }
		  else
		  {
			  System.out.println("CIBIL report not available");
		  }
	}	
}

