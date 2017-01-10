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

public class RehabDetailsPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public RehabDetailsPage(WebDriver driver)
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
		@FindBy(css="h4.marg_top0")
		public WebElement Address;
		
		@FindBy(css="#rehab-summary-view > div > div:nth-child(6) > div > a")
		public WebElement initiateMrk;
		
		@FindBy(css="#initiateMarketingBtn")
		public WebElement initiateMrkcnfrm;
	// All Tabs
		
		// AMAgreements
			@FindBy(id="AMAgreements")
			public WebElement AMAgreementsTab ;
			
			@FindBy(id="AMAgreementsTab")
			public WebElement AMAgreementsContent;
		
		// Financials
			@FindBy(id="financial")
			public WebElement FinancialsTab ;
			
			@FindBy(id="financialTab")
			public WebElement FinancialsContent;
		
		// Leases
			@FindBy(id="leases")
			public WebElement LeasesTab ;
			
			@FindBy(id="leasesTab")
			public WebElement LeasesContent;
			
		// Expenses
			@FindBy(id="expenses")
			public WebElement ExpensesTab ;
			
			@FindBy(id="expensesTab")
			public WebElement ExpensesContent;
			
		// Messages
			@FindBy(id="rehabMessages")
			public WebElement MessagesTab ;
			
			@FindBy(id="messagesTab")
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
			
			
		// RehabRepairs
			@FindBy(id="rehabrepair")
			public WebElement RehabRepairsTab ;
			
			@FindBy(id="rehabrepairTab")
			public WebElement RehabRepairsContent;
			
			
		// Tasks
			@FindBy(id="calendar")
			public WebElement TasksTab ;
			
			@FindBy(id="calendarTab")
			public WebElement TasksContent;
	
		// Documents
			@FindBy(id="rehabDocuments")
			public WebElement DocumentsTab ;
			
			@FindBy(id="rehabDocumentsTab")
			public WebElement DocumentsContent;
			
				//Add new document
				@FindBy(css="#rehabDocumentsTab i.fa-plus")
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
			@FindBy(id="rehabContact")
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
			
						
			// Rehab Items
			@FindBy(id="rehabItems")
			public WebElement RehabItemsTab ;
			
			@FindBy(id="rehabItemsTab")
			public WebElement RehabItemsContent;
			
				//Add new contact
				@FindBy(css="#rehabItemsTab i.fa-plus")
				public WebElement RehabItemsContent_Add;
			
					//pop up
					
					@FindBy(name="rehabCategoryId")
					public WebElement RehabItemsContent_Popup_Category;
					
					@FindBy(name="paidById")
					public WebElement RehabItemsContent_Popup_RepairRehabPaidBy;
					
						public void RehabItemsContent_Popup_SelectCategory(String name)
						{
							new Select(RehabItemsContent_Popup_Category).selectByVisibleText(name);
						}
						
						public void RehabItemsContent_Popup_SelectRepairRehabPaidBy(String name)
						{
							new Select(RehabItemsContent_Popup_RepairRehabPaidBy).selectByVisibleText(name);
						}
						
						public String RehabItemsContent_Popup_GetSelectdCategory()
						{
							return new Select(RehabItemsContent_Popup_Category).getFirstSelectedOption().getText().trim();
						}
						
						public String RehabItemsContent_Popup_GetSelectdRepairRehabPaidBy()
						{
							return new Select(RehabItemsContent_Popup_RepairRehabPaidBy).getFirstSelectedOption().getText().trim();
						}
						
						
					@FindBy(name="workDescription")
					public WebElement RehabItemsContent_Popup_WorkDescription;	
				
					
					@FindBy(id="saveRepairItemDetails")
					public WebElement RehabItemsContent_Popup_Save;
					
					
				//Get Table data for given row
				public String RehabItemsContent_GetTableData(int i, int column)
				{	
					try {
						String cssSelector = "#rehabRepairTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(" + column + ")";
						return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
					} catch (Exception e) {
						//
					}
					return "no data";
				}
				
				//Edit button
				
				public void RehabItemsContent_Table_Edit(int i)
				{	
					String cssSelector = "#rehabRepairTable tbody tr:nth-of-type(" + i + ") a.edit_blue";
					driver.findElement(By.cssSelector(cssSelector)).click();
					try { Thread.sleep(15000);} catch (InterruptedException e) {}
					
				}
				
				//delete button
				public void RehabItemsContent_Table_Delete(int i)
				{	
					String cssSelector = "#rehabRepairTable tbody tr:nth-of-type(" + i + ") a.rehabItemRemoveBtn";
					driver.findElement(By.cssSelector(cssSelector)).click();
					try { Thread.sleep(5000);} catch (InterruptedException e) {}
					driver.findElement(By.id("rehabItemRemoveConfirmBtn")).click();
					try { Thread.sleep(5000);} catch (InterruptedException e) {}
				}
		
				
		// Rehab Photos
		@FindBy(id="rehabPhotos")
		public WebElement RehabPhotosTab ;
		
		@FindBy(id="rehabPhotosTab")
		public WebElement RehabPhotosContent;
		
			@FindBy(css="button.RehabPhotos")
			public WebElement RehabPhotosContent_RehabPhotos;
			
				@FindBy(css="div.uploadPhotos")
				public WebElement RehabPhotosContent_RehabPhotos_UploadPhotos;
				
					//pop up
					@FindBy(id="uploadPhotoFiles")
					public WebElement RehabPhotosContent_RehabPhotos_UploadPhotos_Popup_Image;
					
					@FindBy(id="startUploadButton")
					public WebElement RehabPhotosContent_RehabPhotos_UploadPhotos_Popup_Upload;
					
				//Verify that image is uploaded successfully
				public boolean RehabPhotosContent_RehabPhotos_IsPhotoUploaded(String foldername, String imagename)
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
			public void RehabPhotosContent_ClickOnAddFolderButton()
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
			public WebElement RehabPhotosContent_AddFolder_Popup_Name;
			
			@FindBy(id="createFolderFiles")
			public WebElement RehabPhotosContent_AddFolder_Popup_Image;
			
			@FindBy(id="createFolderBtn")
			public WebElement RehabPhotosContent_AddFolder_Popup_Upload;
				
			//Verify folder added successfully or not 	
			public boolean RehabPhotosContent_IsFolderAdded(String foldername)
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
			public boolean RehabPhotosContent_GoToFolder(String foldername)
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
		
				
}
