package pageFactory.Misc;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constants;
import utility.JavaHelpers;

public class InvestorPortalDrule {
	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public InvestorPortalDrule(WebDriver driver)
	{	 
        this.driver = driver;
 
        //This initElements method will create all WebElements
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.WebDriverWaitDuration), this);
	}
	
	//http://192.168.10.13/hu-platform/#/ruleUpload
		//homeunion / homeunion123
	
    @FindBy(id="hilName")
    public WebElement hilname;
    
    @FindBy( id="source")
    public WebElement mlsname;
    
    @FindBy( id="propertyType")
    public WebElement propertyType;
   
    @FindBy(id="propertyTypeCode")
    public WebElement propertyTypeCode;
    
    @FindBy(id="price")
    public WebElement price;
    
    @FindBy(id="rehabCost" )
    public WebElement rehabCost;
    
    @FindBy(id="rent")
    public WebElement rent;
    
    @FindBy(id="tax" )
    public WebElement tax;
    
    @FindBy(id="insuranceOccupied" )
    public WebElement insuranceOccupied;
    
    @FindBy(id="hoa")
    public WebElement hoa; 
    
    @FindBy(id="zillowAppr")
    public WebElement zillowAppr;
    
    @FindBy(id="calcFreezeDate")
    public WebElement calcFreezeDate;
    
    @FindBy(id="zip")
    public WebElement zip;
    
    @FindBy(id="nir")
    public WebElement nir;
    
    @FindBy(id="projectionTerm")
    public WebElement projectionTerm;
    
    @FindBy(id="body > div > div > div.container-fluid > div:nth-child(2) > div > div:nth-child(4) > button.btn.btn-warning")
    public WebElement TestRules;
    
  //Click on TestRules link
	public void ClickOnLoginLink() throws InterruptedException
	{
		TestRules.click();
		Thread.sleep(4000);
	}
    
}  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	

