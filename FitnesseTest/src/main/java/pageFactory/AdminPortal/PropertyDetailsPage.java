package pageFactory.AdminPortal;

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

public class PropertyDetailsPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public PropertyDetailsPage(WebDriver driver)
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
		
	
		@FindBy(css="div.pad_top7")
		public WebElement Name;
		

		//Select tab from : Property Details , Sold Comps Summary , Leased Comps Summary , Neighborhood
		public void SelectTab(int i)
		{
			String cssSelector = "ul#myTab li:nth-of-type(" + i + ") a";
			driver.findElement(By.cssSelector(cssSelector)).click();
			try {Thread.sleep(3000);} catch (InterruptedException e) {}
		}
		
		
		
		//Sold Comps Summary
		
			
			public void SoldComp_SelectComp()
			{
				String cssSelector = "table#soldCompsTable tr";
				List<WebElement> allrows = driver.findElements(By.cssSelector(cssSelector));
				
				for(int i=2;i<=allrows.size();i++)
				{
					cssSelector = "table#soldCompsTable tr:nth-of-type(" + i + ") td:nth-of-type(1) input";
					try
					{
						//verifying whether check box is not disabled
						driver.findElement(By.cssSelector(cssSelector)).getAttribute("disabled");
						
					}
					catch(Exception e)
					{
						
						try
						{
							//verifying whether check box is already checked 
							if(!driver.findElement(By.cssSelector(cssSelector)).getAttribute("checked").equals("checked"))
							{
								driver.findElement(By.cssSelector(cssSelector)).click();
								Thread.sleep(3000);
							}
							
						}
						catch(Exception e1)
						{
							//nothing
						}
						
					}
					
					
				}
				
			}	
				
			
			//Select ith Record
			public void SoldComp_SelectRecord(int i) throws InterruptedException
			{
				String cssSelector = "table#soldCompsTable tr:nth-of-type(" + i + ") td:nth-of-type(1) input";
				driver.findElement(By.cssSelector(cssSelector)).click();
				Thread.sleep(3000);
			}
	
			@FindBy(id="generateSoldCompsPDF")
			public WebElement GenerateSoldCompsPDF;
			
				//Confirmaton Box
				
					//Text
					@FindBy(css="div#modal_id div[class='form-group modal_text']")
					public WebElement Alert_Text;
					
					//Click OK
					@FindBy(css="div#modal_id a")
					public WebElement Alert_Dismiss;
					
					
				//Warning box
					@FindBy(id="go_l")
					public WebElement Warning_Accept;
			
					
			@FindBy(id="approveSoldComps")
			public WebElement ApproveSoldComps;	
			
			@FindBy(id="disapproveSoldComps")
			public WebElement DisApproveSoldComps;	
				
			
		//Leased Comps Summary
			
			//Select ith Record
			public void LeasedComp_SelectRecord(int i) throws InterruptedException
			{
				String cssSelector = "table#leasedCompsTable tr:nth-of-type(" + i + ") td:nth-of-type(1) input";
				driver.findElement(By.cssSelector(cssSelector)).click();
				Thread.sleep(3000);
			}
	
			@FindBy(id="generateleasedCompsPDF")
			public WebElement GenerateLeasedCompsPDF;
			
			@FindBy(id="approveLeasedComps")
			public WebElement ApproveLeaseComps;	
			
			@FindBy(id="disapproveLeasedComps")
			public WebElement DisApproveLeaseComps;	
			
			
		// Property Details
			
			@FindBy(css="span.ra_saleprice")
			public WebElement ListPrice;
			
			//@FindBy(id="sofferprice_c") - typo
			@FindBy(id="offerprice_c")
			public WebElement HUFairMarketValue;
			
			@FindBy(id="minBid_c")
			public WebElement LowOffer;
			
			@FindBy(id="maxBid_c")
			public WebElement HighOffer;
			
			@FindBy(id="rentFrom_c")
			public WebElement RentFrom;
			
			@FindBy(id="rentTo_c")
			public WebElement RentTo;
			
			@FindBy(id="rent_c")
			public WebElement Rent;
			
			@FindBy(id="rentReviewCheckBox")
			public WebElement RentReview;
			
				@FindBy(id="rentreasons")
				public WebElement RentReviewReason;
				
				public void SelectRentReviewReason(String reason)
				{
					new Select(RentReviewReason).selectByVisibleText(reason);
					try {	Thread.sleep(2000);} catch (InterruptedException e) {}
				}
			
			
			@FindBy(id="annualtaxes_c")
			public WebElement AnnualTaxes;
			
			@FindBy(id="process")
			public WebElement Process;
			
			@FindBy(id="update")
			public WebElement Save;
						
			@FindBy(id="insurance_c")
			public WebElement AnnualInsurance;
			
			@FindBy(id="hoa_c")
			public WebElement HOA;
			
			@FindBy(id="assetClass")
			public WebElement AssetClass;
			
			
			
			//Rehab Estimate ($)
			
				@FindBy(id="rehab_c")
				public WebElement RehabEstimate;
			
				@FindBy(id="rehabCal")
				public WebElement RehabEstimate_Button;
				
				@FindBy(id="rehabBucket")
				public WebElement RehabBucket;
				
				//Enter data for first Text box e.g. Storm Doors
				@FindBy(css="div#TextBoxDiv input")
				public WebElement RehabEstimate_FirstTextBox;
				
				@FindBy(id="rehabsave")
				public WebElement RehabEstimate_SaveChanges;
				
				
			@FindBy(id="rehabReviewCheckBox")
			public WebElement RehabReivew;
				
			@FindBy(id="loccat")
			public WebElement LocationCategory;
			
			@FindBy(id="propcat")
			public WebElement PropertyCategory;
			
			//ILM's Unique Comments
			@FindBy(id="ilmNotes")
			public WebElement ILMsUniqueComments;
			
			@FindBy(id="city")
			public WebElement City;
			
			@FindBy(id="zipcode")
			public WebElement Zipcode;
			
			@FindBy(css="#propertyDetails div.search-details div:nth-child(16) > div > span")
			public WebElement YearBuild;
			
			@FindBy(id="cocReturn")
			public WebElement Return;
			
			@FindBy(id="propSaleCategory")
			public WebElement SaleCategory;
			
			public void SelectSaleCategory(String salecategory)
			{
				new Select(SaleCategory).selectByVisibleText(salecategory);
				try {	Thread.sleep(2000);} catch (InterruptedException e) {}
			}
			

			
			
			
			
}
