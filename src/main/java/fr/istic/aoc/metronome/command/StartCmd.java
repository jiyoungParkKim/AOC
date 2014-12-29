package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

public class StartCmd extends AbstractObserverCmd {

	public StartCmd(MEObserver ctl) {
		super(ctl);
	}

	@Override
	public void execute() {
		ctl.start();
	}

}
