package fr.istic.aoc.metronome.material;

import fr.istic.aoc.metronome.command.Command;

public interface Horloge {
	void activatePeriodically(Command c, int delayInMilliSeconds);
	void activateAfterDelay(Command c, int delayInMilliSeconds);
	void disable(Command c);
}
