package pageFactory.InvestorPortal_Mobile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class SignUp 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public SignUp(WebDriver driver)
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
	
		@FindBy(id="fname-input")
	    WebElement FirstName;
		
		@FindBy(id="lname-input")
	    WebElement LastName;
		
		@FindBy(id="phone-input")
	    WebElement PhoneNumber;
		
		@FindBy(id="email-input")
	    WebElement Email;
		
		@FindBy(id="password-input")
	    WebElement Password;
		
		@FindBy(name="confirm_password")
	    WebElement ConfirmPassword;
		
		@FindBy(css="label.huCheck span")
	    WebElement IAgree;
		
		@FindBy(id="register-submit-btn")
	    WebElement Create	;
		
		@FindBy(css="div#Registration-status-mssg div.modal-content")
	    public WebElement ThankYouMessage;
		
		@FindBy(css="div#Registration-status-mssg div.modal-content button")
	    public WebElement ThankYouMessage_CloseButton;
		
		
		// Fill Registration form and click on 'Register' button
		public void Registration(	String firstname,
								  	String lastname,
								  	String phonenumber,
								  	String email,
								  	String password )
		{
			FirstName.sendKeys(firstname);
			LastName.sendKeys(lastname);
			PhoneNumber.sendKeys(phonenumber);
			Email.sendKeys(email);
			Password.sendKeys(password);
			ConfirmPassword.sendKeys(password);
			IAgree.click();
			//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", IAgree);
			Create.click();
			
		}
		
		
		
		
	
}
