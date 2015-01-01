package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;
/**
 * Implementation of the Command interface for decreasing the BPM
 * @author Jiyoung Park
 *
 */
public class SpeedDownCmd extends AbstractObserverCmd{
	public SpeedDownCmd(MEObserver ctl) {
		super(ctl);
	}

	@Override
	public void execute() {
		ctl.speedDown();
	}


}
