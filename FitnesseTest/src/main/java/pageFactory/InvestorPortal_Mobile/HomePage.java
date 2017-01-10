package pageFactory.InvestorPortal_Mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class HomePage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public HomePage(WebDriver driver)
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
	
	@FindBy(xpath="//*[@id='main-wrap']/div[1]/div/div/div[1]/button")	
    WebElement MENU;
	
	//Click on menu icon
		public void ClickOnMenuIcon()
		{
			MENU.click();
		}
			
		@FindBy(xpath="//div[@id='main-wrap']/div[1]/div/div/div[1]/button")	
		WebElement MENU_IPNew;
			
		//Click on menu_IPNew icon
		public void ClickOnMENU_IPNew()
		{
		MENU_IPNew.click();
		}	
		
		@FindBy(xpath="//a[@href='#login']")
	    WebElement LOGIN;
		
		@FindBy(xpath="//a[href='#register']")
	    WebElement SIGN_UP;
		
		//Click on Login link
		public void ClickOnLoginLink()
		{
			LOGIN.click();
		}
		
		//Click on Sign Up link
		public void ClickOnSignUpLink()
		{
		   SIGN_UP.click();
		}
		
		
		
		
}

