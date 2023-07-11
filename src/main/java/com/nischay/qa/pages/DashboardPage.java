package com.nischay.qa.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class DashboardPage extends TestBase {
	TestUtil testUtil;
	
	@FindBy(xpath = "//*[@class='dashboard-container']/div[2]/div/select")
	WebElement pageSize;
	
	@FindBy(xpath = "(//*[@class='dashboard-container']/div[2]/div/select/option)[4]")
	WebElement selectPageSize;
	
	@FindBy(xpath = "//*[@class='mat-form-field-infix']/input")
	WebElement search;
	
	@FindBy(xpath = "//*[@class='cursor-pointer']")
	WebElement clickSearch;
	
	@FindBy(xpath = "(//*[@class='ag-center-cols-container']/div/div[6]/img)[1]")
	WebElement editApplication;

	public DashboardPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public String validateDashboardPageTitle() 
	{
		return driver.getTitle();
	}

	public void selectPageSize() throws InterruptedException 
	{
		//Select pgSize = new Select(pageSize);
		pageSize.click();
		Thread.sleep(3000);
		selectPageSize.click();
		Thread.sleep(3000);
		System.out.println("Clicked on select page size dropdown");
		//pgSize.selectByValue("50");
		//verify no. of records present on screen
	}
	
	public void searchApplication() throws InterruptedException
	{
		Thread.sleep(2000);
		search.click();
		Thread.sleep(2000);
		
		File file;
		FileReader fileReader;
		BufferedReader bufferedReader;
		StringBuffer stringBuffer = null;
		String line;
		try 
		{
			file = new File("ApplicationID.txt");
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			stringBuffer = new StringBuffer();
			
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Contents of file:");
		
		String applicationNo = stringBuffer.toString();
		System.out.println(applicationNo);
		
		search.sendKeys(applicationNo);
		Thread.sleep(3000);
		
		clickSearch.click();
		Thread.sleep(3000);
	}
	
	public void editApplication() throws InterruptedException
	{
		editApplication.click();
		Thread.sleep(2000);
	}
}

