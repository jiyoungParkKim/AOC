package fr.istic.m2miage.aoc.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fr.istic.m2miage.aoc.ctl.Controller;

public class SpeedDownButton extends javafx.scene.control.Button implements Button  {


	private Controller ctl;

	public SpeedDownButton(Controller ctl){

		this.ctl = ctl;
		this.setText("DEC");
		this.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ctl.decBar();
			}
		});
	}
	public void click() {
		ctl.decBar();
	}
}
