package pageFactory.InvestorPortal;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.JavaHelpers;

public class PerformancePage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	int timeOutseconds=8;
	public PerformancePage(WebDriver driver)
	{	 
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOutseconds), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
		@FindBy(css="h1.page-title")
	    public WebElement PageHeader;
		
		//Tabs
			@FindBy(css="ul.nav-tabs li:nth-of-type(1) a")
		    public WebElement InvestmentSummary_Tab;
			
			@FindBy(css="ul.nav-tabs li:nth-of-type(2) a")
		    public WebElement IncomeStatement_Tab;
			
			@FindBy(css="#sidebar > li:nth-child(2) > a span")
		    public WebElement IncomeStatementTab;
			
			@FindBy(css="ul.nav-tabs li:nth-of-type(3) a")
		    public WebElement TransactionDetails_Tab;
			
			@FindBy(css="#sidebar > li:nth-child(3) > a span")
		    public WebElement TransactionDetailsTab;
			
			
			@FindBy(css="#transHistoryCalendar > div:nth-child(2) > span > i")
			public WebElement calendarIcon;
			
			@FindBy(xpath="//*[@id='transHistoryCalendar']/div[2]/span[3]/i")
			public WebElement calIcon;
			
			
			@FindBy(css="body > div.daterangepicker.dropdown-menu.ltr.show-calendar.opensleft > div.ranges > ul > li:nth-child(2)")
			public WebElement selectLastMonth;
			
			@FindBy(css="body > div.daterangepicker.dropdown-menu.ltr.show-calendar.opensleft > div.ranges > div > button.applyBtn.btn.btn-sm.btn-success")
			public WebElement Applybutton;
			
			
			@FindBy(css="#navbar > div.nav-menu-wrap > ul.nav.navbar-nav.pull-right > li.active > a")
			public WebElement Performanceheader;
			
			@FindBy(css="#tab-inv-summary > div.port-summary.container.spacing--bottom-25.investContr > section:nth-child(3) > h1")
		    public WebElement totalPURCHASEPRICE;
			
			@FindBy(css="#tab-inv-summary > div.port-summary.container.spacing--bottom-25.investContr > section:nth-child(4) > h1")
		    public WebElement totalINVESTMENT;
			
			@FindBy(css="#tab-inv-summary > div.port-summary.container.spacing--bottom-25.investContr > section:nth-child(5) > h1")
		    public WebElement totalCASHFLOW;
			
			
			public int getInvestmentTableSize()
			{
				//String cssSelector="#tab-inv-summary > div.investment-summary-conatainer.color--blue-dark > div > div > table > tbody > tr";
				 
				String cssSelector="#inv-summary-data > div.addInvestProp.col-sm-12.no-gutter > div.col-md-12.no-gutter.hideInMobile > div.col-md-10.col-sm-12.col-lg-10.listing.clearfix.inv-property";
				List<WebElement> investmentTable= driver.findElements(By.cssSelector(cssSelector));
	    		 int size=investmentTable.size();
	    		 return size;
			}
		
		public String getPURCHASE_PRICE(int row)throws Exception
		{
			//String cssSelector="#tab-inv-summary > div.investment-summary-conatainer.color--blue-dark > div > div > table > tbody > tr:nth-child("+row+") > td:nth-child(2) > h6";
			String cssSelector="#inv-summary-data > div.addInvestProp > div > div:nth-child("+row+") > div.slideUnitDetail > div > div:nth-child(1) > section.m-t-53 > ul > li:nth-child(1) > span";
			
			//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			String purchasePRICE=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			//driver.manage().timeouts().implicitlyWait(timeOutseconds, TimeUnit.SECONDS);
			return purchasePRICE;
		}
		
		public String getINVESTMENTAmount(int row)throws Exception
		{
			String cssSelector="#tab-inv-summary > div.investment-summary-conatainer.color--blue-dark > div > div > table > tbody > tr:nth-child("+row+") > td:nth-child(3) > h6";
			String investmentAmount=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			return investmentAmount;
		
		}
		
		public String getRENTALSTATUS(int row)throws Exception
		{
			
			String cssSelector="#inv-summary-data > div.addInvestProp > div.col-md-12 > div:nth-child("+row+") > div.propsec > div.propdet > div.pull-left";
			String rentalStatus=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			return rentalStatus;
		
		}
		
		public String getRENT(int row)throws Exception
		{
			String cssSelector="#tab-inv-summary > div.investment-summary-conatainer.color--blue-dark > div > div > table > tbody > tr:nth-child("+row+") > td:nth-child(5) > h6";
			String rent=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			return rent;
		
		}
		
		public String getCASHFLOW(int row)throws Exception
		{
			String cssSelector="#tab-inv-summary > div.investment-summary-conatainer.color--blue-dark > div > div > table > tbody > tr:nth-child("+row+") > td:nth-child(6) > h6";
			String cashFlow=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			return cashFlow;
		
		}
		
		public String getNETINCOME(int row)throws Exception
		{
			String cssSelector="#tab-inv-summary > div.investment-summary-conatainer.color--blue-dark > div > div > table > tbody > tr:nth-child("+row+") > td:nth-child(7) > h6";
			String netINCOME=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			return netINCOME;
		
		}
		
		
		public String getANNUALIZEDYIELD(int row)throws Exception
		{
			String cssSelector="#tab-inv-summary > div.investment-summary-conatainer.color--blue-dark > div > div > table > tbody > tr:nth-child("+row+") > td:nth-child(8) > h6";
			String annualizedYIELD=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			return annualizedYIELD;
		
		}
		
		public String getPurchaseDate(int row)throws Exception
		{
			String purchaseDate;
			//String cssSelector="#tab-inv-summary > div.investment-summary-conatainer.color--blue-dark > div > div > table > tbody > tr:nth-of-type("+row+") td:nth-of-type(1) div:nth-of-type(2) p:nth-of-type(3)";
			String cssSelector="#inv-summary-data > div.addInvestProp > div.col-md-12 > div:nth-child("+row+") > div.slideUnitDetail > div > div:nth-child(1) > section.f-12.spacing--bottom-15.text-center.m-t-15 > span";
			try{ 
				purchaseDate=driver.findElement(By.cssSelector(cssSelector)).getText().trim();}
				//purchaseDate=driver.findElement(By.cssSelector(cssSelector)).getAttribute("Purchase Date:");}
			catch(Exception e){
				purchaseDate=driver.findElement(By.cssSelector(cssSelector)).getText().trim();}
			
			return purchaseDate;
		
		}
		
		public String getLeasedRent(int row)throws Exception
		{
			String leasedRent;
			String cssSelector="#tab-inv-summary > div.investment-summary-conatainer.color--blue-dark > div > div > table > tbody > tr:nth-of-type("+row+") td:nth-of-type(1) div:nth-of-type(2) p:nth-of-type(4)";
			try{ 
				leasedRent=driver.findElement(By.cssSelector(cssSelector)).getText().trim();}
			catch(Exception e){
				leasedRent=driver.findElement(By.cssSelector(cssSelector)).getText().trim();}
			
			return leasedRent;
		
		}
		
		public String getpropertyAddress(int row)throws Exception
		{
			String propAddress;
			String cssSelector="#inv-summary-data > div.addInvestProp > div.col-md-12 > div:nth-child("+row+") > div.propsec > div.propdet > h4";
			try{ 
				propAddress=driver.findElement(By.cssSelector(cssSelector)).getText().trim();}
			catch(Exception e){
				propAddress=driver.findElement(By.cssSelector(cssSelector)).getText().trim();}
			
			return propAddress;
		
		}
		
		public String getpropertyID(int row)throws Exception
		{
			String propertyID;
			String cssSelector="#inv-summary-data > div.addInvestProp.col-sm-12.no-gutter > div.col-md-12.no-gutter.hideInMobile > div:nth-child("+row+")";
			try{ 
				propertyID=driver.findElement(By.cssSelector(cssSelector)).getAttribute("data-prop-id").trim();}
			catch(Exception e){
				propertyID=driver.findElement(By.cssSelector(cssSelector)).getAttribute("data-prop-id").trim();}
			
			return propertyID;
		
		}
		
		 public int getUnitrow(int row,String propID)
		 {
			 int size;
			 String cssSelector="#inv-summary-data > div.addInvestProp > div.col-md-12 > div:nth-child("+row+") > div.slideUnitDetail > div > div.pull-left > div > table > tbody > tr";
					 try{ 
			 List<WebElement> unitrow=driver.findElements(By.cssSelector(cssSelector));
			 size=unitrow.size(); 
		       }catch(Exception e) {size=0;}
					
		 return size;
		 }
		
		 public String getunitName(int row,int unitRow)
		 {
			 String cssSelector="#inv-summary-data > div.addInvestProp > div.col-md-12 > div:nth-child("+row+") > div.slideUnitDetail > div > div.pull-left > div > table > tbody > tr:nth-child("+unitRow+") > td:nth-child(1) > h6";
			 String unitName="";
			 try{  
				 unitName=driver.findElement(By.cssSelector(cssSelector)).getText().trim();	  
			 }catch(Exception e){
				 	 e.printStackTrace();}
			 return unitName;
		 }
		 public String getunitRentalStatus(int row,int unitRow)
		 {
			 String cssSelector="#inv-summary-data > div.addInvestProp > div.col-md-12 > div:nth-child("+row+") > div.slideUnitDetail > div > div.pull-left > div > table > tbody > tr:nth-child("+unitRow+") > td:nth-child(3) > span";
			 String unitRentalStatus="";
			 try{ 
				 unitRentalStatus=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
			 }catch(Exception e) {}
			 return unitRentalStatus;
		 }
		 public String getunitRent(int row,int unitRow)
		 {
			 String unitRent="";
			 String cssSelector="#inv-summary-data > div.addInvestProp > div.col-md-12 > div:nth-child("+row+") > div.slideUnitDetail > div > div.pull-left > div > table > tbody > tr:nth-child("+unitRow+") > td:nth-child(2) > span";
			 try{ 
				unitRent=driver.findElement(By.cssSelector(cssSelector)).getText().trim(); 
			 }catch(Exception e) {}
			 return unitRent;
		 }
		 
