package fitnesse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;

import nl.hsac.fitnesse.fixture.slim.SlimFixtureException;
import nl.hsac.fitnesse.fixture.slim.web.BrowserTest;
import nl.hsac.fitnesse.fixture.util.BinaryHttpResponse;
import nl.hsac.fitnesse.fixture.util.FileUtil;
import nl.hsac.fitnesse.fixture.util.selenium.SeleniumHelper;

import utility.Browser;
import utility.Constants;
import utility.JavaHelpers;
 
public class propertywareupload extends BrowserTest {
	
	WebDriver driver = getSeleniumHelper().driver();
	private Browser b = new Browser();
	
	String bill_number = null;
	String portfolio_name = null;
	String building_number = null;
	String unit_number = null;
	String payment_account = null;
	String payment_date = null;
	String check_number = null;
	String payment_amount = null;
	String split_account_description = null;
	String file_name = null;
	
	/*public void setNumber1(double number1) {
		this.number1 = number1;
	  }
	  
	public void setNumber2(double number2) {
	    this.number2 = number2;
	  }*/
	  
	public void gettransactiondata(int i) throws IOException {
		String first_part = ".//*[@id='ext-gen100']/div[";	
		
		//locators
		String bill_number_loc = "]/table/tbody/tr[1]/td[1]/div/a";
		String portfolio_name_loc = "]/table/tbody/tr[1]/td[3]/div/a";
		String building_number_loc = "]/table/tbody/tr[1]/td[4]/div/a";
		String unit_number_loc = "]/table/tbody/tr[1]/td[5]/div/a";
		String payment_account_loc = "]/table/tbody/tr[1]/td[12]/div";
		String payment_date_loc = "]/table/tbody/tr[1]/td[13]/div";
		String check_number_loc = "]/table/tbody/tr[1]/td[15]/div";
		String payment_amount_loc = "]/table/tbody/tr[1]/td[16]/div";
		String split_account_description_loc = "]/table/tbody/tr[1]/td[17]/div";
		String temp = null;
		

			//save the transaction data
		    //get bill number
		     temp = first_part +i+bill_number_loc;
		     bill_number = driver.findElement(By.xpath(temp)).getText();
		     //get portfolio name
		     temp = first_part +i+portfolio_name_loc;
		     portfolio_name = driver.findElement(By.xpath(temp)).getText();
		     //get building number
		     temp = first_part +i+building_number_loc;
		     if(isVisible("xpath="+temp))
		     {
		    	building_number = driver.findElement(By.xpath(temp)).getText();
		     }
		     else
		     {
		    	 building_number = "";
		     }
		     //get unit number
		     //temp = first_part +i+unit_number_loc;
		    // unit_number = driver.findElement(By.xpath(temp)).getText();
		     //get payment account
		     temp = first_part +i+payment_account_loc;
		     payment_account = driver.findElement(By.xpath(temp)).getText();
		     //get payment date
		     temp = first_part +i+payment_date_loc;
		     payment_date = driver.findElement(By.xpath(temp)).getText();
		     //get check number
		     temp = first_part +i+check_number_loc;
		     check_number = driver.findElement(By.xpath(temp)).getText();
		     //get payment amount
		     temp = first_part +i+payment_amount_loc;
		     payment_amount = driver.findElement(By.xpath(temp)).getText();
		     //get split account description
		     temp = first_part +i+split_account_description_loc;
		     split_account_description = driver.findElement(By.xpath(temp)).getText();
	}
	
	public BufferedWriter writedata (BufferedWriter BW, String attachmentname) throws IOException
	{
		 BW.write(bill_number);
		 BW.write("\t");
		 BW.write(portfolio_name);
		 BW.write("\t");
		 BW.write(building_number);
		 BW.write("\t");
		// BW.write(unit_number);
		 //BW.write("\t");
		 BW.write(payment_account);
		 BW.write("\t");
		 BW.write(payment_date);
		 BW.write("\t");
		 BW.write(check_number);
		 BW.write("\t");
		 BW.write(payment_amount);
		 BW.write("\t");
		 BW.write(split_account_description);
		 BW.write("\t");
		 BW.write(attachmentname);
		 BW.write("\t");
		 BW.newLine();  
		 return(BW);
	}
	
