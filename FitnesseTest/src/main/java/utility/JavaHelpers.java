package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TimeZone;
import  java.sql.Connection;        
import  java.sql.Statement;     
import  java.sql.ResultSet;     
import  java.sql.DriverManager;     
import  java.sql.SQLException; 

public class JavaHelpers 
{
	
	 public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException 
	 {
		
	 }
	 
	 
	 public String Database_ExecuteQuery(String sqlquery, int column, int row)
	 {
		 //Query to Execute      
         //String query = "select *  from  properties.tbl_yield_check_details;";  
          
		 String data = "";
		 
         try 
         { 
        	//Load mysql jdbc driver     
        	 Class.forName("com.mysql.jdbc.Driver"); 
        	 
        	//Create Connection to DB       
             Connection con;
     		 con = DriverManager.getConnection(Constants.dbUrl,Constants.db_username,Constants.db_password); 
         
              //Create Statement Object       
             Statement stmt = con.createStatement();                  
      
              // Execute the SQL Query. Store results in ResultSet        
             ResultSet rs= stmt.executeQuery(sqlquery);                         
       
             // While Loop to iterate through all data and print results 
             int r=1;
             try{
            	 
             while (rs.next())
             	{
            	 	 if(r==row)	
            	 	 {
            	 		data = rs.getString(column);          
                        //System.out.println(data); //Devendra  
                        
                        break;
            	 	 }
            	 	 r++;
                     
                }  
             }
             catch (NullPointerException | NumberFormatException e) {} 
              // closing DB Connection       
             con.close();
             rs.close();
             stmt.close();
        
        	 
         } catch (ClassNotFoundException | SQLException e) {}         
     
         return data; 
	 }
	 
	 public void Database_UpdateQuery(String sqlquery)
	 {
		 //Query to Update      
         //String query = "update properties.tbl_yield_check_details set rent='1200'...";  
		 
         try 
         { 
        	//Load mysql jdbc driver     
        	 Class.forName("com.mysql.jdbc.Driver"); 
        	 
        	//Create Connection to DB       
             Connection con;
     		 con = DriverManager.getConnection(Constants.dbUrl,Constants.db_username,Constants.db_password); 
         
              //Create Statement Object       
             Statement stmt = con.createStatement();                  
      
              // Execute the SQL Query. Store results in ResultSet        
             stmt.executeUpdate(sqlquery);                         
       
             // closing DB Connection       
             con.close();
             stmt.close();
        
          } catch (ClassNotFoundException | SQLException e) {}         

	 }
	 
	 
	 public List<String> Database_ExecuteQuery_DataRange(String sqlquery, int maxRow, int maxColumn)
	 {
		 //Query to Execute      
         //String query = "select *  from  properties.tbl_yield_check_details;";  
		 
		 List<String> data = new ArrayList<String>();
  		
		 
         try 
         { 
        	//Load mysql jdbc driver     
        	 Class.forName("com.mysql.jdbc.Driver"); 
        	 
        	//Create Connection to DB       
             Connection con;
     		 con = DriverManager.getConnection(Constants.dbUrl,Constants.db_username,Constants.db_password); 
         
             //Create Statement Object       
             Statement stmt = con.createStatement();                  
      
            // Execute the SQL Query. Store results in ResultSet        
            ResultSet rs= stmt.executeQuery(sqlquery);   
             
            
            int r=1; 
            
     		try {
     			while (rs.next())
     			{
	     			if(r <= maxRow)	
	           	 	{
	     				for(int i=1;i<=maxColumn; i++)
	     				{
	     					data.add(rs.getString(i));
	     				}	
	     				
	           	 	}
	     			else
	     			{
	     				break; 
	     			}
	     			
	           	 	r++;
     			}
     		} catch (SQLException e) {}     
     		
       
              // closing DB Connection       
             con.close();
             
        	 
         } catch (ClassNotFoundException | SQLException e) {}         
     
		return data;        
	 }
	 
