package pageFactory.Embrace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Reporter;
import org.openqa.selenium.JavascriptExecutor;

import utility.Constants;
import utility.JavaHelpers;
import utility.SeleniumFunctions;

public class RETSListingPage {

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	SeleniumFunctions selenium;

	public RETSListingPage(WebDriver driver) {
		this.driver = driver;

		// This initElements method will create all WebElements
		// PageFactory.initElements(driver, this);
		PageFactory
				.initElements(new AjaxElementLocatorFactory(driver, Constants.WebDriverWaitDuration), this);
		selenium = new SeleniumFunctions(driver);
	}

	/*
	 * All WebElements are identified by @FindBy annotation
	 * 
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
	 * className, xpath as attributes.
	 */

	@FindBy(id = "rets_listings")
	public WebElement RETSListingIFrame;

	@FindBy(id = "resetModifiedDate")
	public WebElement MLSModifiedDateXButton;

	@FindBy(id = "dd_mls")
	public WebElement MLS;

	@FindBy(id = "minSalePrice_c")
	public WebElement minSalePrice;

	@FindBy(id = "maxSalePrice_c")
	public WebElement maxSalePrice;

	@FindBy(id = "minBed")
	public WebElement minBed;

	@FindBy(id = "maxBed")
	public WebElement maxBed;

	@FindBy(id = "minSqft")
	public WebElement minSqft;

	@FindBy(id = "maxSqft")
	public WebElement maxSqft;

	@FindBy(id = "minRent_c")
	public WebElement minRent;

	@FindBy(id = "maxRent_c")
	public WebElement maxRent;

	@FindBy(id = "minBath")
	public WebElement minBath;

	@FindBy(id = "maxBath")
	public WebElement maxBath;

	@FindBy(id = "address1")
	public WebElement Address;

	@FindBy(id = "mlsNumber")
	public WebElement mlsNumber;

	@FindBy(id = "zip")
	public WebElement zip;

	@FindBy(id = "minPulledDate")
	public WebElement minPulledDate;

	@FindBy(id = "maxPulledDate")
	public WebElement maxPulledDate;

	@FindBy(id = "showPoolProperty")
	public WebElement showPoolProperty;

	@FindBy(id = "showHotProperty")
	public WebElement showHotProperty;

	@FindBy(id = "showNegAppProps")
	public WebElement showNegAppProps;
	
	@FindBy(id = "showHiddenProperty")
	public WebElement showHiddenProperty;

	// Select MLSName
	public void SelectMLS(String mls) {
		driver.findElement(By.cssSelector("div#dd_mls_chosen a")).click();
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
		}*/

