package pageFactory.Embrace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utility.Constants;
import utility.JavaHelpers;

public class RedshiftPropertySearch 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public RedshiftPropertySearch(WebDriver driver)
	{	 
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.WebDriverWaitDuration), this);
	}
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
		@FindBy(id="address")
		public WebElement Address;
	
		@FindBy(id="state")
		public WebElement State;
		
		@FindBy(id="zipcode")
		public WebElement Zipcode;
		
		@FindBy(id="listprice")
		public WebElement Listprice;
		
		@FindBy(id="mlsBasedTax")
		public WebElement MlsBasedTax;
		
		@FindBy(id="city")
		public WebElement City;
		
		@FindBy(id="searchRedshiftTaxProperties")
		public WebElement SearchRedshiftTaxProperties;
		
		@FindBy(id="renderRedshiftTaxProperties_processing")
		public WebElement Search_Processing;
		
		public void waitTillProcessingDone()
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("renderRedshiftTaxProperties_processing")));
			} catch (Exception e) {
				System.out.println("Error in loading Redshift Property Search Results Table.");
			}
		}
						
		// To get total results
		public int ToGetTotalResultsRow() {
			String cssSelector = "table#renderRedshiftTaxProperties tbody tr";
			try {
				List<WebElement> all = driver.findElements(By.cssSelector(cssSelector));
				return all.size();
			} catch (Exception e1) {
				return 0;
			}
		}
			
				
		// Get data from any column (non text box)
		public String ToGetAnyRowColumnData(int row, int column)
		{
			//String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
			String cssSelector = "table#renderRedshiftTaxProperties tbody tr:nth-child(" + row + ") td:nth-child(" + column + ")";	
			return driver.findElement(By.cssSelector(cssSelector)).getText().trim(); 
		}	
		
}
