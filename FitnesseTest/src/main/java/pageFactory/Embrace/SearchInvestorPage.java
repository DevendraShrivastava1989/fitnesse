package pageFactory.Embrace;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utility.Constants;
import utility.JavaHelpers;

public class SearchInvestorPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	static int randomint1 = 0;
	static int randomint2 = 0;
	static int randomint3 = 0;
	static int randomint4 = 0;
	
	public SearchInvestorPage(WebDriver driver)
	{	 
        this.driver = driver;
 
        //This initElements method will create all WebElements
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.WebDriverWaitDuration), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
		@FindBy(name="investorSearchResultsTable_length")
	    WebElement RecordsDropdown;
		
		@FindBy(id="fname")
	    public WebElement Name;
		
		@FindBy(id="currentInvestor")
		WebElement CurrentInvestor;
		
		@FindBy(id="searchInvestor")
		public WebElement Search;
		
		// Result Table
		
			//set search records on Table e.g. 25,50,100 etc.
			public void SetSearchRecord(String i)
			{
				new Select(RecordsDropdown).selectByVisibleText(i);
			}
			
			@FindBy(css="#investorSearchResultsTable thead tr:nth-of-type(1) th:nth-of-type(5)")
		    WebElement ActiveColumn;
			
			public String GetTableData(int row, int column)
			{
				String cssSelector = "#investorSearchResultsTable tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			
			public void ClickOnAnyInvestorName(int row)
			{
				String cssSelector = "#investorSearchResultsTable tbody tr:nth-of-type(" + row + ") td:nth-of-type(2) a";
				driver.findElement(By.cssSelector(cssSelector)).click();
				 try {Thread.sleep(10000);} catch (InterruptedException e) {}	
			}
			
			
			
			

		
		//Get any Investor First Name randomly 
		public String GetAnyInvestorFirstName()
		{
			Random t = new Random();
		    int i = t.nextInt(50);//change by karthik - chanhed from 100 to 50
		    
		    while ( (i == randomint1) || (i == randomint2) || (i == randomint3))
			{
				i = t.nextInt(50);
			}
			
			if (randomint1 == 0 )
			{
				randomint1 = i;
			}
			else if (randomint2 == 0)
			{
				randomint2 = i;
			}
			else if (randomint3 == 0)
			{
				randomint3 = i;
			}
			else if (randomint4 == 0)
			{
				randomint4 = i;
			}
		    
		    CurrentInvestor.click();
		    try {Thread.sleep(2000);} catch (InterruptedException e) {}	
		    
		    Search.click();
		    waitTillProcessingDone();
		    
		    SetSearchRecord("50");
		    waitTillProcessingDone();
			
			// Sorting by Active field
			ActiveColumn.click(); 
			waitTillProcessingDone();
			ActiveColumn.click(); 
			waitTillProcessingDone();
			
			//Making sure , investor is active, so active=Yes
			/*while(!GetTableData(i,5).equals("Yes"))
			{
				i = t.nextInt(50);
			}*/
			
			String cssSelector = "#investorSearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(2) a";
		    String name = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
		    String firstname = JH.ToGetFistNthWordFromString(name,1);
		    return firstname;
		}
		
		@FindBy(id="investorSearchResultsTable_processing")
		public WebElement Search_Processing;
		
		public void waitTillProcessingDone()
		{
			for(int i=1;i < 120; i++)
			{
				try { Thread.sleep(1000);} catch (InterruptedException e1) {}
				
				try {

					String temp = Search_Processing.getAttribute("style");
					if(temp.contains("none"))
					{
						break;
					}
					
				}
				catch (Exception e2) 
				{
					break;
				}
				
			}
		}
		
		
}
