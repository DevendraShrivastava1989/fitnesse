package pageFactory.Misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.List;
import utility.JavaHelpers;

public class PropertyWare {

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public PropertyWare(WebDriver driver)
	{	 
        this.driver = driver;
 
        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
	@FindBy(css="input#loginEmail")
    public WebElement userName;
	
	@FindBy(css="#main-content > aside > div > form > div:nth-child(2) > input")
    public WebElement Password;
	
	@FindBy(css="#main-content > aside > div > form > input.button")
    public WebElement loginButton;
	
	@FindBy(css="#appHeader > ul > li.tabLblReports > a")
    public WebElement reportLink;
	
	@FindBy(css="#recent_item_div > table > tbody > tr:nth-child(1) > td:nth-child(2) a")
    public WebElement ownerStmtReport;
	
	@FindBy(css="div.x-tab-panel-tbar table.x-toolbar-ct > tbody > tr > td.x-toolbar-left > table > tbody > tr > td:nth-child(5) em")
    public WebElement filterButton;
	
	@FindBy(xpath="//*[@id='entity.dateRangeStart']")
    public WebElement fromDate;
	
	@FindBy(xpath="//*[@id='entity.dateRangeEnd']")
    public WebElement toDate;
	
	@FindBy(css="div#filtersForm div.x-fieldset-bwrap > div.x-fieldset-body #buttonsPortfolios table:nth-child(2) em")
    public WebElement noneButton;
	
	@FindBy(css="div#reportFilterWindow div.x-window-bl table table > tbody table > tbody > tr > td:nth-child(1) > table > tbody > tr em > button")
    public WebElement applyButton;
	
	@FindBy(css="div#reportFilterWindow div.x-window-bl table table > tbody table > tbody > tr > td:nth-child(2) > table > tbody > tr em")
    public WebElement cancelButton;
	
	@FindBy(css="div.x-combo-list-inner > div.x-combo-list-item:nth-of-type(1) > span[class='']")
    public WebElement selectInv;
	
	@FindBy(css="#reportData > table:nth-child(4) > tbody > tr > td.statementOwnerAddress > span:nth-child(1)")
	public WebElement reportInvName;
	
	@FindBy(css="input#searchPortfolios")
    public WebElement searchPortfolio;
	
	@FindBy(id="ext-comp-1034")
    public WebElement dateOptions;
	
	@FindBy(css="div.x-combo-list-inner > div.x-combo-list-item:nth-child(1)")
    public WebElement customDateRange;
	
	@FindBy(css="div.x-panel-body.x-panel-body-noheader > ul.x-tree-root-ct.x-tree-lines > div > li:nth-child(10) span[a='Owner Statements']")
    public WebElement ownerstmtfolder;
	
	@FindBy(css="div.x-panel-body.x-panel-body-noheader > ul.x-tree-root-ct.x-tree-lines > div > li:nth-child(10) > ul > li:nth-child(99) a")
    public WebElement ownerstmtdetailslink;
	
	@FindBy(css="#galleryMainPaneContent > div > table.reportBody > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(2) img")
    public WebElement ownerstmtdetailsreportlink;

	
	  //Enter Username
	public void EnteruserName(String username)
	{
		userName.clear();
		userName.sendKeys(username);
	}
	
	//Enter Password
	public void EnterPassword(String password)throws Exception
	{
		Password.clear();
		Password.sendKeys(password);
	
	}
	
	//Click on Login button
	public void ClickOnLogInButton()
	{
		loginButton.click();
	}
	
	public String getTotalIncome()
	{
		String totalIncome="";
		String cssSelector="#reportData > table:nth-child(10) > tfoot > tr > td:nth-child(3)";
		try{
		totalIncome=driver.findElement(By.cssSelector(cssSelector)).getText();
		}catch(Exception e){}
		
		return totalIncome;
	}
	
	public String getTotalExpense()
	{
		String totalExpense="";
		String cssSelector="#reportData > table:nth-child(13) > tfoot > tr > td:nth-child(3)";
		try{
			totalExpense=driver.findElement(By.cssSelector(cssSelector)).getText();
		}catch(Exception e){}
		
		return totalExpense;
	
	}
	
	public String getNetIncome()
	{
		
		String NetIncome="";
		String cssSelector="#reportData > table:nth-child(16) > tfoot > tr > td:nth-child(3)";
		try{
			NetIncome=driver.findElement(By.cssSelector(cssSelector)).getText();
		}catch(Exception e){}
		return NetIncome;
	}
	
	public String getSubtotalExpense(int i)
	{
		String cssSelector="#reportData > table:nth-child(13) > tbody > tr.subtotal > td:nth-child(2)";
		String subtotalValue="";
		try{
		List<WebElement> allSubtotal=driver.findElements(By.cssSelector(cssSelector));
		int size=allSubtotal.size();
		subtotalValue=allSubtotal.get(i).getText().trim();
		}
		catch(Exception e){}
		return subtotalValue;
	}
	
	public String getSubtotalIncome(int i)
	{
		String cssSelector="#reportData > table:nth-child(10) > tbody > tr.subtotal > td:nth-child(2)";
		String subtotalValue="";
		try{
		List<WebElement> allSubtotal=driver.findElements(By.cssSelector(cssSelector));
		int size=allSubtotal.size();
		subtotalValue=allSubtotal.get(i).getText().trim();
		}
		catch(Exception e){}
		return subtotalValue;
	}
}
