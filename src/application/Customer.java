package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.sql.Statement;

import javafx.stage.Stage;

public class Customer extends Stage {
	
	
	///ADD CUSTOMER
	public void addMe(String name, String phno, double amount , String comment , int type ,Date giveTake, String email)
	{
		 try
		    {
		      // create a mysql database connection
		     
		      Class.forName("com.mysql.jdbc.Driver");
		      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account_book?characterEncoding=latin1","root","root");
		      String query1 = "insert into " + email + " (name, phoneNo, amount,Comment , type , DEADLINE) ";
		      // the mysql insert statement
		      String query = query1
		        + " values(?, ?, ?,?,?,?)";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString(1, name);
		      preparedStmt.setString (2, phno);
		      preparedStmt.setDouble(3, amount);
		      preparedStmt.setString(4, comment);
		      preparedStmt.setInt(5, type);
		      preparedStmt.setDate(6, giveTake);

		      // execute the preparedstatement
		      preparedStmt.execute();
		      
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
	} 

  //change my type
   public void changeMe(String email, String  no,String  type )
   {
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account_book?characterEncoding=latin1","root","root");
		 Statement st = conn.createStatement();
			
		
			
			String sql = "update " + email + " set type = " + type + " where number = " + no; 
			
		    st.executeUpdate(sql);
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  
   }
}
  