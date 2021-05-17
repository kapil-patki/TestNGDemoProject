package com.ImpactGuru.testProject.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLSUtils {
	public static XSSFWorkbook wb = null;
	public static XSSFSheet ws = null;
	public static XSSFRow row;
	public static XSSFCell col;
	
	public static int getRowCount(String xlFile, String sheet) throws IOException
	{
		FileInputStream FI = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(FI);
		ws = wb.getSheet("Sheet1");
		int rowCount = ws.getLastRowNum();
		wb.close();
		FI.close();
		return rowCount;		
	}
	
	public static int getColCount(String xlFile, String sheet, int rownum) throws IOException
	{
		FileInputStream FI = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(FI);
		ws = wb.getSheet("Sheet1");
		row = ws.getRow(rownum);
		int cellCount = row.getLastCellNum(); 
		wb.close();
		FI.close();
		return cellCount;		
	}
	
	public static String[][] getData(String xlFile, String sheet, int rownum, int colnum) throws IOException
	{		
		FileInputStream FI = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(FI);
		ws = wb.getSheet("Sheet1");
		String loginData[][] = new String[rownum+1][colnum];
		
		for(int i=0; i<=rownum; i++)
		{
			for(int j=0; j<colnum; j++)
			{																		
				DataFormatter formatter = new DataFormatter();
				String str = formatter.formatCellValue(ws.getRow(i).getCell(j));								
				loginData[i][j] = str;
				//System.out.println("loginData["+i+"]["+j+"]="+str);
			}
		}						
		wb.close();
		FI.close();
		return loginData;		
	}
}