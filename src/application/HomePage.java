package application;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class HomePage extends Stage
{
	public void homePage(Stage primaryStage,final String email)
	{
		  
		 //rectangle
		 Rectangle rect = new Rectangle(0,0,250,800);
         rect.setFill(Color.BLUEVIOLET); 
         //rectangle 
		 Rectangle rectAdd = new Rectangle(650,250,400,480);
         rectAdd.setStrokeWidth(30);
         rectAdd.setArcHeight(50);
         rectAdd.setArcWidth(50);
         rectAdd.setFill(Color.WHITE);
         //line
         Line line1 = new Line(650,320,1050,320);
         line1.setStrokeWidth(3);
         //TEXT ADD NEW CUSTOMER
         Text txt = new Text();
         txt.setText("ADD NEW CUSTOMER");
         txt.setX(695);
         txt.setY(310);
         txt.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,30)); 
         txt.setFill(Color.RED);
         txt.setStroke(Color.BLACK);
         //CUSTOMER NAME
         final TextField customerName = new TextField();  
         customerName.setPromptText("NAME");
		 customerName.setPrefSize(280, 40);
		 customerName.setLayoutX(690);
		 customerName.setLayoutY(350);
		 //CUSTOMER PHONE NUMBER
		 final TextField phno = new TextField();  
		 phno.setPromptText("PHONE NUMBER");
		 phno.setPrefSize(280, 40);
		 phno.setLayoutX(690);
		 phno.setLayoutY(400);
		 //amount
		 final TextField amount = new TextField();  
		 amount.setPromptText("AMOUNT");
		 amount.setPrefSize(280, 40);
		 amount.setLayoutX(690);
		 amount.setLayoutY(450);
		 //COMMENT FEILD
		 final TextField cmt = new TextField();  
		 cmt.setPromptText("comments");
		 cmt.setPrefSize(280, 40);
		 cmt.setLayoutX(690);
		 cmt.setLayoutY(500);
		 //type 
		 final TextField type= new TextField();  
		 type.setPromptText("TYPE('1' FOR GIVE , '0' FOR RECEIVE )");
		 type.setPrefSize(280, 40);
		 type.setLayoutX(690);
		 type.setLayoutY(550);
		 
		 final TextField days = new TextField();
		 days.setPromptText("Set NO OF DAYS OF RETUN OR TO GIVE");
		 days.setPrefSize(280, 40);
		 days.setLayoutX(690);
		 days.setLayoutY(600);
		 // Button ADD CUSTOMER
		 Button addCust = new Button("Add");
		 addCust.setPrefSize(100, 40);
		 addCust.setLayoutX(780);
		 addCust.setLayoutY(650);
		 addCust.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent t) {
		        	String name1,phno1,cmt1;
		        	Double amount1 ;
		        	int type1,days1;
		        	days1 = Integer.parseInt(days.getText());
		        	LocalDate localDate = LocalDate.now();
		        	Date giveTake = Date.valueOf(localDate.plusDays(days1));
		        	name1 = customerName.getText();
		        	phno1 = phno.getText();
		        	amount1 = Double.parseDouble(amount.getText());
		        	cmt1 = cmt.getText();
		        	type1 = Integer.parseInt(type.getText());
		        	 if(type1== 0 || type1 == 1 ) 
		        	 {
		        	Customer addCus = new Customer();
		        	addCus.addMe(name1,phno1,amount1,cmt1,type1,giveTake,email);
		        	JOptionPane.showMessageDialog(null,"CUSTOMER ADDED SUCCESFULLY");}	
		        	 else
		        	 {
		        		 JOptionPane.showMessageDialog(null,"TYPE: ONLY ACCEPTS 0 OR 1: WHERE 1 = GIVE AND 0 = TAKE : ");
		        	 }
		        }
		        }
);
		 
		 //TEXT WELCOME
		 String welcomeString = "WELCOME " + email;
		 Text welcome= new Text(welcomeString);  
		 welcome.setFont(Font.font("Helvetica",FontWeight.BOLD,FontPosture.ITALIC,40)); 
         welcome.setFill(Color.BLACK);
         welcome.setStroke(Color.BLACK);
         welcome.setLayoutX(660);
         welcome.setLayoutY(150);
		 //BUTTON HOME
         Button home= new Button("HOME");
         home.setPrefSize(150, 60);
         home.setLayoutX(50);
         home.setLayoutY(60);
		 //BUTTON SHOW MONEY TO GIVE
         Button giveMoney = new Button("MONEY TO GIVE");
         giveMoney.setPrefSize(150, 60);
         giveMoney.setLayoutX(50);
         giveMoney.setLayoutY(150);
         
                  giveMoney.setOnAction(new EventHandler<ActionEvent>() {
       		        public void handle(ActionEvent t) {
       		        	GiveMoneyPage give = new GiveMoneyPage();
       		        	try {
							give.createTable(primaryStage, email);
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
 					get.createScene(primaryStage, email);
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
						stats1.createScene(primaryStage, email);
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
						blog1.createScene(primaryStage, email);
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
		        	log.loginPage(primaryStage);
		        	primaryStage.close();
		        }}
);
         
         
        Group rootHome = new Group();
		rootHome.getChildren().addAll(rect,rectAdd,line1,giveMoney,takeMoney,stats,blog,txt1,txt,amount,customerName,phno,cmt,home,addCust,type,welcome,days,logout);
		primaryStage.setScene(new Scene(rootHome,1500,790,Color.LIGHTSKYBLUE));
		primaryStage.show();
		primaryStage.setTitle("ACCOUNTBOOK");
	}
}
	
	
	