package com.nischay.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import com.nischay.qa.util.TestUtil;
import com.nischay.qa.util.WebEventListener;
import org.openqa.selenium.remote.RemoteWebDriver;


	public class TestBase
	{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static String appurl;

	@BeforeSuite
	public void TestBase() 
	{
		try 
		{
			 prop = new Properties();

			 FileInputStream ip = new FileInputStream(
			 System.getProperty("user.dir") + "/src/main/java/com/nischay" + "/qa/config/config.properties");
			
			 prop.load(ip);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

	@BeforeSuite
	public static WebDriver initialization() 
	{
		String os = System.getProperty("os.name");
		System.out.println(os);
		String browserName = prop.getProperty("browser");
		if (os.equalsIgnoreCase("Windows 10")) 
		{
			if (browserName.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver","E:\\GICHFL\\GICAutomation\\exe\\chromedriver.exe");
				
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.EAGER);
				options.addArguments("--incognito"); options.addArguments("enable-automation"); options.addArguments("--headless"); options.addArguments("--no-sandbox"); options.addArguments("--window-size=1920,1080"); options.addArguments("--disable-gpu"); options.addArguments("--disable-extensions"); options.addArguments("--dns-prefetch-disable"); options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
						
				driver = new ChromeDriver();
				
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			} 
			else if (browserName.equals("Firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", "E:\\GICHFL\\GICAutomation\\exe\\geckodriver.exe");
				driver = new FirefoxDriver();
			}

		}

		else 
		{
			if (browserName.equals("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
				// System.setProperty("webdriver.chrome.logfile",
				// "/usr/local/share/chromedriver.log");
				// System.setProperty("webdriver.chrome.verboseLogging", "true");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("--headless");
				chromeOptions.setExperimentalOption("useAutomationExtension", false);
				chromeOptions.addArguments("--disable-extensions");
				chromeOptions.addArguments("--no-gui");
				chromeOptions.addArguments("--no-zygote");
				chromeOptions.addArguments("--disable-dev-shm-usage");
				// chromeOptions.setBinary("/opt/google/chrome");
				driver = new RemoteWebDriver(chromeOptions);

				System.out.println("Test completed--- Selenium");

			}
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver

		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get("https://uadigital.gichf.com/");
		//System.out.println("asss"+appurl);
		
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.navigate().refresh();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		return driver;
	
	}
	
	/*@BeforeSuite(alwaysRun = true)
	public void setupBeforeSuite(ITestContext context) {
		appurl = context.getCurrentXmlTest().getParameter("selenium.url");
		System.out.println("****" + appurl);

	}*/


}