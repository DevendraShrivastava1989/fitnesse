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

public class SearchRehabPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public SearchRehabPage(WebDriver driver)
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
	
		@FindBy(id="rehabSearchSubmit")
		public WebElement Search;
		
		@FindBy(id="address")
	    public WebElement Address;
		
		
		@FindBy(css="div.blockUI")
		public WebElement Search_Processing;
		
		@FindBy(css="body > div.blockUI.blockMsg.blockPage > div")
		public WebElement blockUI;
		
		
		public void waitTillProcessingDone()
		{
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			for(int i=1;i < 120; i++)
			{

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
			
			try { Thread.sleep(7000);} catch (InterruptedException e1) {}
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
		}
		
		
		//Search Result table > to get Property address for ith Record
		public String ToGetPropertyAddress(int i)
		{
			String cssSelector = "table#rehabsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) a";
			return JH.ToGetFistNthWordFromString(driver.findElement(By.cssSelector(cssSelector)).getText().trim(),2); 
		}
		
		
		//Search Result table > click on rehab status link
		public void ToClickOnRehabStatusLink(int i)
		{
			String cssSelector = "table#rehabsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(8) a";
			driver.findElement(By.cssSelector(cssSelector)).click();
			try { Thread.sleep(25000);} catch (InterruptedException e1) {}
		}
				
	
		
		
		
		
}
