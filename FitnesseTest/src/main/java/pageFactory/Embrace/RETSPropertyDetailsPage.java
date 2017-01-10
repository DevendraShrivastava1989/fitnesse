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

import utility.Constants;
import utility.JavaHelpers;

public class RETSPropertyDetailsPage {

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();

	public RETSPropertyDetailsPage(WebDriver driver) {
		this.driver = driver;

		// This initElements method will create all WebElements
		// PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,
				Constants.WebDriverWaitDuration), this);
	}

	/*
	 * All WebElements are identified by @FindBy annotation
	 * 
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
	 * className, xpath as attributes.
	 */

	@FindBy(css = "div.pad_top7")
	public WebElement Address;

	// Info
	@FindBy(css = "div.search-detail-landing div.row > div:nth-of-type(2) > div > div div:nth-of-type(1) > label:nth-of-type(2)")
	public WebElement LocalNIR;

	@FindBy(css = "div.search-detail-landing div.row > div:nth-of-type(3) div.col-md-2")
	public WebElement RawYield;

	@FindBy(css = "div.search-detail-landing div.row > div:nth-of-type(3) > div > div div:nth-of-type(3)")
	public WebElement HURentAVM;

	@FindBy(css = "div.search-detail-landing div.row > div:nth-of-type(3) > div > div div:nth-of-type(4)")
	public WebElement HULowOffer;

	@FindBy(css = "div.search-detail-landing div.row > div:nth-of-type(3) > div > div div:nth-of-type(5)")
	public WebElement HUHighOffer;

	// Select tab from : Property Details , Sold Comps Summary , Leased Comps
	// Summary , Neighborhood
	public void SelectTab(int i) {
		String cssSelector = "ul#myTab li:nth-of-type(" + i + ") a";
		
		// Waiting for Tab to Load
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try	{
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
		} catch(Exception e){
			System.out.println("Error in selecting Tab # " + i);
			}
		driver.findElement(By.cssSelector(cssSelector)).click();
		
		/*if(i == 2)	{
			try	{
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("table#soldCompsTable > tbody > tr:nth-child(1) > td:nth-child(5) > label.propertyaddress > a")));
			} catch(Exception e){
				System.out.println("Error in Loading Sold Comps.");
			}
		}
		if(i == 3)	{
			try	{
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("table#leasedCompsTable > tbody > tr:nth-child(1) > td:nth-child(5) > label.propertyaddress > a")));
			} catch(Exception e){
				System.out.println("Error in Loading Leased Comps.");
			}		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}*/
	}

		
		
		
		//Sold Comps Summary
		
			
			/*public void SoldComp_SelectComp()
			{
				String cssSelector = "table#soldCompsTable tr";
				List<WebElement> allrows = driver.findElements(By.cssSelector(cssSelector));
				
				for(int i=2;i<=allrows.size();i++)
				{
					String cssSelector1 = "table#soldCompsTable tr:nth-of-type(" + i + ") td:nth-of-type(1) input";
					String cssSelector2 = "table#soldCompsTable tr:nth-of-type(" + i + ") td:nth-of-type(2) input";
					
					//String xpathselector = "//table[@id='soldCompsTable']/tbody/tr[2]/td[2]/input
					
					try
					{
						//verifying whether check box is already checked 
						String temp = driver.findElement(By.cssSelector(cssSelector1)).getAttribute("checked");
						if(temp.equals("true"))
						{
							break;
						}
						
					}
					catch(Exception e1)
					{
						//nothing
						driver.findElement(By.cssSelector(cssSelector1)).click();
						try {Thread.sleep(3000);} catch (InterruptedException e) {}
						break;
					}
>>>>>>> Stashed changes*/

	// Sold Comps Summary

