package fr.istic.m2miage.aoc.command;

import fr.istic.m2miage.aoc.ctl.Controller;

public class BeatChangedCommand implements Command{
	private Controller ctl;
	public BeatChangedCommand(Controller ctl){
		this.ctl = ctl;
	}
	public void execute() {
		
		ctl.beatChanged();
		
	}
}
