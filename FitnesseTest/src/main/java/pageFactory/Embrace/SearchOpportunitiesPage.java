package pageFactory.Embrace;

//import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utility.Constants;
import utility.JavaHelpers;

public class SearchOpportunitiesPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public SearchOpportunitiesPage(WebDriver driver)
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
	
		@FindBy(name="searchResultTable_length")
	    WebElement RecordsDropdown;
		
		@FindBy(id="searchOpportunityButton")
	    WebElement Search;
		
		@FindBy(name="opportunityStatusId")
	    WebElement OpportunityStatus;
		
		// Result Table
			public void SelectOppStatus(String status)
			{
				new Select(OpportunityStatus).selectByVisibleText(status);
			}
		
			//set search records on Table e.g. 25,50,100 etc.
			public void SetSearchRecord(String i)
			{
				new Select(RecordsDropdown).selectByVisibleText(i);
			}
			
			public String GetTableData(int row, int column)
			{
				String cssSelector = "#searchResultTable tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			

		
		//Click on 'View Details' link for any investor
		public void ClickOnViewDetailsLink(int i)
		{
  
			SelectOppStatus("New");
			try { Thread.sleep(2000);} catch (InterruptedException e1) {}
	 	    Search.click();
	 	   try { Thread.sleep(3000);} catch (InterruptedException e1) {}
		    Search.click();
		    waitTillProcessingDone();
		    
		    /*SetSearchRecord("50");
			Thread.sleep(5000);*/

			String cssSelector = "#searchResultTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(6) a";
			driver.findElement(By.cssSelector(cssSelector)).click();
			
			try { Thread.sleep(30000);} catch (InterruptedException e1) {}
			
		}
		
		
		@FindBy(id="searchResultTable_processing")
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
