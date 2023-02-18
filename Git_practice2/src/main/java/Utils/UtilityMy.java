package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class UtilityMy {

	// screen shot code method
	public static TakesScreenshot takesScreenShott(String testClassName,WebDriver driver ) throws IOException
	{Random a=new Random();
	int ranNo=a.nextInt(1000);

	Date d=new Date();
	String date=d.toString().replace(":", "_").replace(" ","_");
		
	TakesScreenshot ts =(TakesScreenshot) driver;
	File src= ts.getScreenshotAs(OutputType.FILE);
	File dest= new File("test-output\\failedScreenshot"+testClassName+"_"+date+"_"+ranNo+".jpeg");
	FileHandler.copy(src, dest);
	return ts;}

	
	
///////////////////////////////////////////////////////////////////////////////////////////
	public static String readExcelData(String sheetName,int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
String path="src\\test\\resources\\dataFiles\\TestDataEx.xlsx";//locate the file
//String path="src/test/resources\\datFiles\\TestDataEx.xlsx";//locate the file
//String path="C:\\Users\\USER\\Downloads\\TestDataEx.xlsx";
//String path="C:\\Users\\USER\\eclipse-workspace\\Amazon_Automate\\src\\test\\resources\\dataFiles\\TestDataEx.xlsx";
	FileInputStream file=new FileInputStream(path);//open the file
	Workbook wb =WorkbookFactory.create(file);//open the workbook
	Sheet s1 =  wb.getSheet(sheetName);// call sheet by its name
	//Sheet s2=wb.getSheetAt(0); // call sheet by its index number
	Row row1=s1.getRow(rowNo);
	Cell cell1=row1.getCell(cellNo);
	CellType a= cell1.getCellType();
				
	String data="";
	double value;

	try
	{data=cell1.getStringCellValue();}
	catch(IllegalStateException excep)
	{value=cell1.getNumericCellValue();
	 long lon =(long) value;

	data=Long.toString(lon);}//convert double to long to string

	return data;	}
/////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	public static String writeExcelData(String sheetName,int rowNo, int cellNo, String variabletoStore) throws EncryptedDocumentException, IOException
	{String path="src\\test\\resources\\dataFiles\\TestDataEx.xlsx";//locate the file
	//String path="src/test/resources\\datFiles\\TestDataEx.xlsx";//locate the file
	FileInputStream file=new FileInputStream(path);//open the file
	Workbook wb =WorkbookFactory.create(file);//open the workbook
	Sheet s1 =  wb.getSheet(sheetName);// call sheet by its name
	//Sheet s2=wb.getSheetAt(0); // call sheet by its index number

			int rownumLast=s1.getLastRowNum();
			System.out.println(rownumLast);
			System.out.println("===*************===========");

			int cellnumLast=s1.getRow(1).getLastCellNum();
			System.out.println(cellnumLast);
			System.out.println("===*************===========");


			Row row1=s1.getRow(1);
	
			Cell c11=row1.getCell(1);
			CellType a= c11.getCellType();
			System.out.println(a);

System.out.println("==============");
//take data from site
/*
WebElement firstCell=driver.findElement(By.xpath("(//table//tr[2]//td[1])[1]"));	
String firstCellDATA=firstCell.getText();
System.out.println(firstCellDATA);
	*/	

// try catch already data present ot that cell is empty
			
// write data in excel	    //overwrite data in excel	
Cell cell1=s1.getRow(rowNo).createCell(cellNo);		
cell1.setCellValue(variabletoStore);
FileOutputStream fo=new FileOutputStream(path);
wb.write(fo);
fo.close();
			
	return 	variabletoStore;}
	
}