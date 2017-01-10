package fitnesse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;

import nl.hsac.fitnesse.sample.FundaTest;
import nl.hsac.fitnesse.fixture.slim.SlimFixtureException;
import nl.hsac.fitnesse.fixture.slim.web.BrowserTest;
import nl.hsac.fitnesse.fixture.util.selenium.SeleniumHelper;


import utility.Browser;
import utility.Constants;
import utility.JavaHelpers;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.tools.ant.DirectoryScanner;

public class embrace extends BrowserTest {
	
	WebDriver driver = getSeleniumHelper().driver();
	JavaHelpers JH = new JavaHelpers();
	private Browser b = new Browser();
	
	/**
     * Downloads the target of the supplied link.
     * @param element link to follow.
     * @return downloaded file if any, null otherwise.
     */
    public String findtextindownloadedfile(String dir, String filename, String text, String ext) {
    	//String TestDir = "/Users/Karthik/Downloads/";
    	Calendar rightNow = Calendar.getInstance();
    	int hour = rightNow.get(Calendar.HOUR);
    	int min = rightNow.get(Calendar.MINUTE);

    	String hourstring;
    	String minutestring;
    	String filetoread;
    	String returntext = "not present";
    	
    	File myFile;
    	int i = 0;
    	do
    	{
    		if(i==1 && min > 0)
    		{
    			min = min - 1;
    		}
    		else if(i==1 && min == 0)
    		{
    			min = 59;
    			hour = hour - 1;
    		}
    		else if(i==2 && min == 59)
    		{
    			min = 0;
    			hour = hour + 1;
    		}
    		else if (i==2 && min != 59)
    		{
    			min = min+1;
    		}
    		
    		
    		hourstring = Integer.toString(hour);
        	minutestring = Integer.toString(min);
        	if(hour<10)
        	{
        		hourstring = "0"+ hourstring;
        	}
        	if(min<10)
        	{
        		minutestring = "0"+ minutestring;
        	}
        	filetoread = dir + filename + "-"+ hourstring + minutestring+"."+ext;
    		myFile = new File(filetoread);  
    		i++;
    	}while(!myFile.exists() && i <= 2);
    		
    	 
        FileInputStream fis = null;
		try {
			fis = new FileInputStream(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        // Finds the workbook instance for XLSX file 
        XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook (fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        // Get iterator to all the rows in current sheet 
        Iterator<Row> rowIterator = mySheet.iterator(); 
        // Traversing over each row of XLSX file
        while (rowIterator.hasNext())
        { 
        	Row row = rowIterator.next(); 
        	// For each row, iterate through each columns
        	Iterator<Cell> cellIterator = row.cellIterator();
        	while (cellIterator.hasNext()) { 
        		Cell cell = cellIterator.next();
        		switch (cell.getCellType()) 
        		{ 
        			case Cell.CELL_TYPE_STRING:
        				System.out.print(cell.getStringCellValue() + "\t"); 
        				if(cell.getStringCellValue().equals(text))
                		{
                			System.out.print(cell.getStringCellValue() + "is Present\t");
                			returntext = "text present";
                		}
        				break; 
        			case Cell.CELL_TYPE_NUMERIC:
        				System.out.print(cell.getNumericCellValue() + "\t");
        				break;
        			case Cell.CELL_TYPE_BOOLEAN: 
        				System.out.print(cell.getBooleanCellValue() + "\t");
        				break; 
        			default : 
        		}
        		
        	}
        	System.out.println("");
        
        }
        return(returntext);
    }
    
    //To validate the property search result
    public String validatePropertySearchResult(String column,String from,String to)
    {
    	
    	String result="FAIL";
    	String noSearchResult=driver.findElement(By.cssSelector("#propertySearchResultsTable > tbody > tr:nth-of-type(1) > td:nth-of-type(1)")).getText().trim();
        try{
    	if(noSearchResult.equalsIgnoreCase("No matching records found"))    	
        {
        	result="PASS";
        }
        else
        {
        	if(column.equalsIgnoreCase("Investment Amount"))
        	{
        		
        	    List<WebElement> propertiesSearchResult = driver.findElements(By.cssSelector("#propertySearchResultsTable > tbody > tr"));
    		    int size= propertiesSearchResult.size();
    		    for(int j=1;j<=2;j++)
    		    {
    		    	driver.findElement(By.cssSelector("#propertySearchResultsTable > thead > tr > th:nth-child(12)")).click();
    		    	 try{Thread.sleep(6000);}catch(Exception e){}
    		    
        	    for(int i=1;i<=size;i++)
        	    {
        	    	
        	    String invAmtUI=driver.findElement(By.cssSelector("#propertySearchResultsTable > tbody > tr:nth-child("+i+") > td:nth-child(12) > span")).getText().trim();
        	    Double invAmt=Double.parseDouble(JH.USCurrencyFormatToString(invAmtUI));
        	    Double fromAmt=Double.parseDouble(JH.USCurrencyFormatToString(from).trim());
        	    Double toAmt=Double.parseDouble(JH.USCurrencyFormatToString(to).trim());
                 if((invAmt >= fromAmt)&&(invAmt <= toAmt))
                 {
                	result="PASS";
                 }
                 else
                 {
                	result="FAIL";
                	break;
                  }
        	    
        	    } 
        	    if(result.equalsIgnoreCase("FAIL"))
        	    {
        	    	break;
        	    }
        	}
        	
        }	
        	else if(column.equalsIgnoreCase("List Price"))
        	{
        		
        	    List<WebElement> propertiesSearchResult = driver.findElements(By.cssSelector("#propertySearchResultsTable > tbody > tr"));
    		    int size= propertiesSearchResult.size();
    		    for(int j=1;j<=2;j++)
    		    {
    		    	driver.findElement(By.cssSelector("#propertySearchResultsTable > thead > tr > th:nth-child(11)")).click();
    		    	 try{Thread.sleep(6000);}catch(Exception e){}
    		    
        	    for(int i=1;i<=size;i++)
        	    {
        	    	
        	    String listPriceUI=driver.findElement(By.cssSelector("#propertySearchResultsTable > tbody > tr:nth-child("+i+") > td:nth-child(11)")).getText().trim();
        	    Double listPrice=Double.parseDouble(JH.USCurrencyFormatToString(listPriceUI));
        	    Double fromAmt=Double.parseDouble(JH.USCurrencyFormatToString(from).trim());
        	    Double toAmt=Double.parseDouble(JH.USCurrencyFormatToString(to).trim());
                 if((listPrice >= fromAmt)&&(listPrice <= toAmt))
                 {
                	result="PASS";
                 }
                 else
                 {
                	result="FAIL";
                	break;
                  }
        	    
        	    } 
        	    if(result.equalsIgnoreCase("FAIL"))
        	    {
        	    	break;
        	    }
        	}
        	
        }		
        	else if(column.equalsIgnoreCase("Yield"))
        	{
        		
        	    List<WebElement> propertiesSearchResult = driver.findElements(By.cssSelector("#propertySearchResultsTable > tbody > tr"));
    		    int size= propertiesSearchResult.size();
    		    for(int j=1;j<=2;j++)
    		    {
    		    	driver.findElement(By.cssSelector("#propertySearchResultsTable > thead > tr > th:nth-child(13)")).click();
    		    	 try{Thread.sleep(6000);}catch(Exception e){}
    		    
        	    for(int i=1;i<=size;i++)
        	    {
        	    	
        	    String yieldUI=driver.findElement(By.cssSelector("#propertySearchResultsTable > tbody > tr:nth-child("+i+") > td:nth-child(13)")).getText().trim();
        	    Double yield=Double.parseDouble(JH.removePercent(yieldUI));
        	    Double fromyield=Double.parseDouble(JH.removePercent(from).trim());
        	    Double toyield=Double.parseDouble(JH.removePercent(to).trim());
                 if((yield >= fromyield)&&(yield <= toyield))
                 {
                	result="PASS";
                 }
                 else
                 {
                	result="FAIL";
                	break;
                  }
        	    
        	    } 
        	    if(result.equalsIgnoreCase("FAIL"))
        	    {
        	    	break;
        	    }
        	}
        	
        }		
        	else if(column.equalsIgnoreCase("YearBuilt"))
        	{
        		
        	    List<WebElement> propertiesSearchResult = driver.findElements(By.cssSelector("#propertySearchResultsTable > tbody > tr"));
    		    int size= propertiesSearchResult.size();
    		    for(int j=1;j<=2;j++)
    		    {
    		    	driver.findElement(By.cssSelector("#propertySearchResultsTable > thead > tr > th:nth-child(10)")).click();
            	    try{Thread.sleep(6000);}catch(Exception e){}
    		    
        	    for(int i=1;i<=size;i++)
        	    {
        	    	
        	    String yearBuiltUI=driver.findElement(By.cssSelector("#propertySearchResultsTable > tbody > tr:nth-child("+i+") > td:nth-child(10)")).getText().trim();
        	    int yearBuilt=Integer.parseInt(yearBuiltUI);
        	    int fromyearBuilt=Integer.parseInt(from.trim());
        	    int toyearBuilt=Integer.parseInt(to.trim());
                 if((yearBuilt >= fromyearBuilt)&&(yearBuilt <= toyearBuilt))
                 {
                	result="PASS";
                 }
                 else
                 {
                	result="FAIL";
                	break;
                  }
        	    
        	    } 
        	    if(result.equalsIgnoreCase("FAIL"))
        	    {
        	    	break;
        	    }
        	}
        	
        }		
        	
        }
        }
        catch(Exception e){result="FAIL";}
    	return result;
    }
    
    //To select Current Investor check box
    public void selectCurrentInvestorcheckbox()
    {
    	WebElement investorsUnderAssetManagementCheckbox=driver.findElement(By.cssSelector("#investorsUnderAM"));
    	if(investorsUnderAssetManagementCheckbox.isSelected())
    	{
    		try{
    			investorsUnderAssetManagementCheckbox.click();
        	}
        	catch(Exception e)
        	{
        		
        		new Actions(driver).moveToElement(investorsUnderAssetManagementCheckbox).click();
        	}	
    	}	
      try{
    		driver.findElement(By.cssSelector("#currentInvestor")).click();
    	}
    	catch(Exception e)
    	{
    		
    		new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#currentInvestor"))).click();
    	}
    	
    }
    
    //To select Investors Under Asset Management check box
    public void selectInvestorsUnderAssetManagement()
    {
    	WebElement currentInvestorCheckbox=driver.findElement(By.cssSelector("#currentInvestor"));
    	if(currentInvestorCheckbox.isSelected())
    	{
    		try{
    			currentInvestorCheckbox.click();
        	}
        	catch(Exception e)
        	{
        		
        		new Actions(driver).moveToElement(currentInvestorCheckbox).click();
        	}	
    	}	
      try{
    		driver.findElement(By.cssSelector("#investorsUnderAM")).click();
    	}
    	catch(Exception e)
    	{
    		
    		new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#investorsUnderAM"))).click();
    	}
    	
    }
    
   
}
