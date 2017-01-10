package fitnesse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {
	
	   //To get the DB data
		public String getDBData(String Env,String sqlQuery,int column)
		{
			String queryresult="";
			String dbUrl="";
			String	db_username="";
			String	db_password="";
			if(Env.equalsIgnoreCase("PROD"))
			{
				dbUrl="jdbc:mysql://investordbinstance.cfgncecsykm0.us-west-2.rds.amazonaws.com:3306/";
				db_username="hudbreaduser";
				db_password="hudbreadpwd";
			}	
			else if(Env.equalsIgnoreCase("STG"))
			{
				dbUrl="jdbc:mysql://staginghomeunion.cfgncecsykm0.us-west-2.rds.amazonaws.com:3306/";
				db_username="report_admin";
				db_password="report_pwd";
			}
			else if(Env.equalsIgnoreCase("INTEG"))
			{
				dbUrl="jdbc:mysql://192.168.10.12:3306";
				db_username="invappuser";
				db_password="invapppwd";
			}
			
			 Connection con;  	
			try{
		  	       Class.forName("com.mysql.jdbc.Driver"); 
		   	     //Create Connection to DB        
		  		 con = DriverManager.getConnection(dbUrl,db_username,db_password);
		          //Create Statement Object       
		         Statement stmt = con.createStatement();                   
		    	 try{  
		  	    	  ResultSet rs= stmt.executeQuery(sqlQuery); 
		  		      rs.next();
		  		      queryresult=rs.getString(column);
		  	          rs.close();
		  	    }
	           catch (NullPointerException | NumberFormatException e) {} 
	           // closing DB Connection       
	        con.close();
	        stmt.close();
	       } catch (ClassNotFoundException | SQLException e) {}         
			
			return queryresult;
		}
		
}
