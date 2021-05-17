package com.ImpactGuru.testProject.Utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class myUtilities 
{
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	readConfig r = new readConfig();
    	
		TakesScreenshot TS = (TakesScreenshot) driver;
		File src = TS.getScreenshotAs(OutputType.FILE);		
		String targetStr = System.getProperty("user.dir")+"\\Screenshots\\"+tname+sdf.format(timestamp)+".png";		
		r.setScreenShotURL(targetStr);
		File target = new File(targetStr);
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot Taken");
	}
}