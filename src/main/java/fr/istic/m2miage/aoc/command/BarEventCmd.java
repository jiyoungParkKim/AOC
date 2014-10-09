package fr.istic.m2miage.aoc.command;

import fr.istic.m2miage.aoc.ctl.Controller;

public class BarEventCmd implements Command{

	private Controller ctl;
	public BarEventCmd(Controller ctl) {
		this.ctl = ctl;
	}
	
	public void execute() {
		ctl.barChanged();
	}
}
