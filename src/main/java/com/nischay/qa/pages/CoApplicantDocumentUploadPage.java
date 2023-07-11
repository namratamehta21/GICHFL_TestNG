package com.nischay.qa.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class CoApplicantDocumentUploadPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	
	@FindBy(xpath = "(//*[@class='ng-star-inserted']/app-side-nav-menu-items/div)[2]")
	WebElement CoApplicantTab;
	
	@FindBy(xpath = "(//div[@class='ng-star-inserted']/app-side-nav-sub-menu-items/div/span)[6]")
	WebElement documentUploadTab;
	
	@FindBy(xpath = "(//div[@class='file-upload-icon'])[1]/img")
	WebElement uploadPanCard;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[8]")
	WebElement save;
	
	public CoApplicantDocumentUploadPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
	}

	
	public void enterCoApplicantDocumentUploadDetails() throws InterruptedException 
	{
		CoApplicantTab.click();
		Thread.sleep(3000);
		
		documentUploadTab.click();
		Thread.sleep(3000);
		
		uploadPanCard.click();
		Thread.sleep(3000);
		
		try 
		{
	        StringSelection ss = new StringSelection("D:\\GIC_Automation\\GICAutomation\\Assets\\Untitled.jpg");
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	        
	        testUtil.robotClass();
	    } 
		catch (Exception exp) 
		{
	        exp.printStackTrace();
	    }
		
		save.click();
		Thread.sleep(3000);
		
	}	
	
}

