package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.CommonUtil;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPage 
{
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());

		
	}
	@Test
	public void testHomePage()
	{
		
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Avactis Demo Store"));
		
		home.clickOnSigninLink();
				

	}
	
	@Test(dataProvider="getData")
	public void testLogin(String username, String password)
	{
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginApplicatoin(username, password);
		login.verifySignOutLink();
	}
	
	
	
	@DataProvider
	public static Object[][] getData()
	{
		return CommonUtil.getData("Login");
	}
	
	
	
/*	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}*/

}
