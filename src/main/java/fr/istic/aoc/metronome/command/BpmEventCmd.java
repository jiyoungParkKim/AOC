package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

/**
 * This class is registered in the ME implementation as a observer to execute the {@link MEObserver#handleBpmEvent()} method after 
 * change of the ME implementation's beats value.  
 * @author Jiyoung Park
 */
public class BpmEventCmd implements Command{
	private MEObserver ctl;
	public BpmEventCmd(MEObserver controller) {
		this.ctl = controller;
	}

	@Override
	public void execute() {
		ctl.handleBpmEvent();
	}

}
