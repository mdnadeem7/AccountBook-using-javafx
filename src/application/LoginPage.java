package application;

import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.*;
import javax.swing.JOptionPane;


import java.sql.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
public class LoginPage extends Stage{

	//LOGIN PAGE
	public void loginPage(Stage primaryStage) 
	{
		/*Image image = null;
		try {
			image = new Image(new FileInputStream("C:\\Users\\mdnad\\Pictures\\Saved Pictures\\pic12.jpg"));
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		 ImageView imageView = new ImageView(image);
		 imageView.setFitHeight(455); 
	      imageView.setFitWidth(500); 
	      
	      //Setting the preserve ratio of the image view 
	      imageView.setPreserveRatio(true);  
	      
	      //Setting the position of the image 
	      imageView.setX(50); 
	      imageView.setY(25); */
		//Button
		 Button registerButton = new Button("REGISTER");
		 registerButton.setLayoutX(720);
		 registerButton.setLayoutY(650);
		 registerButton.setPrefSize(120, 40);
		 registerButton.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent t) {
		            registerPage(primaryStage);
		        }//end action
		    });
		 //BUTTON LOGINBUTTON
		 Button loginButton = new Button("LOGIN");
		 loginButton.setLayoutX(720);
		 loginButton.setLayoutY(500);
		 loginButton.setPrefSize(120, 40);
		//USERID
		 final TextField userid = new TextField();  
		 userid.setPrefSize(250, 40);
		 userid.setLayoutX(660);
		 userid.setPromptText("ENTER MAIL");
		 userid.setLayoutY(340);
		 //PASSWORD
		 final PasswordField password = new PasswordField();
		 password.setPromptText("password");
		 password.setPrefSize(250, 40);
		 password.setLayoutX(660);
		 password.setLayoutY(400);
		 loginButton.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent t) {
		        	/////////////////////////////action Needeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeddddddddddddddddddddddddddddddddd
		        	String userid1= userid.getText();
		    		String pass = password.getText();
		    		boolean status=false;
		    		try{  
		    		 	 
		    		Class.forName("com.mysql.jdbc.Driver");  
		    		Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/account_book?characterEncoding=latin1","root","root");       
		    		String que = "select * from login";
			        ResultSet rs = con.createStatement().executeQuery(que);
			     
			         
		    		while(rs.next())
		    		{
		    			String tempo2 =  (String)rs.getString(3);
		    			String tempo1 = (String)rs.getString(1);
		    			boolean status1 = tempo1.equals(userid1) ;
		    			boolean status2 = tempo2.equals(pass);
		    			status = status1 && status2;
		    			if(status == true)
		    			{
		    				break;
		    			}
		    		}
		    		          
		    		}catch(Exception e){System.out.println(e);} 
		    		
		    		
		    		if(status==true)
		    		{
		    			
		    			JOptionPane.showMessageDialog(null,"Succesfull LOGIN");
		    			User regUser = new User();   
				        regUser.userCustomizeLogin(userid1,pass,primaryStage);
				       
		    			closeMe();
		    			
		    			
		    		}
		    		else {
		    			JOptionPane.showMessageDialog(null, "INVALID DETAILS");
		    			
		    		}
		    		}
		        }
		        		
		        //end action
		    );
		 
		
		 //rectangle
		 Rectangle rect = new Rectangle(580,200,400,400);
         rect.setStrokeWidth(30);
         rect.setArcHeight(50);
         rect.setArcWidth(50);
         rect.setFill(Color.DARKGOLDENROD);
         //line
         Line line1 = new Line(580,280,980,280);
         line1.setStrokeWidth(3);
         //text
         Text txt = new Text();
         txt.setText("LOGIN");
         txt.setX(710);
         txt.setY(260);
         txt.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,40)); 
         txt.setFill(Color.RED);
         txt.setStroke(Color.BLACK);
         //text name 
         Text txt1 = new Text();
         txt1.setText("AccountBook");
         txt1.setX(620);
         txt1.setY(100);
         txt1.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,50)); 
         txt1.setFill(Color.BLACK);
         txt1.setStroke(Color.BLACK);
        //layout  
		 Group root = new Group();
		 root.getChildren().addAll(rect,line1,txt,txt1,registerButton,loginButton);
		 root.getChildren().addAll(userid,password);
		 //scene
		 //Scene scene1  = new Scene(root,1500,790,Color.DEEPSKYBLUE);
		 this.setScene(new Scene(root,1500,790,Color.DEEPSKYBLUE));
		 this.setTitle("ACCOUNTBOOK");
		 this.show();
		 
	}
	
	//CLOSE WINDOW FUNCTION
	void  closeMe()
	{
		 this.close();
	 }
	
	//REGISTER PAGE
	public void registerPage(Stage primaryStage)
	{
		 //Button
		 Button loginButton = new Button("LOGIN");
		 loginButton.setLayoutX(720);
		 loginButton.setLayoutY(650);
		 loginButton.setPrefSize(120, 40);
		 
		 loginButton.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent t) {
		            loginPage(primaryStage);
		        }//end action
		    }); 
		 //textfield
		 final TextField name = new TextField();  
		 name.setPromptText("NAME");
		 name.setPrefSize(250, 40);
		 name.setLayoutX(660);
		 name.setLayoutY(340);
		 //password field
		 final PasswordField password = new PasswordField();
		 password.setPromptText("password");
		 password.setPrefSize(250, 40);
		 password.setLayoutX(660);
		 password.setLayoutY(460);
		 //EMAIL FEILD
		 final TextField email = new TextField();  
		 email.setPromptText("ENTER EMAIL");
		 email.setPrefSize(250, 40);
		 email.setLayoutX(660);
		 email.setLayoutY(400); 
		 //register Button
		 Button registerButton = new Button("REGISTER");
		 registerButton.setLayoutX(720);
		 registerButton.setLayoutY(550);
		 registerButton.setPrefSize(120, 40);
		 registerButton.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent t) {
		        	
		        	 String name1 =name.getText();
		        	 String password1 =password.getText();
		        	 String email1 = email.getText();
		        	
			    		boolean status = false;  
			    		try{  
			    		Class.forName("com.mysql.jdbc.Driver");  
			    		Connection con=DriverManager.getConnection(  
			    				"jdbc:mysql://localhost:3306/account_book?characterEncoding=latin1","root","root");  
			    		      
		               
			    		String que = "select * from login ";
				         ResultSet rs = con.createStatement().executeQuery(que);
			            rs.first();
			    		while(rs.next())
			    		{
			    			String tempo1 = (String)rs.getString(1);
			    			boolean status1 = tempo1.equals(email1) ;
			    			status = status1;
			    			if(status == true )
			    			{
			    				break;
			    			}
			    		}
			    		          
			    		}catch(Exception e){System.out.println(e);}   
			    		if(status==true)
			    		{
			    			JOptionPane.showMessageDialog(null, "USER ALREADY EXIST");
			    			
			    		}
			    		else {
			    			JOptionPane.showMessageDialog(null, "Succesfull");
			    			User regUser = new User();   
					        regUser.userCustomizeRegister(email1, name1, password1,primaryStage);
					        closeMe();
			    			}
		        	 }//end of action
		    });
		 //rectangle
		 Rectangle rect = new Rectangle(580,200,400,400);
        rect.setStrokeWidth(30);
        rect.setArcHeight(50);
        rect.setArcWidth(50);
        //line
        Line line1 = new Line(580,280,980,280);
        rect.setFill(Color.BLUEVIOLET);
        line1.setStrokeWidth(3);
        //text
        Text txt = new Text();
        txt.setText("REGISTER");
        txt.setX(690);
        txt.setY(260);
        txt.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,40)); 
        txt.setFill(Color.RED);
        txt.setStroke(Color.BLACK);
        //text name 
        Text txt1 = new Text();
        txt1.setText("AccountBook");
        txt1.setX(650);
        txt1.setY(100);
        txt1.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,40)); 
        txt1.setFill(Color.BLACK);
        txt1.setStroke(Color.BLACK);
       //layout  
		 Group root = new Group();
		 root.getChildren().addAll(rect,line1,txt,txt1,loginButton,name,email,password,registerButton);
		 //scene
		 //Scene scene1  = new Scene(root,1500,790,Color.DEEPSKYBLUE);
		 this.setScene(new Scene(root,1500,790,Color.DEEPSKYBLUE));
		 this.show();
		 
	}
}
