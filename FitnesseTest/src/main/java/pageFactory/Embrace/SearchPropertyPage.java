package pageFactory.Embrace;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constants;
import utility.JavaHelpers;


public class SearchPropertyPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	static int randomint1 = 0;
	static int randomint2 = 0;
	static int randomint3 = 0;
	static int randomint4 = 0;

	
	public SearchPropertyPage(WebDriver driver)
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
	
		@FindBy(id="searchProperty")
		public WebElement Search;
		
		@FindBy(name="propertySearchResultsTable_length")
	    WebElement RecordsDropdown;
		
		@FindBy(id="address")
	    public WebElement Address;
		
		//set search records on Table e.g. 25,50,100 etc.
		public void SetSearchRecord(String i)
		{
			new Select(RecordsDropdown).selectByVisibleText(i);
		}
			
		public void SearchAndNavigateToPropertyDetailsPage()
		{
			Random t = new Random();
			int i = 0;
			i = t.nextInt(20);
			
			while ( (i == randomint1) || (i == randomint2) || (i == randomint3))
			{
				i = t.nextInt(20);
			}
			
			if (randomint1 == 0)
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
				
		    System.out.println(i);
		    
			Search.click(); 
			try {Thread.sleep(5000);} catch (InterruptedException e) {}	
			
			SetSearchRecord("100");
			try {Thread.sleep(5000);} catch (InterruptedException e) {}	
			
			String cssSelector = "#propertySearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(2) a";
			driver.findElement(By.cssSelector(cssSelector)).click();
		
		}
		
		public void SearchpropAndNavigateToPropertyDetailsPage(String propertyType)
		{
			Random t = new Random();
			int i = 0;
			i = t.nextInt(20);
			
			while ( (i == randomint1) || (i == randomint2) || (i == randomint3))
			{
				i = t.nextInt(20);
			}
			
			if (randomint1 == 0)
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
				
		   // System.out.println(i);
		    toselectPropertyType(propertyType);
			Search.click(); 
			try {Thread.sleep(5000);} catch (InterruptedException e) {}	
			
			SetSearchRecord("100");
			try {Thread.sleep(5000);} catch (InterruptedException e) {}	
			
			String cssSelector = "#propertySearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(2) a";
			driver.findElement(By.cssSelector(cssSelector)).click();
		
		}
		@FindBy(id="propertySearchResultsTable_processing")
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
		
		
		//Search Result table > to get Property Status for ith Record
		
		public String ToGetPropertyStatus(int i)
		{
			String cssSelector = "table#propertySearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(8)";
			try {
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			} catch (Exception e) {
				return "No such record found in Search results";
			}
		}
		
		public String ToGetPropertyAddress(int i)
		{
			String cssSelector = "table#propertySearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(3)";
			try {
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			} catch (Exception e) {
				return "No such record found in Search results";
			}
		}
		
		public void ToNavigatePropertyDetailsPage(int i)
		{
			String cssSelector = "table#propertySearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(2) a";
			WebDriverWait wait = new WebDriverWait(driver, 20);
			try	{
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
			} catch (Exception e){}
			driver.findElement(By.cssSelector(cssSelector)).click();
			try {Thread.sleep(10000);} catch (InterruptedException e) {}
		}
		
		public void ToClickOnActionIconAndNavigateToDetails(int i)
		{
			String cssSelector = "#propertySearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) i.fa-gear";
			driver.findElement(By.cssSelector(cssSelector)).click();
			cssSelector = "#propertySearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) > div > ul > li";
			driver.findElement(By.cssSelector(cssSelector)).click();
			try {Thread.sleep(10000);} catch (InterruptedException e) {}
		}
		
		public void toselectPropertyType(String propertyType)
		{
			int i=1;
			if(propertyType.equalsIgnoreCase("SFH"))
			{
				i=2;
			}	
			else if(propertyType.equalsIgnoreCase("MFH"))
			{
				i=3;
			}
			//String cssSelector = "table#propertySearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(2) a";
			String cssSelector = "#search_form > div > div:nth-child(3) > div.col-md-12 > div:nth-child(2) > div:nth-child(9) > div:nth-child(7) > div:nth-child(1) > div > label:nth-child(" + i + ")";
			WebDriverWait wait = new WebDriverWait(driver, 20);
			try	{
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
			} catch (Exception e){}
			driver.findElement(By.cssSelector(cssSelector)).click();
			try {Thread.sleep(8000);} catch (InterruptedException e) {}
		}
		
		
		
}
