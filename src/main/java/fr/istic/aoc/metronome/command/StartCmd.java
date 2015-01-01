package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;
/**
 * Implementation of the Command interface for starting the Metronome
 * @author Jiyoung Park
 *
 */
public class StartCmd extends AbstractObserverCmd {

	public StartCmd(MEObserver ctl) {
		super(ctl);
	}

	@Override
	public void execute() {
		ctl.start();
	}

}
