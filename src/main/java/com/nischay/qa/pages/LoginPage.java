package com.nischay.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class LoginPage  
{
	TestUtil testUtil;
	WebDriver driver;
	

		@FindBy(xpath = "//*[@id='userNameInput']") 
		WebElement username1;
	
		@FindBy(xpath = "//*[@id='passwordInput']")
		WebElement password1;
	
		@FindBy(xpath = "//*[@id='submitButton']")
		WebElement lgnbutton;
		
	// Initializing the Page Objects:
	public LoginPage(WebDriver ldriver) 
	{
		this.driver = ldriver;
		//PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}

	// Actions:
	public String validateLoginPageTitle() 
	{
		return driver.getTitle();
	}

	public void login(String username, String password)
			throws InterruptedException 
	{
		Thread.sleep(3000); 
		System.out.println("Inside login page");
		
	//	driver.findElement(By.xpath("//*[@id='userNameInput']")).click();
		//driver.findElement(By.xpath("//*[@id='userNameInput']")).sendKeys(username);
			username1.click();
			username1.sendKeys(username);
			Thread.sleep(3000); 
		
		//	driver.findElement(By.xpath("//*[@id='passwordInput']")).click();
		//	driver.findElement(By.xpath("//*[@id='passwordInput']")).sendKeys(password);
			
			password1.sendKeys(password); 
			Thread.sleep(3000);
		 
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='submitButton']")));
		  
		//  lgnbutton.click(); 
		  Thread.sleep(3000);
		  
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		
	}

}
