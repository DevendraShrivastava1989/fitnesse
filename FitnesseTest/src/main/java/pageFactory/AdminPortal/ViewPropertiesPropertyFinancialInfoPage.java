package pageFactory.AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class ViewPropertiesPropertyFinancialInfoPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public ViewPropertiesPropertyFinancialInfoPage(WebDriver driver)
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
		
		//Select Tabs - Financial Information , Taxes & Fee Information , Investments Information
		public void SelectTab(int i) throws InterruptedException
		{
			String cssSelector = "div#tabs ul li:nth-of-type(" + i + ") a";
			driver.findElement(By.cssSelector(cssSelector)).click();
			Thread.sleep(5000);
		}
	
		
		// Edit financial Details button
		@FindBy(css="div[class='clearfix xtra-buttons'] div:nth-of-type(2) a")
		public WebElement EditFinancialDetails;
	
		// Investments Information tab
		
			@FindBy(css="div#tabs-3 > div div.clearfix div:nth-of-type(5) div div")
			public WebElement CashFlow;
			
			@FindBy(css="div#tabs-3 > div div.clearfix div:nth-of-type(7) div div")
			public WebElement Return;
			
			@FindBy(css="div#tabs-3 > div div.clearfix div:nth-of-type(4) div div")
			public WebElement Investment;
			
			@FindBy(css="div#tabs-3 > div div.clearfix div:nth-of-type(8) div div")
			public WebElement CashOnCashReturn;
			
		// Financial Information tab	
			
			@FindBy(css="div#tabs-1 > div div.clearfix div:nth-of-type(1) div div")
			public WebElement PurchasePrice;
		
	
		
	
		////// Update Financial Info Page //////////////////////////
			
		// Financial Information tab
			
			@FindBy(id="leased_rent")
			public WebElement Edit_Rent;
			
			
		
		

		
}
