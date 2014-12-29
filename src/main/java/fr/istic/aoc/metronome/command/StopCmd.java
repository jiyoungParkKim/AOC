package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

public class StopCmd  extends AbstractObserverCmd{

	public StopCmd(MEObserver ctl) {
		super(ctl);
	}

	@Override
	public void execute() {
		ctl.stop();
	}

}
