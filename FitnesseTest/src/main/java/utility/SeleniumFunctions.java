package utility;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.Reporter;


public class SeleniumFunctions 
{

	WebDriver driver; 
	
	public SeleniumFunctions(WebDriver driver) 
	{
			this.driver=driver;
	}
	
	/*
	For clicking on element on page
	*/
	public void ClickOnElement(String locator, String locatorvalue)
	{
		WebDriverWaitMethod(locator,locatorvalue);
		
		if(locator.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorvalue)).click();
		}
		
		if(locator.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatorvalue)).click();
		}
		
		if(locator.equalsIgnoreCase("css"))
		{
			driver.findElement(By.cssSelector(locatorvalue)).click();
		}
		
		if(locator.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatorvalue)).click();
		}
			
	}
	
	/*
	For waiting for element to be visible on page
	*/
	public void WebDriverWaitMethod(String locator, String locatorvalue)
	{
		WebDriverWait wait = new WebDriverWait(driver, Constants.WebDriverWaitDuration);
		
		try
		{
			if(locator.equalsIgnoreCase("id"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
			}
			
			if(locator.equalsIgnoreCase("name"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
			}
			
			if(locator.equalsIgnoreCase("css"))
			{
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorvalue)));
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorvalue)));
			}
			
			if(locator.equalsIgnoreCase("xpath"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
			}
			
		}
		catch (Exception e)
		{
			System.out.println("Element is NOT visible");
		}
	}
	
	public void waitMethodBylocator(String locator, String locatorvalue,int timeOutseconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutseconds);
		
		try
		{
			if(locator.equalsIgnoreCase("id"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
			}
			
			if(locator.equalsIgnoreCase("name"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
			}
			
			if(locator.equalsIgnoreCase("css"))
			{
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorvalue)));
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorvalue)));
			}
			
			if(locator.equalsIgnoreCase("xpath"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
			}
			
		}
		catch (Exception e)
		{
			System.out.println("Element is NOT visible");
		}
	}
	
	public void waitMethodByElement(WebElement element,int timeOutseconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutseconds);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		catch (Exception e)
		{
			System.out.println("Element is NOT visible");
		}
	}
		
	/*
	To verify whether element is present on page or not
	*/
	public boolean IsElementPresent(String locator, String locatorvalue) 
	{
		boolean b;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	    try 
	    { 	
	    	if(locator.equalsIgnoreCase("id"))
			{
	    		driver.findElement(By.id(locatorvalue));
	    		
			}
	    	

	    	if(locator.equalsIgnoreCase("css"))
			{
	    		driver.findElement(By.cssSelector(locatorvalue));
	    		
			}
	    	

	    	if(locator.equalsIgnoreCase("xpath"))
			{
	    		driver.findElement(By.xpath(locatorvalue));
	    		
			}
	    	

	    	if(locator.equalsIgnoreCase("name"))
			{
	    		driver.findElement(By.name(locatorvalue));
	    		
			}
	    	
	    	
	    	b = true;
	    	
	    }
	    catch (NoSuchElementException e) 
	    {
	      b= false;
	    }
	    
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    return b; 
	}
	
	
	/*
	To verify whether element is present on page or not
	*/
	public boolean IsElementPresent(WebElement element) 
	{
		boolean b ; 
		
	    try 
	    { 	
	    	element.isDisplayed();
	    	b = true;	
	    }
	    catch (NoSuchElementException e) 
	    {
	      b = false;
	    }
	    
	   return b;
	   
	   
	}

	
	/*
	For getting element's text from page
	*/
	public String GetElementText(String locator, String locatorvalue)
	{
		//WebDriverWaitMethod(locator,locatorvalue);
		
		String temptext=null;
		if(locator.equalsIgnoreCase("id"))
		{
			temptext= driver.findElement(By.id(locatorvalue)).getText();
		}
		
		if(locator.equalsIgnoreCase("name"))
		{
			temptext= driver.findElement(By.name(locatorvalue)).getText();
		}
		
		if(locator.equalsIgnoreCase("css"))
		{
			temptext= driver.findElement(By.cssSelector(locatorvalue)).getText();
		}
		
		
		if(locator.equalsIgnoreCase("xpath"))
		{
			temptext= driver.findElement(By.xpath(locatorvalue)).getText();
		}
		
		return temptext;
	}
	
	
	/*
	For entering value in text box on page
	*/
	public void EnterValueInTextbox(String locator, String locatorvalue, String data)
	{
		WebDriverWaitMethod(locator,locatorvalue);
		
		if(locator.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorvalue)).sendKeys(data);
		}
		
		if(locator.equalsIgnoreCase("name"))
		{
		
			driver.findElement(By.name(locatorvalue)).sendKeys(data);
		}
		
		if(locator.equalsIgnoreCase("css"))
		{
			
			driver.findElement(By.cssSelector(locatorvalue)).sendKeys(data);
		}
		
		if(locator.equalsIgnoreCase("xpath"))
		{
			
			driver.findElement(By.xpath(locatorvalue)).sendKeys(data);
		}
		
		
	}
	
	
	/*
	For deleting value from text box on page
	*/
	public void DeleteValueFromTextbox(String locator, String locatorvalue)
	{
		WebDriverWaitMethod(locator,locatorvalue);
		
		if(locator.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorvalue)).clear();
		}
		
		if(locator.equalsIgnoreCase("name"))
		{
		
			driver.findElement(By.name(locatorvalue)).clear();
		}
		
		if(locator.equalsIgnoreCase("css"))
		{
			
			driver.findElement(By.cssSelector(locatorvalue)).clear();
		}
		
		if(locator.equalsIgnoreCase("xpath"))
		{
			
			driver.findElement(By.xpath(locatorvalue)).clear();
		}
		
		
	}
	
	
	/*
	For getting attribute value for element on page
	*/
	public String GetAttributeValue(String locator, String locatorvalue, String attributename)
	{
		WebDriverWaitMethod(locator,locatorvalue);
		
		
		String temptext=null;
		if(locator.equalsIgnoreCase("id"))
		{
			WebElement e = driver.findElement(By.id(locatorvalue));
			temptext = e.getAttribute(attributename);
		}
		
		if(locator.equalsIgnoreCase("name"))
		{
			WebElement e = driver.findElement(By.name(locatorvalue));
			temptext = e.getAttribute(attributename);
		}
		
		if(locator.equalsIgnoreCase("css"))
		{
			WebElement e = driver.findElement(By.cssSelector(locatorvalue));
			temptext = e.getAttribute(attributename);
		}
		
		
		if(locator.equalsIgnoreCase("xpath"))
		{
			WebElement e = driver.findElement(By.xpath(locatorvalue));
			temptext = e.getAttribute(attributename);
		}
		
		return temptext;
	}
	
	
	/*
	For getting attribute value for element on page
	*/
	public String GetAttributeValue(WebElement e, String attribute)
	{
		return e.getAttribute(attribute);
	}
	
	/*
	For clicking on specified item from dropdown list
	*/
	public void ToClickOnSpecifiedItemFromDropdown(String divid, String ItemToClick)
	{
		String tempcss= "div#" + divid+ " li";
		int count = driver.findElements(By.cssSelector(tempcss)).size();
		
		
		for (int i = 2; i < count; i++)
		{
			
			String locatorvalue = "div#" + divid+ " li:nth-of-type(" + i+ ")";
			String temp= driver.findElement(By.cssSelector(locatorvalue)).getText();
			if(temp.equals(ItemToClick))
				{
					//System.out.println("Got required element");
					driver.findElement(By.cssSelector(locatorvalue)).click();
					break;
				}
				
		}
	}

	
	/*
	To navigate given Url
	*/
	public void ToGoToUrl(String Url)
	{
		try {
			//Thread.sleep(5000);
			driver.get(Url);
			Thread.sleep(8000);
		} catch (TimeoutException | InterruptedException e) {
			
			System.out.println("--- " + Url + "  is not responding, test case is aborted" );
			//Reporter.log("--- " + Url + "  is not responding, test case is aborted" );
			//Assert.fail();
		}
	}
	
	
	/*
	To get webpage text
	*/
	public String ToGetPageSourceText()
	{
		return driver.getPageSource();
	}
	
	
	/*
	To select value from drop down list using Visible text
	 */
	public void SelectValueFromDropdownList(String locatortype, String locatorvalue, String visibletext)
	{
		if(locatortype.equalsIgnoreCase("id"))
		{
			new Select(driver.findElement(By.id(locatorvalue))).selectByVisibleText(visibletext);
		}
		
	}
	
	
	/*
	To select value from drop down list using Index
	 */
	public void SelectValueFromDropdownListUsingIndex(String locatortype, String locatorvalue,int index)
	{
		if(locatortype.equalsIgnoreCase("id"))
		{
			new Select(driver.findElement(By.id(locatorvalue))).selectByIndex(index);
		}
		
	}
	
	
	/*
	To get selected value from drop down list
	 */
	public String GetSelectedValueFromDropdownList(String locatortype, String locatorvalue)
	{
		String selectedtext = null;
		if(locatortype.equalsIgnoreCase("id"))
		{
			WebElement element = new Select(driver.findElement(By.id(locatorvalue))).getFirstSelectedOption();
			selectedtext = element.getText();
			
		}
		return selectedtext;
		
		
	}
	// To select a check box 
	public void Select_The_Checkbox_Radiobutton(WebElement element) {
		try {
            if (element.isSelected()) {
               //System.out.println("Checkbox is already selected");
            } else {
            	// Select the checkbox
                element.click();
            }
        } catch (Exception e) {
        	System.out.println("Unable to select the checkbox");
        }
		
	}
	/*
	Accept JS alert and get it's text
	*/
	public String AcceptAlertAndGetText()
	{
		Alert alert = driver.switchTo().alert();
        String AlertText = alert.getText();
        alert.accept();
        
        return AlertText;
	}
	
	
	/*
	Dismiss JS alert and get it's text
	*/
	public String DismisAlertAndGetText()
	{
		Alert alert = driver.switchTo().alert();
        String AlertText = alert.getText();
        alert.dismiss();
        
        return AlertText;
	}
	
	
	/*
	To get current page url
	*/
	public String ToGetCurrentPageUrl()
	{
		return driver.getCurrentUrl();
		
	}
	
	
	/*
	To refresh page
	*/
	public void ToReloadPage()
	{
		driver.navigate().refresh();
		
	}
	
	
	/*To mouse hover on element*/
	public void ToMouseHover(String locator, String locatorvalue ) throws InterruptedException
	{
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector(locatorvalue));
		action.moveToElement(element).build().perform();
		Thread.sleep(5000);
		
		
		String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";

		WebElement element1 = driver.findElement(By.cssSelector(locatorvalue));
		((JavascriptExecutor)driver).executeScript(javaScript, element1);
		
		Thread.sleep(5000);
		
		/*if(locator.equalsIgnoreCase("id"))
		{
			element = driver.findElement(By.id(locatorvalue));
		}
		
		if(locator.equalsIgnoreCase("name"))
		{
			element = driver.findElement(By.name(locatorvalue));
		}
		
		if(locator.equalsIgnoreCase("css"))
		{
			element =driver.findElement(By.cssSelector(locatorvalue));
		}
		
		if(locator.equalsIgnoreCase("xpath"))
		{
			element =driver.findElement(By.xpath(locatorvalue));
		}
		*/
		
		
	}
	
	
	/*
	To switch iFrame
	*/
	public void ToSwitchiFrame(WebElement e)
	{
		driver.switchTo().frame(e);
		
	}
	
	
	/*
	Drag and Drop functionality
	*/
	public void DragAndDrop(WebElement fromElement , WebElement toElement)
	{
		    Actions action = new Actions(driver);
		    Action dragDrop = action.dragAndDrop(fromElement, toElement).build();
		    dragDrop.perform(); 
	}
	
	/*
	To open URL in new tab and return to original tab
	*/
	public void ToOpenURLInNewTab(String url) throws InterruptedException, AWTException
	{
		String oldTab = driver.getWindowHandle();
		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL +"t");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(1));
		//Navigating to processing url
		try {
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			
			System.out.println("--- " + url + "  is not responding, test case is aborted" );
			//Reporter.log("--- " + url + "  is not responding, test case is aborted" );
			//Assert.fail();
			
		}
		Thread.sleep(5000);
		//Switch to original tab
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL +"\t");
		// Switch driver control to focused tab window
		driver.switchTo().window(oldTab);
	}
	
	
	/*
	To open URL in new Window and return to original Window
	*/
	public void ToOpenURLInNewWindow(String url)
	{
		String oldTab = driver.getWindowHandle();
		String newWindow = Keys.chord(Keys.CONTROL, Keys.SHIFT + "n");
		//driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + Keys.SHIFT +"n");
		driver.findElement(By.tagName("body")).sendKeys(newWindow);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(1));
		//Navigating to processing url
		try {
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			System.out.println("--- " + url + "  is not responding, test case is aborted" );
			//Reporter.log("--- " + url + "  is not responding, test case is aborted" );
			//Assert.fail();
		}
		driver.close();
		// Switch driver control to focused tab window
		driver.switchTo().window(oldTab);
		
		// Setting timeout to 2 minutes
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	
	
	public void AddSaucelabsRecordedVideoInfo()
	{	
		SessionId webdriversessionid = ((RemoteWebDriver) driver).getSessionId();
		String url = "https://saucelabs.com/beta/tests/" + webdriversessionid + "/watch" ;
		System.out.println("======================================================================================================" );
		//Reporter.log("======================================================================================================" );	
		System.out.println("SauceLab Recorded Video Url : " + url );
		//Reporter.log("SauceLab Recorded Video Url : " + url );		
		System.out.println("======================================================================================================" );
		//Reporter.log("======================================================================================================" );	
	}
	
	 //Print test result
	 public void testResult(int AssertFailedCount)
	 {
		 if(AssertFailedCount == 0)
		 {
			 System.out.println("\n ------- Test Success -----------------");
			// Reporter.log("------- Test Success -----------------");  	 
		 }
		 else
		 {	 
			 System.out.println("\n ------- Test FAILED -----------------");
			 //Reporter.log("Total properties count not eligible for asset class assignment = " + propertyNotEligible); 
			// Assert.fail("Test Failed");
		 }
	 }
	
}



