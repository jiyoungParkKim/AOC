package fr.istic.m2miage.aoc.command;

import fr.istic.m2miage.aoc.me.Engine;

public class TickCommand implements Command{
	private Engine eg;
	public TickCommand(Engine eg) {
		this.eg = eg;
	}
	public void execute() {
		eg.tick();
	}
}
