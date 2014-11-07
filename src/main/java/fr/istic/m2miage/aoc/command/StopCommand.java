package fr.istic.m2miage.aoc.command;

import fr.istic.m2miage.aoc.me.Engine;

public class StopCommand implements Command {

	private Engine eg;
	public StopCommand(Engine eg){
		this.eg = eg;
	}
	public void execute() {
		//eg.setRunning(false);
	}

}
