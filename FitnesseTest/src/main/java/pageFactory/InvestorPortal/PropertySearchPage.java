package pageFactory.InvestorPortal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class PropertySearchPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public PropertySearchPage(WebDriver driver)
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
	
		
		@FindBy(css="#asset_prop_srch_form h3")
		public WebElement PageHeader;
		
		@FindBy(xpath="//*[@id='navbar']/div[1]/ul[1]/li[1]/a")
		public WebElement propertySearchheader;
		
		@FindBy(css="#navbar > div.nav-menu-wrap > ul.nav.navbar-nav.topMenuMobile.pull-left > li.active > a")
		public WebElement propertySearch;
		
		@FindBy(css="button.search")
		public WebElement Search;
		
		@FindBy(css="i.addWL")
		public WebElement AddToWishList_STAR ;
		
		@FindBy(css="#message_modal div.modal-body p")
		public WebElement AddToWishList_ConfirmationMessage_Text; 
		
		@FindBy(css="#message_modal div.modal-footer button")
		public WebElement AddToWishList_ConfirmationMessage_OK; 
		
		@FindBy(css="i.removeWL")
		public WebElement RemoveFromWishList_STAR_Remove; 
		
		@FindBy(css="#wishlistbuy div.modal-body p")
		public WebElement RemoveFromWishList_ConfirmationMessage_Text; 
		
		@FindBy(css="#wishlistbuy div.modal-footer button")
		public WebElement RemoveFromWishList_ConfirmationMessage_YES; 
	
		@FindBy(css="#panel-group-id > div.filters-container > div.investment-strategy.investment-filters > div.panel-collapse > div > dl > dt > a > i")
		public WebElement InvStrtgIcon;
		
		@FindBy(css="#inv-strategy-list > li:nth-of-type(1)")
		public WebElement InvStrtgAnyoption;
		
		@FindBy(css="button.serachBtnHide")
		public WebElement Searchbutton;
		
		
		//Location
		public void SelectLocation(String location)
		{
			//Expanding location dropdown
			driver.findElement(By.cssSelector("a.anyLocation p")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			List<WebElement> alllocations = driver.findElements(By.cssSelector("#hil-list label"));
			for(WebElement e:alllocations)
			{
				String temp = e.getText().trim();
				if(temp.equals(location))
				{
					e.click();
					break;
				}
					
			}
		
		}
		
		
		//Rental Economy
		public void SelectRentalEconomy(String economy)
		{
			//Expanding Rental Economy dropdown
			driver.findElement(By.cssSelector("a.anyRental p")).click();
			
			List<WebElement> alleconomies = driver.findElements(By.cssSelector("#rental-econ-list label"));
			for(WebElement e:alleconomies)
			{
				String temp = e.getText().trim();
				if(temp.equals(economy))
				{
					e.click();
					break;
				}
					
			}
		
		}
		
		
		//INVESTMENT GOAL
		public void SelectInvestmentGoal(String goal)
		{
			//Expanding Investment Goal dropdown
			driver.findElement(By.cssSelector("a.investmentGoalSelected")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			List<WebElement> allgoals = driver.findElements(By.cssSelector("#inv-goal-list li"));
			for(WebElement e:allgoals)
			{
				String temp = e.getText().trim();
				if(temp.equals(goal))
				{
					e.click();
					break;
				}
					
			}
			
		
		}
		
		
		//FINANCING
		public void SelectFinancing(String type)
		{
			//Expanding Financing dropdown
			driver.findElement(By.cssSelector("a.financingSelectedOption")).click();
			
			List<WebElement> allfinancing = driver.findElements(By.cssSelector("#fin-type-list li"));
			for(WebElement e:allfinancing)
			{
				String temp = e.getText().trim();
				if(temp.equals(type))
				{
					e.click();
					break;
				}
					
			}
		}

		
		//Table
		
		public int GetTotalPropertiesCount()
		{
			List<WebElement> totalrows = driver.findElements(By.cssSelector("#search-results tbody tr"));
			return totalrows.size();
		}
	
		public String GetTableData(int row, int column)
		{
			String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
			return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
		}
		
		public String GetPropertyClassInfo(int row)
		{
			//String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") a.asset-class";
			String cssSelector = "p.p-t-10";
			return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
		}


		//Click on Property on table and navigate to Property Details page
		public void ClickOnProperty(int row) throws InterruptedException
		{
			String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) > div";
			driver.findElement(By.cssSelector(cssSelector)).click();
			Thread.sleep(20000);
		}
		
	
		// Get Property address
		public String GetPropertyAddress(int row)
		{
			String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(1) div.property b";
			return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
		}
		
		
		// Click on STAR button for adding property to WishList
		public void AddToWishList(int row)
		{
			String cssSelector = "#search-results tbody tr:nth-of-type(" + row + ") td:nth-of-type(8) i.addWL";
			driver.findElement(By.cssSelector(cssSelector)).click();;
		}
				
	//To sort properties 	
	public void sortProperties(String column,String sortOrder)
	{
		
		List<WebElement> allColumns = driver.findElements(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th"));
	    int size= allColumns.size();
	    int columnNumber=0;
		if(sortOrder.equalsIgnoreCase("asc"))
		{
			if(column.equalsIgnoreCase("price"))
			{
				columnNumber=2;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("descending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
			else if(column.equalsIgnoreCase("investment"))
			{
				columnNumber=3;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("descending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
			else if(column.equalsIgnoreCase("RENT"))
			{
				columnNumber=4;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("descending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
			else if(column.equalsIgnoreCase("cash on cash return"))
			{
				columnNumber=5;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("descending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
			else if(column.equalsIgnoreCase("yield"))
			{
				columnNumber=6;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("descending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
			else if(column.equalsIgnoreCase("total return"))
			{
				columnNumber=7;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("descending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
		}
		else if (sortOrder.equalsIgnoreCase("desc"))
		{
			if(column.equalsIgnoreCase("price"))
			{
				columnNumber=2;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("ascending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
			else if(column.equalsIgnoreCase("investment"))
			{
				columnNumber=3;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("ascending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
			else if(column.equalsIgnoreCase("RENT"))
			{
				columnNumber=4;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("ascending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
			else if(column.equalsIgnoreCase("cash on cash return"))
			{
				columnNumber=5;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("ascending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
			else if(column.equalsIgnoreCase("yield"))
			{
				columnNumber=6;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("ascending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
			else if(column.equalsIgnoreCase("total return"))
			{
				columnNumber=7;
				try{
					driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
					}
					catch(Exception e)
					{
						 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
					}
				try{Thread.sleep(3000);}catch(Exception e){}
				String sortOrdercolumn=driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).getAttribute("aria-sort").trim();
				if(sortOrdercolumn.equalsIgnoreCase("ascending"))
				{
					try{
						driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")")).click();
						}
						catch(Exception e)
						{
							 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results > thead.tableFloatingHeaderOriginal > tr > th:nth-child("+columnNumber+")"))).click();
						}
				}
			}
		}
	}
		
	public void gotoNextPage(int i) throws Exception
	{
	  try{
			driver.findElement(By.cssSelector("#search-results_paginate > ul > li:nth-of-type("+i+") > a")).click();
		}
		catch(Exception e)
		{
		 new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#search-results_paginate > ul > li:nth-of-type("+i+") > a"))).click();
		}
	}
}
