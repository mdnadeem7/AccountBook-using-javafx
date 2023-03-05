package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class BlogPage {

	void createScene(Stage stage1,String email) throws IOException
	{   
	    //rectangle
		 Rectangle rect = new Rectangle(0,0,250,800);
        rect.setFill(Color.BLUEVIOLET); 
		 
        //line
        Line line1 = new Line(650,370,1050,370);
        line1.setStrokeWidth(3); //TEXT WELCOME
        
        User blogtxt = new User();
        String string = blogtxt.blog();
        Text blogText = new Text();
        blogText.setText(string);
        blogText.setX(260);
        blogText.setY(40);
        blogText.setFont(Font.font(null,FontWeight.NORMAL,FontPosture.ITALIC,20)); 
        blogText.setFill(Color.BLACK);
        blogText.computeAreaInScreen();
      

		
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
        Button takeMoney = new Button("MONEY TO GET");
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
		         ///////////////////////////////////////////////////////	blog1(email);
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
        
       Group rootHome = new Group();
		rootHome.getChildren().addAll(rect,giveMoney,takeMoney,stats,blog,txt1,home,blogText,logout);
	    Scene scene = new Scene(rootHome,1500,790,Color.LIGHTSKYBLUE);
	    stage1.setScene(scene);
	    stage1.show();
	}
}
