package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.ME;

/**
 * Implementation of the Command interface to handle the BeatEvent.
 * @author Jiyoung Park
 *
 */
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
