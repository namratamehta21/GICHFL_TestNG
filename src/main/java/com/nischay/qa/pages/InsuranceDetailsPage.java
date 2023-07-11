package com.nischay.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class InsuranceDetailsPage extends TestBase 
{
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	
	@FindBy(xpath = "(//div[@class='ng-star-inserted'])[14]")
	WebElement insuranceDetailsTab;
	
	@FindBy(xpath = "(//div[@class='mat-radio-outer-circle'])[2]")
	WebElement no;
	
	@FindBy(xpath = "(//div[@class='mat-radio-outer-circle'])[1]")
	WebElement yes;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[6]")
	WebElement yesContinue;
	
	@FindBy(xpath = "(//*[@class='primary-button mat-raised-button'])[1]/span")
	WebElement selectBirlaLifeInsurance;
	
	@FindBy(xpath = "(//*[@class='primary-button mat-raised-button'])[2]/span")
	WebElement selectKotakLifeInsurance;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[5]/input")
	WebElement nomineeName;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[6]/input")
	WebElement nomineeDOB;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[1]/span")
	WebElement nomineeGender;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[2]/span")
	WebElement nomineeRelationship;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[8]")
	WebElement uploadDOGH;
	
	@FindBy(xpath = "(//*[@class='primary-button mat-raised-button'])[3]/span")
	WebElement selectTataAIG;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[10]/input")
	WebElement tataAIGNomineeName;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[11]/input")
	WebElement tataAIGNomineeDOB;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[3]/span")
	WebElement tataAIGNomineeGender;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[4]/span")
	WebElement tataAIGNomineeRelationship;
	
	@FindBy(xpath = "(//*[@class='mat-radio-outer-circle'])[3]")
	WebElement yesPreExistingDisease;
	
	@FindBy(xpath = "(//*[@class='mat-radio-outer-circle'])[4]")
	WebElement noPreExistingDisease;
	
	@FindBy(xpath = "(//*[@class='mat-radio-outer-circle'])[5]")
	WebElement yesInGoodHealth;
	
	@FindBy(xpath = "(//*[@class='mat-radio-outer-circle'])[6]")
	WebElement noInGoodHealth;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[10]")
	WebElement yesToCompleteActivity;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[11]")
	WebElement noToCompleteActivity;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[9]")
	WebElement save;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[8]")
	WebElement next;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[7]")
	WebElement previous;
	
	
	
	public InsuranceDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		//applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}
	
	public void selectLifeInsurance(String OptForInsurance, String SelectBirlaInsurance, String SelectKotakInsurance, String NomineeName,
			String NomineeDOB, String NomineeGender, String NomineeRelationship,
			String SelectTataAIG, String TataAIGNomineeName, String TataAIGNomineeDOB, String TataAIGNomineeGender, String TataAIGNomineeRelationship,
			String PreExistingDisease, String InGoodHealth) 
					throws InterruptedException 
	{
		insuranceDetailsTab.click();
		Thread.sleep(3000);
		
		if(OptForInsurance.contains("Yes"))
		  {
			  yes.click();
			  Thread.sleep(3000);
		  
		
		if(SelectBirlaInsurance.contains("Yes"))
		  {
			  Thread.sleep(3000);
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
			  executor.executeScript("arguments[0].click();", selectBirlaLifeInsurance);
			  Thread.sleep(3000);
		  }
		else if(SelectKotakInsurance.contains("Yes"))
		  {
			  Thread.sleep(3000);
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
			  executor.executeScript("arguments[0].click();", selectKotakLifeInsurance);
			  Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("Life Insurance is not selected");
		  }
		
		
		nomineeName.click();
		nomineeName.sendKeys(NomineeName);
		Thread.sleep(3000);
	
		nomineeDOB.click();
		nomineeDOB.sendKeys(NomineeDOB);
		Thread.sleep(3000);
		
		
		if(nomineeGender.getText().length() == 1)
		  {
			  System.out.println("Inside if loop");
			  nomineeGender.click();
			  Thread.sleep(2000);
			  
			  List<WebElement> gen = driver.findElements(By.xpath("(//*[@class='mat-option-text'])"));
			  Thread.sleep(2000);
					  
		  for (WebElement ele : gen)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(NomineeGender)) 
	          {
	              ele.click();
	              break;
	          }
		  }
		  }
		  else
		  {
			  System.out.println("Inside else loop");
			  System.out.println("Gender is selected");
		  }
		
		if(nomineeRelationship.getText().length() == 1)
		  {
			  System.out.println("Inside if loop");
			  nomineeRelationship.click();
			  Thread.sleep(2000);
			  
			  List<WebElement> gen = driver.findElements(By.xpath("(//*[@class='mat-option-text'])"));
			  Thread.sleep(2000);
					  
		  for (WebElement ele : gen)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(NomineeRelationship)) 
	          {
	              ele.click();
	              break;
	          }
		  }
		  }
		  else
		  {
			  System.out.println("Inside else loop");
			  System.out.println("Relationship is selected");
		  }
		
		/*nomineeRelationship.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[@class='mat-option-text'])[1]")).click();
		Thread.sleep(3000);*/
		
		if(SelectTataAIG.contains("Yes"))
		  {
			  Thread.sleep(3000);
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
			  executor.executeScript("arguments[0].click();", selectTataAIG);
			  Thread.sleep(3000);
		  }
		
		  else
		  {
			  System.out.println("Tata AIG Life Insurance is not selected");
		  }
		
		
		tataAIGNomineeName.click();
		tataAIGNomineeName.sendKeys(TataAIGNomineeName);
		Thread.sleep(3000);
	
		tataAIGNomineeDOB.click();
		tataAIGNomineeDOB.sendKeys(TataAIGNomineeDOB);
		Thread.sleep(3000);
		
		
		if(tataAIGNomineeGender.getText().length() == 1)
		  {
			  System.out.println("Inside if loop");
			  tataAIGNomineeGender.click();
			  Thread.sleep(2000);
			  
			  List<WebElement> gen = driver.findElements(By.xpath("(//*[@class='mat-option-text'])"));
			  Thread.sleep(2000);
					  
		  for (WebElement ele : gen)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(TataAIGNomineeGender)) 
	          {
	              ele.click();
	              break;
	          }
		  }
		  }
		  else
		  {
			  System.out.println("Inside else loop");
			  System.out.println("Gender is selected");
		  }
		
		if(tataAIGNomineeRelationship.getText().length() == 1)
		  {
			  System.out.println("Inside if loop");
			  tataAIGNomineeRelationship.click();
			  Thread.sleep(2000);
			  
			  List<WebElement> gen = driver.findElements(By.xpath("(//*[@class='mat-option-text'])"));
			  Thread.sleep(2000);
					  
		  for (WebElement ele : gen)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(TataAIGNomineeRelationship)) 
	          {
	              ele.click();
	              break;
	          }
		  }
		  }
		  else
		  {
			  System.out.println("Inside else loop");
			  System.out.println("Relationship is selected");
		  }
		

		if(PreExistingDisease.contains("Yes"))
		  {
				yesPreExistingDisease.click();
			  Thread.sleep(3000);
		  }
		  else
		  {
			  noPreExistingDisease.click();
			  Thread.sleep(3000);
		  }
		

		if(InGoodHealth.contains("Yes"))
		  {
			  yesInGoodHealth.click();
			  Thread.sleep(3000);
		  }
		  else
		  {
			  noInGoodHealth.click();
			  Thread.sleep(3000);
		  }
		save.click();
		Thread.sleep(5000);
		
		  }
		  else
		  {
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
			  executor.executeScript("arguments[0].click();", no);
			  //no.click();
			  Thread.sleep(3000);
			  
			  yesContinue.click();
			  Thread.sleep(3000);
			  
			  yesToCompleteActivity.click();
			  Thread.sleep(3000);
			  
			  next.click();
			  Thread.sleep(3000);
			  
			  yesToCompleteActivity.click();
			  Thread.sleep(3000);
			  
		  }
		
	}	
}

