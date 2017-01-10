package pageFactory.Embrace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class InvestorProfilePage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public InvestorProfilePage(WebDriver driver)
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
	
	// General
		@FindBy(css="div.marg_top15")
		public WebElement Name;
		
		
		
	// All Tabs
		
		// Investor Details
			@FindBy(id="investorDetails")
			public WebElement InvestorDetailsTab ;
			
			@FindBy(id="investorDetailsTab")
			public WebElement InvestorDetailsContent;
			
		// Preferences
			@FindBy(id="investorPreferences")
			public WebElement PreferencesTab ;
			
			@FindBy(id="investorPreferencesTab")
			public WebElement PreferencesContent;
			
		// Offers
			@FindBy(id="offerDetails")
			public WebElement OffersTab ;
			
			@FindBy(id="investorOfferDetailsTab")
			public WebElement OffersContent;	
			
		// Closings 
			@FindBy(id="closingDetails")
			public WebElement ClosingsTab ;
			
			@FindBy(id="investorClosingDetailsTab")
			public WebElement ClosingsContent;	
			
		// Assets
			@FindBy(id="assetDetails")
			public WebElement AssetsTab ;
			
			@FindBy(id="investorAssetDetailsTab")
			public WebElement AssetsContent;
			
		// Wishlists
			@FindBy(id="wishlistDetails")
			public WebElement WishlistsTab ;
			
			@FindBy(id="investorWishlistDetailsTab")
			public WebElement WishlistsContent;
		
		// Financials
			@FindBy(id="financialDetails")
			public WebElement FinancialsTab ;
			
			@FindBy(id="investorFinancialTab")
			public WebElement FinancialsContent;
				
		// Documents
			@FindBy(id="investorDocuments")
			public WebElement DocumentsTab ;
			
			@FindBy(id="investorDocumentTab")
			public WebElement DocumentsContent;
			
				//Add new document
				@FindBy(css="#investorDocumentTab i.fa-plus")
				public WebElement DocumentsContent_Add;
				
					//pop up
					@FindBy(css="#documentForm input[name='document']")
					public WebElement DocumentsContent_Popup_UploadDocument;
					
					@FindBy(id="submittDoc")
					public WebElement DocumentsContent_Popup_Save;
					
					//Get Table data for given row
					public String DocumentsContent_GetTableData(int i, int column)
					{	
						try {
							String cssSelector = "div#accordion3 table tbody tr:nth-of-type(" + i + ") td:nth-of-type(" + column + ")";
							return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
						} catch (Exception e) {
							//
						}
						return "no data";
						
					}
					
					
					//Click on Delete icon
					@FindBy(css="#documentTabTableRender i.fa-trash-o")
					public WebElement DocumentsContent_TableData_Delete;
					
						@FindBy(id="deleteDocumentConfirmationButton")
						public WebElement DocumentsContent_TableData_Delete_ConfirmationYes;
			
	
		// Contacts
			@FindBy(id="investorContacts")
			public WebElement ContactsTab ;
			
			@FindBy(id="contactsTab")
			public WebElement ContactsContent;
			
		// Messages
			@FindBy(id="investorMessages")
			public WebElement MessagesTab ;
			
			@FindBy(id="investorMessagesTab")
			public WebElement MessagesContent;
			
				//Add new Message
				@FindBy(id="showAddMessageModal")
				public WebElement MessagesContent_Add;
			
				//pop up
				@FindBy(id="mailSubject")
				public WebElement MessagesContent_Popup_Subject;
				
				@FindBy(css="iframe.cke_wysiwyg_frame")
				public WebElement MessagesContent_Popup_Message_iFrame;
				
				@FindBy(css="body")
				public WebElement MessagesContent_Popup_Message;
				
				public void MessagesContent_AddMessage(String text)
				{
					driver.switchTo().frame(MessagesContent_Popup_Message_iFrame);
					new Actions(driver).moveToElement(MessagesContent_Popup_Message).perform();
					MessagesContent_Popup_Message.sendKeys(text);
					driver.switchTo().defaultContent();
				}
				
				@FindBy(id="addMessage")
				public WebElement MessagesContent_Popup_Save;
				
				//Get Table data for given row
				public String MessagesContent_GetTableData(int i, int column)
				{	
					try {
						String cssSelector = "//table[@id='commentMessagesTable']/tbody/tr["+i+"]/td["+column+"]";
						return driver.findElement(By.xpath(cssSelector)).getText().trim();
					} catch (Exception e) {
						//
					}
					return "no data";
				}
				
				// Delete
				@FindBy(css="#commentMessagesTable a[name='deleteMessage']")
				public WebElement MessagesContent_Delete;
				
				@FindBy(id="deleteMessageConfirmationButton")
				public WebElement MessagesContent_DeleteConfiramtion_Yes;
				
		
}