		for (int i = 1; i <= 40; i++) {
			String cssSelector = "#dd_mls_chosen > div > ul > li:nth-child(" + i + ")";
			String text = driver.findElement(By.cssSelector(cssSelector)).getText();
			if (text.equalsIgnoreCase(mls)) {
				driver.findElement(By.cssSelector(cssSelector)).click();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
				}
				//System.out.println("\n--- mls name is  " + mls);
				break;
			}
		}

	}

	// Select State
	public void selectState(String state) {
		// int i=1;
		while (!driver.findElement(By.id("dd_state_chosen")).isEnabled()) {
			System.out.println("Waiting for state element to get enabled");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			}
		}
		driver.findElement(By.cssSelector("div#dd_state_chosen a")).click();
		for (int i = 1; i <= getdropdowncount("#dd_state_chosen > div > ul > li"); i++) {
			String cssSelector = "#dd_state_chosen > div > ul > li:nth-of-type(" + i + ")";
			while (!driver.findElement(By.cssSelector(cssSelector)).isDisplayed()) {
				System.out.println("Waiting for state element to be displayed");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
				}
			}
			String text = driver.findElement(By.cssSelector(cssSelector)).getText();
			if (text.equalsIgnoreCase(state)) {
				driver.findElement(By.cssSelector(cssSelector)).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
				}
				// System.out.println("Selected State = "+state);
				break;
			}
			// i++;
		}
		// while(driver.findElement(By.cssSelector("#dd_state_chosen > div > ul > li:nth-of-type("
		// + i + ")")) != null );
	}

	// Select City
	public void selectCity(String city) {
		// int i=1;
		while (!driver.findElement(By.id("dd_city_chosen")).isEnabled()) {
			System.out.println("Waiting for city element to get enabled");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			}
		}
		driver.findElement(By.cssSelector("div#dd_city_chosen a")).click();
		for (int i = 1; i <= getdropdowncount("#dd_city_chosen > div > ul > li"); i++) {
			String cssSelector = "#dd_city_chosen > div > ul > li:nth-of-type(" + i + ")";
			while (!driver.findElement(By.cssSelector(cssSelector)).isDisplayed()) {
				System.out.println("Waiting for city element to be displayed");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
				}
			}
			String text = driver.findElement(By.cssSelector(cssSelector)).getText();
			if (text.equalsIgnoreCase(city)) {
				driver.findElement(By.cssSelector(cssSelector)).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
				}
				// System.out.println("Selected city = "+city);
				break;
			}
			// i++;
		}
		// while
		// (driver.findElement(By.cssSelector("#dd_city_chosen > div > ul > li:nth-of-type("
		// + i + ")")) != null );
	}

	// Select County
	public void selectCounty(String county) {
		// int i=1;
		while (!driver.findElement(By.id("dd_county_chosen")).isEnabled()) {
			System.out.println("Waiting for county element to get enabled");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			}
		}
		driver.findElement(By.cssSelector("div#dd_county_chosen a")).click();
		for (int i = 1; i <= getdropdowncount("#dd_county_chosen > div > ul > li"); i++) {
			String cssSelector = "#dd_county_chosen > div > ul > li:nth-of-type(" + i + ")";
			while (!driver.findElement(By.cssSelector(cssSelector)).isDisplayed()) {
				System.out.println("Waiting for county element to be displayed");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
				}
			}
			String text = driver.findElement(By.cssSelector(cssSelector)).getText();
			if (text.equalsIgnoreCase(county)) {
				driver.findElement(By.cssSelector(cssSelector)).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
				}
				// System.out.println("Selected county = "+county);
				break;
			}
			// i++;
		}
		// while
		// (driver.findElement(By.cssSelector("#dd_county_chosen > div > ul > li:nth-of-type("
		// + i + ")")) != null );
	}

	// Select School District
	public void selectSchoolDistrict(String SchoolDistrict) {
		// int i=1;
		while (!driver.findElement(By.id("dd_schoolDistrict_chosen")).isEnabled()) {
			System.out.println("Waiting for SchoolDistrict element to get enabled");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			}
		}
		driver.findElement(By.cssSelector("div#dd_schoolDistrict_chosen a")).click();
		for (int i = 1; i <= getdropdowncount("#dd_schoolDistrict_chosen > div > ul > li"); i++) {
			String cssSelector = "#dd_schoolDistrict_chosen > div > ul > li:nth-of-type(" + i + ")";
			while (!driver.findElement(By.cssSelector(cssSelector)).isDisplayed()) {
				System.out.println("Waiting for SchoolDistrict element to be displayed");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
				}
			}
			String text = driver.findElement(By.cssSelector(cssSelector)).getText();
			if (text.equalsIgnoreCase(SchoolDistrict)) {
				driver.findElement(By.cssSelector(cssSelector)).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
				}
				// System.out.println("Selected SchoolDistrict = "+
				// SchoolDistrict);
				break;
			}
			// i++;
		}
		// while
		// (driver.findElement(By.cssSelector("#dd_schoolDistrict_chosen > div > ul > li:nth-of-type("
		// + i + ")")) != null );
	}

	// Select Listing Class
	public void selectListingClass(String listingClass) {
		// int i=1;
		while (!driver.findElement(By.id("dd_listingclass_chosen")).isEnabled()) {
			System.out.println("Waiting for listingClass element to get enabled");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			}
		}
		driver.findElement(By.cssSelector("div#dd_listingclass_chosen a")).click();
		for (int i = 1; i <= getdropdowncount("#dd_listingclass_chosen > div > ul > li"); i++) {
			String cssSelector = "#dd_listingclass_chosen > div > ul > li:nth-of-type(" + i + ")";
			while (!driver.findElement(By.cssSelector(cssSelector)).isDisplayed()) {
				System.out.println("Waiting for listingClass element to be displayed");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
				}
			}
			String text = driver.findElement(By.cssSelector(cssSelector)).getText();
			if (text.equalsIgnoreCase(listingClass)) {
				driver.findElement(By.cssSelector(cssSelector)).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
				}
				// System.out.println("Selected listingClass = "+ listingClass);
				break;
			}
			// i++;
		}
		// while
		// (driver.findElement(By.cssSelector("#dd_listingclass_chosen > div > ul > li:nth-of-type("
		// + i + ")")) != null );
	}

	// To clear the values of hidden web elements
	public void clearHiddenWebElement(String ElementName) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Change the value of 'type' attribute as 'text' from 'hidden'
		jse.executeScript("document.getElementsByName('" + ElementName
				+ "')[0].setAttribute('type', 'text');");
		// Set the xpath of this element
		driver.findElement(By.xpath("//*[@id='" + ElementName + "']")).clear();
		// Change the value of 'value' attribute to blank
		jse.executeScript("document.getElementsByName('" + ElementName + "')[0].setAttribute('value', '');");
		// Change the value of type attribute back to 'hidden'
		jse.executeScript("document.getElementsByName('" + ElementName
				+ "')[0].setAttribute('type', 'hidden');");
	}

	@FindBy(id = "searchProperty")
	public WebElement Search;

	@FindBy(id = "searchResultTable_processing")
	public WebElement Search_Processing;

	public void waitTillProcessingDone() {
		/*for (int i = 1; i < 120; i++) {
			try {Thread.sleep(1000);} catch (InterruptedException e1) {}
			try {
				String temp = Search_Processing.getAttribute("style");
				if (temp.contains("hidden")) {
					break;
				}
			} catch (Exception e2) {
				break;
			}
		}*/
		// Wait for the tab to load
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try	{
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("searchResultTable_processing")));
		} catch(Exception e){
			System.out.println("Error in loading Results Table.");
			}
	}

	// Buttons
	@FindBy(id = "process")
	public WebElement Process;

	@FindBy(id = "update")
	public WebElement Save;

	@FindBy(id = "hide")
	public WebElement Hide;

	@FindBy(id = "removeProperty")
	public WebElement Remove;

	@FindBy(id = "rentReviewCheckBox")
	public WebElement rentReviewCheckBox;

	@FindBy(id = "rehabReviewCheckBox")
	public WebElement rehabReviewCheckBox;

	// Search Result table > to get Property Details link for First Record

	public String ToGetPropDetailsLink(int i) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(4) a";
		return driver.findElement(By.cssSelector(cssSelector)).getAttribute("href");
	}

	// Get MLS
	public String ToGetPropMLS(int i) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(4) a";
		return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	}

	// Get Address
	public String ToGetPropAddress(int i) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i + ") td:nth-of-type(7)";
		return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	}

	// Get Rent
	public String ToGetPropRent(int i) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i
				+ ") td:nth-of-type(14) input";
		return driver.findElement(By.cssSelector(cssSelector)).getAttribute("value").trim();

	}

	// Get Zip
	public String ToGetPropZip(int i) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i
				+ ") td:nth-of-type(7) .cl_zip";
		return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	}

	// Get MLSName
	public String ToGetPropMLSName(int i) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i
				+ ") td:nth-of-type(4) .mlsname";
		return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	}

	// Get State
	public String ToGetPropStateName(int i) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i
				+ ") td:nth-of-type(7) span:nth-of-type(2)";
		return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	}

	// Get City
	public String ToGetPropCityName(int i) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i
				+ ") td:nth-of-type(7) .cl_city";
		return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	}

	// Get County
	public String ToGetPropCountyName(int i) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i
				+ ") td:nth-of-type(7) .cl_county";
		return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	}

	@FindBy(id = "rentreasons")
	public WebElement RentReviewReason;

	public String GetSelectedRentReviewReason() {
		return new Select(RentReviewReason).getFirstSelectedOption().getText().trim();
	}

	// Common functions

	// Selecting checkbox for 'Select' column
	public void ToSelectCheckboxForSelectColumn(int i) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + i
				+ ") td:nth-of-type(1) input";
		driver.findElement(By.cssSelector(cssSelector)).click();
	}

	// Enter data to any column's text box
	public void ToEnterDataInAnyRowColumnTextbox(int row, int column, String data) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + row + ") td:nth-of-type("
				+ column + ") input";
		driver.findElement(By.cssSelector(cssSelector)).clear();
		driver.findElement(By.cssSelector(cssSelector)).sendKeys(data);
	}

	// Get data from any column's text box
	public String ToGetAnyRowColumnTextboxData(int row, int column) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + row + ") td:nth-of-type("
				+ column + ") input";
		return driver.findElement(By.cssSelector(cssSelector)).getAttribute("value").trim();
	}

	// Get data from any column (non text box)
	public String ToGetAnyRowColumnData(int row, int column) {
		String cssSelector = "table#searchResultTable tbody tr:nth-of-type(" + row + ") td:nth-of-type("
				+ column + ")";
		return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	}
	
	// Get Rent Review Reason
		public String ToGetRentReviewReason(int row) {
			String cssSelector = "table#searchResultTable > tbody > tr:nth-child(" + row + ") > td:nth-child(14) #rentreasons";
			Select dropdown= new Select(driver.findElement(By.cssSelector(cssSelector)));
			return dropdown.getFirstSelectedOption().getText().trim();
		}

	// Get column no of give column
	public int ToGetColumnNo(String columnname) {
		int index = 0;
		String cssSelector = "";
		String text = "";

		try {
			for (index = 1; index < 50; index++) {
				cssSelector = "table#searchResultTable thead tr th:nth-of-type(" + index + ")";
				text = driver.findElement(By.cssSelector(cssSelector)).getText().trim();
				if (text.contains(columnname)) {
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(" - Alert !! requested column doesn't exists");
			//Reporter.log(" - Alert !! requested column doesn't exists");
		}

		return index;

	}

	// Click on column header
	public void ToClickOnColumnHeader(int i) {
		String cssSelector = "table#searchResultTable thead tr th:nth-of-type(" + i + ")";
		driver.findElement(By.cssSelector(cssSelector)).click();

	}

	// To get total results
	public int ToGetTotalResultsRow() {
		String cssSelector = "table#searchResultTable tbody tr";
		try {
			List<WebElement> all = driver.findElements(By.cssSelector(cssSelector));
			return all.size();
		} catch (Exception e1) {
			return 0;
		}
	}

	// To get drop-down options count
	public int getdropdowncount(String cssSelector) {
		// String cssSelector = "#dd_listingclass_chosen > div > ul > li";
		try {
			List<WebElement> all = driver.findElements(By.cssSelector(cssSelector));
			return all.size();
		} catch (Exception e1) {
			return 0;
		}
	}

	// To Reset all previous set filters of BB if any e.g. Min & Max Price,
	// Rent, Sqft, Bed and Bath
	public void clearAllFieldsinBB() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
		}
		minSalePrice.clear();
		maxSalePrice.clear();
		minBed.clear();
		maxBed.clear();
		minBath.clear();
		maxBath.clear();
		minRent.clear();
		maxRent.clear();
		minSqft.clear();
		maxSqft.clear();
		mlsNumber.clear();
		Address.clear();
		zip.clear();
		selectState("Choose a state...");
		selectCity("Choose a city...");
		selectCounty("Choose a county...");
		selectSchoolDistrict("Choose a School District...");
		clearHiddenWebElement("maxSalePrice");
		clearHiddenWebElement("minRent");
		clearHiddenWebElement("maxRent");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
		}
	}

	// Pagination
	@FindBy(css = "ul.pagination i.fa-angle-right")
	public WebElement Page_Next;

	@FindBy(css = "ul.pagination li[class='next disabled'] a")
	public WebElement Page_Next_Disabled;

	public boolean IsNextPage() {
		//return !selenium.IsElementPresent(Page_Next_Disabled);
		return !selenium.IsElementPresent("css", "ul.pagination li[class='next disabled'] a");
	}

}
