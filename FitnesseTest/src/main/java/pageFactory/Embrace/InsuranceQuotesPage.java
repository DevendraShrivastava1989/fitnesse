package pageFactory.Embrace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utility.Constants;
import utility.JavaHelpers;

public class InsuranceQuotesPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public InsuranceQuotesPage(WebDriver driver)
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
	
		@FindBy(id="address")
	    WebElement PropertyAddress;
		
		@FindBy(id="searchSubmit")
	    WebElement Search;
		
		@FindBy(css="a.insurancePopUp")
	    WebElement SubmitInsuranceQuote;
		
		public void ClickOnSubmitInsuranceQuoteLink(String address) throws InterruptedException
		{
			PropertyAddress.sendKeys(address);
			Search.click();
			Thread.sleep(3000);
			SubmitInsuranceQuote.click();
			Thread.sleep(3000);
		}
		
		
		//Insurance Quote pop up
		
			@FindBy(id="add_quote")
		    public WebElement AddNewQuote;
			
			    @FindBy(css="div[class='alert alert-success display-hide'][style='display: block;']")
			    public WebElement AlertMessage;
			    
			    
			    public void Quote_Add(
			    					  int i,	
			    					  String insurancetype,
			    					  String insuranceprovider,
			    					  String premium,
			    					  String deductible,
			    					  String windHail,
			    					  String dwelling,
			    					  String personalProperty,
			    					  String premisesLiability,
			    					  String otherStructures,
			    					  String lossOfUse,
			    					  String medicalPayment,
			    					  String uploadPolicyDetails,
			    					  String comments) throws InterruptedException
			    {
			    	AddNewQuote.click();
			    	Thread.sleep(4000);
			    	
			    	String cssSelector = "div#collapse_2_" + i + " [name='insuranceType']";
				    WebElement InsuranceType = driver.findElement(By.cssSelector(cssSelector)) ;
				    new Select(InsuranceType).selectByVisibleText(insurancetype);
			
				    cssSelector = "div#collapse_2_" + i + " [name='insuranceProvider']";
				    WebElement InsuranceProvider = driver.findElement(By.cssSelector(cssSelector));
				    new Select(InsuranceProvider).selectByVisibleText(insuranceprovider);
				    
				    cssSelector = "div#collapse_2_" + i + " #yearlyPremium_currency";
				    WebElement YearlyPremium = driver.findElement(By.cssSelector(cssSelector)); 
			    	YearlyPremium.sendKeys(premium);
			    	
			    	cssSelector = "div#collapse_2_" + i + " #deductibleAmount_currency";
				    WebElement Deductible = driver.findElement(By.cssSelector(cssSelector)); 
			    	Deductible.sendKeys(deductible);
			    	
			    	cssSelector = "div#collapse_2_" + i + " #windAndHailAmount_currency";
				    WebElement WindHail = driver.findElement(By.cssSelector(cssSelector)); 
			    	WindHail.sendKeys(windHail);
			    	
			    	cssSelector = "div#collapse_2_" + i + " #dwelling_currency";
				    WebElement Dwelling = driver.findElement(By.cssSelector(cssSelector)); 
			    	Dwelling.sendKeys(dwelling);
			    	
			    	cssSelector = "div#collapse_2_" + i + " #personalProperty_currency";
				    WebElement PersonalProperty = driver.findElement(By.cssSelector(cssSelector)); 
			    	PersonalProperty.sendKeys(personalProperty);
			    	
			    	cssSelector = "div#collapse_2_" + i + " #premisesLiability_currency";
				    WebElement PremisesLiability = driver.findElement(By.cssSelector(cssSelector)); 
			    	PremisesLiability.sendKeys(premisesLiability);
			    	
			    	cssSelector = "div#collapse_2_" + i + " #otherStructures_currency";
				    WebElement OtherStructures = driver.findElement(By.cssSelector(cssSelector)); 
			    	OtherStructures.sendKeys(otherStructures);
			    	
			    	cssSelector = "div#collapse_2_" + i + " #lossOfUse_currency";
				    WebElement LossOfUse = driver.findElement(By.cssSelector(cssSelector)); 
			    	LossOfUse.sendKeys(lossOfUse);
			    	
			    	cssSelector = "div#collapse_2_" + i + " #medicalPayment_currency";
				    WebElement MedicalPayment = driver.findElement(By.cssSelector(cssSelector)); 
			    	MedicalPayment.sendKeys(medicalPayment);
			    	
			    	cssSelector = "div#collapse_2_" + i + " [name='insuranceQuoteDocuments']";
				    WebElement UploadPolicyDetails = driver.findElement(By.cssSelector(cssSelector)); 
			    	UploadPolicyDetails.sendKeys(uploadPolicyDetails);
			    	
			    	cssSelector = "div#collapse_2_" + i + " [name='comments']";
				    WebElement Comments = driver.findElement(By.cssSelector(cssSelector)); 
			    	Comments.sendKeys(comments);
			    	
			    	cssSelector = "div#collapse_2_" + i + " [name='saveQuoteButton']";
				    WebElement Save = driver.findElement(By.cssSelector(cssSelector)); 
			    	Save.click();
			    	
			    	Thread.sleep(10000);
			    }
			    
			    
		    @FindBy(name="submitAllQuotes")
		    public WebElement Submit;	    
			 
			   
			    
			    
	
}			
