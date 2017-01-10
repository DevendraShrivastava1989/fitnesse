package pageFactory.InvestorPortal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

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
		
			/*@FindBy(css="#portfolio-results div.port-summary section:nth-child(2) h1")
			public WebElement PropertyClasses;*/ //removed as of June 2016
			
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(1) h1")
			public WebElement InvestmentAmount;
			
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(3) h1")
			public WebElement TotalProperties;
			
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(4) h1")
			public WebElement AnnualYield;
			
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(2) h1")
			public WebElement PortfolioValue;
			
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(5) h1")
			public WebElement Appreciation;
			
			@FindBy(css="#portfolio-results div.port-summary section:nth-child(6) h1")
			public WebElement TotalReturn;
			
			
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
		
			@FindBy(css="#invAmount")
			public WebElement invAmount; 
		
			@FindBy(css="button.button--sm.button--green.search.serachBtnHide")
			public WebElement build; 
			
			@FindBy(xpath="//*[@id='panel-group-id']/div[3]/div[3]/div[2]/div/dl/dt/a/i")
			public WebElement fintypeDropdown;
			
			@FindBy(xpath="//*[@id='panel-group-id']/div[3]/div[4]/div[2]/div/dl/dt/a/i")
			public WebElement investmentStyleDropdown;
			
			@FindBy(xpath="//*[@id='panel-group-id']/div[3]/div[4]/div[3]/div/dl/dt/a/i")
			public WebElement investmentStrategyDropdown;
			
			@FindBy(xpath="//*[@id='fin-type-list']/li")
			public WebElement fintype;
			
			@FindBy(xpath="//*[@id='inv-style-list']/li")
			public WebElement investmentStyle;
			
			@FindBy(xpath="//*[@id='inv-strategy-list']/li")
			public WebElement investmentStrategy;
			
			@FindBy(css="#portfolio-results > portfolio-info-app > div.container > div > div.port-summary.portfolio-summary-common > section:nth-child(1) > h1")
			public WebElement portfolioTotalProperties;
			
			@FindBy(css="#portfolio-results > portfolio-info-app > div.container > div > div.port-summary.portfolio-summary-common > section:nth-child(2) > h1")
			public WebElement portfolioValue;
			
			@FindBy(css="#portfolio-results > portfolio-info-app > div.container > div > div.port-summary.portfolio-summary-common > section:nth-child(3) > h1")
			public WebElement portfolioinvestmentAmount;
			
			@FindBy(css="#portfolio-results > portfolio-info-app > div.container > div > div.port-summary.portfolio-summary-common > section:nth-child(5) > h1")
			public WebElement portfoliocashonCashReturn;
			
			@FindBy(css="#portfolio-results > portfolio-info-app > div.container > div > div.port-summary.portfolio-summary-common > section:nth-child(6) > h1")
			public WebElement portfolioYield;
			
			@FindBy(css="#portfolio-results > portfolio-info-app > div.container > div > div.port-summary.portfolio-summary-common > section:nth-child(7) > h1")
			public WebElement portfoliototalReturn;
			
			@FindBy(css="#main-cont > div > div:nth-child(2) > a")
			public WebElement recoEngineloginlink;
			
			@FindBy(css="#investAmount")
			public WebElement recoEngineinvAmount;
			
			@FindBy(css="#portfolioBase")
			public WebElement recoEnginebuildPortfolio;
			
			@FindBy(css="#allCash")
			public WebElement recoEngineFinancingOption;
			
			@FindBy(css="#portfolio > div:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(4) > input:nth-child(2)")
			public WebElement recoEngineallCashOption;
			
			@FindBy(css="#portfolio > div:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(4) > input:nth-child(2)")
			public WebElement recoEngineSDIRANo;
			
			
			@FindBy(css="#slPortTable > tbody > tr:nth-child(1) > td:nth-child(2)")
			public WebElement recoengineportfolioTotalProperties;
			
			@FindBy(css="#slPortTable > tbody > tr:nth-child(1) > td:nth-child(3)")
			public WebElement recoengineportfolioValue;
			
			@FindBy(css="#slPortTable > tbody > tr:nth-child(1) > td:nth-child(4)")
			public WebElement recoengineportfolioinvestmentAmount;
			
			@FindBy(css="#slPortTable > tbody > tr:nth-child(1) > td:nth-child(7)")
			public WebElement recoengineportfoliocashonCashReturn;
			
			@FindBy(css="#slPortTable > tbody > tr:nth-child(1) > td:nth-child(6)")
			public WebElement recoengineportfolioYield;
			
			@FindBy(css="#slPortTable > tbody > tr:nth-child(1) > td:nth-child(8)")
			public WebElement recoengineportfoliototalReturn;
			
			@FindBy(css="#slPortTable > tbody > tr:nth-child(1) > td:nth-child(11)")
			public WebElement recoengineportfolioScore;
				
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
	
		public String selectFinancingType(String financingType)throws Exception
		{
		String xpath;
		String finType="";
		if(financingType.equals("Financed"))
		{
		    xpath="//*[@id='fin-type-list']/li[1]";
			fintypeDropdown.click();
			 Thread.sleep(2000);
			finType=driver.findElement(By.xpath(xpath)).getText();
		    driver.findElement(By.xpath(xpath)).click();
		}
		else{
			xpath="//*[@id='fin-type-list']/li[2]";
			fintypeDropdown.click();
			 Thread.sleep(2000);
			finType=driver.findElement(By.xpath(xpath)).getText();
		    driver.findElement(By.xpath(xpath)).click();
		}
		return finType;
		}
		
		public String selectInvestmentStyle(int i)throws Exception
		{
			String xpath;
			String InvestmentStyle="";
			 investmentStyleDropdown.click();
		     Thread.sleep(2000);
			 xpath="//*[@id='inv-style-list']/li["+i+"]";
			 InvestmentStyle=driver.findElement(By.xpath(xpath)).getText();
			 try{
			     driver.findElement(By.xpath(xpath)).click();
			 }
			 catch(Exception e)
			 {
				 driver.findElement(By.xpath(xpath)).click();
			 }
			return InvestmentStyle;
		}
		
		public String selectInvestmentStrategy(int i)throws Exception
		{
			String xpath;
			String InvestmentStrategy="";
			 investmentStrategyDropdown.click();
			 Thread.sleep(2000);
			 xpath="//*[@id='inv-strategy-list']/li["+i+"]";
			 InvestmentStrategy=driver.findElement(By.xpath(xpath)).getText();
			 try{
			     driver.findElement(By.xpath(xpath)).click();
			 }
			 catch(Exception e)
			 {
				 driver.findElement(By.xpath(xpath)).click();
			 }
			
			 return InvestmentStrategy;
		}
		
		
		public String getPropertystatus(int i)throws Exception
		{
			String cssSelector;
			String propertyStatus="";
			cssSelector="#portfolioTable > tbody > tr:nth-child("+i+") > td.wl-status.dekstop-star.hideInTab.hideInMobile > span.availableTxt";
			propertyStatus=driver.findElement(By.cssSelector(cssSelector)).getText().trim();		
			return propertyStatus;
		}	
		
		public String getPropertyID(int i)throws Exception
		{
			String cssSelector;
			String propertyID="";
			cssSelector="#portfolioTable > tbody > tr:nth-child("+i+")";
			propertyID=driver.findElement(By.cssSelector(cssSelector)).getAttribute("data-property-id").trim();
			return propertyID;
		}	
		
		public String getportfolioPropertyAddress(int i)throws Exception
		{
			String cssSelector;
			String propertyAddress="";
			cssSelector="#portfolioTable > tbody > tr:nth-child("+i+") > td.property-thumbnail > div.property.pull-left > b";
			propertyAddress=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			return propertyAddress;
		}	
		
		public void selectRecoengineInvestmentStyle(int i)throws Exception
		{
			
			Select invStyle=new Select(driver.findElement(By.cssSelector("#investment-style")));
			invStyle.selectByIndex(i);
		}
		
		public void selectRecoengineBasePlan(int i)throws Exception
		{
			
			Select basePlan=new Select(driver.findElement(By.cssSelector("#basePlanType")));
			basePlan.selectByIndex(i);
		}
}

