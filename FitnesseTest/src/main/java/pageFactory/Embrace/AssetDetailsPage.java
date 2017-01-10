package pageFactory.Embrace;

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

public class AssetDetailsPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public AssetDetailsPage(WebDriver driver)
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
		
		@FindBy(css="a[href='editAssetHeader']")
		public WebElement Edit;
				
			//Pop up
			@FindBy(name="statusId")
			public WebElement Edit_PopUp_Status;
			
			public void Edit_PopUp_SelectStatus(String statusname)
			{
				new Select(Edit_PopUp_Status).selectByVisibleText(statusname);
			}
			
			@FindBy(css="input[name='propTax'][value='Y']")
			public WebElement Edit_PopUp_Impounds_PropertyTax_Yes;
			
			@FindBy(css="input[name='propTax'][value='N']")
			public WebElement Edit_PopUp_Impounds_PropertyTax_No;
			
			@FindBy(css="input[name='insurance'][value='Y']")
			public WebElement Edit_PopUp_Impounds_Insurance_Yes;
			
			@FindBy(css="input[name='insurance'][value='N']")
			public WebElement Edit_PopUp_Impounds_Insurance_No;
			
			@FindBy(css="input[name='hoa'][value='Y']")
			public WebElement Edit_PopUp_Impounds_HOA_Yes;
			
			@FindBy(css="input[name='hoa'][value='N']")
			public WebElement Edit_PopUp_Impounds_HOA_No;
			
			@FindBy(id="updateAssetHeaderButton")
			public WebElement Edit_PopUp_Save;
			
			
			
		
		@FindBy(css="#propertyDetailHeader > div.panel-body > div:nth-child(2)")
		public WebElement Address_Section;
		
		@FindBy(css="#propertyDetailHeader > div.panel-body > div.with-popover")
		public WebElement Investor_Section;
		
		
			
			
		
		
	// All Tabs
		
		// AMAgreements
			@FindBy(id="AMAgreements")
			public WebElement AMAgreementsTab ;
			
			@FindBy(id="AMAgreementsTab")
			public WebElement AMAgreementsContent;
			
				@FindBy(id="showAddAMAgreementsModal")
				public WebElement AMAgreementsContent_Add;
			
				// Add pop up 
				@FindBy(css="#editAMAgreementsForm > div > div:nth-of-type(1) i[class='fa fa-calendar']")
			    public WebElement AMAgreementsContent_AddPopUp_StartDateIcon;
			    
			    @FindBy(css="#editAMAgreementsForm > div > div:nth-of-type(2) i[class='fa fa-calendar']")
			    public WebElement AMAgreementsContent_AddPopUp_EndDateIcon;
		
			    @FindBy(id="AAFeeAmount_currency")
			    public WebElement AMAgreementsContent_AddPopUp_AssetAcquisitionFee;
			    
			    @FindBy(name="AAWaivers")
			    public WebElement AMAgreementsContent_AddPopUp_AAWaivers;
			    
			    @FindBy(id="AMFeeAmount_currency")
			    public WebElement AMAgreementsContent_AddPopUp_AssetManagementFee;
			    
			    @FindBy(name="AMWaivers")
			    public WebElement AMAgreementsContent_AddPopUp_AMWaivers;
			    
			    @FindBy(id="editOrSaveAMAgreements")
			    public WebElement AMAgreementsContent_AddPopUp_Save;
			    
			    
			    // Edit pop up
			    @FindBy(css="#editAMAgreementsForm > div > div:nth-of-type(1) input")
			    public WebElement AMAgreementsContent_EditPopUp_StartDate;
			    
			    @FindBy(css="#editAMAgreementsForm > div > div:nth-of-type(2) input")
			    public WebElement AMAgreementsContent_EditPopUp_EndDate;
	
			    
			    // Table
			    public String AMAgreementsContent_GetTableData(int row, int column)
			    {
			    	String cssSelector = "#accordionAMAgreement table tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
			    	return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			    }
			    
			    // Edit
			    public void AMAgreementsContent_Table_Edit(int row)
			    {
			    	String cssSelector = "#accordionAMAgreement table tr:nth-of-type(" + row + ") a.showEditAMAgreementsModal";
			    	driver.findElement(By.cssSelector(cssSelector)).click();
			    	try { Thread.sleep(4000);} catch (InterruptedException e) {}
			    }
			    
		
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
			
				@FindBy(id="showAddLeaseModal")
				public WebElement LeasesContent_Add;
			
				// Add pop up 
				
				@FindBy(name="tenantName")
				public WebElement LeasesContent_AddPopUp_TanentName;
				
				@FindBy(css="#leaseForm > div.modal-body > div:nth-of-type(2) div:nth-of-type(1) i[class='fa fa-calendar']")
			    public WebElement LeasesContent_AddPopUp_StartDateIcon;
			    
				@FindBy(css="#leaseForm > div.modal-body > div:nth-of-type(2) div:nth-of-type(2) i[class='fa fa-calendar']")
			    public WebElement LeasesContent_AddPopUp_EndDateIcon;
			    
				@FindBy(css="#leaseForm > div.modal-body > div:nth-of-type(2) div:nth-of-type(3) i[class='fa fa-calendar']")
			    public WebElement LeasesContent_AddPopUp_MoveInDateIcon;
			    
				@FindBy(css="#leaseForm > div.modal-body > div:nth-of-type(2) div:nth-of-type(4) i[class='fa fa-calendar']")
			    public WebElement LeasesContent_AddPopUp_MoveOutDateIcon;
			    
				@FindBy(id="monthlyRent_currency")
			    public WebElement LeasesContent_AddPopUp_MonthlyRent;
				
				@FindBy(id="securityDeposit_currency")
			    public WebElement LeasesContent_AddPopUp_SecurityDeposite;
		
			    @FindBy(id="addLease")
			    public WebElement LeasesContent_AddPopUp_Save;
			    
			    
			    // Edit pop up
			    @FindBy(css="#editleaseForm [name='startDate']")
			    public WebElement LeasesContent_EditPopUp_StartDate;
			    
				@FindBy(css="#editleaseForm [name='endDate']")
			    public WebElement LeasesContent_EditPopUp_EndDate;
			    
				@FindBy(css="#editleaseForm [name='moveInDate']")
			    public WebElement LeasesContent_EditPopUp_MoveInDate;
			    
				@FindBy(css="#editleaseForm [name='moveOutDate']")
			    public WebElement LeasesContent_EditPopUp_MoveOutDate;
			    
				@FindBy(css="#editleaseForm [name='tenantName']")
				public WebElement LeasesContent_EditPopUp_TanentName;
				
				@FindBy(css="#editleaseForm #monthlyRent_currency")
			    public WebElement LeasesContent_EditPopUp_MonthlyRent;
				
				@FindBy(css="#editleaseForm #securityDeposit_currency")
			    public WebElement LeasesContent_EditPopUp_SecurityDeposite;
		
			    @FindBy(id="editLease")
			    public WebElement LeasesContent_EditPopUp_Save;
			    
			    // Table
			    public String LeasesContent_GetTableData(int row, int column)
			    {
			    	String cssSelector = "#leaseDataTableMain tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
			    	return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			    }
			    
			    // Edit
			    public void LeasesContent_Table_Edit(int row)
			    {
			    	String cssSelector = "#leaseDataTableMain tbody tr:nth-of-type(" + row + ") a.edit_blue";
			    	driver.findElement(By.cssSelector(cssSelector)).click();
			    	try { Thread.sleep(4000);} catch (InterruptedException e) {}
			    }
				
				
			
		// Expenses
			@FindBy(id="expenses")
			public WebElement ExpensesTab ;
			
			@FindBy(id="expensesTab")
			public WebElement ExpensesContent;
			
				@FindBy(id="showAddExpenseModal")
				public WebElement ExpensesContent_Add;
			
				// Add pop up 
				@FindBy(name="feeTypeId")
				public WebElement ExpensesContent_AddPopUp_FeeType;
				
					public void ExpensesContent_AddPopUp_SelectFeeType(String type)
					{
						new Select(ExpensesContent_AddPopUp_FeeType).selectByVisibleText(type);
					}
					
				@FindBy(name="freqTypeId")
				public WebElement ExpensesContent_AddPopUp_Frequency;
				
					public void ExpensesContent_AddPopUp_SelectFrequency(String type)
					{
						new Select(ExpensesContent_AddPopUp_Frequency).selectByVisibleText(type);
					}
					
					
				@FindBy(css="#expenseForm > div.modal-body > div:nth-of-type(2) div:nth-of-type(1) i[class='fa fa-calendar']")
			    public WebElement ExpensesContent_AddPopUp_LastPaymentDate;
				
				@FindBy(css="#expenseForm > div.modal-body > div:nth-of-type(2) div:nth-of-type(2) i[class='fa fa-calendar']")
			    public WebElement ExpensesContent_AddPopUp_NextDueDate;
			    
				@FindBy(id="expAmount_currency")
			    public WebElement ExpensesContent_AddPopUp_Amount;
				
				@FindBy(id="addExpense")
			    public WebElement ExpensesContent_AddPopUp_Save;
			    
			
			    // Edit pop up
				@FindBy(css="#editExpenseForm [name='feeTypeId']")
				public WebElement ExpensesContent_EditPopUp_FeeType;
				
					public void ExpensesContent_EditPopUp_SelectFeeType(String type)
					{
						new Select(ExpensesContent_EditPopUp_FeeType).selectByVisibleText(type);
					}
					
					public String ExpensesContent_EditPopUp_GetSelectedFeeType()
					{
						return new Select(ExpensesContent_EditPopUp_FeeType).getFirstSelectedOption().getText();
					}
					
					
				@FindBy(css="#editExpenseForm [name='freqTypeId']")
				public WebElement ExpensesContent_EditPopUp_Frequency;
				
					public void ExpensesContent_EditPopUp_SelectFrequency(String type)
					{
						new Select(ExpensesContent_EditPopUp_Frequency).selectByVisibleText(type);
					}
					
					public String ExpensesContent_EditPopUp_GetSelectedFrequency()
					{
						return new Select(ExpensesContent_EditPopUp_Frequency).getFirstSelectedOption().getText();
					}
					
					
				@FindBy(css ="#editExpenseForm [name='lastPaymentDate']")
			    public WebElement ExpensesContent_EditPopUp_LastPaymentDate;
				
				@FindBy(css="#editExpenseForm [name='nextDueDate']")
				public WebElement ExpensesContent_EditPopUp_NextDueDate;
			    
				@FindBy(css="#editExpenseForm #expAmount_currency")
			    public WebElement ExpensesContent_EditPopUp_Amount;
				
				@FindBy(id="editExpense")
			    public WebElement ExpensesContent_EditPopUp_Save;
				
			    
			    // Table
			    public String ExpensesContent_GetTableData(int row, int column)
			    {
			    	String cssSelector = "#expensesTab table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
			    	return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			    }
			    
			    // Edit
			    public void ExpensesContent_Table_Edit(int row)
			    {
			    	String cssSelector = "#expensesTab table tbody tr:nth-of-type(" + row + ") a.edit_blue";
			    	driver.findElement(By.cssSelector(cssSelector)).click();
			    	try { Thread.sleep(4000);} catch (InterruptedException e) {}
			    }
				
			
		// Messages
			@FindBy(id="messages")
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
			@FindBy(id="documents")
			public WebElement DocumentsTab ;
			
			@FindBy(id="documentsTab")
			public WebElement DocumentsContent;
			
				//Add new document
				@FindBy(css="#documentsTab i.fa-plus")
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
			@FindBy(id="contact")
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
			
		
}
