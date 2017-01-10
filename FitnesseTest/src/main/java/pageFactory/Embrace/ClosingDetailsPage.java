package pageFactory.Embrace;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class ClosingDetailsPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public ClosingDetailsPage(WebDriver driver)
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
	
		@FindBy(id="closingSteps")
	    public WebElement ClosingStepsTab;
		
			@FindBy(id="closingStepsTab")
			public WebElement ClosingStepsContent;
		
		@FindBy(id="closingContact")
	    public WebElement ContactsTab;
		
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
				
		
		@FindBy(id="closingDocuments")
	    public WebElement DocumentsTab;
			
			@FindBy(id="closingDocumentsTab")
			public WebElement DocumentsContent;
			
				//Add new document
				@FindBy(css="#closingDocumentsTab i.fa-plus")
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
				
		
		@FindBy(id="closingMessages")
	    public WebElement MessagesTab;
		
			@FindBy(id="closingMessagesTab")
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
			
			
		@FindBy(css="#closingCompletionStatusDiv div:nth-child(2)")
	    public WebElement CompletionPercentageText;
		
		@FindBy(css="#closing-summary-view > div > div:nth-child(2) > div:nth-child(1) > a")
	    public WebElement Investorname;
		
		@FindBy(css="#closingHeader h3 a")
	    public WebElement Propertyname;
		
		@FindBy(css="#closing-summary-view div div:nth-of-type(4) div:nth-of-type(2)")
	    public WebElement PurchasePrice;
		
		@FindBy(css="#closing-summary-view > div > div:nth-child(3) > div:nth-child(3)")
	    public WebElement FinancingType;
		
		@FindBy(css=".marg_top0.margin-bottom-10>a")
		
	    public WebElement Address;
		
		
		//Setting up Insurance Vendor
			
			@FindBy(css="a[href='#collapseOne']")
		    public WebElement MoreDetails;
			
			@FindBy(id="showInsuranceVendorModal")
		    public WebElement InsuranceVendorEdit;
			
			@FindBy(id="insuranceVendorDropdown")
		    public WebElement InsuranceVendorEdit_Dropdown;
			
			@FindBy(id="saveInsuranceVendor")
		    public WebElement InsuranceVendorEdit_Save;
			
			public void SetInsuranceVendor(String vendorname) throws InterruptedException
			{
				MoreDetails.click();
				Thread.sleep(1000);
				InsuranceVendorEdit.click();
				Thread.sleep(3000);
				new Select(InsuranceVendorEdit_Dropdown).selectByVisibleText(vendorname);
				Thread.sleep(1000);
				InsuranceVendorEdit_Save.click();
				Thread.sleep(5000);
			}
			
			
			
		// 'Show ALL' or 'SHOW OPEN'
			
			@FindBy(id="showOpenClosingToggleButton")
		    public WebElement Closing_SHOW_ALL_OPEN;
		
		//Closing Steps
		
			//Click on given Step
			public void ClickOnStep(int i)
			{	
				String cssSelector = "#closingStepsTable  tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) a";
				driver.findElement(By.cssSelector(cssSelector)).click();
				try {Thread.sleep(4500/*7000*/);} catch (InterruptedException e) {}	//TIME 1
			}
			
			
			//Verify whether Task pop up is closed or not
			public void WaitTillTaskPopUpClosed(WebElement taskDivElement)
			{
				try 
				{
					for(int i=0;i<200;i++)
					{
						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
						if(taskDivElement.getAttribute("aria-hidden").equals("true"))
						{
							// Pop up is closed now. and waiting for 5 secs. 
							Thread.sleep(5000);
							break;
						}
						
						//System.out.println("    Attempt = " + (i+1));
					}
				}
				catch(Exception e)
				{
					
					// Pop up is closed now. and waiting for 5 secs. 
					//System.out.println("    Exception thrown ");
					try { Thread.sleep(5000);} catch (InterruptedException e1) { }
				}
				
				driver.manage().timeouts().implicitlyWait(Constants.WebDriverWaitDuration, TimeUnit.SECONDS);
				
			}
			
			
			//Get Table data for given Step
			public String GetTableDataForGivenStep(int i, int column)
			{	
				String cssSelector = "#closingStepsTable  tbody tr:nth-of-type(" + i + ") td:nth-of-type(" + column + ")";
				String data;
				try{
					 data  = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				} catch (Exception e) { data  = driver.findElement(By.cssSelector(cssSelector)).getText().trim();}
				
				return data;
				
			}
			
			//Click on Attachement icon and get attachments names
			public String ClickOnAttachmentIconAndGetAttachmentsNames(int i, int no) throws InterruptedException
			{	
				String cssSelector = "#closingStepsTable  tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) a.fa-paperclip";
				driver.findElement(By.cssSelector(cssSelector)).click();
				Thread.sleep(2000);
				
				String attachmentnames = "";
				for(int j=2; j<=no+1;j++)
				{
					cssSelector = "#closingStepsTable  tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) div table tr:nth-of-type(" + j + ") td:nth-of-type(1)";
					attachmentnames = attachmentnames + driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				}
				
				//Closing attachment flyout
				cssSelector = "#closingStepsTable  tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) div table div.popover-close";
				driver.findElement(By.cssSelector(cssSelector)).click();
				
				return attachmentnames;		
				
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
			
			
	
			
			
			@FindBy(css="a[href='#completeClosing']")
		    public WebElement ClosingCompleted;
			
			
			//Confirmaton Box
				//Text
				@FindBy(css="#completeClosing div.modal-body")
				public WebElement Alert_Text;
				
				//Warning box , Click Yes
				@FindBy(id="completeClosingButton")
				public WebElement Warning_Accept;
			
			
			
			//Step 1 - Property Rental Status
				
				@FindBy(id="PROPERTY_RENTAL_STATUS_POPUP_1")
			    public WebElement Step_PropertyRentalStatus_Div;
				
				@FindBy(css="#PROPERTY_RENTAL_STATUS_POPUP_1 div.modal-content h4'")
			    public WebElement Step_PropertyRentalStatus_Header;
				
				@FindBy(css="#PROPERTY_RENTAL_STATUS_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_PropertyRentalStatus_CalenderIcon;
				
				@FindBy(css="td[class='day active']")
			    public WebElement Calender_Active_Date;
				
				@FindBy(css="#UPLOAD_RENTAL_AGREEMENT_POPUP_1 div.modal-content input[id='document']")
				public WebElement Step_RentalAgreement_UploadRentalAgreement;
				
				public void Step_PropertyRentalStatus_SelectDate()
				{
					Step_PropertyRentalStatus_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}	
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				// Status
					
					@FindBy(css="#uniform-optionsRadiosvacant")
				    public WebElement Step_PropertyRentalStatus_Status_Vacant;
					
					@FindBy(css="#uniform-optionsRadiosownerOccupied")
				    public WebElement Step_PropertyRentalStatus_Status_OwnerOccupied;
					
					@FindBy(css="#uniform-optionsRadiostenantOccupied")
				    public WebElement Step_PropertyRentalStatus_Status_TenantOccupied;
					
						@FindBy(css="div#leaseActive #uniform-optionsRadiosyes")
					    public WebElement Step_PropertyRentalStatus_Lease_InEffect_Yes;
						
						@FindBy(css="div#leaseActive #uniform-optionsRadiosno")
					    public WebElement Step_PropertyRentalStatus_Lease_InEffect_No;
						
				
				@FindBy(css="#PROPERTY_RENTAL_STATUS_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_PropertyRentalStatus_Comments;
				
				@FindBy(xpath="//div[@id='rental_tab_1']//button[.='Save']")
			    public WebElement Step_RentalAgreement_SaveButton;
				
				@FindBy(id="rentalStatusPopupSubmitButton")
			    public WebElement Step_PropertyRentalStatus_Save;
				
			
			//Step 2 - Earnest Money Deposit
				
				@FindBy(id="MILESTONE_POPUP_WITH_DOC_1'")
			    public WebElement Step_EarnestMoneyDeposit_Div;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 div.modal-content h4'")
			    public WebElement Step_EarnestMoneyDeposit_Header;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_EarnestMoneyDeposit_CalenderIcon;
				
				public void Step_EarnestMoneyDeposit_SelectDate()
				{
					Step_EarnestMoneyDeposit_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_EarnestMoneyDeposit_Comments;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 div.modal-content input[id='document']")
			    public WebElement Step_EarnestMoneyDeposit_EMDImage;
				
				@FindBy(id="isDisplayToInvestorMessage")
			    public WebElement Step_EarnestMoneyDeposit_DisplayToInvestor;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 button#milestonePopupSubmitButton")
			    public WebElement Step_EarnestMoneyDeposit_Save;
				
				
			//Step 3 - Introductory Emails
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_IntroductoryEmails_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_IntroductoryEmails_Header;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_IntroductoryEmails_CalenderIcon;
				
				public void Step_IntroductoryEmails_SelectDate()
				{
					Step_IntroductoryEmails_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_IntroductoryEmails_Comments;
				
				@FindBy(id="milestonePopupSubmitButton")
			    public WebElement Step_IntroductoryEmails_Save;	
				
			
				
			//Step 4 - Pre-Inspection Appointment
				
				@FindBy(id="DEFAULT_POPUP_1")
			    public WebElement Step_PreInspectionAppointment_Div;
				
				@FindBy(css="#DEFAULT_POPUP_1 div.modal-content h4'")
			    public WebElement Step_PreInspectionAppointment_Header;
				
				@FindBy(css="#DEFAULT_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_PreInspectionAppointment_StartDateCalenderIcon;
				
				@FindBy(css="#DEFAULT_POPUP_1 div.modal-content form div:nth-of-type(2) i[class='fa fa-calendar']")
			    public WebElement Step_PreInspectionAppointment_CompletionDateCalenderIcon;
				
				public void Step_PreInspectionAppointment_SelectStartDate()
				{
					Step_PreInspectionAppointment_StartDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_PreInspectionAppointment_CompletionStartDate()
				{
					Step_PreInspectionAppointment_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#DEFAULT_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_PreInspectionAppointment_Comments;
				
				@FindBy(css="#DEFAULT_POPUP_1 div.modal-footer #defaultPopupSubmitButton")
			    public WebElement Step_PreInspectionAppointment_Save;	
						
			
			//Step 5 - Inspection Options
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_InspectionOptions_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_InspectionOptions_Header;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content form div:nth-of-type(1) i[class='fa fa-calendar']")
			    public WebElement Step_InspectionOptions_CompletionDateCalenderIcon;
				
				public void Step_InspectionOptions_CompletionStartDate()
				{
					Step_InspectionOptions_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_InspectionOptions_Comments;
				
				@FindBy(id="milestonePopupSubmitButton")
			    public WebElement Step_InspectionOptions_Save;
				
				
			//Step 6 - HU to Provide Insurance
				
				@FindBy(id="HU_TO_PROVIDE_INSURANCE_POPUP_1'")
			    public WebElement Step_HUProvideInsurance_Div;
				
				@FindBy(css="#HU_TO_PROVIDE_INSURANCE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_HUProvideInsurance_Header;
				
				@FindBy(css="#HU_TO_PROVIDE_INSURANCE_POPUP_1 div.modal-content form div:nth-of-type(1) i[class='fa fa-calendar']")
			    public WebElement Step_HUProvideInsurance_CompletionDateCalenderIcon;
				
				public void Step_HUProvideInsurance_CompletionStartDate()
				{
					Step_HUProvideInsurance_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				// HU to Provide Insurance?
				
					@FindBy(css="#HU_TO_PROVIDE_INSURANCE_POPUP_1 #uniform-optionsRadiosyes")
				    public WebElement Step_HUProvideInsuranceHUProvideInsuranceYes;
				
					@FindBy(css="#HU_TO_PROVIDE_INSURANCE_POPUP_1 #uniform-optionsRadiosno")
				    public WebElement Step_HUProvideInsuranceHUProvideInsuranceNo;
				
				@FindBy(css="#HU_TO_PROVIDE_INSURANCE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_HUProvideInsurance_Comments;
				
				@FindBy(id="huToProvideInsurancePopupSubmitButton")
			    public WebElement Step_HUProvideInsurance_Save;	
		
				
			//Step 7 - Property Appraisal Required
				
				@FindBy(id="APPRAISAL_REQUIRED_POPUP_1")
			    public WebElement Step_PropertyAppraisalRequired_Div;
				
				@FindBy(css="#APPRAISAL_REQUIRED_POPUP_1 div.modal-content h4'")
			    public WebElement Step_PropertyAppraisalRequired_Header;
				
				@FindBy(css="#APPRAISAL_REQUIRED_POPUP_1 div.modal-content form div:nth-of-type(1) i[class='fa fa-calendar']")
			    public WebElement Step_PropertyAppraisalRequired_CompletionDateCalenderIcon;
				
				public void Step_PropertyAppraisalRequired_CompletionStartDate()
				{
					Step_PropertyAppraisalRequired_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				// Appraisal
					@FindBy(id="uniform-optionsRadiosyes")
				    public WebElement Step_PropertyAppraisalRequired_Appraisal_Yes;
					
					@FindBy(id="uniform-optionsRadiosno")
				    public WebElement Step_PropertyAppraisalRequired_Appraisal_No;
				
				@FindBy(css="#APPRAISAL_REQUIRED_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_PropertyAppraisalRequired_Comments;
				
				@FindBy(css="#APPRAISAL_REQUIRED_POPUP_1 button#appraisalRequiredPopupSubmitButton")
			    public WebElement Step_PropertyAppraisalRequired_Save;	
				
				
				//Step - Property Appraisal
				
				@FindBy(id="APPRAISAL_POPUP_1")
			    public WebElement Step_PropertyAppraisal_Div;
				
				@FindBy(css="#APPRAISAL_POPUP_1 div.modal-content h4'")
			    public WebElement Step_PropertyAppraisal_Header;
				
				@FindBy(xpath="//form[@id='propertyAppraisalForm']/div[1]/div[1]/div/div/input")
			    public WebElement Step_PropertyAppraisal_StartDateCalenderIcon;
				
				@FindBy(xpath="//form[@id='propertyAppraisalForm']/div[1]/div[2]/div/div/input")
			    public WebElement Step_PropertyAppraisal_CompletionDateCalenderIcon;
				
				public void Step_PropertyAppraisal_StartDate()
				{
					Step_PropertyAppraisal_StartDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_PropertyAppraisal_CompletionDate()
				{
					Step_PropertyAppraisal_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(xpath="//form[@id='propertyAppraisalForm']/div[4]/div[1]/div/input")
			    public WebElement Step_Property_Appraisal_doc;
				
				@FindBy(css="#APPRAISAL_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_PropertyAppraisal_Comments;
				
				@FindBy(id="propertyAppraisalFormPopupSubmitButton")
			    public WebElement Step_PropertyAppraisal_Save;	
				
				//Step - UW Final Approval
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_UWFinalApproval_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_UWFinalApproval_Header;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_UWFinalApproval_CalenderIcon;
				
				public void Step_UWFinalApproval_SelectDate()
				{
					Step_UWFinalApproval_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_UWFinalApproval_Comments;
				
				@FindBy(id="milestonePopupSubmitButton")
			    public WebElement Step_UWFinalApproval_Save;	
				
				//Step 8 - Pre-Inspection Report
				
				@FindBy(id="REHAB_ESTIMATE_POPUP_1")
			    public WebElement Step_PreInspectionReport_Div;
				
				@FindBy(css="#REHAB_ESTIMATE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_PreInspectionReport_Header;
				
				@FindBy(css="input[name='item']")
			    public WebElement Step_PreInspectionReport_RehabItemName;
				
				@FindBy(id="cost_currency")
			    public WebElement Step_PreInspectionReport_RehabItemCost;
				
				@FindBy(css="#provideRehabEstimateForm div.table-responsive table:nth-of-type(2) tr:nth-of-type(2) i[class='fa fa-calendar']")
			    public WebElement Step_PreInspectionReport_CompletionDateCalenderIcon;
				

				@FindBy(css="#provideRehabEstimateForm i[class='fa fa-calendar']")
			    public WebElement Step_PreInspectionReport_StartDateCalenderIcon;
				
				
				public void Step_PreInspectionReport_CompletionStartDate()
				{
					Step_PreInspectionReport_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_PreInspectionReport_SelectStartDate()
				{
					Step_PreInspectionReport_StartDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="table[class='table table-hover'] input#document")
			    public WebElement Step_PreInspectionReport_Document;
				
				@FindBy(css="#REHAB_ESTIMATE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_PreInspectionReport_Comments;
				
				@FindBy(id="provideRehabEstimateButton")
			    public WebElement Step_PreInspectionReport_Save;	
				
				
			//Step 9 - Property Inspection Appointment
				
				@FindBy(id="INSPECTION_APPOINTMENT_POPUP_1")
			    public WebElement Step_PropertyInspectionAppointment_Div;
				
				@FindBy(css="#INSPECTION_APPOINTMENT_POPUP_1 div.modal-content h4'")
			    public WebElement Step_PropertyInspectionAppointment_Header;
				
				@FindBy(css="#INSPECTION_APPOINTMENT_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_PropertyInspectionAppointment_StartDateCalenderIcon;
				
				@FindBy(css="#INSPECTION_APPOINTMENT_POPUP_1 div.modal-content form div:nth-of-type(2) i[class='fa fa-calendar']")
			    public WebElement Step_PropertyInspectionAppointment_CompletionDateCalenderIcon;
				
				public void Step_PropertyInspectionAppointment_SelectStartDate()
				{
					Step_PropertyInspectionAppointment_StartDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_PropertyInspectionAppointment_CompletionStartDate()
				{
					Step_PropertyInspectionAppointment_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#INSPECTION_APPOINTMENT_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_PropertyInspectionAppointment_Comments;
				
				@FindBy(css="#INSPECTION_APPOINTMENT_POPUP_1 div.modal-footer #defaultPopupSubmitButton")
			    public WebElement Step_PropertyInspectionAppointment_Save;	
						
				
			//Step 10 - Insurance Declaration
				
				@FindBy(id="MILESTONE_POPUP_WITH_DOC_1")
			    public WebElement Step_InsuranceDeclaration_Div;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 div.modal-content h4'")
			    public WebElement Step_InsuranceDeclaration_Header;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_InsuranceDeclaration_CalenderIcon;
				
				public void Step_InsuranceDeclaration_SelectDate()
				{
					Step_InsuranceDeclaration_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_InsuranceDeclaration_Comments;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 div.modal-content input[id='document']")
			    public WebElement Step_InsuranceDeclaration_Document;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 div.modal-footer #milestonePopupSubmitButton")
			    public WebElement Step_InsuranceDeclaration_Save;
				
				
			//Step 11 - Asset Management Agreement
				
				@FindBy(id="ASSET_MGMT_AGREEMENT_POPUP_1")
			    public WebElement Step_AssetManagementAgreement_Div;
				
				@FindBy(css="#ASSET_MGMT_AGREEMENT_POPUP_1 div.modal-content h4'")
			    public WebElement Step_AssetManagementAgreement_Header;
				
				@FindBy(css="#ASSET_MGMT_AGREEMENT_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_AssetManagementAgreement_StartDateCalenderIcon;
				
				@FindBy(css="#ASSET_MGMT_AGREEMENT_POPUP_1 div.modal-content form div:nth-of-type(2) i[class='fa fa-calendar']")
			    public WebElement Step_AssetManagementAgreement_CompletionDateCalenderIcon;
				
				public void Step_AssetManagementAgreement_SelectStartDate()
				{
					Step_AssetManagementAgreement_StartDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_AssetManagementAgreement_CompletionStartDate()
				{
					Step_AssetManagementAgreement_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#ASSET_MGMT_AGREEMENT_POPUP_1 div.modal-content input[id='document']")
			    public WebElement Step_AssetManagementAgreement_Document;
				
				@FindBy(css="#ASSET_MGMT_AGREEMENT_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_AssetManagementAgreement_Comments;
				
				@FindBy(id="assetMgmtAgreementPopupSubmitButton")
			    public WebElement Step_AssetManagementAgreement_Save;
				
				
			//Step 12 - Property Inspection
				@FindBy(css="#INSPECTION_POPUP_1 div.modal-content h4'")
			    public WebElement Step_PropertyInspection_Header;
				
				@FindBy(id="INSPECTION_POPUP_1")
			    public WebElement Step_PropertyInspection_Div;
				
				@FindBy(css="#INSPECTION_POPUP_1 #inspectionFee_currency")
			    public WebElement Step_PropertyInspection_InspectionFee;
				
				@FindBy(css="#INSPECTION_POPUP_1 #utilitiesActivationFee_currency")
			    public WebElement Step_PropertyInspection_ActivationFee;
				
				//Repairs Required ?
					@FindBy(css="#INSPECTION_POPUP_1 #uniform-optionsRadiosyes")
				    public WebElement Step_PropertyInspection_RepairsRequired_Yes;
					
					@FindBy(css="#INSPECTION_POPUP_1 #uniform-optionsRadiosno")
				    public WebElement Step_PropertyInspection_RepairsRequired_No;
				

				
				@FindBy(xpath="//form[@id='propertyInspectionForm']/div[2]/div[1]/div/div/input")
				public WebElement Step_PropertyInspection_StartDateCalenderIcon;

				
				@FindBy(css="#INSPECTION_POPUP_1 #propertyInspectionForm > div:nth-child(5) div:nth-of-type(2) i[class='fa fa-calendar']")
			    public WebElement Step_PropertyInspection_CompletionDateCalenderIcon;
				
				public void Step_PropertyInspection_SelectStartDate()
				{
					Step_PropertyInspection_StartDateCalenderIcon.click();
					try {Thread.sleep(4000);} catch (InterruptedException e) {
						Step_PropertyInspection_StartDateCalenderIcon.click();
					}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(4000);} catch (InterruptedException e) {
						ClickOnCurrentDate();
					}
				}
				
				public void Step_PropertyInspection_CompletionStartDate()
				{
					Step_PropertyInspection_CompletionDateCalenderIcon.click();
					try {Thread.sleep(4000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#INSPECTION_POPUP_1 div.modal-content input[name='document']")
			    public WebElement Step_PropertyInspection_Document;
				
				@FindBy(css="#INSPECTION_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_PropertyInspection_Comments;
				
				@FindBy(id="propertyInspectionPopupSubmitButton")
			    public WebElement Step_PropertyInspection_Save;	
				
				
			//Step 13 - Property Inspection Review
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_PropertyInspectionReview_Header;
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_PropertyInspectionReview_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_PropertyInspectionReview_CalenderIcon;
				
				public void Step_PropertyInspectionReview_SelectDate()
				{
					Step_PropertyInspectionReview_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_PropertyInspectionReview_Comments;
				
				@FindBy(id="milestonePopupSubmitButton")
			    public WebElement Step_PropertyInspectionReview_Save;
				
				
			//Step 14 - Preliminary HUD Review
				
				@FindBy(id="PRELIMINARY_HUD_POPUP_1")
			    public WebElement Step_PreliminaryHUDReview_Div;
				
				@FindBy(css="#PRELIMINARY_HUD_POPUP_1 div.modal-content h4'")
			    public WebElement Step_PreliminaryHUDReview_Header;
				
				//@FindBy(css="#PRELIMINARY_HUD_POPUP_1 div.modal-content i[class='fa fa-calendar']")
				@FindBy(xpath="//form[@id='PreliminaryHudReviewForm']//button[normalize-space(.)='']")
			    public WebElement Step_PreliminaryHUDReview_StartDateCalenderIcon;
				
				@FindBy(css="#PRELIMINARY_HUD_POPUP_1 #endDate")
				//@FindBy(xpath="//form[@id='PreliminaryHudReviewForm']/div[7]")
			    public WebElement Step_PreliminaryHUDReview_CompletionDateCalenderIcon;
				
				@FindBy(css="form#PreliminaryHudReviewForm div:nth-of-type(14) div.form-group i[class='fa fa-calendar']")
			    public WebElement Step_PreliminaryHUDReview_SettlementDateCalenderIcon;
				
				public void Step_PreliminaryHUDReview_SelectStartDate()
				{
					Step_PreliminaryHUDReview_StartDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_PreliminaryHUDReview_CompletionStartDate()
				{
					Step_PreliminaryHUDReview_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_PreliminaryHUDReview_SettlementStartDate()
				{
					//Step_PreliminaryHUDReview_SettlementDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#PRELIMINARY_HUD_POPUP_1 div.modal-content input[name='document']")
			    public WebElement Step_PreliminaryHUDReview_Document;
				
				@FindBy(css="#PRELIMINARY_HUD_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_PreliminaryHUDReview_Comments;
				
				@FindBy(xpath="//button[@id='preliminaryHudPopupSubmitButton']")
			    public WebElement Step_PreliminaryHUDReview_Save;	
				
				
			//Step 15 - Docs Signed
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_DocsSigned_Header;
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_DocsSigned_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_DocsSigned_CalenderIcon;
				
				public void Step_DocsSigned_SelectDate()
				{
					Step_DocsSigned_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_DocsSigned_Comments;
				
				@FindBy(css="#MILESTONE_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_DocsSigned_Save;
				
				//Step  - Loan Funded
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_LoanFunded_Header;
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_LoanFunded_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_LoanFunded_CalenderIcon;
				
				public void Step_LoanFunded_SelectDate()
				{
					Step_DocsSigned_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_LoanFunded_Comments;
				
				@FindBy(css="#MILESTONE_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_LoanFunded_Save;
				
				
			//Step 16 - Final Funds
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_FinalFunds_Header;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_FinalFunds_CalenderIcon;
				
				public void Step_FinalFunds_SelectDate() throws InterruptedException
				{
					Step_FinalFunds_CalenderIcon.click();
					Thread.sleep(2000);
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					Thread.sleep(2000);
				}
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_FinalFunds_Comments;
				
				@FindBy(id="#MILESTONE_POPUP_1 milestonePopupSubmitButton")
			    public WebElement Step_FinalFunds_Save;
				
				
			//Step 17 - Final HUD
				@FindBy(css="#FINAL_HUD_POPUP_1 div.modal-content h4'")
			    public WebElement Step_FinalHUD_Header;
				
				@FindBy(id="FINAL_HUD_POPUP_1")
			    public WebElement Step_FinalHUD_Div;
				
				@FindBy(css="form.final-hud-form > div div:nth-of-type(8) i[class='fa fa-calendar']")
			    public WebElement Step_FinalHUD_CompletionDateCalenderIcon;
			
				public void Step_FinalHUD_CompletionStartDate()
				{
					Step_FinalHUD_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(id="rehabCost_currency")
			    public WebElement Step_FinalHUD_RehabCost;
				
				@FindBy(id="homeUnionCommission_currency")
			    public WebElement Step_FinalHUD_Commission;
				
				@FindBy(css="#FINAL_HUD_POPUP_1 div.modal-content input[name='finalHudDocument']")
			    public WebElement Step_FinalHUD_UploadFinalHUD;
				
				@FindBy(css="#FINAL_HUD_POPUP_1 div.modal-content input[name='mortgageNote']")
			    public WebElement Step_FinalHUD_UploadMortgageNote;
				
				@FindBy(css="#FINAL_HUD_POPUP_1 div.modal-content input[name='titleDocument']")
			    public WebElement Step_FinalHUD_UploadTitle;
				
				@FindBy(css="#FINAL_HUD_POPUP_1 div.modal-content input[name='taxCertificateDocument']")
			    public WebElement Step_FinalHUD_UploadTaxCertificate;
				
				@FindBy(css="#FINAL_HUD_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_FinalHUD_Comments;
				
				@FindBy(css="#FINAL_HUD_POPUP_1 #finalHudPopupSubmitButton")
			    public WebElement Step_FinalHUD_Save;		
			
				
			//Step 18 - Property Rehab
				@FindBy(css="#DEFAULT_POPUP_1 div.modal-content h4'")
			    public WebElement Step_PropertyRehab_Header;
				
				@FindBy(id="DEFAULT_POPUP_1")
			    public WebElement Step_PropertyRehab_Div;
				
				@FindBy(css="#DEFAULT_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_PropertyRehab_StartDateCalenderIcon;
				
				@FindBy(css="#DEFAULT_POPUP_1 form div:nth-of-type(2) i[class='fa fa-calendar']")
			    public WebElement Step_PropertyRehab_CompletionDateCalenderIcon;
				
				public void Step_PropertyRehab_SelectStartDate()
				{
					Step_PropertyRehab_StartDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_PropertyRehab_CompletionStartDate()
				{
					Step_PropertyRehab_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#DEFAULT_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_PropertyRehab_Comments;
				
				@FindBy(css="#DEFAULT_POPUP_1 button#defaultPopupSubmitButton")
			    public WebElement Step_PropertyRehab_Save;	
				
		
			//Step 19 - Insurance Quotes Review
				
				// Get field value for given Quote
				public String Step_InsuranceQuotesReview_Quote_GetValue(int quoteno, int fieldindex)
				{
					String cssSelector = "div#renderInsuranceReviewData tr#insuranceReviewRow td:nth-of-type(" + (quoteno+1) + ") tr:nth-of-type(" + fieldindex + ") td";
					return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				}
				
				// Get vendor comments for given quote
				public String Step_InsuranceQuotesReview_Quote_GetVendorComments(int quoteno, int fieldindex)
				{
					String cssSelector = "div#renderInsuranceReviewData tr#insuranceReviewRow td:nth-of-type(" + (quoteno+1) + ") tr:nth-of-type(" + fieldindex + ") td div";
					return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				}
				
				// Enter HU Comments for given Quote
				public void Step_InsuranceQuotesReview_Quote_EnterHUComments(int quoteno, String text)
				{
					String cssSelector = "div#renderInsuranceReviewData tr#insuranceReviewRow td:nth-of-type(" + (quoteno+1) + ") [name='msg']";
					driver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
				}
				
				@FindBy(css="#INSURANCE_QUOTES_REVIEW_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_InsuranceQuotesReview_Quote_CompletionDateCalenderIcon;
				
				public void Step_InsuranceQuotesReview_Quote_CompletionDate() throws InterruptedException
				{
					Step_InsuranceQuotesReview_Quote_CompletionDateCalenderIcon.click();
					Thread.sleep(2000);
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					Thread.sleep(2000);
				}
				
				@FindBy(id="insuranceReviewPopupSubmitButton")
			    public WebElement Step_InsuranceQuotesReview_Quote_Save;	
				
				
				
			//Step 20 - Insurance Vendor Selection
				
				// Get field value for given Quote
				public String Step_InsuranceVendorSelection_GetValue(int quoteno, int fieldindex)
				{
					String cssSelector = "div#renderVendorSelectionData tr#insuranceReviewRow td:nth-of-type(" + (quoteno+1) + ") tr:nth-of-type(" + fieldindex + ") td";
					return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				}
				
				// Get vendor comments for given quote
				public String Step_InsuranceVendorSelection_GetVendorComments(int quoteno, int fieldindex)
				{
					String cssSelector = "div#renderVendorSelectionData tr#insuranceReviewRow td:nth-of-type(" + (quoteno+1) + ") tr:nth-of-type(" + fieldindex + ") td div";
					return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				}
				
				
				// Select Quote for given Quote
				public void Step_InsuranceVendorSelection_SelectQuote(int quoteno)
				{
					String cssSelector = "div#renderVendorSelectionData tr#insuranceReviewRow td:nth-of-type(" + (quoteno+1) + ") div.radio";
					driver.findElement(By.cssSelector(cssSelector)).click();
				}
				
				@FindBy(css="#INSURANCE_VENDOR_SELECTION_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_InsuranceVendorSelection_CompletionDateCalenderIcon;
				
				public void Step_InsuranceVendorSelection_CompletionDate() throws InterruptedException
				{
					Step_InsuranceVendorSelection_CompletionDateCalenderIcon.click();
					Thread.sleep(2000);
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					Thread.sleep(2000);
				}
				
				@FindBy(id="insuranceVendorSelectionPopupSubmitButton")
			    public WebElement Step_InsuranceVendorSelection_Save;	
			
				
			//Step 21 - Insurance Application
				
				//Get data for given field from Quote info
				public String Step_InsuranceApplication_GetFieldData(int row,int index)
				{
					String cssSelector = "div.form-body div:nth-of-type(" + (row) + ") > div:nth-of-type(" + index + ") p.form-control-static";
					return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				}
				
				@FindBy(name="insuranceCertificateDocs")
			    public WebElement Step_InsuranceApplication_CertificateOfIssuance;	
				
				@FindBy(name="insuranceEvidenceDocs")
			    public WebElement Step_InsuranceApplication_EvidenceOfInsurance;	
				
				@FindBy(name="insuranceDeclarationDocs")
			    public WebElement Step_InsuranceApplication_InsuranceDeclaration;	
				
				@FindBy(name="insuranceApplicationDocs")
			    public WebElement Step_InsuranceApplication_InsuranceApplication;	
				
				@FindBy(name="insuranceInvoiceDocs")
			    public WebElement Step_InsuranceApplication_Invoice;	
				
				@FindBy(css="#INSURANCE_APPLICATION_POPUP_1_FORM  textarea[name='comments']")
			    public WebElement Step_InsuranceApplication_Comments;	
				
				@FindBy(id="insuranceAppSubmitButton")
			    public WebElement Step_InsuranceApplication_Save;	
				
			
			//Step 22 - Insurance Application Signature
				
				//Get data for given field from Quote info
				public String Step_InsuranceApplicationSignature_GetFieldData(int row,int index)
				{
					String cssSelector = "div.form-body div:nth-of-type(" + (row) + ") > div:nth-of-type(" + index + ") p.form-control-static";
					return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				}
				
				//Docusign Envelope section
				
					@FindBy(css="div.docusignEnvelopeArea button")
				    public WebElement Step_InsuranceApplicationSignature_UploadForInvestorSignature;
					
					@FindBy(css="div.docusignEnvelopeArea td:nth-of-type(1) span")
				    public WebElement Step_InsuranceApplicationSignature_DocusignEnvelope_Status;
					
					@FindBy(css="div.docusignEnvelopeArea td:nth-of-type(1) button")
				    public WebElement Step_InsuranceApplicationSignature_DocusignEnvelope_Refresh;
					
					@FindBy(css="div.docusignEnvelopeArea td:nth-of-type(2) button")
				    public WebElement Step_InsuranceApplicationSignature_DocusignEnvelope_TagAndSend;
					
					
				
				// Tag and Send Documents for Signature
					
					@FindBy(css="iframe.cboxIframe")
				    public WebElement Step_InsuranceApplicationSignature_TagAndSend_iFrame;
					
					@FindBy(css="#ds_hldrBdy_tabSign img")
				    public WebElement Step_InsuranceApplicationSignature_TagAndSend_Signature;
					
					@FindBy(css="#ds_hldrBdy_holderPage div:nth-of-type(5) img")
				    public WebElement Step_InsuranceApplicationSignature_TagAndSend_MainArea;
					
					@FindBy(id="ds_hldrBdy_btnSendIt_btnInline")
				    public WebElement Step_InsuranceApplicationSignature_TagAndSend_Send;
					
					@FindBy(id="cboxClose")
				    public WebElement Step_InsuranceApplicationSignature_TagAndSend_Close;
					
					
					
				
				@FindBy(css="#INSURANCE_APPLICATION_SIGNATURE_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_InsuranceApplicationSignature_CompletionDateCalenderIcon;
				
				public void Step_InsuranceApplicationSignature_CompletionDate() throws InterruptedException
				{
					Step_InsuranceApplicationSignature_CompletionDateCalenderIcon.click();
					Thread.sleep(2000);
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					Thread.sleep(2000);
				}
				
				@FindBy(css="#INSURANCE_APPLICATION_SIGNATURE_POPUP_1  textarea[name='comments']")
			    public WebElement Step_InsuranceApplicationSignature_Comments;	
				
				@FindBy(id="insuranceAppSignaturePopupSubmitButton")
			    public WebElement Step_InsuranceApplicationSignature_Save;	
				
				
			//Step 23 - Insurance Application Signed
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 i[class='fa fa-calendar']")
			    public WebElement Step_InsuranceApplicationSigned_CompletionDateCalenderIcon;
				
				public void Step_InsuranceApplicationSigned_CompletionDate() throws InterruptedException
				{
					Step_InsuranceApplicationSigned_CompletionDateCalenderIcon.click();
					Thread.sleep(2000);
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					Thread.sleep(2000);
				}
				
				@FindBy(css="div#MILESTONE_POPUP_WITH_DOC_1 #document")
			    public WebElement Step_InsuranceApplicationSigned_UploadInsuranceApplication  ;	
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1  textarea[name='comments']")
			    public WebElement Step_InsuranceApplicationSigned_Comments;	
				
				@FindBy(css="div#MILESTONE_POPUP_WITH_DOC_1 #milestonePopupSubmitButton")
			    public WebElement Step_InsuranceApplicationSigned_Save;	
					
				
			//Step 23 - Upload Binder
				
				@FindBy(name="insuranceCertificateDocs")
			    public WebElement Step_UploadBinder_CertificateOfIssuance ;	
				
				@FindBy(name="insuranceEvidenceDocs")
			    public WebElement Step_UploadBinder_EvidenceOfInsurance  ;	
				
				@FindBy(name="insuranceDeclarationDocs")
			    public WebElement Step_UploadBinder_InsuranceDeclaration;	
				
				@FindBy(name="insuranceInvoiceDocs")
			    public WebElement Step_UploadBinder_Invoice;	
				
				@FindBy(css="#INSURANCE_PROVIDED_POPUP_1_FORM  textarea[name='comments']")
			    public WebElement Step_UploadBinder_Comments;	
				
				@FindBy(id="insuranceBinderSubmitButton")
			    public WebElement Step_UploadBinder_Save;	
				
			
			//Step 24 - Seller Disclosure
				
				@FindBy(id="SELLER_DISCLOSURE_POPUP_1")
			    public WebElement Step_SellerDisclosure_Div;
				
				@FindBy(css="#SELLER_DISCLOSURE_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_SellerDisclosure_CompletionDateCalenderIcon;
				
				public void Step_SellerDisclosure_CompletionDate()
				{
					Step_SellerDisclosure_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="div#SELLER_DISCLOSURE_POPUP_1 #document")
			    public WebElement Step_SellerDisclosure_UploadSellerDisclosure;	
				
				@FindBy(css="div#SELLER_DISCLOSURE_POPUP_1 #fldDocument")
			    public WebElement Step_SellerDisclosure_UploadFLDDisclosure;	
				
				@FindBy(css="#SELLER_DISCLOSURE_POPUP_1  textarea[name='comments']")
			    public WebElement Step_SellerDisclosure_Comments;	
				
				@FindBy(css="#SELLER_DISCLOSURE_POPUP_1  #sellerDisclosurePopupSubmitButton")
			    public WebElement Step_SellerDisclosure_Save;	
					
				
				
			//Step 25 - Contractor Appointment
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_ContractorAppointment_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_ContractorAppointment_Header;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_ContractorAppointment_CalenderIcon;
				
				public void Step_ContractorAppointment_SelectDate()
				{
					Step_ContractorAppointment_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_ContractorAppointment_Comments;
				
				@FindBy(id="milestonePopupSubmitButton")
			    public WebElement Step_ContractorAppointment_Save;		
				
				
				//Step 26 - Loan Disclosure
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_LoanDisclosure_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_LoanDisclosure_Header;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_LoanDisclosure_CalenderIcon;
				
				public void Step_LoanDisclosure_SelectDate()
				{
					Step_OrderTitle_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_LoanDisclosure_Comments;
				
				@FindBy(id="milestonePopupSubmitButton")
			    public WebElement Step_LoanDisclosure_Save;		
				
				//Step - Rate & Terms
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_RateAndTerms_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_RateAndTerms_Header;
				
				//@FindBy(css="#TERMS_AND_RATE_POPUP_1 div.modal-content i[class='fa fa-calendar']")
				@FindBy(css="#TERMS_AND_RATE_POPUP_1 #endDate")
				//@FindBy(id="endDate")
			    public WebElement Step_RateAndTerms_CalenderIcon;
				
				public void Step_RateAndTerms_SelectDate()
				{
					Step_RateAndTerms_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#TERMS_AND_RATE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_RateAndTerms_Comments;
				
				@FindBy(css="#TERMS_AND_RATE_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_RateAndTerms_Save;	
				
				//Step - Mortgagee Clause
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_MortgageeClause_Div;
				
				@FindBy(css="#MORTGAGEE_CLAUSE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_MortgageeClause_Header;
				
				@FindBy(css="#MORTGAGEE_CLAUSE_POPUP_1 #endDate")
			    public WebElement Step_MortgageeClause_CalenderIcon;
				
				public void Step_MortgageeClause_SelectDate()
				{
					Step_MortgageeClause_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MORTGAGEE_CLAUSE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_MortgageeClause_Comments;
				
				@FindBy(id="mortgageClausePopupSubmitButton")
			    public WebElement Step_MortgageeClause_Save;		
				
			//Step 26 - Order Title
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_OrderTitle_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content h4'")
			    public WebElement Step_OrderTitle_Header;
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_OrderTitle_CalenderIcon;
				
				public void Step_OrderTitle_SelectDate()
				{
					Step_OrderTitle_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#MILESTONE_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_OrderTitle_Comments;
				
				@FindBy(id="milestonePopupSubmitButton")
			    public WebElement Step_OrderTitlet_Save;		
				
				
			//Step 28 - MLS Sheet
				
				@FindBy(id="MILESTONE_POPUP_WITH_DOC_1")
			    public WebElement Step_MLSSheet_Div;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 i[class='fa fa-calendar']")
			    public WebElement Step_MLSSheet_CompletionDateCalenderIcon;
				
				public void Step_MLSSheet_CompletionDate()
				{
					Step_MLSSheet_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="div#MILESTONE_POPUP_WITH_DOC_1 #document")
			    public WebElement Step_MLSSheet_UploadMLSSheet;	
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1  textarea[name='comments']")
			    public WebElement Step_MLSSheet_Comments;	
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 #milestonePopupSubmitButton")
			    public WebElement Step_MLSSheet_Save;	
				
				
			//Step 25 - Home Warranty
				
				@FindBy(id="HOME_WARRANTY_POPUP_1")
			    public WebElement Step_HomeWarranty_Div;
				
				//Home Warranty Included ?
				
					@FindBy(css="#HOME_WARRANTY_POPUP_1 #optionsRadiosN")
				    public WebElement Step_HomeWarranty_Included_No;
				
					@FindBy(css="#HOME_WARRANTY_POPUP_1 #optionsRadiosY")
				    public WebElement Step_HomeWarranty_Included_Yes;
					
						@FindBy(name="#HOME_WARRANTY_POPUP_1 companyName")
					    public WebElement Step_HomeWarranty_CompanyName;
						
						@FindBy(name="#HOME_WARRANTY_POPUP_1 policyNumber")
					    public WebElement Step_HomeWarranty_PolicyNumber;
						
						@FindBy(id="#HOME_WARRANTY_POPUP_1 validFromDate")
					    public WebElement Step_HomeWarranty_ValidFrom;
						
						@FindBy(id="validToDate")
					    public WebElement Step_HomeWarranty_ValidTo;
		
				
				@FindBy(css="#HOME_WARRANTY_POPUP_1 #endDate")
			    public WebElement Step_HomeWarranty_CompletionDateCalenderIcon;
				
				public void Step_HomeWarranty_CompletionDate()
				{
					Step_HomeWarranty_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
	
				@FindBy(css="#HOME_WARRANTY_POPUP_1 #comments")
			    public WebElement Step_HomeWarranty_Comments;	
				
				@FindBy(css="#HOME_WARRANTY_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_HomeWarranty_Save;	
					
				
			//Step 26 - Utility Information
				
				@FindBy(id="UTILITY_INFORMATION_POPUP_1")
			    public WebElement Step_UtilityInformation_Div;
						
				@FindBy(css="a.addOrEditUtility")
			    public WebElement Step_UtilityInformation_AddUtility;
				
					@FindBy(name="utilityType")
				    public WebElement Step_UtilityInformation_AddUtility_UtilityType;
					
					@FindBy(id="companyDropdown")
				    public WebElement Step_UtilityInformation_AddUtility_Company;
					
					@FindBy(name="orgName")
				    public WebElement Step_UtilityInformation_AddUtility_Company_Name;
					
						// Company details - if needed...
					
					@FindBy(css="button.submitUtilityForm")
				    public WebElement Step_UtilityInformation_AddUtility_Save;
				
	
				@FindBy(xpath="//form[@id='utilityInformationForm']/div/div[1]/div/input")
			    public WebElement Step_UtilityInformation_CompletionDateCalenderIcon;
				
				public void Step_UtilityInformation_CompletionDate()
				{
					Step_UtilityInformation_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
	
				@FindBy(css="#UTILITY_INFORMATION_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_UtilityInformation_Save;	
				
				
				
			//Step 27 - HOA Docs
				
				@FindBy(id="MILESTONE_POPUP_WITH_DOC_1")
			    public WebElement Step_HOADocs_Div;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 i[class='fa fa-calendar']")
			    public WebElement Step_HOADocs_CompletionDateCalenderIcon;
				
				public void Step_HOADocs_CompletionDate()
				{
					Step_HOADocs_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="div#MILESTONE_POPUP_WITH_DOC_1 #document")
			    public WebElement Step_HOADocs_UploadHOAStatement;	
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 textarea[name='comments']")
			    public WebElement Step_HOADocs_Comments;	
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 #milestonePopupSubmitButton")
			    public WebElement Step_HOADocs_Save;	
				
				
			//Step 27 - Wire Instruction
				
				@FindBy(id="MILESTONE_POPUP_WITH_DOC_1")
			    public WebElement Step_WireInstruction_Div;
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 i[class='fa fa-calendar']")
			    public WebElement Step_WireInstruction_CompletionDateCalenderIcon;
				
				public void Step_WireInstruction_CompletionDate()
				{
					Step_WireInstruction_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="div#MILESTONE_POPUP_WITH_DOC_1 #document")
			    public WebElement Step_WireInstruction_UploadHOAStatement;	
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 textarea[name='comments']")
			    public WebElement Step_WireInstruction_Comments;	
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 #milestonePopupSubmitButton")
			    public WebElement Step_WireInstruction_Save;		
				
				
			//Step 28 - HU Impound
				
				@FindBy(id="HU_IMPOUND_POPUP_1")
			    public WebElement Step_HUImpound_Div;
				
				@FindBy(css="#HU_IMPOUND_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_HUImpound_CompletionDateCalenderIcon;
				
				public void Step_HUImpound_CompletionDate()
				{
					Step_HUImpound_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
			
				//HU Tax Impound?
				
					@FindBy(css="div#HU_IMPOUND_POPUP_1 form.milestone-form div:nth-of-type(1) #uniform-optionsRadiosY")
				    public WebElement Step_HUImpound_TaxImpound_Yes;	
					
					@FindBy(css="div#HU_IMPOUND_POPUP_1 form.milestone-form div:nth-of-type(1) #uniform-optionsRadiosN")
				    public WebElement Step_HUImpound_TaxImpound_No;
					
				//HU Insurance Impound?
					
					@FindBy(css="div#HU_IMPOUND_POPUP_1 form.milestone-form div:nth-of-type(2) #uniform-optionsRadiosY")
				    public WebElement Step_HUImpound_InsuranceImpound_Yes;	
					
					@FindBy(css="div#HU_IMPOUND_POPUP_1 form.milestone-form div:nth-of-type(2) #uniform-optionsRadiosN")
				    public WebElement Step_HUImpound_InsuranceImpound_No;
					
				//HU HOA  Impound?
					
					@FindBy(css="div#HU_IMPOUND_POPUP_1 form.milestone-form div:nth-of-type(3) #uniform-optionsRadiosY")
				    public WebElement Step_HUImpound_HOAImpound_Yes;	
					
					@FindBy(css="div#HU_IMPOUND_POPUP_1 form.milestone-form div:nth-of-type(3) #uniform-optionsRadiosN")
				    public WebElement Step_HUImpound_HOAImpound_No;	
					
					
				@FindBy(css="#HU_IMPOUND_POPUP_1 textarea[name='comments']")
			    public WebElement Step_HUImpound_Comments;	
				
				@FindBy(css="#HU_IMPOUND_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_HUImpound_Save;
				
				
			//Step 29 - Contractor Appointment Confirmation
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_ContractorAppointmentConfirmation_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_ContractorAppointmentConfirmation_CompletionDateCalenderIcon;
				
				public void Step_ContractorAppointmentConfirmation_CompletionDate()
				{
					Step_ContractorAppointmentConfirmation_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
			
				
				@FindBy(css="#MILESTONE_POPUP_1 textarea[name='comments']")
			    public WebElement Step_ContractorAppointmentConfirmation_Comments;	
				
				@FindBy(css="#MILESTONE_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_ContractorAppointmentConfirmation_Save;
				
				
			//Step 30 - Title Report
				
				@FindBy(id="MILESTONE_POPUP_WITH_DOC_1")
			    public WebElement Step_TitleReport_Div;
				
				//Title is clean?
				
					@FindBy(css="#uniform-optionsRadiosY")
				    public WebElement Step_TitleReport_TitleClean_Yes;
					
					@FindBy(css="#uniform-optionsRadiosN")
				    public WebElement Step_TitleReport_TitleClean_No;
					
				// Display to Investor
				
					@FindBy(id="isDisplayToInvestorMessage")
				    public WebElement Step_TitleReport_DisplayToInvestor;
					
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 i[class='fa fa-calendar']")
			    public WebElement Step_TitleReport_CompletionDateCalenderIcon;
				
				public void Step_TitleReport_CompletionDate()
				{
					Step_TitleReport_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="div#MILESTONE_POPUP_WITH_DOC_1 #document")
			    public WebElement Step_TitleReport_UploadTitleDocument;	
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 textarea[name='comments']")
			    public WebElement Step_TitleReport_Comments;	
				
				@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 #milestonePopupSubmitButton")
			    public WebElement Step_TitleReport_Save;
				
				
			//Step 31 - Tax Certificate
				
				@FindBy(id="TAX_CERTIFICATE_POPUP_1")
			    public WebElement Step_TaxCertificate_Div;
				
				//@FindBy(css="#MILESTONE_POPUP_WITH_DOC_1 i[class='fa fa-calendar']")
				@FindBy(css="#TAX_CERTIFICATE_POPUP_1 #endDate")
			    public WebElement Step_TaxCertificate_CompletionDateCalenderIcon;
				
				//yearly tax amount
				@FindBy(css="#TAX_CERTIFICATE_POPUP_1 #yearlyTaxAmount_currency")
			    public WebElement Step_TaxCertificate_YearlyTaxAmount;
				
				public void Step_TaxCertificate_CompletionDate()
				{
					Step_TaxCertificate_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				// Display to Investor
				
					@FindBy(id="isDisplayToInvestorMessage")
				    public WebElement Step_TaxCertificate_DisplayToInvestor;
				
				@FindBy(css="#TAX_CERTIFICATE_POPUP_1 #document")
			    public WebElement Step_TaxCertificate_UploadTaxCertificate;	
				
				@FindBy(css="#TAX_CERTIFICATE_POPUP_1 #comments")
			    public WebElement Step_TaxCertificate_Comments;	
				
				@FindBy(css="#TAX_CERTIFICATE_POPUP_1 #taxCertificatePopupSubmitButton")
			    public WebElement Step_TaxCertificate_Save;
				
			
			//Step 32 - Fee Sheet
				
				@FindBy(id="FEE_SHEET_POPUP_1")
			    public WebElement Step_FeeSheet_Div;
				
				@FindBy(css="#FEE_SHEET_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_FeeSheet_CompletionDateCalenderIcon;
				
				public void Step_FeeSheet_CompletionDate()
				{
					Step_FeeSheet_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="div#FEE_SHEET_POPUP_1 #document")
			    public WebElement Step_FeeSheet_UploadFeeSheet;	
				
				@FindBy(css="#FEE_SHEET_POPUP_1 textarea[name='comments']")
			    public WebElement Step_FeeSheet_Comments;	
				
				@FindBy(css="#FEE_SHEET_POPUP_1 #feeSheetPopupSubmitButton")
			    public WebElement Step_FeeSheet_Save;
				
				
			//Step 32 - Contractor Quote
				
				@FindBy(id="PROPERTY_INSPECTION_ILM_POPUP_1")
			    public WebElement Step_ContractorQuote_Div;
				
				@FindBy(css="#PROPERTY_INSPECTION_ILM_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_ContractorQuote_ReviewDateCalenderIcon;
				
				public void Step_ContractorQuote_ReviewDate()
				{
					Step_ContractorQuote_ReviewDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#PROPERTY_INSPECTION_ILM_POPUP_1 textarea[name='comments']")
			    public WebElement Step_ContractorQuote_Comments;	
				
				@FindBy(css="#propertyInspectionIlmPopupSubmitButton")
			    public WebElement Step_ContractorQuote_Save;
					
				
			//Step 32 - HomeUnion Inspection Review
				
				@FindBy(id="PROPERTY_INSPECTION_ILM_POPUP_1")
			    public WebElement Step_HomeUnionInspectionReview_Div;
				
				@FindBy(css="#PROPERTY_INSPECTION_ILM_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_HomeUnionInspectionReview_ReviewDateCalenderIcon;
				
				public void Step_HomeUnionInspectionReview_ReviewDate()
				{
					Step_HomeUnionInspectionReview_ReviewDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#PROPERTY_INSPECTION_ILM_POPUP_1 textarea[name='comments']")
			    public WebElement Step_HomeUnionInspectionReview_Comments;	
				
				@FindBy(css="#propertyInspectionIlmPopupSubmitButton")
			    public WebElement Step_HomeUnionInspectionReview_Save;
			
				
			//Step 33 - HomeUnion Rehab Quote
				
				@FindBy(id="PROPERTY_INSPECTION_ILM_POPUP_1")
			    public WebElement Step_HomeUnionRehabQuote_Div;
				
				@FindBy(css="#PROPERTY_INSPECTION_ILM_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_HomeUnionRehabQuote_ReviewDateCalenderIcon;
				
				public void Step_HomeUnionRehabQuote_ReviewDate()
				{
					Step_HomeUnionRehabQuote_ReviewDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#PROPERTY_INSPECTION_ILM_POPUP_1 textarea[name='comments']")
			    public WebElement Step_HomeUnionRehabQuote_Comments;	
				
				@FindBy(css="#propertyInspectionIlmPopupSubmitButton")
			    public WebElement Step_HomeUnionRehabQuote_Save;
						
			
			//Step 34 - Inspection Review - Internal
				
				@FindBy(id="PROPERTY_INSPECTION_ILM_POPUP_1")
			    public WebElement Step_InspectionReviewInternal_Div;
				
				@FindBy(css="#PROPERTY_INSPECTION_ILM_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_InspectionReviewInternal_ReviewDateCalenderIcon;
				
				public void Step_InspectionReviewInternal_ReviewDate()
				{
					Step_InspectionReviewInternal_ReviewDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#PROPERTY_INSPECTION_ILM_POPUP_1 textarea[name='comments']")
			    public WebElement Step_InspectionReviewInternal_Comments;	
				
				@FindBy(css="#propertyInspectionIlmPopupSubmitButton")
			    public WebElement Step_InspectionReviewInternal_Save;
				
				
			//Step 35 - Inspection Review - Investor
				
				@FindBy(css="#PROPERTY_INSPECTION_INVESTOR_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_InspectionReviewInvestor_ReviewDateCalenderIcon;
				
				@FindBy(id="PROPERTY_INSPECTION_INVESTOR_POPUP_1")
			    public WebElement Step_InspectionReviewInvestor_Div;
				
				public void Step_InspectionReviewInvestor_ReviewDate()
				{
					Step_InspectionReviewInvestor_ReviewDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#PROPERTY_INSPECTION_INVESTOR_POPUP_1 textarea[name='comments']")
			    public WebElement Step_InspectionReviewInvestor_Comments;	
				
				@FindBy(css="#propertyInspectionInvestorPopupSubmitButton")
			    public WebElement Step_InspectionReviewInvestor_Save;	
							
			
			//Step 35 - Utility Transfer
				
				@FindBy(id="UTILITY_TRANSFER_POPUP_1")
			    public WebElement Step_UtilityTransfer_Div;
				
				@FindBy(css="#UTILITY_TRANSFER_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_UtilityTransfer_ReviewDateCalenderIcon;
				
				public void Step_UtilityTransfer_ReviewDate()
				{
					Step_UtilityTransfer_ReviewDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();	
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#UTILITY_TRANSFER_POPUP_1 textarea[name='comments']")
			    public WebElement Step_UtilityTransfer_Comments;	
				
				@FindBy(css="#UTILITY_TRANSFER_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_UtilityTransfer_Save;
				
				
			//Step 36 - Final Walk Through
				
				@FindBy(id="FINAL_WALK_THROUGH_POPUP_1")
			    public WebElement Step_FinalWalkThrough_Div;
				
				@FindBy(css="#FINAL_WALK_THROUGH_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_FinalWalkThrough_ReviewDateCalenderIcon;
				
				public void Step_FinalWalkThrough_ReviewDate()
				{
					Step_FinalWalkThrough_ReviewDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();		
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#FINAL_WALK_THROUGH_POPUP_1 textarea[name='comments']")
			    public WebElement Step_FinalWalkThrough_Comments;	
				
				@FindBy(css="#FINAL_WALK_THROUGH_POPUP_1 #finalWalkThroughPopupSubmitButton")
			    public WebElement Step_FinalWalkThrough_Save;
				
				
			//Step 37 - Closing Appointment
				
				@FindBy(id="CLOSING_APPOINTMENT_POPUP_1")
			    public WebElement Step_ClosingAppointment_Div;
				
				@FindBy(css="#CLOSING_APPOINTMENT_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_ClosingAppointment_ReviewDateCalenderIcon;
				
				public void Step_ClosingAppointment_ReviewDate()
				{
					Step_ClosingAppointment_ReviewDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();		
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#CLOSING_APPOINTMENT_POPUP_1 textarea[name='comments']")
			    public WebElement Step_ClosingAppointment_Comments;	
				
				@FindBy(css="#CLOSING_APPOINTMENT_POPUP_1 #closingAppointmentPopupSubmitButton")
			    public WebElement Step_ClosingAppointment_Save;	
			
				
			//Step 37 - Rehab Start Confirmation
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_RehabStartConfirmation_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_RehabStartConfirmation_ReviewDateCalenderIcon;
				
				public void Step_RehabStartConfirmation_CompletionDate()
				{
					Step_RehabStartConfirmation_ReviewDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();		
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#MILESTONE_POPUP_1 textarea[name='comments']")
			    public WebElement Step_RehabStartConfirmation_Comments;	
				
				@FindBy(css="#MILESTONE_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_RehabStartConfirmation_Save;		
				
				
			//Step 38 - Deed Recorded
				
				@FindBy(id="DEED_RECORDED_POPUP_1")
			    public WebElement Step_DeedRecorded_Div;
				
				@FindBy(css="#DEED_RECORDED_POPUP_1 div.modal-content i[class='fa fa-calendar']")
			    public WebElement Step_DeedRecorded_ClosingDateCalenderIcon;
				
				@FindBy(css="#DEED_RECORDED_POPUP_1 div.modal-content form div:nth-of-type(2) i[class='fa fa-calendar']")
			    public WebElement Step_DeedRecorded_CompletionDateCalenderIcon;
				
				public void Step_DeedRecorded_SelectClosingDate()
				{
					Step_DeedRecorded_ClosingDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				public void Step_DeedRecorded_CompletionStartDate()
				{
					Step_DeedRecorded_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="#DEED_RECORDED_POPUP_1 div.modal-content textarea[name='comments']")
			    public WebElement Step_DeedRecorded_Comments;
				
				@FindBy(css="#DEED_RECORDED_POPUP_1 #deedRecordedPopupSubmitButton")
			    public WebElement Step_DeedRecorded_Save;	
			
				
			//Step 39 - Get Keys & Install Lock Box
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_GetKeysAndInstallLockBox_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_GetKeysAndInstallLockBox_CompletionDateCalenderIcon;
				
				public void Step_GetKeysAndInstallLockBox_CompletionDate()
				{
					Step_GetKeysAndInstallLockBox_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();		
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#MILESTONE_POPUP_1 textarea[name='comments']")
			    public WebElement Step_GetKeysAndInstallLockBox_Comments;	
				
				@FindBy(css="#MILESTONE_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_GetKeysAndInstallLockBox_Save;		
				
				
			//Step 40 - Rental Agreement
				
				@FindBy(id="UPLOAD_RENTAL_AGREEMENT_POPUP_1")
			    public WebElement Step_RentalAgreement_Div;
				
				
				// Property 
					
					@FindBy(name="tenantName")
				    public WebElement Step_RentalAgreement_Property_TenantName;
					
					@FindBy(id="rentAmount_currency")
				    public WebElement Step_RentalAgreement_Property_RentAmount;
					
					@FindBy(id="securityDeposits_currency")
				    public WebElement Step_RentalAgreement_Property_SecurityDepositeAmount;
					
					@FindBy(css="#UPLOAD_RENTAL_AGREEMENT_POPUP_1 #document")
				    public WebElement Step_RentalAgreement_Property_UploadRentalAgreement;	
					
					@FindBy(css="button.saveRentalAgreementTab")
				    public WebElement Step_RentalAgreement_Property_Save;
					
				
				@FindBy(css="#UPLOAD_RENTAL_AGREEMENT_POPUP_1 div.col-md-6 i[class='fa fa-calendar']")
			    public WebElement Step_RentalAgreement_CompletionDateCalenderIcon;
				
				public void Step_RentalAgreement_CompletionDate()
				{
					Step_RentalAgreement_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();		
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#UPLOAD_RENTAL_AGREEMENT_POPUP_1 textarea[name='comments']")
			    public WebElement Step_RentalAgreement_Comments;	
				
				@FindBy(css="#UPLOAD_RENTAL_AGREEMENT_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_RentalAgreement_Save;			
				
				
			//Step 41 - Lease Review
				
				@FindBy(id="LEASE_REVIEW_POPUP_1")
			    public WebElement Step_LeaseReview_Div;
				
				@FindBy(css="#LEASE_REVIEW_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_LeaseReview_CompletionDateCalenderIcon;
				
				public void Step_LeaseReview_CompletionDate()
				{
					Step_LeaseReview_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();		
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#LEASE_REVIEW_POPUP_1 textarea[name='comments']")
			    public WebElement Step_LeaseReview_Comments;	
				
				@FindBy(css="#LEASE_REVIEW_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_LeaseReview_Save;			
				
				
			//Step 42 - Security Deposit - Pro-Rated Rent
				
				@FindBy(id="MILESTONE_POPUP_1")
			    public WebElement Step_SecurityDepositProRatedRent_Div;
				
				@FindBy(css="#MILESTONE_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_SecurityDepositProRatedRent_CompletionDateCalenderIcon;
				
				public void Step_SecurityDepositProRatedRent_CompletionDate()
				{
					Step_SecurityDepositProRatedRent_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();		
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#MILESTONE_POPUP_1 textarea[name='comments']")
			    public WebElement Step_SecurityDepositProRatedRent_Comments;	
				
				@FindBy(css="#MILESTONE_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_SecurityDepositProRatedRent_Save;
				
				
			//Step 52 - Contractor Scheduling
				
				@FindBy(css="#MILESTONE_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_ContractorScheduling_CompletionDateCalenderIcon;
				
				public void Step_ContractorScheduling_CompletionDate()
				{
					Step_ContractorScheduling_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				
				@FindBy(css="#MILESTONE_POPUP_1 textarea[name='comments']")
			    public WebElement Step_ContractorScheduling_Comments;	
				
				@FindBy(css="#MILESTONE_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_ContractorScheduling_Save;
				
				
			//Step 53 - Option Fee
				
				@FindBy(css="#OPTION_FEE_POPUP_1 #optionFee_currency")
			    public WebElement Step_OptionFee_OptionFee;
				
				@FindBy(css="#OPTION_FEE_POPUP_1 i[class='fa fa-calendar']")
			    public WebElement Step_OptionFee_CompletionDateCalenderIcon;
				
				public void Step_OptionFee_CompletionDate()
				{
					Step_OptionFee_CompletionDateCalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(css="div#OPTION_FEE_POPUP_1 #document")
			    public WebElement Step_OptionFee_UploadFeeImage;	
				
				@FindBy(css="#OPTION_FEE_POPUP_1 textarea[name='comments']")
			    public WebElement Step_OptionFee_Comments;	
				
				@FindBy(css="#OPTION_FEE_POPUP_1 #milestonePopupSubmitButton")
			    public WebElement Step_OptionFee_Save;
				
		//Documents
			//Get Table data for given row
			public String Documents_GetTableData(int i, int column)
			{	
				try {
					String cssSelector = "div#accordion3 table tbody tr:nth-of-type(" + i + ") td:nth-of-type(" + column + ")";
					return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				} catch (Exception e) {
					//
				}
				return "no data";
				
			}
			
			
		//Messages
			//Get Table data for given row
			public String Messages_GetTableData(int i, int column)
			{	
				String cssSelector = "#messagesTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(" + column + ")";
				return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				
			}
		
}
