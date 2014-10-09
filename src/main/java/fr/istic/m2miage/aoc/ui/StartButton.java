package fr.istic.m2miage.aoc.ui;

import fr.istic.m2miage.aoc.ctl.Controller;

public class StartButton implements Button {
	private Controller ctl;
	public StartButton(Controller ctl){
		this.ctl = ctl;
	}
	public void click() {
		ctl.start();
	}

}
