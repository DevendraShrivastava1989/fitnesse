package pageFactory.InvestorPortal_Mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class Menu {

	

		WebDriver driver;
		JavaHelpers JH = new JavaHelpers();
		
		public Menu(WebDriver driver)
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
		  @FindBy(xpath="//a[@href='#login']")
	      WebElement LOGIN;
		
		  @FindBy(xpath="//a[@href='#property-search']")
	      WebElement PROPERTY_SEARCH;
		  
		  @FindBy(xpath="//a[@href='#watchlist']")
	      WebElement WATCHLIST;
		  
		  @FindBy(xpath="//a[@href='#transactions']")
	      WebElement TRANSACTIONS;

	      @FindBy(xpath="//div[@class='accountDetailsWrap']/ul/li[3]/a")
	      WebElement LOGOUT;
		
		
			//Click on Login link in menu
			public void ClickOnLoginLink()
			{
			  LOGIN.click();
			}
			
			//Click on PROPERTY SEARCH link in menu
			public void ClickOnPropertySearch()
			{
				PROPERTY_SEARCH.click();
			}
			
			//Click on WATCH LIST link in menu
			public void ClickOnWatchList()
			{
				WATCHLIST.click();
			}
			
			//Click on Transactions link in menu
			public void ClickOnTransactionsLink()
			{
				TRANSACTIONS.click();
			}

			//Click on Log Out link in menu
			public void ClickOnLogOutLink()
			{
				LOGOUT.click();
			}
			
			
			
	}


