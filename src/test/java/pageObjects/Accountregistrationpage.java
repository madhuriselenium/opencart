package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountregistrationpage extends BasePage 
{
	
	public Accountregistrationpage(WebDriver driver) {
		super(driver);
	}
	
	//elements
	
	@FindBy(name="firstname")
	WebElement txtfirstname;
	
	
	@FindBy(name="lastname")
	WebElement txtlastname;
	
	
	@FindBy(name="email")
	WebElement txtemail;
	
	
	@FindBy(name="telephone")
	WebElement txtphone;
	
	
	@FindBy(name="password")
	WebElement txtpass;
	
	
	@FindBy(name="confirm")
	WebElement txtconfirm;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checked;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement text;
	
	//Action methods
	
	public void setfirstname(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void setlastname(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	public void setemail(String mail)
	{
		txtemail.sendKeys(mail);
	}
	public void settelephone(String phone)
	{
		txtphone.sendKeys(phone);
	}
	public void setpassword(String pass )
	{
		txtpass.sendKeys(pass);
	}
	public void setconfirmpass(String pass)
	{
		txtconfirm.sendKeys(pass);
	}
	public void setagree()
	{
		checked.click();
	}
	
	public void clickcontinue()
	{
		btncontinue.click();
		//sol2 
		//btnContinue.submit();
		
		//sol3//using action class
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4//javascriptexecutor
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5//using enter keys
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  //using mywait
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}
	public String confirmationmsg()
	{
		try
		{
			return (text.getText());
		}
		catch(Exception e) {
	       return(e.getMessage());	
	}
	}
}
	
	
	
	
	
	
	
	

