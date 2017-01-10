package pageFactory.AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class RETSListingPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public RETSListingPage(WebDriver driver)
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
		
		@FindBy(id="minSalePrice_c")
		public WebElement minSalePrice;
		
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
		
		
		
	
		
	
}
