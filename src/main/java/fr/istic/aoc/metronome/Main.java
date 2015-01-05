package fr.istic.aoc.metronome;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
			Scene scene = new Scene(root, 266.0,206.0);
			
			primaryStage.setTitle("metronome Park-Pereira");
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
