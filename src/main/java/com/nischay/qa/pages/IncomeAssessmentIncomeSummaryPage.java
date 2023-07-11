package com.nischay.qa.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nischay.qa.base.TestBase;
import com.nischay.qa.util.TestUtil;

public class IncomeAssessmentIncomeSummaryPage extends TestBase {
	
	TestUtil testUtil;
	DashboardPage dashboardPage;
	ApplicantKYCDetailsPage applicantKYCDetailsPage;
	
		
	@FindBy(xpath = "(//div[@class='ng-star-inserted'])[13]")
	WebElement incomeAssessmentTab;
	
	@FindBy(xpath = "(//div[@class='ng-star-inserted'])[10]/app-side-nav-sub-menu-items/div/span")
	WebElement incomeSummary;
	
	@FindBy(xpath = "(//div[@class='ag-pinned-left-cols-container'])[1]/div[1]/div[2]")
	WebElement avaerageSalaryTotalIncome;
	
	@FindBy(xpath = "(//div[@class='ag-center-cols-container'])[1]/div[1]/div")
	WebElement avaerageSalaryofPrimaryApplicant;
	
	@FindBy(xpath = "(//div[@class='ag-pinned-left-cols-container'])[2]/div[1]/div[2]")
	WebElement grossMonthlyIncomeTotalIncome;
	
	@FindBy(xpath = "(//div[@class='ag-center-cols-container'])[2]/div[1]/div")
	WebElement grossMonthlyIncomeofPrimaryApplicant;
	
	@FindBy(xpath = "(//div[@class='action-buttons-container'])/app-custom-button[3]/button/span")
	WebElement save;
	
	@FindBy(xpath = "(//div[@class='action-buttons-container'])/app-custom-button[2]/button/span")
	WebElement next;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[9]")
	WebElement yes;
	
	@FindBy(xpath = "(//*[@class='mat-button-wrapper'])[10]")
	WebElement no;
	
	public IncomeAssessmentIncomeSummaryPage() 
	{
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		dashboardPage = new DashboardPage();
		//applicantKYCDetailsPage = new ApplicantKYCDetailsPage();
	}
	
	public void IncomeSummaryDetails(String AverageSalaryOfTotalIncome, String AverageSalaryOfPrimaryApplicant,
			String GrossMonthlyIncomeofTotalIncome, String GrossMonthlyIncomeofPrimaryApplicant) throws InterruptedException 
	{
		incomeAssessmentTab.click();
		Thread.sleep(3000);
		
		incomeSummary.click();
		Thread.sleep(3000);
		
		avaerageSalaryTotalIncome.click();
		Thread.sleep(3000);
		
		System.out.println("Average salary :"+avaerageSalaryTotalIncome.getText());
		
		String avaerageSalaryTotalIncome1 =  avaerageSalaryTotalIncome.getText();
		
		if(avaerageSalaryTotalIncome1.equals(AverageSalaryOfTotalIncome))
		{
			System.out.println("Average salary of all applicant is same as expected");
		}
		else
		{
			System.out.println("Average salary of all applicant is not same as expected");
		}
		
		String avaerageSalaryofPrimaryApplicant1 = avaerageSalaryofPrimaryApplicant.getText();
		
		if(avaerageSalaryofPrimaryApplicant1.equals(AverageSalaryOfPrimaryApplicant))
		{
			System.out.println("Average salary of primary applicant is same as expected");
		}
		else
		{
			System.out.println("Average salary of primary applicant is not same as expected");
		}
		
		String grossMonthlyIncomeTotalIncome1 = grossMonthlyIncomeTotalIncome.getText();
		
		if(grossMonthlyIncomeTotalIncome1.equals(GrossMonthlyIncomeofTotalIncome))
		{
			System.out.println("Gross Monthly Income of all applicant is same as expected");
		}
		else
		{
			System.out.println("Gross Monthly Income of all applicant is not same as expected");
		}
		
		String grossMonthlyIncomeofPrimaryApplicant1 = grossMonthlyIncomeofPrimaryApplicant.getText();
		if(grossMonthlyIncomeofPrimaryApplicant1.equals(GrossMonthlyIncomeofPrimaryApplicant))
		{
			System.out.println("Gross Monthly Income of primary applicant is same as expected");
		}
		else
		{
			System.out.println("Gross Monthly Income of primary applicant is not same as expected");
		}
		
		next.click();
		Thread.sleep(3000);
		
		yes.click();
		Thread.sleep(3000);
	}	
}

