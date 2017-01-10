package pageFactory.InvestorPortal_Mobile;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constants;
import utility.JavaHelpers;

public class PropertySearchPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public PropertySearchPage(WebDriver driver)
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
	
	    @FindBy(xpath="//span[@id='adjustTheFilters']")
        public WebElement AdjustFilters;

	    @FindBy(xpath="//a[@href='#property-search']")
	    public WebElement PropertySearchTab;
	    
	    @FindBy(xpath="//div [@class='panel-heading p-r-0']/h4/a")
	    public WebElement ResetFilter;
	    
	    @FindBy(xpath="//table[@id='search-results']/thead[1]/tr/th[2]")
	    public WebElement PriceSort;
	    
	    @FindBy(xpath="//table[@id='search-results']/thead[1]/tr/th[3]")
	    public WebElement InvestmentSort;
	    
	    @FindBy(xpath="//table[@id='search-results']/thead[1]/tr/th[4]")
	    public WebElement CashOnCashReturnSort;
	    
	    @FindBy(xpath="//table[@id='search-results']/thead[1]/tr/th[5]")
	    public WebElement YieldSort;
	    
	    @FindBy(xpath="//table[@id='search-results']/thead[1]/tr/th[6]")
	    public WebElement TotalReturnSort;
	   
	    @FindBy(id="invAmount")
		public WebElement InvestmentAmount;
		
		@FindBy(css="#asset_prop_srch_form h3")
		public WebElement PageHeader;
		
		@FindBy(css="button.search")
		public WebElement Search;
		
		@FindBy(id="recalculate")
		public WebElement Search_mobile;
		
		@FindBy(css="i.addWL")
		public WebElement AddToWishList_STAR ;
		
		@FindBy(css="#message_modal div.modal-body p")
		public WebElement AddToWishList_ConfirmationMessage_Text; 
		
		@FindBy(css="#message_modal div.modal-footer button")
		public WebElement AddToWishList_ConfirmationMessage_OK; 
		
		@FindBy(css="i.removeWL")
		public WebElement RemoveFromWishList_STAR_Remove; 
		
		@FindBy(css="#wishlistbuy div.modal-body p")
		public WebElement RemoveFromWishList_ConfirmationMessage_Text; 
		
		@FindBy(css="#wishlistbuy div.modal-footer button")
		public WebElement RemoveFromWishList_ConfirmationMessage_YES; 
	
		//Explicit wait
		public void ExplitWait(String element)
		{
			
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		
		}
		
		
		//Location
		public void SelectLocation(String location)
		{
			//Expanding location dropdown
			driver.findElement(By.cssSelector("a.anyLocation p")).click();
			
			List<WebElement> alllocations = driver.findElements(By.cssSelector("#hil-list label"));
			for(WebElement e:alllocations)
			{
				String temp = e.getText().trim();
				if(temp.equals(location))
				{
					e.click();
					break;
				}
					
			}
		
		}
		
		//Locations
		public void SelectLocations(String[] locations)
		{
			//Expanding location dropdown
			driver.findElement(By.cssSelector("a.anyLocation p")).click();
			
			List<WebElement> alllocations = driver.findElements(By.cssSelector("#hil-list label"));
			for(WebElement e:alllocations)
			{
				String temp = e.getText().trim();
				
				for(int i=0;i<locations.length;i++){
					
					if(temp.equals(locations[i]))
					{
						e.click();
					
					}
					
				}
				
				
			}
		
		}
		
		
		
		
		//INVESTMENT GOAL
		public void SelectInvestmentGoal(String goal) throws InterruptedException
		{
			//Expanding Investment Goal dropdown
			driver.findElement(By.cssSelector("a.investmentGoalSelected")).click();
			Thread.sleep(2500);
			
			List<WebElement> allgoals = driver.findElements(By.cssSelector("#inv-goal-list li"));
			for(WebElement e:allgoals)
			{
				String temp = e.getText().trim();
				if(temp.equals(goal))
				{
					e.click();
					break;
				}
					
			}
			
		
		}
		
		//INVESTMENT STYLE
		public void SelectInvestmentStyle(String investmentStyle) throws InterruptedException
		{
			//Expanding Investment Style dropdown
			driver.findElement(By.xpath("//a[@class='investmentStyleSelected pointer']")).click();
			Thread.sleep(2500);
					
			List<WebElement> allstyles = driver.findElements(By.cssSelector("#inv-style-list li"));
			for(WebElement e:allstyles)
			{
				String temp = e.getText().trim();
				if(temp.equals(investmentStyle))
				{
					e.click();
					break;
				}
							
			}
					
				
		}
		
		//INVESTMENT STRATEGY
		public void SelectInvestmentStrategy(String strategy) throws InterruptedException
		{
			//Expanding Investment Style dropdown
			driver.findElement(By.xpath("//a[@class='investmentStrategySelected pointer']")).click();
			Thread.sleep(2500);
							
			List<WebElement> allstrategies = driver.findElements(By.cssSelector("#inv-strategy-list li"));
			for(WebElement e:allstrategies)
			{
				String temp = e.getText().trim();
				if(temp.equals(strategy))
				{
					e.click();
					break;
				}
									
			}
							
						
		}	
		//FINANCING
		public void SelectFinancing(String type) throws InterruptedException
		{
			//Expanding Financing dropdown
			
			driver.findElement(By.cssSelector("a.financingSelectedOption")).click();
			Thread.sleep(2500);
			
			List<WebElement> allfinancing = driver.findElements(By.cssSelector("#fin-type-list li"));
	        for(WebElement e:allfinancing)
			{
				String temp = e.getText().trim();
				if(temp.equals(type))
				{
					e.click();
					break;
				}
					
			}
		}
		
		//Neighborhood
		public void SelectNeighborhood(String type) throws InterruptedException
		{
			//Expanding Neighborhood dropdown
			
		    driver.findElement(By.xpath("//p[@class='multiSel2 m-b-0']")).click(); 
		    Thread.sleep(2500);
			
			List<WebElement> allneighborhood = driver.findElements(By.cssSelector("#nir-list label"));
			for(WebElement e:allneighborhood)
			{
				String temp = e.getText().trim();
				if(temp.equals(type))
				{
					System.out.println(temp);
					e.click();
					break;
				}
					
			}
		}

		
		//Table
		
		public int GetTotalPropertiesCount()
		{
			//List<WebElement> totalrows = driver.findElements(By.cssSelector("#search-results tbody tr"));
			List<WebElement> totalrows = driver.findElements(By.xpath("//table[@id='search-results']/tbody/tr"));
			return totalrows.size();
		}
	
		public String GetTableData(int row, int column)
		{
			
			//String xpath = "//span[@class='currency_field fontBoldTab valueSpan']";
			
			String xpath = "//table[@id='search-results']/tbody/tr[" +row+ "]/td[2]/span[3]/span[2]";
			return driver.findElement(By.xpath(xpath)).getText().trim();
		}
		
		public String GetTableData_investment()
		{
			
			String xpath = "//span[@class='displayBlock m-t-5 hideInDesk']/span[2]";
			
			return driver.findElement(By.xpath(xpath)).getText().trim();
		}
		
		
		public String GetPropertyClassInfo(int row)
		{
			//String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") a.asset-class";
			String xpath = "//table[@id='search-results']/tbody/tr["+ row +"]/td[1]/div[1]/div[2]/div/p";
			return driver.findElement(By.xpath(xpath)).getText().trim();
		}


		//Click on Property on table and navigate to Property Details page
		public void ClickOnProperty(int row) throws InterruptedException
		{   
			Thread.sleep(5000);
			
		  
		    WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) div.property b")));
		    
		    Thread.sleep(3000);
		    
		  	   
		    String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) div.property b";
		    driver.findElement(By.cssSelector(cssSelector)).click();
		
		}
		
	
		
		public void ClickOnRandomProperty(int row, String browser) throws InterruptedException
		{   
			Thread.sleep(5000);
			
		  
		    WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) div.property b")));
		    Thread.sleep(3000);
		    
		    // For Firefox browser, need to scroll to the particular property to make it visible on the page before the click. 
		    if(browser.equalsIgnoreCase("firefox")){
		    
		    int propertynumber= row-1;
		    Point hoverItem =driver.findElement(By.cssSelector("#search-results tbody tr:nth-of-type(" + propertynumber + ") td:nth-of-type(1) div.property b")).getLocation();
		    ((JavascriptExecutor)driver).executeScript("return window.title;");    
		    Thread.sleep(6000);
		    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");"); 
		    }
		   
		    //Actual Click
		    String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) div.property b";
		    driver.findElement(By.cssSelector(cssSelector)).click();
		
		}
		
		public void ClickOnRandomProperty(int row) throws InterruptedException
		{   
			Thread.sleep(5000);
			
		  
		    WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) div.property b")));
		    Thread.sleep(3000);
		    
		   
		    //Actual Click
		    String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) div.property b";
		    driver.findElement(By.cssSelector(cssSelector)).click();
		
		}
		
		// Get Property address
		public String GetPropertyAddress(int row)
		{
			//String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(2) div.property div b";
			String xpath = "//table[@id='search-results']/tbody/tr[" +row+"]/td[1]/div[1]/div[2]/div/b";
			return driver.findElement(By.xpath(xpath)).getText().trim();
		}
		
		// Get Property Price
		public String GetPropertyPrice(int row)
		{
			
			String xpath = "//table[@id='search-results']/tbody/tr[" +row+"]/td[2]/span[2]/span[2]";
			return driver.findElement(By.xpath(xpath)).getText().trim();
		}
		
		// Get Property Investment
		public String GetPropertyInvestment(int row)
		{
			String xpath = "//table[@id='search-results']/tbody/tr[" +row+ "]/td[2]/span[3]/span[2]";
			return driver.findElement(By.xpath(xpath)).getText().trim();
		}
		
		
		
		// Get Property COC Return
		public String GetPropertyCOCReturn(int row)
		{
			String xpath = "//table[@id='search-results']/tbody/tr[" +row+ "]/td[2]/span[4]/span[2]";
			return driver.findElement(By.xpath(xpath)).getText().trim();
		}
		
		// Get Property Yield
		public String GetPropertyYield(int row)
		{
			String xpath = "//table[@id='search-results']/tbody/tr[" +row+ "]/td[3]/span[2]/span[2]";
			return driver.findElement(By.xpath(xpath)).getText().trim();
		}
		
		// Get Property Total Return
		public String GetPropertyTotalReturn(int row)
		{
			String xpath = "//table[@id='search-results']/tbody/tr[" +row+ "]/td[3]/span[3]/span[2]";
			return driver.findElement(By.xpath(xpath)).getText().trim();
		}
		
		public void ClickOnAnyProperty(int row)
		{
			String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) div.property b";
		//	return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
		}
		
		
		// Click on STAR button for adding property to WishList
		public void AddToWishList(int row)
		{
			String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(7) i.addWL";
			driver.findElement(By.cssSelector(cssSelector)).click();;
		}
		
		public void AddToWatchList(int row, int column) throws InterruptedException
		{   
		    Thread.sleep(2500);
			String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
			driver.findElement(By.cssSelector(cssSelector)).click();
		}
		
		//Click on Property Search tab
		public void ClickOnAdjustFilters()
		{
			AdjustFilters.click();
		}
		
		//Click on Property Search tab
		public void ClickOnPropertySearchTab()
		{
			PropertySearchTab.click();
		}
		
        //Click on Search button
		public void ClickOnSearchButton()
		{
			Search.click();
		}
		
		//Click on Search_mobile button
		public void ClickOnSearch_mobileButton()
		{
			Search_mobile.click();
		}
		
		public void ClickOnPriceSort()
		{
			PriceSort.click();
		}
		
		public void ClickOnInvestmentSort()
		{
			InvestmentSort.click();
		}
		
		public void ClickOnCashOnCashReturnSort()
		{
			CashOnCashReturnSort.click();
		}
		
		public void ClickOnYieldSort()
		{
			YieldSort.click();
		}
		
		public void ClickOnTotalReturnSort()
		{
			TotalReturnSort.click();
		}
		
		//Investment Amount
		public void InvestmentAmount(String investment)
		{
			InvestmentAmount.clear();
			InvestmentAmount.sendKeys(investment);
		
		}
		//Click on Reset filter link
		public void clickOnResetFilters() throws InterruptedException
		{
			//WebDriverWait wait = new WebDriverWait(driver,20);			 
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='resetFilter']")));		
			ResetFilter.click();
	
		}	
	    
	
		// Get Property neighborhood
		public String GetPropertyNeighborhood(int row)
		{
		//	String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) div.property>p span";
			String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) div.pull-left>p span";
			return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
		}
				
		
}
