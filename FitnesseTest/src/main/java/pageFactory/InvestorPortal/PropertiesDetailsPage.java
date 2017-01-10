package pageFactory.InvestorPortal;

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
	
		
		@FindBy(css="div.prop-info h1")
		public WebElement Address;
		
		@FindBy(css="b.propertyDetailTotalReturn")
		public WebElement TotalReturn;
		
		@FindBy(css="div.prop-info > div > div:nth-of-type(2) > div:nth-of-type(3) h1")
		public WebElement Rent;
		
		@FindBy(css="#propDetailHeaderDesktop > div > div > div:nth-child(1) > h1")
		public WebElement Price;
		
		
		@FindBy(css="div.prop-info > div > div:nth-of-type(2) > div:nth-of-type(2) h1 b")
		public WebElement Investment; 
		
		@FindBy(css="b.propertyDetailYield")
		public WebElement YIELD ; 
		
		@FindBy(css="b.propertyDetailCOCReturn")
		public WebElement CASHONCASHRETURN ; 
		
		@FindBy(css="b.color--blue.propertyDetailAppreciationY10")
		public WebElement PROJECTEDAPPRECIATION; 
		
		@FindBy(css="div#pdetails_header div:nth-of-type(5) h3")
		public WebElement YEAR1APPRECIATION ; 
		
		@FindBy(css="div.wishlistStar")
		public WebElement AddToWishList_STAR ;
		
		@FindBy(css="div#pdetails_header div:nth-of-type(6) span span")
		public WebElement AddToWishList_Text; 
		
		@FindBy(css="#message_modal div.modal-body p")
		public WebElement AddToWishList_ConfirmationMessage_Text; 
		
		@FindBy(css="#message_modal div.modal-footer button")
		public WebElement AddToWishList_ConfirmationMessage_OK; 
		
		@FindBy(css="a[class='removeWL wishlistTooltip'] i")
		public WebElement RemoveFromWishList_STAR_Remove; 
		
		@FindBy(css="#modal-remove div.modal-body p")
		public WebElement RemoveFromWishList_ConfirmationMessage_Text; 
		
		@FindBy(css="#modal-remove div.modal-footer button")
		public WebElement RemoveFromWishList_ConfirmationMessage_YES; 
		
		
		@FindBy(css="div.property-detail-detail div:nth-of-type(2) div:nth-of-type(2)")
		public WebElement MLSInformation ; 
		
		@FindBy(css="#tab4 > a")
		public WebElement compsTab;
		
		
		//Info & Media
			
			@FindBy(id="gmap")
			public WebElement Map_Section;
		
			
			@FindBy(id="pano")
			public WebElement StreetView_Section;
	
		
		//Neighborhood
		@FindBy(id="tab2")
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

		
			@FindBy(css="label.price-comps-label")
			public WebElement PriceComps;
			
			@FindBy(css="label.rent-comps-label")
			public WebElement RentComps;
			
			@FindBy(css="#rentPDF")
			public WebElement rentCompsPDF;
			
			@FindBy(css="#comps-solution-manager-overlay > div > div > div > div > h2")
			public WebElement compsNTPresent;
		
				
			@FindBy(css="#price_header > div:nth-child(1) > div > div > div.col-md-5.width100.plr20 > ul > li:nth-of-type(1) > h1")
			public WebElement ListPrice;
			
			@FindBy(css="#rent_header > div > div > div > div > ul li:nth-of-type(2) h1")
			public WebElement ListPricePerSQFT	;
			
			@FindBy(css="#rent_header > div > div > div > div:nth-of-type(2) > ul li:nth-of-type(1) h1")
			public WebElement PriceComps_CompEstimatedValue	;
				
			@FindBy(css="#rent_header > div > div > div > div:nth-of-type(2) > ul li:nth-of-type(2) h1")
			public WebElement PriceComps_CompAvgPricePerSQFT;
			
			@FindBy(css="#rent_header > div > div > div > div > ul li:nth-of-type(1)")
			public WebElement ListRent;
			
			@FindBy(css="#rent_header > div:nth-child(1) > div > div > div.col-md-5.width100 > ul > li.list-group-item.fist-item > h1")
			public WebElement listRents;
			
			@FindBy(css="#rent_header > div > div > div > div > ul li:nth-of-type(2)")
			public WebElement ListRentPerSQFT	;
			
			@FindBy(css="#rent_header > div > div > div > div:nth-of-type(2) > ul li:nth-of-type(1)")
			public WebElement RentComps_CompEstimatedValue	;
				
			@FindBy(css="#rent_header > div > div > div > div:nth-of-type(2) > ul li:nth-of-type(2)")
			public WebElement RentComps_CompAvgPricePerSQFT;
			
			@FindBy(css="#comps-solution-manager-overlay div.sol-manager")
			public WebElement Comps_InfoPopUp;
			
			@FindBy(xpath= "//div[@id='rent_header']/div[2]/div/div/ul/li/label/span")
			public WebElement Property_Sqft;
	
		
		
		

		
}
