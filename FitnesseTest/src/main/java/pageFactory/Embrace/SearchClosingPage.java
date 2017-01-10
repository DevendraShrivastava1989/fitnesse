package pageFactory.Embrace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utility.Constants;
import utility.JavaHelpers;

public class SearchClosingPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public SearchClosingPage(WebDriver driver)
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
	
		@FindBy(id="closingSearchSubmit")
		public WebElement Search;
		
		@FindBy(name="financingType")
		public WebElement financingType;
		
		public void SelectFinancingType(String financetype)
		{
			new Select(financingType).selectByVisibleText(financetype);
			try {	Thread.sleep(2000);} catch (InterruptedException e) {}
		}
		
		@FindBy(id="address")
	    public WebElement Address;
		
		
		@FindBy(css="div.blockUI")
		public WebElement Search_Processing;
		
		public void waitTillProcessingDone()
		{
			for(int i=1;i < 120; i++)
			{
				try { Thread.sleep(100);} catch (InterruptedException e1) {}
				
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
		
		
		//Search Result table > to get Property address for ith Record
		
		public String ToGetPropertyAddress(int i)
		{
			String cssSelector = "table#myClosingsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) a";
			return JH.ToGetFistNthWordFromString(driver.findElement(By.cssSelector(cssSelector)).getText().trim(),2); 
		}
		
		
		//Search Result table > Click on Status link
		
		public void ToClickOnStatusLink(int i)
		{
			String cssSelector = "table#myClosingsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(6) a";
			driver.findElement(By.cssSelector(cssSelector)).click();
		}
		
		
	
		
		
		
		
}
