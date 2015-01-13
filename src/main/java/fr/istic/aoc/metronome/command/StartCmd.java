/**
 * 
 */
package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.Controller;

/**
 * @author Jiyoung Park
 *
 */
public class StartCmd implements Command {
	private Controller controller;
	public StartCmd(Controller controller) {
		this.controller = controller;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aoc.metronome.command.Command#execute()
	 */
	@Override
	public void execute() {
		controller.start();
	}

}
