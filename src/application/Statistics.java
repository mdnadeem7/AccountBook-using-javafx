package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Statistics {

	
	int max=0,difference;
	float togive = 0,toget = 0;
	
	
	
	void createScene(Stage stage1,String email) throws IOException
	{   
		
		Label lable = new Label("MY STATISTICS: ");
		lable.setLayoutX(260);
	    lable.setLayoutY(20);
	    lable.setFont(Font.font(null, FontWeight.BOLD, 20));
	    //rectangle
		 Rectangle rect = new Rectangle(0,0,250,800);
        rect.setFill(Color.BLUEVIOLET); 
		 
        //line
        Line line1 = new Line(650,370,1050,370);
        line1.setStrokeWidth(3); //TEXT WELCOME
		
		 //BUTTON HOME
        Button home= new Button("HOME");
        home.setPrefSize(150, 60);
        home.setLayoutX(50);
        home.setLayoutY(60);
        home.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent t) {
		        	HomePage home = new HomePage();
		        	home.homePage(stage1, email);
		        }}
);
		 //BUTTON SHOW MONEY TO GIVE
        Button giveMoney = new Button("MONEY TO GIVE");
        giveMoney.setPrefSize(150, 60);
        giveMoney.setLayoutX(50);
        giveMoney.setLayoutY(150);
        giveMoney.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent t) {
		        	GiveMoneyPage give = new GiveMoneyPage();
		        	try {
					give.createTable(stage1, email);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        }}
);
        //BUTTON SHOW MONEY TO GET
        Button takeMoney = new Button("MONEY TO RECEIVE");
        takeMoney.setPrefSize(150, 60);
        takeMoney.setLayoutX(50);
        takeMoney.setLayoutY(250);
        takeMoney.setOnAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent t) {
	        	GetMoneyPage get = new GetMoneyPage();
	        	try {
					get.createScene(stage1, email);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }}
);
        
        //BUTTON STATISTICS
        Button stats= new Button("MY STATISTICS");
        stats.setPrefSize(150, 60);
        stats.setLayoutX(50);
        stats.setLayoutY(350);
        stats.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent t) {
		        	//////////////////////////////////////////////////////////////stats1(email);
		        }}
);
       //BUTTON BLOG
        Button blog= new Button("BLOGS");
        blog.setPrefSize(150, 60);
        blog.setLayoutX(50);
        blog.setLayoutY(450);
        blog.setOnAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent t) {
	        	BlogPage blog1 = new BlogPage();
	        	try {
					blog1.createScene(stage1, email);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }}
);
        //menu text
        Text txt1 = new Text();
        txt1.setText("MENU");
        txt1.setX(70);
        txt1.setY(40);
        txt1.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,30)); 
        txt1.setFill(Color.BLACK);
        txt1.setStroke(Color.BLACK);
        //BUTTONNN LOGOUT
        Button logout = new Button("LOGOUT");
        logout.setPrefSize(120, 60);
        logout.setLayoutX(60);
        logout.setLayoutY(600);
        logout.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent t) {
		        	LoginPage log = new LoginPage();
		        	log.loginPage(stage1);
		        	stage1.close();
		        }}
);
        
        
        ///getting data from mysql
         data(email);
		 
		 
		 ///////////GRAPH DESIGN
		max = (int) (togive+toget);
		CategoryAxis xaxis= new CategoryAxis(); 
		NumberAxis yaxis = new NumberAxis("Amount",0,max,100);
		xaxis.setLabel("TYPE");
		yaxis.setLabel("AMOUNT");
		
		BarChart<String,Float> bar = new BarChart(xaxis,yaxis);
		
		XYChart.Series<String,Float> series = new XYChart.Series<>(); 
		
		series.getData().add(new XYChart.Data<String,Float>("TO GIVE", togive));
		
		series.getData().add(new XYChart.Data<String,Float>("TO RECEIVE", toget ));
		bar.getData().add(series);
		bar.setPrefSize(600, 600);
		bar.setCategoryGap(100);
		bar.setTitle("Graph showing DATA OF MONEY TO GIVE AND MONEY TO RECEIVE");
		bar.setLayoutX(500);
		bar.setLayoutY(200);
	  
		///data lable
		 Text txtgive = new Text();
	        txtgive.setText("TOTAL AMOUNT TO GIVE :- "+togive);
	        txtgive.setX(300);
	        txtgive.setY(80);
	        txtgive.setFont(Font.font(null,FontWeight.NORMAL,20)); 
	        txtgive.setFill(Color.BLACK);
	        txtgive.setStroke(Color.BLACK);
	        Text txttake = new Text("TOTAL AMOUNT TO RECEIVE :- "+toget);
	        txttake.setX(300);
	        txttake.setY(130);
	        txttake.setFont(Font.font(null,FontWeight.NORMAL,20)); 
	        txttake.setFill(Color.BLACK);
	        txttake.setStroke(Color.BLACK);
        
        
        Group rootHome = new Group();
		rootHome.getChildren().addAll(lable,rect,giveMoney,takeMoney,stats,blog,txt1,home,logout,bar,txttake,txtgive);
	    Scene scene = new Scene(rootHome,1500,790,Color.LIGHTSKYBLUE);
	    stage1.setScene(scene);
	    stage1.show();
	}
	
	public void data(String email)
	{
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account_book?characterEncoding=latin1","root","root");
			 String que = "select * from " + email + " ";
	         ResultSet rs = conn.createStatement().executeQuery(que);
	         while(rs.next())
	         {
	        	 if(rs.getInt("type") == 1) {
	        	togive =   (float) (togive+ (rs.getDouble("amount")));}
	        	 else if(rs.getInt("type") == 0)
	        	{toget = (float) (toget+ (rs.getDouble("amount")));}
	        	 
	         }
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		 
		 
	}
}