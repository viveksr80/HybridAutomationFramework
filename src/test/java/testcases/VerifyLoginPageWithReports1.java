package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.Helper;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPageWithReports1 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		report = new ExtentReports("./Reports/LoginPageReport.html",true);
				
		logger = report.startTest("Verify Login Page");
		//logger = new ExtentTest("Verify Login Page", "This page will verify sign out link");
		
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());

		logger.log(LogStatus.INFO, "Application is up and running");
	}
	@Test
	public void testHomePage()
	{
		
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Avactis Demo Store"));
		
		logger.log(LogStatus.PASS, "Home Page loaded and verified");
		
		home.clickOnSigninLink();
		
		logger.log(LogStatus.INFO, "Click on Signout link");
				
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
						
		login.loginApplicatoin(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		
		logger.log(LogStatus.INFO, "Login to application");
		
		login.verifySignOutLink();
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "verifySignoutLink")));
		
		logger.log(LogStatus.PASS, "Sign Out link appeared");
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path  = Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		report.flush();
	}

}
