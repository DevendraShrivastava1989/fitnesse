package utility;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Browser 
{
	private WebDriver driver;
	
	/*
	Set up method to lunch browser
	*/
	public WebDriver setUp(String browser, String environment, String OS , String version , Method method) throws Exception 
	 {	   
		
		
		//Adding random wait between each thread
		Random t = new Random();
	    Thread.sleep(t.nextInt(15)*1000);
	    String saucelabs_url = "http://" + Constants.SL_USERNAME + ":" + Constants.SL_ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
		
		if(environment.equalsIgnoreCase("Local") )
		{
			System.out.println("===========================================================" );
			//Reporter.log("===========================================================" );
			System.out.println("RUNNING THE TEST : "+ method.getName());
			//Reporter.log("RUNNING THE TEST : "+ method.getName() );
			System.out.println("===========================================================" );
			//Reporter.log("===========================================================" );
			
			if(browser.equalsIgnoreCase("firefox"))
			{
				FirefoxProfile profile = new FirefoxProfile();
				profile.setEnableNativeEvents(true);
				driver = new FirefoxDriver(profile);
				
			}
			
			else if(browser.equalsIgnoreCase("ie"))
			{  
			   System.setProperty("webdriver.ie.driver", "src/test/resources/BrowserDrivers/IEDriverServer_2_48.exe");
			   driver = new InternetExplorerDriver();
			   driver.manage().window().maximize();
			   
			}
			
			else if(browser.equalsIgnoreCase("chrome"))
			{
				String os = System.getProperty("os.name");
				if(os.contains("Windows"))
				{
					 //Use the below if running in windows 
				  System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDrivers/chromedriver_2_25_Win.exe");
				}
				else
				{
					 //Use the below if running on linux
					   System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDrivers/chromedriver_2_25_Mac");
				}
			  
				driver = new ChromeDriver();
			}
		}
		
		else if(environment.equalsIgnoreCase("SauceLabs"))
		{
			System.out.println("===========================================================" );
			//Reporter.log("===========================================================" );
			System.out.println("Pre-requisite : Launching Browser on SauceLabs" );
			//Reporter.log("Pre-requisite : Launching Browser on SauceLabs" );
			
			// Choose the browser
				DesiredCapabilities capabilities = new DesiredCapabilities(); 
				if(browser.equalsIgnoreCase("firefox"))
				{
					capabilities = DesiredCapabilities.firefox();
				}
				
				else if(browser.equalsIgnoreCase("ie"))
				{  
					capabilities = DesiredCapabilities.internetExplorer();
				}
				
				else if(browser.equalsIgnoreCase("chrome"))
				{
					capabilities = DesiredCapabilities.chrome();
				}
			
			// Choose the OS/version
				capabilities.setCapability("platform", OS);
				capabilities.setCapability("version", version);
				capabilities.setCapability("screenResolution", "1280x960");
				capabilities.setCapability("name", method.getName());
				capabilities.setCapability("maxDuration", "10800");
				
	        // Create the connection to Sauce Labs to run the tests
				this.driver = new RemoteWebDriver(new URL(saucelabs_url),capabilities);
				((RemoteWebDriver) this.driver).setFileDetector(new LocalFileDetector());
				
	        
		}
	
		String os = System.getProperty("os.name");
		if(os.contains("Mac"))
		{
			maximizeScreen(driver);
		}
		else
		{
			driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		return driver;
	   
	 }
	
	public void maximizeScreen(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.open('','testwindow','width=400,height=200')");
		driver.close();
		driver.switchTo().window("testwindow");
		js.executeScript("window.moveTo(0,0);");
		js.executeScript("window.resizeTo(1280,800);");
	  }

	
	/*
	Tear down method to quit browser after test execution
	*/
	public void tearDown() throws Exception 
	  {  
		    try
	        {
		    	driver.close();
	            Thread.sleep(5000);
	            driver.quit();
	        }
	        catch(Exception e)
	        {
	        }
		   
	  }
	
}
