package fr.istic.m2miage.aoc.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fr.istic.m2miage.aoc.ctl.Controller;

public class StopButton extends javafx.scene.control.Button implements Button {
	private Controller ctl;
	public StopButton(Controller ctl){
		this.ctl = ctl;
		this.setText("Stop");
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				ctl.stop();
			}
		});
	}
	public void click() {
		ctl.stop();
	}

}
