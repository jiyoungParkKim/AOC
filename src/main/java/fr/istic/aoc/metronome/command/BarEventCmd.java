package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

public class BarEventCmd extends AbstractObserverCmd{
	public BarEventCmd(MEObserver ctl) {
		super(ctl);
	}

	@Override
	public void execute() {
		ctl.handleBarEvent();
	}

}
