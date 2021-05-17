package com.ImpactGuru.testProject.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfig 
{
	Properties prop;
	private static String ScreenShotURL;
	
	public readConfig() throws IOException, FileNotFoundException
	{		
		FileInputStream fin = new FileInputStream("./Configurations/config.properties");
		prop = new Properties();
		prop.load(fin);		
	}
		
	public String getURL() {
		String baseURL = prop.getProperty("baseURL");
		return baseURL;
	}
	public String getUname1() {
		String uname = prop.getProperty("uname1");
		return uname;
	}
	public String getPwd1() {
		String pwd = prop.getProperty("pwd1");
		return pwd;
	}
	
	public String getUname2() {
		String uname = prop.getProperty("uname2");
		return uname;
	}
	public String getPwd2() {
		String pwd = prop.getProperty("pwd2");
		return pwd;
	}
	
	public String getChromePath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}	
	public String getFFPath() {
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}
	public int getSeconds() {
		int seconds  = Integer.parseInt(prop.getProperty("waitSeconds"));
		return seconds;
	}
	public void setScreenShotURL(String URL) {
		ScreenShotURL = URL;		
	}
	public String getScreenShotURL() {		
		return ScreenShotURL;
	}
}
