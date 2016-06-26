package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver ldriver)
	{
		
		this.driver = ldriver;
		
	}
	
	@FindBy(xpath="//a[text()='Sign In']") WebElement Signin_Link;
	@FindBy(xpath="//a[text()='My Account']") WebElement MyAccount_Link;
	@FindBy(xpath="//a[text()='My cart']") WebElement MyCart_Link;
	@FindBy(xpath="//a[text()='Checkout']") WebElement Checkout_Link;
	
	
	public void clickOnSigninLink()
	{
		Signin_Link.click();
	}
	
	public void clickOnMyAccountLink()
	{
		MyAccount_Link.click();
	}
	
	public void clickOnMyCartLink()
	{
		MyCart_Link.click();
	}
	
	public void clickOnCheckoutLink()
	{
		Checkout_Link.click();
	}
	
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}

}
