package fr.istic.m2miage.aoc.me;

import fr.istic.m2miage.aoc.command.Command;

public class StopCommand implements Command {

	private Engine eg;
	public StopCommand(Engine eg){
		this.eg = eg;
	}
	public void execute() {
		
	}

}
