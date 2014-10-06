package fr.istic.m2miage.aoc.command;

import fr.istic.m2miage.aoc.ctl.Controller;

public class BeatCommand  implements Command {
	private Controller ctl;
	public BeatCommand(Controller ctl){
		this.ctl = ctl;
	}
	public void execute() {
		handleBeatEvent();
	}
	
	private void handleBeatEvent(){
		ctl.beat();
		ctl.clignote();
	}
}
