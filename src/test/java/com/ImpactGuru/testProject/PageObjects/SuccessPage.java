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

public class SuccessPage extends testBase
{
	Logger logger = Logger.getLogger(SuccessPage.class);
	WebDriver ldriver;
	public SuccessPage(WebDriver rdriver) throws FileNotFoundException, IOException {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@class='thankyou-banner__content-desc']")
	WebElement lblSucess;
	
	public boolean verifySuccess()
	{
		boolean flag = false;
		System.out.println("inside verify success method");
		
		try {
			if(lblSucess.getText().contains("Thank you"))
			{
				flag=true;
				logger.debug("Verification Success");
				System.out.println("Success verification");
			}
		}catch(NoSuchElementException e)
		{
			logger.debug("Failed because of exception: "+e);
			System.out.println("Failed because of exception: "+e);
			flag=false;
		}
		return flag;
	}
}