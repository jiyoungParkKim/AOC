package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

/**
 * This class is registered in the ME implementation as a observer to execute the {@link MEObserver#measureChanged()} method after 
 * change of the ME implementation's bar value.  
 * @author Jiyoung Park
 */
public class MeasureChangedCmd implements Command {
	private MEObserver ctl;
	public MeasureChangedCmd(MEObserver ctl) {
		this.ctl = ctl;
	}

	@Override
	public void execute() {
		ctl.measureChanged();
	}

}
