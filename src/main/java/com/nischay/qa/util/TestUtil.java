package com.nischay.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.nischay.qa.base.TestBase;

public class TestUtil extends TestBase
{
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName, String Path) // Read xlsx (all rows) without comparing with another xlsx
	{
		FileInputStream file = null;
		try 
		{
			file = new FileInputStream(Path);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			book = WorkbookFactory.create(file);
		} 
		catch (InvalidFormatException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
			{
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
						
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest(String screenShotName) throws IOException // take screen shot only when it fails 
	{
		String screenShotName1 = screenShotName;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + screenShotName1 + ".png"));
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + screenShotName1 + System.currentTimeMillis() + ".png"));
	}
	
public void robotClass() throws AWTException //handle windows based pop up to upload file
{
	Robot robot = new Robot();

    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
}

public void writeInFile() throws FileNotFoundException //Write console output in file
{
	File file = new File("file.txt");
    FileOutputStream fos = new FileOutputStream(file);
    PrintStream ps = new PrintStream(fos);
    System.setOut(ps);
}

public String getBrowser() throws FileNotFoundException //written to select OS to upload documents
{
	String os = System.getProperty("os.name");
	System.out.println(os);
	//String browserName = prop.getProperty("browser");
	 return os;
}

public void writeApplicationID() throws IOException // write application in front of test case 
{
	File file = new File("WriteApplicationID.xlsx");
	FileInputStream fis = new FileInputStream(file);
	
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    
    XSSFSheet sh = wb.getSheetAt(0);
    
    sh.getRow(0).createCell(2).setCellValue(100);
    
    FileOutputStream fos = new FileOutputStream(file);
    
    wb.write(fos);
}


public static Map<String, ArrayList<ArrayList<String>>> compareSheetAndGetData(String Path1, String sheetName1, String Path2, String sheetName2) throws IOException 
{
	Map<String, ArrayList<String>> data1 = new HashMap<String, ArrayList<String>>();

	FileInputStream inputStream1 = new FileInputStream(new File(Path1));
	Workbook workbook1 = new XSSFWorkbook(inputStream1);
	Sheet firstSheet1 = workbook1.getSheet(sheetName1);
	Iterator<Row> iterator1 = firstSheet1.iterator();
	Iterator<Row> itr1 = firstSheet1.iterator();

	int lastRow1 = firstSheet1.getLastRowNum();

	FileInputStream inputStream2 = new FileInputStream(new File(Path2));
	Map<String, List<String>> data2 = new HashMap<String, List<String>>();
	Workbook workbook2 = new XSSFWorkbook(inputStream2);
	Sheet secondSheet = workbook2.getSheet(sheetName2);

	ArrayList<String> cellValue = new ArrayList<String>();
	//ArrayList<String> key = new ArrayList<String>();
	int lastRow2 = secondSheet.getLastRowNum();

	Object[][] coAppvalues = new Object[secondSheet.getLastRowNum()][secondSheet.getRow(0).getLastCellNum()];


	Map<String, ArrayList<ArrayList<String>>> hm = new HashMap<String, ArrayList<ArrayList<String>>>();

	while (iterator1.hasNext()) 
	{

		Row row1 = iterator1.next();
		if (row1.getCell(0).toString().equals("TestCase"))
			continue;

		Cell key = row1.getCell(0);
		ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();
		Iterator<Row> iterator2 = secondSheet.iterator();
		while (iterator2.hasNext()) 
		{

			Row row = iterator2.next();

			if (row.getCell(0).toString().equals("TestCase"))
				continue;

			if (key.toString().equals(row.getCell(0).toString())) 
			{
				System.out.println(key.toString());
				
				ArrayList<String> valiue = new ArrayList<String>();
				for (int i = 1; i < row.getLastCellNum(); i++) 
				{
					System.out.println(row.getCell(i));
					valiue.add(row.getCell(i).getStringCellValue());
				}
				values.add(valiue);
				System.out.println("Values :"+values);
			}
		}
		hm.put(key.toString(), values);
		
		System.out.println("value in hash map is "+hm);
	}

	/*for (String name : hm.keySet()) 
	{
		String key = name.toString();
		String value = hm.get(name).toString();
		System.out.println(key + " " + value);
	}*/

return hm; //values are not assigned as of now

}

}





