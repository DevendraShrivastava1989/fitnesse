package pageFactory.Misc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class YardiPortal {

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public YardiPortal(WebDriver driver)
	{	 
        this.driver = driver;
 
        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
	@FindBy(css="#Username")
    public WebElement userName;
	
	@FindBy(css="#tblLogin1 > li:nth-child(2) input#Password_Text")
    public WebElement Password;
	
	@FindBy(css="#cmdLogin1")
    public WebElement loginButton;
	
	@FindBy(css="#PropLookup_LookupCode")
    public WebElement propertytextbox;
	
	@FindBy(tagName="iframe")
	public WebElement frame;
	
	@FindBy(css="#DashColThreeTable > tbody > tr:nth-child(2) > td:nth-child(1) > table > tbody > tr:nth-child(4) > td:nth-child(2) input")
	public WebElement proptextbox;
	
	@FindBy(css="#RefreshButton_Button")
    public WebElement refreshbutton;
	
	@FindBy(css="#LeasedUnitsDash_DashboardItem > tbody > tr > td:nth-child(2) a")
	public WebElement leaseStatus;
	
	@FindBy(css="#LeasedUnitsDash_DashboardItem > tbody > tr > td:nth-child(2) span")
	public WebElement leaseStatusblank;
	
	@FindBy(css="#DashboardGrid_DataTable_row0 > td:nth-child(8) span")
	public WebElement homestatus1;
	
	@FindBy(css="#DashboardGrid_DataTable_row1 > td:nth-child(8) span")
	public WebElement homestatus2;
	
	@FindBy(css="#DashboardGrid_DataTable_row0 > td:nth-child(1) a")
	public WebElement propCode1;
	
	@FindBy(css="#DashboardGrid_DataTable_row0 > td:nth-child(2) a")
	public WebElement propCode2;
	
	@FindBy(css="#DashboardGrid_DataTable_row0 > td:nth-child(9) a")
	public WebElement leasedetailsrow1;
	
	@FindBy(css="#DashboardGrid_DataTable_row1 > td:nth-child(9) a")
	public WebElement leasedetailsrow2;
	
	@FindBy(css="#DashboardGrid_DataTable > tbody > tr")
	public WebElement unitTable;
	
	@FindBy(css="#Tent_LeaseFrom_TextBox")
	public WebElement unitleaseFromDate;
	
	@FindBy(css="#Tent_LeaseTo_TextBox")
	public WebElement unitleaseToDate;
	
	@FindBy(css="#Tent_Rent_TextBox")
	public WebElement unitleaseRent;
	
	@FindBy(css="#PageButtons_CancelButton_Button")
	public WebElement closeButton;
	
	@FindBy(css="#LeaseFrom_TextBox")
	public WebElement leaseFromDate;
	
	@FindBy(css="#LeaseTo_TextBox")
	public WebElement leaseToDate;
	
	@FindBy(css="#Rent_TextBox")
	public WebElement leaseRent;
	
	@FindBy(css="#FromMMYY_TextBox")
	public WebElement fromDate;
	
	@FindBy(css="#ToMMYY_TextBox")
	public WebElement toDate;
	
	@FindBy(css="#PropertyID_LookupCode")
	public WebElement propertyIDtxt;
	
	@FindBy(css="#BookID_LookupCode")
	public WebElement bookID;
	
	@FindBy(css="#TreeID_LookupCode")
	public WebElement accountTree;
	
	@FindBy(css="#DivAttribute > table > tbody > tr:nth-child(4) > td:nth-child(1) a")
	public WebElement ownerLink;
	
	@FindBy(css="#LookupGrid_filter > label > input[type='text']")
	public WebElement invSearchtxt;
	
	@FindBy(css="#row1 > td.center > input[type='checkbox']")
	public WebElement selectInv;
	
	@FindBy(css="#popupiframe")
	public WebElement ownerAllframe;
	
	@FindBy(css="#cmdOK_Button")
	public WebElement okButton;
	
	@FindBy(css="#mi1")
	public WebElement reportLink;
	
	@FindBy(css="#mi1-1")
	public WebElement reportSUBLink1;
	
	@FindBy(css="#mi1-1-1")
	public WebElement reportSUBLink2;
	
	@FindBy(css="li.ajax-menu-item-first > a[type='side']")
	public WebElement finReportlink;
	
	@FindBy(css="#DivAttribute > table > tbody > tr:nth-child(4) > td:nth-child(2) > input")
	public WebElement ownerTxtbox;
	
	@FindBy(css="#Display_Button")
	public WebElement displayButton;
	
	
	@FindBy(css="#top-menu-wrap > ul.ajax-menu > li:nth-child(6) a")
	public WebElement dashboardLink;
	
	@FindBy(xpath="//a[contains(text(),'Residential')]")
	public WebElement residentialLink;
	
	
	        //Enter Username
			public void EnteruserName(String username)
			{
				userName.clear();
				userName.sendKeys(username);
			}
			
			//Enter Password
			public void EnterPassword(String password)throws Exception
			{
				
				new Actions(driver).moveToElement(Password).click().build().perform(); 
				try{Password.sendKeys(password);}
				catch(Exception e){
					try{
						Thread.sleep(500);
						new Actions(driver).moveToElement(Password).sendKeys(password).build().perform();}
					catch(Exception e1)
					{
						JavascriptExecutor executor = (JavascriptExecutor)driver;
					     executor.executeScript("document.getElementById('Password_Text').value='Yardi888!!'");
					}
		
				}
					//Password.sendKeys(password);}
			}
			
			//Click on Login button
			public void ClickOnLogInButton()
			{
				loginButton.click();
			}
			
			//Enter yardi property id
			public void EnterPropertyid(String propertyid)throws Exception
			{
				
				try{
					new Actions(driver).moveToElement(propertytextbox);
					((JavascriptExecutor)driver).executeScript("arguments[0].value ='';", propertytextbox);	
					propertytextbox.sendKeys(propertyid);
					try{Thread.sleep(1000);}catch(Exception e){}
					new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#Body1 > ul:nth-child(6) > li a"))).click().perform();
					//driver.findElement(By.cssSelector("#Body1 > ul:nth-child(6) > li a")).click();
				}
				catch(Exception e){
					
					new Actions(driver).moveToElement(proptextbox);
					((JavascriptExecutor)driver).executeScript("arguments[0].value ='';", proptextbox);	
					proptextbox.sendKeys(propertyid);
					
				}
			}
			
			public String getPropertyCode()
			{
				String propCode="";
				try{
					propCode=propCode1.getText().trim();
				}
				catch(Exception e){
					try{
						
						Thread.sleep(1000);
						new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#DashboardGrid_DataDiv"))).build().perform();
						propCode=propCode2.getText().trim();
					}
					catch(NoSuchElementException | InterruptedException e2){}
					}
				return propCode;
		}
				
			public String getHomestatus(int unitrow)
			{
				String homeStatus="";
				String cssSelector;
				try{
					
					cssSelector="#DashboardGrid_DataTable_row"+unitrow+" > td:nth-child(3) span";
					homeStatus= driver.findElement(By.cssSelector(cssSelector)).getText().trim();
					
				}
				catch(Exception e){
					try{
						
						Thread.sleep(1000);
						cssSelector="#DashboardGrid_DataTable_row"+unitrow+" > td:nth-child(3) span";
						homeStatus= driver.findElement(By.cssSelector(cssSelector)).getText().trim();
					}
					catch(NoSuchElementException | InterruptedException e2){
						
					}
					}
				return homeStatus;
		}
			
			public String getUnitName(int unitrow)
			{
				String unitName="";
				String cssSelector;
				try{
					
					cssSelector="#DashboardGrid_DataTable_row"+unitrow+" > td:nth-child(1) a";
					unitName= driver.findElement(By.cssSelector(cssSelector)).getText().trim();
					
				}
				catch(Exception e){
					try{
						
						Thread.sleep(1000);
						cssSelector="#DashboardGrid_DataTable_row"+unitrow+" > td:nth-child(1) a";
						unitName= driver.findElement(By.cssSelector(cssSelector)).getText().trim();
					}
					catch(NoSuchElementException | InterruptedException e2){
						
					}
					}
				return unitName;
		}
								
		public void clickOnUnitdetails(int unitrow)	throws Exception
		{
			String cssSelector;
			try{
				
				cssSelector="#DashboardGrid_DataTable_row"+unitrow+" > td:nth-child(4) a";
				driver.findElement(By.cssSelector(cssSelector)).click();
				
			}
			catch(Exception e){
				cssSelector="#DashboardGrid_DataTable_row"+unitrow+" > td:nth-child(4) a";
				new Actions(driver).moveToElement(driver.findElement(By.cssSelector(cssSelector))).click().perform();
		  }
			
		}		
			
		public void clickOnleasedetails(int unitrow)throws Exception
		{
			String cssSelector;
			try{
				
				cssSelector="#DashboardGrid_DataTable_row"+unitrow+" > td:nth-child(4) a";
				driver.findElement(By.cssSelector(cssSelector)).click();
				
			}
			catch(Exception e){
				cssSelector="#DashboardGrid_DataTable_row"+unitrow+" > td:nth-child(4) a";
				new Actions(driver).moveToElement(driver.findElement(By.cssSelector(cssSelector))).click().perform();
		  }
			
		}		
		
		public String getResidentName(int unitrow)
		{
			String cssSelector;
			String residentName;
			try{
				
				cssSelector="#DashboardGrid_DataTable_row"+unitrow+" > td:nth-child(4) a";
				residentName=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				
			}
			catch(Exception e){
				try{
				cssSelector="#DashboardGrid_DataTable_row"+unitrow+" > td:nth-child(4) a";
				new Actions(driver).moveToElement(driver.findElement(By.cssSelector(cssSelector)));
				residentName=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				}
				catch(Exception e1){residentName="";}
				}
			
			return residentName;
		}		
		
		public int getUnitTableSize()
		{
			
			String cssSelector="#DashboardGrid_DataTable > tbody > tr";
			List<WebElement> unitTable= driver.findElements(By.cssSelector(cssSelector));
    		int size=unitTable.size();
    		return size;
			
		}
			
		public void switchToFrame()
		{
			try{
		        	driver.switchTo().frame(frame);
		        }
		        catch(Exception e)
		        {
		          driver.navigate().refresh();
		          try{Thread.sleep(8000);}catch(Exception e1){} 
		          dashboardLink.click();
		          try{Thread.sleep(4000);}catch(Exception e1){}
		      	  residentialLink.click();
		      	try{Thread.sleep(5000);}catch(Exception e1){} 
		          driver.switchTo().frame(frame);
		        }
		}
		
		public String getleaseStatus(String yardiPropertycode)throws Exception
		{
			String leasestatus;
			try
			{
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				leasestatus=leaseStatus.getText().trim();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
			catch(Exception e)
			{
			try{
				
				leasestatus=leaseStatusblank.getText().trim();	
				driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			}
			catch(Exception e1){
				driver.navigate().refresh();
	        	Thread.sleep(9000);
				new Actions(driver).moveToElement(dashboardLink).click().perform();
				 Thread.sleep(4000);
				 residentialLink.click();
				 Thread.sleep(5000);
				 driver.switchTo().frame(frame);
				 EnterPropertyid(yardiPropertycode);
				 try{
						leasestatus=leaseStatus.getText().trim();
				
					}
					catch(Exception e2)
					{
						leasestatus=leaseStatusblank.getText().trim();	
					}
			}
			}
			
			return leasestatus;
		}
		
		public String getTotalIncome()
		{
			String totalIncome="";
			try{
				String cssSelector="#TableWriter1_Row21 > td:nth-child(2)";
				totalIncome=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			catch(Exception e){}
			
			return totalIncome;
		}
		
		public String getTotalExpense()
		{
			String totalExpense="";
			try{
				String cssSelector="#TableWriter1_Row65 > td:nth-child(2)";
				totalExpense=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			catch(Exception e){}
	
			return totalExpense;
		}
		
		public String getNetIncome()
		{
			String netIncome="";
			try{
				String cssSelector="#TableWriter1_Row66 > td:nth-child(2)";
				netIncome=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			}
			catch(Exception e){}
			
			return netIncome;
		}
		
		public String invNotFound()throws Exception
		{
			String msg="";
			String cssSelector="#MessageTableContainer > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr > td:nth-child(2)";
			msg=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			return msg;
			
		}
		
		public String finNotFound()throws Exception
		{
			String msg="";
			String cssSelector="#TableWriter1_Row1 > td";
			msg=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			return msg;
			
		}
		
		public String getTotalDiscountPromotion()
		{
			
			String TotalDiscountPromotion="";
			String cssSelector="#TableWriter1_Row4 > td:nth-child(2) > a";
			try{
				TotalDiscountPromotion=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalDiscountPromotion=driver.findElement(By.cssSelector("#TableWriter1_Row4 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
			}
			return TotalDiscountPromotion;
		}
		
		
		public String getTotalRent()
		{
			
			String TotalRent="";
			String cssSelector="#TableWriter1_Row2 > td:nth-child(2) > a";
			try{
				TotalRent=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalRent=driver.findElement(By.cssSelector("#TableWriter1_Row2 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
			}
			return TotalRent;
		}
		
		public String getTotalRentGuarantee()
		{
			
			String TotalRentGuarantee="";
			String cssSelector="#TableWriter1_Row3 > td:nth-child(2) > a";
			try{
				TotalRentGuarantee=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalRentGuarantee=driver.findElement(By.cssSelector("#TableWriter1_Row3 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
			}
			return TotalRentGuarantee;
		}
		
		
		public String getTotalInsuranceExpense()
		{
			
			String TotalInsuranceExpense="";
			String cssSelector="#TableWriter1_Row52 > td:nth-child(2) > a";
			try{
				TotalInsuranceExpense=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalInsuranceExpense=driver.findElement(By.cssSelector("#TableWriter1_Row52 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
			}
			return TotalInsuranceExpense;
		}
		
		
		public String getTotalInsuranceProvision()
		{
			
			String TotalInsuranceProvision="";
			String cssSelector="#TableWriter1_Row34 > td:nth-child(2) > a";
			try{
				TotalInsuranceProvision=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalInsuranceProvision=driver.findElement(By.cssSelector("#TableWriter1_Row34 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
			}
			return TotalInsuranceProvision;
		}
		
		public String getTotalLeasingFeeHU()
		{
			
			String TotalLeasingFeeHU="";
			String cssSelector="#TableWriter1_Row26 > td:nth-child(2) > a";
			try{
				TotalLeasingFeeHU=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalLeasingFeeHU=driver.findElement(By.cssSelector("#TableWriter1_Row26 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
			}
			return TotalLeasingFeeHU;
		}
		
		
		public String getTotalPrepaidPropManagementFeesHU()
		{
			
			String TotalPrepaidPropManagementFeesHU="";
			String cssSelector="#TableWriter1_Row40 > td:nth-child(2) > a";
			try{
				TotalPrepaidPropManagementFeesHU=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalPrepaidPropManagementFeesHU=driver.findElement(By.cssSelector("#TableWriter1_Row40 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
			}
			return TotalPrepaidPropManagementFeesHU;
		}
		
		
		public String getTotalPropManagementFeesHU()
		{
			
			String TotalPropManagementFeesHU="";
			String cssSelector="#TableWriter1_Row41 > td:nth-child(2) > a";
			try{
				TotalPropManagementFeesHU=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalPropManagementFeesHU=driver.findElement(By.cssSelector("#TableWriter1_Row41 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
			}
			return TotalPropManagementFeesHU;
		}
		
		public String getTotalPropManagementFeesHUHISTORY()
		{
			
			String TotalPropManagementFeesHUHISTORY="";
			String cssSelector="#TableWriter1_Row39 > td:nth-child(2) > a";
			try{
				TotalPropManagementFeesHUHISTORY=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalPropManagementFeesHUHISTORY=driver.findElement(By.cssSelector("#TableWriter1_Row39 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
			}
			return TotalPropManagementFeesHUHISTORY;
		}
		
		
		public String getTotalPropertyTaxExpense()
		{
			
			String TotalPropertyTaxExpense="";
			String cssSelector="#TableWriter1_Row54 > td:nth-child(2) > a";
			try{
				TotalPropertyTaxExpense=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalPropertyTaxExpense=driver.findElement(By.cssSelector("#TableWriter1_Row54 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
			}
			return TotalPropertyTaxExpense;
		}
		
		
		public String getTotalPropertyTaxProvision()
		{
			
			String TotalPropertyTaxProvision="";
			String cssSelector="#TableWriter1_Row33 > td:nth-child(2) > a";
			try{
				TotalPropertyTaxProvision=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalPropertyTaxProvision=driver.findElement(By.cssSelector("#TableWriter1_Row33 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
				
			}
			return TotalPropertyTaxProvision;
		}
		
		
		public String getTotalRepairsExpense()
		{
			
			String TotalRepairsExpense="";
			String cssSelector="#TableWriter1_Row55 > td:nth-child(2) > a";
			try{
				TotalRepairsExpense=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalRepairsExpense=driver.findElement(By.cssSelector("#TableWriter1_Row55 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
				
			}
			return TotalRepairsExpense;
		}
		
		
		public String getTotalUtilityExpenses()
		{
			
			String TotalUtilityExpenses="";
			String cssSelector="#TableWriter1_Row64 > td:nth-child(2)";
			try{
				TotalUtilityExpenses=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalUtilityExpenses=driver.findElement(By.cssSelector("#TableWriter1_Row64 > td:nth-child(2) > a")).getText();
				}catch(Exception e1){}
				
			}
			return TotalUtilityExpenses;
		}
		
		public String getTotalCleaningandMaintenance()
		{
			
			String TotalCleaningandMaintenance="";
			String cssSelector="#TableWriter1_Row48 > td:nth-child(2) > a";
			try{
				TotalCleaningandMaintenance=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalCleaningandMaintenance=driver.findElement(By.cssSelector("#TableWriter1_Row48 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
				
			}
			return TotalCleaningandMaintenance;
		}
		
		public String getTotalLegalandProfessional()
		{
			
			String TotalLegalandProfessional="";
			String cssSelector="#TableWriter1_Row44 > td:nth-child(2) > a";
			try{
				TotalLegalandProfessional=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalLegalandProfessional=driver.findElement(By.cssSelector("#TableWriter1_Row44 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
				
			}
			return TotalLegalandProfessional;
		}
		
		public String getTotalPropManagementFees()
		{
			
			String TotalPropManagementFees="";
			String cssSelector="#TableWriter1_Row38 > td:nth-child(2) > a";
			try{
				TotalPropManagementFees=driver.findElement(By.cssSelector(cssSelector)).getText();
			}catch(Exception e){
				try{
					TotalPropManagementFees=driver.findElement(By.cssSelector("#TableWriter1_Row38 > td:nth-child(2)")).getText();
				}catch(Exception e1){}
				
			}
			return TotalPropManagementFees;
		}
}
