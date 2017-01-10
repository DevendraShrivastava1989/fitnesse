package pageFactory.AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class ViewPropertiesDetailsPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public ViewPropertiesDetailsPage(WebDriver driver)
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
		
		//Select Tabs - Demographics , Property Characteristics , Neighborhood Information , Photos, Videos , Comps
		public void SelectTab(int i) throws InterruptedException
		{
			String cssSelector = "div#tabs ul li:nth-of-type(" + i + ") a";
			driver.findElement(By.cssSelector(cssSelector)).click();
			Thread.sleep(5000);
		}
	
	
		// Property Characteristics tab
		
			@FindBy(css="div#tabs-2 > div > div:nth-of-type(2) div.clearfix div:nth-of-type(5) > div > div > div")
			public WebElement AppreciationRate;
		
	
		
	
		
		
		

		
}
