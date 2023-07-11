package com.nischay.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class CoApplicantKYCDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	
	@FindBy(xpath = "(//*[@class='ng-star-inserted']/app-side-nav-menu-items/div)[3]")
	WebElement CoApplicantKYCDetailsTab;
		
	@FindBy(xpath = "(//*[@class='mat-radio-outer-circle'])[1]")
	WebElement incomeConsideredYes;
	
	@FindBy(xpath = "(//*[@class='mat-radio-outer-circle'])[2]")
	WebElement incomeConsideredNo;
	
	@FindBy(xpath = "(//*[@class='mat-icon material-icons mat-icon-no-color'])[5]")
	WebElement editCoApplicant;
	
	@FindBy(xpath = "(//*[@class='mat-card-content'])[1]/span[1]")
	WebElement applicantName;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[7]/img")
	WebElement AddCoApplicant;	
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])/input")
	WebElement panNo;	
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[8]")
	WebElement enterDetails;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[1]/input")
	WebElement firstName;

	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[2]/input")
	WebElement middleName;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[3]/input")
	WebElement lastName;

	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[4]/input")
	WebElement dob;

	@FindBy(xpath = "(//*[@class='mat-select-trigger'])[1]/div[1]")
	WebElement gender;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[6]/input")
	WebElement aadharNo;
	
	@FindBy(xpath = "(//*[@class='mat-select-trigger'])[2]/div[1]")
	WebElement occupation;
	
	@FindBy(xpath = "(//*[@class='mat-select-trigger'])[3]/div[1]")
	WebElement citizenship;
	
	@FindBy(xpath = "(//*[@class='mat-select-trigger'])[4]/div[1]")
	WebElement eQualification;
	
	@FindBy(xpath = "(//*[@class='mat-select-trigger'])[5]/div[1]/span")
	WebElement religion;
	
	@FindBy(xpath = "(//*[@class='mat-select-trigger'])[6]/div[1]")
	WebElement maritalStatus;
	
	@FindBy(xpath = "(//*[@class='mat-select-trigger'])[7]/div[1]")
	WebElement category;
	
	@FindBy(xpath = "(//*[@class='mat-select-trigger'])[8]/div[1]")
	WebElement relationship;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[9]")
	WebElement save;
	
	@FindBy(xpath = "//app-branch-new-application/div[2]/app-kycdetails/div/div/button[2]")
	WebElement next;
	
	@FindBy(xpath = "//app-branch-new-application/div[2]/app-kycdetails/div/div/button[1]")
	WebElement previous;
	
	public CoApplicantKYCDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
	}

	public void editCoApplicantKYCDetails(String IncomeConsidered, String FirstName, String MiddleName, 
			String LastName, String DateOfBirth, String Gender, String AadharNo,
			String Occupation, String Citizenship, String Education, String Religion, String MaritalStatus, 
			String Category, String Relationship) throws InterruptedException 
	{
			CoApplicantKYCDetailsTab.click();
			Thread.sleep(3000);	
		/*
		 * Boolean valueIs = applicantName.isDisplayed();
		 * System.out.println("Boolean value is :"+valueIs);
		 * 
		 * if(AddCoApplicant.isDisplayed() || editCoApplicant.isDisplayed() ) {
		 * if(editCoApplicant.isDisplayed()) { Thread.sleep(3000);
		 * System.out.println("if loop"); editCoApplicant.click(); } else {
		 * Thread.sleep(3000); System.out.println("else loop");
		 * 
		 * AddCoApplicant.click();
		 * 
		 * panNo.click();
		 * 
		 * panNo.sendKeys("GHUJS0987H");
		 * 
		 * enterDetails.clear(); } } else { System.out.println("TP"); }
		 */
			
			
			editCoApplicant.click();
			Thread.sleep(3000);
			
			if(incomeConsideredYes.isSelected() || incomeConsideredNo.isSelected())	
			{
			 if(IncomeConsidered.contains("Yes"))
			  {
				  incomeConsideredYes.click();
				  Thread.sleep(3000);
			  }
			  else
			  {
				  incomeConsideredNo.click();
				  Thread.sleep(3000);
			  }
			}
			else
			{
				System.out.println("Income considered is already selected");
			}
			
			if(firstName.getAttribute("value").isEmpty())
			  {
				firstName.click();
				firstName.sendKeys(FirstName);
			  }
			  else
			  {
				  System.out.println("firstName Value exists");
			  }
			  
			if(middleName.getAttribute("value").isEmpty())
			  {
				middleName.click();
				middleName.sendKeys(MiddleName);
				Thread.sleep(3000);
			  }
			  else
			  {
				  System.out.println("Middle name value exists");
			  }
			
			if(lastName.getAttribute("value").isEmpty())
			  {
				lastName.click();
				lastName.sendKeys(LastName);
			  }
			  else
			  {
				  System.out.println("last name value exists");
			  }
			
			if(dob.getAttribute("value").isEmpty())
			  {
				dob.click();
				dob.sendKeys(DateOfBirth);
			  }
			  else
			  {
				  System.out.println("date of birth value exists");
			  }
			
			if(gender.getText().length() == 1)
			  {
				  System.out.println("Inside if loop");
				  gender.click();
				  Thread.sleep(3000);
				  
				  List<WebElement> gen = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : gen)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Gender)) 
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
			
			if(aadharNo.getAttribute("value").isEmpty())
			  {
				aadharNo.click();
				aadharNo.sendKeys(AadharNo);
				Thread.sleep(3000);
			  }
			  else
			  {
				  System.out.println("Aadhar No value exists");
			  }
			
		/*
		 * occupation.click(); Thread.sleep(3000); WebElement occupation1 =
		 * driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]"));
		 * occupation1.click();
		 */
			
				
			if(occupation.getText().length() == 1)
			  {
				  System.out.println("Inside occupation if loop");
				  occupation.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> citi = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : citi)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Occupation)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("occupation is selected");
			  }	
			
			if(citizenship.getText().length() == 1)
			  {
				  System.out.println("Inside  citizenship if loop");
				  citizenship.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> citi = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : citi)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Citizenship)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("citizenship is selected");
			  }	
		
			if(eQualification.getText().length() == 1)
			  {
				  System.out.println("Inside eQualification if loop");
				  eQualification.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> edu = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : edu)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Education)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("Education is selected");
			  }	
		
			if(religion.getText().length() == 1)
			  {
				  System.out.println("Inside religion if loop");
				  Thread.sleep(2000);
				  
				   Actions action = new Actions(driver);
				  action.moveToElement(religion).click().perform();
				  
				 				  
				  List<WebElement> rel = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : rel)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Religion)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("Religion is selected");
			  }	
		
			if(maritalStatus.getText().length() == 1)
			  {
				  System.out.println("Inside maritalStatus if loop");
				  maritalStatus.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> mar = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : mar)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(MaritalStatus)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("Marital Status is selected");
			  }	
			
			if(category.getText().length() == 1)
			  {
				  System.out.println("Inside category if loop");
				  category.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> cat = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : cat)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Category)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("category is selected");
			  }	
			if(relationship.getText().length() == 1)
			  {
				  System.out.println("Inside relationship if loop");
				  relationship.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> cat = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : cat)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Relationship)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("relationship is selected");
			  }	
		/*
		 * relationship.click(); Thread.sleep(3000); WebElement relationship1 =
		 * driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]"));
		 * relationship1.click();
		 */
		
		save.click();
		Thread.sleep(3000);
	}

	public void addCoApplicantKYCDetails(String PanNo, String IncomeConsidered, String FirstName, String MiddleName, 
			String LastName, String DateOfBirth, String Gender, String AadharNo,
			String Occupation, String Citizenship, String Education, String Religion, String MaritalStatus, 
			String Category, String Relationship) throws InterruptedException 
	{
			CoApplicantKYCDetailsTab.click();
			Thread.sleep(3000);	
		/*
		 * Boolean valueIs = applicantName.isDisplayed();
		 * System.out.println("Boolean value is :"+valueIs);
		 * 
		 * if(AddCoApplicant.isDisplayed() || editCoApplicant.isDisplayed() ) {
		 * if(editCoApplicant.isDisplayed()) { Thread.sleep(3000);
		 * System.out.println("if loop"); editCoApplicant.click(); } else {
		 * Thread.sleep(3000); System.out.println("else loop");
		 * 
		 * AddCoApplicant.click();
		 * 
		 * panNo.click();
		 * 
		 * panNo.sendKeys("GHUJS0987H");
		 * 
		 * enterDetails.clear(); } } else { System.out.println("TP"); }
		 */
			List<WebElement> list = driver.findElements(By.xpath("(//*[@class='not-selected-co-applicants mat-card'])"));
			  Thread.sleep(2000);
			  System.out.println("List is : "+list.size());
			  int size = list.size();
			  
			  System.out.println("List size is :" +size);
			  
			  Actions action = new Actions(driver);
			  WebElement panNo = null;
			  int i=0;
			  if(size>=0)
			  { 
				AddCoApplicant.click();
				Thread.sleep(3000);
					
				for(i=size; i<=3; i++)
				{
				System.out.println("Inside co-applicant loop");
				
				panNo = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix'])["+i+"]/input"));
				action.moveToElement(panNo).click().perform();
				
				System.out.println("WebElement is :" +panNo);
				break;
				}
			  }
			  else 
			  {
				System.out.println("User can add maximum "+size+1+" co-applicants");  
			  }
			  
			
			panNo.sendKeys(PanNo);
			Thread.sleep(3000);
			
			int j=i+6;
			//enterDetails.click(); 
			action.moveToElement(driver.findElement(By.xpath("(//*[@class='mat-button-wrapper'])["+j+"]"))).click().perform();
			Thread.sleep(3000);
			
			if(incomeConsideredYes.isSelected() || incomeConsideredNo.isSelected())	
			{
			 if(IncomeConsidered.contains("Yes"))
			  {
				  incomeConsideredYes.click();
				  Thread.sleep(3000);
			  }
			  else
			  {
				  incomeConsideredNo.click();
				  Thread.sleep(3000);
			  }
			}
			else
			{
				System.out.println("Income considered is already selected");
			}
			
			if(firstName.getAttribute("value").isEmpty())
			  {
				firstName.click();
				firstName.sendKeys(FirstName);
				Thread.sleep(3000);
				
				firstName.sendKeys(Keys.TAB);
				Thread.sleep(3000);
				
				if(firstName.getAttribute("value").matches("^[a-zA-Z\\s]*$"))
				{
					System.out.println("firstName  is valid");
				}
				else
				{
					System.out.println("firstName is invalid");
				}
				Thread.sleep(3000);
			  }
			  else
			  {
				  System.out.println("firstName Value exists");
			  }
			 
			if(middleName.getAttribute("value").isEmpty())
			  {
				middleName.click();
				middleName.sendKeys(MiddleName);
				Thread.sleep(3000);
				
				middleName.sendKeys(Keys.TAB);
				Thread.sleep(3000);
				
				if(middleName.getAttribute("value").matches("^[a-zA-Z\\s]*$"))
				{
					System.out.println("middleName  is valid");
				}
				else
				{
					System.out.println("middleName is invalid");
				}
				Thread.sleep(3000);
			  }
			  else
			  {
				  System.out.println("Middle name value exists");
			  }
			
			if(lastName.getAttribute("value").isEmpty())
			  {
				lastName.click();
				lastName.sendKeys(LastName);
				Thread.sleep(3000);
				
				lastName.sendKeys(Keys.TAB);
				Thread.sleep(3000);
				
				if(lastName.getAttribute("value").matches("^[a-zA-Z\\s]*$"))
				{
					System.out.println("lastName  is valid");
				}
				else
				{
					System.out.println("lastName is invalid");
				}
				Thread.sleep(3000);
				
			  }
			  else
			  {
				  System.out.println("last name value exists");
			  }
			
			if(dob.getAttribute("value").isEmpty())
			  {
				dob.click();
				dob.sendKeys(DateOfBirth);
				Thread.sleep(3000);
			  }
			  else
			  {
				  System.out.println("date of birth value exists");
			  }
			
			if(gender.getText().length() == 1)
			  {
				  System.out.println("Inside if loop");
				  gender.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> gen = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : gen)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Gender)) 
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
			
			if(aadharNo.getAttribute("value").isEmpty())
			  {
				aadharNo.click();
				aadharNo.sendKeys(AadharNo);
				Thread.sleep(3000);
				
				aadharNo.sendKeys(Keys.TAB);
				
				if(aadharNo.getAttribute("value").matches("^[0-9]{12}$"))
				{
					System.out.println("aadharNo  is valid");
				}
				else
				{
					System.out.println("aadharNo is invalid");
				}
				Thread.sleep(3000);
			  }
			  else
			  {
				  System.out.println("Aadhar No value exists");
			  }
		
			if(occupation.getText().length() == 1)
			  {
				  System.out.println("Inside occupation if loop");
				  occupation.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> citi = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : citi)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Occupation)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("occupation is selected");
			  }	
			
			if(citizenship.getText().length() == 1)
			  {
				  System.out.println("Inside  citizenship if loop");
				  citizenship.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> citi = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : citi)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Citizenship)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("citizenship is selected");
			  }	
		
			if(eQualification.getText().length() == 1)
			  {
				  System.out.println("Inside eQualification if loop");
				  eQualification.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> edu = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : edu)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Education)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("Education is selected");
			  }	
		
			if(religion.getText().length() == 1)
			  {
				  System.out.println("Inside religion if loop");
				  Thread.sleep(2000);
				  
				   Actions action1 = new Actions(driver);
				  action1.moveToElement(religion).click().perform();
				  
				 List<WebElement> rel = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : rel)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Religion)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("Religion is selected");
			  }	
			
		
			if(maritalStatus.getText().length() == 1)
			  {
				  System.out.println("Inside maritalStatus if loop");
				  maritalStatus.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> mar = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : mar)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(MaritalStatus)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("Marital Status is selected");
			  }	
			
			if(category.getText().length() == 1)
			  {
				  System.out.println("Inside category if loop");
				  category.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> cat = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : cat)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Category)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("category is selected");
			  }	
			
			if(relationship.getText().length() == 1)
			  {
				  System.out.println("Inside relationship if loop");
				  relationship.click();
				  Thread.sleep(2000);
				  
				  List<WebElement> cat = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
				  Thread.sleep(2000);
						  
			  for (WebElement ele : cat)
			  {
		         System.out.println("Values " + ele.getAttribute("innerHTML"));
		  
		          if (ele.getAttribute("innerHTML").contains(Relationship)) 
		          {
		              ele.click();
		              break;
		          }
			  }
			  }
			  else
			  {
				  System.out.println("Inside else loop");
				  System.out.println("relationship is selected");
			  }	
		
		/*
		 * relationship.click(); Thread.sleep(3000); WebElement relationship1 =
		 * driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]"));
		 * relationship1.click();
		 */
		
		save.click();
		Thread.sleep(5000);
	}
}

