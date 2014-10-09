package fr.istic.m2miage.aoc.ui;

import fr.istic.m2miage.aoc.command.Command;

public interface Timer {
	void activatePeriodically(Command c, int delayInSeconds);
	void activateAfterDelay(Command c, int delayInSeconds);
	void disable(Command c);
}
