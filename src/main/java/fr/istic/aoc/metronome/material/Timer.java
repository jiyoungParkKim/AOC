package fr.istic.aoc.metronome.material;

import fr.istic.aoc.metronome.command.Command;

/**
 * Timer class to execute the given methods periodically.
 * @author Jiyoung Park
 *
 */
public interface Timer {
	void activatePeriodically(Command c, int delayInSeconds);
	void activateAfterDelay(Command c, int delayInSeconds);
	void disable(Command c);
}
