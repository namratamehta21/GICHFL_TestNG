package com.nischay.qa.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class IncomeAssessmentEnterDetailsPage extends TestBase {

	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;

	/*
	 * @FindBy(xpath = "(//div[@class='menu-item-name'])[4]/span/img") WebElement
	 * incomeAssessmentTab;
	 */
	
	@FindBy(xpath = "(//div[@class='ng-star-inserted'])[13]/app-side-nav-menu-items/div[1]")
	WebElement incomeAssessmentTab;

	@FindBy(xpath = "(//div[@class='ng-star-inserted'])[8]/app-side-nav-sub-menu-items/div/span")
	WebElement enterDetails;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[6]")
	WebElement addAccount;

	@FindBy(xpath = "(//span[@class='mat-content'])")
	WebElement enterDetailSection;

	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[3]")
	WebElement generateLink;

	@FindBy(xpath = "(//*[@class='mat-form-field-infix']/input)[3]")
	WebElement statementStartDate;

	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[4]/input")
	WebElement statementEndDate;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[8]")
	WebElement sendLink;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[9]")
	WebElement resendLink;

	@FindBy(xpath = "(//*[@class=\"mat-radio-container\"])[2]/div")
	WebElement uploadScannedStatement;

	@FindBy(xpath = "(//*[@class='mat-radio-container'])[3]")
	WebElement uploadEStatement1;

	@FindBy(xpath = "(//div[@class='mat-select-value'])/span")
	WebElement institute;

	@FindBy(xpath = "(//span[@class='mat-option-text'])[56]")
	WebElement instituteSelect;

	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[6]/input")
	WebElement pdf;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[8]")
	WebElement upload;

	@FindBy(xpath = "(//*[@class='mat-raised-button primary-button'])[3]")
	WebElement save;

	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[11]")
	WebElement next;

	@FindBy(xpath = "(//*[@class=\"mat-button-wrapper\"])[15]")
	WebElement previous;

	public IncomeAssessmentEnterDetailsPage() {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		// applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}

	public void enterDetailsInIncomeAssessment(String UploadType, String UploadTypeForCoApp1, 
			String UploadTypeForCoApp2, String UploadTypeForCoApp3) throws InterruptedException 
	{

		incomeAssessmentTab.click(); 
		Thread.sleep(3000);
		
		enterDetails.click();
		Thread.sleep(3000);
		
		  List<WebElement> list = driver.findElements(By.xpath("(//*[@class='mat-tab-labels'])[1]/div/div"));
		  Thread.sleep(2000);
		  
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  int size = list.size();
		  System.out.println("Size is : "+size);
		  WebElement tabs;
		  int i=0;
		  if(size>=0)
		  { 
			  for(i=1; i<=size; i++)
				{
				  	System.out.println("Adding account for : "+i);
				  	Thread.sleep(3000);
				  	
				  	tabs = driver.findElement(By.xpath("((//*[@class='mat-tab-label-container'])[1]/div/div/div/div)["+i+"]"));
				  	Thread.sleep(3000);
				  	
				  	js.executeScript("arguments[0].click();", tabs);
					Thread.sleep(3000);
					
					addAccount.click(); 
					Thread.sleep(3000);
					
					enterDetailSection.click(); 
					Thread.sleep(3000);
					
					System.out.println("Value of i is :"+i);
					if(i==1) //For applicant
					{
						System.out.println("Inside if loop 1");
						if(UploadType.contains("Generate Link"))
						{
							System.out.println("Generate link selected for applicant");
							//this.generateLink();
						
							generateLink.click(); 
							Thread.sleep(3000);
						}
						else if(UploadType.contains("Upload Scanned Statement "))
						{
							System.out.println("Upload Scanned selected");
							this.uploadScannedStatement();
							
						}
						else if(UploadType.contains("Upload E-Statement"))
						{
							System.out.println("Upload E-statement selected");
							this.uploadEStatement();
						}
						else
						{
							System.out.println("No option selected1");
						}
					}
					else
					{
						System.out.println("Invalid selection for applicant");
					}
					
					if(i==2) //For 1st co-applicant
					{
						System.out.println("Inside if loop 2");
						if(UploadTypeForCoApp1.contains("Generate Link"))
						{
							System.out.println("Generate link selected for co-applicant");
							//this.generateLink();
						
							generateLink.click(); 
							Thread.sleep(3000);
						}
						else if(UploadTypeForCoApp1.contains("Upload Scanned Statement "))
						{
							System.out.println("Upload Scanned selected");
							this.uploadScannedStatement();
						}
						else if(UploadTypeForCoApp1.contains("Upload E-Statement"))
						{
							System.out.println("Upload E-statement selected");
							this.uploadEStatement();
						}
						else
						{
							System.out.println("No option selected 2");
						}
					}
					else
					{
						System.out.println("Invalid selection for Co-applicant2");
					}
					
					if(i==3) //For 1st co-applicant
					{
						System.out.println("Inside if loop 3");
						if(UploadTypeForCoApp2.contains("Generate Link"))
						{
							System.out.println("Generate link selected for co-applicant");
							//this.generateLink();
						
							generateLink.click(); 
							Thread.sleep(3000);
						}
						else if(UploadTypeForCoApp2.contains("Upload Scanned Statement 3"))
						{
							System.out.println("Upload Scanned selected");
							this.uploadScannedStatement();
						}
						else if(UploadTypeForCoApp2.contains("Upload E-Statement3"))
						{
							System.out.println("Upload E-statement selected3");
							this.uploadEStatement();
						}
						else
						{
							System.out.println("No option selected 3");
						}
					}
					else
					{
						System.out.println("Invalid selection for Co-applicant 3");
					}
					
					if(i==4) //For 3rd co-applicant
					{
						System.out.println("Inside if loop 4");
						if(UploadTypeForCoApp3.contains("Generate Link"))
						{
							System.out.println("Generate link selected for co-applicant4");
							//this.generateLink();
						
							generateLink.click(); 
							Thread.sleep(3000);
						}
						else if(UploadTypeForCoApp3.contains("Upload Scanned Statement"))
						{
							System.out.println("Upload Scanned selected4");
							this.uploadScannedStatement();
						}
						else if(UploadTypeForCoApp3.contains("Upload E-Statement"))
						{
							System.out.println("Upload E-statement selected4");
							this.uploadEStatement();
						}
						else
						{
							System.out.println("No option selected 4");
						}
					}
					else
					{
						System.out.println("Invalid selection for Co-applicant 3");
					}
				}
		  }
		  else
		  {
			  System.out.println("Something went wrong");
		  }
		  
		  next.click();
		  Thread.sleep(6000);
	}

	/*
	 * public void generateLink() throws InterruptedException { Thread.sleep(3000);
	 * 
	 * incomeAssessmentTab.click(); Thread.sleep(3000);
	 * 
	 * addAccount.click(); Thread.sleep(3000);
	 * 
	 * enterDetailSection.click(); Thread.sleep(3000);
	 * 
	 * generateLink.click(); Thread.sleep(3000);
	 * 
	 * DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); Calendar cal =
	 * Calendar.getInstance(); cal.add(Calendar.DAY_OF_YEAR, -300); Date
	 * previousDate = cal.getTime(); String result =
	 * dateFormat.format(previousDate); System.out.println(result);
	 * Thread.sleep(3000);
	 * 
	 * statementStartDate.click(); Thread.sleep(3000);
	 * 
	 * statementStartDate.sendKeys(result); Thread.sleep(3000);
	 * 
	 * Date date = new Date(); String result1 = dateFormat.format(date);
	 * System.out.println(result1);
	 * 
	 * statementEndDate.click(); Thread.sleep(3000);
	 * 
	 * statementEndDate.sendKeys(result1); Thread.sleep(3000);
	 * 
	 * sendLink.click(); Thread.sleep(3000);
	 * 
	 * save.click(); Thread.sleep(3000); }
	 */

	
	  public void uploadScannedStatement() throws InterruptedException 
	  {
		  Thread.sleep(3000);
		  
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", uploadScannedStatement);
			Thread.sleep(3000);
	 
		  //uploadScannedStatement.click(); 
		 // Thread.sleep(3000);
	 
		  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		  Calendar cal = Calendar.getInstance(); 
		  cal.add(Calendar.DAY_OF_YEAR, -300); 
		  Date previousDate = cal.getTime(); 
		  String result = dateFormat.format(previousDate); 
		  System.out.println(result);
		  Thread.sleep(3000);
	  
		  statementStartDate.click(); 
		  Thread.sleep(3000);
	  
		  statementStartDate.sendKeys(result); 
		  Thread.sleep(3000);
	  
		  Date date = new Date(); String result1 = dateFormat.format(date);
		  System.out.println(result1);
	  
		  statementEndDate.click(); 
		  Thread.sleep(3000);
	  
		  statementEndDate.sendKeys(result1); 
		  Thread.sleep(3000);
	  
		  institute.click(); 
		  Thread.sleep(3000);
	  
		  instituteSelect.click(); 
		  Thread.sleep(3000);
	  
		  pdf.click(); 
		  Thread.sleep(3000);
	  
		 // pdf.sendKeys("123456"); 
		  Thread.sleep(3000);
	  
		  upload.click(); 
		  Thread.sleep(3000);
	  
		  try 
		  { 
			  String browser = testUtil.getBrowser();
	  
			  StringSelection ss;
	 
			  if(browser.equalsIgnoreCase("Windows 10")) 
			  { 
				  ss = new StringSelection( "D:\\GIC_Automation\\GICAutomationBranch\\GICAutomation\\Assets\\Canarabank.pdf"); 
			  } 
			  else 
			  { 
				  ss = new StringSelection("GICAutomation/Assets/Canarabank.pdf");
			  }
			  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	  
			  testUtil.robotClass(); 
		  } 
		  catch (Exception exp) 
		  { 
			  exp.printStackTrace(); 
		  }
	  
		  //next.click(); 
		  //Thread.sleep(3000); 
	  }
	 

	
	  public void uploadEStatement() throws InterruptedException 
	  {
		  
		  uploadEStatement1.click(); 
		  Thread.sleep(3000);
	 
		  /*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //logic as per functionlity to select date
		  Calendar cal = Calendar.getInstance(); 
		  cal.add(Calendar.DAY_OF_YEAR, -300); 
		  Date previousDate = cal.getTime(); 
		  String result = dateFormat.format(previousDate); 
		  System.out.println(result);
		  Thread.sleep(3000);*/
	 
		  statementStartDate.click(); 
		  Thread.sleep(3000);
	 
		  statementStartDate.sendKeys("01-03-2019"); 
		  Thread.sleep(3000);
	 
		  //Date date = new Date(); String result1 = dateFormat.format(date);
		  //System.out.println(result1);
	 
		  statementEndDate.click(); 
		  Thread.sleep(3000);
	 
		  statementEndDate.sendKeys("30-09-2019"); 
		  Thread.sleep(3000);
	 
		  institute.click(); 
		  Thread.sleep(3000);
	 
		  instituteSelect.click(); 
		  Thread.sleep(3000);
	 
		  pdf.click(); 
		  Thread.sleep(3000);
	 
		 // pdf.sendKeys("123456"); 
		  Thread.sleep(3000);
	 
		  upload.click(); 
		  Thread.sleep(3000);
	 
		  try 
		  { 
			  String browser = testUtil.getBrowser();
	  
			  StringSelection ss;
	 
			  if(browser.equalsIgnoreCase("Windows 10")) 
			  { 
				  ss = new StringSelection("D:\\GIC_Automation\\GICAutomationBranch\\GICAutomation\\Assets\\Canarabank.pdf"); 
			  } 
			  else 
			  { 
				  ss = new StringSelection("GICAutomation/Assets/Canarabank.pdf");
			  }
			  
			  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			  testUtil.robotClass(); Thread.sleep(5000); 
		  }
		  catch (Exception exp) 
		  {  
			  exp.printStackTrace(); 
		  }

	 //next.click(); 
	 //Thread.sleep(3000);
	 }
	 
}
