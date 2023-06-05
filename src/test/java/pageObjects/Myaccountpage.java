package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends BasePage {
	public Myaccountpage(WebDriver driver)
	{
	   super(driver);
	}
	@FindBy(xpath="//h2[normalize-space()=\"My Account\"]")
	WebElement myheading;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement lnklogout;
	
	public boolean myaccexists()
	{
		try
		{
			return(myheading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
		public void clickLogout()
		{
			lnklogout.click();
		}
	}