	public void selecttransaction1() throws Exception
	{
		int j = 0;
		
		
		String TestFile = "/Users/Karthik/Downloads/temp1.txt";
		String location = "downloads/batch1";

		File FC = new File(TestFile);//Created object of java File class.
		try {
			FC.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				  
		FileWriter FW = null;
		try {
			FW = new FileWriter(TestFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter BW = new BufferedWriter(FW);
		
		driver.findElement(By.xpath(".//*[@id='gridPanelPager']")).sendKeys("5100");
		waitMilliseconds(2000);
		press("ENTER");
		waitMilliseconds(10000);
	
		WebElement table = driver.findElement(By.id("ext-gen100")); 
		
		//Get number of rows in table 
		int numOfRow = table.findElements(By.tagName("tr")).size(); 
  	    String first_part = ".//*[@id='ext-gen100']/div[";
		String second_part = "]/table/tbody/tr[1]/td[2]/div/a";
		
		WebElement attachments = null;
		int noofattachments = 0;
		String attachmentpath1 = ".//*[@id='billAttachmentsTable']/tbody/tr[";
		String attachmentpath2 = "]/td[1]/a";
		
		String attachment = null;
		boolean write = false;

		  //Loop through the rows and get the second column and put it in a list
		  //for (int i=1; i<=numOfRow; i++){
		  //for (int i=1;i<=50; i++){
		  //for (int i=50;i<=100; i++){
		    //for (int i=101;i<=200; i++){
			//for(int i=401;i<=700; i++){
		for(int i=701;i<=1000; i++){
			   if(i>=1)
				   j=i-1; 
			   //Prepared final xpath of specific cell as per values of i and j.
		       String final_xpath = first_part+i+second_part;
		       String scroll_place = "xpath="+ first_part+j+second_part;
		       scrollTo(scroll_place);
		       waitMilliseconds(500);

		       gettransactiondata(i);
		      
		       //open the invoice in new tab to avoid reloading the page everytime
		       String url = driver.findElement(By.xpath(final_xpath)).getAttribute("href");
		       String filename = null;
		       openInNewTab(url);
			   waitMilliseconds(2800);
			   //save the attachment
			   //open the invoice in new tab to avoid reloading the page everytime
			 //Get number of attachments
				attachments = driver.findElement(By.id("billAttachmentsTable")); 
				noofattachments = attachments.findElements(By.tagName("tr")).size();
		       if(isVisible("xpath=.//*[@id='billAttachmentsTable']/caption"))
		       {
		    	   for (int l=1;l<noofattachments; l++){
		    	   
		    		   //attachment = "xpath="+attachmentpath1 + l+ attachmentpath2;
		    		   //attachment = attachmentpath1 + l+ attachmentpath2;
		    		  // click(attachment);
		    		   
		    		  /* Actions action= new Actions(driver);
		    		   action.moveToElement(driver.findElement(By.xpath(attachment)));
		    		   action.contextClick(driver.findElement(By.xpath(attachment))).build().perform();  /* this will perform right click */
		    		   /*WebElement elementOpen = driver.findElement(By.
		    				   xpath("//option[contains(text(),'Save Link As')]"));
		    	
		    		  // WebElement elementOpen = driver.findElement(By.xpath("//option[contains(text(),'Save Link As')]")); /*This will select menu after right click */
		    		   //elementOpen.click();
		    		   
		    		   //action.contextClick(driver.findElement(By.xpath(attachment))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		    		   attachment = attachmentpath1 + l+ attachmentpath2;
		    		   filename = bill_number+"_"+ "Attachment#"+l+"_"+driver.findElement(By.xpath(attachment)).getText();
		    		   /*if(filename.isEmpty())
		    		   {
		    			   filename = "EMPTY";
		    		   }*/
		    		   downloadLinkTarget(driver.findElement(By.xpath(attachment)),filename,location);
		    		   //write = true;
		    		   writedata(BW, filename);
		    	   }
		       }
			   
		       /*String selectAll = Keys.chord(Keys.COMMAND, Keys.SHIFT,"j");
		       Actions keyAction = new Actions(driver);     
		       keyAction.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).sendKeys("j").perform();*/

			   //waitMilliseconds(2000);
			   closeTab(); //closes the transaction tab
			   
			   /*if(write == true)
			   {
				   writedata(BW, filename);
				   write = false;
			   }*/
		  }   
	      
		  try {
			BW.close();
	       } catch (IOException e) {
			// TODO Auto-generated catch block
	    	BW.close();
			e.printStackTrace();
	       }      

	}
	
	public void selecttransaction2() throws Exception
	{
		int j = 0;
		
		
		String TestFile = "/Users/Karthik/Downloads/temp2.txt";
		String location = "downloads/batch2";

		File FC = new File(TestFile);//Created object of java File class.
		try {
			FC.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				  
		FileWriter FW = null;
		try {
			FW = new FileWriter(TestFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter BW = new BufferedWriter(FW);
		
		driver.findElement(By.xpath(".//*[@id='gridPanelPager']")).sendKeys("5100");
		waitMilliseconds(2000);
		press("ENTER");
		waitMilliseconds(10000);
	
		WebElement table = driver.findElement(By.id("ext-gen100")); 
		
		//Get number of rows in table 
		int numOfRow = table.findElements(By.tagName("tr")).size(); 
  	    String first_part = ".//*[@id='ext-gen100']/div[";
		String second_part = "]/table/tbody/tr[1]/td[2]/div/a";
		
		WebElement attachments = null;
		int noofattachments = 0;
		String attachmentpath1 = ".//*[@id='billAttachmentsTable']/tbody/tr[";
		String attachmentpath2 = "]/td[1]/a";
		
		String attachment = null;
		boolean write = false;

		  //Loop through the rows and get the second column and put it in a list
		  //for (int i=1; i<=numOfRow; i++){
		 // for (int i=1001;i<=2000; i++){
			for (int i=1658;i<=2000; i++){	
			   if(i>=1)
				   j=i-1; 
			   //Prepared final xpath of specific cell as per values of i and j.
		       String final_xpath = first_part+i+second_part;
		       String scroll_place = "xpath="+ first_part+j+second_part;
		       scrollTo(scroll_place);
		       waitMilliseconds(1000);

		       gettransactiondata(i);
		      
		       //open the invoice in new tab to avoid reloading the page everytime
		       String url = driver.findElement(By.xpath(final_xpath)).getAttribute("href");
		       String filename = null;
		       openInNewTab(url);
			   waitMilliseconds(2000);
			   //save the attachment
			   //open the invoice in new tab to avoid reloading the page everytime
			 //Get number of attachments
				attachments = driver.findElement(By.id("billAttachmentsTable")); 
				noofattachments = attachments.findElements(By.tagName("tr")).size();
		       if(isVisible("xpath=.//*[@id='billAttachmentsTable']/caption"))
		       {
		    	   for (int l=1;l<noofattachments; l++){
		    	   
		    		   //attachment = "xpath="+attachmentpath1 + l+ attachmentpath2;
		    		   //attachment = attachmentpath1 + l+ attachmentpath2;
		    		  // click(attachment);
		    		   
		    		  /* Actions action= new Actions(driver);
		    		   action.moveToElement(driver.findElement(By.xpath(attachment)));
		    		   action.contextClick(driver.findElement(By.xpath(attachment))).build().perform();  /* this will perform right click */
		    		   /*WebElement elementOpen = driver.findElement(By.
		    				   xpath("//option[contains(text(),'Save Link As')]"));
		    	
		    		  // WebElement elementOpen = driver.findElement(By.xpath("//option[contains(text(),'Save Link As')]")); /*This will select menu after right click */
		    		   //elementOpen.click();
		    		   
		    		   //action.contextClick(driver.findElement(By.xpath(attachment))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		    		   attachment = attachmentpath1 + l+ attachmentpath2;
		    		   filename = bill_number+"_"+ "Attachment#"+l+"_"+driver.findElement(By.xpath(attachment)).getText();
		    		   /*if(filename.isEmpty())
		    		   {
		    			   filename = "EMPTY";
		    		   }*/
		    		   downloadLinkTarget(driver.findElement(By.xpath(attachment)),filename,location);
		    		   //write = true;
		    		   writedata(BW, filename);
		    	   }
		       }
			   
		       /*String selectAll = Keys.chord(Keys.COMMAND, Keys.SHIFT,"j");
		       Actions keyAction = new Actions(driver);     
		       keyAction.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).sendKeys("j").perform();*/

			   //waitMilliseconds(2000);
			   closeTab(); //closes the transaction tab
			   
			   /*if(write == true)
			   {
				   writedata(BW, filename);
				   write = false;
			   }*/
		  }   
	      
		  try {
			BW.close();
	       } catch (IOException e) {
			// TODO Auto-generated catch block
	    	BW.close();
			e.printStackTrace();
	       }      

	}
	
	public void selecttransaction3() throws Exception
	{
		int j = 0;
		
		
		String TestFile = "/Users/Karthik/Downloads/temp3.txt";
		String location = "downloads/batch3";

		File FC = new File(TestFile);//Created object of java File class.
		try {
			FC.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				  
		FileWriter FW = null;
		try {
			FW = new FileWriter(TestFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter BW = new BufferedWriter(FW);
		
		driver.findElement(By.xpath(".//*[@id='gridPanelPager']")).sendKeys("5100");
		waitMilliseconds(2000);
		press("ENTER");
		waitMilliseconds(10000);
	
		WebElement table = driver.findElement(By.id("ext-gen100")); 
		
		//Get number of rows in table 
		int numOfRow = table.findElements(By.tagName("tr")).size(); 
  	    String first_part = ".//*[@id='ext-gen100']/div[";
		String second_part = "]/table/tbody/tr[1]/td[2]/div/a";
		
		WebElement attachments = null;
		int noofattachments = 0;
		String attachmentpath1 = ".//*[@id='billAttachmentsTable']/tbody/tr[";
		String attachmentpath2 = "]/td[1]/a";
		
		String attachment = null;
		boolean write = false;

		  //Loop through the rows and get the second column and put it in a list
		  //for (int i=1; i<=numOfRow; i++){
		  //for (int i=2301;i<=2800; i++){
			//for (int i=2801;i<=3000; i++){
		for (int i=2900;i<=3000; i++){
			   if(i>=1)
				   j=i-1; 
			   //Prepared final xpath of specific cell as per values of i and j.
		       String final_xpath = first_part+i+second_part;
		       String scroll_place = "xpath="+ first_part+j+second_part;
		       scrollTo(scroll_place);
		       waitMilliseconds(1000);

		       gettransactiondata(i);
		      
		       //open the invoice in new tab to avoid reloading the page everytime
		       String url = driver.findElement(By.xpath(final_xpath)).getAttribute("href");
		       String filename = null;
		       openInNewTab(url);
			   waitMilliseconds(2000);
			   //save the attachment
			   //open the invoice in new tab to avoid reloading the page everytime
			 //Get number of attachments
				attachments = driver.findElement(By.id("billAttachmentsTable")); 
				noofattachments = attachments.findElements(By.tagName("tr")).size();
		       if(isVisible("xpath=.//*[@id='billAttachmentsTable']/caption"))
		       {
		    	   for (int l=1;l<noofattachments; l++){
		    	   
		    		   //attachment = "xpath="+attachmentpath1 + l+ attachmentpath2;
		    		   //attachment = attachmentpath1 + l+ attachmentpath2;
		    		  // click(attachment);
		    		   
		    		  /* Actions action= new Actions(driver);
		    		   action.moveToElement(driver.findElement(By.xpath(attachment)));
		    		   action.contextClick(driver.findElement(By.xpath(attachment))).build().perform();  /* this will perform right click */
		    		   /*WebElement elementOpen = driver.findElement(By.
		    				   xpath("//option[contains(text(),'Save Link As')]"));
		    	
		    		  // WebElement elementOpen = driver.findElement(By.xpath("//option[contains(text(),'Save Link As')]")); /*This will select menu after right click */
		    		   //elementOpen.click();
		    		   
		    		   //action.contextClick(driver.findElement(By.xpath(attachment))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		    		   attachment = attachmentpath1 + l+ attachmentpath2;
		    		   filename = bill_number+"_"+ "Attachment#"+l+"_"+driver.findElement(By.xpath(attachment)).getText();
		    		   /*if(filename.isEmpty())
		    		   {
		    			   filename = "EMPTY";
		    		   }*/
		    		   downloadLinkTarget(driver.findElement(By.xpath(attachment)),filename,location);
		    		   //write = true;
		    		   writedata(BW, filename);
		    	   }
		       }
			   
		       /*String selectAll = Keys.chord(Keys.COMMAND, Keys.SHIFT,"j");
		       Actions keyAction = new Actions(driver);     
		       keyAction.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).sendKeys("j").perform();*/

			   //waitMilliseconds(2000);
			   closeTab(); //closes the transaction tab
			   
			   /*if(write == true)
			   {
				   writedata(BW, filename);
				   write = false;
			   }*/
		  }   
	      
		  try {
			BW.close();
	       } catch (IOException e) {
			// TODO Auto-generated catch block
	    	BW.close();
			e.printStackTrace();
	       }      

	}
	
	public void selecttransaction4() throws Exception
	{
		int j = 0;
		
		
		String TestFile = "/Users/Karthik/Downloads/temp4.txt";
		String location = "downloads/batch4";

		File FC = new File(TestFile);//Created object of java File class.
		try {
			FC.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				  
		FileWriter FW = null;
		try {
			FW = new FileWriter(TestFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter BW = new BufferedWriter(FW);
		
		driver.findElement(By.xpath(".//*[@id='gridPanelPager']")).sendKeys("5100");
		waitMilliseconds(2000);
		press("ENTER");
		waitMilliseconds(10000);
	
		WebElement table = driver.findElement(By.id("ext-gen100")); 
		
		//Get number of rows in table 
		int numOfRow = table.findElements(By.tagName("tr")).size(); 
  	    String first_part = ".//*[@id='ext-gen100']/div[";
		String second_part = "]/table/tbody/tr[1]/td[2]/div/a";
		
		WebElement attachments = null;
		int noofattachments = 0;
		String attachmentpath1 = ".//*[@id='billAttachmentsTable']/tbody/tr[";
		String attachmentpath2 = "]/td[1]/a";
		
		String attachment = null;
		boolean write = false;

		  //Loop through the rows and get the second column and put it in a list
		  //for (int i=1; i<=numOfRow; i++){
		  for (int i=3001;i<=4000; i++){	  
			   if(i>=1)
				   j=i-1; 
			   //Prepared final xpath of specific cell as per values of i and j.
		       String final_xpath = first_part+i+second_part;
		       String scroll_place = "xpath="+ first_part+j+second_part;
		       scrollTo(scroll_place);
		       waitMilliseconds(1000);

		       gettransactiondata(i);
		      
		       //open the invoice in new tab to avoid reloading the page everytime
		       String url = driver.findElement(By.xpath(final_xpath)).getAttribute("href");
		       String filename = null;
		       openInNewTab(url);
			   waitMilliseconds(2000);
			   //save the attachment
			   //open the invoice in new tab to avoid reloading the page everytime
			 //Get number of attachments
				attachments = driver.findElement(By.id("billAttachmentsTable")); 
				noofattachments = attachments.findElements(By.tagName("tr")).size();
		       if(isVisible("xpath=.//*[@id='billAttachmentsTable']/caption"))
		       {
		    	   for (int l=1;l<noofattachments; l++){
		    	   
		    		   //attachment = "xpath="+attachmentpath1 + l+ attachmentpath2;
		    		   //attachment = attachmentpath1 + l+ attachmentpath2;
		    		  // click(attachment);
		    		   
		    		  /* Actions action= new Actions(driver);
		    		   action.moveToElement(driver.findElement(By.xpath(attachment)));
		    		   action.contextClick(driver.findElement(By.xpath(attachment))).build().perform();  /* this will perform right click */
		    		   /*WebElement elementOpen = driver.findElement(By.
		    				   xpath("//option[contains(text(),'Save Link As')]"));
		    	
		    		  // WebElement elementOpen = driver.findElement(By.xpath("//option[contains(text(),'Save Link As')]")); /*This will select menu after right click */
		    		   //elementOpen.click();
		    		   
		    		   //action.contextClick(driver.findElement(By.xpath(attachment))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		    		   attachment = attachmentpath1 + l+ attachmentpath2;
		    		   filename = bill_number+"_"+ "Attachment#"+l+"_"+driver.findElement(By.xpath(attachment)).getText();
		    		   /*if(filename.isEmpty())
		    		   {
		    			   filename = "EMPTY";
		    		   }*/
		    		   downloadLinkTarget(driver.findElement(By.xpath(attachment)),filename,location);
		    		   //write = true;
		    		   writedata(BW, filename);
		    	   }
		       }
			   
		       /*String selectAll = Keys.chord(Keys.COMMAND, Keys.SHIFT,"j");
		       Actions keyAction = new Actions(driver);     
		       keyAction.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).sendKeys("j").perform();*/

			   //waitMilliseconds(2000);
			   closeTab(); //closes the transaction tab
			   
			   /*if(write == true)
			   {
				   writedata(BW, filename);
				   write = false;
			   }*/
		  }   
	      
		  try {
			BW.close();
	       } catch (IOException e) {
			// TODO Auto-generated catch block
	    	BW.close();
			e.printStackTrace();
	       }      

	}
	
	public void selecttransaction5() throws Exception
	{
		int j = 0;
		//private String downloadlocation1 = new File(filesDir, "downloads").getPath() + "/";

		String location = "downloads/batch5";
		String TestFile = "/Users/Karthik/Downloads/temp5.txt";
		File FC = new File(TestFile);//Created object of java File class.
		try {
			FC.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				  
		FileWriter FW = null;
		try {
			FW = new FileWriter(TestFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter BW = new BufferedWriter(FW);
		
		driver.findElement(By.xpath(".//*[@id='gridPanelPager']")).sendKeys("5100");
		waitMilliseconds(2000);
		press("ENTER");
		waitMilliseconds(10000);
	
		WebElement table = driver.findElement(By.id("ext-gen100")); 
		
		//Get number of rows in table 
		int numOfRow = table.findElements(By.tagName("tr")).size(); 
  	    String first_part = ".//*[@id='ext-gen100']/div[";
		String second_part = "]/table/tbody/tr[1]/td[2]/div/a";
		
		WebElement attachments = null;
		int noofattachments = 0;
		String attachmentpath1 = ".//*[@id='billAttachmentsTable']/tbody/tr[";
		String attachmentpath2 = "]/td[1]/a";
		
		String attachment = null;
		boolean write = false;

		  //Loop through the rows and get the second column and put it in a list
		  //for (int i=1; i<=numOfRow; i++){
		  for (int i=4000;i<=5078; i++){	  
			   if(i>=1)
				   j=i-1; 
			   //Prepared final xpath of specific cell as per values of i and j.
		       String final_xpath = first_part+i+second_part;
		       String scroll_place = "xpath="+ first_part+j+second_part;
		       scrollTo(scroll_place);
		       waitMilliseconds(1000);

		       gettransactiondata(i);
		      
		       //open the invoice in new tab to avoid reloading the page everytime
		       String url = driver.findElement(By.xpath(final_xpath)).getAttribute("href");
		       String filename = null;
		       openInNewTab(url);
			   waitMilliseconds(2000);
			   //save the attachment
			   //open the invoice in new tab to avoid reloading the page everytime
			 //Get number of attachments
				attachments = driver.findElement(By.id("billAttachmentsTable")); 
				noofattachments = attachments.findElements(By.tagName("tr")).size();
		       if(isVisible("xpath=.//*[@id='billAttachmentsTable']/caption"))
		       {
		    	   for (int l=1;l<noofattachments; l++){
		    	   
		    		   //attachment = "xpath="+attachmentpath1 + l+ attachmentpath2;
		    		   //attachment = attachmentpath1 + l+ attachmentpath2;
		    		  // click(attachment);
		    		   
		    		  /* Actions action= new Actions(driver);
		    		   action.moveToElement(driver.findElement(By.xpath(attachment)));
		    		   action.contextClick(driver.findElement(By.xpath(attachment))).build().perform();  /* this will perform right click */
		    		   /*WebElement elementOpen = driver.findElement(By.
		    				   xpath("//option[contains(text(),'Save Link As')]"));
		    	
		    		  // WebElement elementOpen = driver.findElement(By.xpath("//option[contains(text(),'Save Link As')]")); /*This will select menu after right click */
		    		   //elementOpen.click();
		    		   
		    		   //action.contextClick(driver.findElement(By.xpath(attachment))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		    		   attachment = attachmentpath1 + l+ attachmentpath2;
		    		   filename = bill_number+"_"+ "Attachment#"+l+"_"+driver.findElement(By.xpath(attachment)).getText();
		    		   /*if(filename.isEmpty())
		    		   {
		    			   filename = "EMPTY";
		    		   }*/
		    		   downloadLinkTarget(driver.findElement(By.xpath(attachment)),filename,location);
		    		   //write = true;
		    		   writedata(BW, filename);
		    	   }
		       }
			   
		       /*String selectAll = Keys.chord(Keys.COMMAND, Keys.SHIFT,"j");
		       Actions keyAction = new Actions(driver);     
		       keyAction.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).sendKeys("j").perform();*/

			   //waitMilliseconds(2000);
			   closeTab(); //closes the transaction tab
			   
			   /*if(write == true)
			   {
				   writedata(BW, filename);
				   write = false;
			   }*/
		  }   
	      
		  try {
			BW.close();
	       } catch (IOException e) {
			// TODO Auto-generated catch block
	    	BW.close();
			e.printStackTrace();
	       }      

	}
	protected String downloadLinkTarget(WebElement element, String filename, String location) {
        String result = null;
        if (element != null) {
            String href = element.getAttribute("href");
            if (href != null) {
                result = downloadContentFrom(href,filename,location);
            } else {
                throw new SlimFixtureException(false, "Could not determine url to download from");
            }
        }
        return result;
    }

    /**
     * Downloads binary content from specified url (using the browser's cookies).
     * @param urlOrLink url to download from
     * @return link to downloaded file
     */
    public String downloadContentFrom(String urlOrLink, String filename, String location) {
        String result = null;
        if (urlOrLink != null) {
            String url = getUrl(urlOrLink);
            BinaryHttpResponse resp = new BinaryHttpResponse();
            getUrlContent(url, resp);
            byte[] content = resp.getResponseContent();
            if (content == null) {
                result = resp.getResponse();
            } else {
                //String fileName = resp.getFileName();
                String baseName = FilenameUtils.getBaseName(filename);
                String ext = FilenameUtils.getExtension(filename);
                String downloadedFile = FileUtil.saveToFile(getDownloadName(baseName,location), ext, content);
                String wikiUrl = getWikiUrl(downloadedFile);
                if (wikiUrl != null) {
                    // make href to file
                    result = String.format("<a href=\"%s\">%s</a>", wikiUrl, filename);
                } else {
                    result = downloadedFile;
                }
            }
        }
        return result;
    }
	
    private String getDownloadName(String baseName, String location) {
    	String downloadlocation = new File(filesDir, location).getPath() + "/";
        return downloadlocation + baseName;
    }

}
