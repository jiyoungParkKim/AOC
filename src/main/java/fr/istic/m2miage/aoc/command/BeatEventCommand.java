package fr.istic.m2miage.aoc.command;

import fr.istic.m2miage.aoc.ctl.Controller;

public class BeatEventCommand  implements Command {
	private Controller ctl;
	public BeatEventCommand(Controller ctl) {
		this.ctl = ctl;
	}

	public void execute() {
		ctl.handleBeatEvent();
	}
	
}