public void clickviewUnitDetail(int row)
{
	String cssSelector="#inv-summary-data > div.addInvestProp > div.col-md-12 > div:nth-child("+row+") > div.propsec > div.propdet > div.pull-right > a";
	try{ 
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep(5000);
		}
	catch(Exception e){
		try{JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(cssSelector)));
		Thread.sleep(5000);
		}catch(Exception e1){e1.printStackTrace();}
		
	}
  } 

public void gotoLastPage()
{
	
	//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); 
	String cssSelector="#incomeStatementTable > thead.tableFloatingHeaderOriginal > tr > th.text-center > div > ul > li";
	 List<WebElement> investmentTable= driver.findElements(By.cssSelector(cssSelector));
	 int size=investmentTable.size();
	 //System.out.println("size = " + size);
	 if(size > 0){
	 cssSelector="#incomeStatementTable > thead.tableFloatingHeaderOriginal > tr > th.text-center > div > ul > li:nth-child("+size+")";
      try{ driver.findElement(By.cssSelector(cssSelector)).click();
      Thread.sleep(3000);
      }catch(Exception e){
    	  JavascriptExecutor executor = (JavascriptExecutor)driver;
  		executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(cssSelector)));
  	     try{Thread.sleep(3000);}catch(Exception e1){}
      }
	 }
	 //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); 
}

