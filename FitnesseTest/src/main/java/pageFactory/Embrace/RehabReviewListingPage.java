package pageFactory.Embrace;

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

public class RehabReviewListingPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public RehabReviewListingPage(WebDriver driver)
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
		
		@FindBy(id="searchProperty")
		public WebElement Search;
		
		@FindBy(id="searchResultTable_processing")
		public WebElement Search_Processing;
		
		public void waitTillProcessingDone()
		{
			/*for (int i = 1; i < 120; i++) {
				try {Thread.sleep(1000);} catch (InterruptedException e1) {}
				try {
					String temp = Search_Processing.getAttribute("style");
					if (temp.contains("hidden")) {
						break;
					}
				} catch (Exception e2) {
					break;
				}*/
			WebDriverWait wait = new WebDriverWait(driver, 120);
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("searchResultTable_processing")));
			} catch (Exception e) {
				System.out.println("Error in loading Results Table.");
			}
		}
		
		// Buttons
				@FindBy(id="process")
				public WebElement Process;
				
				@FindBy(id="update")
				public WebElement Save;
				
				@FindBy(id="hide")
				public WebElement Hide;
				
				@FindBy(id="removeProperty")
				public WebElement Remove;
				
				
		@FindBy(id="rentReviewCheckBox")
		public WebElement rentReviewCheckBox;
		
		@FindBy(id="rehabReviewCheckBox")
		public WebElement rehabReviewCheckBox;
				
					
		
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
			String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(7)";
			return driver.findElement(By.cssSelector(cssSelector)).getText().trim(); 
		}
		
		//Get Rent
		public String ToGetPropRent(int i)
		{
			String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(14) input";
			return driver.findElement(By.cssSelector(cssSelector)).getAttribute("value").trim(); 
			
		}
				
				
		@FindBy(id="rentreasons")
		public WebElement RentReviewReason;	
		
		public String GetSelectedRentReviewReason()
		{
			return new Select(RentReviewReason).getFirstSelectedOption().getText().trim();
		}

				
		//Common functions
		
			//Selecting checkbox for 'Select' column
			public void ToSelectCheckboxForSelectColumn(int i)
			{
				String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) input";
				driver.findElement(By.cssSelector(cssSelector)).click();
			}
		
			// Enter data to any column's text box
			public void ToEnterDataInAnyRowColumnTextbox(int row, int column, String data)
			{
				String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") input";
				driver.findElement(By.cssSelector(cssSelector)).clear();
				driver.findElement(By.cssSelector(cssSelector)).sendKeys(data);
			}
		
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
