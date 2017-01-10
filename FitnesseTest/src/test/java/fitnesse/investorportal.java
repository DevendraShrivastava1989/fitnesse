package fitnesse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import pageFactory.InvestorPortal.PropertySearchPage;
import pageFactory.InvestorPortal.WatchList;
 
public class investorportal extends BrowserTest {
	
	WebDriver driver = getSeleniumHelper().driver();
	JavaHelpers JH = new JavaHelpers();
	WatchList wl=new WatchList(driver);
	PropertySearchPage propertysearch = new PropertySearchPage(driver);
	DBAccess db =new DBAccess();
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
   
    /***************************************************/
    //Function name - verifyCorrectPropertiesAreDisplayedAccordingToSelectedFilters
    //Purpose - verify the correct properties are displayed based on locations selected in filters
    //Parameters -
    //             1) [String] locations - array of names of locations
    //Return values -
    //             1) [String] result - if all results are correct as per filters, return 'TRUE'; else return 'FALSE'
    //
    /****************************************************/
    public String verifyCorrectPropertiesAreDisplayedAccordingToSelectedFilters(String[] locations) {
    	
    	PropertySearchPage propertysearch = new PropertySearchPage(driver);
        int count=0;
    	//int j = propertysearch.GetTotalPropertiesCount();
        int j = propertysearch.GetTotalPropertiesCount();
    	String result = "FAIL";
    	//String locations[]={"Atlanta","Charlotte"};
		
		//System.out.println(" -- There are " + j + " properties displayed on table");
		
		for (int i=1;i<=j;i++)
		{
			String actual = propertysearch.GetPropertyClassInfo(i).toLowerCase();
			
			for (int k=0;k<locations.length;k++){
			
				String expected= locations[k].toLowerCase();
				
				if(actual.contains(expected))
				{
					//System.out.println("--- Success!! Property location is correct = " + expected);
					count=count+1;
				}		
				
			}
		
		}
		
		if(count==j){
			//System.out.println("--- Success!! All Locations Verified");
			result = "PASS";
		}
		
		else{
			//System.out.println("---Location Verification Failed");
			result = "FAIL";
		}
		return result;
		
    }
    
       
    public String verifythesortorderonportfoliowatchlist(String sortOrder)
	 {
    	 WatchList wl=new WatchList(driver);
    	 JavaHelpers JH = new JavaHelpers();
    	
    	 String result="FAIL";
		 SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
		 int size;
		 int lastrecord;
		  
		  try{
			  wl.sortPortfolioList(sortOrder); Thread.sleep(5000);
		  }
		  catch(Exception e){
			  return result;
		  }
		  
		  if(sortOrder.equalsIgnoreCase("recently created"))
		  {
			  try{
				  	List<WebElement> portfolioList = driver.findElements(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing"));
				  	size= portfolioList.size();
				  	lastrecord=size+2;
				  	
				  	if(size==0 || size==1) // if no records are present or only one record is present
				  	{
				  		result="SKIP";
				  	}
				  	else
				  	{
				  		for (int i=3;i<lastrecord;i++)  
				  		{
				  			for (int j=i+1;j<=lastrecord;j++)
				  			{ 
				  				String dateUI1=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing:nth-child("+i+") > div > div.propdet > div > div > span > span:nth-child(2)")).getText().trim();
				  				String dateUI2=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing:nth-child("+j+") > div > div.propdet > div > div > span > span:nth-child(2)")).getText().trim();
							    
				  				Date date1 = sdf.parse(dateUI1);
							    Date date2 = sdf.parse(dateUI2);
							    
							    if ((date1.compareTo(date2) > 0) ||  (date1.compareTo(date2) == 0))
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
			   catch(Exception e)//if no any portfolio present
			   {
			     result="PASS";
			   }
		  }
		  
		  else if(sortOrder.equalsIgnoreCase("Investment Amount"))
		  {  
			  try{
				  	List<WebElement> portfolioList = driver.findElements(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing"));
				  	size= portfolioList.size();
				  	lastrecord=size+2;
				  	
				  	if(size==0 || size==1) // if no records are present or only one record is present
				  	{
				  		result="SKIP";
				  	}
				  	else
				  	{
				  		for (int i=3;i<lastrecord;i++)  
				  		{
				  			for (int j=i+1;j<=lastrecord;j++)
				  			{ 
				  				String invAMTUI1=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div:nth-child("+i+") > div > div.propdet > div.watch-port-list > section:nth-child(4) > h1 > span.currency_field_no_symbol")).getText().trim();
				  				String invAMTUI2=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div:nth-child("+j+") > div > div.propdet > div.watch-port-list > section:nth-child(4) > h1 > span.currency_field_no_symbol")).getText().trim();
				  				
				  				if(invAMTUI1.equals("-"))
				  				{
				  					invAMTUI1="0.0";
				  				}
				  				if(invAMTUI2.equals("-"))
				  				{
				  					invAMTUI2="0.0";
				  				}
				  				
				  				double invAMT1=Double.parseDouble(JH.USCurrencyFormatToString(invAMTUI1));
				  				double invAMT2=Double.parseDouble(JH.USCurrencyFormatToString(invAMTUI2));
				  				int diff = Double.compare(invAMT1, invAMT2); 
				  				
				  				if (diff > 0 || diff == 0)
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
			    catch(Exception e)//if no any portfolio present
			    {
			      result="PASS";
			    }
		   
		  }
	  
	      else if(sortOrder.equalsIgnoreCase("Total Return"))
		  {  
	    	  try{
		    		  List<WebElement> portfolioList = driver.findElements(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing"));
		    		  size= portfolioList.size();
		    		  lastrecord=size+2;
		    		  
		    		  if(size==0 || size==1) // if no records are present or only one record is present
					  {
					  		result="SKIP";
					  }
		    		  else
		    		  {
		    			  for (int i=3;i<lastrecord;i++)  
		    			  {
		    				  for (int j=i+1;j<=lastrecord;j++)
		    				  { 
		    					  String totRETUI1=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div:nth-child("+i+") > div > div.propdet > div.watch-port-list > section:nth-child(8) > h1")).getText().trim();
		    					  String totRETUI2=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div:nth-child("+j+") > div > div.propdet > div.watch-port-list > section:nth-child(8) > h1")).getText().trim();
		    					  
		    					  if(totRETUI1.equals("-")){totRETUI1="0.0";}
		    					  if(totRETUI2.equals("-")){totRETUI2="0.0";}
		    					  
		    					  double totRET1=Double.parseDouble(removePercent(totRETUI1));
		    					  double totRET2=Double.parseDouble(removePercent(totRETUI2));
		    					  
		    					  int diff = Double.compare(totRET1, totRET2); 
		    					  if (diff > 0 || diff == 0)
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
			   	catch(Exception e)//if no any portfolio present
			   	{
			   		result="PASS";
			   	}
  
		  	}
		
	      else if(sortOrder.equalsIgnoreCase("Yield"))
	      {
			 try{
				    List<WebElement> portfolioList = driver.findElements(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing"));
				    size= portfolioList.size();
				    lastrecord=size+2;
				    
				    if(size==0 || size==1) // if no records are present or only one record is present
				  	{
				  		result="SKIP";
				  	}
				    
				    else
				    {
				    	for (int i=3;i<lastrecord;i++)  
				    	{
				    		for (int j=i+1;j<=lastrecord;j++)
				    		{ 
				    			String yieldUI1=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div:nth-child("+i+") > div > div.propdet > div.watch-port-list > section:nth-child(7) > h1")).getText().trim();
				    			String yieldUI2=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div:nth-child("+j+") > div > div.propdet > div.watch-port-list > section:nth-child(7) > h1")).getText().trim();
				    			
				    			if(yieldUI1.equals("-")){yieldUI1="0.0";}
				    			if(yieldUI2.equals("-")){yieldUI2="0.0";}
				    			double yield1=Double.parseDouble(removePercent(yieldUI1));
				    			double yield2=Double.parseDouble(removePercent(yieldUI2));
				    			
				    			int diff = Double.compare(yield1, yield2); 
				    			if (diff > 0 || diff == 0)
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
				  catch(Exception e)//if no any portfolio present
				   {
				     result="PASS";
				   }
	
		  }
	  
	      else if(sortOrder.equalsIgnoreCase("Cash On Cash Return"))
	      {
	    	  try{
	    		  	List<WebElement> portfolioList = driver.findElements(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing"));
	    		  	size= portfolioList.size();
	    		  	lastrecord=size+2;
	    		  	
	    		  	if(size==0 || size==1) // if no records are present or only one record is present
				  	{
				  		result="SKIP";
				  	}
	    		  	else
	    		  	{
	    		  		for (int i=3;i<lastrecord;i++)  
	    		  		{
	    		  			for (int j=i+1;j<=lastrecord;j++)
	    		  			{ 
	    		  				String cocRETUI1=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div:nth-child("+i+") > div > div.propdet > div.watch-port-list > section:nth-child(6) > h1")).getText().trim();
	    		  				String cocRETUI2=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div:nth-child("+j+") > div > div.propdet > div.watch-port-list > section:nth-child(6) > h1")).getText().trim();
	    		  				
	    		  				if(cocRETUI1.equals("-")){cocRETUI1="0.0";}
	    		  				if(cocRETUI2.equals("-")){cocRETUI2="0.0";}
	    		  			
	    		  				double cocRET1=Double.parseDouble(removePercent(cocRETUI1));
	    		  				double cocRET2=Double.parseDouble(removePercent(cocRETUI2));
	    		  				
	    		  				int diff = Double.compare(cocRET1, cocRET2); 
	    		  				if (diff > 0 || diff == 0)
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
			   catch(Exception e)//if no any portfolio present
			   {
			     result="PASS";
			   }
			
		}
		else if(sortOrder.equalsIgnoreCase("recently modified"))
	  {
		  SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String ENV="PROD";
		  int column=1;
		  try{
			  	List<WebElement> portfolioList = driver.findElements(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing"));
			  	size= portfolioList.size();
			  	lastrecord=size+2;
			  	if(size==0 || size==1) // if no records are present or only one record is present
			  	{
			  		result="SKIP";
			  	}
			  	else
			  	{
			  		for (int i=3;i<lastrecord;i++)  
			  		{
			  			for (int j=i+1;j<=lastrecord;j++)
			  			{ 
			  				String portFOLIOID1=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div:nth-child("+i+") > div > div:nth-child(1) > span")).getAttribute("data-portfolio-id").trim();
			  				String portFOLIOID2=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div:nth-child("+j+") > div > div:nth-child(1) > span")).getAttribute("data-portfolio-id").trim();
			  				String sqlQuery1="select date_modified as datemodified from investor.tblportfolio where portfolio_id='"+portFOLIOID1+"';";
			  				String sqlQuery2="select date_modified as datemodified from investor.tblportfolio where portfolio_id='"+portFOLIOID2+"';";
			  				Date date1 = sdf1.parse(db.getDBData(ENV,sqlQuery1,column));
			  				Date date2 = sdf1.parse(db.getDBData(ENV,sqlQuery2,column));
						    if ((date1.compareTo(date2) > 0) ||  (date1.compareTo(date2) == 0))
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
		   catch(Exception e)//if no any portfolio present
		   {
		     result="PASS";
		   }
	  }
	  return result;
	 }
    
	// Remove % from a string  
 	public String removePercent(String input)
 	{
 		String s = input.replaceAll("[%,]", "");
 		return s;
 	}

	//To verify sorting on property search table columns 
	public String verifythesortorderonPropertySearch(String column,String sortOrder)
	 {

		 String result="FAIL";
		 int size;
		 try{ propertysearch.sortProperties(column,sortOrder); Thread.sleep(5000);}
		 catch(Exception e){return result;} 
		 try{
		 List<WebElement> propertiesSearchResult = driver.findElements(By.cssSelector("#search-results > tbody > tr"));
		    size= propertiesSearchResult.size();
		    if(size==0 || size==1) // if no records are present or only one record is present
		  	{
		  		result="SKIP";
		  	}
		    else{
		    	if(sortOrder.equalsIgnoreCase("asc"))
				{
		    		if(column.equalsIgnoreCase("price"))
					{
		    			 for (int i=1;i<size;i++)  
					     {
					      for (int j=i+1;j<=size;j++)
					      { 
					       String priceUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(2) > span.currency_field")).getText().trim();
					       String priceUI2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(2) > span.currency_field")).getText().trim();
					       double price1=Double.parseDouble(JH.USCurrencyFormatToString(priceUI1));
					       double price2=Double.parseDouble(JH.USCurrencyFormatToString(priceUI2));
					        int diff = Double.compare(price1, price2); 
					              if (diff < 0 || diff == 0)
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
		    		else if(column.equalsIgnoreCase("investment"))
		    		{
		    			 for (int i=1;i<size;i++)  
					     {
					      for (int j=i+1;j<=size;j++)
					      { 
					       String investmentAMTUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(3) > span.currency_field")).getText().trim();
					       String investmentAMTU2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(3) > span.currency_field")).getText().trim();
					       double investmentAMT1=Double.parseDouble(JH.USCurrencyFormatToString(investmentAMTUI1));
					       double investmentAMT2=Double.parseDouble(JH.USCurrencyFormatToString(investmentAMTU2));
					        int diff = Double.compare(investmentAMT1, investmentAMT2); 
					              if (diff < 0 || diff == 0)
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
		    	   else if(column.equalsIgnoreCase("rent"))
				    		{
				    			 for (int i=1;i<size;i++)  
							     {
							      for (int j=i+1;j<=size;j++)
							      { 
							       String rentUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(4) > span.currency_field")).getText().trim();
							       String rentUI2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(4) > span.currency_field")).getText().trim();
							       double rentAMT1=Double.parseDouble(JH.USCurrencyFormatToString(rentUI1));
							       double rentAMT2=Double.parseDouble(JH.USCurrencyFormatToString(rentUI2));
							        int diff = Double.compare(rentAMT1, rentAMT2); 
							              if (diff < 0 || diff == 0)
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
		    			 else if(column.equalsIgnoreCase("Cash On Cash Return"))
				    		{
				    			 for (int i=1;i<size;i++)  
							     {
							      for (int j=i+1;j<=size;j++)
							      { 
							       String cocRETUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(5) > span.percent_field")).getText().trim();
							       String cocRETUI2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(5) > span.percent_field")).getText().trim();
							       if(cocRETUI1.equals("-")){cocRETUI1="0.0";}
							       if(cocRETUI2.equals("-")){cocRETUI2="0.0";}
							       double cocRET1=Double.parseDouble(removePercent(cocRETUI1));
							       double cocRET2=Double.parseDouble(removePercent(cocRETUI2));
							        int diff = Double.compare(cocRET1, cocRET2); 
							              if (diff < 0 || diff == 0)
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
		    			 else if(column.equalsIgnoreCase("yield"))
				    		{
				    			 for (int i=1;i<size;i++)  
							     {
							      for (int j=i+1;j<=size;j++)
							      { 
							       String yieldUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(6) > span.percent_field")).getText().trim();
							       String yieldUI2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(6) > span.percent_field")).getText().trim();
							       if(yieldUI1.equals("-")){yieldUI1="0.0";}
							       if(yieldUI2.equals("-")){yieldUI2="0.0";}
							       double yield1=Double.parseDouble(removePercent(yieldUI1));
							       double yield2=Double.parseDouble(removePercent(yieldUI2));
							        int diff = Double.compare(yield1, yield2); 
							              if (diff < 0 || diff == 0)
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
		    			 else if(column.equalsIgnoreCase("Total return"))
				    		{
				    			 for (int i=1;i<size;i++)  
							     {
							      for (int j=i+1;j<=size;j++)
							      { 
							       String TOTRETUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(7) > span.percent_field")).getText().trim();
							       String TOTRETUI2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(7) > span.percent_field")).getText().trim();
							       if(TOTRETUI1.equals("-")){TOTRETUI1="0.0";}
							       if(TOTRETUI2.equals("-")){TOTRETUI2="0.0";}
							       double TOTRET1=Double.parseDouble(removePercent(TOTRETUI1));
							       double TOTRET2=Double.parseDouble(removePercent(TOTRETUI2));
							        int diff = Double.compare(TOTRET1, TOTRET2); 
							              if (diff < 0 || diff == 0)
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
		    	else if(sortOrder.equalsIgnoreCase("desc"))
		    	{
		    		if(column.equalsIgnoreCase("price"))
					{
		    			 for (int i=1;i<size;i++)  
					     {
					      for (int j=i+1;j<=size;j++)
					      { 
					       String priceUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(2) > span.currency_field")).getText().trim();
					       String priceUI2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(2) > span.currency_field")).getText().trim();
					       double price1=Double.parseDouble(JH.USCurrencyFormatToString(priceUI1));
					       double price2=Double.parseDouble(JH.USCurrencyFormatToString(priceUI2));
					        int diff = Double.compare(price1, price2); 
					              if (diff > 0 || diff == 0)
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
		    		else if(column.equalsIgnoreCase("investment"))
		    		{
		    			 for (int i=1;i<size;i++)  
					     {
					      for (int j=i+1;j<=size;j++)
					      { 
					       String investmentAMTUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(3) > span.currency_field")).getText().trim();
					       String investmentAMTU2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(3) > span.currency_field")).getText().trim();
					       double investmentAMT1=Double.parseDouble(JH.USCurrencyFormatToString(investmentAMTUI1));
					       double investmentAMT2=Double.parseDouble(JH.USCurrencyFormatToString(investmentAMTU2));
					        int diff = Double.compare(investmentAMT1, investmentAMT2); 
					              if (diff > 0 || diff == 0)
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
		    	   else if(column.equalsIgnoreCase("rent"))
				    		{
				    			 for (int i=1;i<size;i++)  
							     {
							      for (int j=i+1;j<=size;j++)
							      { 
							       String rentUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(4) > span.currency_field")).getText().trim();
							       String rentUI2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(4) > span.currency_field")).getText().trim();
							       double rentAMT1=Double.parseDouble(JH.USCurrencyFormatToString(rentUI1));
							       double rentAMT2=Double.parseDouble(JH.USCurrencyFormatToString(rentUI2));
							        int diff = Double.compare(rentAMT1, rentAMT2); 
							              if (diff > 0 || diff == 0)
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
		    			 else if(column.equalsIgnoreCase("Cash On Cash Return"))
				    		{
				    			 for (int i=1;i<size;i++)  
							     {
							      for (int j=i+1;j<=size;j++)
							      { 
							       String cocRETUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(5) > span.percent_field")).getText().trim();
							       String cocRETUI2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(5) > span.percent_field")).getText().trim();
							       if(cocRETUI1.equals("-")){cocRETUI1="0.0";}
							       if(cocRETUI2.equals("-")){cocRETUI2="0.0";}
							       double cocRET1=Double.parseDouble(removePercent(cocRETUI1));
							       double cocRET2=Double.parseDouble(removePercent(cocRETUI2));
							        int diff = Double.compare(cocRET1, cocRET2); 
							              if (diff > 0 || diff == 0)
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
		    			 else if(column.equalsIgnoreCase("yield"))
				    		{
				    			 for (int i=1;i<size;i++)  
							     {
							      for (int j=i+1;j<=size;j++)
							      { 
							       String yieldUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(6) > span.percent_field")).getText().trim();
							       String yieldUI2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(6) > span.percent_field")).getText().trim();
							       if(yieldUI1.equals("-")){yieldUI1="0.0";}
							       if(yieldUI2.equals("-")){yieldUI2="0.0";}
							       double yield1=Double.parseDouble(removePercent(yieldUI1));
							       double yield2=Double.parseDouble(removePercent(yieldUI2));
							        int diff = Double.compare(yield1, yield2); 
							              if (diff > 0 || diff == 0)
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
		    			 else if(column.equalsIgnoreCase("Total return"))
				    		{
				    			 for (int i=1;i<size;i++)  
							     {
							      for (int j=i+1;j<=size;j++)
							      { 
							       String TOTRETUI1=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(7) > span.percent_field")).getText().trim();
							       String TOTRETUI2=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+j+") > td:nth-of-type(7) > span.percent_field")).getText().trim();
							       if(TOTRETUI1.equals("-")){TOTRETUI1="0.0";}
							       if(TOTRETUI2.equals("-")){TOTRETUI2="0.0";}
							       double TOTRET1=Double.parseDouble(removePercent(TOTRETUI1));
							       double TOTRET2=Double.parseDouble(removePercent(TOTRETUI2));
							        int diff = Double.compare(TOTRET1, TOTRET2); 
							              if (diff > 0 || diff == 0)
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
		 }
		   catch(Exception e)//if no any property is present
		   {
		     result="PASS";
		   }
		    return result;
	 }
	
	//To verify the property status(available)
	public String verifythePropertyStatus()
	{
		 String result="FAIL";
		 int size;
		 int totalPages;
		 boolean flag =false;
		 try{
		 List<WebElement> propertiesSearchResult = driver.findElements(By.cssSelector("#search-results > tbody > tr"));
		    size= propertiesSearchResult.size();
		    if(size==0) // if no record is present
		  	{
		  		result="SKIP";
		  	}
		    else{
				List<WebElement> propertiesSearchPages = driver.findElements(By.cssSelector("#search-results_paginate > ul > li"));
		    	totalPages=propertiesSearchPages.size();
		    	if(totalPages > 4)
		    	{	
		    	totalPages=totalPages-1;	
		    	for(int j=3;j<=totalPages;j++)	
		    	{
		    		if(j==totalPages){
		    		flag=true;
		    		String lastPagecheck=driver.findElement(By.cssSelector("#search-results_paginate > ul > li:nth-child("+j+")")).getAttribute("class").trim();
		    		if(lastPagecheck.equalsIgnoreCase("next disabled"))
		    		{
		    			break;
		    		}	
		    	}
		    	try{	
		    	 propertysearch.gotoNextPage(j);if(flag){j--;}
		    	 Thread.sleep(5000);
		    	 propertiesSearchResult.clear();
		    	 propertiesSearchResult = driver.findElements(By.cssSelector("#search-results > tbody > tr"));
				 size= propertiesSearchResult.size();
		    	 for (int i=1;i<=size;i++)  
			     {
		        	 String propertyStatus=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(8) > span:nth-of-type(1)")).getText().trim();
		    		 if(propertyStatus.equalsIgnoreCase("Available"))
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
		      catch(Exception e)//For any exception
		  	   {
		  	     result="SKIP";
		  	   }
		     }
	        }
		  }
       }
	   catch(Exception e)//if no any property is present
	   {
	     result="PASS";
	   }
		 
	    return result;
    }
  
	   //To verify the property's NIR
		public String verifytheNIRstatus(String ENV)
		{
			 String result="FAIL";
			 int size;
			 int totalPages;
			 boolean flag =false;
			 int column=1;
			 try{
			 List<WebElement> propertiesSearchResult = driver.findElements(By.cssSelector("#search-results > tbody > tr"));
			 size= propertiesSearchResult.size();
			    if(size==0) // if no record is present
			  	{
			  		result="SKIP";
			  	}
			    else{
					List<WebElement> propertiesSearchPages = driver.findElements(By.cssSelector("#search-results_paginate > ul > li"));
			    	totalPages=propertiesSearchPages.size();
			    	if(totalPages > 4)
			    	{	
			    	totalPages=totalPages-1;	
			    	for(int j=3;j<=totalPages;j++)	
			    	{
			    		if(j==totalPages){
			    		flag=true;
			    		String lastPagecheck=driver.findElement(By.cssSelector("#search-results_paginate > ul > li:nth-child("+j+")")).getAttribute("class").trim();
			    		if(lastPagecheck.equalsIgnoreCase("next disabled"))
			    		{
			    			break;
			    		}	
			    	}
			    	try{	
			    	 propertysearch.gotoNextPage(j);if(flag){j--;}
			    	 Thread.sleep(5000);
			    	 propertiesSearchResult.clear();
			    	 propertiesSearchResult = driver.findElements(By.cssSelector("#search-results > tbody > tr"));
					 size= propertiesSearchResult.size();
			    	 for (int i=1;i<=size;i++)  
				     {
			        	 String propertyNIR=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(1) > div > div > div > p:nth-child(5) > span")).getText().trim();
			        	 String propertyAddress=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(1) > div > div > div > b")).getText().trim();
			    	   if(propertyNIR.equals("") || propertyNIR.equalsIgnoreCase("NA"))
			    	   {
			    		   result="FAIL NIR NOT PRESENT ON UI - " + propertyAddress;
			               break;
			    	   }   
			    	   else{	 
			        	 String propertyID=driver.findElement(By.cssSelector("#search-results > tbody > tr:nth-child("+i+") > td:nth-of-type(1) > div > div.property.propertyAddr")).getAttribute("data-property-id").trim();
			        	 String sqlQuery="Select NIR from properties.tblproperty where propertyid='"+propertyID+"';";
			    		 String propertyNIRDB = db.getDBData(ENV,sqlQuery,column);
			    		 if(propertyNIR.equalsIgnoreCase(propertyNIRDB))
			    		 {
			    			 result="PASS";
			             }
			             else
			             {
			            	 result=" FAIL NIR NOT MATCH WITH DB - " + propertyAddress;
				             break;
			             } 
				      }
				     }
			    	 if(result.contains("FAIL"))
				       {
				         break;
				       } 
			       }
			      catch(Exception e)//For any exception
			  	   {
			  	     result="SKIP";
			  	   }
			     }
		        }
			  }
	       }
		   catch(Exception e)//if no any property is present
		   {
		     result="PASS";
		   }
			 
		    return result;
	    }
	  
	   //To verify the message if no any portfolio is present in the portfolio List
		public String removeallportfolios()
        {
			
	    	 String result="FAIL";
			 int size;
			 int lastrecord;
			 String noPropertyMsg;
			 try{
					  	List<WebElement> portfolioList = driver.findElements(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing"));
					  	size= portfolioList.size();
					  	if(size==0) // if no records are present 
					  	{
					  		noPropertyMsg=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div > div > div.noInvestProp > div > span")).getText().trim();
					        if(noPropertyMsg.equalsIgnoreCase("There are no investment portfolios in your Watch List."))
					        {
					        	result="PASS";
					        }  
					        else
					        {
					        	result="FAIL";
					        }
					  	}
					  	else
					  	{
					  		lastrecord=size+2;
					  		for(int i=3;i<=lastrecord;i++)
					  		{
					  		 String buttonName=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing:nth-child("+i+") > div > div.propdet > div > div.watch-list-btns > button.removeWL > b")).getText().trim();
					  		 if(buttonName.contains("Cancel Bid"))
					  		 {
					  			  try{
							  		 driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing:nth-child("+i+") > div > div.propdet > div > div.watch-list-btns > button.removeWL > b")).click();	
							  		 }
							  		 catch(Exception e)
							  		 {
								  		driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing:nth-child("+i+") > div > div.propdet > div > div.watch-list-btns > button.removeWL > b")).click();	
								   	 }
					  			 Thread.sleep(2000);
					  		     driver.findElement(By.cssSelector("#modal-cancel > div > div > div.modal-footer > button.confirm-cancel-bid")).click();
					  			 Thread.sleep(9000);
					  		 }
					  		}
					  		for(int i=3;i<=lastrecord;i++)
					  		{
					  		 int j=3;	
					  		 try{
					  		 driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing:nth-child("+j+") > div > div.propdet > div > div.watch-list-btns > button.removeWL > b")).click();	
					  		 }
					  		 catch(Exception e)
					  		 {
						  		driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div > div.listing:nth-child("+j+") > div > div.propdet > div > div.watch-list-btns > button.removeWL > b")).click();	
						   	 }
					  		    Thread.sleep(2000);
					  		    driver.findElement(By.cssSelector("#modal-remove > div > div > div.modal-footer > button.confirm-remove")).click();
					  		    Thread.sleep(10000);
					  		}	
					  		noPropertyMsg=driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div > div > div.noInvestProp > div > span")).getText().trim();
					        if(noPropertyMsg.equalsIgnoreCase("There are no investment portfolios in your Watch List."))
					        {
					        	result="PASS";
					        }  
					        else
					        {
					        	result="FAIL";
					        }
	  		      	}
			
			 }catch(Exception e){}
			
			return result;
        }
}
