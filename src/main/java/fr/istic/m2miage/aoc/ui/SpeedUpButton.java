package fr.istic.m2miage.aoc.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fr.istic.m2miage.aoc.ctl.Controller;

public class SpeedUpButton extends javafx.scene.control.Button implements Button {

	private Controller ctl;

	public SpeedUpButton(Controller ctl){

		this.ctl = ctl;
		this.setText("INC");
		this.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ctl.incBar();
			}
		});
	}
	public void click() {
		ctl.incBar();
	}

}
