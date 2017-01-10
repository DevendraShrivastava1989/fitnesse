package pageFactory.InvestorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class UserSearch {
	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public UserSearch(WebDriver driver)
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
	
	@FindBy(css="input#searchEmail")
	public WebElement emailField;
	
	@FindBy(css="button#userSearchBtn")
	public WebElement searchButton;
	
	@FindBy(css="#user_results > tbody")
	public WebElement searchTable;
	
	public String getSearchData(int row,int column)
	{
		String invFirstname;
		String cssSelector="#user_results > tbody tr:nth-of-type("+row+") td:nth-of-type("+column+")";
		invFirstname=driver.findElement(By.cssSelector(cssSelector)).getText().trim();
		return invFirstname;
	}
	
	public void click_OnSearchtableData(int row,int column)
	{
		String cssSelector="#user_results > tbody tr:nth-of-type("+row+") td:nth-of-type("+column+") a";
		//new Actions(driver).moveToElement(driver.findElement(By.cssSelector(cssSelector))).click().perform();
		try{
		driver.findElement(By.cssSelector(cssSelector)).click();
		
		}
		catch(Exception e){
			try{JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(cssSelector)));
			}catch(Exception e1){e1.printStackTrace();}
			
		}
		try{Thread.sleep(3000);}catch(Exception e){}
	}
	
}
