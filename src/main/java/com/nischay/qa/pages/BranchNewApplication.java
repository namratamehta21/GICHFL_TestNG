package com.nischay.qa.pages;

import java.io.File;
import java.io.FileOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class BranchNewApplication extends TestBase {
	TestUtil testUtil;
	

	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[7]")
	WebElement newApplication;

	@FindBy(xpath = "//*[@class='mat-form-field-infix']/input")
	WebElement panNo;
	
	@FindBy(xpath = "//*[@class='applicationId']")
	WebElement applicationID;

	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[6]")
	WebElement enterDetails;

	@FindBy(xpath = "//app-branch-new-application/div[2]/app-kycdetails/div/div/button[3]/span")
	WebElement save;

	@FindBy(xpath = "//app-branch-new-application/div[2]/app-kycdetails/div/div/button[2]")
	WebElement next;

	@FindBy(xpath = "//app-branch-new-application/div[2]/app-kycdetails/div/div/button[1]")
	WebElement previous;

	public BranchNewApplication() {
		PageFactory.initElements(driver, this);
		//branchNewApplication = new BranchNewApplication();
	}

	public void enterNewPanNo(String PanNo) throws InterruptedException 
	{
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		newApplication.click();
		Thread.sleep(3000);
		
		this.getApplicationID();

		panNo.click();
		Thread.sleep(3000);

		panNo.sendKeys(PanNo);
		Thread.sleep(3000);

		enterDetails.click();
		Thread.sleep(3000);
	}
	
	public void getApplicationID()
	{
		try 
		{
			String applicationID1 =applicationID.getText();
			
			System.out.println("DSA Application id is :"+applicationID1);
			
			File file = new File("ApplicationID.txt");
		    FileOutputStream fos = new FileOutputStream(file);

		    byte[] bytesArray = applicationID1.getBytes();

		    fos.write(bytesArray);
			fos.flush();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
		}
	}
}