public int getIncome_statementTableSize()
{
	 int size;
	 String cssSelector="#incomeStatementTable > tbody > tr";
			 try{ 
	 List<WebElement> unitrow=driver.findElements(By.cssSelector(cssSelector));
	 size=unitrow.size(); 
      }catch(Exception e) {size=0;}
			
return size;
}

public int getIncome_statementpreviousMonth()
{
	 int size;
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child(1) > td";
	 try{ 
	 List<WebElement> unitrow=driver.findElements(By.cssSelector(cssSelector)); try{Thread.sleep(3000);}catch(Exception e){} 
	 size=unitrow.size() - 1; 
	 //size=size-1;
      }catch(Exception e) {size=0;}
			
return size;
}

public String getRentalIncome(int row,int column) throws Exception{
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String RentalIncome=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return RentalIncome;
}
public String getOtherIncome(int row,int column)throws Exception{
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String OtherIncome=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return OtherIncome;
}
public String getTOTALINCOME(int row,int column)throws Exception{
	
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String TOTALINCOME=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return TOTALINCOME;
}
public String getEXPENSES_paid_byHomeUnion(int row,int column)throws Exception{
	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String EXPENSES_paid_byHomeUnion=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return EXPENSES_paid_byHomeUnion;
}
public String getexpPropertyTax(int row,int column)throws Exception{
	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String expPropertyTax=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return expPropertyTax;
}
public String getexpPropertyInsurance(int row,int column)throws Exception{
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String expPropertyInsurance=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return expPropertyInsurance;
	
}
public String getHOA(int row,int column)throws Exception{
	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String HOA=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return HOA;
}
public String getLeasingFees(int row,int column)throws Exception{
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String LeasingFees=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return LeasingFees;
}
public String getAssetManagementFees(int row,int column)throws Exception{
	
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String AssetManagementFees=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return AssetManagementFees;
	
}
public String getRepairsMaintenance(int row,int column)throws Exception{
	
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String RepairsMaintenance=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return RepairsMaintenance;
	
}
public String getProvisionReserves(int row,int column)throws Exception{
	
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String ProvisionReserves=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return ProvisionReserves;
	
}
public String getUtilities(int row,int column)throws Exception{
	
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String Utilities=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return Utilities;
	
}
public String getOtherExpenses(int row,int column)throws Exception{
	
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String OtherExpenses=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return OtherExpenses;
}
public String getTOTALEXPENSES_paidbyHomeUnion(int row,int column)throws Exception{
	
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String TOTALEXPENSES_paidbyHomeUnion=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return TOTALEXPENSES_paidbyHomeUnion;	
	
}
public String getNETOPERATINGINCOME_HomeUnion(int row,int column)throws Exception{
	
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String NETOPERATINGINCOME_HomeUnion=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return NETOPERATINGINCOME_HomeUnion;	
	
}
public String getAdjustmentsOwner_PaidExpenses(int row,int column)throws Exception{
	
	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String AdjustmentsOwner_PaidExpenses=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return AdjustmentsOwner_PaidExpenses;
	
}

