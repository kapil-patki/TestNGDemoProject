package com.ImpactGuru.testProject.TestCase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.ImpactGuru.testProject.Utilities.readConfig;

public class testBase {	
	public static String userName1;
	public static String password1;
	public static String userName2;
	public static String password2;
	public static String baseURL;
	public static String chromeDriverPath;	
	public static String FFDriverPath;
	public static int waitSeconds;
	//public static WebDriver driver;
	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();		
	public static Properties prop;	
	public static Logger logger;
				
	public WebDriver getDriver() {
		System.out.println("invoking driver.get()");
		return this.driver.get() ;
	}
	public void setDriver(WebDriver driver) {
		System.out.println("invoking set driver");
		this.driver.set(driver);		
	}

	public testBase() throws FileNotFoundException, IOException
	{		
		PropertyConfigurator.configure("Log4j.properties");
		readConfig objReadConfig = new readConfig();
		logger = Logger.getLogger("testBase");		
		userName1 = objReadConfig.getUname1() ;
		password1 = objReadConfig.getPwd1();
		userName2 = objReadConfig.getUname2() ;
		password2 = objReadConfig.getPwd2();		
		baseURL = objReadConfig.getURL();
		chromeDriverPath = objReadConfig.getChromePath();		
		FFDriverPath = objReadConfig.getFFPath();
		waitSeconds = objReadConfig.getSeconds();					
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br)
	{					
		if(br.equals("chrome"))
		{			
			logger.debug("Initiating Chrome driver");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			//driver=new ChromeDriver();
			setDriver(new ChromeDriver());
		}
		else if(br.equals("FF"))
		{
			logger.debug("Initiating Firefox driver");
			System.setProperty("webdriver.gecko.driver", FFDriverPath);
			//Desired Capabilities help Selenium understand the browser name, 
			//version and operating system in order to execute automated tests.
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			//driver=new FirefoxDriver();
			setDriver(new FirefoxDriver());
		}		
		System.out.println("baseurl: "+ baseURL);
		getDriver().get(baseURL);
		getDriver().manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();        
	}
		
	@AfterTest
	public void tearDown()
	{
		//extentReports.flush();
		//getDriver().close();	
	}
}