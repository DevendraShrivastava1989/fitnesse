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
//import org.testng.Reporter;

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
	
	// General
		@FindBy(css="div.marg_top10 tbody tr:nth-of-type(7) td:nth-of-type(1) span")
		public WebElement ListPrice;
		
		@FindBy(css="div.marg_top10 tbody tr:nth-of-type(7) td:nth-of-type(2) span")
		public WebElement BidRange;
		
		@FindBy(css="div.marg_top10 tbody tr:nth-of-type(8) td:nth-of-type(2) span")
		public WebElement RentRange;
		
		@FindBy(css="div.marg_top10 tbody tr:nth-of-type(8) td:nth-of-type(2) span")
		public WebElement PropertySaleType;
		
		@FindBy(id="propertyAddressSpan")
		public WebElement Address;
		
		
	// All Tabs
		
		// Property Information
			@FindBy(id="propertyInfo")
			public WebElement PropertyInformationTab ;
			
			@FindBy(id="propertyInfoTab")
			public WebElement PropertyInformationContent;
			
				//General Information
				@FindBy(id="generalInfoEditButton")
				public WebElement PropertyInformationContent_GeneralInfo_Edit;
				
				@FindBy(id="yearBuilt")
				public WebElement PropertyInformationContent_GeneralInfo_YearBuild;
				
				@FindBy(id="rehabEstimate")
				public WebElement PropertyInformationContent_GeneralInfo_RehabEstimate;
				
				@FindBy(id="propertyTaxesAnnual")
				public WebElement PropertyInformationContent_GeneralInfo_AnnualTaxes;
				
				//Edit mode
					@FindBy(name="yearBuilt")
					public WebElement PropertyInformationContent_GeneralInfo_YearBuild_Edit;
					
					@FindBy(id="rehabEstimate_currency")
					public WebElement PropertyInformationContent_GeneralInfo_RehabEstimate_Edit;
					
					@FindBy(id="propertyTaxesAnnual_currency")
					public WebElement PropertyInformationContent_GeneralInfo_AnnualTaxes_Edit;
				
				@FindBy(id="saveGeneralInfoModalBtn")
				public WebElement PropertyInformationContent_GeneralInfo_Edit_Save;
				
					//Confirmation
					@FindBy(id="saveGeneralInfoButton")
					public WebElement PropertyInformationContent_GeneralInfo_Edit_Save_Confirmation_Yes;
					
			
		// Financials
			@FindBy(id="propertyFinancials")
			public WebElement FinancialsTab ;
			
			@FindBy(id="propertyFinancialsTab")
			public WebElement FinancialsContent;
			
		// Photos
			@FindBy(id="propertyPhotos")
			public WebElement PhotosTab ;
			
			@FindBy(id="propertyPhotosTab")
			public WebElement PhotosContent;
			
				@FindBy(name="addFilesBtn")
				public WebElement PhotosContent_AddPhotos;
				
				@FindBy(id="files")
				public WebElement PhotosContent_AddPhoto_ChooseFile;
				
				@FindBy(name="startUploadBtn")
				public WebElement PhotosContent_AddPhoto_Upload;
				
		
				//To delete existing photos if any		
				public void PhotosContent_ToDeleteExistingPhotos()
				{
					String cssSelector = "#photoDetailTable tbody tr";
					List<WebElement> allphotos = driver.findElements(By.cssSelector(cssSelector));
					
					if(allphotos.size() >= 1)
					{
						int i=1; 
						while (i <= allphotos.size())
						{
							cssSelector = "#photoDetailTable tbody tr:nth-of-type(1) td";
							if(driver.findElement(By.cssSelector(cssSelector)).getText().trim().equalsIgnoreCase("No matching records found"))
							{
								//Nothing
								System.out.println("--- Success!! Photo is not present ");
								//Reporter.log("--- Success!! Photo is not present ");
								break;
							}
							else
							{
								cssSelector = "#photoDetailTable tbody tr:nth-of-type(1) td:nth-of-type(1) button";
								driver.findElement(By.cssSelector(cssSelector)).click();
								
								cssSelector = "#photoDetailTable tbody tr:nth-of-type(1) td:nth-of-type(1) li a";
								driver.findElement(By.cssSelector(cssSelector)).click();
								try { Thread.sleep(3000);} catch (InterruptedException e) {}
								
								driver.findElement(By.name("deletePhotoConfirm")).click();
								try { Thread.sleep(10000);} catch (InterruptedException e) {}

							}
							
							i++;
						}

					}
						
				}
				
				
				
			
	
		// Documents
			@FindBy(id="propertyDocuments")
			public WebElement DocumentsTab ;
			
			@FindBy(id="propertyDocumentsTab")
			public WebElement DocumentsContent;
			
				//Add new document
				@FindBy(css="#propertyDocumentsTab i.fa-plus")
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
				
		// Rehab Estimator
			@FindBy(id="rehabEstimator")
			public WebElement RehabEstimatorTab ;
			
			@FindBy(id="rehabEstimatorTab")
			public WebElement RehabEstimatorContent;
			
				@FindBy(id="edit-rehab-estimate")
				public WebElement RehabEstimatorContent_StartNew;
				
				@FindBy(id="startRehabEstimationBtn")
				public WebElement RehabEstimatorContent_StartRehabEstimation;
				
				// Estimate
				@FindBy(css="button.goto-head-category")
				public WebElement RehabEstimatorContent_RehabEstimation_GoToSummary;
				
				@FindBy(css="#summary-dtls-section table > tbody > tr:nth-child(7) > td.rehab_amt")
				public WebElement RehabEstimatorContent_RehabEstimation_Total;
				
				@FindBy(id="btnSubmitToNextSummary")
				public WebElement RehabEstimatorContent_RehabEstimation_Submit;
				
				@FindBy(css="#populate-Categories > div:nth-child(12) > span.amount_1")
				public WebElement RehabEstimatorContent_TotalRehabCost;
				
				
				
				
			
		// Messages
			@FindBy(id="propertyMessages")
			public WebElement MessagesTab ;
			
			@FindBy(id="propertyMessagesTab")
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
						String cssSelector = "div#accordion3 table tbody tr:nth-of-type(" + i + ") td:nth-of-type(" + column + ")";
						return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
					} catch (Exception e) {
						//
					}
					return "no data";
				}
				
				// Delete
				@FindBy(css="#messagesTable_wrapper a[name='deleteMessage']")
				public WebElement MessagesContent_Delete;

				@FindBy(id="deleteMessageConfirmationButton")
				public WebElement MessagesContent_DeleteConfiramtion_Yes;
		
		
	
	
		//Property Information Tab
			//@FindBy(id="purchasePrice")
			@FindBy(id="askingPrice")
			public WebElement Price;
			
			@FindBy(id="propertyTaxesAnnual")
			public WebElement PropertyTaxesAnnual;
			
			@FindBy(id="propertyInsuranceAnnual")
			public WebElement PropertyInsuranceAnnual;
			
			@FindBy(id="leasedRent")
			public WebElement ListedRent;
			
			@FindBy(id="rehabEstimate")
			public WebElement RehabEstimate;
			
			@FindBy(id="hoaFeeAnnual")
			public WebElement HOAFeeAnnual;
			
			@FindBy(id="nir")
			public WebElement PDP_NIR;
			
			public String HOAMonthly()
			{
				String hoaannual = HOAFeeAnnual.getText().trim();
				String temp = JH.USCurrencyFormatToString(hoaannual);
				double hoamonthly = (Integer.parseInt(temp)) / 12 ;
				temp = Double.toString(hoamonthly);
				return JH.CovertToUSCurrencyFormat(temp);
			}
			
			
			
		// Wishlists
		
		@FindBy(id="propertyWishlists")
		public WebElement WishListsTab;
			
		@FindBy(id="propertyWishlistsTab")
		public WebElement WishlistsContent;
		
			@FindBy(css="a[href='#wishlistmodal2']")
			public WebElement AddToWishlist;
			
			//'Add Property to Wishlist' model
				@FindBy(css="input#investor_fname")
				public WebElement InvestorSearchbox;
				
				@FindBy(css="#investorSearch button")
				public WebElement Search;
				
				public String SelectInvestorFromSearchTable(String investor)
				{
					int i=1;
					String cssSelector = "";
					try {
						for(i=1;i<=10;i++)
						{
							cssSelector = "#investorSearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1)";
							String temp = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
							if(temp.toLowerCase().contains(investor.toLowerCase()))
							{
								break;
							}
						}
					} 
					catch (Exception e) 
					{
						i--;
					}
					
					cssSelector = "#investorSearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1)";
					String investorname = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
					cssSelector = "#investorSearchResultsTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(4) input";
					try { Thread.sleep(1000); driver.findElement(By.cssSelector(cssSelector)).click();}catch(Exception e)
					{new Actions(driver).moveToElement(driver.findElement(By.cssSelector(cssSelector))).click().perform();}
					try {Thread.sleep(3000);} catch (InterruptedException e) {}
					return investorname; 
				
				}
				
				@FindBy(id="addWishInvestor")//karthik
				public WebElement Add;
				
				
			    // Wishlists table
				
				@FindBy(name="propertyWishlistTable_length")
				public WebElement RecordsDropdown;
				
				//set search records on Table e.g. 25,50,100 etc.
				public void SetSearchRecord(String i)
				{
					new Select(RecordsDropdown).selectByVisibleText(i);
				}
				
				//Click on Ready To Invest link for given investor
				public void ClickOnReadyToInvestLinkForInvestor(String investor)
				{
					int i=1;
					String cssSelector = "";
					for(i=1;i<=10;i++)
					{
						cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(2) a";
						String temp = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
						if(temp.toLowerCase().contains(investor.toLowerCase()))
						{
							break;
						}
					}
					
					cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) div button";
					driver.findElement(By.cssSelector(cssSelector)).click();
					try {Thread.sleep(4000);} catch (InterruptedException e) {}	
					
					cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) div ul a[href='#inventToBuyModal']";
					driver.findElement(By.cssSelector(cssSelector)).click();
					try {Thread.sleep(4000);} catch (InterruptedException e) {}		
					
				}
				
				
				//Click on ' Remove Investor from Wishlist ' for given investor
				public void ClickOnRemoveInvestorfromWishlistLinkForInvestor(String investor)
				{
					int i=1;
					String cssSelector = "";
					for(i=1;i<=10;i++)
					{
						cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(2) a";
						String temp = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
						if(temp.toLowerCase().contains(investor.toLowerCase()))
						{
							break;
						}
					}
					
					cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) div button";
					driver.findElement(By.cssSelector(cssSelector)).click();
					try {Thread.sleep(4000);} catch (InterruptedException e) {}	
					
					cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) div ul a[href='#wishlistInvestorModal']";
					driver.findElement(By.cssSelector(cssSelector)).click();
					try {Thread.sleep(4000);} catch (InterruptedException e) {}		
					
					driver.findElement(By.id("removeInvestor")).click();
					try {Thread.sleep(4000);} catch (InterruptedException e) {}	
					
				}
				
				
				//Get table data for given investor
				public String GetTableDataForInvestor(String investor, int column)
				{
					int i=1;
					String cssSelector = "";
					for(i=1;i<=10;i++)
					{
						cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(2) a";
						String temp = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
						if(temp.toLowerCase().contains(investor.toLowerCase()))	
						{
							break;
						}
					}
					
					cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(" + column + ")";
					return driver.findElement(By.cssSelector(cssSelector)).getText().trim();					
					
				}
				
				
				//Click on Initiate Closing link for given investor
				public void ClickOnInitiateClosingLinkForInvestor(String investor)
				{
					int i=1;
					String cssSelector = "";
					for(i=1;i<=10;i++)
					{
						cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(2) a";
						String temp = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
						if(temp.toLowerCase().contains(investor.toLowerCase()))
						{
							break;
						}
					}
					
					cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) div button";
					driver.findElement(By.cssSelector(cssSelector)).click();
					try {Thread.sleep(4000);} catch (InterruptedException e) {}	
					
					cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(1) div ul a[href='#initiateClosingModal']";
					driver.findElement(By.cssSelector(cssSelector)).click();
					try {Thread.sleep(4000);} catch (InterruptedException e) {}
					
				}
				
				
				//Verifying whether Investor is already added to Wishlist
				public boolean IsInvestorAddedToWishlistAlready(String investor)
				{
					int i=1;
					String cssSelector = "";
					boolean b= true; 
					
					try 
					{
						for(i=1;i<=10;i++)
						{
							cssSelector = "#propertyWishlistTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(2) a";
							String temp = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
							if(temp.toLowerCase().contains(investor.toLowerCase()))	
							{
								System.out.println("--- Investor is already added to Wishlist ");
								//Reporter.log("--- Investor is already added to Wishlist ");
								break;
							}
						}
					} 
					catch (Exception e) 
					{
						System.out.println("--- Investor is not present on Wishlist ");
						//Reporter.log("--- Investor is not present on Wishlist "); 
						b=false; 
					}	

					return b; 
				}
				
			
				@FindBy(id="confirmInvest")
				public WebElement ReadyToInvestYes;
				
			
				
		//Initiate Closing pop up
				
				@FindBy(css="input#purchasePrice_currency")
				public WebElement PurchasePrice;
				
				@FindBy(id="dealType")
				public WebElement ILMDeal;
				
				@FindBy(xpath="//form[@id='initiateClosingForm']/div[9]/div/label[2]/input")
				public WebElement TKPDeal;
				
				@FindBy(id="paDate")
			    public WebElement Select_PA_CalenderIcon;
				
				public void Initiate_Closing_Select_PA_Date()
				{
					Select_PA_CalenderIcon.click();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
					//Calender_Active_Date.click();
					ClickOnCurrentDate();
					try {Thread.sleep(2000);} catch (InterruptedException e) {}
				}
				
				@FindBy(xpath="//div[@id='closingTypeDiv']/select//option[1]")
				public WebElement Type_Purchase;
				
				@FindBy(xpath="//div[@id='closingTypeDiv']/select//option[2]")
				public WebElement Type_Sale;
				
				
				@FindBy(id="financingType")
				public WebElement FinancingType;
				
					public void SelectFinancingType(int i)
					{
						new Select(FinancingType).selectByIndex(i);
					}
					
					
				
				@FindBy(id="closingUserId")
				public WebElement Closer;
				
					public void SelectCloser(int i)
					{
						new Select(Closer).selectByIndex(i);
					}
					
					public String GetSelectedCloserText()
					{
						return new Select(Closer).getFirstSelectedOption().getText().trim();
					}
				
				@FindBy(id="assetManagerId")
				public WebElement AssetManager;
				
					public void SelectAssetManager(int i)
					{
						new Select(AssetManager).selectByIndex(i);
					}
					
					public String GetSelectedAssetManagerText()
					{
						return new Select(AssetManager).getFirstSelectedOption().getText().trim();
					}
					
				@FindBy(id="ilmUserId")
				public WebElement ILM;
				
					public void SelectILM(int i)
					{
						new Select(ILM).selectByIndex(i);
					}
					
					public String GetSelectedILMText()
					{
						return new Select(ILM).getFirstSelectedOption().getText().trim();
					}
					
				@FindBy(id="saleUserId")
				public WebElement SolutionSpecialist;
				
					public void SelectSolutionSpecialist(int i)
					{
						new Select(SolutionSpecialist).selectByIndex(i);
					}		
					
					public String GetSelectedSolutionSpecialistText()
					{
						return new Select(SolutionSpecialist).getFirstSelectedOption().getText().trim();
					}
					
				@FindBy(id="purchaseAgreementDoc")
				public WebElement UploadPurchaseAgreement;
				
				@FindBy(css="#submitInitiateClosingWL")
				public WebElement InitiateClosing;
				
				//Click on PST date on Datepicker
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
