package testbase;

import java.io.IOException;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.tools.picocli.CommandLine.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Date;

import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;
import java.util.ResourceBundle;
public class BaseTest {
	public Logger logger;
 public static WebDriver driver;
 public ResourceBundle rb;//properties file
 
	
	@BeforeClass(groups= {"Master","Sanity","Regression"}  )
	@Parameters("browser")
	public void setup(String br)
	{
		 rb=ResourceBundle.getBundle("config");//reading data from properties file
		 
		logger=LogManager.getLogger(this.getClass());
		if(br.equalsIgnoreCase("chrome"))
		{
		logger.info("launching chrome browser");	
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
		
		driver=new ChromeDriver(options);	
		}
		else if(br.equalsIgnoreCase("edge"))
		{
				logger.info("launching edge browser");
				EdgeOptions options=new EdgeOptions();
				options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
				driver=new EdgeDriver(options);	
					}
		else
		{
			logger.info("launching chrome browser");	
			
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
			
			driver=new ChromeDriver(options);	
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));//remote
		driver.manage().window().maximize();
		
		}
		

		
		
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void teardown()
	{
		logger.info("closing the app");
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphanum()
	{
		String generatedAlphanum=RandomStringUtils.randomAlphanumeric(10);
		String generatedString=RandomStringUtils.randomAlphabetic(6);
		
		return (generatedAlphanum+generatedString);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	
	}
}
	
	
	


