package pageFactory.InvestorPortal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class PropertyClassesPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public PropertyClassesPage(WebDriver driver)
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
		
		public String GetTableData(int row, int column)
		{
			String cssSelector = "#assetClassList tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
			return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
		}
		
		public int GetTotalPropertyClassCount()
		{
			List<WebElement> totalrows = driver.findElements(By.cssSelector("#assetClassList tbody tr"));
			return totalrows.size();
		}
		
}
