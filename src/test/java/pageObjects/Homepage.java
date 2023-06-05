package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage{
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	//elements
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccount;
	
	@FindBy(linkText="Register")
	WebElement reg;
	
	
	@FindBy(linkText="Login")
	WebElement login;
	
	//action methods
	
	public void clickmyacc()
	{
		myaccount.click();
	}
	public void clickregister()
	{
		reg.click();
	}
	
	public void clicklogin()
	{
		login.click();
	}

}
