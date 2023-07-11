package com.nischay.qa.pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class ApplicantCorrespondenceDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	
	@FindBy(xpath = "(//*[@class='ng-star-inserted'])[6]/app-side-nav-sub-menu-items/div/span")
	WebElement CorrDetailsTab;
	
	@FindBy(xpath = "(//*[@class='mat-select-value'])[1]")
	WebElement countryCode;

	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[2]/input")
	WebElement mobileNo;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-wrapper']/div)[10]/div/input")
	WebElement alternateMobileNo;
	
	
	@FindBy(xpath = "(//*[@class='mat-form-field-wrapper']/div)[10]/div/input")
	WebElement alternateMobileNoError;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[5]/input")
	WebElement landline;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-subscript-wrapper']/div/mat-error/span)[2]")
	WebElement landlineNoError;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix'])[6]/input")
	WebElement emailId;
	
	@FindBy(xpath = "(//*[@class=\"mat-select-trigger\"]/div/span)[2]")
	WebElement addressType;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[6]")
	WebElement houseNo;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[7]")
	WebElement address;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[8]")
	WebElement landmark;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[9]")
	WebElement locality;
	
	@FindBy(xpath = "(//*[@class=\"mat-form-field-infix\"]/input)[10]")
	WebElement pinCode;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-subscript-wrapper'])[12]")
	WebElement pinCodeError;
	
	@FindBy(xpath = "(//*[@class=\\\"mat-form-field-infix\\\"]/input)[11]")
	WebElement city;
	
	@FindBy(xpath = "//*[@id=\"mat-select-23\"]/div/div[1]/span")
	WebElement state;
	
	@FindBy(xpath = "(//*[@class='mat-radio-outer-circle'])[1]")
	WebElement permanent;
	
	@FindBy(xpath = "(//*[@class='mat-radio-outer-circle'])[2]")
	WebElement current;
	
	@FindBy(linkText = "Verify Address")
	WebElement verifyAddress;
	
	@FindBy(xpath = "//*[@class='mat-raised-button primary-button full-width']")
	WebElement authenticate;
	
	@FindBy(xpath = "(//*[@class='full-width primary-button center-align mat-raised-button mat-primary'])/span")
	WebElement update;
	
	@FindBy(xpath = "//*[@id=\"mat-radio-14\"]/label/div[1]/div[1]")
	WebElement edit;
	
	@FindBy(xpath = "//*[@id=\"mat-radio-14\"]/label/div[1]/div[1]")
	WebElement delete;
	
	@FindBy(xpath = "//app-correspondence-details/div[3]/div/button[3]/span")
	WebElement save;
	
	@FindBy(xpath = "//app-correspondence-details/div[3]/div/button[2]")
	WebElement next;
	
	@FindBy(xpath = "//app-correspondence-details/div[3]/div/button[1]/span")
	WebElement previous;
	
	
	public ApplicantCorrespondenceDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}

	
	public void enterCorrespondenceDetails(String CountryCode, String MobileNo, String AlternateMobileNo, String Landline, String EmailId,
			String AddressType, String HouseNo, String Address, String Landmark, String Locality, String Pincode, String CorrAddr) throws InterruptedException 
	{
		CorrDetailsTab.click();
		
		System.out.println("Country code is"+countryCode.getText().length());
		
		/*if(countryCode.getText().length() == 1)
		  {
			  System.out.println("Inside Country Code if loop");
			  countryCode.click();
			  
			  Actions action = new Actions(driver);
			  action.doubleClick(countryCode).build().perform();
			  Thread.sleep(4000);
			  
			  System.out.println("Clicked on country code");
			  Thread.sleep(4000);
			  
			  List<WebElement> cc = driver.findElements(By.xpath("//div[@class='cdk-overlay-pane']/div/mat-option/span"));
			  System.out.println("List is "+cc);
			  Thread.sleep(3000);
					  
		  for (WebElement ele : cc)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(CountryCode)) 
	          {
	              ele.click();
	              break;
	          }
		  }
		  }
		  else
		  {
			  System.out.println("Inside else loop");
			  System.out.println("CountryCode is selected");
		  }	*/
		
		System.out.println("Is enabled :"+mobileNo.isEnabled());
		System.out.println("Is get Attribute :"+mobileNo.getAttribute("value"));
		
		WebElement vText = driver.findElement(By.xpath("//*[@class='verified-text']"));
		
		if(!vText.isDisplayed())
		{
		if(mobileNo.getAttribute("value").isEmpty())
		  {
			mobileNo.click();
			mobileNo.sendKeys(MobileNo);
			Thread.sleep(3000);
			
			mobileNo.sendKeys(Keys.TAB);
						
			if(mobileNo.getAttribute("value").matches("^[0-9]{10}$"))
			{
				System.out.println("mobileNo  is valid");
			}
			else
			{
				System.out.println("mobileNo is invalid");
			}
			Thread.sleep(3000);
			
		  }
		  else
		  {
			  System.out.println("mobileNo Value exists");
		  }
		}
		else
		{
			System.out.println("Mobile No is not editable");
		}
		
		if(alternateMobileNo.getAttribute("value").isEmpty())
		  {
			alternateMobileNo.click();
			alternateMobileNo.sendKeys(AlternateMobileNo);
			Thread.sleep(3000);
			
			alternateMobileNo.sendKeys(Keys.TAB);
						
			if(alternateMobileNo.getAttribute("value").matches("^[0-9]{10}$"))
			{
				System.out.println("alternateMobileNo is valid");
			}
			else
			{
				System.out.println("alternateMobileNo is invalid");
			}
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("AlternateMobileNo Value exists");
		  }
		
		
		
		if(landline.getAttribute("value").isEmpty())
		  {
			landline.click();
			landline.sendKeys(Landline);
		  }
		  else
		  {
			  System.out.println("landline Value exists");
		  }
		
		if(emailId.getAttribute("value").isEmpty())
		  {
			emailId.click();
			emailId.sendKeys(EmailId);
		  }
		  else
		  {
			  System.out.println("emailId Value exists");
		  }
		
		if(addressType.getText().length() == 1)
		  {
			  System.out.println("Inside addressType Code if loop");
			  addressType.click();
			  Thread.sleep(2000);
			  
			  List<WebElement> at = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
			  Thread.sleep(2000);
					  
		  for (WebElement ele : at)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(AddressType)) 
	          {
	              ele.click();
	              break;
	          }
	          else 
	          {
	        	  System.out.println("Selected address type is already added on Correspondence screen ");
	          }
		  }
		  }
		  else
		  {
			  System.out.println("Inside else loop");
			  System.out.println("addressType is selected");
		  }	
		
		/*
		 * addressType.click(); WebElement value =
		 * driver.findElement(By.xpath("//*[@id=\"mat-option-32\"]/span"));
		 * value.click();
		 */
		
		if(houseNo.getAttribute("value").isEmpty())
		  {
			houseNo.click();
			houseNo.sendKeys(HouseNo);
		  }
		  else
		  {
			  System.out.println("HouseNo Value exists");
		  }
		
		  if(address.getAttribute("value").isEmpty())
		  {
			  address.click();
			  address.sendKeys(Address);
		  }
		  else
		  {
			  System.out.println("Address Value exists");
		  }
		
		  if(landmark.getAttribute("value").isEmpty())
		  {
			  Actions action = new Actions(driver);
			  action.moveToElement(landmark).click().perform();
			  landmark.sendKeys(Landmark);
		  }
		  else
		  {
			  System.out.println("Landmark Value exists");
		  }
		
		  if(locality.getAttribute("value").isEmpty())
		  {
			  locality.click();
			  locality.sendKeys(Locality);
		  }
		  else
		  {
			  System.out.println("Locality Value exists");
		  }
		  
				
		if(pinCode.getAttribute("value").isEmpty())
		  {
			pinCode.click();
			pinCode.sendKeys(Pincode);
			Thread.sleep(5000);
			
			pinCode.sendKeys(Keys.TAB);
						
			if(pinCode.getAttribute("value").matches("^[0-9]{6}$"))
			{
				System.out.println("pinCode  is valid");
			}
			else
			{
				System.out.println("pinCode is invalid");
			}
			Thread.sleep(3000);
			
		  }
		  else
		  {
			  System.out.println("Pincode Value exists");
		  }
		
		/*if(permanent.isSelected() || current.isSelected())	
		{
			System.out.println("Inside if loop of corr addr");
		 if(CorrAddr.contains("Permanent"))
		  {
			 permanent.click();
			  Thread.sleep(3000);
		  }
		  else
		  {
			  current.click();
			  Thread.sleep(3000);
		  }
		}
		else
		{
			System.out.println("Selected");
		}*/
		
		verifyAddress.click();
		Thread.sleep(3000);
		System.out.println("Clicked on verify address");
		
		Actions action = new Actions(driver);
		action.doubleClick(authenticate).build().perform();
		
		Thread.sleep(3000);
		System.out.println("Clicked on authenticate");
		
		update.click();
		Thread.sleep(5000);
		
		save.click();
		Thread.sleep(5000);
	}
	
	public void validateAlternateMobileNo() throws InterruptedException
	{
		alternateMobileNo.sendKeys("namrata2345");
		alternateMobileNo.sendKeys(Keys.TAB);
		String s = alternateMobileNoError.getText();
		Pattern pattern = Pattern.compile("[0-9]{10}");
		Matcher matcher = pattern.matcher(s);
		// Check if pattern matches
		if (matcher.matches()) {
			System.out.println("Test case Pass");
		}else
			{
			alternateMobileNoError.getText();
			System.out.println("Error" + alternateMobileNoError.getText());
			
			}
	}
		
		public void validateLandlineNo() throws InterruptedException
		{
			alternateMobileNo.sendKeys("namrata2345");
			alternateMobileNo.sendKeys(Keys.TAB);
			String s = landlineNoError.getText();
			Pattern pattern = Pattern.compile("[0-9]{10}");
			Matcher matcher = pattern.matcher(s);
			// Check if pattern matches
			if (matcher.matches()) {
				System.out.println("Test case Pass");
			}else
				{
				landlineNoError.getText();
				System.out.println("Error" + landlineNoError.getText());
				
				}
			
	}
		public void validatePincode() throws InterruptedException
		{
			
			// how to check valid or invalid pincode
			
			alternateMobileNo.sendKeys("4562893");
			alternateMobileNo.sendKeys(Keys.TAB);
			String s = pinCodeError.getText();
			Pattern pattern = Pattern.compile("[0-9]{6}");
			Matcher matcher = pattern.matcher(s);
			// Check if pattern matches
			if (matcher.matches()) {
				System.out.println("Test case Pass");
			}else
				{
				pinCodeError.getText();
				System.out.println("Error" + pinCodeError.getText());
				}
	}
}

