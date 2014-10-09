package fr.istic.m2miage.aoc.ui;

import fr.istic.m2miage.aoc.ctl.Controller;

public class StopButton implements Button {
	private Controller ctl;
	public StopButton(Controller ctl){
		this.ctl = ctl;
	}
	public void click() {
		ctl.stop();
	}

}
