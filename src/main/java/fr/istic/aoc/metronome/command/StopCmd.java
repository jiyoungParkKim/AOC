package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;
/**
 * Implementation of the Command interface for stopping the Metronome
 * @author Jiyoung Park
 *
 */
public class StopCmd  extends AbstractObserverCmd{

	public StopCmd(MEObserver ctl) {
		super(ctl);
	}

	@Override
	public void execute() {
		ctl.stop();
	}

}
