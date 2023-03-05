package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.stage.Stage;

public class User {

	static final String DB_URL = "jdbc:mysql://localhost:3306/account_book?characterEncoding=latin1";
	 static  final String USER = "root";
	 static   final String PASS = "root"; 
	 
	 
	 //user Customised page LOGIN
	 public void userCustomizeLogin(String email,String password ,Stage primaryStage)
	 {
		 HomePage homePage = new HomePage();
		
		 int k = 0;
		    for(int i = 0 ; i < email.length(); i ++)
		    {
		    	if(email.charAt(i) == '@')
		    	{
		    		break;
		    	}
		    	else
		    	{
		    		k++;
		    	}
		    }
		    String passemail = (String) email.subSequence(0, k);
		   
		    homePage.homePage(primaryStage,passemail);
		
		 
	 }
	 
	 
	 
	 
	 
	//user Customised page REGISTER
		 public void userCustomizeRegister(String email,String userName , String password,Stage primaryStage)
		 {
			 HomePage homePage = new HomePage();
			 int k = 0;
			    for(int i = 0 ; i < email.length(); i ++)
			    {
			    	if(email.charAt(i) == '@')
			    	{
			    		break;
			    	}
			    	else
			    	{
			    		k++;
			    	}
			    }
			    String passemail = (String) email.subSequence(0, k);
			   
			    homePage.homePage(primaryStage,passemail);
			 addUser(email,userName,password);
		 }
		 
		 
		 
		 
		 //blog
		 public String blog()
		 {
			 String blog = " Small Business Survival \n\n\n"+ 
		 "Starting and growing a business requires a mix of guts, inspiration, dedication and know-how. As providers of bookkeeping services \nfor small businesses up to $25 million,"
		+ "we have the privilege of seeing firsthand how many of our clients have mastered this formula to drive \ntheir businesses to success."
		 +"We're proud to supply our clients with all the knowledge and support they need to master financial management \nbut we recognize that there are additional resources out there that help provide additional education on other areas of business development.\n "
         +"such, in addition to our own blog for accounting and bookkeeping information, we've rounded up some of "
		 +"our personal favorites \n in the small business blogosphere to help small businesses find the information they're looking for,"
         +"no matter what the topic of expertise."+"\n \n \n" + "FOR MORE DETAILS VISIT LINK: https://www.accountingdepartment.com/blog/9-top-small-business-blogs-for-entrepreneurs ";
			 return blog;
		
		 }
		 
		 
		 
	 
	 //add User 
	 private void addUser(String email,String userName , String password)
	  {
	    try
	    {
	      // create a mysql database connection
	     
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account_book?characterEncoding=latin1","root","root");
	    
	      // the mysql insert statement
	      String query = " insert into login (email, userName, password)"
	        + " values(?, ?, ?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, email);
	      preparedStmt.setString (2, userName);
	      preparedStmt.setString(3, password);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	  
	    int k = 0;
	    for(int i = 0 ; i < email.length(); i ++)
	    {
	    	if(email.charAt(i) == '@')
	    	{
	    		break;
	    	}
	    	else
	    	{
	    		k++;
	    	}
	    }
	     String passTableName = (String) email.subSequence(0, k);
	    registerUserTable((passTableName));
	
	  }
	 
	 
	 
	 
	 //add table when registered
	 public void registerUserTable(String nameTable)
	 {
		  String tableName = " CREATE TABLE " + nameTable +  " " ; 
		 try{  
	    		Class.forName("com.mysql.jdbc.Driver");  
	    		Connection con=DriverManager.getConnection(  
	    		"jdbc:mysql://localhost:3306/account_book?characterEncoding=latin1","root","root"); 
	    				Statement stmt=con.createStatement();
	    	    		String sql = tableName +
	    	                    "( number INT  AUTO_INCREMENT, "
	    	                    + "name VARCHAR(50), " +  
	    	                    " phoneNo VARCHAR(10), " + 
	    	                    " amount DOUBLE, " + 
	    	                    " Comment LONGTEXT, " + 
	    	                    " type INT, " +
	    	                    " DEADLINE DATE, " +
	    	                    " PRIMARY KEY ( number ))"; 
	    	    		stmt.executeUpdate(sql);
	    	    	    System.out.println("Created table in given database for user "); 
	    		}catch(Exception e){ System.out.println(e);}
		
	 }
	
	 
}

