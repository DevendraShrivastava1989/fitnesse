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

public class TransactionsPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public TransactionsPage(WebDriver driver)
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
		
		@FindBy(css="div#transaction-summary-div h1")
	    public WebElement TotalTransactionProgress_Header;
		
			@FindBy(css="div#progress div.bgtransaction input")
		    public WebElement TotalTransactionProgress_Percentage;
			
		
		@FindBy(css="#transaction-steps-div  > div:nth-of-type(1) span.info-label")
	    public WebElement TransactionSetup_Header;
		
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(1) div.pie span.text")
		    public WebElement TransactionSetup_Percentage;
			
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(1) div.pieinfo")
		    public WebElement TransactionSetup_ProgressText;
		
		@FindBy(css="#transaction-steps-div  > div:nth-of-type(2) span.info-label")
	    public WebElement AgreementEarnestDeposit_Header;
		
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(2) div.pie span.text")
		    public WebElement AgreementEarnestDeposit_Percentage;
			
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(2) div.pieinfo")
		    public WebElement AgreementEarnestDeposit_ProgressText;
		
		@FindBy(css="#transaction-steps-div  > div:nth-of-type(3) span.info-label")
	    public WebElement LoanProcessing_Header;
		
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(3) div.pie span.text" )
		    public WebElement LoanProcessing_Percentage;
			
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(3) div.pieinfo")
		    public WebElement LoanProcessing_ProgressText;
	
		
		@FindBy(css="#transaction-steps-div  > div:nth-of-type(4) span.info-label")
	    public WebElement RenovationInspection_Header;
		
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(4) div.pie span.text")
		    public WebElement RenovationInspection_Percentage;
			
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(4) div.pieinfo")
		    public WebElement RenovationInspection_ProgressText;

		
		@FindBy(css="#transaction-steps-div  > div:nth-of-type(5) span.info-label")
	    public WebElement TelentMarkteting_Header;
		
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(5) div.pie span.text")
		    public WebElement TelentMarkteting_Percentage;
			
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(5) div.pieinfo")
		    public WebElement TelentMarkteting_ProgressText;
		
		@FindBy(css="#transaction-steps-div  > div:nth-of-type(6) span.info-label")
	    public WebElement HUDAndClosing_Header;
		
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(6) div.pie span.text")
		    public WebElement HUDAndClosing_Percentage;
			
			@FindBy(css="#transaction-steps-div  > div:nth-of-type(6) div.pieinfo")
		    public WebElement HUDAndClosing_ProgressText;
				
		@FindBy(css="#contacts-div span")
	    public WebElement InvestorContacts_Header;	
		
			@FindBy(css="#contacts-div")
		    public WebElement InvestorContacts_Text;	
		
		
		// Property dropdown
			
			@FindBy(css="#select-prop-menu a")
		    public WebElement PropertyDropdown_DownArrow;	
			
			public void SelectProperty(String propertyname) throws InterruptedException
			{
				
				PropertyDropdown_DownArrow.click();
				Thread.sleep(3000);
				
				String cssSelector = "#select-prop-dd-list li";
				List<WebElement> e = driver.findElements(By.cssSelector(cssSelector));
				int j = e.size();
				
				for(int i=1;i<=j;i++)
				{
					cssSelector = "#select-prop-dd-list li:nth-of-type(" + i + ") a";
					String text = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
					if(text.equals(propertyname))
					{
						driver.findElement(By.cssSelector(cssSelector)).click();
						break;
					}
				}
			}
		
	
		
	
}
