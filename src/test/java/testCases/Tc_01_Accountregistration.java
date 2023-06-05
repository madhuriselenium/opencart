package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.BaseTest;
import pageObjects.Homepage;
import pageObjects.Accountregistrationpage;

public class  Tc_01_Accountregistration extends BaseTest {
	
	@Test(groups={"Regression","Master"})
	public void acc_registration()
	{
		logger.info("******Starting Tc_01_Accountregistration ****** "); //null, driver, driver, driver, driver, driver, driver, logger, driver);
		logger.debug("****Generating debug logs....");
		Homepage hp=new Homepage(driver);
		hp.clickmyacc();
		logger.info("Clicked on myacc link");
		hp.clickregister();
		
		logger.info("Clicked on register");
	   
	
		Accountregistrationpage accreg=new Accountregistrationpage(driver);
		logger.info("Providing customer details");
		accreg.setfirstname(randomString().toUpperCase());
		accreg.setlastname(randomString().toUpperCase());
	
		accreg.setemail(randomString()+"@gmail.com");
		accreg.settelephone(randomNumber());
		String pwd=randomAlphanum();
		accreg.setpassword(pwd);
		accreg.setconfirmpass(pwd);
		accreg.setagree();
		accreg.clickcontinue();
		logger.info("clicked on continue");
		String confirmmsg=accreg.confirmationmsg();
		if(confirmmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("test passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			Assert.fail();
		}
		//Assert.assertEquals(confirmmsg,"Your Account Has Been Created!");
		logger.info("*********finished Tc_01_Accountregistration**************** ");	
	}
      
		
	}

