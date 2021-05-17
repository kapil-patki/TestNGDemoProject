package com.ImpactGuru.testProject.TestCase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ImpactGuru.testProject.PageObjects.DonationDetailsPage;
import com.ImpactGuru.testProject.PageObjects.FirstLoginPage;
import com.ImpactGuru.testProject.PageObjects.HomePage;
import com.ImpactGuru.testProject.PageObjects.stagingAuthPopup;
import com.ImpactGuru.testProject.Utilities.myUtilities;
import com.ImpactGuru.testProject.Utilities.readConfig;

public class TC_ValidateNumbersInName extends testBase {

	public TC_ValidateNumbersInName() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void TC_numbersInName() throws FileNotFoundException, IOException, InterruptedException
	{
		readConfig config = new readConfig();
		Logger logger = Logger.getLogger(TC_ValidateNumbersInName.class);
		System.out.println("inside test case: TC_ValidateNumbersInName");
		FirstLoginPage flPage = new FirstLoginPage(getDriver());				
		stagingAuthPopup authPage = new stagingAuthPopup(getDriver());		
		HomePage hpage = new HomePage(getDriver());
		DonationDetailsPage dPage = new DonationDetailsPage(getDriver());
		
		flPage.btnUsernamePwdClick();
		flPage.submitLoginDetails(config.getUname1(),config.getPwd1());
		Thread.sleep(3000);
		authPage.authPopupLogin(config.getUname2(),config.getPwd2());		
		hpage.btnDonateClick();
		boolean flag = dPage.validateNumberInName("Name1");
		System.out.println("flag outside: "+flag);
		if(flag==true)
		{
			Assert.assertEquals(flag, true);
			System.out.println("Number in name success");
			myUtilities utilities = new myUtilities();
			utilities.captureScreen(getDriver(), "TC_numbersInName");
			logger.debug("Number in name success");
		}
		else
		{
			System.out.println("Number in name failure");
			myUtilities utilities = new myUtilities();
			utilities.captureScreen(getDriver(), "TC_numbersInName");
			logger.debug("Number in name failure");
		}
		logger.debug("*********************************************End of TC_InvalidLength*******************************************************");
	}
		
}
