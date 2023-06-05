package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.BaseTest;
import pageObjects.Myaccountpage;


import pageObjects.Homepage;
import pageObjects.LoginPage;
//this is login test 
public class Tc_02_LoginTest extends BaseTest{
	@Test(groups={"Sanity","Master"})
	public void test_login()
	{
		logger.info("starting Tc_002_LoginTest.... ");
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clickmyacc();
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setemail(rb.getString("email"));
		lp.setpassword(rb.getString("password"));
		lp.clicksubmit();
		
		Myaccountpage macc=new Myaccountpage(driver);
		boolean targetpage=macc.myaccexists();
		
		Assert.assertEquals(targetpage,true);
		
		logger.info("finished Tc_002_LoginTest....");
	}
		catch(Exception e)
		{
		Assert.fail();	
}
		
		
	}
	

}
