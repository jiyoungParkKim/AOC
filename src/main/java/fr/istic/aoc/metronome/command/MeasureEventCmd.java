package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

public class MeasureEventCmd implements Command{
	private MEObserver ctl;
	public MeasureEventCmd(MEObserver ctl) {
		this.ctl = ctl;
	}

	@Override
	public void execute() {
		ctl.handleMeasureEvent();
	}

}
