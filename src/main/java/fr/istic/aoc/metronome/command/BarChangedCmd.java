package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

/**
 * This class is registered in the ME implementation as a observer to execute the {@link MEObserver#barChanged()} method after 
 * change of the ME implementation's bar value.  
 * @author Jiyoung Park
 */
public class BarChangedCmd extends AbstractObserverCmd{
	public BarChangedCmd(MEObserver ctl) {
		super(ctl);
	}

	@Override
	public void execute() {
		ctl.barChanged();
	}

}
