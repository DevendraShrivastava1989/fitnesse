package pageFactory.Embrace;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class SearchMarketingPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public SearchMarketingPage(WebDriver driver)
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
	
		@FindBy(id="searchMarketingButton")
		public WebElement Search;
		
		@FindBy(id="address")
	    public WebElement Address;
		
		
		@FindBy(css="div.blockUI")
		public WebElement Search_Processing;
		
		public void waitTillProcessingDone()
		{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			for(int i=1;i < 120; i++)
			{
				try { Thread.sleep(1000);} catch (InterruptedException e1) {}
				
				try {

					String temp = Search_Processing.getAttribute("style");
					if(temp.contains("none"))
					{
						//break;
					}
					
				}
				catch (Exception e2) 
				{
					break;
				}
				
			}
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		
		
		//Search Result table > to get Property address for ith Record
		public String ToGetPropertyAddress(int i)
		{
			String cssSelector = "table#myAssetMarketingTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) a";
			return JH.ToGetFistNthWordFromString(driver.findElement(By.cssSelector(cssSelector)).getText().trim(),2); 
		}
		
		//Search Result table > Click on Status link
		public void ToClickOnStatusLink(int i)
		{
			String cssSelector = "table#myAssetMarketingTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(8) a";
			driver.findElement(By.cssSelector(cssSelector)).click();
		}
		
}