	 // Verify whether data - double is sorted or not
		public boolean IsDataSortedDouble(List<Double> listdata, String sorttype)
		 {
			 boolean isSorted = false ; 
				
			 //List<Integer> temp  = new ArrayList<Integer>(listdata.size());
			 List<Double> temp  = new ArrayList<Double>(listdata.size());

			 for (int i = 0 ; i<listdata.size();i++)
			 {
				 temp.add(listdata.get(i)) ;
			 }
			 
			 if(sorttype.equalsIgnoreCase("asc"))
			 {
				 Collections.sort(temp);
				 isSorted = temp.equals(listdata);
			 }
			 else if(sorttype.equalsIgnoreCase("dsc"))
			 {
				 Collections.sort(temp);
				 Collections.reverse(temp);
				 isSorted = temp.equals(listdata);
			 }
				
			 return isSorted;
		 }
		
		
	// Verify whether data - Strings is sorted or not
		public boolean IsDataSortedString(List<String> listdata, String sorttype)
		 {
			 boolean isSorted = false ; 
			
			 List<String> temp  = new ArrayList<String>(listdata.size());

			 for (int i = 0 ; i<listdata.size();i++)
			 {
				 temp.add(listdata.get(i)) ;
			 }
			 
			 if(sorttype.equalsIgnoreCase("asc"))
			 {
				 //Collections.sort(temp);
				 Collections.sort(temp, String.CASE_INSENSITIVE_ORDER);
				 isSorted = temp.equals(listdata);
			 }
			 else if(sorttype.equalsIgnoreCase("dsc"))
			 {
				 //Collections.sort(temp);
				 Collections.sort(temp, String.CASE_INSENSITIVE_ORDER);
				 Collections.reverse(temp);
				 isSorted = temp.equals(listdata);
			 }
				
			 return isSorted;
		 }
	 
	 
	 
	 
	 public void RunJar(String jarpath, String arg1, String arg2, String arg3 , String arg4, 
			 			String arg5, String arg6 , String arg7, String arg8, String arg9, 
			 			String arg10, String arg11) throws IOException
	 {
		ProcessBuilder pb = new ProcessBuilder("java", "-jar", jarpath,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);	
		Process p = pb.start();
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String s = "";
		while((s = in.readLine()) != null){
		    System.out.println(s);
		}
	 }
	 
	 
	 // To Get file absolute path
		 public String File_GetAbsolutePath(String path)
		 {
		      
		      File f = null;
		      boolean bool = false;
		      
		      try{
		         // create new files
		         f = new File(path);
		         
		         // returns true if the file exists
		         bool = f.exists();
		         
		         // if file exists
		         if(bool)
		         {
		            // get absolute path
		            path = f.getAbsolutePath();
		            
		            // prints
		            //System.out.print("Absolute Pathname = "+ path + "\n");
		         }
		      }catch(Exception e){
		         // if any error occurs
		         e.printStackTrace();
		      }
		      
			return path;
		   }
	
	
	// To get first nth words from String
		public String ToGetFistNthWordFromString(String text, int n)
		{
			String newstring = ""; 
			StringTokenizer st = new StringTokenizer(text);
		    for(int i = 0; i < n && st.hasMoreTokens(); i++) 
		    {
		        newstring = newstring + st.nextToken() + " ";
		    }
		    
		    return newstring; 
		}
	
	
	// To replace characters on String
		public static String ToReplaceCharactorOnString(String text , String replacechar, String newchar)
		{
			return text.replace(replacechar,newchar);
		}
	
	
	// To remove last n characters on String
		public String ToRemoveLastNCharactorOnString(String text , int n)
		{
			return text.substring(0,text.length() - n) ; 
		}
	
	
	// Convert text to currency format	e.g. 123 to $123.00
		public String CovertToUSCurrencyFormat(String input)
		{
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			return (nf.format(new BigDecimal(input)));
		}
		
		
	// Convert currency format to text	e.g. $123.00 to 123 
		public String USCurrencyFormatToString(String input)
		{
			// remove the $ and ,
			String s2 = input.replaceAll("[$,]", "");
			return s2;
		}
		
		
	//Round off value	
		public String RoundOffValues(String input)
		{
			float f = Float.parseFloat(input);
			//System.out.println(Float.toString(Math.round(f))); 
			return Float.toString(Math.round(f));
		}
		
	// To Get current system date & time	
		public String SystemDateTime()
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			return dateFormat.format(cal.getTime());
		}
		
		
	
	// To upload document on Windows
		public void UploadDoc(String document) throws AWTException, InterruptedException
		{
			//put path to your image in a clipboard
		    StringSelection ss = new StringSelection(document);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		    //imitate mouse events ENTER, CTRL+C, CTRL+V
		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    Thread.sleep(3000);
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    Thread.sleep(3000);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);

		    Thread.sleep(5000);
		}
		
		
		  /**
		  *@param offset  - specify the offset e.g -1 for yesterday, 0 - for today, 1 for tomorrow
		  * @return date in MM-dd-yyyy format
		  */
		public String GetSystemDate(int offset) 
		  {
		      /*DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");*/
		      DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		      dateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
		      Calendar cal = Calendar.getInstance();
		      cal.add(Calendar.DATE,offset);    
		      //System.out.println(dateFormat.format(cal.getTime()));
		      return dateFormat.format(cal.getTime());
		  }	
		
		  
	  /**
		  * @param offset  - specify the offset e.g -1 for yesterday, 0 - for today, 1 for tomorrow
		  * @return date in MM/dd/yyyy format
		  */
		public String GetSystemDate_slash(int offset) 
		  {
		      /*DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");*/
		      DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		      dateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
		      Calendar cal = Calendar.getInstance();
		      cal.add(Calendar.DATE,offset);    
		      //System.out.println(dateFormat.format(cal.getTime()));
		      return dateFormat.format(cal.getTime());
		  }	
		  
	// Get today's date(only date e.g 24  etc) in PST 
		public String GetSystemDate_Date(int offset) 
		  { 
		      DateFormat dateFormat = new SimpleDateFormat("dd");
		      dateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
		      Calendar cal = Calendar.getInstance();
		      cal.add(Calendar.DATE,offset);    
		      //System.out.println(dateFormat.format(cal.getTime()));
		      return dateFormat.format(cal.getTime());
		  }	
			
		
	//Generate random number
		public int GenerateRandomNumber()
		  {
			  Random randomGenerator = new Random();
			  int randomInt = randomGenerator.nextInt(10000);
			  //System.out.println(randomInt);
			  return randomInt;
			     
		  }

	
	// to check whether value fall in between ranges
		  
		public boolean IsValueInRange(double x, double startrange, double endrange)
		  {
			  boolean b=false;
			  if(x>=startrange && x<=endrange)
			  {
				  b= true; 
			  }
			  
			  return b;
			  
		  }
	
		
	   // Replace trailing .00 with space e.g $10,000.00 will return $10,000
		public String ReplaceTrailingZeros(String text)
		{
			return text.replaceAll("\\.0*$", "");
		}
		
		// Remove % from a string  
	 	public String removePercent(String input)
	 	{
	 		String s = input.replaceAll("[%,]", "");
	 		return s;
	 	}
	 	
	 // Concatenate the two strings
	 	  public String concatenateString(String text1, String text2)
	 	  {
	 	   return (text1+text2);
	 	  }
	 	    
	 	    // Check whether one string is present in another.
	 	    public boolean contentContains(String text1, String text2)
	 	    {
	 	            return text1.contains(text2);
	 	    }
}
