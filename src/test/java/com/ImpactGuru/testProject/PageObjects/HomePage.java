package com.ImpactGuru.testProject.PageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactGuru.testProject.TestCase.testBase;

public class HomePage extends testBase {

	Logger logger = Logger.getLogger(FirstLoginPage.class);
	WebDriver ldriver;
	public HomePage(WebDriver rdriver) throws FileNotFoundException, IOException {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
		
	@FindBy(xpath="//div[@class='w-100 d-block text-center mb-3 mb-md-2']")
	WebElement btnDonate;
	
	public void btnDonateClick()
	{
		logger.debug("button donate clicked");
		try {
			btnDonate.click();
		}catch(NoSuchElementException e)
		{
			System.out.println("e: "+e);
		}
		
	}
}
