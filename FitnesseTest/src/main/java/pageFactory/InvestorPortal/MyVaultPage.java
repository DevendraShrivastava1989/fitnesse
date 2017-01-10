package pageFactory.InvestorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class MyVaultPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public MyVaultPage(WebDriver driver)
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
		
		//Tabs
			@FindBy(css="ul#evCabinet li:nth-of-type(1) a")
		    public WebElement Investment_Tab;
			
			@FindBy(css="ul#evCabinet li:nth-of-type(2) a")
		    public WebElement HomeUnionAgreements_Tab;

			@FindBy(css="ul#evCabinet li:nth-of-type(3) a")
		    public WebElement CurrentHome_Tab;
			
			@FindBy(css="ul#evCabinet li:nth-of-type(4) a")
		    public WebElement PersonalDocuments_Tab;
		
			
	
		
	
}
