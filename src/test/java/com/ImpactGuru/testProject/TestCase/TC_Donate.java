package com.ImpactGuru.testProject.TestCase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ImpactGuru.testProject.PageObjects.CardDetailsPage;
import com.ImpactGuru.testProject.PageObjects.DonationDetailsPage;
import com.ImpactGuru.testProject.PageObjects.FirstLoginPage;
import com.ImpactGuru.testProject.PageObjects.HomePage;
import com.ImpactGuru.testProject.PageObjects.SuccessPage;
import com.ImpactGuru.testProject.PageObjects.stagingAuthPopup;
import com.ImpactGuru.testProject.Utilities.XLSUtils;
import com.ImpactGuru.testProject.Utilities.myUtilities;
import com.ImpactGuru.testProject.Utilities.readConfig;


public class TC_Donate extends testBase {

	public TC_Donate() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	static int rownum=0;
	static int colnum=0;
	
	@Test(dataProvider="TestData")
	public void DonateTC_TDD(String fullName, String email, String mobile, String city) throws FileNotFoundException, IOException, InterruptedException
	{	
		readConfig config = new readConfig();		
		Logger logger = Logger.getLogger(TC_Donate.class);
		FirstLoginPage flPage = new FirstLoginPage(getDriver());				
		stagingAuthPopup authPage = new stagingAuthPopup(getDriver());		
		HomePage hpage = new HomePage(getDriver());
		DonationDetailsPage dPage = new DonationDetailsPage(getDriver());
		CardDetailsPage cPage = new CardDetailsPage(getDriver());
		SuccessPage sPage = new SuccessPage(getDriver());
		
		flPage.btnUsernamePwdClick();
		flPage.submitLoginDetails(config.getUname1(),config.getPwd1());
		Thread.sleep(3000);
		authPage.authPopupLogin(config.getUname2(),config.getPwd2());		
		hpage.btnDonateClick();
						
		dPage.submitDetails(fullName, email, mobile, city);
		cPage.contribute();
		boolean flag = sPage.verifySuccess();
		if(flag==true)
		{
			Assert.assertEquals(flag, true);
			myUtilities utilities = new myUtilities();
			utilities.captureScreen(getDriver(), "DonateTC_TDD");
			logger.debug("User donated successfully");
		}
		else
		{
			myUtilities utilities = new myUtilities();
			utilities.captureScreen(getDriver(), "DonateTC_TDD");
			logger.debug("donation failed");
		}
		logger.debug("*********************************************End of TC*******************************************************");
	}
	
	@DataProvider(name="TestData")
	String[][] getData() throws IOException
	{		
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\ImpactGuru\\testProject\\TestData\\TestData.xls";
		rownum = XLSUtils.getRowCount(path, "Sheet1");	
		colnum = XLSUtils.getColCount(path, "Sheet1", rownum);
		String loginData[][] = new String[rownum][colnum];
		loginData = XLSUtils.getData(path, "Sheet1", rownum, colnum);		
		return loginData;
	}
}
