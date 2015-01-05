package fr.istic.aoc.metronome.ui;

import fr.istic.aoc.metronome.command.Command;

/**
 * Base intarface for the buttons
 * @author Jiyoung Park
 *
 */
public interface Button {
	void setCommand(Command cmd);
	void click();
}
