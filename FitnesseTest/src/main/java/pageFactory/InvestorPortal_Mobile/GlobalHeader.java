package pageFactory.InvestorPortal_Mobile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class GlobalHeader 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public GlobalHeader(WebDriver driver)
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
	
	//without login
		@FindBy(css="a[href='#login']")
	    public WebElement Login;
		
		//Click on Login link
				public void ClickOnLoginLink() throws InterruptedException
				{
					Login.click();
					Thread.sleep(4000);
				}
		
		@FindBy(css="#navbar02 a[href='#register']")
		public WebElement SignUp;
		
		
	//After login
		
		
		@FindBy(css="#navbar02 > ul > li.dropdown > a")
		public WebElement Username;
		
		
		//After login, click on any menu item from top i.e. Portfolio Builder, Property Search etc.
		public void ClickOnMenuItem(String menuname) throws InterruptedException
		{
			List<WebElement> menus = driver.findElements(By.cssSelector("div#navbar ul li a"));
			
			for(WebElement e:menus)
			{
			
				String temp = e.getText().trim();
				Thread.sleep(2000);
				if(temp.equalsIgnoreCase(menuname))
				{
					e.click();
					Thread.sleep(7000);
					break;
				}
			}
		}
		
		
		//Pagination
		@FindBy(css="a[title='Next']")
		public WebElement Page_Next; 
		
		@FindBy(css="a[title='Prev']")
		public WebElement Page_Previous; 
		
		
		public void Pagination_ClickOnNext() throws InterruptedException
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView()", Page_Next); 
			Page_Next.click();
			Thread.sleep(5000);
		}
		
		public void Pagination_ClickOnPrevious() throws InterruptedException
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView()", Page_Previous); 
			Page_Previous.click();
			Thread.sleep(5000);
		}
		
		public void Pagination_GoTopage(String n) throws InterruptedException
		{
			
			String cssSelector = "div.dataTables_paginate ul.pagination a";
			List<WebElement> pages = driver.findElements(By.cssSelector(cssSelector));
			
			for(WebElement e:pages)
			{
				String temp = e.getText().trim();
				if(temp.equals(n))
				{
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].scrollIntoView()", e); 
					e.click();
					Thread.sleep(10000);
					break;
				}
			}		
			
		}

	
}
