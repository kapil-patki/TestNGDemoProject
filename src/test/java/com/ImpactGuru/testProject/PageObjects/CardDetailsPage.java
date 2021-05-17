package com.ImpactGuru.testProject.PageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactGuru.testProject.TestCase.testBase;

public class CardDetailsPage extends testBase {

	Logger logger = Logger.getLogger(FirstLoginPage.class);
	WebDriver ldriver;
	public CardDetailsPage(WebDriver rdriver) throws FileNotFoundException, IOException {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(xpath="//input[@name='cardNumber']")
	WebElement txtCardNumber;

	@FindBy(xpath="//input[@name='expiryDate']")
	WebElement txtExpiryDate;
	
	@FindBy(xpath="//input[@name='cvvNumber']")
	WebElement txtCVVNumber;
	
	@FindBy(xpath="//button[@class='additional-changes-in-btn btn-g-new text-center error-msg-space']")
	WebElement btnContribute;	
	
	public void contribute()
	{
		txtCardNumber.sendKeys("5555555555554444");
		txtExpiryDate.sendKeys("1122");
		txtCVVNumber.sendKeys("301");
		btnContribute.submit();
	}	
}
