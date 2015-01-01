package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

/**
 * Implementation of the Command interface for increasing the BPM
 * @author Jiyoung Park
 *
 */
public class SpeedUpCmd extends AbstractObserverCmd{

	public SpeedUpCmd(MEObserver ctl) {
		super(ctl);
	}

	@Override
	public void execute() {
		ctl.speedUp();
	}

}
