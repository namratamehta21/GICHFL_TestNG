package com.nischay.qa.pages;


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class ApplicantPhotoSignaturePage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	
	@FindBy(xpath = "((//div[@class='ng-star-inserted'])[7]/app-side-nav-sub-menu-items/div)[1]")
	WebElement photSignatureTab;
	
	@FindBy(xpath = "(//span[@class='mat-content'])[1]")
	WebElement photoTab;
	
	@FindBy(xpath = "(//div[@class='mat-radio-outer-circle'])[1]")
	WebElement browseFromDeskTop;
	
	@FindBy(xpath = "(//button[@class='mat-raised-button primary-button'])[1]")
	WebElement browse;
	
	@FindBy(xpath = "(//div[@class='mat-radio-outer-circle'])[2]")
	WebElement captureFromWebcam;
	
	@FindBy(xpath = "(//button[@class='mat-raised-button primary-button'])[1]")
	WebElement capturePhoto;
	
	@FindBy(xpath = "(//button[@class='mat-raised-button primary-button'])[1]")
	WebElement reCapturePhoto;
	
	@FindBy(xpath = "(//span[@class='mat-content'])[2]")
	WebElement signatureTab;
	
	@FindBy(xpath = "(//button[@class='mat-raised-button primary-button'])[2]")
	WebElement captureSignature;
	
	@FindBy(xpath = "(//button[@class='mat-raised-button primary-button'])[2]")
	WebElement captureSignature1;
	
	@FindBy(xpath = "(//button[@class='mat-raised-button primary-button'])[2]")
	WebElement reCaptureSignature;
			
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[8]")
	WebElement previous;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[9]")
	WebElement next;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[10]")
	WebElement save;
	
	public ApplicantPhotoSignaturePage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
	}
	
	public void enterPhotoSignatureDetails() throws InterruptedException 
	{
		photSignatureTab.click();
		Thread.sleep(3000);
				 
		photoTab.click();
		Thread.sleep(3000);
		
		/*
		Code for capture from webcam
		captureFromWebcam.click();
		Thread.sleep(3000);
		
		capturePhoto.click();
		Thread.sleep(3000);
		*/
		Thread.sleep(3000);
		

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", browseFromDeskTop);
		
		//browseFromDeskTop.click();
		Thread.sleep(3000);
		
		browse.click();
		Thread.sleep(3000);
		
		try 
		{
			String browser = testUtil.getBrowser();
        	
    		StringSelection ss;
    		
    		if(browser.equalsIgnoreCase("Windows 10"))
    		{
    			 ss = new StringSelection("D:\\GIC_Automation\\GICAutomationBranch\\GICAutomation\\Assets\\Untitled.jpg");
    		}
    		else
    		{
    			 ss = new StringSelection("GICAutomation/Assets/Untitled.jpg");
    		}
    		
	       // StringSelection ss = new StringSelection("D:\\GIC_Automation\\GICAutomationBranch\\GICAutomation\\Assets\\Untitled.jpg");
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	        
	        testUtil.robotClass();
	    } 
		catch (Exception exp) 
		{
	        exp.printStackTrace();
	    }
		
		signatureTab.click();
		Thread.sleep(3000);
		
		captureSignature.click();
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("//div[@id='signature']"));

	    Actions builder = new Actions(driver);
	    Action drawAction = builder.moveToElement(element,16,15) //start points x axis and y axis. 
	              .click()
	              .moveByOffset(70, 60) // 2nd points (x1,y1)
	              .click()
	              .moveByOffset(80, 70)// 3rd points (x2,y2)
	              .doubleClick()
	              .build();
	    		   drawAction.perform();
	    Thread.sleep(3000);
		
		captureSignature1.click(); 
		Thread.sleep(3000);
	}	
	
}

