package pageFactory.Embrace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class LoginPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public LoginPage(WebDriver driver)
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
	
		@FindBy(name="username")
	    WebElement Username;
		
		@FindBy(name="password")
	    WebElement Password;
		
		@FindBy(id="submit")
	    WebElement Login;
		
		@FindBy(css = "#header div.header-inner ul.nav.navbar-nav.pull-right li:nth-of-type(3) a.dropdown-toggle")
	    private WebElement logout_dropdown;
		
		@FindBy(css = "a[href='#logout']")
	    private WebElement logOut;
		
		
	//Enter Username
		public void EnterUsername(String username)
		{
			Username.clear();
			Username.sendKeys(username);
		}
		
	//Enter Password
		public void EnterPassword(String password)
		{
			Password.clear();
			Password.sendKeys(password);
		}
		
	//Click on Login button
		public void ClickOnLogInButton()
		{
			Login.click();
		}
		
		//Click on logout drop down
		public void Logoutdropdown()
		{
			logout_dropdown.click();
		}
		
		//Click on Logout button
		public void Logout()
		{
			logOut.click();
		}
}
