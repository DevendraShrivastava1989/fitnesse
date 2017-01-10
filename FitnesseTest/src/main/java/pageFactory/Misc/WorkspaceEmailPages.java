package pageFactory.Misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class WorkspaceEmailPages 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public WorkspaceEmailPages(WebDriver driver)
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
	
		//Login - https://login.secureserver.net/index.php?app=wbe&logout=1
	
		@FindBy(id="username")
	    public WebElement Username;
		
		@FindBy(id="password")
	    public WebElement Password;
		
		@FindBy(id="submitBtn")
	    public WebElement Login;
		
		public void LoginToWSEmail(String username, String password) throws InterruptedException
		{
			Username.sendKeys(username);
			Password.sendKeys(password);
			Login.click();
			Thread.sleep(5000);
		}
		
		public String GetEmailSubject(int i)
		{
			String cssSelector="form#frm_mail_index tbody tr:nth-of-type(" + (i+1)+ ") td:nth-of-type(3) span";
			return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
		}
		
		public void OpenEmail(int i) throws InterruptedException
		{
			
			//Click on Preview if disabled
			if(driver.findElement(By.id("preview_scroller")).getAttribute("style").contains("height: 0px;"))
			{
				driver.findElement(By.id("preview_expander")).click();
				Thread.sleep(5000);
			}
			
			String cssSelector="form#frm_mail_index tbody tr:nth-of-type(" + (i+1)+ ") td:nth-of-type(3)";
			driver.findElement(By.cssSelector(cssSelector)).click();
			Thread.sleep(5000);
		
			
		}
		
		// Email body
		@FindBy(css="#wmMessage > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(2) > td > table:nth-child(1) > tbody > tr:nth-child(2) > td > table:nth-child(2) > tbody > tr > td > p:nth-child(2) > a")
	    public WebElement ActivationLink;
		

		@FindBy(css="#wmMessage > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(2) > td > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(4) > td > a")
	    public WebElement ResetPasswordLink;
		
		@FindBy(css="#wmMessage > p:nth-child(3) > a")
	    public WebElement SingnatureLink;
		
	
}
