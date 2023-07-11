package com.nischay.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class PropertyDetailsPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
		
		
	@FindBy(xpath = "(//div[@class='ng-star-inserted'])[19]/app-side-nav-menu-items/div")
	WebElement propertyDetailsTab;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[1]/input")
	WebElement plotArea;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[2]/input")
	WebElement builtUpArea;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[3]/input")
	WebElement superBuiltUpArea;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[4]/input")
	WebElement reraId;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[5]/input")
	WebElement carpetArea;
	
	@FindBy(xpath = "(//div[@class='mat-select-value'])[1]")
	WebElement secondSale;	
	
	@FindBy(xpath = "(//span[@class='mat-option-text'])[2]")
	WebElement selectSecondSaleYes;	
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[7]/input")
	WebElement valueOfProperty;
	
	@FindBy(xpath = "(//div[@class='mat-select-value'])[2]")
	WebElement morgageType;
	
	@FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
	WebElement selectMorgageType;
	
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[1]")
	WebElement yes;
	
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[2]")
	WebElement no;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[9]/input")
	WebElement houseNo;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[10]/input")
	WebElement address;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[11]/input")
	WebElement landmark;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[12]/input")
	WebElement locality;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[13]/input")
	WebElement pincode;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[14]/input")
	WebElement city;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[15]/input")
	WebElement taluka;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[16]/input")
	WebElement state;
		
	@FindBy(xpath = "(//div[@class='ng-star-inserted'])/button/span")
	WebElement verifyAddress;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[6]")
	WebElement authenticate;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[7]")
	WebElement previous;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[8]")
	WebElement next;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[9]")
	WebElement save;
	
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[2]")
	WebElement sellerDetailsTab;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[1]/input")
	WebElement sellerName;
	
	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[2]/textarea")
	WebElement address1;
	
	@FindBy(xpath = "//div[@class='branch-input-field link-button']/a/span")
	WebElement verifyAddress1;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[7]")
	WebElement authenticate1;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[6]")
	WebElement update;

	public PropertyDetailsPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
	}

	
	public void enterPropertyDetails(String PlotArea, String BuiltUpArea, String SuperBuiltUpArea, String ReraId,
			String CarpetArea, String SecondSale, String ValueOfProperty, String MorgageType, String UnderConstructionOrNot,
			String HouseNo, String Address, String Landmark, String Locality,
			String Pincode, String Taluka, String SellerName, String Address1) throws InterruptedException 
	{
		propertyDetailsTab.click();
		Thread.sleep(3000);
		
		if(plotArea.getAttribute("value").isEmpty())
		  {
			plotArea.click();
			plotArea.sendKeys(PlotArea);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("plotArea value exists");
		  }
		
		if(builtUpArea.getAttribute("value").isEmpty())
		  {
			builtUpArea.click();
			builtUpArea.sendKeys(BuiltUpArea);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("builtUpArea value exists");
		  }
		
		if(superBuiltUpArea.getAttribute("value").isEmpty())
		  {
			superBuiltUpArea.click();
			superBuiltUpArea.sendKeys(SuperBuiltUpArea);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("SuperBuiltUpArea value exists");
		  }
	
		if(reraId.getAttribute("value").isEmpty())
		  {
			reraId.click();
			reraId.sendKeys(ReraId);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("reraId value exists");
		  }
		
		if(carpetArea.getAttribute("value").isEmpty())
		  {
			carpetArea.click();
			carpetArea.sendKeys(CarpetArea);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("carpetArea value exists");
		  }
			
		if(secondSale.getText().length() == 1)
		  {
			  System.out.println("Inside religion if loop");
			  Thread.sleep(2000);
			  
			   Actions action = new Actions(driver);
			  action.moveToElement(secondSale).click().perform();
			  
			  secondSale.click();
			  Thread.sleep(2000);
			  
			  List<WebElement> rel = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
			  Thread.sleep(2000);
					  
		  for (WebElement ele : rel)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(SecondSale)) 
	          {
	              ele.click();
	              break;
	          }
		  }
		  }
		  else
		  {
			  System.out.println("Inside else loop");
			  System.out.println("secondSale is selected");
		  }	
		
		
		if(valueOfProperty.getAttribute("value").isEmpty())
		  {
			valueOfProperty.click();
			valueOfProperty.sendKeys(ValueOfProperty);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("valueOfProperty value exists");
		  }
		
		
		
		if(morgageType.getText().length() == 1)
		  {
			  System.out.println("Inside religion if loop");
			  Thread.sleep(2000);
			  
			   Actions action = new Actions(driver);
			  action.moveToElement(morgageType).click().perform();
			  
			  morgageType.click();
			  Thread.sleep(2000);
			  
			  List<WebElement> rel = driver.findElements(By.xpath("(//span[@class='mat-option-text'])"));
			  Thread.sleep(2000);
					  
		  for (WebElement ele : rel)
		  {
	         System.out.println("Values " + ele.getAttribute("innerHTML"));
	  
	          if (ele.getAttribute("innerHTML").contains(MorgageType)) 
	          {
	              ele.click();
	              break;
	          }
		  }
		  }
		  else
		  {
			  System.out.println("Inside else loop");
			  System.out.println("morgageType is selected");
		  }	
		
		if(yes.isSelected() || no.isSelected())	
		{
			System.out.println("Inside if loop of property under construction");
		 if(UnderConstructionOrNot.contains("Yes"))
		  {
			 yes.click();
			  Thread.sleep(3000);
		  }
		  else
		  {
			  no.click();
			  Thread.sleep(3000);
		  }
		}
		else
		{
			System.out.println("Selected");
		}
				
		if(houseNo.getAttribute("value").isEmpty())
		  {
			houseNo.click();
			houseNo.sendKeys(HouseNo);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("houseNo value exists");
		  }
		
		if(address.getAttribute("value").isEmpty())
		  {
			address.click();
			address.sendKeys(Address);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("address value exists");
		  }
		
		if(landmark.getAttribute("value").isEmpty())
		  {
			landmark.click();
			landmark.sendKeys(Landmark);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("landmark value exists");
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
		
		if(taluka.getAttribute("value").isEmpty())
		  {
			taluka.click();
			taluka.sendKeys(Taluka);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("pincode value exists");
		  }
		
		if(pincode.getAttribute("value").isEmpty())
		  {
			pincode.click();
			pincode.sendKeys(Pincode);
			Thread.sleep(3000);
			
			verifyAddress.click();
			Thread.sleep(3000);
			
			authenticate.click();
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("pincode value exists");
		  }
				
		save.click();
		Thread.sleep(3000);
		
		sellerDetailsTab.click();
		Thread.sleep(3000);
		
		if(sellerName.getAttribute("value").isEmpty())
		  {
			sellerName.click();
			sellerName.sendKeys(SellerName);
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("Seller Name value exists");
		  }
		
		if(address1.getAttribute("value").isEmpty())
		  {
			address1.click();
			address1.sendKeys(Address1);
			Thread.sleep(3000);
			
			verifyAddress1.click();
			Thread.sleep(3000);
			
			update.click();
			Thread.sleep(3000);
		  }
		  else
		  {
			  System.out.println("address1 value exists");
		  }
		
		save.click();
		Thread.sleep(3000);
	}	
	
}