public void SoldComp_SelectComp() {
		String cssSelector = "table#soldCompsTable tr";
		List<WebElement> allrows = driver.findElements(By
				.cssSelector(cssSelector));

		for (int i = 2; i <= allrows.size(); i++) {
			String cssSelector1 = "table#soldCompsTable tr:nth-of-type(" + i
					+ ") td:nth-of-type(1) input";
			String cssSelector2 = "table#soldCompsTable tr:nth-of-type(" + i
					+ ") td:nth-of-type(2) input";

			// String xpathselector =
			// "//table[@id='soldCompsTable']/tbody/tr[2]/td[2]/input

			try {
				// verifying whether check box is already checked
				String temp = driver.findElement(By.cssSelector(cssSelector2))
						.getAttribute("checked");
				if (temp.equals("true")) {
					break;
				}

			} catch (Exception e1) {
				// nothing
				driver.findElement(By.cssSelector(cssSelector1)).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				break;
			}

		}

	}
	// Select ith Record
	public void SoldComp_SelectRecord(int i) throws InterruptedException {
		String cssSelector = "table#soldCompsTable tr:nth-of-type(" + i
				+ ") td:nth-of-type(1) input";
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep(3000);
	}

	@FindBy(id = "generateSoldCompsPDF")
	public WebElement GenerateSoldCompsPDF;

	// Confirmaton Box

	// Text
	@FindBy(css = "div#modal_id div[class='form-group modal_text']")
	public WebElement Alert_Text;

	@FindBy(css = "div#modal_dialog_box div[class='form-group modal_text']")
	public WebElement Alert_Text_New;

	// Click OK
	@FindBy(css = "div#modal_id a")
	public WebElement Alert_Dismiss;

	@FindBy(css = "div#modal_dialog_box a")
	public WebElement Alert_Dismiss_New;

	// Warning box
	@FindBy(id = "go_l")
	public WebElement Warning_Accept;

	@FindBy(id = "approveSoldComps")
	public WebElement ApproveSoldComps;

	@FindBy(id = "disapproveSoldComps")
	public WebElement DisApproveSoldComps;
	
	@FindBy(id = "go_yield")
	public WebElement ProcessKickOut;

	// Sorting

	// Getting count of total Sold comps displayed
	public int SoldComp_ToGetTotalTableRows() {
		String cssSelector = "table#soldCompsTable tbody tr";
		List<WebElement> all = driver.findElements(By.cssSelector(cssSelector));
		return all.size();
	}

	// Get data from any column's text box
	public String SoldComp_ToGetAnyRowColumnTextboxData(int row, int column) {
		String cssSelector = "table#soldCompsTable tbody tr:nth-of-type(" + row
				+ ") td:nth-of-type(" + column + ") input";
		return driver.findElement(By.cssSelector(cssSelector))
				.getAttribute("value").trim();
	}

	// Get data from any column (non text box)
	public String SoldComp_ToGetAnyRowColumnData(int row, int column) {
		String cssSelector = "table#soldCompsTable tbody tr:nth-of-type(" + row
				+ ") td:nth-of-type(" + column + ")";
		return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	}

	// Get column no of give column
	public int SoldComp_ToGetColumnNo(String columnname) {
		int index = 0;
		String cssSelector = "";
		String text = "";

		try {
			for (index = 1; index < 50; index++) {
				cssSelector = "table#soldCompsTable thead tr th:nth-of-type("
						+ index + ")";
				text = driver.findElement(By.cssSelector(cssSelector))
						.getText().trim();
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
	public void SoldComp_ToClickOnColumnHeader(int i) {
		String cssSelector = "table#soldCompsTable thead tr th:nth-of-type("
				+ i + ")";
		driver.findElement(By.cssSelector(cssSelector)).click();
	}

	@FindBy(id = "soldCompsTable_processing")
	public WebElement SoldComp_Search_Processing;

	public void SoldComp_waitTillProcessingDone() {
		for (int i = 1; i < 500; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}

			try {

				String temp = SoldComp_Search_Processing.getAttribute("style");
				if (temp.contains("hidden")) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
					}
					break;
				}

			} catch (Exception e2) {
				break;
			}

		}
	}

	// Leased Comps Summary

	public void LeaseComp_SelectComp() {
		String cssSelector = "table#leasedCompsTable tr";
		List<WebElement> allrows = driver.findElements(By
				.cssSelector(cssSelector));

		for (int i = 2; i <= allrows.size(); i++) {
			String cssSelector1 = "table#leasedCompsTable tr:nth-of-type(" + i
					+ ") td:nth-of-type(3) input";
			String cssSelector2 = "table#leasedCompsTable tr:nth-of-type(" + i
					+ ") td:nth-of-type(1) input";

			try {
				// verifying whether check box is already checked
				String temp = driver.findElement(By.cssSelector(cssSelector1))
						.getAttribute("checked");
				if (temp.equals("true")) {
					break;
				}

			} catch (Exception e1) {
				// nothing
				driver.findElement(By.cssSelector(cssSelector2)).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				break;
			}

		}

	}

	// Select ith Record
	public void LeasedComp_SelectRecord(int i) throws InterruptedException {
		String cssSelector = "table#leasedCompsTable tr:nth-of-type(" + i
				+ ") td:nth-of-type(1) input";
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep(3000);
	}

	@FindBy(id = "generateleasedCompsPDF")
	public WebElement GenerateLeasedCompsPDF;

	@FindBy(id = "approveLeasedComps")
	public WebElement ApproveLeaseComps;

	@FindBy(id = "disapproveLeasedComps")
	public WebElement DisApproveLeaseComps;

	// Sorting

	// Getting count of total Lease comps displayed
	public int LeaseComp_ToGetTotalTableRows() {
		String cssSelector = "table#leasedCompsTable tbody tr";
		List<WebElement> all = driver.findElements(By.cssSelector(cssSelector));
		return all.size();
	}

	// Get data from any column's text box
	public String LeaseComp_ToGetAnyRowColumnTextboxData(int row, int column) {
		String cssSelector = "table#leasedCompsTable tbody tr:nth-of-type("
				+ row + ") td:nth-of-type(" + column + ") input";
		return driver.findElement(By.cssSelector(cssSelector))
				.getAttribute("value").trim();
	}

	// Get data from any column (non text box)
	public String LeaseComp_ToGetAnyRowColumnData(int row, int column) {
		String cssSelector = "table#leasedCompsTable tbody tr:nth-of-type("
				+ row + ") td:nth-of-type(" + column + ")";
		return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	}

	// Get column no of give column
	public int LeaseComp_ToGetColumnNo(String columnname) {
		int index = 0;
		String cssSelector = "";
		String text = "";

		try {
			for (index = 1; index < 50; index++) {
				cssSelector = "table#leasedCompsTable thead tr th:nth-of-type("
						+ index + ")";
				text = driver.findElement(By.cssSelector(cssSelector))
						.getText().trim();
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
	public void LeaseComp_ToClickOnColumnHeader(int i) {
		String cssSelector = "table#leasedCompsTable thead tr th:nth-of-type("
				+ i + ")";
		driver.findElement(By.cssSelector(cssSelector)).click();
	}

	@FindBy(id = "leasedCompsTable_processing")
	public WebElement LeaseComp_Search_Processing;

	public void LeaseComp_waitTillProcessingDone() {
		for (int i = 1; i < 500; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}

			try {

				String temp = LeaseComp_Search_Processing.getAttribute("style");
				if (temp.contains("hidden")) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
					}
					break;
				}

			} catch (Exception e2) {
				break;
			}

		}
	}

	// Property Details

	@FindBy(id = "mlsnumber")
	public WebElement mlsnumberPDP;

	@FindBy(css = "span.ra_saleprice")
	public WebElement ListPrice;

	// @FindBy(id="sofferprice_c") - typo
	@FindBy(id = "offerprice_c")
	public WebElement HUFairMarketValue;

	@FindBy(id = "minBid_c")
	public WebElement LowOffer;

	@FindBy(id = "maxBid_c")
	public WebElement HighOffer;

	@FindBy(id = "rentFrom_c")
	public WebElement RentFrom;

	@FindBy(id = "rentTo_c")
	public WebElement RentTo;

	@FindBy(id = "rent_c")
	public WebElement Rent;

	@FindBy(id = "rentReviewCheckBox")
	public WebElement RentReview;

	@FindBy(id = "rentreasons")
	public WebElement RentReviewReason;

	public void SelectRentReviewReason(String reason) {
		new Select(RentReviewReason).selectByVisibleText(reason);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	public String GetSelectedRentReviewReason() {
		return new Select(RentReviewReason).getFirstSelectedOption().getText()
				.trim();
	}

	@FindBy(id = "annualtaxes_c")
	public WebElement AnnualTaxes;

	@FindBy(id = "process")
	public WebElement Process;

	@FindBy(id = "update")
	public WebElement Save;

	@FindBy(id = "insurance_c")
	public WebElement AnnualInsurance;

	@FindBy(id = "hoa_c")
	public WebElement HOA;

	@FindBy(id = "assetClass")
	public WebElement AssetClass;

	@FindBy(id = "pdp_schoold")
	public WebElement schoolDistrict;

	@FindBy(id = "hotPropertyCheckBox")
	public WebElement hotPropertyCheckBox;

	@FindBy(id = "pdp_pool")
	public WebElement pdp_pool;

	// Get School District
	public String ToGetSchoolDistrictName() {
		return schoolDistrict.getText().trim();
	}

	// Get MLS Date Modified
	public String ToGetDateMlsModified() {
		String cssSelector = "#dateMlsModified";
		return driver.findElement(By.cssSelector(cssSelector)).getText().trim();
	}

	// Get Pool Details
	public String toGetPoolDetails() {
		return pdp_pool.getText().trim();
	}

	// Get MLSNumber @ PDP
	public String getMLSNumberFromPDP() {
		return mlsnumberPDP.getText().trim();
	}

	// Rehab Estimate ($)

	@FindBy(id = "rehab_c")
	public WebElement RehabEstimate;

	@FindBy(id = "rehabCal")
	public WebElement RehabEstimate_Button;

	@FindBy(id = "rehabBucket")
	public WebElement RehabBucket;

	// Enter data for first Text box e.g. Storm Doors
	@FindBy(css = "div#TextBoxDiv input")
	public WebElement RehabEstimate_FirstTextBox;

	@FindBy(id = "rehabsave")
	public WebElement RehabEstimate_SaveChanges;

	@FindBy(id = "rehabReviewCheckBox")
	public WebElement RehabReivew;

	@FindBy(id = "rehabreasons")
	public WebElement RehabReviewReason;

	public void SelectRehabReviewReason(String reason) {
		new Select(RehabReviewReason).selectByVisibleText(reason);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	public String GetSelectedRehabReviewReason() {
		return new Select(RehabReviewReason).getFirstSelectedOption().getText()
				.trim();
	}

	@FindBy(id = "rehabBucket")
	public WebElement RehabBucketText;

	@FindBy(id = "cocReturn")
	public WebElement CashOnCashReturn;

	@FindBy(id = "totalYield")
	public WebElement Yield;

	@FindBy(id = "totalReturn")
	public WebElement TotalReturn;

	@FindBy(id = "appreciationRate")
	public WebElement Appreciation;

	@FindBy(id = "loccat")
	public WebElement LocationCategory;

	@FindBy(id = "propcat")
	public WebElement PropertyCategory;

	// ILM's Unique Comments
	@FindBy(id = "ilmNotes")
	public WebElement ILMsUniqueComments;

	@FindBy(id = "city")
	public WebElement City;

	@FindBy(id = "zipcode")
	public WebElement Zipcode;

	@FindBy(css = "#propertyDetails div.search-details div:nth-child(16) > div > span")
	public WebElement YearBuild;

	@FindBy(id = "cocReturn")
	public WebElement Return;

	@FindBy(id = "propSaleCategory")
	public WebElement SaleCategory;
	
	@FindBy(id = "ILMReview")
	public WebElement ILMReview;
	
	@FindBy(id = "ILMHold")
	public WebElement ILMHold;

	public void SelectSaleCategory(String salecategory) {
		new Select(SaleCategory).selectByVisibleText(salecategory);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	public String GetSelectedSaleCategory() {
		return new Select(SaleCategory).getFirstSelectedOption().getText()
				.trim();
	}

	// comp filters
	@FindBy(xpath = "//select[@id='radiusInMiles']//option[6]")
	public WebElement Radius_5_Miles;

	@FindBy(id = "go")
	public WebElement Select_More_Comps;

	@FindBy(id = "totalSqft")
	public WebElement TotalSqft;
	
	@FindBy(id="rehabReviewCheckBox")
	public WebElement rehabReviewCheckBox;

}
