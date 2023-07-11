package com.nischay.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class IPSOfferLetter extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
		
	@FindBy(xpath = "(//div[@class='ng-star-inserted'])[18]/app-side-nav-menu-items/div")
	WebElement ipsOfferLetterTab;
	
	@FindBy(xpath = "(//span[@class='mat-content'])[1]")
	WebElement loanParticulars;
	
	@FindBy(xpath = "(//span[@class='mat-content'])[2]")
	WebElement termAndConditions;
	
	@FindBy(xpath = "//div[@class='button-container']/app-custom-button/button/span")
	WebElement addConditions;
	
	@FindBy(xpath = "(//button[@class='mat-raised-button primary-button'])[2]/span")
	WebElement writeCondition;
	
	@FindBy(xpath = "(//button[@class='mat-raised-button primary-button'])[2]/span")
	WebElement editCondition;
	
	@FindBy(xpath = "(//button[@class='mat-raised-button primary-button'])[2]/span")
	WebElement deleteCondition;
	
	@FindBy(xpath = "(//button[@class='mat-raised-button primary-button'])[2]/span")
	WebElement downloadPDF;
	
	@FindBy(xpath = "(//div[@class='mat-expansion-panel-body'])[2]")
	WebElement clickAnywhereToSave;
	
	public IPSOfferLetter() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
	}

	
	public void enterIPSOfferLetter() throws InterruptedException 
	{
		ipsOfferLetterTab.click();
		Thread.sleep(3000);
		
		loanParticulars.click();
		Thread.sleep(3000);
		
		termAndConditions.click();
		Thread.sleep(3000);
		
		addConditions.click();
		Thread.sleep(3000);
		
		/*
		 * List<WebElement> rows =
		 * driver.findElements(By.xpath("//div[@class='row ng-star-inserted']"));
		 * System.out.println("No of rows are : " + rows.size());
		 */
        
        WebElement ele = driver.findElement(By.xpath("//textarea[@class='ng-untouched ng-pristine ng-valid']"));
        ele.click();
        Thread.sleep(3000);
        ele.sendKeys("Test conditions");
        
        clickAnywhereToSave.click();
        Thread.sleep(3000);
        
        Thread.sleep(3000);
        editCondition.click();
        Thread.sleep(3000);
        ele.sendKeys("Test conditions1");
        
        downloadPDF.click();
        Thread.sleep(3000);
	}	
	
}

