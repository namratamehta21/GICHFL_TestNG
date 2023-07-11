package com.nischay.qa.pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class ApplicantKYCDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	
	@FindBy(xpath = "(//div[@class='ng-star-inserted']/app-side-nav-sub-menu-items/div/span)[1]")
	WebElement KYCDetailsTab;
	
	@FindBy(xpath = "(//*[@class='mat-radio-outer-circle'])[1]")
	WebElement incomeConsideredYes;
	
	@FindBy(xpath = "(//*[@class='mat-radio-outer-circle'])[2]")
	WebElement incomeConsideredNo;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[1]/input")
	WebElement firstName;

	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[2]/input")
	WebElement middleName;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[3]/input")
	WebElement lastName;

	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[4]/input")
	WebElement dob;

	@FindBy(xpath = "(//div[@class='mat-select-value'])[1]/span")
	WebElement gender;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[6]/input")
	WebElement aadharNo;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[2]/span")
	WebElement occupation;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[3]/span")
	WebElement citizenship;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[4]/span")
	WebElement eQualification;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[5]/span")
	WebElement religion;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[6]/span")
	WebElement maritalStatus;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[7]/span")
	WebElement category;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[8]")
	WebElement save;
	
	@FindBy(xpath = "//app-branch-new-application/div[2]/app-kycdetails/div/div/button[2]")
	WebElement next;
	
	@FindBy(xpath = "//app-branch-new-application/div[2]/app-kycdetails/div/div/button[1]")
	WebElement previous;
	
	@FindBy(xpath = "//*[@id=\"mat-error-4\"]/span")
	WebElement aadharNoError;
	
	@FindBy(xpath = "//*[@id=\"mat-error-0\"]/span")
	WebElement fnameError;

	@FindBy(xpath = "//*[@id=\"mat-error-2\"]/span")
	WebElement lnameError;
	
	public ApplicantKYCDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
	}

	public void enterKYCDetails(String IncomeConsidered, String FirstName, String MiddleName, String LastName, String DateOfBirth, String Gender, String AadharNo,
			String Occupation, String Citizenship, String Education, String Religion, String MaritalStatus, String Category) throws InterruptedException 
	{
		Thread.sleep(3000);
		
		KYCDetailsTab.click();
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
		
		System.out.println("Firstname is "+(firstName.getAttribute("value")));
		System.out.println("Firstname text is "+(firstName.getText()));
		System.out.println("Firstname length is "+(FirstName.length()));
		
		
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
		
		/*
		if(!gender.isSelected())
		{
			Select gen = new Select(gender);
			gen.selectByValue("Female");
		}*/
		
		if(aadharNo.getAttribute("value").isEmpty())
		  {
			aadharNo.click();
			Thread.sleep(3000);
			aadharNo.sendKeys(AadharNo);
			Thread.sleep(3000);
			
			aadharNo.sendKeys(Keys.TAB);
			Thread.sleep(3000);
			
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
		
		/*
		 * citizenship.click(); Thread.sleep(3000); WebElement value =
		 * driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]"));
		 * value.click();
		 */
		
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
		
		
		/*
		 * eQualification.click(); Thread.sleep(3000); WebElement value1 =
		 * driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]"));
		 * value1.click();
		 */
		
		
		if(religion.getText().length() == 1)
		  {
			  System.out.println("Inside religion if loop");
			  Thread.sleep(2000);
			  
			   Actions action = new Actions(driver);
			  action.moveToElement(religion).click().perform();
			  
			  religion.click();
			  Thread.sleep(2000);
			  
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
		
		/*
		 * religion.click(); Thread.sleep(3000); WebElement value2 =
		 * driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]"));
		 * value2.click();
		 */
		
		
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
		
		/*
		 * maritalStatus.click(); Thread.sleep(3000); WebElement value3 =
		 * driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]"));
		 * value3.click();
		 */
			
		
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
		
		/*
		 * category.click(); Thread.sleep(3000); WebElement value4 =
		 * driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]"));
		 * value4.click();
		 */
		
		save.click();
		Thread.sleep(3000);
		
	}
	
	public void validatefirstName() throws InterruptedException
	{
		
		firstName.sendKeys("namrata.mehta");
		firstName.sendKeys(Keys.TAB);
		String s = aadharNo.getText();
		Pattern pattern = Pattern.compile("/^[a-zA-Z]+ [a-zA-Z]+$/");
		Matcher matcher = pattern.matcher(s);
		// Check if pattern matches
		if (matcher.matches()) {
			System.out.println("Test case Pass");
		}else
			{
			fnameError.getText();
			System.out.println("Error" + fnameError.getText());
			
			}
	}
	
	public void validatelastName() throws InterruptedException
	{
		lastName.sendKeys("namrata.mehta");
		lastName.sendKeys(Keys.TAB);
		String s = aadharNo.getText();
		Pattern pattern = Pattern.compile("/^[a-zA-Z]+ [a-zA-Z]+$/");
		Matcher matcher = pattern.matcher(s);
		// Check if pattern matches
		if (matcher.matches()) {
			System.out.println("Test case Pass");
		}else
			{
			lnameError.getText();
			System.out.println("Error" + lnameError.getText());
			
			}
	}
	
	public void validateAadhanNo() throws InterruptedException 
	{
		aadharNo.sendKeys("876589");
		aadharNo.sendKeys(Keys.TAB);
		String s = aadharNo.getText();
		Pattern pattern = Pattern.compile("^[0-9]{12}$");
		Matcher matcher = pattern.matcher(s);
		// Check if pattern matches
		if (matcher.matches()) {
			System.out.println("Test case Pass");
		}else
			{
			aadharNoError.getText();
			System.out.println("Error" + aadharNoError.getText());
			
			}
	}
}