/*public static Object[][] compareSheetAndGetData(String Path1, String sheetName1,String Path2, String sheetName2) throws IOException
{
	 	FileInputStream fileInputStream1 = new FileInputStream(Path1);

        XSSFWorkbook workbook1 = new XSSFWorkbook(fileInputStream1);

        XSSFSheet worksheet1 = workbook1.getSheet(sheetName1);

        Row row1 = worksheet1.getRow(0);
        int rowCount1 = worksheet1.getLastRowNum()+1;
        int colCount1=row1.getLastCellNum();
        
        Object[][] data1 = new Object[rowCount1][colCount1];
        
        //int rowCount1= worksheet1.getPhysicalNumberOfRows();
        
        //Object[][] data1 = new Object[worksheet1.getLastRowNum()][worksheet1.getRow(0).getLastCellNum()];


        FileInputStream fileInputStream2 = new FileInputStream(Path2);

        XSSFWorkbook workbook2 = new XSSFWorkbook(fileInputStream2);

        XSSFSheet worksheet2 = workbook2.getSheet(sheetName2);

        //int rowCount= worksheet2.getPhysicalNumberOfRows();
        
        Row row2 = worksheet2.getRow(0);
        int rowCount2 = worksheet2.getLastRowNum()+1;
        int colCount2=row2.getLastCellNum();
        
        Object[][] data2 = new Object[rowCount2][colCount2];
        
       // Object[][] data2 = new Object[worksheet2.getLastRowNum()][worksheet2.getRow(0).getLastCellNum()];
        
        
        for (int k=1; k<rowCount1; k++)
        {
        	
        row1 = worksheet1.getRow(k);
        
        for(int i = 1; i < rowCount2; i++)
        {
          	row2 = worksheet2.getRow(i);
          	System.out.println("Row 2 value :"+row2.getCell(0).getStringCellValue());          	
          	System.out.println("Row 1 value :"+row1.getCell(0).getStringCellValue());
        	
        	if(row2.getCell(0).getStringCellValue().equalsIgnoreCase(row1.getCell(0).getStringCellValue()))
        	{
        		for (int j = 0; j < row2.getLastCellNum(); j++) 
        		{
        				data2[i][j] = row2.getCell(j).toString();
        			
        				System.out.println("Data in row :"+data2[i][j]);
        				
        		}
        		}
        	}
        }
        
        System.out.println("Data length is : "+data2.length);
        
        for (int i = 1; i < data2.length; i++) 
        {
        	for(int j = 0; j < data2[i].length; j++) 
        	{
        		if(data2[i][j]!=null)
        		{
        			System.out.println(data2[i][j]);
        		}
        	}
        }
        
        return data2;
}*/

/*public static Object[][] compareSheetAndGetData(String Path1, String sheetName1,String Path2, String sheetName2) throws IOException
{
	 	FileInputStream fileInputStream1 = new FileInputStream(Path1);

        XSSFWorkbook workbook1 = new XSSFWorkbook(fileInputStream1);

        XSSFSheet worksheet1 = workbook1.getSheet(sheetName1);

        int rowCount1= worksheet1.getPhysicalNumberOfRows();
        
        Object[][] data1 = new Object[worksheet1.getLastRowNum()][worksheet1.getRow(0).getLastCellNum()];


        FileInputStream fileInputStream2 = new FileInputStream(Path2);

        XSSFWorkbook workbook2 = new XSSFWorkbook(fileInputStream2);

        XSSFSheet worksheet2 = workbook2.getSheet(sheetName2);

        int rowCount2= worksheet2.getPhysicalNumberOfRows();
        
        Object[][] data2 = new Object[worksheet2.getLastRowNum()][worksheet2.getRow(0).getLastCellNum()];
        
        for (int i = 1; i < rowCount1; i++)
        {
        	XSSFRow row1 = worksheet1.getRow(i);
        	for (int j = 1; j < rowCount2; j++)
        	{
        		XSSFRow row2 = worksheet2.getRow(j);
        		
        		String idstr1 = "";
        		
                XSSFCell id1 = row1.getCell(0);
                if (id1 != null) 
                {
                    idstr1 = id1.getStringCellValue();
                }

                String idstr2 = "";
                XSSFCell id2 = row2.getCell(0);
                if (id2 != null) 
                {
                    idstr2 = id2.getStringCellValue();
                }
                
                if(!idstr1.equals(idstr2))
                {
                    System.out.println("[ERROR] :"+"Diference for id (book1) " + idstr1 + "| Book 1 id = " + idstr1+ " | Book 2 id = " + idstr2);
                   break;
                }
                else
                {
                	System.out.println("[Success] :"+"same for id (book1) " + idstr1 + "| Book 1 id = " + idstr1+ " | Book 2 id = " + idstr2);
                	for (int l = 0; l < worksheet2.getLastRowNum(); l++) 
            		{
            			for (int k = 0; k < worksheet2.getRow(0).getLastCellNum(); k++) 
            			{
            				data2[l][k] = worksheet2.getRow(l + 1).getCell(k).toString();
            						
            			}
            		}
                }
        	}
            
      }
		return data2;
}*/


