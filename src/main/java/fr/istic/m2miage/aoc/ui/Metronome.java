package fr.istic.m2miage.aoc.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import fr.istic.m2miage.aoc.ctl.Controller;

public class Metronome extends Application{
	private Controller ctl = new Controller();
	
	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("metronome Park-Pereira");

		ctl.moveSlider(0.2);
		ctl.setBar(4);
		
		javafx.scene.control.Button startBtn = (javafx.scene.control.Button)ctl.getView().getStartBtn();
		javafx.scene.control.Button stopBtn = (javafx.scene.control.Button)ctl.getView().getStopBtn();
		javafx.scene.control.Button incBtn = (javafx.scene.control.Button)ctl.getView().getSpeedDown();
		javafx.scene.control.Button decBtn = (javafx.scene.control.Button)ctl.getView().getSpeedUp();
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.add(startBtn, 0,2);
		root.add(stopBtn, 1, 2);
		root.add(incBtn, 2,2);
		root.add(decBtn, 3, 2);
		
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
		
		
	}

}
