package fr.istic.m2miage.aoc.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fr.istic.m2miage.aoc.ctl.Controller;

public class StartButton extends javafx.scene.control.Button implements Button{
	private Controller ctl;
	
	public StartButton(Controller ctl){
		
		this.ctl = ctl;
		this.setText("Start");
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Hello world");
				ctl.start();
			}
		});
	}
	public void click() {
		ctl.start();
	}

}
