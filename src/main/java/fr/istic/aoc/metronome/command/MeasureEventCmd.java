package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

public class MeasureEventCmd extends AbstractObserverCmd{
	public MeasureEventCmd(MEObserver ctl) {
		super(ctl);
	}

	@Override
	public void execute() {
		ctl.handleMeasureEvent();
	}

}
