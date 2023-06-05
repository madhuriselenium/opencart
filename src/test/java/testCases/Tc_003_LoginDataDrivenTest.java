package testCases;
import pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Myaccountpage;
import testbase.BaseTest;
import utilities.DataProviders;
public class Tc_003_LoginDataDrivenTest extends BaseTest{
	
	
    @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp){
	
		logger.info("starting Tc_003_LoginDataDrivenTest");
		try
		{
		
		Homepage hp=new Homepage(driver);
		hp.clickmyacc();
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setemail(email);
		lp.setpassword(pwd);
		lp.clicksubmit();
		
		Myaccountpage macc=new Myaccountpage(driver);
		boolean targetpage=macc.myaccexists();
		
		if(exp.equals("valid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
				Assert.assertTrue(false);
		}
		
		
	if(exp.equals("Invalid"))
	{
		if(targetpage==true)
		{
			macc.clickLogout();
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertTrue(true);
	}
	}
		}
	
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("finished Tc_003_LoginDataDrivenTest");
	}
   }
  
	
	

