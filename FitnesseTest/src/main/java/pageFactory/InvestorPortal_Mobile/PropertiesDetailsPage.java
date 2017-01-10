package pageFactory.InvestorPortal_Mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class PropertiesDetailsPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public PropertiesDetailsPage(WebDriver driver)
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
	
		
		@FindBy(css="div.innerPropInfo h1")
		public WebElement Address;
		
		//@FindBy(css="div.prop-info > div > div:nth-of-type(2) > div:nth-of-type(3) h1 b")
		@FindBy(xpath="//div[@class='container']/div[1]/div[3]/div[3]/h1/b")
		public WebElement Rent;
		
		@FindBy(xpath="//div[@class='col-xs-4 p-l-0 col-sm-4 col-md-3 topPricingSec']/h1/b")
		public WebElement Price;
		
		@FindBy(xpath="//div[@class='col-xs-4 col-sm-4 col-md-3 p-l-7']/h1/b")
		public WebElement Investment;
		
		
		//@FindBy(css="div.prop-info > div > div:nth-of-type(2) > div:nth-of-type(2) h1 b")
	//	public WebElement Investment; 
		
		@FindBy(xpath="//div[@class='well2 clearfix col-md-12 col-sm-12 col-lg-9 propDetailsSec']/section[1]/span/b")
		public WebElement YIELD ; 
		
		@FindBy(xpath="//div[@class='well2 clearfix col-md-12 col-sm-12 col-lg-9 propDetailsSec']/section[4]/span/b")
		public WebElement CASHONCASHRETURN ; 
		
		@FindBy(xpath="//div[@class='well2 clearfix col-md-12 col-sm-12 col-lg-9 propDetailsSec']/section[3]/span/b")
		public WebElement TotalReturn;
			
		@FindBy(xpath="//div[@class='well2 clearfix col-md-12 col-sm-12 col-lg-9 propDetailsSec']/section[2]/span/b")
		public WebElement PROJECTEDAPPRECIATION; 
		
		@FindBy(css="div#pdetails_header div:nth-of-type(5) h3")
		public WebElement YEAR1APPRECIATION ; 
		
		//@FindBy(css="div.wishlistStar")
		@FindBy(xpath="//div[@class='wishlistStar pull-left']/a/i")
		public WebElement AddToWishList_STAR ;
		
		@FindBy(css="div#pdetails_header div:nth-of-type(6) span span")
		public WebElement AddToWishList_Text; 
		
		@FindBy(css="#message_modal div.modal-body p")
		public WebElement AddToWishList_ConfirmationMessage_Text; 
		
		@FindBy(css="#message_modal div.modal-footer button")
		public WebElement AddToWishList_ConfirmationMessage_OK; 
		
		//@FindBy(css="a[class='removeWL wishlistTooltip'] i")
		@FindBy(xpath="//div[@class='wishlistStar pull-left']/a/i")
		public WebElement RemoveFromWishList_STAR_Remove; 
		
		//@FindBy(css="#modal-remove div.modal-body p")
		@FindBy(xpath="//div[@class='modal fade bs-modal-sm in']/div/div/div[2]/p")
		public WebElement RemoveFromWishList_ConfirmationMessage_Text; 
		
		//@FindBy(css="#modal-remove div.modal-footer button")
		@FindBy(xpath="//div[@class='modal fade bs-modal-sm in']/div/div/div[3]/button")
		public WebElement RemoveFromWishList_ConfirmationMessage_YES; 
		
		
		//@FindBy(css="div.property-detail-detail div:nth-of-type(2) div:nth-of-type(2)")
		@FindBy(xpath="//div[@id='property-tabs']/div[2]/div/div/div/div/div/ul/li[4]")
		public WebElement MLSInformation ; 
		
		
		//Info & Media
			
			//@FindBy(id="gmap")
		    @FindBy(id="mediaCarousel")
			public WebElement Photo_Section;
		
			
			@FindBy(id="pano")
			public WebElement StreetView_Section;
	
		
		//Neighborhood
		//@FindBy(id="tab2")
			@FindBy(xpath="//a[@data-href='#tab-2']")
		    public WebElement NeighborhoodTab; 
		
			@FindBy(id="nbrhdInfo")
			public WebElement NeighborhoodTab_iframe; 
		
			@FindBy(css="div.wrap")
			public WebElement NeighborhoodTab_Section; 
			
			@FindBy(css="body h2")
			public WebElement NeighborhoodTab_Title; 
			
			
			
		//Local Area
		   @FindBy(id="tab4")
		   public WebElement LocalAreaTab; 
		
			@FindBy(css="#map >div")
			public WebElement LocalAreaTab_Section; 
			
		//Financials
			@FindBy(xpath="//a[@data-href='#tab-3']")
			public WebElement FinancialsTab; 	
			
			@FindBy(xpath="//div[@class='m-t-10']/div")
			public WebElement InteractiveCharts; 
			
			@FindBy(xpath="//div[@class='financial container']")
			public WebElement BasicMonthlyIncomeStatement;
			
			@FindBy(xpath="//div[@id='cashOutChart']")
			public WebElement TotalCashOutOfPocket;
			
			@FindBy(xpath="//div[@class='clearfix col-sm-12 ld-sec ']")
			public WebElement LoanDetails;
			
			@FindBy(xpath="//div[@class='col-sm-6 col-md-4 col-lg-4']/div/div/p")
			public WebElement TotalCash_Investment;
			
			
			
			
			
				
				
		//Comps
		    @FindBy(xpath="//a[@data-href='#tab-4']")
		    public WebElement CompsTab; 
		
			@FindBy(css="label.price-comps-label")
			public WebElement PriceComps;
			
			@FindBy(css="label.rent-comps-label")
			public WebElement RentComps;
			
			//@FindBy(css="#rent_header > div > div > div > div > ul li:nth-of-type(1) h1")
			@FindBy(xpath="//div[@id='price_header']/div/div/div/div/ul/li/h1")
			public WebElement ListPrice;
			
			@FindBy(css="#rent_header > div > div > div > div > ul li:nth-of-type(2) h1")
			public WebElement ListPricePerSQFT	;
			
			@FindBy(css="#rent_header > div > div > div > div:nth-of-type(2) > ul li:nth-of-type(1) h1")
			public WebElement PriceComps_CompEstimatedValue	;
				
			@FindBy(css="#rent_header > div > div > div > div:nth-of-type(2) > ul li:nth-of-type(2) h1")
			public WebElement PriceComps_CompAvgPricePerSQFT;
			
			//@FindBy(css="#rent_header > div > div > div > div > ul li:nth-of-type(1)")
			@FindBy(xpath="//div[@id='rent_header']/div/div/div/div/ul/li/h1")
			public WebElement ListRent;
			
			//@FindBy(css="#rent_header > div > div > div > div > ul li:nth-of-type(2)")
			@FindBy(xpath="//div[@id='rent_header']/div/div/div/div/ul/li[2]/h1")
			public WebElement ListRentPerSQFT	;
			
			//@FindBy(css="#rent_header > div > div > div > div:nth-of-type(2) > ul li:nth-of-type(1)")
			@FindBy(xpath="//div[@id='rent_header']/div/div/div/div[2]/ul/li/h1")
			public WebElement RentComps_CompEstimatedValue	;
				
			//@FindBy(css="#rent_header > div > div > div > div:nth-of-type(2) > ul li:nth-of-type(2)")
			@FindBy(xpath="//div[@id='rent_header']/div/div/div/div[2]/ul/li[2]/h1")
			public WebElement RentComps_CompAvgRentPerSQFT;
			
			@FindBy(css="#comps-solution-manager-overlay div.sol-manager")
			public WebElement Comps_InfoPopUp;
			
		
	
		
		
		

		
}
