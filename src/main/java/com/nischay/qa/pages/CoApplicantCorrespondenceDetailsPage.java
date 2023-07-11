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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class CoApplicantCorrespondenceDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	
	@FindBy(xpath = "(//*[@class='ng-star-inserted']/app-side-nav-menu-items/div)[3]")
	WebElement CoApplicantTab;
	
	@FindBy(xpath = "(//*[@class='ng-star-inserted'])[24]/div/mat-card/mat-card-content/img[2]")
	WebElement editCoApplicant;
	
	@FindBy(xpath = "(//*[@class='ng-star-inserted'])[7]/app-side-nav-sub-menu-items/div/span")
	WebElement CorrDetailsTab;
	
	@FindBy(xpath = "//*[@class='tick-mark mat-icon material-icons mat-icon-no-color']")
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
	
	@FindBy(xpath = "//*[@id='mat-input-52']")
	WebElement emailId;
	
	@FindBy(xpath = "(//*[@class=\"mat-select-trigger\"]/div/span)[2]")
	WebElement addressType;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix']/input)[6]")
	WebElement houseNo;
	
	@FindBy(xpath = "(//*[@class='mat-form-field-infix']/input)[7]")
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
	
	@FindBy(linkText = "Verify Address")
	WebElement verifyAddress;
	
	@FindBy(xpath = "//*[@id=\"map-authenticate-button\"]/button/span")
	WebElement authenticate;
	
	@FindBy(xpath = "//*[@id=\"mat-radio-14\"]/label/div[1]/div[1]")
	WebElement edit;
	
	@FindBy(xpath = "//*[@id=\"mat-radio-14\"]/label/div[1]/div[1]")
	WebElement delete;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[6]")
	WebElement update;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[9]")
	WebElement save;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[8]")
	WebElement next;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[7]")
	WebElement previous;
	
	
	public CoApplicantCorrespondenceDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}

	
	public void enterCorrespondenceDetails(String MobileNo, String AlternateMobileNo, String Landline, String AddressType, String HouseNo, String Address, String Landmark, String Locality, String Pincode) throws InterruptedException 
	{
		CoApplicantTab.click();
		Thread.sleep(3000);
		
		/*
		 * editCoApplicant.click(); Thread.sleep(3000);
		 */
		
		CorrDetailsTab.click();
		Thread.sleep(3000);
		
		if(mobileNo.getAttribute("value").isEmpty())
		  {
			mobileNo.click();
			mobileNo.sendKeys(MobileNo);
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
			  System.out.println("mobileNo value exists");
		  }
		
		if(alternateMobileNo.getAttribute("value").isEmpty())
		  {
			alternateMobileNo.click();
			alternateMobileNo.sendKeys(AlternateMobileNo);
			alternateMobileNo.sendKeys(Keys.TAB);
						
			if(alternateMobileNo.getAttribute("value").matches("^[0-9]{10}$"))
			{
				System.out.println("Alternate no is valid");
			}
			else
			{
				System.out.println("Alternate no is invalid");
			}
					
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("AlternateMobileNo value exists");
		  }
		
		if(landline.getAttribute("value").isEmpty())
		  {
			landline.click();
			landline.sendKeys(Landline);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("Landline value exists");
		  }
		
		
		if(addressType.getText().length() == 1)
		  {
			  System.out.println("Inside addressType Code if loop");
			  addressType.click();
			  Thread.sleep(2000);
			  
			  List<WebElement> at = driver.findElements(By.xpath("(//*[@class='mat-option-text'])"));
			  Thread.sleep(2000);
					  
		  for (WebElement ele : at)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(AddressType)) 
	          {
	              ele.click();
	              break;
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
		 * driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[1]"));
		 * value.click();
		 */
		
		
		if(houseNo.getAttribute("value").isEmpty())
		  {
			houseNo.click();
			houseNo.sendKeys(HouseNo);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("HouseNo value exists");
		  }
		
		if(address.getAttribute("value").isEmpty())
		  {
			address.click();
			address.sendKeys(Address);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("Address value exists");
		  }
		
		if(landmark.getAttribute("value").isEmpty())
		  {
			landmark.click();
			landmark.sendKeys(Landmark);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("Address value exists");
		  }	
		
		if(locality.getAttribute("value").isEmpty())
		  {
			locality.click();
			locality.sendKeys(Locality);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("Locality value exists");
		  }
		
		if(pinCode.getAttribute("value").isEmpty())
		  {
			pinCode.click();
			pinCode.sendKeys(Pincode);
			pinCode.sendKeys(Keys.TAB);
						
			if(pinCode.getAttribute("value").matches("^[0-9]{6}$"))
			{
				System.out.println("pinCode no is valid");
			}
			else
			{
				System.out.println("pinCode no is invalid");
			}
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("pinCode value exists");
		  }
		
		verifyAddress.click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1280)");
		Thread.sleep(3000);
		
		
		//System.out.println("Is enabled :"+authenticate.isEnabled());
		//System.out.println("Is displayed :"+authenticate.isDisplayed());
			
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='map-authenticate-button']/button/span")));
		
		Thread.sleep(3000);
		authenticate.click();
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.moveToElement(permanent).click().perform();
		/*
		 * permanent.click(); Thread.sleep(3000);
		 */
		
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

