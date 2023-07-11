package com.nischay.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class LoginFeeDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	
		
	@FindBy(xpath = "(//*[@class='ng-star-inserted']/app-side-nav-menu-items/div)[7]")
	WebElement loginFeeDetailsTab;
		
	@FindBy(xpath = "(//div[@class='mat-radio-outer-circle'])[1]")
	WebElement cheque;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix']/input)[1]")
	WebElement bankName;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix']/input)[2]")
	WebElement ifscCode;
			
	@FindBy(xpath = "(//*[@class='mat-form-field-infix']/input)[3]")
	WebElement chequeNo;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix']/input)[4]")
	WebElement date;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix']/input)[4]")
	WebElement generateInvoice;
	
	@FindBy(xpath = "(//div[@class='mat-radio-outer-circle'])[2]")
	WebElement cash;
		
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[10]")
	WebElement chequesave;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[8]")
	WebElement cashsave;
	
	@FindBy(xpath = "(//*[@class='mat-radio-outer-circle'])[3]")
	WebElement paymentGateway;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[7]")
	WebElement chequepayNow;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[8]")
	WebElement next;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[7]")
	WebElement previous;
	
	
	public LoginFeeDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		//applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}

	
	public void selectChequeDetails(String BankName, String IFSCCode, String ChequeNumber, String ChequeDate) throws InterruptedException 
	{
		Thread.sleep(2000);
		
		loginFeeDetailsTab.click();
		
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
	     builder.moveToElement(cheque).click().build().perform();
	   
	     
		//cheque.click();
		Thread.sleep(3000);
		
		if(bankName.getAttribute("value").isEmpty())
		  {
			bankName.click();
			bankName.sendKeys(BankName);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("bankName value exists");
		  }
		
		if(ifscCode.getAttribute("value").isEmpty())
		  {
			ifscCode.click();
			ifscCode.sendKeys(IFSCCode);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("bankName value exists");
		  }
		
		if(chequeNo.getAttribute("value").isEmpty())
		  {
			chequeNo.click();
			chequeNo.sendKeys(ChequeNumber);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("chequeNo value exists");
		  }
		
		if(date.getAttribute("value").isEmpty())
		  {
			date.click();
			date.sendKeys(ChequeDate);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("date value exists");
		  }
			
		
		
		/*
		 * generateInvoice.click(); Thread.sleep(3000);
		 */
		chequepayNow.click();
		Thread.sleep(3000);
		
		chequesave.click();
		Thread.sleep(3000);
	}	
	
	public void selectCashDetails() throws InterruptedException 
	{
		loginFeeDetailsTab.click();
		Thread.sleep(3000);
		
		cash.click();
		Thread.sleep(3000);
		
		cashsave.click();
		Thread.sleep(3000);
	}
	
	public void paymentGateway() throws InterruptedException 
	{
		
	}
	
}

