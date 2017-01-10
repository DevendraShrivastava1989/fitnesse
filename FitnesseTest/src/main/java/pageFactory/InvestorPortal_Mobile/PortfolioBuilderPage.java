package pageFactory.InvestorPortal_Mobile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class PortfolioBuilderPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public PortfolioBuilderPage(WebDriver driver)
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
	
		
		@FindBy(css="#portfolio_form h3")
		public WebElement PageHeader;
		
		
		//YOUR RECOMMENDED PORTFOLIO section
		
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(2) h1")
			public WebElement PropertyClasses;
			
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(3) h1")
			public WebElement InvestmentAmount;
			
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(1) h1")
			public WebElement TotalProperties;
			
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(5) h1")
			public WebElement AnnualYield;
			
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(4) h1")
			public WebElement PortfolioValue;
			
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(6) h1")
			public WebElement Appreciation;
			
			
			@FindBy(css="i.addWL")
			public WebElement AddToWishList_STAR ;
			
			@FindBy(css="#message_modal div.modal-body p")
			public WebElement AddToWishList_ConfirmationMessage_Text; 
			
			@FindBy(css="#message_modal div.modal-footer button")
			public WebElement AddToWishList_ConfirmationMessage_OK; 
			
			@FindBy(css="i.removeWL")
			public WebElement RemoveFromWishList_STAR_Remove; 
			
			@FindBy(css="#wishlistbuy div.modal-body p")
			public WebElement RemoveFromWishList_ConfirmationMessage_Text; 
			
			@FindBy(css="#wishlistbuy div.modal-footer button")
			public WebElement RemoveFromWishList_ConfirmationMessage_YES; 
		
		
			//Table
			
			public int GetTotalPropertiesCount()
			{
				List<WebElement> totalrows = driver.findElements(By.cssSelector("#portfolioTable tbody tr"));
				return totalrows.size();
			}
		
			public String GetTableData(int row, int column)
			{
				String cssSelector = "#portfolioTable tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			
			// Get Property address
			public String GetPropertyAddress(int row)
			{
				String cssSelector = "#portfolioTable tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) div.property b";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			
			public String GetPropertyClassInfo(int row)
			{
				String cssSelector = "#portfolioTable tbody tr:nth-of-type(" + row + ") a.asset-class";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
		
			public String GetTableFooterData(int column)
			{
				String cssSelector = "#portfolioTable tfoot tr:nth-of-type(1) td:nth-of-type(" + column + ")";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			
			public int GetTotalNumberOfUniquePropertyClasses()
			{
				
				ArrayList<String> values = new ArrayList<String>();
			
				int j = GetTotalPropertiesCount();
				for(int i=1; i<=j;i++)
				{
					values.add(GetPropertyClassInfo(i));
				}
				
				HashSet<String> uniqueValues = new HashSet<String>(values);
				return uniqueValues.size();
				
			}
			
			
			public int SumAllPropertyPrices()
			{
				int j = GetTotalPropertiesCount();
				int[] price = new int[j];
				int sum =0;
				//String totalprice="";
				
				for(int i=0; i<j;i++)
				{
					int temp= Integer.parseInt(JH.USCurrencyFormatToString(GetTableData(i+1,2)));
					price[i]=temp;
					sum = sum + price[i];
				}		
				/*totalprice = JH.CovertToUSCurrencyFormat(Integer.toString(sum));
				//removing last 3 decimal ".00" from price
				totalprice  = JH.ToRemoveLastNCharactorOnString(totalprice, 3);
				return totalprice ;*/
				return sum;
			
			}
			
			
			public int SumAllInvestmentPrices()
			{
				int j = GetTotalPropertiesCount();
				int[] price = new int[j];
				int sum =0;
				//String totalprice="";
				
				for(int i=0; i<j;i++)
				{
					int temp= Integer.parseInt(JH.USCurrencyFormatToString(GetTableData(i+1,3)));
					price[i]=temp;
					sum = sum + price[i];
				}		
				
				/*totalprice = JH.CovertToUSCurrencyFormat(Integer.toString(sum));
				//removing last 3 decimal ".00" from price
				totalprice  = JH.ToRemoveLastNCharactorOnString(totalprice, 3);*/
				return sum ;
			
			}
			
			
			public String AverageYieldForAllProperties()
			{
				int j = GetTotalPropertiesCount();
				float[] price = new float[j];
				float sum = 0;
				float avgyield= 0;
				String avgyield_s ="";
				
				for(int i=0; i<j;i++)
				{
					float temp= Float.parseFloat(JH.ToRemoveLastNCharactorOnString(GetTableData(i+1,5),1));
					price[i]=temp;
					sum = sum + price[i];
				}		
				avgyield = sum/j;
				avgyield_s = JH.RoundOffValues(Float.toString(avgyield));
				return avgyield_s ;
			
			}
			
			
			public String AverageAppreciationForAllProperties()
			{
				int j = GetTotalPropertiesCount();
				float[] price = new float[j];
				float sum = 0;
				float avgappreciation= 0;
				String avgappreciation_s ="";
				
				for(int i=0; i<j;i++)
				{
					float temp= Float.parseFloat(JH.ToRemoveLastNCharactorOnString(GetTableData(i+1,6),1));
					price[i]=temp;
					sum = sum + price[i];
				}		
				avgappreciation = sum/j;
				avgappreciation_s = JH.RoundOffValues(Float.toString(avgappreciation));
				return avgappreciation_s ;
			
			}
	
		
		
		

		
}
