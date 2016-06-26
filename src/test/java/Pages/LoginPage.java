package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		
		this.driver = ldriver;
		
	}
	
	@FindBy(id="account_sign_in_form_email_id") WebElement username;
	@FindBy(name="passwd") WebElement password;
	@FindBy(xpath="//input[@value='Sign In']") WebElement signupButton;
	//@FindBy(xpath="//[@class='pre-header']//a[text()='Sign Out']") WebElement sighOut;
	By signout = By.xpath("//div[@class='row margin-bottom-40']//a[text()='Sign Out']");
	
	public void loginApplicatoin(String username, String password)
	{
		
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		signupButton.click();
		
	}
	
	public void verifySignOutLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signout));
		String text = ele.getText();
		System.out.println(text);
		Assert.assertEquals(text, "SIGN OUT", "Sign out link not verified properly");
		
	}
}
