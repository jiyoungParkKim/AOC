package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.observer.MEObserver;

/**
 * Abstract command that is parameterized with the observer necessary to perform the target's method.
 * @author Jiyoung Park
 *
 */
public abstract class AbstractObserverCmd implements Command {
	protected MEObserver ctl;
	public AbstractObserverCmd(MEObserver ctl) {
		this.ctl = ctl;
	}

	@Override
	abstract public void execute();
}
