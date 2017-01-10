package pageFactory.AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class AssetClassPropertiesListPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public AssetClassPropertiesListPage(WebDriver driver)
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
		
	
		@FindBy(id="address")
		public WebElement Address;
		
		@FindBy(id="city")
		public WebElement City;
		
		@FindBy(id="zip")
		public WebElement Zip;
		
		@FindBy(id="Submit")
		public WebElement Search;
		
		//Get Table data from Result's table
		public String GetTableData(int row, int column)
		{
			String cssSelector = "table#datatable_ajax tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
			return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
		}
		
			
		
		
		

		
}
