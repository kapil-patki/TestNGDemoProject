package com.ImpactGuru.testProject.PageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactGuru.testProject.TestCase.testBase;
import com.ImpactGuru.testProject.PageObjects.FirstLoginPage;

public class FirstLoginPage extends testBase {
	Logger logger = Logger.getLogger(FirstLoginPage.class);
	WebDriver ldriver;
	public FirstLoginPage(WebDriver rdriver) throws FileNotFoundException, IOException {
		System.out.println("rdriver: "+rdriver);
		ldriver=getDriver();
		PageFactory.initElements(rdriver, this);
	}
			
	@FindBy(xpath="//button[@id='auth-local-btn']")
	WebElement btnUsernamePwd;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPwd;
	
	@FindBy(xpath="//input[@id='submit']")
	WebElement btnSubmit;

	@FindBy(xpath="//button[@class='pt-button auth-cancel']']")
	WebElement btnCancel;
	
	public void btnUsernamePwdClick()
	{
		logger.debug("Clicked on UsernamePassword button");
		try
		{
			btnUsernamePwd.click();
		}catch(ElementNotVisibleException e)
		{
			System.out.println("e: "+e);
		}
		
	}		
	
	public void submitLoginDetails(String username, String pwd) throws InterruptedException
	{
		logger.debug("Entered login details and clicked login");
		txtUsername.sendKeys(username);
		txtPwd.sendKeys(pwd);
		btnSubmit.click();				
	}
	
}
