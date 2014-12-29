package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

/**
 * This class is registered in the ME implementation as a observer to execute the {@link MEObserver#beatsChanged()} method after 
 * change of the ME implementation's beats value.  
 * @author Jiyoung Park
 */
public class BeatsChangedCmd extends AbstractObserverCmd{
	public BeatsChangedCmd(MEObserver ctl) {
		super(ctl);
	}

	@Override
	public void execute() {
		ctl.beatsChanged();
	}
}
