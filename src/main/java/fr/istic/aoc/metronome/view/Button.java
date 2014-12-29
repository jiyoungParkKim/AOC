package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.command.Command;


/**
 * This interface acts as a Invoker of the Command Pattern. 
 * @author Jiyoung Park
 *
 */
public interface Button {
	void click();
	Button setCommand(Command cmd);
}
