package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GiveMoneyPage  {

	
	void createTable(Stage stage1,String email) throws IOException
	{
		
		
	    //rectangle
		 Rectangle rect = new Rectangle(0,0,250,800);
        rect.setFill(Color.BLUEVIOLET); 
		 
        //line
        Line line1 = new Line(650,370,1050,370);
        line1.setStrokeWidth(3); //TEXT WELCOME
		
      //lable table
	    Label lable = new Label("Table Showing data of MONEY TO GIVE : ");
		lable.setLayoutX(260);
	    lable.setLayoutY(20);
	    lable.setFont(Font.font(null, FontWeight.BOLD, 20));
	    //lable Note
        Label lablenote = new Label("*** NOTE: THE TYPE '3' SHOWS THE MONEY GIVEN **** ");
		lablenote.setLayoutX(350);
	    lablenote.setLayoutY(55);
	    lablenote.setFont(Font.font(null, FontWeight.BOLD, 15));
	    lablenote.setTextFill(Color.RED);
	    
	    // MARK AS GIVEN/TAKEN
	     
		 //text
		 Text  textmark= new Text("           -> Enter the corresponding customer number to mark as GIVEN (eg : 2): ");
		 textmark.setX(350);
		 textmark.setY(100);
		 textmark.setFont(Font.font(null, FontWeight.NORMAL,FontPosture.REGULAR,15)); 
		 //textField
		 TextField changeRow = new TextField(); 
		 changeRow.setPrefSize(50, 20);
		 changeRow.setLayoutX(900);
		 changeRow.setLayoutY(80);
		 
	    
	  //BUTTON OK
        Button ok= new Button("OK");
        ok.setPrefSize(50, 20);
        ok.setLayoutX(985);
        ok.setLayoutY(80);
        ok.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent t) {
		        	Customer cust = new Customer();
		        	String no = changeRow.getText();
		        	cust.changeMe(email,no, "3");
		        	try {
						createTable(stage1, email);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }}
);
	    
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
	        	Statistics stats1 = new Statistics();
	        	try {
					stats1.createScene(stage1, email);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
        Text txt1 = new Text("MENU");
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
        //tableeeeeeeeeeeeee
        TableView<Datamysql> table = new TableView();

		TableColumn<Datamysql, Integer> no = new TableColumn("no");
		no.setCellValueFactory(new PropertyValueFactory<>("no"));
		

		TableColumn<Datamysql,String> name = new TableColumn("name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
	
		TableColumn<Datamysql,String> phno = new TableColumn("phno");
		phno.setCellValueFactory(new PropertyValueFactory<>("phno"));
		
		TableColumn<Datamysql,Double> amount= new TableColumn("amount");
		amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
		
		TableColumn<Datamysql,String> comment1 = new TableColumn("comment");
		comment1.setCellValueFactory(new PropertyValueFactory<>("comment"));
		
		TableColumn<Datamysql, Integer> type= new TableColumn("type");
		type.setCellValueFactory(new PropertyValueFactory<>("type"));
		
		TableColumn<Datamysql,Date> deadline = new TableColumn("DEADLINE");
		deadline.setCellValueFactory(new PropertyValueFactory<>("DEADLINE"));
		
		
		 ObservableList<Datamysql> obl = FXCollections.observableArrayList();
		
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account_book?characterEncoding=latin1","root","root");
		
	         String que = "select * from " + email + " ";
  	         ResultSet rs = conn.createStatement().executeQuery(que);
		 
	         while(rs.next())
	         {
	        	 if(rs.getInt(6)== 1 | rs.getInt(6) == 3)
	        	 {obl.add(new Datamysql(rs.getInt("number"),rs.getString("name"),rs.getString("phoneNo"),rs.getDouble("amount"),rs.getString("comment"),rs.getInt("type"),rs.getDate("DEADLINE")));
	         }}
		 		}catch(SQLException e)
		 						{
		 							System.out.println("EXCEPTION IN PRINTING TABLE"+ e);
		 																					} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
		 
			table.setItems(obl);
			table.setPrefSize(600, 600);
			table.getColumns().addAll(no,name,phno,amount,comment1,type,deadline);
	        table.setLayoutX(500);
	        table.setLayoutY(130);
	        
	      
		 
		
        Group rootHome = new Group();
		rootHome.getChildren().addAll(rect,giveMoney,takeMoney,stats,blog,txt1,home,lable,logout,table,textmark,changeRow,lablenote,ok);
	    Scene scene = new Scene(rootHome,1500,790,Color.LIGHTSKYBLUE);
	    stage1.setScene(scene);
	    stage1.show();
	}
}
