package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

/**
 * This class is registered in the ME implementation as a observer to execute the {@link MEObserver#bpmChanged()} method after 
 * change of the ME implementation's beats value.  
 * @author Jiyoung Park
 */
public class BpmChangedCmd implements Command {
	private MEObserver ctl;
	public BpmChangedCmd(MEObserver ctl) {
		this.ctl = ctl;
	}

	@Override
	public void execute() {
		ctl.bpmChanged();
	}
}
