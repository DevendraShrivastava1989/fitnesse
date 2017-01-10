package pageFactory.Embrace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utility.Constants;
import utility.JavaHelpers;

public class MarketingDetailsPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public MarketingDetailsPage(WebDriver driver)
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
		@FindBy(css="#marketingDetailsData h3 a")
		public WebElement Address;
		
		@FindBy(css="#maincontainer > div > div:nth-child(1) > div > h3")
		public WebElement mrkheaderadress;
		
		@FindBy(css="#showOpenMarketingToggleButton")
		public WebElement Marketing_SHOW_ALL_OPEN;
		
	// All Tabs
		
		@FindBy(css="#marketingSteps")
		public WebElement Marketing_StepsTab;
		
		
		// Contacts
			@FindBy(id="marketingContact")
			public WebElement ContactsTab ;
			
			@FindBy(id="contactsTab")
			public WebElement ContactsContent;
			
				//Add new contact
				@FindBy(css="#contactsTab i.fa-plus")
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
						
			
			// Leasing Photos
			@FindBy(id="marketingPhotos")
			public WebElement LeasingPhotosTab ;
			
			@FindBy(id="marketingPhotosTab")
			public WebElement LeasingPhotosContent;
			
				@FindBy(css="button.LeasingPhotos")
				public WebElement LeasingPhotosContent_LeasingPhotos;
				
					@FindBy(css="div.uploadPhotos")
					public WebElement LeasingPhotosContent_LeasingPhotos_UploadPhotos;
					
						//pop up
						@FindBy(id="uploadPhotoFiles")
						public WebElement LeasingPhotosContent_LeasingPhotos_UploadPhotos_Popup_Image;
						
						@FindBy(id="startUploadButton")
						public WebElement LeasingPhotosContent_LeasingPhotos_UploadPhotos_Popup_Upload;
						
					//Verify that image is uploaded successfully
					public boolean LeasingPhotosContent_LeasingPhotos_IsPhotoUploaded(String foldername, String imagename)
					{
						boolean b = false ; 
						String cssSelector = "div." + foldername + " p";
						List<WebElement> allphothos = driver.findElements(By.cssSelector(cssSelector));
						
						for(WebElement e:allphothos)
						{
							
							String temp = e.getAttribute("innerText").trim();
						
							if(temp.contains(imagename))
							{
								b= true;
								break;
							}
						}
						
						return b; 
						
					}
					
				//Click on Add Folder button	
				public void LeasingPhotosContent_ClickOnAddFolderButton()
				{
					List<WebElement> alltabs = driver.findElements(By.cssSelector("button[name='filterButton']"));
					
					for(WebElement e:alltabs)
					{
						if(e.getText().trim().equals("All"))
						{
							e.click();
						}
						
						driver.findElement(By.cssSelector("div#createFolder")).click();
						break;
					}
					try { Thread.sleep(5000);} catch (InterruptedException e) {}
					
				}
				
				//pop up
				@FindBy(id="createFolderName")
				public WebElement LeasingPhotosContent_AddFolder_Popup_Name;
				
				@FindBy(id="createFolderFiles")
				public WebElement LeasingPhotosContent_AddFolder_Popup_Image;
				
				@FindBy(id="createFolderBtn")
				public WebElement LeasingPhotosContent_AddFolder_Popup_Upload;
					
				//Verify folder added successfully or not 	
				public boolean LeasingPhotosContent_IsFolderAdded(String foldername)
				{
					boolean b = false;
					List<WebElement> alltabs = driver.findElements(By.cssSelector("button[name='filterButton']"));
					
					for(WebElement e:alltabs)
					{
						if(e.getText().trim().equals(foldername))
						{
							b= true;
							break;
						}
						
					}
					
					return b;
					
				}
				
				
				//Go to given folder
				public boolean LeasingPhotosContent_GoToFolder(String foldername)
				{
					boolean b = false;
					List<WebElement> alltabs = driver.findElements(By.cssSelector("button[name='filterButton']"));
					
					for(WebElement e:alltabs)
					{
						if(e.getText().trim().equals(foldername))
						{
							e.click();
							break;
						}
						
					}
					
					return b;
					
				}
				
				
		// Documents
			@FindBy(id="marketingDocuments")
			public WebElement DocumentsTab ;
			
			@FindBy(id="marketingDocumentsTab")
			public WebElement DocumentsContent;
			
				//Add new document
				@FindBy(css="#marketingDocumentsTab i.fa-plus")
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
				
				
		
		// Messages
			@FindBy(id="marketingMessages")
			public WebElement MessagesTab ;
			
			@FindBy(id="marketingMessagesTab")
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
						new Actions(driver).moveToElement(driver.findElement(By.xpath(cssSelector)));
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
	
    //Task elements
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement schedulePhotographer_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement schedulePhotographer_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement schedulePhotographer_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement request_updatedCMA_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement request_updatedCMA_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement request_updatedCMA_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement approvePhotographs_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement approvePhotographs_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement approvePhotographs_save;
				
				@FindBy(css="#REVIEW_RENT_POPUP_1 div.modal-content div.modal-body div.form-group i[class='fa fa-calendar']")
				public WebElement reviewrent_calenderIcon;
				@FindBy(css="#REVIEW_RENT_POPUP_1 div.modal-content div.modal-body div.form-group textarea[name='comments'][class='form-control']")
				public WebElement reviewrent_comments;
				@FindBy(css="#REVIEW_RENT_POPUP_1 div.modal-content div.modal-footer [id='milestonePopupSubmitButton']")
				public WebElement reviewrent_save;
				@FindBy(css="#REVIEW_RENT_POPUP_1 div.modal-content div.modal-footer [id='cancelButton']")
				public WebElement reviewrent_cancel;
				@FindBy(css="#REVIEW_RENT_POPUP_1 div.modal-content #updatedCma_currency")
				public WebElement reviewrent_updatedCma;
				@FindBy(css="#REVIEW_RENT_POPUP_1 div.modal-content #zestimate_currency")
				public WebElement reviewrent_zestimate;
				@FindBy(css="#REVIEW_RENT_POPUP_1 div.modal-content #updatedCma")
				public WebElement reviewrent_updatedCmaval;
				@FindBy(css="#REVIEW_RENT_POPUP_1 div.modal-content #zestimate")
				public WebElement reviewrent_zestimateval;
				
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement payPhotographer_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement payPhotographer_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement payPhotographer_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement uploadPhotos_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement uploadPhotos_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement uploadPhotos_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement AddListing_Copy_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement AddListing_Copy_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement AddListing_Copy_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Postto_Craigslist_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Postto_Craigslist_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Postto_Craigslist_save;
					
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement SetSyndication_Flags_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement SetSyndication_Flags_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement SetSyndication_Flags_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement ConfirmSyndication_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement ConfirmSyndication_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement ConfirmSyndication_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Request_Lease_ListingILM_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Request_Lease_ListingILM_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Request_Lease_ListingILM_save;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement UploadLease_Listing_Agreement_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement UploadLease_Listing_Agreement_comments;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement UploadLease_Listing_Agreement_save;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 #document")
				public WebElement UploadLease_Listing_Agreement_Document;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Upload_Executed_Lease_Listing_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Upload_Executed_Lease_Listing_comments;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Upload_Executed_Lease_Listing_save;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 #document")
				public WebElement Upload_Executed_Lease_Listing_Document;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Upload_MLS_Sheet_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Upload_MLS_Sheet_comments;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Upload_MLS_Sheet_save;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 #document")
				public WebElement Upload_MLS_Sheet_Document;
			
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement ApplicationsAccepted_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement ApplicationsAccepted_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement ApplicationsAccepted_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Monitor_Lead_Activity_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Monitor_Lead_Activity_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Monitor_Lead_Activity_save;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Confirm_Deposit_Receipt_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Confirm_Deposit_Receipt_comments;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Confirm_Deposit_Receipt_save;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 #document")
				public WebElement Confirm_Deposit_Receipt_Document;
				
				
				@FindBy(css="#CONFIRM_MOVEIN_POPUP_1 div.modal-content div:nth-of-type(1) div:nth-of-type(1) [class='fa fa-calendar']")
				public WebElement ConfirmMove_in_Date_MOVEIN_DATEcalenderIcon;
				@FindBy(css="#CONFIRM_MOVEIN_POPUP_1 div.modal-content div:nth-of-type(2) div:nth-of-type(2) [class='fa fa-calendar']")
				public WebElement ConfirmMove_in_Date_calenderIcon;
				@FindBy(css="#CONFIRM_MOVEIN_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement ConfirmMove_in_Date_comments;
				@FindBy(css="#CONFIRM_MOVEIN_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement ConfirmMove_in_Date_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement SendLease_for_Tenant_Signature_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement SendLease_for_Tenant_Signature_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement SendLease_for_Tenant_Signature_save;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Confirm_Lease_Signed_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Confirm_Lease_Signed_comments;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Confirm_Lease_Signed_save;
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_MARKETING_1 #document")
				public WebElement Confirm_Lease_Signed_Document;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Schedule_Move_in_Inspection_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Schedule_Move_in_Inspection_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Schedule_Move_in_Inspection_save;
			
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Notify_InvestorofDeposit_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Notify_InvestorofDeposit_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Notify_InvestorofDeposit_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement RemovefromCraigslist_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement RemovefromCraigslist_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement RemovefromCraigslist_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement RemovefromMLS_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement RemovefromMLS_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement RemovefromMLS_save;

				@FindBy(css="#MOVEIN_INSPECTION_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Move_in_Inspection_calenderIcon;
				@FindBy(css="#MOVEIN_INSPECTION_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Move_in_Inspection_comments;
				@FindBy(css="#MOVEIN_INSPECTION_1 div.modal-content [id='appraisalRequiredPopupSubmitButton']")
				public WebElement Move_in_Inspection_save;
				@FindBy(css="#MOVEIN_INSPECTION_1 div.modal-content div.form-group div.radio#uniform-optionsRadiosyes")
				public WebElement Move_in_Inspection_CheckYes;
				@FindBy(css="#MOVEIN_INSPECTION_1 div.modal-content div.form-group div.radio#uniform-optionsRadiosno")
				public WebElement Move_in_Inspection_CheckNo;
				@FindBy(css="#MOVEIN_INSPECTION_1 #document")
				public WebElement Move_in_Inspection_Document;
				
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement MoveinRepairs_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement MoveinRepairs_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement MoveinRepairs_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement StopLawn_Care_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement StopLawn_Care_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement StopLawn_Care_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement PropertyLeased_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement PropertyLeased_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement PropertyLeased_save;
				
				@FindBy(css="#MOVEIN-DOCS_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Move_in_Documents_calenderIcon;
				@FindBy(css="#MOVEIN-DOCS_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Move_in_Documents_comments;
				@FindBy(css="#MOVEIN-DOCS_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Move_in_Documents_save;
				@FindBy(css="#MOVEIN-DOCS_POPUP_1 input#utilityTransferDocument")
				public WebElement Move_in_DocUpload;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement SendWelcome_Letter_toTenant_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement SendWelcome_Letter_toTenant_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement SendWelcome_Letter_toTenant_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement NotifyInvestor_of_Movein_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement NotifyInvestor_of_Movein_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement NotifyInvestor_of_Movein_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement BonusPayment_Processing_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement BonusPayment_Processing_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement BonusPayment_Processing_save;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Followup_with_Tenant_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Followup_with_Tenant_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Followup_with_Tenant_save;

				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content div.form-group [class='fa fa-calendar']")
				public WebElement Update_PropertyWare_Yardi_calenderIcon;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments'][class='form-control']")
				public WebElement Update_PropertyWare_Yardi_comments;
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content [id='milestonePopupSubmitButton']")
				public WebElement Update_PropertyWare_Yardi_save;	
				
				
				@FindBy(css="#assetMarketingStepsTable tbody.with-popover")
				public WebElement marketingTasktable;
				
				
				
				@FindBy(css="#marketingStatusDiv [name='asset-marketing-status']")
				public WebElement marketingStatus_Dropdown;
				
				
				public void Step_Update_PropertyWare_Yardi_SelectDate()
				{
					Update_PropertyWare_Yardi_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_BonusPayment_Processing_SelectDate()
				{
					BonusPayment_Processing_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_Followup_with_Tenant_SelectDate()
				{
					Followup_with_Tenant_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_SendWelcome_Letter_toTenant_SelectDate()
				{
					SendWelcome_Letter_toTenant_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_NotifyInvestor_of_Move_SelectDate()
				{
					NotifyInvestor_of_Movein_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_Move_in_Documents_SelectDate()
				{
					Move_in_Documents_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_Move_in_Inspection_SelectDate()
				{
					Move_in_Inspection_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_MoveinRepairs_SelectDate()
				{
					MoveinRepairs_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_StopLawn_Care_SelectDate()
				{
					StopLawn_Care_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
			
				public void Step_PropertyLeased_SelectDate()
				{
					PropertyLeased_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_Notify_InvestorofDeposit_SelectDate()
				{
					Notify_InvestorofDeposit_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_RemovefromCraigslist_SelectDate()
				{
					RemovefromCraigslist_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_RemovefromMLS_SelectDate()
				{
					RemovefromMLS_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
					
				
				public void Step_SendLease_for_Tenant_Signature_SelectDate()
				{
					SendLease_for_Tenant_Signature_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_Confirm_Lease_Signed_SelectDate()
				{
					Confirm_Lease_Signed_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_Schedule_Move_in_Inspection_SelectDate()
				{
					Schedule_Move_in_Inspection_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
						
				public void Step_Confirm_Deposit_Receipt_SelectDate()
				{
					Confirm_Deposit_Receipt_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_ConfirmMove_in_Date_SelectDate()
				{
					ConfirmMove_in_Date_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_ConfirmMove_in_Date_SelectMove_in_Date()
				{
					ConfirmMove_in_Date_MOVEIN_DATEcalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_schedulePhotographer_SelectDate()
				{
					schedulePhotographer_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_request_updatedCMA_SelectDate()
				{
					request_updatedCMA_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_reviewrent_SelectDate()
				{
					reviewrent_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_payPhotographer_SelectDate()
				{
					payPhotographer_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_approvePhotographs_SelectDate()
				{
					approvePhotographs_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_uploadPhotos_SelectDate()
				{
					uploadPhotos_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_AddListing_Copy_SelectDate()
				{
					AddListing_Copy_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_Postto_Craigslist_SelectDate()
				{
					Postto_Craigslist_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_SetSyndication_Flags_SelectDate()
				{
					SetSyndication_Flags_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				public void Step_ConfirmSyndication_SelectDate()
				{
					ConfirmSyndication_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_Request_Lease_ListingILM_SelectDate()
				{
					Request_Lease_ListingILM_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_UploadLease_Listing_Agreement_SelectDate()
				{
					UploadLease_Listing_Agreement_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_Upload_MLS_Sheet_SelectDate()
				{
					Upload_MLS_Sheet_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_Upload_Executed_Lease_Listing_SelectDate()
				{
					Upload_Executed_Lease_Listing_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
			//
				public void Step_ApplicationsAccepted_SelectDate()
				{
					ApplicationsAccepted_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_Monitor_Lead_Activity_SelectDate()
				{
					Monitor_Lead_Activity_calenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				//Get MessagesTable data for given row
				public String MrkMessagesContent_GetTableData(int i, int column)
				{	
					try {
						String cssSelector = "#commentMessagesTable tr:nth-of-type(" + i + ") td:nth-of-type(" + column + ")";
						//new Actions(driver).moveToElement(driver.findElement(By.cssSelector(cssSelector)));
						return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
					} catch (Exception e) {
						//
					}
					return "no data";
				}
						
				//Get Table data for given Step
				public String GetTableDataForGivenStep(int i, int column)
				{	
					
					String cssSelector = "#assetMarketingStepsTable > tbody > tr:nth-child(" + i + ") > td:nth-child(" + column + ")";
					String data;
					try{
						 data  = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
					} catch (Exception e) { data  = driver.findElement(By.cssSelector(cssSelector)).getText().trim();}
				
						return data;
					
					
				}
				//Click on given Step
				public void ClickOnStep(int i)
				{	
					String cssSelector = "#assetMarketingStepsTable > tbody > tr:nth-child(" + i + ") > td:nth-child(1) a:nth-child(1)";
					try {driver.findElement(By.cssSelector(cssSelector)).click();}
					catch(Exception e){JavascriptExecutor ex = (JavascriptExecutor)driver;
					ex.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(cssSelector)));}
					try {Thread.sleep(4500);} catch (InterruptedException e) {}	//TIME 1
				}
				//To get the selected marketing status
				public String getMRK_Status()
				{
					String mrkStatus="";
					Select marStatus=new Select(marketingStatus_Dropdown);
					try{
						mrkStatus=marStatus.getFirstSelectedOption().getText().trim();
					}catch(NoSuchElementException e){}
						return mrkStatus;
				}
				
				//Click on PST date on Datepicker while completing closing step
				public void ClickOnCurrentDate()
				{	
					String todaydate = JH.GetSystemDate_Date(0);
					
					String selector = "div.datepicker-days tbody td[class='day active']";
					String defaultdate = driver.findElement(By.cssSelector(selector)).getText().trim();
					
					if(defaultdate.length()==1)
					{
						defaultdate = "0"+defaultdate;
					}
					
					if(todaydate.contains(defaultdate))
					{
						driver.findElement(By.cssSelector(selector)).click();
					}
					else
					{
						selector = "div.datepicker-days tbody td[class='day']";
						List<WebElement> allactivedates = driver.findElements(By.cssSelector(selector));
					
						for(WebElement td : allactivedates)
						{
							String temp = td.getText().trim();
							if(temp.length()==1)
							{
								temp = "0"+temp;
							}

							if(todaydate.contains(temp))
							{
								td.click();
								try {Thread.sleep(2000);} catch (InterruptedException e) {}	
								break;
							}
						}
					}
					
					
				}
				
				
				
}
