package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	
	public void start(Stage primaryStage)  throws Exception{
		
		   LoginPage loginPage = new LoginPage();
		   loginPage.loginPage(primaryStage);
	
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
