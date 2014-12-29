package fr.istic.aoc.metronome.material;

import fr.istic.aoc.metronome.command.Command;

public interface Timer {
	void activatePeriodically(Command c, int delayInSeconds);
	void activateAfterDelay(Command c, int delayInSeconds);
	void disable(Command c);
}
