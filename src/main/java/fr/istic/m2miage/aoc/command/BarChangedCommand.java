package fr.istic.m2miage.aoc.command;

import fr.istic.m2miage.aoc.ctl.Controller;


public class BarChangedCommand implements Command {
	private Controller ctl;
	public BarChangedCommand(Controller ctl){
		this.ctl = ctl;
	}
	public void execute() {
		ctl.barChanged();
	}

}
