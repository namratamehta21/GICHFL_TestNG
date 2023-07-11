package com.nischay.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class LoanDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
		
	@FindBy(xpath = "(//*[@class='ng-star-inserted']/app-side-nav-menu-items/div)[5]")
	WebElement loanDetailsTab;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[1]/span")
	WebElement product;
	
	@FindBy(xpath = "//div/mat-option[@class='mat-option ng-star-inserted mat-selected mat-active']/span")
	WebElement selectProduct;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[2]/span")
	WebElement subProduct;
	
	@FindBy(xpath = "//mat-option[@class='mat-option ng-star-inserted mat-selected mat-active']/span")
	WebElement selectSubProduct;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix']/input)[1]")
	WebElement loanAmount;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix']/input)[2]")
	WebElement loanTenure;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[3]/span")
	WebElement scheme;
	
	@FindBy(xpath = "(//*[@class='mat-option-text'])[1]")
	WebElement selectScheme;
	
	@FindBy(xpath = "(//div[@class='mat-select-value']/span)[4]")
	WebElement morgage;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[8]")
	WebElement save;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[7]")
	WebElement next;
	
	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[6]")
	WebElement previous;
	
	
	
	public LoanDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		//applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}

	
	public void enterLoanDetails(String LoanAmount, String lTenure, String Product, String SubProduct, String Scheme) throws InterruptedException 
	{
		Thread.sleep(2000);
		/*Actions action = new Actions(driver);
		action.moveToElement(loginFeeDetailsTab).moveByOffset(235, 15).click().build().perform();*/
		loanDetailsTab.click();
		Thread.sleep(3000);
		
		if(loanAmount.getAttribute("value").isEmpty())
		  {
			loanAmount.click();
			loanAmount.sendKeys(LoanAmount);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("loanAmount value exists");
		  }
		
		if(loanTenure.getAttribute("value").isEmpty())
		  {
			loanTenure.click();
			loanTenure.sendKeys(lTenure);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("loanTenure value exists");
		  }
		
		  product.click();
		  Thread.sleep(2000);
		  List<WebElement> list = driver.findElements(By.xpath("//*[@class='cdk-overlay-pane']/div/mat-option/span"));
		  Thread.sleep(2000);
	  
		  for (WebElement ele : list)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(Product)) 
	          {
	              ele.click();
	              break;
	          }
		  }
		  
		  Actions builder = new Actions(driver);
		  builder.moveToElement(subProduct).click().build().perform();
		  
		 // JavascriptExecutor executor = (JavascriptExecutor)driver;
		  //executor.executeScript("arguments[0].click();", subProduct);
		  
		  //subProduct.click();
		  Thread.sleep(3000);
		  List<WebElement> subProductList = driver.findElements(By.xpath("//*[@class='cdk-overlay-pane']/div/mat-option/span"));
		  Thread.sleep(3000);
	  
		  for (WebElement ele : subProductList)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(SubProduct)) 
	          {
	              ele.click();
	              break;
	          }
		  }
	
		  Actions builder1 = new Actions(driver);
		  builder1.moveToElement(scheme).click().build().perform();
		     		     
		  //JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		  //executor1.executeScript("arguments[0].click();", scheme);
		  
		  //scheme.click();
		  Thread.sleep(2000);
		  List<WebElement> schemeList = driver.findElements(By.xpath("//*[@class='cdk-overlay-pane']/div/mat-option/span"));
		  Thread.sleep(2000);
	  
		  for (WebElement ele : schemeList)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(Scheme)) 
	          {
	              ele.click();
	              break;
	          }
		  }
		
				
		 //scheme.click();
		//selectScheme.click();
		Thread.sleep(3000);
			
		save.click();
		Thread.sleep(3000);
	}	
	
}

