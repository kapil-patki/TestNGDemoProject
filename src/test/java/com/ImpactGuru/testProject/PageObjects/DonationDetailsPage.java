package com.ImpactGuru.testProject.PageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactGuru.testProject.TestCase.testBase;

public class DonationDetailsPage extends testBase {

	Logger logger = Logger.getLogger(DonationDetailsPage.class);
	WebDriver ldriver;
	public DonationDetailsPage(WebDriver rdriver) throws FileNotFoundException, IOException {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(xpath="//button[@id='story-popup-donate-amt-option4']")
	WebElement txtAmt4;
	
	@FindBy(xpath="//input[@name='full_name']")
	WebElement txtFullName;
	
	@FindBy(xpath="//input[@name='email_receipt']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='mobile']")
	WebElement txtMobile;
	
	@FindBy(xpath="//input[@name='city_text']")
	WebElement txtCity;
	
	@FindBy(xpath="//button[@class='btn-g-new text-center mt-2 story-popup-donate-button cmp-analytics']")
	WebElement btnDonateNow;
		
	//@FindBy(xpath="//small[@data-bv-validator='callback']")	
	@FindBy(xpath="//*[@id=\"userDetailsForm\"]/div[1]/small[4]")
	WebElement lblLessThanThreeChars;
		
	@FindBy(xpath="//*[@id=\"userDetailsForm\"]/div[1]/small[3]")
	WebElement lblNumberInName;
	
	public void submitDetails(String fullName, String email, String mobile, String city)
	{				
		txtAmt4.click();
		txtFullName.sendKeys(fullName);
		txtEmail.sendKeys(email);
		txtMobile.sendKeys(mobile);
		txtCity.sendKeys(city);
		btnDonateNow.click();
		logger.debug("Submitted donation details");
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean validateNameLength(String str) throws InterruptedException
	{
		boolean flag = false;
		txtFullName.sendKeys(str);
		String str1 = lblLessThanThreeChars.getText();
		String str2 = "Name should be of minimum 3 characters";			  
		System.out.println("str1.equals(str2): "+str1.equals(str2));
						
		if(str1.equals(str2))
		{
			flag = true;
		}
		System.out.println("flag inside: "+flag);
		return flag;
	}
	
	public boolean validateNumberInName(String str)
	{
		boolean flag = false;
		txtFullName.sendKeys(str);
		String str1 = lblNumberInName.getText();
		
        /*char[] chars = str1.toCharArray();        
        for(char c : chars)
        {
          if(Character.isDigit(c))
          {
             flag = true;
             break;
          }
        }*/
                
        if(str1.equals("Special characters and numbers are not allowed"))
		{
			flag = true;
		}
		System.out.println("flag inside: "+flag);
		return flag;
	}
}
