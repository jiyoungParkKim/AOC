package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.Controller;

public class DecCmd implements Command {

	private Controller controller;
	public DecCmd(Controller controller) {
		this.controller = controller;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aoc.metronome.command.Command#execute()
	 */
	@Override
	public void execute() {
		controller.dec();
	}

}
