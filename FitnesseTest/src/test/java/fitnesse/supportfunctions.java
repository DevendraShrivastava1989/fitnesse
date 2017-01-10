package fitnesse;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;

import utility.JavaHelpers;

public class supportfunctions {
	JavaHelpers JH = new JavaHelpers();
		
		public int generaterandomnumber()
		{
			Random t = new Random();
		    int i = t.nextInt(10);
		    if(i == 0) i++;
		   return i;
		}
	
		public String returnSubstring(String name, int value)
		{
			String firstname = JH.ToGetFistNthWordFromString(name,1);
		    return firstname;
		}
		
		// Replace null  with 0  
		public int replaceNullwithZero(String input)
		{
			 if(input==null)
			 {
			 	input="0";
		     }
	    	return Integer.parseInt(input);
		}
		
		public String compareStringPropertySearch(String str1,String str2)
		{
			String result="FAIL";
			if(str2==null){ result="PASS";}
			else{
				String source=str1.toUpperCase();
				String target=str2.toUpperCase();
				if(target.contains(source)||source.contains(target))
				{
					result="PASS";
				}	
			}
			return result;
			
		}
		
		//Generic function
		public String compareString(String str1,String str2)
		{
			String result="FAIL";
			if(str2==null){ result="PASS";}
			else{
				String source=str1.toUpperCase();
				String target=str2.toUpperCase();
				if(target.contains(source)||source.contains(target))
				{
					result="PASS";
				}	
			}
			return result;
			
		}

}
