package pageFactory.Embrace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utility.Constants;
import utility.JavaHelpers;

public class OpportunityDetailsPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public OpportunityDetailsPage(WebDriver driver)
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
	
	
	// All Tabs
	
			// Properties
				@FindBy(id="opportunityProperties")
				public WebElement PropertiesTab ;
				
				@FindBy(id="opportunityPropertiesTab")
				public WebElement PropertiesContent;
			
			// Wishlists
				@FindBy(id="wishlistDetails")
				public WebElement WishlistsTab ;
				
				@FindBy(id="opportunityWishlistDetailsTab")
				public WebElement WishlistsContent;
				
			// Contacts
				@FindBy(id="opportunityContacts")
				public WebElement ContactsTab ;
				
				@FindBy(id="opportunityContactsTab")
				public WebElement ContactsContent;
				
					//Add new contact
					@FindBy(css="#opportunityContactsTab i.fa-plus")
					public WebElement ContactsContent_Add;
						
						//pop up
						@FindBy(name="contactName")
						public WebElement ContactsContent_Popup_ContactName;
						
						@FindBy(name="address1")
						public WebElement ContactsContent_Popup_Address1;
						
						@FindBy(name="address2")
						public WebElement ContactsContent_Popup_Address2;
						
						@FindBy(name="city")
						public WebElement ContactsContent_Popup_City;
						
						@FindBy(css="select.states")
						public WebElement ContactsContent_Popup_State;
						
							public void ContactsContent_Popup_SelectState(String name)
							{
								new Select(ContactsContent_Popup_State).selectByValue(name);
							}
							
							public String ContactsContent_Popup_GetSelectdState()
							{
								return new Select(ContactsContent_Popup_State).getFirstSelectedOption().getText();
							}
							
							
						@FindBy(name="postalCode")
						public WebElement ContactsContent_Popup_PostalCode;	
						
						@FindBy(name="email")
						public WebElement ContactsContent_Popup_Email;	
						
						@FindBy(name="phoneHome")
						public WebElement ContactsContent_Popup_PhoneNumber1;	
						
						@FindBy(name="phoneWork")
						public WebElement ContactsContent_Popup_PhoneNumber2;
						
						@FindBy(name="fax")
						public WebElement ContactsContent_Popup_Fax;
						
						@FindBy(id="addContact")
						public WebElement ContactsContent_Popup_Add;
						
						
						//Get Table data for given row
						public String ContactsContent_GetTableData(int i, int column)
						{	
							try {
								String cssSelector = "div#accordion3 table tbody tr:nth-of-type(" + i + ") td:nth-of-type(" + column + ")";
								return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
							} catch (Exception e) {
								//
							}
							return "no data";
						}
						
						//Edit button
						@FindBy(css="a.editContact")
						public WebElement ContactsContent_Edit;
						
							@FindBy(css="#editContactForm [name='contactName']")
							public WebElement ContactsContent_Popup_Edit_ContactName;

							@FindBy(css="#editContactForm [name='address1']")
							public WebElement ContactsContent_Popup_Edit_Address1;
							
							@FindBy(css="#editContactForm [name='address2']")
							public WebElement ContactsContent_Popup_Edit_Address2;
							
							@FindBy(css="#editContactForm [name='city']")
							public WebElement ContactsContent_Popup_Edit_City;
							
							@FindBy(css="#editContactForm select.states")
							public WebElement ContactsContent_Popup_Edit_State;
							
								public void ContactsContent_Popup_Edit_SelectState(String name)
								{
									new Select(ContactsContent_Popup_Edit_State).selectByValue(name);
								}
								
								public String ContactsContent_Popup_Edit_GetSelectdState()
								{
									return new Select(ContactsContent_Popup_Edit_State).getFirstSelectedOption().getText();
								}
								
							@FindBy(css="#editContactForm [name='postalCode']")
							public WebElement ContactsContent_Popup_Edit_PostalCode;	
							
							@FindBy(css="#editContactForm [name='email']")
							public WebElement ContactsContent_Popup_Edit_Email;	
							
							@FindBy(css="#editContactForm [name='phoneHome']")
							public WebElement ContactsContent_Popup_Edit_PhoneNumber1;	
							
							@FindBy(css="#editContactForm [name='phoneWork']")
							public WebElement ContactsContent_Popup_Edit_PhoneNumber2;
							
							@FindBy(css="#editContactForm [name='fax']")
							public WebElement ContactsContent_Popup_Edit_Fax;
						
							@FindBy(id="editContact")
							public WebElement ContactsContent_Popup_Edit_Submit;
						
						
				
			// Documents
				@FindBy(id="opportunityDocuments")
				public WebElement DocumentsTab ;
				
					//Add new document
					@FindBy(css="#opportunityDocumentsTab i.fa-plus")
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
						
				
				@FindBy(id="opportunityDocumentsTab")
				public WebElement DocumentsContent;
				
			// Messages
				@FindBy(id="opportunityMessages")
				public WebElement MessagesTab ;
				
				@FindBy(id="opportunityMessagesTab")
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
	
				
		//Search and Add Properties section
		@FindBy(css="#s2id_propertyAutoSuggestDD b")
		public WebElement Search_Add_Properties_DropdownArrow;
		
		@FindBy(css="#select2-drop > div > input")
		public WebElement Search_Add_Properties_Textbox;
		
		@FindBy(css="#select2-drop ul li")
		public WebElement Search_Add_Properties_FirstResult;
		
		@FindBy(id="addPropertyToOpportunity")
		public WebElement AddProperty;
		
		@FindBy(css="#s2id_propertyAutoSuggestDD > a > span.select2-chosen")
		public WebElement SelectedProperty;
		
		//Search Property on Table
		public void SearchOnTable(String propaddress) throws InterruptedException
		{
			String cssSelector = "div#hilOppPropertyTable_filter input";
			driver.findElement(By.cssSelector(cssSelector)).sendKeys(propaddress);
			Thread.sleep(15000);
		}
		
		public String Search_Add_Property(String searchtext) throws InterruptedException
		{
			Search_Add_Properties_DropdownArrow.click();
			Thread.sleep(10000);
			Search_Add_Properties_Textbox.sendKeys(searchtext);
			Thread.sleep(10000);
			Search_Add_Properties_FirstResult.click();
			Thread.sleep(2000);
			String propaddresss = SelectedProperty.getText().trim();
			AddProperty.click();
			Thread.sleep(10000);
			return propaddresss;
		}
		
		
		//Table
		
		
			//Get Table data
			public String GetTableData(int i, int column) throws InterruptedException
			{	
				String cssSelector = "#hilOppPropertyTable  tbody tr:nth-of-type(" + i + ") td:nth-of-type(" + column + ")";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				
			}
			
			
			//Get List Price
			public String GetListPrice(int i) throws InterruptedException
			{	
				String cssSelector = "#hilOppPropertyTable  tbody tr:nth-of-type(" + i + ") td:nth-of-type(4) div";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				
			}
		
			//Click on 'Ready For Investor Review' button
			public void ClickOnReadyForInvestorReviewButton() throws InterruptedException
			{
				String cssSelector = "#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='READY_INVESTOR_REVIEW']";
				driver.findElement(By.cssSelector(cssSelector)).click();
				Thread.sleep(10000);
				driver.findElement(By.id("oppPropertyYesNoConfirmBtn")).click();
				Thread.sleep(10000);
			}
			
			//Investor Review
			
				@FindBy(css="#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='READY_TO_INVEST']")
			    public WebElement Start_Investment_button;
			
				//Click on 'Investor Review' button
				public void ClickOnInvestorReviewButton() throws InterruptedException
				{
					String cssSelector = "#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='INVESTOR_REVIEW']";
					driver.findElement(By.cssSelector(cssSelector)).click();
					Thread.sleep(10000);
					
				}
				
				@FindBy(css="div.date-picker i[class='fa fa-calendar']")
			    public WebElement InvestorReview_ReviewDate_CalenderIcon;
				
				public void InvestorReview_ReviewDate_SelectDate() throws InterruptedException
				{
					ClosingDetailsPage closing = new ClosingDetailsPage(driver);
					InvestorReview_ReviewDate_CalenderIcon.click();
					Thread.sleep(2000);
					closing.ClickOnCurrentDate();
					Thread.sleep(2000);
				}
				
				//@FindBy(css="textarea[name='comments']")
				@FindBy(css="#hilOppPropertyTable > tbody div > textarea")
			    public WebElement InvestorReview_Comments;
				
				@FindBy(css="button.saveToggleBtnClass")
			    public WebElement InvestorReview_Save;
				

			//Ready To Invest
				
				
				@FindBy(css="#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='READY_TO_INVEST']")
			    public WebElement ReadyToInvest_button;
				
				@FindBy(css="#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='PROPERTY_REJECTED']")
			    public WebElement RejectedByInvestor_button;
				
				//Click on 'Ready To Invest' button
				public void ClickOnReadyToInvestButton()
				{
					String cssSelector = "#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='READY_TO_INVEST']";
					driver.findElement(By.cssSelector(cssSelector)).click();
					try {Thread.sleep(10000);} catch (InterruptedException e) {}	
					
				}		
				
				@FindBy(id="offerAmount_currency")
			    public WebElement ReadyToInvest_OfferAmount;
					
				@FindBy(id="emdAmount_currency")
			    public WebElement ReadyToInvest_EMDAmount;
				
				@FindBy(id="firstInvlegalName")
			    public WebElement ReadyToInvest_FirstInvestorLegalName;
					
				@FindBy(css="div.date-picker i[class='fa fa-calendar']")
			    public WebElement ReadyToInvest_OfferDate_CalenderIcon;
				
				public void ReadyToInvest_OfferDate_SelectDate() throws InterruptedException
				{
					ClosingDetailsPage closing = new ClosingDetailsPage(driver);
					ReadyToInvest_OfferDate_CalenderIcon.click();
					Thread.sleep(2000);
					closing.ClickOnCurrentDate();
					Thread.sleep(2000);
				}
				
				@FindBy(css="form > div:nth-child(4) > div:nth-child(2) > div > span > button > i")
			    public WebElement ReadyToInvest_EstimatedClosingDate_CalenderIcon;
				
				public void ReadyToInvest_EstimatedClosingDate_SelectDate() throws InterruptedException
				{
					ClosingDetailsPage closing = new ClosingDetailsPage(driver);
					ReadyToInvest_EstimatedClosingDate_CalenderIcon.click();
					Thread.sleep(2000);
					closing.ClickOnCurrentDate();
					Thread.sleep(2000);
				}
				
				@FindBy(css="div#financingTypeDD [name='financingType']")
			    public WebElement ReadyToInvest_FinancingType;
				
				public void ReadyToInvest_SelectFinancingType(String type) throws InterruptedException
				{
					new Select(ReadyToInvest_FinancingType).selectByVisibleText(type);
					
				}
				
				@FindBy(id="lpoa")
			    public WebElement ReadyToInvest_LPOA;
				
				public void ReadyToInvest_SelectHUSinger(int i)
				{
					new Select(driver.findElement(By.cssSelector("div#husignerDD [name='huSigner']"))).selectByIndex(i);;
				}
				
				
				@FindBy(css="#hilOppPropertyTable > tbody > tr:nth-child(2) > td > div > div > form > div.marg_top10.col-md-9 >div > textarea")
				//@FindBy(css="textarea[name='comments']")
			    public WebElement ReadyToInvest_Comments;
				
				@FindBy(css="button.saveToggleBtnClass")
			    public WebElement ReadyToInvest_Save;
				
				@FindBy(id="createPAbuttn")
			    public WebElement ReadyToInvest_CreatePA;
			
				
			//Create Offer
				
				@FindBy(css="#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='CREATE_OFFER']")
			    public WebElement CreateOffer_button;
				
				//Click on 'Create Offer' button
				public void ClickOnCreateOfferButton() throws InterruptedException
				{
					String cssSelector = "#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='CREATE_OFFER']";
					driver.findElement(By.cssSelector(cssSelector)).click();
					Thread.sleep(10000);
					
				}	
				
				
				@FindBy(id="offerAmount")
			    public WebElement CreateOffer_OfferAmount;
				
				@FindBy(id="emdAmount")
			    public WebElement CreateOffer_EMDAmount;
				
				@FindBy(id="offerDate")
			    public WebElement CreateOffer_OfferDate;
				
				@FindBy(id="estimatedClosingDate")
			    public WebElement CreateOffer_EstimatedClosingDate;
				
				@FindBy(css="div.docusignEnvelopeArea")
			    public WebElement CreateOffer_DocusignEnvelope;
				
					@FindBy(css="div.docusignEnvelopeArea button.reviewPALinkButton")
				    public WebElement CreateOffer_DocusignEnvelope_ReviewApprovePAButton;
					
					//Review Purchase Agreement section
					
					@FindBy(css="iframe.cboxIframe")
				    public WebElement CreateOffer_DocusignEnvelope_RPA_iFrame;
					
					@FindBy(css="#action-bar-btn-continue")
				    public WebElement CreateOffer_DocusignEnvelope_RPA_Continue;
					
					@FindBy(css="#action-bar-bottom-btn-finish")
				    public WebElement CreateOffer_DocusignEnvelope_RPA_Finish;
					
					@FindBy(css="#signingIframe")
				    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_iFrame;
					
						@FindBy(css="#ds_hldrBdy_navnexttext_btnInline")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_Start_Button;
						
						@FindBy(css="input[title='Sign Here']")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_SignHere;
						
						//Fill values in all blank fields
						public void CreateOffer_DocusignEnvelope_RPA_Page_FillBlankValues()
						{
							String cssSelector = "div#ds_hldrBdy_holderPage input.InputTabRequired";
							List<WebElement> allelements = driver.findElements(By.cssSelector(cssSelector));
						
							for(WebElement e:allelements)
							{
								if(e.getAttribute("value").equals(""))
								{
									e.sendKeys("test");
								}
							}
						}
						
						//Date
						@FindBy(css="div.FirstPage div:nth-of-type(9) input")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_Date;
						
						//Buyer
						@FindBy(css="div.FirstPage div:nth-of-type(10) input")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_Buyer;
						
						//Address
						@FindBy(css="div.FirstPage div:nth-of-type(13) input")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_Address;
						
						//County
						@FindBy(css="div.FirstPage div:nth-of-type(16) input")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_County;
						
						//Zip
						@FindBy(css="div.FirstPage div:nth-of-type(17) input")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_Zip;
						
						//Offer Amount
						@FindBy(css="div.FirstPage div:nth-of-type(21) input")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_OfferAmount;
						
						//Offer Amount in Words
						@FindBy(css="div.FirstPage div:nth-of-type(22) input")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_OfferAmount_InWords;
						
						//Offer EMD Amount
						@FindBy(css="div.FirstPage div:nth-of-type(23) input")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_EMDAmount;
						
						//Address at Footer
						@FindBy(css="div.FirstPage div:nth-of-type(24) input")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_Address_Footer;
						
						//'Cash' checkbox - attribute - checked=checked
						@FindBy(css="input[type=checkbox']")
					    public WebElement CreateOffer_DocusignEnvelope_RPA_Page_Cash_Checkbox;
						
						
						
					@FindBy(id="cboxClose")
				    public WebElement CreateOffer_DocusignEnvelope_RPA_Close;
					
					
				
				
				@FindBy(css="div.docusignEnvelopeArea td:nth-of-type(1) span")
			    public WebElement CreateOffer_DocusignEnvelope_Status;
				
				@FindBy(css="div.docusignEnvelopeArea td:nth-of-type(1) button")
			    public WebElement CreateOffer_DocusignEnvelope_Refresh;
				
				@FindBy(css="div.docusignEnvelopeArea td:nth-of-type(2) tbody tr:nth-of-type(2) td:nth-of-type(2)")
			    public WebElement CreateOffer_DocusignEnvelope_Action_ILM_Status;
				
				@FindBy(name="terms")
			    public WebElement CreateOffer_ChangeofTerms;
		
				//@FindBy(css="#hilOppPropertyTable > tbody div > textarea")
				@FindBy(css="textarea[name='comments']")
			    public WebElement CreateOffer_Comments;
				
				@FindBy(css="button.saveToggleBtnClass")
			    public WebElement CreateOffer_Save;
			

			//Submit Offer
				
				@FindBy(css="#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='SUBMIT_OFFER']")
			    public WebElement SubmitOffer_button;
				
				//Click on 'Submit Offer' button
				public void ClickOnSubmitOfferButton() throws InterruptedException
				{
					String cssSelector = "#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='SUBMIT_OFFER']";
					driver.findElement(By.cssSelector(cssSelector)).click();
					Thread.sleep(10000);
				
				}
				
				@FindBy(id="offerAmount")
			    public WebElement SubmitOffer_OfferAmount;
				
				@FindBy(id="emdAmount")
			    public WebElement SubmitOffer_EMDAmount;
				
				@FindBy(id="offerDate")
			    public WebElement SubmitOffer_OfferDate;
				
				@FindBy(id="estimatedClosingDate")
			    public WebElement SubmitOffer_EstimatedClosingDate;
				
				@FindBy(name="terms")
			    public WebElement SubmitOffer_ChangeofTerms;
				
				//@FindBy(css="#hilOppPropertyTable > tbody div > textarea")
				@FindBy(css="textarea[name='comments']")
			    public WebElement SubmitOffer_Comments;
				
				@FindBy(css="button.saveToggleBtnClass")
			    public WebElement SubmitOffer_Save;
			
				
			//Accept Offer
				
				@FindBy(css="#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-subtaskkey='ACCEPT']")
			    public WebElement AcceptOffer_button;
				
				@FindBy(css="#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-subtaskkey='COUNTER']")
			    public WebElement CounterOffer_button;
				
				@FindBy(css="#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-subtaskkey='REJECT']")
			    public WebElement RejectOffer_button;
				
				
				//Click on 'Accept Offer' button
				public void ClickOnAcceptOfferButton() throws InterruptedException
				{
					String cssSelector = "#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='OFFER_RESPONSE']";
					driver.findElement(By.cssSelector(cssSelector)).click();
					Thread.sleep(10000);
				
				}	
				
				//@FindBy(css="#hilOppPropertyTable > tbody div > textarea")
				@FindBy(css="textarea[name='comments']")
			    public WebElement AcceptOffer_Comments;
				
				@FindBy(css="button.saveToggleBtnClass")
			    public WebElement AcceptOffer_Save;
				
				
				
			//Upload Purchase agreement
				
				@FindBy(css="#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='UPLOAD_PA']")
			    public WebElement UploadPA_button;
				
				
				//Click on 'Upload Purchase agreement' button
				public void ClickOnUploadPAButton() throws InterruptedException
				{
					String cssSelector = "#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='UPLOAD_PA']";
					driver.findElement(By.cssSelector(cssSelector)).click();
					Thread.sleep(10000);
				
				}	
				
				@FindBy(id="offerAmount_currency")
			    public WebElement UploadPA_OfferAmount;
				
				@FindBy(id="emdAmount_currency")
			    public WebElement UploadPA_EMDAmount;
				
				@FindBy(css="form > div:nth-child(3) > div:nth-child(1) > div > span > button > i")
			    public WebElement UploadPA_PADate_CalenderIcon;
				
				public void UploadPA_PADate_SelectDate() throws InterruptedException
				{
					ClosingDetailsPage closing = new ClosingDetailsPage(driver);
					UploadPA_PADate_CalenderIcon.click();
					Thread.sleep(2000);
					closing.ClickOnCurrentDate();
					Thread.sleep(2000);
				}
				
				@FindBy(css="form > div:nth-child(3) > div:nth-child(2) > div > span > button > i")
			    public WebElement UploadPA_EscrowDate_CalenderIcon;
				
				public void UploadPA_Escrow_Date_SelectDate() throws InterruptedException
				{
					ClosingDetailsPage closing = new ClosingDetailsPage(driver);
					UploadPA_EscrowDate_CalenderIcon.click();
					Thread.sleep(2000);
					closing.ClickOnCurrentDate();
					Thread.sleep(2000);
				}
				
				@FindBy(name="finalPaAgreement")
			    public WebElement UploadPA_UploadDoc;
				
				@FindBy(name="terms")
			    public WebElement UploadPA_ChangeOfTerms;
				
				@FindBy(css="button.saveToggleBtnClass")
			    public WebElement UploadPA_Save;		
				
			
				
			//Closing Details
				
				@FindBy(css="#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='INITIATE_CLOSING']")
			    public WebElement ClosingDetails_button;
				
				
				//Click on 'Closing Details' button
				public void ClickOnClosingDetailsButton() throws InterruptedException
				{
					String cssSelector = "#hilOppPropertyTable tbody tr:nth-of-type(1) td:nth-of-type(7) button[data-taskkey='INITIATE_CLOSING']";
					driver.findElement(By.cssSelector(cssSelector)).click();
					Thread.sleep(20000);
				
				}	
				
}
