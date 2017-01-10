package fitnesse;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;

import nl.hsac.fitnesse.sample.FundaTest;
import nl.hsac.fitnesse.fixture.util.selenium.SeleniumHelper;

import utility.Browser;
import utility.Constants;
import utility.JavaHelpers;
 
public class mathoperations extends FundaTest {
	
	WebDriver driver = getSeleniumHelper().driver();
	private Browser b = new Browser();
	
	
	/*public void setNumber1(double number1) {
		this.number1 = number1;
	  }
	  
	public void setNumber2(double number2) {
	    this.number2 = number2;
	  }*/
	  

	//public static void main(String[] args)
	public double add(double number1, double number2)
	{
		double result = 0.0;
		result = number1+number2;
		//getSeleniumHelper().navigate().to("http://www.google.com");
		//driver.get("http://www.google.com");
		if(result>0.0 || result < 0.0)
		{
			return(result);
		}
		else
		{
			return(0.0);
		}
		
	}
	
	public double checknull(double number1)
	{
		if(number1>0.0 || number1 < 0.0)
		{
			return(number1);
		}
		else
		{
			return(0.0);
		}
		
	}
	
	public String concatenateinvestornameyardi(String lastname, String firstname)
	{
		String finalstring;
		finalstring = lastname.concat(", ");
		finalstring = finalstring.concat(firstname);
		return finalstring;		
	}

}
