package com.ImpactGuru.testProject.PageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ImpactGuru.testProject.TestCase.testBase;

public class stagingAuthPopup extends testBase {

	Logger logger = Logger.getLogger(stagingAuthPopup.class);
	WebDriver ldriver;
	public stagingAuthPopup(WebDriver rdriver) throws FileNotFoundException, IOException {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void authPopupLogin(String username, String pwd)
	{
		logger.debug("Popup Authenticated");
		ldriver.get("https://"+username+":"+pwd+"@staging.igstg.com/fundraiser/help-testdocumentchecklist");		
	}
}
