package pageFactory.InvestorPortal_Mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class ILoginPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public ILoginPage(WebDriver driver)
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
	
		@FindBy(id="page-login-username-input")
	    WebElement Email;
		
		@FindBy(id="page-login-password-input")
	    WebElement Password;
		
		@FindBy(id="page-login-btn")
	    WebElement Login;
		
		
		//Enter Username
		public void EnterEmail(String username)
		{
			Email.clear();
			Email.sendKeys(username);
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
		
		
		//Forgot Password
			@FindBy(id="forgotPassBtn")
		    public WebElement ForgotPasswordLink;
			
			@FindBy(id="page_fpwd_email")
		    public WebElement ForgotPassword_Email;
			
			@FindBy(id="page-forgot-pw-btn")
		    public WebElement ForgotPassword_Submit;
		
			@FindBy(css="div#resetpassword div.modal-body")
		    public WebElement ResetPasswordMessage;
			
			@FindBy(css="div#resetpassword div.modal-footer button")
		    public WebElement ResetPassword_OKButton;
			
			//On login after password reset, 'Change Password Security' pop up displayed
			@FindBy(css="#newpassword div.modal-body > p")
		    public WebElement ChangePasswordSecurityPopupTitle;
			
			@FindBy(id="password-input")
		    public WebElement ForgotPassword_NewPassword;
			
			@FindBy(name="confirm_password")
		    public WebElement ForgotPassword_ConfirmPassword;
			
			@FindBy(id="change-pw-btn")
		    public WebElement ForgotPassword_Save;
			
		
		
		// Login page view after confirming user registration
		

			@FindBy(css="div#activation_status div.form-group")
		    public WebElement AccountActivationMessage;
			
			@FindBy(css="div#activation_status a")
		    public WebElement AccountActivation_OKButton;
			
			@FindBy(id="page-login-username-input")
			public WebElement Email1;
			
			@FindBy(id="page-login-password-input")
			public WebElement Password1;
			
			@FindBy(id="page-login-btn")
			public WebElement Login1;
		
		
	
}