public String getLoanInterest(int row,int column)throws Exception{
	
	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String LoanInterest=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return LoanInterest;
	
}
public String getPropertyTaxpaid_by_HomeUnion(int row,int column)throws Exception{
	
	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String PropertyTaxpaid_by_HomeUnion=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return PropertyTaxpaid_by_HomeUnion;
	
}
public String getPropertyInsurance_through_HomeUnion(int row,int column)throws Exception{
	
	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String PropertyInsurance_through_HomeUnion=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return PropertyInsurance_through_HomeUnion;
	
	
}
public String getNETINCOME(int row,int column)throws Exception{
	
	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String NETINCOME=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return NETINCOME;
	
}

public String getYIELDPeriod(int row,int column)throws Exception{
	
	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String YIELDPeriod=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return YIELDPeriod;
	
}
public String getYIELDAnnualized(int row,int column)throws Exception{
	
	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String YIELDAnnualized=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return YIELDAnnualized;
	
}
public String getOwnerPaidLoanPrincipal(int row,int column)throws Exception{

	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String OwnerPaidLoanPrincipal=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return OwnerPaidLoanPrincipal;
		
}
public String getCASHFLOW(int row,int column)throws Exception{
	
	 String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String CASHFLOW=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return CASHFLOW;
	
}
public String getCashOnCashReturn_Annualized(int row,int column)throws Exception{
	String cssSelector="#incomeStatementTable > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String CashOnCashReturn_Annualized=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return CashOnCashReturn_Annualized;
	
}

public String getPreviousMonthYear(int column)throws Exception{
	String cssSelector="#incomeStatementTable > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+column+")";
	 String PreviousMonthYear=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return PreviousMonthYear;
	
}

public int gettransactionTableSize()
{
	//String cssSelector="#tab-inv-summary > div.investment-summary-conatainer.color--blue-dark > div > div > table > tbody > tr";
	 
	String cssSelector="#tab-trans-history > div > div > div.transaction-table > table > tbody > tr";
	List<WebElement> transactionTable= driver.findElements(By.cssSelector(cssSelector));
	 int size=transactionTable.size();
	 return size;
}

public String getTransactionDate(int row,int column)
{
     String cssSelector="#tab-trans-history > div > div > div.transaction-table > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String transactionDate=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return transactionDate;

}

public String getTransactionDescription(int row,int column)
{
     String cssSelector="#tab-trans-history > div > div > div.transaction-table > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	 String transactionDescription=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	 return transactionDescription;

}

public String getTransactionDeposit(int row,int column)
{

	  String cssSelector="#tab-trans-history > div > div > div.transaction-table > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	  String transactionDeposit=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	  return transactionDeposit;

}

public String getTransactionWithdraw(int row,int column)
{

	  String cssSelector="#tab-trans-history > div > div > div.transaction-table > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
	  String transactionWithdraw=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	  return transactionWithdraw;

}

public void transactiontabClick() throws Exception
{
	
	try {TransactionDetails_Tab.click(); }
	   catch (Exception e){try {
	   Thread.sleep(2000);	
	   new Actions(driver).moveToElement(TransactionDetailsTab).click().perform();}
	   catch(Exception e2){
	   JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();",TransactionDetailsTab);}}

}

public void calendarIconClick() throws Exception
{
	 try{calendarIcon.click();}
     catch(Exception e){try {new Actions(driver).moveToElement(calendarIcon).click().perform();}
     catch(Exception e1){JavascriptExecutor executor = (JavascriptExecutor)driver;
	   executor.executeScript("arguments[0].click();",calIcon);}}
}


public int returnMonth(String month)
{	
	int monthint=0;
	
	switch(month)
	{
	case "JAN": 
	    monthint=1;break;
	
	case "FEB": 
	    monthint=2;break;
		
	case "MAR": 
		monthint=3;break;
	
	case "APR": 
		monthint=4;break;
	
	case "MAY": 
		monthint=5;break;
		
	case "JUN": 
		monthint=6;break;
	
	case "JUL": 
		monthint=7;break;
		
	case "AUG": 
		monthint=8;break;
		
	case "SEP": 
		monthint=9;break;
		
	case "OCT": 
		monthint=10;break;
		
	case "NOV": 
		monthint=11;break;
		
	case "DEC": 
		monthint=12;break;
	
	}
	
	return monthint;
}

}
