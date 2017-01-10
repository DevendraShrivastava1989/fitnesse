package pageFactory.Embrace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utility.Constants;
import utility.JavaHelpers;

public class ILMReviewListingPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public ILMReviewListingPage(WebDriver driver)
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
	
		@FindBy(id="rets_listings")
		public WebElement RETSListingIFrame;
		
		@FindBy(id="resetModifiedDate")
		public WebElement MLSModifiedDateXButton;
		
		@FindBy(id="dd_mls")
		public WebElement MLS;
		
		@FindBy(id="mlsNumber")
		public WebElement mlsNumber;
		
		@FindBy(id="minSalePrice_c")
		public WebElement minSalePrice;
		
		@FindBy(id="address1")
		public WebElement Address;
		
		@FindBy(id="searchProperty")
		public WebElement Search;
		
		@FindBy(id="searchResultTable_processing")
		public WebElement Search_Processing;
		
		@FindBy(id="rentreasons")
		public WebElement RentReviewReason;	
		
		//Select MLS
		public void SelectMLS(String mls)
		{
			driver.findElement(By.cssSelector("div#dd_mls_chosen a")).click();
			try { Thread.sleep(2000);} catch (InterruptedException e1) {}
			
			for(int i=1; i<=10;i++)
			{
				String cssSelector = "#dd_mls_chosen > div > ul > li:nth-child(" + i + ")";
				String text = driver.findElement(By.cssSelector(cssSelector)).getText();
				if(text.equalsIgnoreCase(mls))
				{
					driver.findElement(By.cssSelector(cssSelector)).click();
					try { Thread.sleep(5000);} catch (InterruptedException e1) {}
					break;
				}
			}
			
		}
		
		public void waitTillProcessingDone()
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("searchResultTable_processing")));
			} catch (Exception e) {
				System.out.println("Error in loading Results Table.");
			}
		}
						
		//Search Result table > to get Property Details link for First Record
		public String ToGetPropDetailsLink(int i)
		{
			String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(4) a";
			return driver.findElement(By.cssSelector(cssSelector)).getAttribute("href"); 
		}
		
		//Get MLS
		public String ToGetPropMLS(int i)
		{
			String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(4) a";
			return driver.findElement(By.cssSelector(cssSelector)).getText().trim(); 
		}
		
		//Get Address
		public String ToGetPropAddress(int i)
		{
			String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(5)";
			return driver.findElement(By.cssSelector(cssSelector)).getText().trim(); 
		}
		
		//Get Rent
		public String ToGetPropRent(int i)
		{
			String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(12) input";
			return driver.findElement(By.cssSelector(cssSelector)).getAttribute("value").trim(); 
			
		}
		
		public String GetSelectedRentReviewReason()
		{
			return new Select(RentReviewReason).getFirstSelectedOption().getText().trim();
		}
		
		// To get total results
		public int ToGetTotalResultsRow() {
			String cssSelector = "table#searchResultTable tbody tr";
			try {
				List<WebElement> all = driver.findElements(By.cssSelector(cssSelector));
				return all.size();
			} catch (Exception e1) {
				return 0;
			}
		}

				
		//Common functions
		
			// Get data from any column's text box
			public String ToGetAnyRowColumnTextboxData(int row, int column)
			{
				String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") input";
				return driver.findElement(By.cssSelector(cssSelector)).getAttribute("value").trim();
			}
			
			// Get data from any column (non text box)
			public String ToGetAnyRowColumnData(int row, int column)
			{
				String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim(); 
			}	
	
}
