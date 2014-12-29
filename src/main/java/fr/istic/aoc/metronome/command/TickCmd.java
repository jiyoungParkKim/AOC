package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.ME;

public class TickCmd implements Command{
	
	private ME me;
	public TickCmd(ME me) {
		this.me = me;
	}			

	@Override
	public void execute() {
		me.tick();
	}
}
