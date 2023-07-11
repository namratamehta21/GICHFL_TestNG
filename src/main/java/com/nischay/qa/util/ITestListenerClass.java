package com.nischay.qa.util;

import java.io.FileNotFoundException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass implements ITestListener
{
		
	TestUtil testUtil = new TestUtil();
	
	@Override
	public void onStart(ITestContext Result) {
		
		System.out.println("<============ Execution Started : "+ Result.getName()+"  ============>");

		
	}

	@Override
	public void onFinish(ITestContext Result) {
		
		System.out.println();
		System.out.println("<============ Execution Finished : "+ Result.getName()+"  ============>");

	}

			
	@Override
	public void onTestStart(ITestResult Result) {
		
		 System.out.println("<============ Started TestCase Execution : "+ Result.getName()+"  ============>");

	}
	
	@Override
	public void onTestSuccess(ITestResult Result) {
		
		 System.out.println("<============ TestCase Passed : "+ Result.getName()+"  ============>");
		 
		/*
		 * try { testUtil.writeInFile(); } catch (FileNotFoundException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

	@SuppressWarnings("static-access")
	@Override
	public void onTestFailure(ITestResult Result) {
		
		 System.out.println("<============ TestCase Failed : "+ Result.getName()+"  ============>");
		 
		 String screenShotName = Result.getName();
		 
		 if(ITestResult.FAILURE==Result.getStatus())
			{
				System.out.println("Test case result is : "+Result.getStatus());
				try 
				{
					/*WebDriver driver = testUtil.initialization();
					
					TakesScreenshot ts=(TakesScreenshot)driver;
					File source=ts.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(source, new File("./Screenshots/"+Result.getName()+".png"));
					System.out.println("Screenshot taken");*/
					
					testUtil.takeScreenshotAtEndOfTest(screenShotName);
				}
				catch (Exception e)
				{
			 
					System.out.println("Exception while taking screenshot "+e.getMessage());
			
				} 

			}
		 return;
		
	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		
		 System.out.println("<============ TestCase Skipped : "+ Result.getName()+"  ============>");

	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) 
	{
		
	}
}
