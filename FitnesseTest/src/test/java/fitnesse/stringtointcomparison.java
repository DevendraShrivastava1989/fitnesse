package fitnesse;

import java.text.NumberFormat;
import java.text.ParseException;

public class stringtointcomparison {
	private String Propertyware;
	private String Yardi;
	public String compresult;
	
	public void setPropertyware(String Propertyware) {
		this.Propertyware = Propertyware;
	  }
	  
	public void setYardi(String Yardi) {
	    this.Yardi = Yardi;
	  }
	  

	//public static void main(String[] args)
	public String comparison()
	{
				
		if(Propertyware.contains("-") || Yardi.contains("-"))
		{
			if(Propertyware.equals(Yardi))
				 compresult = "MATCH";
			else
				compresult = "MISMATCH";
		}
		else
		{
			if(Propertyware.contains("$") && Yardi.contains("$"))
			{
				NumberFormat format = NumberFormat.getCurrencyInstance();
				Number number1 = null;
				Number number2 = null;
				
				try {
					number1 = format.parse(Propertyware);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					number2 = format.parse(Yardi);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
											
				if(Math.abs(number1.floatValue()-number2.floatValue()) > 0.5)
				{
					compresult = "MISMATCH";
				}
				else
				{
					compresult = "MATCH";
				}
			}
			else if(Propertyware.contains("%") && Yardi.contains("%"))
			{
				NumberFormat format = NumberFormat.getPercentInstance();
				Number number1 = null;
				Number number2 = null;
				try {
					number1 = format.parse(Propertyware);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					number2 = format.parse(Yardi);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
											
				if(Math.abs(number1.floatValue()-number2.floatValue()) > 0.5)
				{
					compresult = "MISMATCH";
				}
				else
				{
					compresult = "MATCH";
				}
			}
			else
			{
				compresult = "MISMATCH";
			}
		}
		
		return(compresult);
	}
	
	public String setConcatenate()
	{
			
		compresult = Propertyware.concat(" ");
		compresult = Propertyware.concat(Yardi);
	
		return(compresult);
	}
	
}
