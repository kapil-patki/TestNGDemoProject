package com.ImpactGuru.testProject.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting implements ITestListener {
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static String screenShotPath;
	
	 public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
		 	extentReports.flush();		
	    }		
	
	    public void onStart(ITestContext arg0) {						    	
	        // TODO Auto-generated method stub				
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    		    	
	    	String str = System.getProperty("user.dir")+"\\test-output\\ExtentReport"+sdf.format(timestamp)+".html";
	    	System.out.println("str: "+str);
	    	htmlreporter = new ExtentHtmlReporter(str);
			extentReports = new ExtentReports();
			extentReports.attachReporter(htmlreporter);			
	    }		
		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {										        	
	    }		
		
	    public void onTestFailure(ITestResult result) {					
	        // TODO Auto-generated method stub	    	

	    	extentTest = extentReports.createTest(result.getName());	    	
	    	extentTest.fail(MarkupHelper.createLabel(result.getName()+" Test Case Failed", ExtentColor.RED));
	    	//screenShotPath = System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+sdf.format(timestamp)+".png";
	    	
	    	readConfig r=null;
			try {
				r = new readConfig();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	System.out.println("r.getScreenShotURL in Reporting "+r.getScreenShotURL());
	    	
	    	//File f = new File(screenShotPath);
	    	File f = new File(r.getScreenShotURL());
	    	if(f.exists())
	    	{ 	    	  
	    		try {
					//extentTest.fail("Screenshot is below: "+ extentTest.addScreenCaptureFromPath(screenShotPath));
	    			extentTest.fail("Screenshot is below: "+ extentTest.addScreenCaptureFromPath(r.getScreenShotURL()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}	    	
			extentTest.fail(result.getThrowable());		
	    }		
	    public void onTestSuccess(ITestResult result) {	
	    	
	    	extentTest = extentReports.createTest(result.getName());
	        extentTest.pass(MarkupHelper.createLabel(result.getName()+" Test Case Passed", ExtentColor.GREEN));	        
	        
	        readConfig r=null;
			try {
				r = new readConfig();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    		    	
	    	//System.out.println("screenShotPath: "+screenShotPath);
			System.out.println("r.getScreenShotURL in Reporting "+r.getScreenShotURL());
	    	File f = new File(r.getScreenShotURL());
	    	if(f.exists())
	    	{ 	    	  
	    		try {
					//extentTest.pass("Screenshot is below: "+ extentTest.addScreenCaptureFromPath(screenShotPath));
	    			extentTest.pass("Screenshot is below: "+ extentTest.addScreenCaptureFromPath(r.getScreenShotURL()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}	 
	    }		
	    public void onTestSkipped(ITestResult result) {						        				
	    	extentTest.skip(MarkupHelper.createLabel(result.getName()+" Test Case Skipped", ExtentColor.YELLOW));
			extentTest.skip(result.getThrowable());		
	    }		
		
	    public void onTestStart(ITestResult result) {						        
	    }					    
}