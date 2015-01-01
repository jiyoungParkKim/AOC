package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.command.Command;


/**
 * Button interface
 * @author Jiyoung Park
 *
 */
public interface Button {
	void click();
	Button setCommand(Command cmd);
}
