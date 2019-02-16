package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Lib implements IAutoConstant {
	public static Workbook wb;
	public static String getCellValue(String sheetName,int rowNum,int colNum) {
		String cellValue="";
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
		    cellValue=wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		return cellValue;
		
	}
	public static String getPropertyValue(String propertyName){
		String propValue="";
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_PATH));
			 propValue = prop.getProperty(propertyName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propValue;
	}
 public static int getRowCount(String sheetName) {
	 int rows=0;
	 try {
		wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
		 rows = wb.getSheet(sheetName).getLastRowNum();
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
	 return rows;
 }
public static void captureScreenshot(WebDriver driver,String testMethodName) {
	 Date d=new Date();
	 String d1=d.toString();
	 System.out.println(d1);
	 String currentDateAndTime = d1.replaceAll(":", "_");
	 TakesScreenshot ts =(TakesScreenshot) driver;
	 File srcFile = ts.getScreenshotAs(OutputType.FILE);
	 File destFile=new File(SCREENSHOT_PATH+" "+testMethodName+" "+currentDateAndTime+"_"+".png");
	 try {
		Files.copy(srcFile, destFile);
	} catch (IOException e) {
		
	}
	 
	 
 }
}
