package pageFactory.InvestorPortal;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
//import org.testng.Reporter;

import utility.Constants;
import utility.JavaHelpers;

public class WishListPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public WishListPage(WebDriver driver)
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
	
		
		@FindBy(css="h1.page-title")
		public WebElement PageHeader;
		
			
			@FindBy(css="i.fa-times")
			public WebElement RemoveFromWishList_STAR_Remove; 
			
			@FindBy(css="#wishlistbuy div.modal-body p")
			public WebElement RemoveFromWishList_ConfirmationMessage_Text; 
			
			@FindBy(css="#wishlistbuy div.modal-footer button")
			public WebElement RemoveFromWishList_ConfirmationMessage_YES; 
			
			@FindBy(css="div[id='message_modal'][style='display: block;'] div.modal-body p")
			public WebElement RemoveFromWishList_ConfirmationMessage_Text_1; 
			
			@FindBy(css="div[id='message_modal'][style='display: block;'] div.modal-footer button")
			public WebElement RemoveFromWishList_ConfirmationMessage_OK; 
			
			@FindBy(id="back_to_search")
			public WebElement Back; 
			
			@FindBy(css="a.button--sm")
			public WebElement SeeComparisonView; 
		
			//Table
			
			public String GetTableData(int row, int column)
			{
				String cssSelector = "#wl_table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			
			public int GetTotalPropertiesCount()
			{
				List<WebElement> totalrows = driver.findElements(By.cssSelector("#wl_table tbody tr"));
				return totalrows.size();
			}
			
			public String GetPropertyAddress(int row)
			{
				String cssSelector = "#wl_table tbody tr:nth-of-type(" + row + ") td:nth-of-type(2) b";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			
			public String GetPropertyClassInfo(int row)
			{
				String cssSelector = "#wl_table tbody tr:nth-of-type(" + row + ") a.asset-class";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			
			public void SelectProperty(int row) throws InterruptedException
			{
				String cssSelector = "#wl_table tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) label";
				WebElement e = driver.findElement(By.cssSelector(cssSelector));
				//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", e);
				e.click();
				Thread.sleep(5000);
			}
			
			
			public void ClickOnTableHeader(int column) throws InterruptedException
			{
				String cssSelector = "#wl_table thead tr:nth-of-type(1) th:nth-of-type(" + column + ")";
				WebElement e = driver.findElement(By.cssSelector(cssSelector));
				e.click();
				Thread.sleep(5000);
			}
			
			
			//Remove Wishlist
			public void Wishlist_RemoveItem(int row) throws InterruptedException
			{
				String cssSelector = "#wl_table tbody tr:nth-of-type(" + row + ") td:nth-of-type(9) i.fa-times";
				driver.findElement(By.cssSelector(cssSelector)).click();
				Thread.sleep(15000);
				
			}
		
			
			//Remove All Wishlist items
			public void Wishlist_RemoveALLItem() throws InterruptedException
			{
			
				for(int k=0;k<1000;k++)
				{
					try{
						
						if(GetTableData(1, 1).contains("No properties added to Wish List"))
						{
							System.out.println("--- Success!! No properties added to Wish List ");
							//Reporter.log("--- Success!! No properties added to Wish List ");
							break;
						}
						else if(GetTotalPropertiesCount() >=1)
						{
							try {
								Wishlist_RemoveItem(1);
								driver.navigate().refresh();
								Thread.sleep(10000);
							} catch (Exception e) {
								//Click on Cancel link
								HowDoIInvest_Cancel_Link.click();
								Thread.sleep(10000);
								driver.navigate().refresh();
								Thread.sleep(10000);
								
							}
						}
						
					}
					catch(Exception e)
					{
						//Catch if any
						
					}
				}
					
				
				
			}
			
			
			//Comparison view
			public String Comparison_GetPropertyAddress(int index)
			{
				String cssSelector = "div.property-listing > span:nth-of-type(" + index + ") p.selectedPropertyAddress";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			
			public String Comparison_GetTableData(int tbody, int row , int column)
			{
				String cssSelector = "#compare-item tbody:nth-of-type(" + tbody + ") tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			
			
			//Wish List Portfolio Summary
			
			@FindBy(css="div.watchlist-summ-table")
			public WebElement Summary_Section; 
			
			@FindBy(css="#portfolioTableArea > div")
			public WebElement Summary_Section_Title; 
			
			public String Summary_GetTableData(int row, int column)
			{
				String cssSelector = "#wishlistPortfolio tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			
			
			//How do I invest?
			
			@FindBy(css="button.placeBid")
			public WebElement HowDoIInvestLink; 
			
			@FindBy(css="div.modal-body")
			public WebElement HowDoIInvest_ConfirmationMessage_Text; 
			
			@FindBy(css="button.confirm-bid")
			public WebElement HowDoIInvest_ConfirmationMessage_OK; 
			
			@FindBy(css="button.cancelBid.watchlistButton")
			public WebElement HowDoIInvest_InvestToBuyCancelSection; 
			
			@FindBy(css="button.confirm-cancel-bid")
			public WebElement HowDoIInvest_Cancel_Link; 

			
		
}
