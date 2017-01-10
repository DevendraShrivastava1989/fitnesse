package pageFactory.InvestorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class WatchList {

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public WatchList(WebDriver driver)
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
	
	@FindBy(css="#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dt > a > i")
	public WebElement sortingOption;
	
	public void sortPortfolioList(String sortOrder) throws Exception
	{
		int option=0;
		sortingOption.click();
		Thread.sleep(5000);
		if(sortOrder.equalsIgnoreCase("recently created"))
		{
			option=1;
			try{
			driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")")).click();
			}
			catch(Exception e)
			{
				 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")"))).click();
			}
		}	
		
		else if(sortOrder.equalsIgnoreCase("Investment Amount"))
		{
			option=3;
			try{
			driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")")).click();
			}
			catch(Exception e)
			{
				 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")"))).click();
			}
		}	
		
		else if(sortOrder.equalsIgnoreCase("Total Return"))
		{
			option=4;
			try{
			driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")")).click();
			}
			catch(Exception e)
			{
				 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")"))).click();
			}
		}	
		
		else if(sortOrder.equalsIgnoreCase("Yield"))
		{
			option=5;
			try{
			driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")")).click();
			}
			catch(Exception e)
			{
				 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")"))).click();
			}
		}	
		
		else if(sortOrder.equalsIgnoreCase("Cash On Cash Return"))
		{
			option=6;
			try{
			driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")")).click();
			}
			catch(Exception e)
			{
				 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")"))).click();
			}
		}	
		
		else if(sortOrder.equalsIgnoreCase("recently modified"))
		{
			option=2;
			try{
			driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")")).click();
			}
			catch(Exception e)
			{
				 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#tab-watchlist-portfolio > portfolio-list-app > div > div > div.addInvestProp > div.col-md-12 > div.pull-right > div > div > div > dl > dd > div > ul > li:nth-child("+option+")"))).click();
			}
		}	
	}
}
