package pageFactory.InvestorPortal_Mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class SDIRAPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public SDIRAPage(WebDriver driver)
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
	
		@FindBy(css="h1.page-title")
	    public WebElement PageHeader;
		
		@FindBy(css="a.sdira")
	    public WebElement OpenAnSDIRAAccount;
		
		@FindBy(id="main-cont")
	    public WebElement PageText;
		
	
}
